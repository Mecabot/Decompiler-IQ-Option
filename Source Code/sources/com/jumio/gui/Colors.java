package com.jumio.gui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;

public class Colors {
    public static final int DIALOG_NEGATIVE_ACTION_COLOR = -10066330;
    public static final int DIALOG_POSITIVE_ACTION_COLOR = -6832627;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    public static int parseColor(android.content.Context r3, int r4, int r5) {
        /*
        r0 = 1;
        r0 = new int[r0];
        r1 = 0;
        r0[r1] = r4;
        r4 = 0;
        r3 = r3.getTheme();	 Catch:{ all -> 0x001e }
        r3 = r3.obtainStyledAttributes(r0);	 Catch:{ all -> 0x001e }
        r4 = r3.getColor(r1, r5);	 Catch:{ all -> 0x0019 }
        if (r3 == 0) goto L_0x0018;
    L_0x0015:
        r3.recycle();
    L_0x0018:
        return r4;
    L_0x0019:
        r4 = move-exception;
        r2 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x001f;
    L_0x001e:
        r3 = move-exception;
    L_0x001f:
        if (r4 == 0) goto L_0x0024;
    L_0x0021:
        r4.recycle();
    L_0x0024:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.gui.Colors.parseColor(android.content.Context, int, int):int");
    }

    public static ColorStateList parseColorStateList(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        if (colorStateList == null) {
            i = obtainStyledAttributes.getColor(0, 0);
            if (i == 0) {
                i = i2;
            }
            colorStateList = ColorStateList.valueOf(i);
        }
        obtainStyledAttributes.recycle();
        return colorStateList;
    }

    public static ColorStateList constructList(int i, int i2, int i3) {
        int[][] iArr = new int[4][];
        iArr[0] = new int[]{16842910};
        iArr[1] = new int[]{-16842910};
        iArr[2] = new int[]{16842919};
        iArr[3] = new int[0];
        return new ColorStateList(iArr, new int[]{i, i2, i3, i});
    }
}
