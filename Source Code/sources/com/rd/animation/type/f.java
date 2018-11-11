package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.a.b.a;
import com.rd.animation.b.a.e;

/* compiled from: SlideAnimation */
public class f extends a<ValueAnimator> {
    private e eid = new e();
    private int eie = -1;
    private int eif = -1;

    public f(@NonNull a aVar) {
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
                f.this.e(valueAnimator);
            }
        });
        return valueAnimator;
    }

    /* renamed from: Z */
    public f W(float f) {
        if (this.animator != null) {
            long j = (long) (f * ((float) this.ehL));
            if (((ValueAnimator) this.animator).getValues() != null && ((ValueAnimator) this.animator).getValues().length > 0) {
                ((ValueAnimator) this.animator).setCurrentPlayTime(j);
            }
        }
        return this;
    }

    @NonNull
    public f aO(int i, int i2) {
        if (this.animator != null && aN(i, i2)) {
            this.eie = i;
            this.eif = i2;
            PropertyValuesHolder aTa = aTa();
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{aTa});
        }
        return this;
    }

    private PropertyValuesHolder aTa() {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("ANIMATION_COORDINATE", new int[]{this.eie, this.eif});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private void e(@NonNull ValueAnimator valueAnimator) {
        this.eid.iv(((Integer) valueAnimator.getAnimatedValue("ANIMATION_COORDINATE")).intValue());
        if (this.eho != null) {
            this.eho.a(this.eid);
        }
    }

    private boolean aN(int i, int i2) {
        if (this.eie == i && this.eif == i2) {
            return false;
        }
        return true;
    }
}
