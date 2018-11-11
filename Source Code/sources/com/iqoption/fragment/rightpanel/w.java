package com.iqoption.fragment.rightpanel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.iqoption.fragment.rightpanel.x.a;
import com.iqoption.view.a.a.d;

/* compiled from: CrossFadeAnimatorProvider */
public class w implements a {
    private final View avl;

    public w(View view) {
        this.avl = view;
    }

    public void e(View view, View view2) {
        if (view == this.avl) {
            view.setAlpha(0.0f);
            view.setTranslationY((float) view.getHeight());
        }
    }

    public void a(AnimatorSet animatorSet) {
        animatorSet.setInterpolator(d.dEM);
    }

    public Animator f(View view, View view2) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        Animator ofPropertyValuesHolder;
        if (view == this.avl) {
            propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
            ofPropertyValuesHolder.setInterpolator(d.aQV);
            return ofPropertyValuesHolder;
        }
        propertyValuesHolderArr = new PropertyValuesHolder[3];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f});
        propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f});
        ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
        ofPropertyValuesHolder.setInterpolator(d.dEM);
        return ofPropertyValuesHolder;
    }

    public Animator g(View view, View view2) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        Animator ofPropertyValuesHolder;
        if (view2 == this.avl) {
            propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) view2.getHeight()});
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, propertyValuesHolderArr);
            ofPropertyValuesHolder.setInterpolator(d.aQW);
            return ofPropertyValuesHolder;
        }
        propertyValuesHolderArr = new PropertyValuesHolder[3];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.95f});
        propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.95f});
        ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, propertyValuesHolderArr);
        ofPropertyValuesHolder.setInterpolator(d.dEM);
        return ofPropertyValuesHolder;
    }
}
