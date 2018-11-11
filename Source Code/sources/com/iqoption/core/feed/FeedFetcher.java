package com.iqoption.core.feed;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.core.feed.MediaDiskCache.MediaType;
import com.iqoption.core.microservices.feed.response.FeedItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0007J\b\u0010\u001f\u001a\u00020\u001cH\u0007J\u0016\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u000eJ\u0014\u0010#\u001a\u00020\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%J\b\u0010&\u001a\u00020\u001cH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006'"}, aXE = {"Lcom/iqoption/core/feed/FeedFetcher;", "Landroid/arch/lifecycle/LifecycleObserver;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "THREAD_COUNT", "", "executor", "Ljava/util/concurrent/ExecutorService;", "imageLoader", "Lcom/iqoption/core/feed/FeedImageLoader;", "justBound", "", "Lcom/iqoption/core/feed/Previewable;", "justReceived", "monitor", "Ljava/lang/Object;", "receivedIsInProcess", "", "shutdown", "stubPreviewable", "com/iqoption/core/feed/FeedFetcher$stubPreviewable$1", "Lcom/iqoption/core/feed/FeedFetcher$stubPreviewable$1;", "asPreviewable", "item", "Lcom/iqoption/core/microservices/feed/response/FeedItem;", "endlessWorkingLoop", "", "isBound", "onStart", "onStop", "process", "tempArray", "putJustBound", "putJustReceived", "items", "", "startLoop", "core_release"})
/* compiled from: FeedFetcher.kt */
public final class FeedFetcher implements LifecycleObserver {
    private static final String TAG = "com.iqoption.core.feed.FeedFetcher";
    private static final f aQi = new f();
    private static final List<j> aQj = new ArrayList();
    private static final List<j> aQk = new ArrayList();
    private static final Object aQl = new Object();
    private static boolean aQm;
    private static final b aQn = new b();
    public static final FeedFetcher aQo = new FeedFetcher();
    private static final ExecutorService executor = Executors.newFixedThreadPool(4);
    private static volatile boolean shutdown;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: FeedFetcher.kt */
    static final class a implements Runnable {
        public static final a aQp = new a();

        a() {
        }

        public final void run() {
            FeedFetcher.aQo.Ts();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, aXE = {"com/iqoption/core/feed/FeedFetcher$stubPreviewable$1", "Lcom/iqoption/core/feed/Previewable;", "getKeyBase", "", "type", "Lcom/iqoption/core/feed/MediaDiskCache$MediaType;", "isContentValid", "", "originalPreviewUrl", "setContentInvalid", "", "thumbnailPreviewUrl", "core_release"})
    /* compiled from: FeedFetcher.kt */
    public static final class b implements j {
        public void Tt() {
        }

        public boolean Tu() {
            return true;
        }

        public String Tv() {
            return null;
        }

        public String Tw() {
            return null;
        }

        public String c(MediaType mediaType) {
            h.e(mediaType, Param.TYPE);
            return null;
        }

        b() {
        }
    }

    private FeedFetcher() {
    }

    public final void aj(List<? extends j> list) {
        h.e(list, "items");
        synchronized (aQl) {
            aQk.addAll(list);
            aQl.notifyAll();
            l lVar = l.etX;
        }
    }

    public final void f(j jVar) {
        h.e(jVar, "item");
        synchronized (aQl) {
            aQj.add(jVar);
            aQl.notifyAll();
            l lVar = l.etX;
        }
    }

    @OnLifecycleEvent(R = Event.ON_START)
    public final void onStart() {
        shutdown = false;
        Tr();
    }

    @OnLifecycleEvent(R = Event.ON_STOP)
    public final void onStop() {
        shutdown = true;
        synchronized (aQl) {
            aQl.notifyAll();
            l lVar = l.etX;
        }
    }

    public final j a(FeedItem feedItem) {
        h.e(feedItem, "item");
        if (feedItem instanceof com.iqoption.core.microservices.feed.response.a) {
            return (j) feedItem;
        }
        return aQn;
    }

    private final boolean b(j jVar) {
        return a.aPQ.b(jVar);
    }

    private final void Tr() {
        for (int i = 1; i <= 4; i++) {
            executor.execute(a.aQp);
        }
    }

