package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.a.b.a;
import com.rd.animation.b.a.f;

/* compiled from: SwapAnimation */
public class g extends a<ValueAnimator> {
    private int eie = -1;
    private int eif = -1;
    private f eih = new f();

    public g(@NonNull a aVar) {
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
                g.this.e(valueAnimator);
            }
        });
        return valueAnimator;
    }

    /* renamed from: aa */
    public g W(float f) {
        if (this.animator != null) {
            long j = (long) (f * ((float) this.ehL));
            if (((ValueAnimator) this.animator).getValues() != null && ((ValueAnimator) this.animator).getValues().length > 0) {
                ((ValueAnimator) this.animator).setCurrentPlayTime(j);
            }
        }
        return this;
    }

    @NonNull
    public g aP(int i, int i2) {
        if (this.animator != null && aN(i, i2)) {
            this.eie = i;
            this.eif = i2;
            PropertyValuesHolder f = f("ANIMATION_COORDINATE", i, i2);
            PropertyValuesHolder f2 = f("ANIMATION_COORDINATE_REVERSE", i2, i);
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{f, f2});
        }
        return this;
    }

    private PropertyValuesHolder f(String str, int i, int i2) {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i, i2});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private void e(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE_REVERSE")).intValue();
        this.eih.iv(intValue);
        this.eih.iw(intValue2);
        if (this.eho != null) {
            this.eho.a(this.eih);
        }
    }

    private boolean aN(int i, int i2) {
        if (this.eie == i && this.eif == i2) {
            return false;
        }
        return true;
    }
}
