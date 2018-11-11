package com.iqoption.view;

import android.view.View;
import android.view.animation.Interpolator;

/* compiled from: AnimatingViews */
public final class a {
    private final View[] cGq;
    private final Interpolator dAp;
    private final Interpolator dAq;
    private final Interpolator dAr;
    private final Interpolator dAs;

    /* compiled from: AnimatingViews */
    public static final class a {
        private View[] cGq;
        private Interpolator dAp;
        private Interpolator dAq;
        private Interpolator dAr;
        private Interpolator dAs;

        public a a(View... viewArr) {
            this.cGq = viewArr;
            return this;
        }

        public a j(float f, float f2) {
            this.dAp = new j(f, f2);
            return this;
        }

        public a gK(int i) {
            this.dAr = new j(0.0f, (float) i);
            return this;
        }

        public a aHZ() {
            return new a(this);
        }
    }

    private a(a aVar) {
        this.cGq = aVar.cGq;
        this.dAp = aVar.dAp;
        this.dAq = aVar.dAq;
        this.dAr = aVar.dAr;
        this.dAs = aVar.dAs;
    }

    public void M(float f) {
        for (View view : this.cGq) {
            if (this.dAp != null) {
                view.setAlpha(this.dAp.getInterpolation(f));
            }
            if (this.dAq != null) {
                float interpolation = this.dAq.getInterpolation(f);
                view.setScaleX(interpolation);
                view.setScaleY(interpolation);
            }
            if (this.dAr != null) {
                view.setTranslationX(this.dAr.getInterpolation(f));
            }
            if (this.dAs != null) {
                view.setTranslationY(this.dAs.getInterpolation(f));
            }
        }
    }
}
