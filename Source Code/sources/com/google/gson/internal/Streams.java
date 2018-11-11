package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonWriter;
import java.io.Writer;

public final class Streams {

    private static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite = new CurrentWrite();

        static class CurrentWrite implements CharSequence {
            char[] chars;

            CurrentWrite() {
            }

            public int length() {
                return this.chars.length;
            }

            public char charAt(int i) {
                return this.chars[i];
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.chars, i, i2 - i);
            }
        }

        public void close() {
        }

        public void flush() {
        }

        AppendableWriter(Appendable appendable) {
            this.appendable = appendable;
        }

        public void write(char[] cArr, int i, int i2) {
            this.currentWrite.chars = cArr;
            this.appendable.append(this.currentWrite, i, i2 + i);
        }

        public void write(int i) {
            this.appendable.append((char) i);
        }
    }

    private Streams() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A:{Splitter: B:0:0x0000, ExcHandler: com.google.gson.stream.MalformedJsonException (r2_6 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A:{Splitter: B:0:0x0000, ExcHandler: java.io.IOException (r2_5 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A:{Splitter: B:0:0x0000, ExcHandler: java.lang.NumberFormatException (r2_4 'e' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:6:0x000d, code:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:7:0x000f, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:9:0x0015, code:
            throw new com.google.gson.JsonSyntaxException(r2);
     */
    /* JADX WARNING: Missing block: B:10:0x0016, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:12:0x001c, code:
            throw new com.google.gson.JsonIOException(r2);
     */
    /* JADX WARNING: Missing block: B:13:0x001d, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:15:0x0023, code:
            throw new com.google.gson.JsonSyntaxException(r2);
     */
    /* JADX WARNING: Missing block: B:20:0x002a, code:
            return com.google.gson.JsonNull.INSTANCE;
     */
    /* JADX WARNING: Missing block: B:22:0x0030, code:
            throw new com.google.gson.JsonSyntaxException(r2);
     */
    public static com.google.gson.JsonElement parse(com.google.gson.stream.JsonReader r2) {
        /*
        r2.peek();	 Catch:{ EOFException -> 0x0024, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        r0 = 0;
        r1 = com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT;	 Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        r2 = r1.read(r2);	 Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        r2 = (com.google.gson.JsonElement) r2;	 Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        return r2;
    L_0x000d:
        r2 = move-exception;
        goto L_0x0026;
    L_0x000f:
        r2 = move-exception;
        r0 = new com.google.gson.JsonSyntaxException;
        r0.<init>(r2);
        throw r0;
    L_0x0016:
        r2 = move-exception;
        r0 = new com.google.gson.JsonIOException;
        r0.<init>(r2);
        throw r0;
    L_0x001d:
        r2 = move-exception;
        r0 = new com.google.gson.JsonSyntaxException;
        r0.<init>(r2);
        throw r0;
    L_0x0024:
        r2 = move-exception;
        r0 = 1;
    L_0x0026:
        if (r0 == 0) goto L_0x002b;
    L_0x0028:
        r2 = com.google.gson.JsonNull.INSTANCE;
        return r2;
    L_0x002b:
        r0 = new com.google.gson.JsonSyntaxException;
        r0.<init>(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.Streams.parse(com.google.gson.stream.JsonReader):com.google.gson.JsonElement");
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }
}
