package com.iqoption.fragment.leftmenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.iqoption.x.R;

/* compiled from: LeftMenuAnimationHelper */
public class d {
    public static Animator a(LeftMenuFragment leftMenuFragment, int i) {
        if (leftMenuFragment == null || leftMenuFragment.cCw == null) {
            return null;
        }
        Animator createCircularReveal;
        Resources resources = leftMenuFragment.getResources();
        View view = leftMenuFragment.cCw.axw;
        View view2 = leftMenuFragment.cCw.bKy;
        view.clearAnimation();
        view2.clearAnimation();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.dp24);
        float dimension = resources.getDimension(R.dimen.left_menu_width2);
        float dimension2 = resources.getDimension(R.dimen.left_menu_item_button_height);
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{dimension2, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
        if (VERSION.SDK_INT >= 21) {
            createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, dimensionPixelOffset, dimensionPixelOffset, 0.0f, ((float) i) * 1.1f);
        } else {
            createCircularReveal = ObjectAnimator.ofFloat(view2, "translationX", new float[]{-dimension, 0.0f});
        }
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, createCircularReveal});
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        return animatorSet;
    }

    public static Animator b(LeftMenuFragment leftMenuFragment, int i) {
        if (leftMenuFragment == null || leftMenuFragment.cCw == null) {
            return null;
        }
        Animator createCircularReveal;
        Resources resources = leftMenuFragment.getResources();
        RecyclerView recyclerView = leftMenuFragment.cCw.axw;
        View view = leftMenuFragment.cCw.bKy;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dp24);
        float dimension = resources.getDimension(R.dimen.left_menu_width2);
        float dimension2 = resources.getDimension(R.dimen.left_menu_item_button_height);
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, dimension2});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(recyclerView, propertyValuesHolderArr);
        if (VERSION.SDK_INT >= 21) {
            createCircularReveal = ViewAnimationUtils.createCircularReveal(view, dimensionPixelSize, dimensionPixelSize, ((float) i) * 1.1f, 0.0f);
        } else {
            createCircularReveal = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, -dimension});
        }
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, createCircularReveal});
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        return animatorSet;
    }
}
