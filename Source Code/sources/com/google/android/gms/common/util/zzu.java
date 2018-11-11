package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public final class zzu {
    private static String zzglf;
    private static final int zzglg = Process.myPid();

    public static String zzany() {
        if (zzglf == null) {
            zzglf = zzci(zzglg);
        }
        return zzglf;
    }

    private static String zzci(int i) {
        Throwable th;
        Closeable closeable = null;
        if (i <= 0) {
            return null;
        }
        ThreadPolicy allowThreadDiskReads;
        Closeable bufferedReader;
        try {
            allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            StringBuilder stringBuilder = new StringBuilder(25);
            stringBuilder.append("/proc/");
            stringBuilder.append(i);
            stringBuilder.append("/cmdline");
            bufferedReader = new BufferedReader(new FileReader(stringBuilder.toString()));
            try {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                String trim = bufferedReader.readLine().trim();
                zzp.closeQuietly(bufferedReader);
                return trim;
            } catch (IOException unused) {
                zzp.closeQuietly(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                closeable = bufferedReader;
                zzp.closeQuietly(closeable);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            zzp.closeQuietly(closeable);
            throw th;
        }
    }
}
