package com.google.common.collect;

import com.google.common.base.i;

/* compiled from: CollectPreconditions */
final class g {
    static void n(Object obj, Object obj2) {
        StringBuilder stringBuilder;
        if (obj == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("null key in entry: null=");
            stringBuilder.append(obj2);
            throw new NullPointerException(stringBuilder.toString());
        } else if (obj2 == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("null value in entry: ");
            stringBuilder.append(obj);
            stringBuilder.append("=null");
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    static int b(int i, String str) {
        if (i >= 0) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" cannot be negative but was: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static void c(int i, String str) {
        if (i <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" must be positive but was: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    static void ac(boolean z) {
        i.a(z, "no calls to next() since the last call to remove()");
    }
}
