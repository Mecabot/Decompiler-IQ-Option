package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import com.iqoption.dto.entity.position.Position;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

final class WebSocketWriter {
    boolean activeWriter;
    final Buffer buffer = new Buffer();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final UnsafeCursor maskCursor;
    private final byte[] maskKey;
    final Random random;
    final BufferedSink sink;
    final Buffer sinkBuffer;
    boolean writerClosed;

    final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public void write(Buffer buffer, long j) {
            if (this.closed) {
                throw new IOException(Position.STATUS_CLOSED);
            }
            WebSocketWriter.this.buffer.write(buffer, j);
            Object obj = (!this.isFirstFrame || this.contentLength == -1 || WebSocketWriter.this.buffer.size() <= this.contentLength - PlaybackStateCompat.ACTION_PLAY_FROM_URI) ? null : 1;
            long completeSegmentByteCount = WebSocketWriter.this.buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0 && obj == null) {
                WebSocketWriter.this.writeMessageFrame(this.formatOpcode, completeSegmentByteCount, this.isFirstFrame, false);
                this.isFirstFrame = false;
            }
        }

        public void flush() {
            if (this.closed) {
                throw new IOException(Position.STATUS_CLOSED);
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        public Timeout timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public void close() {
            if (this.closed) {
                throw new IOException(Position.STATUS_CLOSED);
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, true);
            this.closed = true;
            WebSocketWriter.this.activeWriter = false;
        }
    }

    WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random == null) {
            throw new NullPointerException("random == null");
        } else {
            this.isClient = z;
            this.sink = bufferedSink;
            this.sinkBuffer = bufferedSink.buffer();
            this.random = random;
            UnsafeCursor unsafeCursor = null;
            this.maskKey = z ? new byte[4] : null;
            if (z) {
                unsafeCursor = new UnsafeCursor();
            }
            this.maskCursor = unsafeCursor;
        }
    }

    void writePing(ByteString byteString) {
        writeControlFrame(9, byteString);
    }

    void writePong(ByteString byteString) {
        writeControlFrame(10, byteString);
    }

    void writeClose(int i, ByteString byteString) {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    private void writeControlFrame(int i, ByteString byteString) {
        if (this.writerClosed) {
            throw new IOException(Position.STATUS_CLOSED);
        }
        int size = byteString.size();
        if (((long) size) > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.writeByte(i | 128);
        if (this.isClient) {
            this.sinkBuffer.writeByte(size | 128);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                long size2 = this.sinkBuffer.size();
                this.sinkBuffer.write(byteString);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size2);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(size);
            this.sinkBuffer.write(byteString);
        }
        this.sink.flush();
    }

    Sink newMessageSink(int i, long j) {
        if (this.activeWriter) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.activeWriter = true;
        this.frameSink.formatOpcode = i;
        this.frameSink.contentLength = j;
        this.frameSink.isFirstFrame = true;
        this.frameSink.closed = false;
        return this.frameSink;
    }

    void writeMessageFrame(int i, long j, boolean z, boolean z2) {
        if (this.writerClosed) {
            throw new IOException(Position.STATUS_CLOSED);
        }
        int i2 = 0;
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.sinkBuffer.writeByte(i);
        if (this.isClient) {
            i2 = 128;
        }
        if (j <= 125) {
            this.sinkBuffer.writeByte(((int) j) | i2);
        } else if (j <= 65535) {
            this.sinkBuffer.writeByte(i2 | 126);
            this.sinkBuffer.writeShort((int) j);
        } else {
            this.sinkBuffer.writeByte(i2 | 127);
            this.sinkBuffer.writeLong(j);
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (j > 0) {
                long size = this.sinkBuffer.size();
                this.sinkBuffer.write(this.buffer, j);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j);
        }
        this.sink.emit();
    }
}
