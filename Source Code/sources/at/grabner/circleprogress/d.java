package at.grabner.circleprogress;

import android.graphics.Color;
import android.support.annotation.ColorInt;

/* compiled from: ColorUtils */
public class d {
    public static int a(@ColorInt int i, @ColorInt int i2, float f) {
        int[] iArr = new int[]{a((float) Color.red(i), (float) Color.red(i2), f), a((float) Color.green(i), (float) Color.green(i2), f), a((float) Color.blue(i), (float) Color.blue(i2), f)};
        return Color.argb(255, iArr[0], iArr[1], iArr[2]);
    }

    private static int a(float f, float f2, float f3) {
        return Math.round((f * f3) + (f2 * (1.0f - f3)));
    }
}
