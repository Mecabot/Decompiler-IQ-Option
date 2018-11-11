package com.firebase.jobdispatcher;

import android.support.annotation.VisibleForTesting;

/* compiled from: Constraint */
public final class a {
    @VisibleForTesting
    static final int[] JG = new int[]{2, 1, 4, 8};

    static int f(int[] iArr) {
        int i = 0;
        if (iArr == null) {
            return 0;
        }
        int i2 = 0;
        while (i < iArr.length) {
            i2 |= iArr[i];
            i++;
        }
        return i2;
    }

    static int[] am(int i) {
        int i2 = 0;
        for (int i3 : JG) {
            i2 += (i & i3) == i3 ? 1 : 0;
        }
        int[] iArr = new int[i2];
        i2 = 0;
        for (int i32 : JG) {
            if ((i & i32) == i32) {
                int i4 = i2 + 1;
                iArr[i2] = i32;
                i2 = i4;
            }
        }
        return iArr;
    }
}
