package com.google.common.c;

import com.google.common.primitives.Ints;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.dto.ToastEntity;
import java.math.RoundingMode;

/* compiled from: IntMath */
public final class b {
    static final byte[] UH = new byte[]{(byte) 9, (byte) 9, (byte) 9, (byte) 8, (byte) 8, (byte) 8, (byte) 7, (byte) 7, (byte) 7, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 5, (byte) 5, (byte) 4, (byte) 4, (byte) 4, (byte) 3, (byte) 3, (byte) 3, (byte) 3, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    static final int[] UI = new int[]{1, 10, 100, 1000, ToastEntity.ALERT_TOAST_DURATION, 100000, 1000000, 10000000, 100000000, 1000000000};
    static final int[] UJ = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
    private static final int[] UK = new int[]{1, 1, 2, 6, 24, ChartTimeInterval.CANDLE_2m, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    static int[] UL = new int[]{ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* compiled from: IntMath */
    /* renamed from: com.google.common.c.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] UN = new int[RoundingMode.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:17:0x0062, code:
            return;
     */
        static {
            /*
            r0 = java.math.RoundingMode.values();
            r0 = r0.length;
            r0 = new int[r0];
            UN = r0;
            r0 = UN;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = java.math.RoundingMode.UNNECESSARY;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = UN;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = java.math.RoundingMode.DOWN;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = UN;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = java.math.RoundingMode.FLOOR;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = UN;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = java.math.RoundingMode.UP;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = UN;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = java.math.RoundingMode.CEILING;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = UN;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = java.math.RoundingMode.HALF_DOWN;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r0 = UN;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = java.math.RoundingMode.HALF_UP;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            r0 = UN;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r1 = java.math.RoundingMode.HALF_EVEN;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0062 }
            r2 = 8;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0062 }
        L_0x0062:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.c.b.1.<clinit>():void");
        }
    }

    static int D(int i, int i2) {
        return (((i - i2) ^ -1) ^ -1) >>> 31;
    }

    public static boolean bw(int i) {
        int i2 = 0;
        int i3 = i > 0 ? 1 : 0;
        if ((i & (i - 1)) == 0) {
            i2 = 1;
        }
        return i3 & i2;
    }

    public static int a(int i, RoundingMode roundingMode) {
        d.p("x", i);
        switch (AnonymousClass1.UN[roundingMode.ordinal()]) {
            case 1:
                d.ae(bw(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + D(-1257966797 >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static int E(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        i = (int) j;
        d.af(j == ((long) i));
        return i;
    }

    public static int F(int i, int i2) {
        return Ints.I(((long) i) + ((long) i2));
    }
}
