package com.rd.animation.type;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.b.a.a;

/* compiled from: ColorAnimation */
public class b extends a<ValueAnimator> {
    private a ehM = new a();
    int ehN;
    int ehO;

    public b(@Nullable com.rd.animation.a.b.a aVar) {
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
                b.this.e(valueAnimator);
            }
        });
        return valueAnimator;
    }

    /* renamed from: X */
    public b W(float f) {
        if (this.animator != null) {
            long j = (long) (f * ((float) this.ehL));
            if (((ValueAnimator) this.animator).getValues() != null && ((ValueAnimator) this.animator).getValues().length > 0) {
                ((ValueAnimator) this.animator).setCurrentPlayTime(j);
            }
        }
        return this;
    }

    @NonNull
    public b aM(int i, int i2) {
        if (this.animator != null && aN(i, i2)) {
            this.ehN = i;
            this.ehO = i2;
            PropertyValuesHolder ge = ge(false);
            PropertyValuesHolder ge2 = ge(true);
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{ge, ge2});
        }
        return this;
    }

    PropertyValuesHolder ge(boolean z) {
        String str;
        int i;
        int i2;
        if (z) {
            str = "ANIMATION_COLOR_REVERSE";
            i = this.ehO;
            i2 = this.ehN;
        } else {
            str = "ANIMATION_COLOR";
            i = this.ehN;
            i2 = this.ehO;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i, i2});
        ofInt.setEvaluator(new ArgbEvaluator());
        return ofInt;
    }

    private boolean aN(int i, int i2) {
        if (this.ehN == i && this.ehO == i2) {
            return false;
        }
        return true;
    }

    private void e(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        this.ehM.setColor(intValue);
        this.ehM.ir(intValue2);
        if (this.eho != null) {
            this.eho.a(this.ehM);
        }
    }
}
