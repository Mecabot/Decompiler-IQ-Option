package com.iqoption.system.d;

import android.os.SystemClock;
import com.iqoption.core.i;
import com.iqoption.dto.ToastEntity;
import java.io.IOException;

/* compiled from: NtpTime */
public class a {
    private static final String TAG = "com.iqoption.system.d.a";
    private static final a dsf = new a();
    private static final b dsg = new b();
    private static final String[] dsi = new String[]{"0.pool.ntp.org", "1.pool.ntp.org", "2.pool.ntp.org", "3.pool.ntp.org"};

    public static long bZ(long j) {
        if (isInitialized()) {
            return aEy() + (j - aEx());
        }
        throw new IllegalStateException("You need to call init() on NtpTime at least once.");
    }

    public static long ca(long j) {
        if (isInitialized()) {
            return bZ(j);
        }
        return System.currentTimeMillis() + (j - SystemClock.elapsedRealtime());
    }

    public static boolean isInitialized() {
        return dsg.aEz();
    }

    public static a aEv() {
        return dsf;
    }

    public void initialize() {
        if (isInitialized()) {
            i.i(TAG, "---- NtpTime already initialized from previous boot/init");
        } else {
            aEw();
        }
    }

    long[] aEw() {
        String[] strArr = dsi;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                return dsg.N(str, ToastEntity.ACTION_TOAST_DURATION);
            } catch (Exception unused) {
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("---- SNTP request failed for ");
                stringBuilder.append(str);
                i.d(str2, stringBuilder.toString());
                i++;
            }
        }
        throw new IOException("SNTP request failed");
    }

    private static long aEx() {
        return dsg.aEB();
    }

    private static long aEy() {
        return dsg.aEA();
    }
}
