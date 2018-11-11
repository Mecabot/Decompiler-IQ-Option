package com.iqoption.core.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t\u001a\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001¨\u0006\u0010"}, aXE = {"fileToString", "", "file", "Ljava/io/File;", "longHash", "", "string", "readerToString", "reader", "Ljava/io/Reader;", "safeClose", "", "obj", "Ljava/io/Closeable;", "stringToFile", "text", "core_release"})
/* compiled from: Files.kt */
public final class e {
    public static final String t(File file) {
        h.e(file, "file");
        FileReader fileReader = new FileReader(file);
        try {
            String a = a(fileReader);
            return a;
        } finally {
            b(fileReader);
        }
    }

    public static final String a(Reader reader) {
        h.e(reader, "reader");
        char[] cArr = new char[512];
        int read = reader.read(cArr);
        StringBuilder stringBuilder = new StringBuilder();
        while (read != -1) {
            stringBuilder.append(cArr, 0, read);
            read = reader.read(cArr);
        }
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "builder.toString()");
        return stringBuilder2;
    }

    public static final void d(File file, String str) {
        h.e(file, "file");
        h.e(str, "text");
        FileWriter fileWriter = new FileWriter(file);
        try {
            fileWriter.write(str);
        } finally {
            b(fileWriter);
        }
    }

    public static final void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
