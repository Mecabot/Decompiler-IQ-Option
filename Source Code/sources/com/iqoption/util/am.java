package com.iqoption.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.iqoption.core.i;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: KeyboardUtil */
public class am {
    private static final String TAG = "com.iqoption.util.am";
    private static Collection<a> bgW = new ArrayList();
    private boolean bgS = false;
    private boolean bgT = false;
    private View bgU;
    private LayoutParams bgV;

    /* compiled from: KeyboardUtil */
    public interface a {
        void cp(boolean z);
    }

    /* compiled from: KeyboardUtil */
    public static class b {
        private final Runnable dvV;
        private final Runnable dvW;
        private final al dvX;
        private final View dvY;
        private boolean dvZ;
        private boolean dwa;
        private volatile boolean dwb;

        private b(View view) {
            this.dvV = new ao(this);
            this.dvW = new ap(this);
            this.dvX = new al();
            this.dvY = view;
        }

        /* renamed from: aGm */
        public void aGp() {
            am.bS(this.dvY);
        }

        private void aGn() {
            if (this.dwa) {
                am.bS(this.dvY);
            }
        }

        public void register() {
            if (!this.dwb) {
                this.dwb = true;
                if (!this.dvZ) {
                    this.dvX.b(this.dvV, 2000);
                }
                this.dvY.setOnSystemUiVisibilityChangeListener(new aq(this));
            }
        }

        final /* synthetic */ void gH(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setOnSystemUiVisibilityChangeListener = ");
            stringBuilder.append(i);
            i.d(stringBuilder.toString());
            if (!this.dvZ) {
                this.dvX.m(this.dvV);
                this.dvZ = true;
            }
            if ((i & 4) == 0) {
                this.dvX.a(this.dvW, 2000, 2000);
                this.dwa = true;
                return;
            }
            this.dvX.m(this.dvW);
            this.dwa = false;
        }

        public void unregister() {
            if (this.dwb) {
                this.dvZ = false;
                this.dwb = false;
                this.dvX.clear();
                this.dvY.setOnSystemUiVisibilityChangeListener(null);
            }
        }
    }

    public am(Activity activity) {
        this.bgU = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.bgV = (LayoutParams) this.bgU.getLayoutParams();
        this.bgU.getViewTreeObserver().addOnGlobalLayoutListener(new an(this));
    }

    public static void a(a aVar) {
        bgW.add(aVar);
    }

    public static void b(a aVar) {
        bgW.remove(aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x003d A:{RETURN, Splitter: B:3:0x000a, ExcHandler: java.lang.NoSuchMethodException (unused java.lang.NoSuchMethodException)} */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x003d A:{RETURN, Splitter: B:3:0x000a, ExcHandler: java.lang.NoSuchMethodException (unused java.lang.NoSuchMethodException)} */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x003d A:{RETURN, Splitter: B:3:0x000a, ExcHandler: java.lang.NoSuchMethodException (unused java.lang.NoSuchMethodException)} */
    /* JADX WARNING: Missing block: B:5:0x003d, code:
            return;
     */
    public static void b(android.widget.EditText r4, boolean r5) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 < r1) goto L_0x000a;
    L_0x0006:
        r4.setShowSoftInputOnFocus(r5);
        goto L_0x003d;
    L_0x000a:
        r0 = android.widget.TextView.class;
        r1 = "createEditorIfNeeded";
        r2 = 0;
        r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r1 = 1;
        r0.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r0.invoke(r4, r2);	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r0 = android.widget.TextView.class;
        r2 = "mEditor";
        r0 = r0.getDeclaredField(r2);	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r0.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r4 = r0.get(r4);	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r0 = r4.getClass();	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r2 = "mShowSoftInputOnFocus";
        r0 = r0.getDeclaredField(r2);	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r0.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
        r0.setBoolean(r4, r5);	 Catch:{ NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d, NoSuchMethodException -> 0x003d }
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.util.am.b(android.widget.EditText, boolean):void");
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.util.am.aac():void");
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

    public void aGk() {
        this.bgT = true;
    }

    public void aGl() {
        this.bgT = false;
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

    public static void bS(View view) {
        if (VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5894);
        }
    }

    public static b u(Activity activity) {
        b bVar = new b(activity.getWindow().getDecorView());
        bVar.register();
        return bVar;
    }
}
