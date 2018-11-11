package com.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: Util */
public final class c {
    static final Charset US_ASCII = Charset.forName("US-ASCII");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    static void deleteContents(File file) {
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
                stringBuilder2.append("failed to delete file: ");
                stringBuilder2.append(file2);
                throw new IOException(stringBuilder2.toString());
            }
        }
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
