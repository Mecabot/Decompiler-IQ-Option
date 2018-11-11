package com.iqoption.view.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: HideViewAnimationListenerAdapter */
public class c extends AnimatorListenerAdapter {
    private final View view;

    public c(View view) {
        this.view = view;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.view.setVisibility(8);
    }
}
