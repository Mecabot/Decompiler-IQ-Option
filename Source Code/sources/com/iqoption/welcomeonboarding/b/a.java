package com.iqoption.welcomeonboarding.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.iqoption.d.ub;
import com.iqoption.x.R;

/* compiled from: AnimatorFactory */
abstract class a {
    protected final float cwc;
    protected final ub dLU;

    abstract Animator aKI();

    abstract Animator aKJ();

    public a(ub ubVar) {
        this.dLU = ubVar;
        this.cwc = -ubVar.getRoot().getResources().getDimension(R.dimen.dp24);
    }

    protected Animator P(View view) {
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{this.cwc, 0.0f});
        return ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
    }
}
