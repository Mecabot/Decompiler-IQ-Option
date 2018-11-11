package com.iqoption.core.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.iqoption.core.i;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: KeyboardUtil */
public class j {
    private static final String TAG = "com.iqoption.core.util.j";
    private static Collection<a> bgW = new ArrayList();
    private boolean bgS = false;
    private boolean bgT = false;
    private View bgU;
    private LayoutParams bgV;

    /* compiled from: KeyboardUtil */
    public interface a {
        void cp(boolean z);
    }

    public j(Activity activity) {
        this.bgU = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.bgV = (LayoutParams) this.bgU.getLayoutParams();
        this.bgU.getViewTreeObserver().addOnGlobalLayoutListener(new k(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    private void aac() {
        /*
        r5 = this;
        r0 = r5.bgU;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r5.aad();
        r1 = r5.bgU;
        r1 = r1.getRootView();
        r1 = r1.getHeight();
        r0 = r1 - r0;
        r2 = r1 / 4;
        r3 = 0;
        r4 = 1;
        if (r0 <= r2) goto L_0x0025;
    L_0x001b:
        r2 = r5.bgS;
        if (r2 != 0) goto L_0x002f;
    L_0x001f:
        r5.bgS = r4;
        co(r4);
        goto L_0x0030;
    L_0x0025:
        r2 = r5.bgS;
        if (r2 == 0) goto L_0x002f;
    L_0x0029:
        r5.bgS = r3;
        co(r3);
        goto L_0x0030;
    L_0x002f:
        r4 = 0;
    L_0x0030:
        r2 = r5.bgT;
        if (r2 == 0) goto L_0x0049;
    L_0x0034:
        if (r4 == 0) goto L_0x0049;
    L_0x0036:
        r2 = r5.bgS;
        if (r2 == 0) goto L_0x0040;
    L_0x003a:
        r2 = r5.bgV;
        r1 = r1 - r0;
        r2.height = r1;
        goto L_0x0044;
    L_0x0040:
        r0 = r5.bgV;
        r0.height = r1;
    L_0x0044:
        r0 = r5.bgU;
        r0.requestLayout();
    L_0x0049:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.util.j.aac():void");
    }

    private static void co(boolean z) {
        for (a cp : bgW) {
            cp.cp(z);
        }
    }

    private int aad() {
        Rect rect = new Rect();
        this.bgU.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public boolean zN() {
        return this.bgS;
    }

    public static void n(Activity activity) {
        if (activity == null) {
            i.w(TAG, "activity is null");
            return;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = activity.findViewById(16908290);
        }
        if (currentFocus == null) {
            i.w(TAG, "view is null");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager == null) {
            i.w(TAG, "InputMethodManager is null");
        } else {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static void a(Context context, View view) {
        if (context == null) {
            i.w(TAG, "context is null");
        } else if (view == null) {
            i.w(TAG, "view is null");
        } else {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager == null) {
                i.w(TAG, "InputMethodManager is null");
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            co(false);
        }
    }

    public static void R(View view) {
        a(view.getContext(), view);
    }

    public static void b(Context context, View view) {
        if (context == null) {
            i.w(TAG, "context is null");
        } else if (view == null) {
            i.w(TAG, "view is null");
        } else {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager == null) {
                i.w(TAG, "InputMethodManager is null");
                return;
            }
            inputMethodManager.showSoftInput(view, 1);
            co(true);
        }
    }
}
