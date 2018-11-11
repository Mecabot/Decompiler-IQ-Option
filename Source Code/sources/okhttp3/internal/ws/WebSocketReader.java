package okhttp3.internal.ws;

import com.iqoption.dto.entity.position.Position;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.BufferedSource;
import okio.ByteString;

final class WebSocketReader {
    boolean closed;
    private final Buffer controlFrameBuffer = new Buffer();
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer = new Buffer();
    int opcode;
    final BufferedSource source;

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str);

        void onReadMessage(ByteString byteString);

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        } else {
            byte[] bArr;
            this.isClient = z;
            this.source = bufferedSource;
            this.frameCallback = frameCallback;
            UnsafeCursor unsafeCursor = null;
            if (z) {
                bArr = null;
            } else {
                bArr = new byte[4];
            }
            this.maskKey = bArr;
            if (!z) {
                unsafeCursor = new UnsafeCursor();
            }
            this.maskCursor = unsafeCursor;
        }
    }

    void processNextFrame() {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }

    private void readHeader() {
        if (this.closed) {
            throw new IOException(Position.STATUS_CLOSED);
        }
        long timeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int readByte = this.source.readByte() & 255;
            this.isFinalFrame = timeoutNanos != null;
            this.isControlFrame = (readByte & 8) != 0;
            if (!this.isControlFrame || this.isFinalFrame) {
                Object obj = (readByte & 64) != 0 ? 1 : null;
                Object obj2 = (readByte & 32) != 0 ? 1 : null;
                Object obj3 = (readByte & 16) != 0 ? 1 : null;
                if (obj == null && obj2 == null && obj3 == null) {
                    int readByte2 = this.source.readByte() & 255;
                    if ((readByte2 & 128) != 0) {
                    }
                    if (true == this.isClient) {
                        throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    this.frameLength = (long) (readByte2 & 127);
                    if (this.frameLength == 126) {
                        this.frameLength = ((long) this.source.readShort()) & 65535;
                    } else if (this.frameLength == 127) {
                        this.frameLength = this.source.readLong();
                        if (this.frameLength < 0) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Frame length 0x");
                            stringBuilder.append(Long.toHexString(this.frameLength));
                            stringBuilder.append(" > 0x7FFFFFFFFFFFFFFF");
                            throw new ProtocolException(stringBuilder.toString());
                        }
                    }
                    if (this.isControlFrame && this.frameLength > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (1 != null) {
                        this.source.readFully(this.maskKey);
                        return;
                    } else {
                        return;
                    }
                }
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            throw new ProtocolException("Control frames must be final.");
        } finally {
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
        }
    }

    private void readControlFrame() {
        if (this.frameLength > 0) {
            this.source.readFully(this.controlFrameBuffer, this.frameLength);
            if (!this.isClient) {
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                int i = 1005;
                String str = "";
                long size = this.controlFrameBuffer.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    i = this.controlFrameBuffer.readShort();
                    str = this.controlFrameBuffer.readUtf8();
                    String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(i);
                    if (closeCodeExceptionMessage != null) {
                        throw new ProtocolException(closeCodeExceptionMessage);
                    }
                }
                this.frameCallback.onReadClose(i, str);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown control opcode: ");
                stringBuilder.append(Integer.toHexString(this.opcode));
                throw new ProtocolException(stringBuilder.toString());
        }
    }

    private void readMessageFrame() {
        int i = this.opcode;
        if (i == 1 || i == 2) {
            readMessage();
            if (i == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
                return;
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown opcode: ");
        stringBuilder.append(Integer.toHexString(i));
        throw new ProtocolException(stringBuilder.toString());
    }

    private void readUntilNonControlFrame() {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    private void readMessage() {
        while (!this.closed) {
            if (this.frameLength > 0) {
                this.source.readFully(this.messageFrameBuffer, this.frameLength);
                if (!this.isClient) {
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (!this.isFinalFrame) {
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected continuation opcode. Got: ");
                    stringBuilder.append(Integer.toHexString(this.opcode));
                    throw new ProtocolException(stringBuilder.toString());
                }
            }
            return;
        }
        throw new IOException(Position.STATUS_CLOSED);
    }
}
