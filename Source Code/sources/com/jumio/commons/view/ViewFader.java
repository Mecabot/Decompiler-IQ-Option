package com.jumio.commons.view;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class ViewFader {
    private static int MAX_COUNT = 10;
    private int fadeCount = 0;
    private AlphaAnimation lAnimation1;
    private AlphaAnimation lAnimation2;
    private View view;

    public ViewFader(View view) {
        this.view = view;
        this.lAnimation1 = new AlphaAnimation(0.4f, 1.0f);
        this.lAnimation2 = new AlphaAnimation(1.0f, 0.4f);
        this.lAnimation1.setDuration(350);
        this.lAnimation2.setDuration(350);
        this.lAnimation1.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                ViewFader.this.fadeCount = ViewFader.this.fadeCount + 1;
                if (ViewFader.this.fadeCount < ViewFader.MAX_COUNT) {
                    ViewFader.this.view.startAnimation(ViewFader.this.lAnimation2);
                }
            }
        });
        this.lAnimation2.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                ViewFader.this.fadeCount = ViewFader.this.fadeCount + 1;
                if (ViewFader.this.fadeCount < ViewFader.MAX_COUNT) {
                    ViewFader.this.view.startAnimation(ViewFader.this.lAnimation1);
                }
            }
        });
    }

    public void cancel() {
        this.fadeCount = MAX_COUNT;
    }

    public void pulsate() {
        this.fadeCount = 0;
        this.view.startAnimation(this.lAnimation1);
    }
}
