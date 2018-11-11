package kotlin.c;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.text.d;

@i(aXC = {1, 1, 11}, aXD = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a!\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\b\u001a!\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\b\u001aB\u0010\u0010\u001a\u00020\u0001*\u00020\u000226\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001aJ\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\r26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001a7\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u0019\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0002H\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\b\u001a\u0017\u0010\u001f\u001a\u00020 *\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\b\u001a\n\u0010!\u001a\u00020\u0004*\u00020\u0002\u001a\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0014\u0010$\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010%\u001a\u00020&*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\b\u001a?\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u0002H(0\u0019H\bø\u0001\u0000¢\u0006\u0002\u0010,\u001a\u0012\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010.\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0017\u0010/\u001a\u000200*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\b\u0002\b\n\u0006\b\u0011(+0\u0001¨\u00061"}, aXE = {"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"})
/* compiled from: FileReadWrite.kt */
class e extends d {
    public static final byte[] A(File file) {
        h.e(file, "$receiver");
        Closeable fileInputStream = new FileInputStream(file);
        Throwable th = (Throwable) null;
        try {
            FileInputStream fileInputStream2 = (FileInputStream) fileInputStream;
            int i = 0;
            long length = file.length();
            if (length > ((long) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("File ");
                stringBuilder.append(file);
                stringBuilder.append(" is too big (");
                stringBuilder.append(length);
                stringBuilder.append(" bytes) to fit in memory.");
                throw new OutOfMemoryError(stringBuilder.toString());
            }
            int i2 = (int) length;
            byte[] bArr = new byte[i2];
            while (i2 > 0) {
                int read = fileInputStream2.read(bArr, i, i2);
                if (read < 0) {
                    break;
                }
                i2 -= read;
                i += read;
            }
            if (i2 != 0) {
                bArr = Arrays.copyOf(bArr, i);
                h.d(bArr, "java.util.Arrays.copyOf(this, newSize)");
            }
            b.a(fileInputStream, th);
            return bArr;
        } catch (Throwable th2) {
            b.a(fileInputStream, th);
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0024, code:
            kotlin.c.b.a(r0, r2);
     */
    public static final void a(java.io.File r2, byte[] r3) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r2, r0);
        r0 = "array";
        kotlin.jvm.internal.h.e(r3, r0);
        r0 = new java.io.FileOutputStream;
        r0.<init>(r2);
        r0 = (java.io.Closeable) r0;
        r2 = 0;
        r2 = (java.lang.Throwable) r2;
        r1 = r0;
        r1 = (java.io.FileOutputStream) r1;	 Catch:{ Throwable -> 0x0022 }
        r1.write(r3);	 Catch:{ Throwable -> 0x0022 }
        r3 = kotlin.l.etX;	 Catch:{ Throwable -> 0x0022 }
        kotlin.c.b.a(r0, r2);
        return;
    L_0x0020:
        r3 = move-exception;
        goto L_0x0024;
    L_0x0022:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0020 }
    L_0x0024:
        kotlin.c.b.a(r0, r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.c.e.a(java.io.File, byte[]):void");
    }

    public static final String a(File file, Charset charset) {
        h.e(file, "$receiver");
        h.e(charset, "charset");
        return new String(A(file), charset);
    }

    public static /* bridge */ /* synthetic */ String a(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = d.UTF_8;
        }
        return a(file, charset);
    }

    public static final void a(File file, String str, Charset charset) {
        h.e(file, "$receiver");
        h.e(str, "text");
        h.e(charset, "charset");
        Object bytes = str.getBytes(charset);
        h.d(bytes, "(this as java.lang.String).getBytes(charset)");
        a(file, (byte[]) bytes);
    }

    public static /* bridge */ /* synthetic */ void a(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = d.UTF_8;
        }
        a(file, str, charset);
    }
}
