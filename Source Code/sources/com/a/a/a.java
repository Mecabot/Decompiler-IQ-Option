package com.a.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class a implements Closeable {
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream Un = new OutputStream() {
        public void write(int i) {
        }
    };
    private final int appVersion;
    private Writer dTK;
    final ThreadPoolExecutor dTL = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> dTM = new Callable<Void>() {
        /* JADX WARNING: Missing block: B:11:0x0027, code:
            return null;
     */
        public java.lang.Void call() {
            /*
            r4 = this;
            r0 = com.a.a.a.this;
            monitor-enter(r0);
            r1 = com.a.a.a.this;	 Catch:{ all -> 0x0028 }
            r1 = r1.dTK;	 Catch:{ all -> 0x0028 }
            r2 = 0;
            if (r1 != 0) goto L_0x000e;
        L_0x000c:
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return r2;
        L_0x000e:
            r1 = com.a.a.a.this;	 Catch:{ all -> 0x0028 }
            r1.trimToSize();	 Catch:{ all -> 0x0028 }
            r1 = com.a.a.a.this;	 Catch:{ all -> 0x0028 }
            r1 = r1.journalRebuildRequired();	 Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0026;
        L_0x001b:
            r1 = com.a.a.a.this;	 Catch:{ all -> 0x0028 }
            r1.rebuildJournal();	 Catch:{ all -> 0x0028 }
            r1 = com.a.a.a.this;	 Catch:{ all -> 0x0028 }
            r3 = 0;
            r1.redundantOpCount = r3;	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            return r2;
        L_0x0028:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0028 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.1.call():java.lang.Void");
        }
    };
    private final File directory;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private final LinkedHashMap<String, b> lruEntries = new LinkedHashMap(0, 0.75f, true);
    private long maxSize;
    private long nextSequenceNumber = 0;
    private int redundantOpCount;
    private long size = 0;
    private final int valueCount;

    /* compiled from: DiskLruCache */
    public final class a {
        private final b dTO;
        private boolean dTP;
        private boolean hasErrors;
        private final boolean[] written;

        /* compiled from: DiskLruCache */
        private class a extends FilterOutputStream {
            /* synthetic */ a(a aVar, OutputStream outputStream, AnonymousClass1 anonymousClass1) {
                this(outputStream);
            }

            private a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    a.this.hasErrors = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    a.this.hasErrors = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    a.this.hasErrors = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    a.this.hasErrors = true;
                }
            }
        }

        /* synthetic */ a(a aVar, b bVar, AnonymousClass1 anonymousClass1) {
            this(bVar);
        }

        private a(b bVar) {
            this.dTO = bVar;
            this.written = bVar.readable ? null : new boolean[a.this.valueCount];
        }

        public OutputStream hF(int i) {
            OutputStream aVar;
            synchronized (a.this) {
                if (this.dTO.dTR != this) {
                    throw new IllegalStateException();
                }
                if (!this.dTO.readable) {
                    this.written[i] = true;
                }
                File hH = this.dTO.hH(i);
                OutputStream fileOutputStream = new FileOutputStream(hH);
                try {
                } catch (FileNotFoundException unused) {
                    a.this.directory.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(hH);
                        aVar = new a(this, fileOutputStream, null);
                        return aVar;
                    } catch (FileNotFoundException unused2) {
                        return a.Un;
                    }
                }
            }
            return aVar;
        }

        public void commit() {
            if (this.hasErrors) {
                a.this.a(this, false);
                a.this.remove(this.dTO.key);
            } else {
                a.this.a(this, true);
            }
            this.dTP = true;
        }

        public void abort() {
            a.this.a(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.dTP) {
                try {
                    abort();
                } catch (IOException unused) {
                }
            }
        }
    }

    /* compiled from: DiskLruCache */
    private final class b {
        private a dTR;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        /* synthetic */ b(a aVar, String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private b(String str) {
            this.key = str;
            this.lengths = new long[a.this.valueCount];
        }

        public String aOA() {
            StringBuilder stringBuilder = new StringBuilder();
            for (long j : this.lengths) {
                stringBuilder.append(' ');
                stringBuilder.append(j);
            }
            return stringBuilder.toString();
        }

        private void setLengths(String[] strArr) {
            if (strArr.length != a.this.valueCount) {
                throw invalidLengths(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        private IOException invalidLengths(String[] strArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(strArr));
            throw new IOException(stringBuilder.toString());
        }

        public File hG(int i) {
            File f = a.this.directory;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.key);
            stringBuilder.append(".");
            stringBuilder.append(i);
            return new File(f, stringBuilder.toString());
        }

        public File hH(int i) {
            File f = a.this.directory;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.key);
            stringBuilder.append(".");
            stringBuilder.append(i);
            stringBuilder.append(".tmp");
            return new File(f, stringBuilder.toString());
        }
    }

    /* compiled from: DiskLruCache */
    public final class c implements Closeable {
        private final InputStream[] dTS;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        /* synthetic */ c(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, AnonymousClass1 anonymousClass1) {
            this(str, j, inputStreamArr, jArr);
        }

        private c(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.dTS = inputStreamArr;
            this.lengths = jArr;
        }

        public InputStream hI(int i) {
            return this.dTS[i];
        }

        public void close() {
            for (Closeable closeQuietly : this.dTS) {
                c.closeQuietly(closeQuietly);
            }
        }
    }

    private a(File file, int i, int i2, long j) {
        File file2 = file;
        this.directory = file2;
        this.appVersion = i;
        this.journalFile = new File(file2, "journal");
        this.journalFileTmp = new File(file2, "journal.tmp");
        this.journalFileBackup = new File(file2, "journal.bkp");
        this.valueCount = i2;
        this.maxSize = j;
    }

    public static a a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j);
            if (aVar.journalFile.exists()) {
                try {
                    aVar.readJournal();
                    aVar.processJournal();
                    aVar.dTK = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.journalFile, true), c.US_ASCII));
                    return aVar;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("DiskLruCache ");
                    stringBuilder.append(file);
                    stringBuilder.append(" is corrupt: ");
                    stringBuilder.append(e.getMessage());
                    stringBuilder.append(", removing");
                    printStream.println(stringBuilder.toString());
                    aVar.delete();
                }
            }
            file.mkdirs();
            aVar = new a(file, i, i2, j);
            aVar.rebuildJournal();
            return aVar;
        }
    }

    private void readJournal() {
        Closeable bVar = new b(new FileInputStream(this.journalFile), c.US_ASCII);
        int i;
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if ("libcore.io.DiskLruCache".equals(readLine) && "1".equals(readLine2) && Integer.toString(this.appVersion).equals(readLine3) && Integer.toString(this.valueCount).equals(readLine4) && "".equals(readLine5)) {
                i = 0;
                while (true) {
                    readJournalLine(bVar.readLine());
                    i++;
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected journal header: [");
                stringBuilder.append(readLine);
                stringBuilder.append(", ");
                stringBuilder.append(readLine2);
                stringBuilder.append(", ");
                stringBuilder.append(readLine4);
                stringBuilder.append(", ");
                stringBuilder.append(readLine5);
                stringBuilder.append("]");
                throw new IOException(stringBuilder.toString());
            }
        } catch (EOFException unused) {
            this.redundantOpCount = i - this.lruEntries.size();
            c.closeQuietly(bVar);
        } catch (Throwable th) {
            c.closeQuietly(bVar);
        }
    }

    private void readJournalLine(String str) {
        int indexOf = str.indexOf(32);
        StringBuilder stringBuilder;
        if (indexOf == -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(str);
            throw new IOException(stringBuilder.toString());
        }
        String substring;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.lruEntries.remove(substring);
                return;
            }
        }
        substring = str.substring(i, indexOf2);
        b bVar = (b) this.lruEntries.get(substring);
        if (bVar == null) {
            bVar = new b(this, substring, null);
            this.lruEntries.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            bVar.readable = true;
            bVar.dTR = null;
            bVar.setLengths(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            bVar.dTR = new a(this, bVar, null);
        } else if (!(indexOf2 == -1 && indexOf == "READ".length() && str.startsWith("READ"))) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(str);
            throw new IOException(stringBuilder.toString());
        }
    }

    private void processJournal() {
        u(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            int i = 0;
            if (bVar.dTR == null) {
                while (i < this.valueCount) {
                    this.size += bVar.lengths[i];
                    i++;
                }
            } else {
                bVar.dTR = null;
                while (i < this.valueCount) {
                    u(bVar.hG(i));
                    u(bVar.hH(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private synchronized void rebuildJournal() {
        if (this.dTK != null) {
            this.dTK.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), c.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.valueCount));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.lruEntries.values()) {
                StringBuilder stringBuilder;
                if (bVar.dTR != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("DIRTY ");
                    stringBuilder.append(bVar.key);
                    stringBuilder.append(10);
                    bufferedWriter.write(stringBuilder.toString());
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("CLEAN ");
                    stringBuilder.append(bVar.key);
                    stringBuilder.append(bVar.aOA());
                    stringBuilder.append(10);
                    bufferedWriter.write(stringBuilder.toString());
                }
            }
            if (this.journalFile.exists()) {
                a(this.journalFile, this.journalFileBackup, true);
            }
            a(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.dTK = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), c.US_ASCII));
        } finally {
            bufferedWriter.close();
        }
    }

    private static void u(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            u(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Missing block: B:21:?, code:
            r11.redundantOpCount++;
            r1 = r11.dTK;
            r2 = new java.lang.StringBuilder();
            r2.append("READ ");
            r2.append(r12);
            r2.append(10);
            r1.append(r2.toString());
     */
    /* JADX WARNING: Missing block: B:22:0x0059, code:
            if (journalRebuildRequired() == false) goto L_0x0062;
     */
    /* JADX WARNING: Missing block: B:23:0x005b, code:
            r11.dTL.submit(r11.dTM);
     */
    /* JADX WARNING: Missing block: B:26:0x0074, code:
            return new com.a.a.a.c(r11, r12, com.a.a.a.b.e(r0), r8, com.a.a.a.b.b(r0), null);
     */
    public synchronized com.a.a.a.c gt(java.lang.String r12) {
        /*
        r11 = this;
        monitor-enter(r11);
        r11.checkNotClosed();	 Catch:{ all -> 0x0087 }
        r11.validateKey(r12);	 Catch:{ all -> 0x0087 }
        r0 = r11.lruEntries;	 Catch:{ all -> 0x0087 }
        r0 = r0.get(r12);	 Catch:{ all -> 0x0087 }
        r0 = (com.a.a.a.b) r0;	 Catch:{ all -> 0x0087 }
        r1 = 0;
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        monitor-exit(r11);
        return r1;
    L_0x0014:
        r2 = r0.readable;	 Catch:{ all -> 0x0087 }
        if (r2 != 0) goto L_0x001c;
    L_0x001a:
        monitor-exit(r11);
        return r1;
    L_0x001c:
        r2 = r11.valueCount;	 Catch:{ all -> 0x0087 }
        r8 = new java.io.InputStream[r2];	 Catch:{ all -> 0x0087 }
        r2 = 0;
        r3 = 0;
    L_0x0022:
        r4 = r11.valueCount;	 Catch:{ FileNotFoundException -> 0x0075 }
        if (r3 >= r4) goto L_0x0034;
    L_0x0026:
        r4 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0075 }
        r5 = r0.hG(r3);	 Catch:{ FileNotFoundException -> 0x0075 }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0075 }
        r8[r3] = r4;	 Catch:{ FileNotFoundException -> 0x0075 }
        r3 = r3 + 1;
        goto L_0x0022;
    L_0x0034:
        r1 = r11.redundantOpCount;	 Catch:{ all -> 0x0087 }
        r1 = r1 + 1;
        r11.redundantOpCount = r1;	 Catch:{ all -> 0x0087 }
        r1 = r11.dTK;	 Catch:{ all -> 0x0087 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0087 }
        r2.<init>();	 Catch:{ all -> 0x0087 }
        r3 = "READ ";
        r2.append(r3);	 Catch:{ all -> 0x0087 }
        r2.append(r12);	 Catch:{ all -> 0x0087 }
        r3 = 10;
        r2.append(r3);	 Catch:{ all -> 0x0087 }
        r2 = r2.toString();	 Catch:{ all -> 0x0087 }
        r1.append(r2);	 Catch:{ all -> 0x0087 }
        r1 = r11.journalRebuildRequired();	 Catch:{ all -> 0x0087 }
        if (r1 == 0) goto L_0x0062;
    L_0x005b:
        r1 = r11.dTL;	 Catch:{ all -> 0x0087 }
        r2 = r11.dTM;	 Catch:{ all -> 0x0087 }
        r1.submit(r2);	 Catch:{ all -> 0x0087 }
    L_0x0062:
        r1 = new com.a.a.a$c;	 Catch:{ all -> 0x0087 }
        r6 = r0.sequenceNumber;	 Catch:{ all -> 0x0087 }
        r9 = r0.lengths;	 Catch:{ all -> 0x0087 }
        r10 = 0;
        r3 = r1;
        r4 = r11;
        r5 = r12;
        r3.<init>(r4, r5, r6, r8, r9, r10);	 Catch:{ all -> 0x0087 }
        monitor-exit(r11);
        return r1;
    L_0x0075:
        r12 = r11.valueCount;	 Catch:{ all -> 0x0087 }
        if (r2 >= r12) goto L_0x0085;
    L_0x0079:
        r12 = r8[r2];	 Catch:{ all -> 0x0087 }
        if (r12 == 0) goto L_0x0085;
    L_0x007d:
        r12 = r8[r2];	 Catch:{ all -> 0x0087 }
        com.a.a.c.closeQuietly(r12);	 Catch:{ all -> 0x0087 }
        r2 = r2 + 1;
        goto L_0x0075;
    L_0x0085:
        monitor-exit(r11);
        return r1;
    L_0x0087:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.gt(java.lang.String):com.a.a.a$c");
    }

    public a kB(String str) {
        return k(str, -1);
    }

    /* JADX WARNING: Missing block: B:9:0x0021, code:
            return null;
     */
    private synchronized com.a.a.a.a k(java.lang.String r6, long r7) {
        /*
        r5 = this;
        monitor-enter(r5);
        r5.checkNotClosed();	 Catch:{ all -> 0x0061 }
        r5.validateKey(r6);	 Catch:{ all -> 0x0061 }
        r0 = r5.lruEntries;	 Catch:{ all -> 0x0061 }
        r0 = r0.get(r6);	 Catch:{ all -> 0x0061 }
        r0 = (com.a.a.a.b) r0;	 Catch:{ all -> 0x0061 }
        r1 = -1;
        r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
        r1 = 0;
        if (r3 == 0) goto L_0x0022;
    L_0x0016:
        if (r0 == 0) goto L_0x0020;
    L_0x0018:
        r2 = r0.sequenceNumber;	 Catch:{ all -> 0x0061 }
        r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r4 == 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r5);
        return r1;
    L_0x0022:
        if (r0 != 0) goto L_0x002f;
    L_0x0024:
        r0 = new com.a.a.a$b;	 Catch:{ all -> 0x0061 }
        r0.<init>(r5, r6, r1);	 Catch:{ all -> 0x0061 }
        r7 = r5.lruEntries;	 Catch:{ all -> 0x0061 }
        r7.put(r6, r0);	 Catch:{ all -> 0x0061 }
        goto L_0x0037;
    L_0x002f:
        r7 = r0.dTR;	 Catch:{ all -> 0x0061 }
        if (r7 == 0) goto L_0x0037;
    L_0x0035:
        monitor-exit(r5);
        return r1;
    L_0x0037:
        r7 = new com.a.a.a$a;	 Catch:{ all -> 0x0061 }
        r7.<init>(r5, r0, r1);	 Catch:{ all -> 0x0061 }
        r0.dTR = r7;	 Catch:{ all -> 0x0061 }
        r8 = r5.dTK;	 Catch:{ all -> 0x0061 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0061 }
        r0.<init>();	 Catch:{ all -> 0x0061 }
        r1 = "DIRTY ";
        r0.append(r1);	 Catch:{ all -> 0x0061 }
        r0.append(r6);	 Catch:{ all -> 0x0061 }
        r6 = 10;
        r0.append(r6);	 Catch:{ all -> 0x0061 }
        r6 = r0.toString();	 Catch:{ all -> 0x0061 }
        r8.write(r6);	 Catch:{ all -> 0x0061 }
        r6 = r5.dTK;	 Catch:{ all -> 0x0061 }
        r6.flush();	 Catch:{ all -> 0x0061 }
        monitor-exit(r5);
        return r7;
    L_0x0061:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.k(java.lang.String, long):com.a.a.a$a");
    }

    /* JADX WARNING: Missing block: B:45:0x0113, code:
            return;
     */
    private synchronized void a(com.a.a.a.a r12, boolean r13) {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = r12.dTO;	 Catch:{ all -> 0x0114 }
        r1 = r0.dTR;	 Catch:{ all -> 0x0114 }
        if (r1 == r12) goto L_0x0011;
    L_0x000b:
        r12 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0114 }
        r12.<init>();	 Catch:{ all -> 0x0114 }
        throw r12;	 Catch:{ all -> 0x0114 }
    L_0x0011:
        r1 = 0;
        if (r13 == 0) goto L_0x0053;
    L_0x0014:
        r2 = r0.readable;	 Catch:{ all -> 0x0114 }
        if (r2 != 0) goto L_0x0053;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r3 = r11.valueCount;	 Catch:{ all -> 0x0114 }
        if (r2 >= r3) goto L_0x0053;
    L_0x001f:
        r3 = r12.written;	 Catch:{ all -> 0x0114 }
        r3 = r3[r2];	 Catch:{ all -> 0x0114 }
        if (r3 != 0) goto L_0x0041;
    L_0x0027:
        r12.abort();	 Catch:{ all -> 0x0114 }
        r12 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0114 }
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0114 }
        r13.<init>();	 Catch:{ all -> 0x0114 }
        r0 = "Newly created entry didn't create value for index ";
        r13.append(r0);	 Catch:{ all -> 0x0114 }
        r13.append(r2);	 Catch:{ all -> 0x0114 }
        r13 = r13.toString();	 Catch:{ all -> 0x0114 }
        r12.<init>(r13);	 Catch:{ all -> 0x0114 }
        throw r12;	 Catch:{ all -> 0x0114 }
    L_0x0041:
        r3 = r0.hH(r2);	 Catch:{ all -> 0x0114 }
        r3 = r3.exists();	 Catch:{ all -> 0x0114 }
        if (r3 != 0) goto L_0x0050;
    L_0x004b:
        r12.abort();	 Catch:{ all -> 0x0114 }
        monitor-exit(r11);
        return;
    L_0x0050:
        r2 = r2 + 1;
        goto L_0x001b;
    L_0x0053:
        r12 = r11.valueCount;	 Catch:{ all -> 0x0114 }
        if (r1 >= r12) goto L_0x008a;
    L_0x0057:
        r12 = r0.hH(r1);	 Catch:{ all -> 0x0114 }
        if (r13 == 0) goto L_0x0084;
    L_0x005d:
        r2 = r12.exists();	 Catch:{ all -> 0x0114 }
        if (r2 == 0) goto L_0x0087;
    L_0x0063:
        r2 = r0.hG(r1);	 Catch:{ all -> 0x0114 }
        r12.renameTo(r2);	 Catch:{ all -> 0x0114 }
        r12 = r0.lengths;	 Catch:{ all -> 0x0114 }
        r3 = r12[r1];	 Catch:{ all -> 0x0114 }
        r5 = r2.length();	 Catch:{ all -> 0x0114 }
        r12 = r0.lengths;	 Catch:{ all -> 0x0114 }
        r12[r1] = r5;	 Catch:{ all -> 0x0114 }
        r7 = r11.size;	 Catch:{ all -> 0x0114 }
        r12 = 0;
        r9 = r7 - r3;
        r2 = r9 + r5;
        r11.size = r2;	 Catch:{ all -> 0x0114 }
        goto L_0x0087;
    L_0x0084:
        u(r12);	 Catch:{ all -> 0x0114 }
    L_0x0087:
        r1 = r1 + 1;
        goto L_0x0053;
    L_0x008a:
        r12 = r11.redundantOpCount;	 Catch:{ all -> 0x0114 }
        r1 = 1;
        r12 = r12 + r1;
        r11.redundantOpCount = r12;	 Catch:{ all -> 0x0114 }
        r12 = 0;
        r0.dTR = r12;	 Catch:{ all -> 0x0114 }
        r12 = r0.readable;	 Catch:{ all -> 0x0114 }
        r12 = r12 | r13;
        r2 = 10;
        if (r12 == 0) goto L_0x00d2;
    L_0x009d:
        r0.readable = r1;	 Catch:{ all -> 0x0114 }
        r12 = r11.dTK;	 Catch:{ all -> 0x0114 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0114 }
        r1.<init>();	 Catch:{ all -> 0x0114 }
        r3 = "CLEAN ";
        r1.append(r3);	 Catch:{ all -> 0x0114 }
        r3 = r0.key;	 Catch:{ all -> 0x0114 }
        r1.append(r3);	 Catch:{ all -> 0x0114 }
        r3 = r0.aOA();	 Catch:{ all -> 0x0114 }
        r1.append(r3);	 Catch:{ all -> 0x0114 }
        r1.append(r2);	 Catch:{ all -> 0x0114 }
        r1 = r1.toString();	 Catch:{ all -> 0x0114 }
        r12.write(r1);	 Catch:{ all -> 0x0114 }
        if (r13 == 0) goto L_0x00f8;
    L_0x00c6:
        r12 = r11.nextSequenceNumber;	 Catch:{ all -> 0x0114 }
        r1 = 1;
        r3 = r12 + r1;
        r11.nextSequenceNumber = r3;	 Catch:{ all -> 0x0114 }
        r0.sequenceNumber = r12;	 Catch:{ all -> 0x0114 }
        goto L_0x00f8;
    L_0x00d2:
        r12 = r11.lruEntries;	 Catch:{ all -> 0x0114 }
        r13 = r0.key;	 Catch:{ all -> 0x0114 }
        r12.remove(r13);	 Catch:{ all -> 0x0114 }
        r12 = r11.dTK;	 Catch:{ all -> 0x0114 }
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0114 }
        r13.<init>();	 Catch:{ all -> 0x0114 }
        r1 = "REMOVE ";
        r13.append(r1);	 Catch:{ all -> 0x0114 }
        r0 = r0.key;	 Catch:{ all -> 0x0114 }
        r13.append(r0);	 Catch:{ all -> 0x0114 }
        r13.append(r2);	 Catch:{ all -> 0x0114 }
        r13 = r13.toString();	 Catch:{ all -> 0x0114 }
        r12.write(r13);	 Catch:{ all -> 0x0114 }
    L_0x00f8:
        r12 = r11.dTK;	 Catch:{ all -> 0x0114 }
        r12.flush();	 Catch:{ all -> 0x0114 }
        r12 = r11.size;	 Catch:{ all -> 0x0114 }
        r0 = r11.maxSize;	 Catch:{ all -> 0x0114 }
        r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x010b;
    L_0x0105:
        r12 = r11.journalRebuildRequired();	 Catch:{ all -> 0x0114 }
        if (r12 == 0) goto L_0x0112;
    L_0x010b:
        r12 = r11.dTL;	 Catch:{ all -> 0x0114 }
        r13 = r11.dTM;	 Catch:{ all -> 0x0114 }
        r12.submit(r13);	 Catch:{ all -> 0x0114 }
    L_0x0112:
        monitor-exit(r11);
        return;
    L_0x0114:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.a(com.a.a.a$a, boolean):void");
    }

    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    /* JADX WARNING: Missing block: B:19:0x0091, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:21:0x0093, code:
            return false;
     */
    public synchronized boolean remove(java.lang.String r10) {
        /*
        r9 = this;
        monitor-enter(r9);
        r9.checkNotClosed();	 Catch:{ all -> 0x0094 }
        r9.validateKey(r10);	 Catch:{ all -> 0x0094 }
        r0 = r9.lruEntries;	 Catch:{ all -> 0x0094 }
        r0 = r0.get(r10);	 Catch:{ all -> 0x0094 }
        r0 = (com.a.a.a.b) r0;	 Catch:{ all -> 0x0094 }
        r1 = 0;
        if (r0 == 0) goto L_0x0092;
    L_0x0012:
        r2 = r0.dTR;	 Catch:{ all -> 0x0094 }
        if (r2 == 0) goto L_0x001a;
    L_0x0018:
        goto L_0x0092;
    L_0x001a:
        r2 = r9.valueCount;	 Catch:{ all -> 0x0094 }
        if (r1 >= r2) goto L_0x005d;
    L_0x001e:
        r2 = r0.hG(r1);	 Catch:{ all -> 0x0094 }
        r3 = r2.exists();	 Catch:{ all -> 0x0094 }
        if (r3 == 0) goto L_0x0045;
    L_0x0028:
        r3 = r2.delete();	 Catch:{ all -> 0x0094 }
        if (r3 != 0) goto L_0x0045;
    L_0x002e:
        r10 = new java.io.IOException;	 Catch:{ all -> 0x0094 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0094 }
        r0.<init>();	 Catch:{ all -> 0x0094 }
        r1 = "failed to delete ";
        r0.append(r1);	 Catch:{ all -> 0x0094 }
        r0.append(r2);	 Catch:{ all -> 0x0094 }
        r0 = r0.toString();	 Catch:{ all -> 0x0094 }
        r10.<init>(r0);	 Catch:{ all -> 0x0094 }
        throw r10;	 Catch:{ all -> 0x0094 }
    L_0x0045:
        r2 = r9.size;	 Catch:{ all -> 0x0094 }
        r4 = r0.lengths;	 Catch:{ all -> 0x0094 }
        r5 = r4[r1];	 Catch:{ all -> 0x0094 }
        r4 = 0;
        r7 = r2 - r5;
        r9.size = r7;	 Catch:{ all -> 0x0094 }
        r2 = r0.lengths;	 Catch:{ all -> 0x0094 }
        r3 = 0;
        r2[r1] = r3;	 Catch:{ all -> 0x0094 }
        r1 = r1 + 1;
        goto L_0x001a;
    L_0x005d:
        r0 = r9.redundantOpCount;	 Catch:{ all -> 0x0094 }
        r1 = 1;
        r0 = r0 + r1;
        r9.redundantOpCount = r0;	 Catch:{ all -> 0x0094 }
        r0 = r9.dTK;	 Catch:{ all -> 0x0094 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0094 }
        r2.<init>();	 Catch:{ all -> 0x0094 }
        r3 = "REMOVE ";
        r2.append(r3);	 Catch:{ all -> 0x0094 }
        r2.append(r10);	 Catch:{ all -> 0x0094 }
        r3 = 10;
        r2.append(r3);	 Catch:{ all -> 0x0094 }
        r2 = r2.toString();	 Catch:{ all -> 0x0094 }
        r0.append(r2);	 Catch:{ all -> 0x0094 }
        r0 = r9.lruEntries;	 Catch:{ all -> 0x0094 }
        r0.remove(r10);	 Catch:{ all -> 0x0094 }
        r10 = r9.journalRebuildRequired();	 Catch:{ all -> 0x0094 }
        if (r10 == 0) goto L_0x0090;
    L_0x0089:
        r10 = r9.dTL;	 Catch:{ all -> 0x0094 }
        r0 = r9.dTM;	 Catch:{ all -> 0x0094 }
        r10.submit(r0);	 Catch:{ all -> 0x0094 }
    L_0x0090:
        monitor-exit(r9);
        return r1;
    L_0x0092:
        monitor-exit(r9);
        return r1;
    L_0x0094:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.remove(java.lang.String):boolean");
    }

    private void checkNotClosed() {
        if (this.dTK == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() {
        if (this.dTK != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.dTR != null) {
                    bVar.dTR.abort();
                }
            }
            trimToSize();
            this.dTK.close();
            this.dTK = null;
        }
    }

    private void trimToSize() {
        while (this.size > this.maxSize) {
            remove((String) ((Entry) this.lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    public void delete() {
        close();
        c.deleteContents(this.directory);
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("keys must match regex [a-z0-9_-]{1,64}: \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
