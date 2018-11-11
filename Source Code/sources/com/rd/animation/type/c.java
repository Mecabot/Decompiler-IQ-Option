package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.a.b.a;

/* compiled from: FillAnimation */
public class c extends b {
    private int ehF;
    private com.rd.animation.b.a.c ehY = new com.rd.animation.b.a.c();
    private int radius;

    public c(@NonNull a aVar) {
        super(aVar);
    }

    @NonNull
    /* renamed from: aSY */
    public ValueAnimator aIz() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.e(valueAnimator);
            }
        });
        return valueAnimator;
    }

    @NonNull
    public c h(int i, int i2, int i3, int i4) {
        if (this.animator != null && i(i, i2, i3, i4)) {
            this.ehN = i;
            this.ehO = i2;
            this.radius = i3;
            this.ehF = i4;
            PropertyValuesHolder ge = ge(false);
            PropertyValuesHolder ge2 = ge(true);
            PropertyValuesHolder gf = gf(false);
            PropertyValuesHolder gf2 = gf(true);
            PropertyValuesHolder gg = gg(false);
            PropertyValuesHolder gg2 = gg(true);
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{ge, ge2, gf, gf2, gg, gg2});
        }
        return this;
    }

    @NonNull
    private PropertyValuesHolder gf(boolean z) {
        String str;
        int i;
        int i2;
        if (z) {
            str = "ANIMATION_RADIUS_REVERSE";
            i = this.radius / 2;
            i2 = this.radius;
        } else {
            str = "ANIMATION_RADIUS";
            i = this.radius;
            i2 = this.radius / 2;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i, i2});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    @NonNull
    private PropertyValuesHolder gg(boolean z) {
        String str;
        int i;
        int i2;
        if (z) {
            str = "ANIMATION_STROKE_REVERSE";
            i = this.radius;
            i2 = 0;
        } else {
            str = "ANIMATION_STROKE";
            i2 = this.radius;
            i = 0;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i, i2});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private void e(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_RADIUS_REVERSE")).intValue();
        int intValue5 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE")).intValue();
        int intValue6 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_STROKE_REVERSE")).intValue();
        this.ehY.setColor(intValue);
        this.ehY.ir(intValue2);
        this.ehY.setRadius(intValue3);
        this.ehY.is(intValue4);
        this.ehY.it(intValue5);
        this.ehY.iu(intValue6);
        if (this.eho != null) {
            this.eho.a(this.ehY);
        }
    }

    private boolean i(int i, int i2, int i3, int i4) {
        if (this.ehN == i && this.ehO == i2 && this.radius == i3 && this.ehF == i4) {
            return false;
        }
        return true;
    }
}
