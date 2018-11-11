package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import com.google.android.youtube.player.YouTubePlayer.e;
import com.google.android.youtube.player.internal.d;
import com.google.android.youtube.player.internal.p;
import com.google.android.youtube.player.internal.t;
import com.google.android.youtube.player.internal.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class c extends ViewGroup implements e {
    private final a Le;
    private final Set<View> Lf;
    private final b Lg;
    private d Lh;
    private t Li;
    private View Lj;
    private p Lk;
    private e Ll;
    private Bundle Lm;
    private com.google.android.youtube.player.YouTubePlayer.b Ln;
    private boolean k;
    private boolean l;

    private final class a implements OnGlobalFocusChangeListener {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final void onGlobalFocusChanged(View view, View view2) {
            if (c.this.Li != null && c.this.Lf.contains(view2) && !c.this.Lf.contains(view)) {
                c.this.Li.g();
            }
        }
    }

    interface b {
        void a(c cVar);
    }

    c(Context context, AttributeSet attributeSet, int i, b bVar) {
        super((Context) com.google.android.youtube.player.internal.b.e(context, "context cannot be null"), attributeSet, i);
        this.Lg = (b) com.google.android.youtube.player.internal.b.e(bVar, "listener cannot be null");
        if (getBackground() == null) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        setClipToPadding(false);
        this.Lk = new p(context);
        requestTransparentRegion(this.Lk);
        addView(this.Lk);
        this.Lf = new HashSet();
        this.Le = new a(this, (byte) 0);
    }

    private void a(View view) {
        Object obj = (view == this.Lk || (this.Li != null && view == this.Lj)) ? 1 : null;
        if (obj == null) {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        }
    }

    private void a(YouTubeInitializationResult youTubeInitializationResult) {
        this.Li = null;
        this.Lk.c();
        if (this.Ln != null) {
            this.Ln.a(this.Ll, youTubeInitializationResult);
            this.Ln = null;
        }
    }

    final void a() {
        if (this.Li != null) {
            this.Li.b();
        }
    }

    final void a(final Activity activity, e eVar, String str, com.google.android.youtube.player.YouTubePlayer.b bVar, Bundle bundle) {
        if (this.Li == null && this.Ln == null) {
            com.google.android.youtube.player.internal.b.e(activity, "activity cannot be null");
            this.Ll = (e) com.google.android.youtube.player.internal.b.e(eVar, "provider cannot be null");
            this.Ln = (com.google.android.youtube.player.YouTubePlayer.b) com.google.android.youtube.player.internal.b.e(bVar, "listener cannot be null");
            this.Lm = bundle;
            this.Lk.b();
            this.Lh = com.google.android.youtube.player.internal.a.pg().a(getContext(), str, new com.google.android.youtube.player.internal.u.a() {
                public final void a() {
                    if (c.this.Lh != null) {
                        c.a(c.this, activity);
                    }
                    c.this.Lh = null;
                }

                public final void b() {
                    if (!(c.this.l || c.this.Li == null)) {
                        c.this.Li.f();
                    }
                    c.this.Lk.a();
                    if (c.this.indexOfChild(c.this.Lk) < 0) {
                        c.this.addView(c.this.Lk);
                        c.this.removeView(c.this.Lj);
                    }
                    c.this.Lj = null;
                    c.this.Li = null;
                    c.this.Lh = null;
                }
            }, new com.google.android.youtube.player.internal.u.b() {
                public final void a(YouTubeInitializationResult youTubeInitializationResult) {
                    c.this.a(youTubeInitializationResult);
                    c.this.Lh = null;
                }
            });
            this.Lh.e();
        }
    }

    final void a(boolean z) {
        if (!z || VERSION.SDK_INT >= 14) {
            this.k = z;
            return;
        }
        z.e("Could not enable TextureView because API level is lower than 14", new Object[0]);
        this.k = false;
    }

    public final void addFocusables(ArrayList<View> arrayList, int i) {
        Collection arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i);
        arrayList.addAll(arrayList2);
        this.Lf.clear();
        this.Lf.addAll(arrayList2);
    }

    public final void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        Collection arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i, i2);
        arrayList.addAll(arrayList2);
        this.Lf.clear();
        this.Lf.addAll(arrayList2);
    }

    public final void addView(View view) {
        a(view);
        super.addView(view);
    }

    public final void addView(View view, int i) {
        a(view);
        super.addView(view, i);
    }

    public final void addView(View view, int i, int i2) {
        a(view);
        super.addView(view, i, i2);
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        a(view);
        super.addView(view, i, layoutParams);
    }

    public final void addView(View view, LayoutParams layoutParams) {
        a(view);
        super.addView(view, layoutParams);
    }

    final void b() {
        if (this.Li != null) {
            this.Li.c();
        }
    }

    final void b(boolean z) {
        if (this.Li != null) {
            this.Li.b(z);
            c(z);
        }
    }

    final void c() {
        if (this.Li != null) {
            this.Li.d();
        }
    }

    final void c(boolean z) {
        this.l = true;
        if (this.Li != null) {
            this.Li.a(z);
        }
    }

    public final void clearChildFocus(View view) {
        if (hasFocusable()) {
            requestFocus();
        } else {
            super.clearChildFocus(view);
        }
    }

    final void d() {
        if (this.Li != null) {
            this.Li.e();
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.Li != null) {
            if (keyEvent.getAction() == 0) {
                return this.Li.a(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            } else {
                if (keyEvent.getAction() == 1) {
                    return this.Li.b(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void focusableViewAvailable(View view) {
        super.focusableViewAvailable(view);
        this.Lf.add(view);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.Le);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.Li != null) {
            this.Li.a(configuration);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.Le);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, i3 - i, i4 - i2);
        }
    }

    protected final void onMeasure(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.measure(i, i2);
            setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    final Bundle pe() {
        return this.Li == null ? this.Lm : this.Li.po();
    }

    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.Lf.add(view2);
    }

    public final void setClipToPadding(boolean z) {
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
    }
}
