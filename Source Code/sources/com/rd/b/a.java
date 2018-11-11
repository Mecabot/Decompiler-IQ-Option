package com.rd.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Pair;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Orientation;

/* compiled from: CoordinatesUtils */
public class a {
    public static int a(@Nullable com.rd.draw.data.a aVar, int i) {
        if (aVar == null) {
            return 0;
        }
        if (aVar.aTh() == Orientation.HORIZONTAL) {
            return b(aVar, i);
        }
        return c(aVar, i);
    }

    public static int b(@Nullable com.rd.draw.data.a aVar, int i) {
        if (aVar == null) {
            return 0;
        }
        if (aVar.aTh() == Orientation.HORIZONTAL) {
            i = d(aVar, i);
        } else {
            i = a(aVar);
        }
        return i + aVar.getPaddingLeft();
    }

    public static int c(@Nullable com.rd.draw.data.a aVar, int i) {
        if (aVar == null) {
            return 0;
        }
        if (aVar.aTh() == Orientation.HORIZONTAL) {
            i = a(aVar);
        } else {
            i = d(aVar, i);
        }
        return i + aVar.getPaddingTop();
    }

    public static int a(@Nullable com.rd.draw.data.a aVar, float f, float f2) {
        if (aVar == null) {
            return -1;
        }
        if (aVar.aTh() != Orientation.HORIZONTAL) {
            float f3 = f2;
            f2 = f;
            f = f3;
        }
        return b(aVar, f, f2);
    }

    private static int b(@NonNull com.rd.draw.data.a aVar, float f, float f2) {
        int count = aVar.getCount();
        int radius = aVar.getRadius();
        int aSS = aVar.aSS();
        int padding = aVar.getPadding();
        int height = aVar.aTh() == Orientation.HORIZONTAL ? aVar.getHeight() : aVar.getWidth();
        int i = 0;
        int i2 = 0;
        while (i < count) {
            int i3;
            if (i > 0) {
                i3 = padding;
            } else {
                i3 = padding / 2;
            }
            i3 = i2 + (((radius * 2) + (aSS / 2)) + i3);
            Object obj = 1;
            Object obj2 = (f < ((float) i2) || f > ((float) i3)) ? null : 1;
            if (f2 < 0.0f || f2 > ((float) height)) {
                obj = null;
            }
            if (obj2 != null && obj != null) {
                return i;
            }
            i++;
            i2 = i3;
        }
        return -1;
    }

    private static int d(@NonNull com.rd.draw.data.a aVar, int i) {
        int count = aVar.getCount();
        int radius = aVar.getRadius();
        int aSS = aVar.aSS();
        int padding = aVar.getPadding();
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            int i4 = aSS / 2;
            i2 += radius + i4;
            if (i == i3) {
                return i2;
            }
            i2 += (radius + padding) + i4;
        }
        if (aVar.aTi() == AnimationType.DROP) {
            i2 += radius * 2;
        }
        return i2;
    }

    private static int a(@NonNull com.rd.draw.data.a aVar) {
        int radius = aVar.getRadius();
        return aVar.aTi() == AnimationType.DROP ? radius * 3 : radius;
    }

    public static Pair<Integer, Float> a(@NonNull com.rd.draw.data.a aVar, int i, float f, boolean z) {
        int count = aVar.getCount();
        int aTe = aVar.aTe();
        if (z) {
            i = (count - 1) - i;
        }
        Object obj = null;
        if (i < 0) {
            i = 0;
        } else {
            count--;
            if (i > count) {
                i = count;
            }
        }
        Object obj2 = i > aTe ? 1 : null;
        Object obj3 = (z ? i - 1 >= aTe : i + 1 >= aTe) ? null : 1;
        if (!(obj2 == null && obj3 == null)) {
            aVar.cD(i);
            aTe = i;
        }
        float f2 = 0.0f;
        if (aTe == i && f != 0.0f) {
            obj = 1;
        }
        if (obj != null) {
            i = z ? i - 1 : i + 1;
        } else {
            f = 1.0f - f;
        }
        if (f > 1.0f) {
            f2 = 1.0f;
        } else if (f >= 0.0f) {
            f2 = f;
        }
        return new Pair(Integer.valueOf(i), Float.valueOf(f2));
    }
}
