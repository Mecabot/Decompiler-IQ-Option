package com.iqoption.kyc;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.Formatter;
import com.iqoption.b.b;
import com.iqoption.util.am;

public class PositionPicker extends NumberPicker {
    private static final String TAG = "com.iqoption.kyc.PositionPicker";
    @Nullable
    private EditText cJx;
    @Nullable
    private Paint cJy;

    public boolean performClick() {
        return true;
    }

    public boolean performLongClick() {
        return true;
    }

    public PositionPicker(Context context) {
        super(context);
    }

    public PositionPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context, attributeSet);
    }

    public PositionPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public PositionPicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        d(context, attributeSet);
    }

    private void d(Context context, AttributeSet attributeSet) {
        setFormatter(new Formatter() {
            public String format(int i) {
                return "";
            }
        });
        this.cJx = a(this);
        this.cJy = b(this);
        if (this.cJx != null) {
            am.b(this.cJx, false);
            this.cJx.setVisibility(4);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.PositionPicker, 0, 0);
        try {
            int dimension = (int) obtainStyledAttributes.getDimension(3, 0.0f);
            if (dimension != 0) {
                setTextSize(dimension);
            }
            setTextColor(obtainStyledAttributes.getColor(2, -1));
            setDividerColor(obtainStyledAttributes.getColor(0, -1));
            dimension = (int) obtainStyledAttributes.getDimension(1, 0.0f);
            if (dimension != 0) {
                setDividerHeight(dimension);
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setTextSize(int i) {
        if (this.cJx != null) {
            this.cJx.setTextSize(0, (float) i);
        }
        if (this.cJy != null) {
            this.cJy.setTextSize((float) i);
        }
    }

    public void setTextColor(int i) {
        if (this.cJx != null) {
            this.cJx.setTextColor(i);
        }
        if (this.cJy != null) {
            this.cJy.setColor(i);
        }
    }

    public void setDividerColor(int i) {
        a(this, i);
    }

    private void setDividerHeight(int i) {
        b(this, i);
    }

    @Nullable
    private static EditText a(NumberPicker numberPicker) {
        int childCount = numberPicker.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = numberPicker.getChildAt(i);
            if (childAt instanceof EditText) {
                return (EditText) childAt;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.NoSuchFieldException (r2_3 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.NoSuchFieldException (r2_3 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x0013, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:4:0x0014, code:
            com.iqoption.core.i.w(TAG, "getNumberPickerInputPaint", r2);
     */
    /* JADX WARNING: Missing block: B:5:0x001c, code:
            return null;
     */
    @android.support.annotation.Nullable
    private static android.graphics.Paint b(android.widget.NumberPicker r2) {
        /*
        r0 = android.widget.NumberPicker.class;
        r1 = "mSelectorWheelPaint";
        r0 = r0.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x0013, NoSuchFieldException -> 0x0013, NoSuchFieldException -> 0x0013 }
        r1 = 1;
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0013, NoSuchFieldException -> 0x0013, NoSuchFieldException -> 0x0013 }
        r2 = r0.get(r2);	 Catch:{ NoSuchFieldException -> 0x0013, NoSuchFieldException -> 0x0013, NoSuchFieldException -> 0x0013 }
        r2 = (android.graphics.Paint) r2;	 Catch:{ NoSuchFieldException -> 0x0013, NoSuchFieldException -> 0x0013, NoSuchFieldException -> 0x0013 }
        return r2;
    L_0x0013:
        r2 = move-exception;
        r0 = TAG;
        r1 = "getNumberPickerInputPaint";
        com.iqoption.core.i.w(r0, r1, r2);
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.kyc.PositionPicker.b(android.widget.NumberPicker):android.graphics.Paint");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025 A:{Splitter: B:5:0x001c, ExcHandler: java.lang.IllegalArgumentException (r6_1 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025 A:{Splitter: B:5:0x001c, ExcHandler: java.lang.IllegalArgumentException (r6_1 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:7:0x0025, code:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:8:0x0026, code:
            com.iqoption.core.i.w(TAG, "setNumberPickerDividerColor", r6);
     */
    /* JADX WARNING: Missing block: B:12:?, code:
            return;
     */
    private static void a(android.widget.NumberPicker r6, int r7) {
        /*
        r0 = android.widget.NumberPicker.class;
        r0 = r0.getDeclaredFields();
        r1 = r0.length;
        r2 = 0;
    L_0x0008:
        if (r2 >= r1) goto L_0x0031;
    L_0x000a:
        r3 = r0[r2];
        r4 = r3.getName();
        r5 = "mSelectionDivider";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x002e;
    L_0x0018:
        r0 = 1;
        r3.setAccessible(r0);
        r0 = new android.graphics.drawable.ColorDrawable;	 Catch:{ IllegalArgumentException -> 0x0025, IllegalArgumentException -> 0x0025, IllegalArgumentException -> 0x0025 }
        r0.<init>(r7);	 Catch:{ IllegalArgumentException -> 0x0025, IllegalArgumentException -> 0x0025, IllegalArgumentException -> 0x0025 }
        r3.set(r6, r0);	 Catch:{ IllegalArgumentException -> 0x0025, IllegalArgumentException -> 0x0025, IllegalArgumentException -> 0x0025 }
        goto L_0x0031;
    L_0x0025:
        r6 = move-exception;
        r7 = TAG;
        r0 = "setNumberPickerDividerColor";
        com.iqoption.core.i.w(r7, r0, r6);
        goto L_0x0031;
    L_0x002e:
        r2 = r2 + 1;
        goto L_0x0008;
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.kyc.PositionPicker.a(android.widget.NumberPicker, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024 A:{Splitter: B:5:0x001c, ExcHandler: java.lang.IllegalArgumentException (r6_1 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024 A:{Splitter: B:5:0x001c, ExcHandler: java.lang.IllegalArgumentException (r6_1 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:7:0x0024, code:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:8:0x0025, code:
            com.iqoption.core.i.w(TAG, "setNumberPickerDividerHeight", r6);
     */
    /* JADX WARNING: Missing block: B:12:?, code:
            return;
     */
    private static void b(android.widget.NumberPicker r6, int r7) {
        /*
        r0 = android.widget.NumberPicker.class;
        r0 = r0.getDeclaredFields();
        r1 = r0.length;
        r2 = 0;
    L_0x0008:
        if (r2 >= r1) goto L_0x0030;
    L_0x000a:
        r3 = r0[r2];
        r4 = r3.getName();
        r5 = "mSelectionDividerHeight";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x002d;
    L_0x0018:
        r0 = 1;
        r3.setAccessible(r0);
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ IllegalArgumentException -> 0x0024, IllegalArgumentException -> 0x0024, IllegalArgumentException -> 0x0024 }
        r3.set(r6, r7);	 Catch:{ IllegalArgumentException -> 0x0024, IllegalArgumentException -> 0x0024, IllegalArgumentException -> 0x0024 }
        goto L_0x0030;
    L_0x0024:
        r6 = move-exception;
        r7 = TAG;
        r0 = "setNumberPickerDividerHeight";
        com.iqoption.core.i.w(r7, r0, r6);
        goto L_0x0030;
    L_0x002d:
        r2 = r2 + 1;
        goto L_0x0008;
    L_0x0030:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.kyc.PositionPicker.b(android.widget.NumberPicker, int):void");
    }
}
