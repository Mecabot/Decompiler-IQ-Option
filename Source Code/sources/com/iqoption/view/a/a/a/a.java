package com.iqoption.view.a.a.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: BuilderAnimationListener */
public class a implements AnimatorListener, AnimationListener {
    private b dEO;
    private b dEP;
    private int mEndVisibility = -1;
    private int mStartVisibility = -1;
    private final View mView;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public a(View view) {
        this.mView = view;
    }

    public a fm(boolean z) {
        this.mEndVisibility = z;
        return this;
    }

    public a fn(boolean z) {
        this.mStartVisibility = z;
        return this;
    }

    public a a(b bVar) {
        this.dEO = bVar;
        return this;
    }

    public a b(b bVar) {
        this.dEP = bVar;
        return this;
    }

    public static a ch(View view) {
        return new a(view).fm(false);
    }

    public static a ci(View view) {
        return new a(view).fn(true);
    }

    public static a c(b bVar) {
        return new a(null).a(bVar);
    }

    public static a d(b bVar) {
        return new a(null).b(bVar);
    }

    private void onAnimationStart() {
        if (this.mStartVisibility >= 0 && this.mView != null) {
            this.mView.setVisibility(this.mStartVisibility == 1 ? 0 : 8);
        }
        if (this.dEP != null) {
            this.dEP.execute();
        }
    }

    private void onAnimationEnd() {
        if (this.mEndVisibility >= 0 && this.mView != null) {
            this.mView.setVisibility(this.mEndVisibility == 1 ? 0 : 8);
        }
        if (this.dEO != null) {
            this.dEO.execute();
        }
    }

    public void onAnimationStart(Animator animator) {
        onAnimationStart();
    }

    public void onAnimationEnd(Animator animator) {
        onAnimationEnd();
    }

    public void onAnimationStart(Animation animation) {
        onAnimationStart();
    }

    public void onAnimationEnd(Animation animation) {
        if (this.mView != null) {
            this.mView.clearAnimation();
        }
        onAnimationEnd();
    }
}
