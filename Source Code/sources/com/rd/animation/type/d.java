package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.a.b.a;

/* compiled from: ScaleAnimation */
public class d extends b {
    float eia;
    private com.rd.animation.b.a.d eib = new com.rd.animation.b.a.d();
    int radius;

    public d(@NonNull a aVar) {
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
                d.this.e(valueAnimator);
            }
        });
        return valueAnimator;
    }

    @NonNull
    public d a(int i, int i2, int i3, float f) {
        if (this.animator != null && b(i, i2, i3, f)) {
            this.ehN = i;
            this.ehO = i2;
            this.radius = i3;
            this.eia = f;
            PropertyValuesHolder ge = ge(false);
            PropertyValuesHolder ge2 = ge(true);
            PropertyValuesHolder gh = gh(false);
            PropertyValuesHolder gh2 = gh(true);
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{ge, ge2, gh, gh2});
        }
        return this;
    }

    private void e(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE_REVERSE")).intValue();
        this.eib.setColor(intValue);
        this.eib.ir(intValue2);
        this.eib.setRadius(intValue3);
        this.eib.is(intValue4);
        if (this.eho != null) {
            this.eho.a(this.eib);
        }
    }

    @NonNull
    protected PropertyValuesHolder gh(boolean z) {
        String str;
        int i;
        int i2;
        if (z) {
            str = "ANIMATION_SCALE_REVERSE";
            i = this.radius;
            i2 = (int) (((float) this.radius) * this.eia);
        } else {
            str = "ANIMATION_SCALE";
            i = (int) (((float) this.radius) * this.eia);
            i2 = this.radius;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i, i2});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean b(int i, int i2, int i3, float f) {
        if (this.ehN == i && this.ehO == i2 && this.radius == i3 && this.eia == f) {
            return false;
        }
        return true;
    }
}
