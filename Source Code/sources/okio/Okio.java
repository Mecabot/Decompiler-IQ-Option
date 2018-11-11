package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Okio {
    static final Logger logger = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    private static Sink sink(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new Sink() {
                public void write(Buffer buffer, long j) {
                    Util.checkOffsetAndCount(buffer.size, 0, j);
                    while (j > 0) {
                        timeout.throwIfReached();
                        Segment segment = buffer.head;
                        int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                        outputStream.write(segment.data, segment.pos, min);
                        segment.pos += min;
                        long j2 = (long) min;
                        long j3 = j - j2;
                        buffer.size -= j2;
                        if (segment.pos == segment.limit) {
                            buffer.head = segment.pop();
                            SegmentPool.recycle(segment);
                        }
                        j = j3;
                    }
                }

                public void flush() {
                    outputStream.flush();
                }

                public void close() {
                    outputStream.close();
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("sink(");
                    stringBuilder.append(outputStream);
                    stringBuilder.append(")");
                    return stringBuilder.toString();
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink sink(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        } else {
            Timeout timeout = timeout(socket);
            return timeout.sink(sink(socket.getOutputStream(), timeout));
        }
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static Source source(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new Source() {
                public long read(Buffer buffer, long j) {
                    if (j < 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("byteCount < 0: ");
                        stringBuilder.append(j);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    } else if (j == 0) {
                        return 0;
                    } else {
                        try {
                            timeout.throwIfReached();
                            Segment writableSegment = buffer.writableSegment(1);
                            int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, (long) (8192 - writableSegment.limit)));
                            if (read == -1) {
                                return -1;
                            }
                            writableSegment.limit += read;
                            j = (long) read;
                            buffer.size += j;
                            return j;
                        } catch (Throwable e) {
                            if (Okio.isAndroidGetsocknameError(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                public void close() {
                    inputStream.close();
                }

                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("source(");
                    stringBuilder.append(inputStream);
                    stringBuilder.append(")");
                    return stringBuilder.toString();
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Source source(File file) {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Sink sink(File file) {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink appendingSink(File file) {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Sink blackhole() {
        return new Sink() {
            public void close() {
            }

            public void flush() {
            }

            public void write(Buffer buffer, long j) {
                buffer.skip(j);
            }

            public Timeout timeout() {
                return Timeout.NONE;
            }
        };
    }

    public static Source source(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        } else {
            Timeout timeout = timeout(socket);
            return timeout.source(source(socket.getInputStream(), timeout));
        }
    }

    private static AsyncTimeout timeout(final Socket socket) {
        return new AsyncTimeout() {
            protected IOException newTimeoutException(IOException iOException) {
                IOException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            protected void timedOut() {
                Logger logger;
                Level level;
                StringBuilder stringBuilder;
                try {
                    socket.close();
                } catch (Throwable e) {
                    logger = Okio.logger;
                    level = Level.WARNING;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to close timed out socket ");
                    stringBuilder.append(socket);
                    logger.log(level, stringBuilder.toString(), e);
                } catch (Throwable e2) {
                    if (Okio.isAndroidGetsocknameError(e2)) {
                        logger = Okio.logger;
                        level = Level.WARNING;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to close timed out socket ");
                        stringBuilder.append(socket);
                        logger.log(level, stringBuilder.toString(), e2);
                        return;
                    }
                    throw e2;
                }
            }
        };
    }

    static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
