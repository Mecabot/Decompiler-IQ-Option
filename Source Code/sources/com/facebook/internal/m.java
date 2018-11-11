package com.facebook.internal;

import com.facebook.LoggingBehavior;
import com.facebook.h;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: FileLruCache */
public final class m {
    private static final AtomicLong Dx = new AtomicLong();
    static final String TAG = "m";
    private boolean DA;
    private AtomicLong DB = new AtomicLong(0);
    private final c Dy;
    private boolean Dz;
    private final File directory;
    private final Object lock;
    private final String tag;

    /* compiled from: FileLruCache */
    private static class a {
        private static final FilenameFilter DI = new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.startsWith("buffer") ^ 1;
            }
        };
        private static final FilenameFilter DL = new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.startsWith("buffer");
            }
        };

        static void n(File file) {
            File[] listFiles = file.listFiles(lY());
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        static FilenameFilter lX() {
            return DI;
        }

        static FilenameFilter lY() {
            return DL;
        }

        static File o(File file) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("buffer");
            stringBuilder.append(Long.valueOf(m.Dx.incrementAndGet()).toString());
            return new File(file, stringBuilder.toString());
        }
    }

    /* compiled from: FileLruCache */
    private static class b extends OutputStream {
        final OutputStream DN;
        final e DQ;

        b(OutputStream outputStream, e eVar) {
            this.DN = outputStream;
            this.DQ = eVar;
        }

        public void close() {
            try {
                this.DN.close();
            } finally {
                this.DQ.onClose();
            }
        }

        public void flush() {
            this.DN.flush();
        }

        public void write(byte[] bArr, int i, int i2) {
            this.DN.write(bArr, i, i2);
        }

        public void write(byte[] bArr) {
            this.DN.write(bArr);
        }

        public void write(int i) {
            this.DN.write(i);
        }
    }

    /* compiled from: FileLruCache */
    public static final class c {
        private int DR = 1048576;
        private int DS = 1024;

        int getByteCount() {
            return this.DR;
        }

        int lZ() {
            return this.DS;
        }
    }

    /* compiled from: FileLruCache */
    private static final class d implements Comparable<d> {
        private final long DT;
        private final File file;

        d(File file) {
            this.file = file;
            this.DT = file.lastModified();
        }

        File getFile() {
            return this.file;
        }

        long ma() {
            return this.DT;
        }

        /* renamed from: a */
        public int compareTo(d dVar) {
            if (ma() < dVar.ma()) {
                return -1;
            }
            if (ma() > dVar.ma()) {
                return 1;
            }
            return getFile().compareTo(dVar.getFile());
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && compareTo((d) obj) == 0;
        }

        public int hashCode() {
            return ((1073 + this.file.hashCode()) * 37) + ((int) (this.DT % 2147483647L));
        }
    }

    /* compiled from: FileLruCache */
    private interface e {
        void onClose();
    }

    /* compiled from: FileLruCache */
    private static final class f {
        static void a(OutputStream outputStream, JSONObject jSONObject) {
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }

        static JSONObject b(InputStream inputStream) {
            if (inputStream.read() != 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = inputStream.read();
                if (read == -1) {
                    q.a(LoggingBehavior.CACHE, m.TAG, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < bArr.length) {
                i2 = inputStream.read(bArr, i, bArr.length - i);
                if (i2 < 1) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String str = m.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("readHeader: stream.read stopped at ");
                    stringBuilder.append(Integer.valueOf(i));
                    stringBuilder.append(" when expected ");
                    stringBuilder.append(bArr.length);
                    q.a(loggingBehavior, str, stringBuilder.toString());
                    return null;
                }
                i += i2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr)).nextValue();
                if (nextValue instanceof JSONObject) {
                    return (JSONObject) nextValue;
                }
                LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                String str2 = m.TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("readHeader: expected JSONObject, got ");
                stringBuilder2.append(nextValue.getClass().getCanonicalName());
                q.a(loggingBehavior2, str2, stringBuilder2.toString());
                return null;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public m(String str, c cVar) {
        this.tag = str;
        this.Dy = cVar;
        this.directory = new File(h.getCacheDir(), str);
        this.lock = new Object();
        if (this.directory.mkdirs() || this.directory.isDirectory()) {
            a.n(this.directory);
        }
    }

    public InputStream bH(String str) {
        return z(str, null);
    }

    public InputStream z(String str, String str2) {
        File file = new File(this.directory, w.bN(str));
        InputStream inputStream = null;
        try {
            InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject b = f.b(bufferedInputStream);
                if (b == null) {
                    return inputStream;
                }
                String optString = b.optString("key");
                if (optString == null || !optString.equals(str)) {
                    bufferedInputStream.close();
                    return null;
                }
                str = b.optString("tag", null);
                if ((str2 != null || str == null) && (str2 == null || str2.equals(str))) {
                    long time = new Date().getTime();
                    inputStream = LoggingBehavior.CACHE;
                    String str3 = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Setting lastModified to ");
                    stringBuilder.append(Long.valueOf(time));
                    stringBuilder.append(" for ");
                    stringBuilder.append(file.getName());
                    q.a(inputStream, str3, stringBuilder.toString());
                    file.setLastModified(time);
                    return bufferedInputStream;
                }
                bufferedInputStream.close();
                return null;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public OutputStream bI(String str) {
        return A(str, null);
    }

    public OutputStream A(String str, String str2) {
        LoggingBehavior loggingBehavior;
        String str3;
        final File o = a.o(this.directory);
        o.delete();
        if (o.createNewFile()) {
            try {
                OutputStream fileOutputStream = new FileOutputStream(o);
                final long currentTimeMillis = System.currentTimeMillis();
                final String str4 = str;
                OutputStream bufferedOutputStream = new BufferedOutputStream(new b(fileOutputStream, new e() {
                    public void onClose() {
                        if (currentTimeMillis < m.this.DB.get()) {
                            o.delete();
                        } else {
                            m.this.a(str4, o);
                        }
                    }
                }), 8192);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!w.bc(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    f.a(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e) {
                    loggingBehavior = LoggingBehavior.CACHE;
                    str3 = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error creating JSON header for cache file: ");
                    stringBuilder.append(e);
                    q.a(loggingBehavior, 5, str3, stringBuilder.toString());
                    throw new IOException(e.getMessage());
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                }
            } catch (FileNotFoundException e2) {
                loggingBehavior = LoggingBehavior.CACHE;
                str3 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Error creating buffer output stream: ");
                stringBuilder2.append(e2);
                q.a(loggingBehavior, 5, str3, stringBuilder2.toString());
                throw new IOException(e2.getMessage());
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Could not create file at ");
        stringBuilder3.append(o.getAbsolutePath());
        throw new IOException(stringBuilder3.toString());
    }

    public void clearCache() {
        final File[] listFiles = this.directory.listFiles(a.lX());
        this.DB.set(System.currentTimeMillis());
        if (listFiles != null) {
            h.getExecutor().execute(new Runnable() {
                public void run() {
                    for (File delete : listFiles) {
                        delete.delete();
                    }
                }
            });
        }
    }

    private void a(String str, File file) {
        if (!file.renameTo(new File(this.directory, w.bN(str)))) {
            file.delete();
        }
        lV();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{FileLruCache: tag:");
        stringBuilder.append(this.tag);
        stringBuilder.append(" file:");
        stringBuilder.append(this.directory.getName());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void lV() {
        synchronized (this.lock) {
            if (!this.Dz) {
                this.Dz = true;
                h.getExecutor().execute(new Runnable() {
                    public void run() {
                        m.this.trim();
                    }
                });
            }
        }
    }

    private void trim() {
        int i;
        Throwable th;
        m mVar = this;
        PriorityQueue priorityQueue = mVar.lock;
        synchronized (priorityQueue) {
            try {
                mVar.Dz = false;
                mVar.DA = true;
            } finally {
                Object obj = 
/*
Method generation error in method: com.facebook.internal.m.trim():void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0103: MERGE  (r3_11 'obj' java.lang.Object) = (r0_5 int), (r7_7 'i' int) in method: com.facebook.internal.m.trim():void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:298)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:228)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:173)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:323)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:260)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:222)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 28 more

*/
}
