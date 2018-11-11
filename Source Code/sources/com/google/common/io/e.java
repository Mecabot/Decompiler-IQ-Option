package com.google.common.io;

import com.google.common.base.i;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

/* compiled from: CharStreams */
public final class e {
    static CharBuffer vk() {
        return CharBuffer.allocate(2048);
    }

    public static long a(Readable readable, Appendable appendable) {
        if (!(readable instanceof Reader)) {
            i.checkNotNull(readable);
            i.checkNotNull(appendable);
            long j = 0;
            CharBuffer vk = vk();
            while (readable.read(vk) != -1) {
                vk.flip();
                appendable.append(vk);
                long remaining = j + ((long) vk.remaining());
                vk.clear();
                j = remaining;
            }
            return j;
        } else if (appendable instanceof StringBuilder) {
            return a((Reader) readable, (StringBuilder) appendable);
        } else {
            return a((Reader) readable, a(appendable));
        }
    }

    static long a(Reader reader, StringBuilder stringBuilder) {
        i.checkNotNull(reader);
        i.checkNotNull(stringBuilder);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            stringBuilder.append(cArr, 0, read);
            j += (long) read;
        }
    }

    static long a(Reader reader, Writer writer) {
        i.checkNotNull(reader);
        i.checkNotNull(writer);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }

    public static String a(Readable readable) {
        return b(readable).toString();
    }

    private static StringBuilder b(Readable readable) {
        Appendable stringBuilder = new StringBuilder();
        if (readable instanceof Reader) {
            a((Reader) readable, (StringBuilder) stringBuilder);
        } else {
            a(readable, stringBuilder);
        }
        return stringBuilder;
    }

    public static <T> T a(Readable readable, i<T> iVar) {
        i.checkNotNull(readable);
        i.checkNotNull(iVar);
        j jVar = new j(readable);
        String readLine;
        do {
            readLine = jVar.readLine();
            if (readLine == null) {
                break;
            }
        } while (iVar.cJ(readLine));
        return iVar.getResult();
    }

    public static Writer a(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new a(appendable);
    }
}
