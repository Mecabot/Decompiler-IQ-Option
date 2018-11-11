package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.iqoption.dto.entity.position.Position;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class RealBufferedSink implements BufferedSink {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Sink sink;

    RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.sink = sink;
    }

    public Buffer buffer() {
        return this.buffer;
    }

    public void write(Buffer buffer, long j) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.write(buffer, j);
        emitCompleteSegments();
    }

    public BufferedSink write(ByteString byteString) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.write(byteString);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8(String str) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8(String str, int i, int i2) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeUtf8(str, i, i2);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8CodePoint(int i) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeUtf8CodePoint(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeString(String str, Charset charset) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    public BufferedSink writeString(String str, int i, int i2, Charset charset) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeString(str, i, i2, charset);
        return emitCompleteSegments();
    }

    public BufferedSink write(byte[] bArr) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.write(bArr);
        return emitCompleteSegments();
    }

    public BufferedSink write(byte[] bArr, int i, int i2) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.write(bArr, i, i2);
        return emitCompleteSegments();
    }

    public int write(ByteBuffer byteBuffer) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        int write = this.buffer.write(byteBuffer);
        emitCompleteSegments();
        return write;
    }

    public long writeAll(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            long j2 = j + read;
            emitCompleteSegments();
            j = j2;
        }
    }

    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this.buffer, j);
            if (read == -1) {
                throw new EOFException();
            }
            long j2 = j - read;
            emitCompleteSegments();
            j = j2;
        }
        return this;
    }

    public BufferedSink writeByte(int i) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeByte(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeShort(int i) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeShort(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeShortLe(int i) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeShortLe(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeInt(int i) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeInt(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeIntLe(int i) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeIntLe(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeLong(long j) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeLong(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeLongLe(long j) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeLongLe(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeDecimalLong(long j) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeDecimalLong(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeHexadecimalUnsignedLong(long j) {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        this.buffer.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    public BufferedSink emitCompleteSegments() {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.sink.write(this.buffer, completeSegmentByteCount);
        }
        return this;
    }

    public BufferedSink emit() {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    public OutputStream outputStream() {
        return new OutputStream() {
            public void write(int i) {
                if (RealBufferedSink.this.closed) {
                    throw new IOException(Position.STATUS_CLOSED);
                }
                RealBufferedSink.this.buffer.writeByte((byte) i);
                RealBufferedSink.this.emitCompleteSegments();
            }

            public void write(byte[] bArr, int i, int i2) {
                if (RealBufferedSink.this.closed) {
                    throw new IOException(Position.STATUS_CLOSED);
                }
                RealBufferedSink.this.buffer.write(bArr, i, i2);
                RealBufferedSink.this.emitCompleteSegments();
            }

            public void flush() {
                if (!RealBufferedSink.this.closed) {
                    RealBufferedSink.this.flush();
                }
            }

            public void close() {
                RealBufferedSink.this.close();
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(RealBufferedSink.this);
                stringBuilder.append(".outputStream()");
                return stringBuilder.toString();
            }
        };
    }

    public void flush() {
        if (this.closed) {
            throw new IllegalStateException(Position.STATUS_CLOSED);
        }
        if (this.buffer.size > 0) {
            this.sink.write(this.buffer, this.buffer.size);
        }
        this.sink.flush();
    }

    public boolean isOpen() {
        return this.closed ^ 1;
    }

    public void close() {
        if (!this.closed) {
            Throwable th = null;
            try {
                if (this.buffer.size > 0) {
                    this.sink.write(this.buffer, this.buffer.size);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.closed = true;
            if (th != null) {
                Util.sneakyRethrow(th);
            }
        }
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.sink);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
