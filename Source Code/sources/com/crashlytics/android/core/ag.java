package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NativeFileUtils */
final class ag {
    static byte[] i(File file) {
        Throwable th;
        Closeable closeable = null;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] a = a(fileInputStream);
                CommonUtils.closeQuietly(fileInputStream);
                return a;
            } catch (FileNotFoundException unused) {
                CommonUtils.closeQuietly(fileInputStream);
                return null;
            } catch (IOException unused2) {
                CommonUtils.closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                closeable = fileInputStream;
                CommonUtils.closeQuietly(closeable);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            fileInputStream = null;
        } catch (IOException unused4) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.closeQuietly(closeable);
            throw th;
        }
    }

    private static byte[] a(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static File c(File file, String str) {
        for (File file2 : file.listFiles()) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    static byte[] j(File file) {
        file = c(file, ".dmp");
        return file == null ? new byte[0] : k(file);
    }

    private static byte[] k(File file) {
        return i(file);
    }

    static byte[] a(File file, Context context) {
        File c = c(file, ".maps");
        if (c != null) {
            return c(c, context);
        }
        file = c(file, ".binary_libs");
        return file != null ? b(file, context) : null;
    }

    private static byte[] b(File file, Context context) {
        byte[] i = i(file);
        return (i == null || i.length == 0) ? null : k(context, new String(i));
    }

    private static byte[] c(File file, Context context) {
        Throwable th;
        if (!file.exists()) {
            return null;
        }
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                byte[] a = new c(context, new ar()).a((BufferedReader) bufferedReader);
                CommonUtils.closeQuietly(bufferedReader);
                return a;
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.closeQuietly(bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            CommonUtils.closeQuietly(bufferedReader);
            throw th;
        }
    }

    static byte[] l(File file) {
        file = c(file, ".device_info");
        if (file == null) {
            return null;
        }
        return i(file);
    }

    private static byte[] k(Context context, String str) {
        return new c(context, new ar()).aO(str);
    }
}
