package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ReLinker */
class i {
    private static final String fkV = System.mapLibraryName("pl_droidsonroids_gif");

    private i() {
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    static void cU(Context context) {
        synchronized (i.class) {
            System.load(cV(context).getAbsolutePath());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c3 A:{SYNTHETIC, Splitter: B:46:0x00c3} */
    /* JADX WARNING: Missing block: B:23:?, code:
            d(r3);
            d(r5);
            C(r1);
     */
    private static java.io.File cV(android.content.Context r8) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = fkV;
        r0.append(r1);
        r1 = "1.2.12";
        r0.append(r1);
        r0 = r0.toString();
        r1 = new java.io.File;
        r2 = "lib";
        r3 = 0;
        r2 = r8.getDir(r2, r3);
        r1.<init>(r2, r0);
        r2 = r1.isFile();
        if (r2 == 0) goto L_0x0026;
    L_0x0025:
        return r1;
    L_0x0026:
        r2 = new java.io.File;
        r4 = r8.getCacheDir();
        r2.<init>(r4, r0);
        r0 = r2.isFile();
        if (r0 == 0) goto L_0x0036;
    L_0x0035:
        return r2;
    L_0x0036:
        r0 = "pl_droidsonroids_gif_surface";
        r0 = java.lang.System.mapLibraryName(r0);
        r4 = new pl.droidsonroids.gif.i$1;
        r4.<init>(r0);
        b(r1, r4);
        b(r2, r4);
        r8 = r8.getApplicationInfo();
        r0 = new java.io.File;
        r8 = r8.sourceDir;
        r0.<init>(r8);
        r8 = 0;
        r0 = B(r0);	 Catch:{ all -> 0x00bd }
    L_0x0057:
        r4 = r3 + 1;
        r5 = 5;
        if (r3 >= r5) goto L_0x00b7;
    L_0x005c:
        r3 = a(r0);	 Catch:{ all -> 0x00b5 }
        if (r3 != 0) goto L_0x0080;
    L_0x0062:
        r8 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00b5 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b5 }
        r1.<init>();	 Catch:{ all -> 0x00b5 }
        r2 = "Library ";
        r1.append(r2);	 Catch:{ all -> 0x00b5 }
        r2 = fkV;	 Catch:{ all -> 0x00b5 }
        r1.append(r2);	 Catch:{ all -> 0x00b5 }
        r2 = " for supported ABIs not found in APK file";
        r1.append(r2);	 Catch:{ all -> 0x00b5 }
        r1 = r1.toString();	 Catch:{ all -> 0x00b5 }
        r8.<init>(r1);	 Catch:{ all -> 0x00b5 }
        throw r8;	 Catch:{ all -> 0x00b5 }
    L_0x0080:
        r3 = r0.getInputStream(r3);	 Catch:{ IOException -> 0x00a7, all -> 0x009e }
        r5 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x009c, all -> 0x009a }
        r5.<init>(r1);	 Catch:{ IOException -> 0x009c, all -> 0x009a }
        c(r3, r5);	 Catch:{ IOException -> 0x00a9, all -> 0x0096 }
        d(r3);	 Catch:{ all -> 0x00b5 }
        d(r5);	 Catch:{ all -> 0x00b5 }
        C(r1);	 Catch:{ all -> 0x00b5 }
        goto L_0x00b7;
    L_0x0096:
        r8 = move-exception;
        r1 = r8;
        r8 = r5;
        goto L_0x00a0;
    L_0x009a:
        r1 = move-exception;
        goto L_0x00a0;
    L_0x009c:
        r5 = r8;
        goto L_0x00a9;
    L_0x009e:
        r1 = move-exception;
        r3 = r8;
    L_0x00a0:
        d(r3);	 Catch:{ all -> 0x00b5 }
        d(r8);	 Catch:{ all -> 0x00b5 }
        throw r1;	 Catch:{ all -> 0x00b5 }
    L_0x00a7:
        r3 = r8;
        r5 = r3;
    L_0x00a9:
        r6 = 2;
        if (r4 <= r6) goto L_0x00ad;
    L_0x00ac:
        r1 = r2;
    L_0x00ad:
        d(r3);	 Catch:{ all -> 0x00b5 }
        d(r5);	 Catch:{ all -> 0x00b5 }
        r3 = r4;
        goto L_0x0057;
    L_0x00b5:
        r8 = move-exception;
        goto L_0x00c1;
    L_0x00b7:
        if (r0 == 0) goto L_0x00bc;
    L_0x00b9:
        r0.close();	 Catch:{ IOException -> 0x00bc }
    L_0x00bc:
        return r1;
    L_0x00bd:
        r0 = move-exception;
        r7 = r0;
        r0 = r8;
        r8 = r7;
    L_0x00c1:
        if (r0 == 0) goto L_0x00c6;
    L_0x00c3:
        r0.close();	 Catch:{ IOException -> 0x00c6 }
    L_0x00c6:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.i.cV(android.content.Context):java.io.File");
    }

    private static ZipEntry a(ZipFile zipFile) {
        for (String a : bFM()) {
            ZipEntry a2 = a(zipFile, a);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    private static String[] bFM() {
        if (VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    private static ZipEntry a(ZipFile zipFile, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lib/");
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(fkV);
        return zipFile.getEntry(stringBuilder.toString());
    }

    private static ZipFile B(File file) {
        ZipFile zipFile;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                zipFile = null;
                break;
            }
            try {
                zipFile = new ZipFile(file, 1);
                break;
            } catch (IOException unused) {
                i = i2;
            }
        }
        if (zipFile != null) {
            return zipFile;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not open APK file: ");
        stringBuilder.append(file.getAbsolutePath());
        throw new IllegalStateException(stringBuilder.toString());
    }

    private static void b(File file, FilenameFilter filenameFilter) {
        File[] listFiles = file.getParentFile().listFiles(filenameFilter);
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    @SuppressLint({"SetWorldReadable"})
    private static void C(File file) {
        file.setReadable(true, false);
        file.setExecutable(true, false);
        file.setWritable(true);
    }

    private static void c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
