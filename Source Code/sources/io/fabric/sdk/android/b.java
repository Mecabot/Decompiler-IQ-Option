package io.fabric.sdk.android;

import android.util.Log;

/* compiled from: DefaultLogger */
public class b implements k {
    private int emb;

    public b(int i) {
        this.emb = i;
    }

    public b() {
        this.emb = 4;
    }

    public boolean isLoggable(String str, int i) {
        return this.emb <= i;
    }

    public void d(String str, String str2, Throwable th) {
        if (isLoggable(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void v(String str, String str2, Throwable th) {
        if (isLoggable(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void i(String str, String str2, Throwable th) {
        if (isLoggable(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void w(String str, String str2, Throwable th) {
        if (isLoggable(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (isLoggable(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void d(String str, String str2) {
        d(str, str2, null);
    }

    public void v(String str, String str2) {
        v(str, str2, null);
    }

    public void i(String str, String str2) {
        i(str, str2, null);
    }

    public void w(String str, String str2) {
        w(str, str2, null);
    }

    public void e(String str, String str2) {
        e(str, str2, null);
    }

    public void e(int i, String str, String str2) {
        a(i, str, str2, false);
    }

    public void a(int i, String str, String str2, boolean z) {
        if (z || isLoggable(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
