package com.jumio.commons.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

public final class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private IOUtils() {
    }

    public static String readFully(Reader reader) {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            return stringWriter2;
        } finally {
            reader.close();
        }
    }

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

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static byte[] toByteArray(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
