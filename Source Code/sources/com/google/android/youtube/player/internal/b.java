package com.google.android.youtube.player.internal;

import android.text.TextUtils;

public final class b {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static String c(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static <T> T e(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T u(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }
}
