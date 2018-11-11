package com.iqoption.view.materialcalendar;

import android.animation.Animator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.iqoption.view.materialcalendar.a.g;

/* compiled from: TitleChanger */
class r {
    private final TextView agA;
    private g dGB;
    private final int dHR;
    private final int dHS;
    private final int dHT;
    private long dHU = 0;
    private b dHV = null;
    private final Interpolator oR = new DecelerateInterpolator(2.0f);
    private int orientation = 0;

    public r(TextView textView) {
        this.agA = textView;
        Resources resources = textView.getResources();
        this.dHR = 400;
        this.dHS = resources.getInteger(17694720) / 2;
        this.dHT = (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics());
    }

    public void l(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar != null) {
            if (TextUtils.isEmpty(this.agA.getText()) || currentTimeMillis - this.dHU < ((long) this.dHR)) {
                a(currentTimeMillis, bVar, false);
            }
            if (!bVar.equals(this.dHV) && (bVar.getMonth() != this.dHV.getMonth() || bVar.getYear() != this.dHV.getYear())) {
                a(currentTimeMillis, bVar, true);
            }
        }
    }

    private void a(long j, b bVar, boolean z) {
        this.agA.animate().cancel();
        h(this.agA, 0);
        this.agA.setAlpha(1.0f);
        this.dHU = j;
        final CharSequence o = this.dGB.o(bVar);
        if (z) {
            final int i = this.dHT * (this.dHV.a(bVar) ? 1 : -1);
            ViewPropertyAnimator animate = this.agA.animate();
            if (this.orientation == 1) {
                animate.translationX((float) (i * -1));
            } else {
                animate.translationY((float) (i * -1));
            }
            animate.alpha(0.0f).setDuration((long) this.dHS).setInterpolator(this.oR).setListener(new a() {
                public void onAnimationCancel(Animator animator) {
                    r.this.h(r.this.agA, 0);
                    r.this.agA.setAlpha(1.0f);
                }

                public void onAnimationEnd(Animator animator) {
                    r.this.agA.setText(o);
                    r.this.h(r.this.agA, i);
                    ViewPropertyAnimator animate = r.this.agA.animate();
                    if (r.this.orientation == 1) {
                        animate.translationX(0.0f);
                    } else {
                        animate.translationY(0.0f);
                    }
                    animate.alpha(1.0f).setDuration((long) r.this.dHS).setInterpolator(r.this.oR).setListener(new a()).start();
                }
            }).start();
        } else {
            this.agA.setText(o);
        }
        this.dHV = bVar;
    }

    private void h(TextView textView, int i) {
        if (this.orientation == 1) {
            textView.setTranslationX((float) i);
        } else {
            textView.setTranslationY((float) i);
        }
    }

    public void setTitleFormatter(g gVar) {
        this.dGB = gVar;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void m(b bVar) {
        this.dHV = bVar;
    }
}
