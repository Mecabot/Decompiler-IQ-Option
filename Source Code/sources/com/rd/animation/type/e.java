package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.support.annotation.NonNull;
import com.rd.animation.a.b.a;

/* compiled from: ScaleDownAnimation */
public class e extends d {
    public e(@NonNull a aVar) {
        super(aVar);
    }

    @NonNull
    protected PropertyValuesHolder gh(boolean z) {
        String str;
        int i;
        int i2;
        if (z) {
            str = "ANIMATION_SCALE_REVERSE";
            i = (int) (((float) this.radius) * this.eia);
            i2 = this.radius;
        } else {
            str = "ANIMATION_SCALE";
            i = this.radius;
            i2 = (int) (((float) this.radius) * this.eia);
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i, i2});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }
}