    /* JADX WARNING: Missing block: B:35:0x005e, code:
            r0.clear();
     */
    /* JADX WARNING: Missing block: B:36:0x0063, code:
            monitor-enter(aQl);
     */
    /* JADX WARNING: Missing block: B:38:?, code:
            aQm = false;
            aQl.notifyAll();
            r1 = kotlin.l.etX;
     */
    private final void Ts() {
        /*
        r5 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.List) r0;
    L_0x0007:
        r1 = shutdown;
        if (r1 != 0) goto L_0x0072;
    L_0x000b:
        r1 = 0;
        r5.process(r0);	 Catch:{ RuntimeException -> 0x003f, InterruptedException -> 0x0025 }
        r0.clear();
        r2 = aQl;
        monitor-enter(r2);
        aQm = r1;	 Catch:{ all -> 0x0020 }
        r1 = aQl;	 Catch:{ all -> 0x0020 }
        r1.notifyAll();	 Catch:{ all -> 0x0020 }
        r1 = kotlin.l.etX;	 Catch:{ all -> 0x0020 }
    L_0x001e:
        monitor-exit(r2);
        goto L_0x0007;
    L_0x0020:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0023:
        r2 = move-exception;
        goto L_0x005e;
    L_0x0025:
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0023 }
        r2.interrupt();	 Catch:{ all -> 0x0023 }
        r0.clear();
        r2 = aQl;
        monitor-enter(r2);
        aQm = r1;	 Catch:{ all -> 0x003c }
        r1 = aQl;	 Catch:{ all -> 0x003c }
        r1.notifyAll();	 Catch:{ all -> 0x003c }
        r1 = kotlin.l.etX;	 Catch:{ all -> 0x003c }
        goto L_0x001e;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x003f:
        r2 = move-exception;
        r3 = TAG;	 Catch:{ all -> 0x0023 }
        r4 = r2.getMessage();	 Catch:{ all -> 0x0023 }
        r2 = (java.lang.Throwable) r2;	 Catch:{ all -> 0x0023 }
        com.iqoption.core.i.e(r3, r4, r2);	 Catch:{ all -> 0x0023 }
        r0.clear();
        r2 = aQl;
        monitor-enter(r2);
        aQm = r1;	 Catch:{ all -> 0x005b }
        r1 = aQl;	 Catch:{ all -> 0x005b }
        r1.notifyAll();	 Catch:{ all -> 0x005b }
        r1 = kotlin.l.etX;	 Catch:{ all -> 0x005b }
        goto L_0x001e;
    L_0x005b:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x005e:
        r0.clear();
        r0 = aQl;
        monitor-enter(r0);
        aQm = r1;	 Catch:{ all -> 0x006f }
        r1 = aQl;	 Catch:{ all -> 0x006f }
        r1.notifyAll();	 Catch:{ all -> 0x006f }
        r1 = kotlin.l.etX;	 Catch:{ all -> 0x006f }
        monitor-exit(r0);
        throw r2;
    L_0x006f:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x0072:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.feed.FeedFetcher.Ts():void");
    }

    /* JADX WARNING: Missing block: B:23:0x0050, code:
            r0 = (com.iqoption.core.feed.j) null;
            r6 = r6.iterator();
     */
    /* JADX WARNING: Missing block: B:25:0x005d, code:
            if (r6.hasNext() == false) goto L_0x008c;
     */
    /* JADX WARNING: Missing block: B:26:0x005f, code:
            r1 = (com.iqoption.core.feed.j) r6.next();
     */
    /* JADX WARNING: Missing block: B:27:0x0065, code:
            if (r2 == false) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:29:0x006d, code:
            if (aQo.b(r1) != false) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:30:0x006f, code:
            r3 = aQl;
     */
    /* JADX WARNING: Missing block: B:31:0x0071, code:
            monitor-enter(r3);
     */
    /* JADX WARNING: Missing block: B:34:0x0078, code:
            if (aQo.b(r1) == false) goto L_0x0081;
     */
    /* JADX WARNING: Missing block: B:35:0x007a, code:
            aQj.remove(r1);
     */
    /* JADX WARNING: Missing block: B:36:0x007f, code:
            monitor-exit(r3);
     */
    /* JADX WARNING: Missing block: B:39:?, code:
            r4 = kotlin.l.etX;
     */
    /* JADX WARNING: Missing block: B:40:0x0083, code:
            monitor-exit(r3);
     */
    /* JADX WARNING: Missing block: B:44:0x0088, code:
            if (r0 != null) goto L_0x0059;
     */
    /* JADX WARNING: Missing block: B:45:0x008a, code:
            r0 = r1;
     */
    /* JADX WARNING: Missing block: B:46:0x008c, code:
            if (r0 != null) goto L_0x008f;
     */
    /* JADX WARNING: Missing block: B:47:0x008e, code:
            return;
     */
    /* JADX WARNING: Missing block: B:48:0x008f, code:
            r6 = aQl;
     */
    /* JADX WARNING: Missing block: B:49:0x0091, code:
            monitor-enter(r6);
     */
    /* JADX WARNING: Missing block: B:50:0x0092, code:
            if (r2 == false) goto L_0x00a5;
     */
    /* JADX WARNING: Missing block: B:52:?, code:
            r1 = aQj;
     */
    /* JADX WARNING: Missing block: B:53:0x0096, code:
            if (r0 != null) goto L_0x009b;
     */
    /* JADX WARNING: Missing block: B:54:0x0098, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:56:0x009f, code:
            if (r1.remove(r0) != false) goto L_0x00b4;
     */
    /* JADX WARNING: Missing block: B:57:0x00a1, code:
            monitor-exit(r6);
     */
    /* JADX WARNING: Missing block: B:58:0x00a2, code:
            return;
     */
    /* JADX WARNING: Missing block: B:61:?, code:
            r1 = aQk;
     */
    /* JADX WARNING: Missing block: B:62:0x00a7, code:
            if (r0 != null) goto L_0x00ac;
     */
    /* JADX WARNING: Missing block: B:63:0x00a9, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:65:0x00b0, code:
            if (r1.remove(r0) != false) goto L_0x00b4;
     */
    /* JADX WARNING: Missing block: B:66:0x00b2, code:
            monitor-exit(r6);
     */
    /* JADX WARNING: Missing block: B:67:0x00b3, code:
            return;
     */
    /* JADX WARNING: Missing block: B:69:?, code:
            r1 = kotlin.l.etX;
     */
    /* JADX WARNING: Missing block: B:70:0x00b6, code:
            monitor-exit(r6);
     */
    /* JADX WARNING: Missing block: B:72:?, code:
            r6 = aQi;
     */
    /* JADX WARNING: Missing block: B:73:0x00b9, code:
            if (r0 != null) goto L_0x00be;
     */
    /* JADX WARNING: Missing block: B:74:0x00bb, code:
            kotlin.jvm.internal.h.aXZ();
     */
    /* JADX WARNING: Missing block: B:75:0x00be, code:
            r6.g(r0);
     */
    /* JADX WARNING: Missing block: B:76:0x00c1, code:
            return;
     */
    private final void process(java.util.List<com.iqoption.core.feed.j> r6) {
        /*
        r5 = this;
        r0 = aQl;
        monitor-enter(r0);
    L_0x0003:
        r1 = aQj;	 Catch:{ all -> 0x00c4 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x0021;
    L_0x000b:
        r1 = aQm;	 Catch:{ all -> 0x00c4 }
        if (r1 != 0) goto L_0x0017;
    L_0x000f:
        r1 = aQk;	 Catch:{ all -> 0x00c4 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x0021;
    L_0x0017:
        r1 = shutdown;	 Catch:{ all -> 0x00c4 }
        if (r1 != 0) goto L_0x0021;
    L_0x001b:
        r1 = aQl;	 Catch:{ all -> 0x00c4 }
        r1.wait();	 Catch:{ all -> 0x00c4 }
        goto L_0x0003;
    L_0x0021:
        r1 = shutdown;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x002e;
    L_0x0025:
        r6 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x00c4 }
        r6.interrupt();	 Catch:{ all -> 0x00c4 }
        monitor-exit(r0);
        return;
    L_0x002e:
        r1 = aQj;	 Catch:{ all -> 0x00c4 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00c4 }
        r2 = 1;
        if (r1 == 0) goto L_0x0044;
    L_0x0037:
        r1 = aQk;	 Catch:{ all -> 0x00c4 }
        r1 = (java.util.Collection) r1;	 Catch:{ all -> 0x00c4 }
        r6.addAll(r1);	 Catch:{ all -> 0x00c4 }
        aQm = r2;	 Catch:{ all -> 0x00c4 }
        r2 = 0;
        r1 = kotlin.l.etX;	 Catch:{ all -> 0x00c4 }
        goto L_0x004f;
    L_0x0044:
        r1 = aQj;	 Catch:{ all -> 0x00c4 }
        r1 = (java.util.Collection) r1;	 Catch:{ all -> 0x00c4 }
        r1 = r6.addAll(r1);	 Catch:{ all -> 0x00c4 }
        java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x00c4 }
    L_0x004f:
        monitor-exit(r0);
        r0 = 0;
        r0 = (com.iqoption.core.feed.j) r0;
        r6 = (java.lang.Iterable) r6;
        r6 = r6.iterator();
    L_0x0059:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x008c;
    L_0x005f:
        r1 = r6.next();
        r1 = (com.iqoption.core.feed.j) r1;
        if (r2 == 0) goto L_0x0088;
    L_0x0067:
        r3 = aQo;
        r3 = r3.b(r1);
        if (r3 != 0) goto L_0x0088;
    L_0x006f:
        r3 = aQl;
        monitor-enter(r3);
        r4 = aQo;	 Catch:{ all -> 0x0085 }
        r4 = r4.b(r1);	 Catch:{ all -> 0x0085 }
        if (r4 == 0) goto L_0x0081;
    L_0x007a:
        r4 = aQj;	 Catch:{ all -> 0x0085 }
        r4.remove(r1);	 Catch:{ all -> 0x0085 }
        monitor-exit(r3);
        goto L_0x0059;
    L_0x0081:
        r4 = kotlin.l.etX;	 Catch:{ all -> 0x0085 }
        monitor-exit(r3);
        goto L_0x0088;
    L_0x0085:
        r6 = move-exception;
        monitor-exit(r3);
        throw r6;
    L_0x0088:
        if (r0 != 0) goto L_0x0059;
    L_0x008a:
        r0 = r1;
        goto L_0x0059;
    L_0x008c:
        if (r0 != 0) goto L_0x008f;
    L_0x008e:
        return;
    L_0x008f:
        r6 = aQl;
        monitor-enter(r6);
        if (r2 == 0) goto L_0x00a5;
    L_0x0094:
        r1 = aQj;	 Catch:{ all -> 0x00a3 }
        if (r0 != 0) goto L_0x009b;
    L_0x0098:
        kotlin.jvm.internal.h.aXZ();	 Catch:{ all -> 0x00a3 }
    L_0x009b:
        r1 = r1.remove(r0);	 Catch:{ all -> 0x00a3 }
        if (r1 != 0) goto L_0x00b4;
    L_0x00a1:
        monitor-exit(r6);
        return;
    L_0x00a3:
        r0 = move-exception;
        goto L_0x00c2;
    L_0x00a5:
        r1 = aQk;	 Catch:{ all -> 0x00a3 }
        if (r0 != 0) goto L_0x00ac;
    L_0x00a9:
        kotlin.jvm.internal.h.aXZ();	 Catch:{ all -> 0x00a3 }
    L_0x00ac:
        r1 = r1.remove(r0);	 Catch:{ all -> 0x00a3 }
        if (r1 != 0) goto L_0x00b4;
    L_0x00b2:
        monitor-exit(r6);
        return;
    L_0x00b4:
        r1 = kotlin.l.etX;	 Catch:{ all -> 0x00a3 }
        monitor-exit(r6);
        r6 = aQi;	 Catch:{ IOException -> 0x00c1 }
        if (r0 != 0) goto L_0x00be;
    L_0x00bb:
        kotlin.jvm.internal.h.aXZ();	 Catch:{ IOException -> 0x00c1 }
    L_0x00be:
        r6.g(r0);	 Catch:{ IOException -> 0x00c1 }
    L_0x00c1:
        return;
    L_0x00c2:
        monitor-exit(r6);
        throw r0;
    L_0x00c4:
        r6 = move-exception;
        monitor-exit(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.feed.FeedFetcher.process(java.util.List):void");
    }
}
