package okhttp3.internal.cache2;

import java.nio.channels.FileChannel;
import okio.Buffer;

final class FileOperator {
    private final FileChannel fileChannel;

    FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void write(long j, Buffer buffer, long j2) {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j3, j4);
            j4 -= transferFrom;
            j3 += transferFrom;
        }
    }

    public void read(long j, Buffer buffer, long j2) {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long transferTo = this.fileChannel.transferTo(j, j2, buffer);
            j2 -= transferTo;
            j += transferTo;
        }
    }
}
