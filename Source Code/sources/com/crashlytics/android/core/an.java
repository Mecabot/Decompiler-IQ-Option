package com.crashlytics.android.core;

import java.util.HashMap;
import java.util.Map;

/* compiled from: RemoveRepeatsStrategy */
class an implements as {
    private final int vP;

    public an() {
        this(1);
    }

    public an(int i) {
        this.vP = i;
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] a = a(stackTraceElementArr, this.vP);
        return a.length < stackTraceElementArr.length ? a : stackTraceElementArr;
    }

    private static StackTraceElement[] a(StackTraceElement[] stackTraceElementArr, int i) {
        Map hashMap = new HashMap();
        Object obj = new StackTraceElement[stackTraceElementArr.length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < stackTraceElementArr.length) {
            int i5;
            Object obj2 = stackTraceElementArr[i2];
            Integer num = (Integer) hashMap.get(obj2);
            if (num == null || !a(stackTraceElementArr, num.intValue(), i2)) {
                obj[i3] = stackTraceElementArr[i2];
                i3++;
                i5 = i2;
                i4 = 1;
            } else {
                i5 = i2 - num.intValue();
                if (i4 < i) {
                    System.arraycopy(stackTraceElementArr, i2, obj, i3, i5);
                    i3 += i5;
                    i4++;
                }
                i5 = (i5 - 1) + i2;
            }
            hashMap.put(obj2, Integer.valueOf(i2));
            i2 = i5 + 1;
        }
        Object obj3 = new StackTraceElement[i3];
        System.arraycopy(obj, 0, obj3, 0, obj3.length);
        return obj3;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, int i, int i2) {
        int i3 = i2 - i;
        if (i2 + i3 > stackTraceElementArr.length) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!stackTraceElementArr[i + i4].equals(stackTraceElementArr[i2 + i4])) {
                return false;
            }
        }
        return true;
    }
}
