package androidx.work;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.util.Log;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: Logger */
public class e {
    private static int dU = 4;

    public static void k(int i) {
        dU = i;
    }

    public static void a(String str, String str2, Throwable... thArr) {
        if (dU > 2) {
            return;
        }
        if (thArr == null || thArr.length < 1) {
            Log.v(str, str2);
        } else {
            Log.v(str, str2, thArr[0]);
        }
    }

    public static void b(String str, String str2, Throwable... thArr) {
        if (dU > 3) {
            return;
        }
        if (thArr == null || thArr.length < 1) {
            Log.d(str, str2);
        } else {
            Log.d(str, str2, thArr[0]);
        }
    }

    public static void c(String str, String str2, Throwable... thArr) {
        if (dU > 4) {
            return;
        }
        if (thArr == null || thArr.length < 1) {
            Log.i(str, str2);
        } else {
            Log.i(str, str2, thArr[0]);
        }
    }

    public static void d(String str, String str2, Throwable... thArr) {
        if (dU > 5) {
            return;
        }
        if (thArr == null || thArr.length < 1) {
            Log.w(str, str2);
        } else {
            Log.w(str, str2, thArr[0]);
        }
    }

    public static void e(String str, String str2, Throwable... thArr) {
        if (dU > 6) {
            return;
        }
        if (thArr == null || thArr.length < 1) {
            Log.e(str, str2);
        } else {
            Log.e(str, str2, thArr[0]);
        }
    }
}
