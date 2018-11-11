package okhttp3.internal.http2;

import android.support.v4.internal.view.SupportMenu;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    private boolean awaitingPong;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests = new LinkedHashSet();
    final String hostname;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings = new Settings();
    final Settings peerSettings = new Settings();
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    boolean receivedInitialPeerSettings = false;
    boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    final Http2Writer writer;
    private final ScheduledExecutorService writerExecutor;

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean z) {
            this.client = z;
        }

        public Builder socket(Socket socket) {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }

        public Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public void onStream(Http2Stream http2Stream) {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream);
    }

    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", r4.hostname, Integer.valueOf(i), Integer.valueOf(i2));
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        public void execute() {
            Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Handler {
        final Http2Reader reader;

        public void ackSettings() {
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", r4.hostname);
            this.reader = http2Reader;
        }

        protected void execute() {
            Throwable th;
            ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            this.reader.readConnectionPreface(this);
            while (this.reader.nextFrame(false, this)) {
            }
            ErrorCode errorCode3 = ErrorCode.NO_ERROR;
            Http2Connection http2Connection;
            try {
                errorCode = ErrorCode.CANCEL;
                try {
                    http2Connection = Http2Connection.this;
                    http2Connection.close(errorCode3, errorCode);
                } catch (IOException unused) {
                    Util.closeQuietly(this.reader);
                }
            } catch (IOException unused2) {
                errorCode = errorCode3;
                try {
                } catch (IOException unused3) {
                    errorCode3 = ErrorCode.PROTOCOL_ERROR;
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                    http2Connection = Http2Connection.this;
                } catch (Throwable th2) {
                    ErrorCode errorCode4 = errorCode3;
                    th = th2;
                    errorCode = errorCode4;
                    Http2Connection.this.close(errorCode, errorCode2);
                }
            }
        }

        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushDataLater(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                bufferedSource.skip((long) i2);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z) {
                stream.receiveFin();
            }
        }

        /* JADX WARNING: Missing block: B:25:0x0071, code:
            r0.receiveHeaders(r13);
     */
        /* JADX WARNING: Missing block: B:26:0x0074, code:
            if (r10 == false) goto L_0x0079;
     */
        /* JADX WARNING: Missing block: B:27:0x0076, code:
            r0.receiveFin();
     */
        /* JADX WARNING: Missing block: B:28:0x0079, code:
            return;
     */
        public void headers(boolean r10, int r11, int r12, java.util.List<okhttp3.internal.http2.Header> r13) {
            /*
            r9 = this;
            r12 = okhttp3.internal.http2.Http2Connection.this;
            r12 = r12.pushedStream(r11);
            if (r12 == 0) goto L_0x000e;
        L_0x0008:
            r12 = okhttp3.internal.http2.Http2Connection.this;
            r12.pushHeadersLater(r11, r13, r10);
            return;
        L_0x000e:
            r12 = okhttp3.internal.http2.Http2Connection.this;
            monitor-enter(r12);
            r0 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r0 = r0.getStream(r11);	 Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0070;
        L_0x0019:
            r0 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r0 = r0.shutdown;	 Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0021;
        L_0x001f:
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            return;
        L_0x0021:
            r0 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r0 = r0.lastGoodStreamId;	 Catch:{ all -> 0x007a }
            if (r11 > r0) goto L_0x0029;
        L_0x0027:
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            return;
        L_0x0029:
            r0 = r11 % 2;
            r1 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r1 = r1.nextStreamId;	 Catch:{ all -> 0x007a }
            r2 = 2;
            r1 = r1 % r2;
            if (r0 != r1) goto L_0x0035;
        L_0x0033:
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            return;
        L_0x0035:
            r0 = new okhttp3.internal.http2.Http2Stream;	 Catch:{ all -> 0x007a }
            r5 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r6 = 0;
            r3 = r0;
            r4 = r11;
            r7 = r10;
            r8 = r13;
            r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ all -> 0x007a }
            r10 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r10.lastGoodStreamId = r11;	 Catch:{ all -> 0x007a }
            r10 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r10 = r10.streams;	 Catch:{ all -> 0x007a }
            r13 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x007a }
            r10.put(r13, r0);	 Catch:{ all -> 0x007a }
            r10 = okhttp3.internal.http2.Http2Connection.listenerExecutor;	 Catch:{ all -> 0x007a }
            r13 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$1;	 Catch:{ all -> 0x007a }
            r1 = "OkHttp %s stream %d";
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x007a }
            r3 = 0;
            r4 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r4 = r4.hostname;	 Catch:{ all -> 0x007a }
            r2[r3] = r4;	 Catch:{ all -> 0x007a }
            r3 = 1;
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x007a }
            r2[r3] = r11;	 Catch:{ all -> 0x007a }
            r13.<init>(r1, r2, r0);	 Catch:{ all -> 0x007a }
            r10.execute(r13);	 Catch:{ all -> 0x007a }
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            return;
        L_0x0070:
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            r0.receiveHeaders(r13);
            if (r10 == 0) goto L_0x0079;
        L_0x0076:
            r0.receiveFin();
        L_0x0079:
            return;
        L_0x007a:
            r10 = move-exception;
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            throw r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.headers(boolean, int, int, java.util.List):void");
        }

        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushResetLater(i, errorCode);
                return;
            }
            Http2Stream removeStream = Http2Connection.this.removeStream(i);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean z, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j;
            int i;
            synchronized (Http2Connection.this) {
                int initialWindowSize = Http2Connection.this.peerSettings.getInitialWindowSize();
                if (z) {
                    Http2Connection.this.peerSettings.clear();
                }
                Http2Connection.this.peerSettings.merge(settings);
                applyAndAckSettings(settings);
                int initialWindowSize2 = Http2Connection.this.peerSettings.getInitialWindowSize();
                http2StreamArr = null;
                if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                    j = 0;
                } else {
                    j = (long) (initialWindowSize2 - initialWindowSize);
                    if (!Http2Connection.this.receivedInitialPeerSettings) {
                        Http2Connection.this.addBytesToWriteWindow(j);
                        Http2Connection.this.receivedInitialPeerSettings = true;
                    }
                    if (!Http2Connection.this.streams.isEmpty()) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                    }
                }
                ExecutorService access$100 = Http2Connection.listenerExecutor;
                Object[] objArr = new Object[1];
                i = 0;
                objArr[0] = Http2Connection.this.hostname;
                access$100.execute(new NamedRunnable("OkHttp %s settings", objArr) {
                    public void execute() {
                        Http2Connection.this.listener.onSettings(Http2Connection.this);
                    }
                });
            }
            if (http2StreamArr != null && j != 0) {
                int length = http2StreamArr.length;
                while (i < length) {
                    Http2Stream http2Stream = http2StreamArr[i];
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(j);
                    }
                    i++;
                }
            }
        }

        private void applyAndAckSettings(final Settings settings) {
            try {
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.hostname}) {
                    public void execute() {
                        try {
                            Http2Connection.this.writer.applyAndAckSettings(settings);
                        } catch (IOException unused) {
                            Http2Connection.this.failConnection();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        public void ping(boolean z, int i, int i2) {
            if (z) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.awaitingPong = false;
                    Http2Connection.this.notifyAll();
                }
            } else {
                try {
                    Http2Connection.this.writerExecutor.execute(new PingRunnable(true, i, i2));
                } catch (RejectedExecutionException unused) {
                }
            }
        }

        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            byteString.size();
            synchronized (Http2Connection.this) {
                Http2Stream[] http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.bytesLeftInWriteWindow += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        public void pushPromise(int i, int i2, List<Header> list) {
            Http2Connection.this.pushRequestLater(i2, list);
        }
    }

    boolean pushedStream(int i) {
        return i != 0 && (i & 1) == 0;
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        this.pushObserver = builder2.pushObserver;
        this.client = builder2.client;
        this.listener = builder2.listener;
        this.nextStreamId = builder2.client ? 1 : 2;
        if (builder2.client) {
            this.nextStreamId += 2;
        }
        if (builder2.client) {
            this.okHttpSettings.set(7, 16777216);
        }
        this.hostname = builder2.hostname;
        this.writerExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", this.hostname), false));
        if (builder2.pingIntervalMillis != 0) {
            this.writerExecutor.scheduleAtFixedRate(new PingRunnable(false, 0, 0), (long) builder2.pingIntervalMillis, (long) builder2.pingIntervalMillis, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", this.hostname), true));
        this.peerSettings.set(7, SupportMenu.USER_MASK);
        this.peerSettings.set(5, 16384);
        this.bytesLeftInWriteWindow = (long) this.peerSettings.getInitialWindowSize();
        this.socket = builder2.socket;
        this.writer = new Http2Writer(builder2.sink, this.client);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder2.source, this.client));
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    synchronized Http2Stream getStream(int i) {
        return (Http2Stream) this.streams.get(Integer.valueOf(i));
    }

    synchronized Http2Stream removeStream(int i) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return http2Stream;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) {
        if (!this.client) {
            return newStream(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    public Http2Stream newStream(List<Header> list, boolean z) {
        return newStream(0, list, z);
    }

    private Http2Stream newStream(int i, List<Header> list, boolean z) {
        Http2Stream http2Stream;
        Object obj;
        boolean z2 = z ^ 1;
        synchronized (this.writer) {
            int i2;
            synchronized (this) {
                if (this.nextStreamId > 1073741823) {
                    shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (this.shutdown) {
                    throw new ConnectionShutdownException();
                }
                i2 = this.nextStreamId;
                this.nextStreamId += 2;
                http2Stream = new Http2Stream(i2, this, z2, false, list);
                obj = (!z || this.bytesLeftInWriteWindow == 0 || http2Stream.bytesLeftInWriteWindow == 0) ? 1 : null;
                if (http2Stream.isOpen()) {
                    this.streams.put(Integer.valueOf(i2), http2Stream);
                }
            }
            if (i == 0) {
                this.writer.synStream(z2, i2, i, list);
            } else if (this.client) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.writer.pushPromise(i, i2, list);
            }
        }
        if (obj != null) {
            this.writer.flush();
        }
        return http2Stream;
    }

    void writeSynReply(int i, boolean z, List<Header> list) {
        this.writer.synReply(z, i, list);
    }

    /* JADX WARNING: Missing block: B:17:?, code:
            r2 = java.lang.Math.min((int) java.lang.Math.min(r14, r10.bytesLeftInWriteWindow), r10.writer.maxDataLength());
            r6 = (long) r2;
            r10.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Missing block: B:29:0x0063, code:
            throw new java.io.InterruptedIOException();
     */
    public void writeData(int r11, boolean r12, okio.Buffer r13, long r14) {
        /*
        r10 = this;
        r0 = 0;
        r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        r3 = 0;
        if (r2 != 0) goto L_0x000d;
    L_0x0007:
        r14 = r10.writer;
        r14.data(r12, r11, r13, r3);
        return;
    L_0x000d:
        r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0066;
    L_0x0011:
        monitor-enter(r10);
    L_0x0012:
        r4 = r10.bytesLeftInWriteWindow;	 Catch:{ InterruptedException -> 0x005e }
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x0030;
    L_0x0018:
        r2 = r10.streams;	 Catch:{ InterruptedException -> 0x005e }
        r4 = java.lang.Integer.valueOf(r11);	 Catch:{ InterruptedException -> 0x005e }
        r2 = r2.containsKey(r4);	 Catch:{ InterruptedException -> 0x005e }
        if (r2 != 0) goto L_0x002c;
    L_0x0024:
        r11 = new java.io.IOException;	 Catch:{ InterruptedException -> 0x005e }
        r12 = "stream closed";
        r11.<init>(r12);	 Catch:{ InterruptedException -> 0x005e }
        throw r11;	 Catch:{ InterruptedException -> 0x005e }
    L_0x002c:
        r10.wait();	 Catch:{ InterruptedException -> 0x005e }
        goto L_0x0012;
    L_0x0030:
        r4 = r10.bytesLeftInWriteWindow;	 Catch:{ all -> 0x005c }
        r4 = java.lang.Math.min(r14, r4);	 Catch:{ all -> 0x005c }
        r2 = (int) r4;	 Catch:{ all -> 0x005c }
        r4 = r10.writer;	 Catch:{ all -> 0x005c }
        r4 = r4.maxDataLength();	 Catch:{ all -> 0x005c }
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x005c }
        r4 = r10.bytesLeftInWriteWindow;	 Catch:{ all -> 0x005c }
        r6 = (long) r2;	 Catch:{ all -> 0x005c }
        r8 = r4 - r6;
        r10.bytesLeftInWriteWindow = r8;	 Catch:{ all -> 0x005c }
        monitor-exit(r10);	 Catch:{ all -> 0x005c }
        r4 = 0;
        r4 = r14 - r6;
        r14 = r10.writer;
        if (r12 == 0) goto L_0x0056;
    L_0x0050:
        r15 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r15 != 0) goto L_0x0056;
    L_0x0054:
        r15 = 1;
        goto L_0x0057;
    L_0x0056:
        r15 = 0;
    L_0x0057:
        r14.data(r15, r11, r13, r2);
        r14 = r4;
        goto L_0x000d;
    L_0x005c:
        r11 = move-exception;
        goto L_0x0064;
    L_0x005e:
        r11 = new java.io.InterruptedIOException;	 Catch:{ all -> 0x005c }
        r11.<init>();	 Catch:{ all -> 0x005c }
        throw r11;	 Catch:{ all -> 0x005c }
    L_0x0064:
        monitor-exit(r10);	 Catch:{ all -> 0x005c }
        throw r11;
    L_0x0066:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void writeSynResetLater(int i, ErrorCode errorCode) {
        try {
            final int i2 = i;
            final ErrorCode errorCode2 = errorCode;
            this.writerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}) {
                public void execute() {
                    try {
                        Http2Connection.this.writeSynReset(i2, errorCode2);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    void writeSynReset(int i, ErrorCode errorCode) {
        this.writer.rstStream(i, errorCode);
    }

    void writeWindowUpdateLater(int i, long j) {
        try {
            final int i2 = i;
            final long j2 = j;
            this.writerExecutor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}) {
                public void execute() {
                    try {
                        Http2Connection.this.writer.windowUpdate(i2, j2);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    void writePing(boolean z, int i, int i2) {
        if (!z) {
            boolean z2;
            synchronized (this) {
                z2 = this.awaitingPong;
                this.awaitingPong = true;
            }
            if (z2) {
                failConnection();
                return;
            }
        }
        try {
            this.writer.ping(z, i, i2);
        } catch (IOException unused) {
            failConnection();
        }
    }

    void writePingAndAwaitPong() {
        writePing(false, 1330343787, -257978967);
        awaitPong();
    }

    synchronized void awaitPong() {
        while (this.awaitingPong) {
            wait();
        }
    }

    public void flush() {
        this.writer.flush();
    }

    public void shutdown(ErrorCode errorCode) {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                int i = this.lastGoodStreamId;
                this.writer.goAway(i, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void close() {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    void close(ErrorCode errorCode, ErrorCode errorCode2) {
        IOException e;
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                this.streams.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream close : http2StreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    private void failConnection() {
        try {
            close(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    public void start() {
        start(true);
    }

    void start(boolean z) {
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != SupportMenu.USER_MASK) {
                this.writer.windowUpdate(0, (long) (initialWindowSize - SupportMenu.USER_MASK));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    public void setSettings(Settings settings) {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    /* JADX WARNING: Missing block: B:10:?, code:
            r2 = r8;
            r5 = r9;
            r6 = r10;
            r8.pushExecutor.execute(new okhttp3.internal.http2.Http2Connection.AnonymousClass3(r2, "OkHttp %s Push Request[%s]", new java.lang.Object[]{r8.hostname, java.lang.Integer.valueOf(r9)}));
     */
    /* JADX WARNING: Missing block: B:11:0x003d, code:
            return;
     */
    void pushRequestLater(int r9, java.util.List<okhttp3.internal.http2.Header> r10) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.currentPushRequests;	 Catch:{ all -> 0x003e }
        r1 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x003e }
        r0 = r0.contains(r1);	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0014;
    L_0x000d:
        r10 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ all -> 0x003e }
        r8.writeSynResetLater(r9, r10);	 Catch:{ all -> 0x003e }
        monitor-exit(r8);	 Catch:{ all -> 0x003e }
        return;
    L_0x0014:
        r0 = r8.currentPushRequests;	 Catch:{ all -> 0x003e }
        r1 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x003e }
        r0.add(r1);	 Catch:{ all -> 0x003e }
        monitor-exit(r8);	 Catch:{ all -> 0x003e }
        r0 = r8.pushExecutor;	 Catch:{ RejectedExecutionException -> 0x003d }
        r7 = new okhttp3.internal.http2.Http2Connection$3;	 Catch:{ RejectedExecutionException -> 0x003d }
        r3 = "OkHttp %s Push Request[%s]";
        r1 = 2;
        r4 = new java.lang.Object[r1];	 Catch:{ RejectedExecutionException -> 0x003d }
        r1 = 0;
        r2 = r8.hostname;	 Catch:{ RejectedExecutionException -> 0x003d }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x003d }
        r1 = 1;
        r2 = java.lang.Integer.valueOf(r9);	 Catch:{ RejectedExecutionException -> 0x003d }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x003d }
        r1 = r7;
        r2 = r8;
        r5 = r9;
        r6 = r10;
        r1.<init>(r3, r4, r5, r6);	 Catch:{ RejectedExecutionException -> 0x003d }
        r0.execute(r7);	 Catch:{ RejectedExecutionException -> 0x003d }
    L_0x003d:
        return;
    L_0x003e:
        r9 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x003e }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.pushRequestLater(int, java.util.List):void");
    }

    void pushHeadersLater(int i, List<Header> list, boolean z) {
        try {
            final int i2 = i;
            final List<Header> list2 = list;
            final boolean z2 = z;
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) {
                public void execute() {
                    boolean onHeaders = Http2Connection.this.pushObserver.onHeaders(i2, list2, z2);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.writer.rstStream(i2, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                        }
                    }
                    if (onHeaders || z2) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i2));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    void pushDataLater(int i, BufferedSource bufferedSource, int i2, boolean z) {
        final Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() != j) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(buffer.size());
            stringBuilder.append(" != ");
            stringBuilder.append(i2);
            throw new IOException(stringBuilder.toString());
        }
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) {
            public void execute() {
                try {
                    boolean onData = Http2Connection.this.pushObserver.onData(i3, buffer, i4, z2);
                    if (onData) {
                        Http2Connection.this.writer.rstStream(i3, ErrorCode.CANCEL);
                    }
                    if (onData || z2) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i3));
                        }
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    void pushResetLater(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) {
            public void execute() {
                Http2Connection.this.pushObserver.onReset(i2, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i2));
                }
            }
        });
    }
}
