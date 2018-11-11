package com.iqoption.core;

import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import com.crashlytics.android.a;

/* compiled from: Logger */
public final class i {
    private static final boolean DEBUG = f.Dp().DJ();
    public static volatile boolean aMw = false;

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG && !TextUtils.isEmpty(str2)) {
            int i = 0;
            int length;
            if (th != null) {
                if (str2.length() <= 3072 || !aMw) {
                    Log.v(str, str2, th);
                } else {
                    length = str2.length();
                    while (i < length) {
                        int i2 = i + 3072;
                        Log.v(str, str2.substring(i, Math.min(i2, length)), th);
                        i = i2;
                    }
                }
            } else if (str2.length() <= 3072 || !aMw) {
                Log.v(str, str2);
            } else {
                int length2 = str2.length();
                while (i < length2) {
                    length = i + 3072;
                    Log.v(str, str2.substring(i, Math.min(length, length2)));
                    i = length;
                }
            }
        }
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG && !TextUtils.isEmpty(str2)) {
            int i = 0;
            int length;
            if (th != null) {
                if (str2.length() <= 3072) {
                    Log.d(str, str2, th);
                } else {
                    length = str2.length();
                    while (i < length) {
                        int i2 = i + 3072;
                        Log.d(str, str2.substring(i, Math.min(i2, length)), th);
                        i = i2;
                    }
                }
            } else if (str2.length() <= 3072) {
                Log.d(str, str2);
            } else {
                int length2 = str2.length();
                while (i < length2) {
                    length = i + 3072;
                    Log.d(str, str2.substring(i, Math.min(length, length2)));
                    i = length;
                }
            }
        }
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, Throwable th) {
        d("Core", str, th);
    }

    public static void d(String str) {
        d("Core", str, null);
    }

    public static void i(String str, String str2, Throwable th) {
        if (DEBUG && !TextUtils.isEmpty(str2)) {
            int i = 0;
            int length;
            if (th != null) {
                if (str2.length() <= 3072) {
                    Log.i(str, str2, th);
                } else {
                    length = str2.length();
                    while (i < length) {
                        int i2 = i + 3072;
                        Log.i(str, str2.substring(i, Math.min(i2, length)), th);
                        i = i2;
                    }
                }
            } else if (str2.length() <= 3072) {
                Log.i(str, str2);
            } else {
                int length2 = str2.length();
                while (i < length2) {
                    length = i + 3072;
                    Log.i(str, str2.substring(i, Math.min(length, length2)));
                    i = length;
                }
            }
        }
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void w(String str, String str2, Throwable th) {
        if (DEBUG && !TextUtils.isEmpty(str2)) {
            int i = 0;
            int length;
            if (th != null) {
                if (str2.length() <= 3072) {
                    Log.w(str, str2, th);
                } else {
                    length = str2.length();
                    while (i < length) {
                        int i2 = i + 3072;
                        Log.w(str, str2.substring(i, Math.min(i2, length)), th);
                        i = i2;
                    }
                }
            } else if (str2.length() <= 3072) {
                Log.w(str, str2);
            } else {
                int length2 = str2.length();
                while (i < length2) {
                    length = i + 3072;
                    Log.w(str, str2.substring(i, Math.min(length, length2)));
                    i = length;
                }
            }
        }
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void w(String str, Throwable th) {
        w("Core", str, th);
    }

    public static void w(String str) {
        w("Core", str, null);
    }

    public static void e(String str, String str2, Throwable th) {
        if (DEBUG && !TextUtils.isEmpty(str2)) {
            int i = 0;
            int length;
            if (th != null) {
                if (str2.length() <= 3072) {
                    Log.e(str, str2, th);
                } else {
                    length = str2.length();
                    while (i < length) {
                        int i2 = i + 3072;
                        Log.e(str, str2.substring(i, Math.min(i2, length)), th);
                        i = i2;
                    }
                }
            } else if (str2.length() <= 3072) {
                Log.e(str, str2);
            } else {
                int length2 = str2.length();
                while (i < length2) {
                    length = i + 3072;
                    Log.e(str, str2.substring(i, Math.min(length, length2)));
                    i = length;
                }
            }
        }
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, Throwable th) {
        e("Core", str, th);
    }

    public static void e(String str) {
        e("Core", str, null);
    }

    public static void c(FragmentManager fragmentManager) {
        if (DEBUG) {
            for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("back stack entry ");
                stringBuilder.append(i);
                stringBuilder.append(": ");
                stringBuilder.append(fragmentManager.getBackStackEntryAt(i).getName());
                v("FragmentManager", stringBuilder.toString());
            }
        }
    }

    public static void r(Throwable th) {
        a.c(th);
    }

    public static void fZ(String str) {
        a.log(str);
    }
}
