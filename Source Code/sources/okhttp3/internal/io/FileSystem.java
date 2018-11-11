package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() {
        public Source source(File file) {
            return Okio.source(file);
        }

        public Sink sink(File file) {
            try {
                return Okio.sink(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.sink(file);
            }
        }

        public Sink appendingSink(File file) {
            try {
                return Okio.appendingSink(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.appendingSink(file);
            }
        }

        public void delete(File file) {
            if (!file.delete() && file.exists()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed to delete ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public long size(File file) {
            return file.length();
        }

        public void rename(File file, File file2) {
            delete(file2);
            if (!file.renameTo(file2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed to rename ");
                stringBuilder.append(file);
                stringBuilder.append(" to ");
                stringBuilder.append(file2);
                throw new IOException(stringBuilder.toString());
            }
        }

        public void deleteContents(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("not a readable directory: ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("failed to delete ");
                    stringBuilder2.append(file2);
                    throw new IOException(stringBuilder2.toString());
                }
            }
        }
    };

    Sink appendingSink(File file);

    void delete(File file);

    void deleteContents(File file);

    boolean exists(File file);

    void rename(File file, File file2);

    Sink sink(File file);

    long size(File file);

    Source source(File file);
}
