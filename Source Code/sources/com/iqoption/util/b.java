package com.iqoption.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.provider.Settings.Global;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.core.d.a;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: AnimUtils */
public final class b {
    private static final String TAG = "com.iqoption.util.b";

    private b() {
    }

    public static void a(final View view, final ViewGroup viewGroup, final boolean z) {
        a.aSe.execute(new Runnable() {
            public void run() {
                b.b(view, viewGroup, z);
            }
        });
    }

    public static void b(View view, final ViewGroup viewGroup, boolean z) {
        if (viewGroup.getChildCount() == 0) {
            Log.e(TAG, "container has no one child, cannot apply card flip");
            throw new RuntimeException("container has no one child");
        } else if (z && (viewGroup.getChildAt(0).getTag() == null || view.getTag() == null)) {
            Log.e(TAG, "container has no tag, cannot apply card flip");
            throw new RuntimeException("container has no tag");
        } else {
            Object obj = (!(z && view.getTag().equals(viewGroup.getChildAt(0).getTag())) && (z || !view.equals(viewGroup.getChildAt(0)))) ? null : 1;
            if (obj == null) {
                view.setVisibility(8);
                viewGroup.addView(view, 0);
                final View childAt = viewGroup.getChildAt(1);
                Animator h = h(childAt, view);
                h.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        viewGroup.removeView(childAt);
                    }
                });
                h.start();
            }
        }
    }

    public static Animator h(View view, View view2) {
        final View view3 = view;
        final View view4 = view2;
        view3.setScaleX(1.0f);
        view3.setScaleY(1.0f);
        view3.setTranslationY(0.0f);
        view3.setRotationY(0.0f);
        view3.setAlpha(1.0f);
        r5 = new PropertyValuesHolder[3];
        r5[0] = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.1f});
        r5[1] = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.7f});
        r5[2] = PropertyValuesHolder.ofFloat("translationY", new float[]{-30.0f});
        long j = (long) 200;
        ObjectAnimator.ofPropertyValuesHolder(view3, r5).setDuration(j).setInterpolator(new DecelerateInterpolator(0.8f));
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat("rotationY", new float[]{92.0f});
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view3, propertyValuesHolderArr).setDuration(j);
        duration.setInterpolator(new AccelerateInterpolator(1.0f));
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[1];
        propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{0.1f});
        long j2 = (long) (((float) 200) * 0.8f);
        ObjectAnimator.ofPropertyValuesHolder(view3, propertyValuesHolderArr2).setDuration(j2).setInterpolator(new DecelerateInterpolator(2.0f));
        long j3 = j2;
        duration.setStartDelay(0);
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view3.setVisibility(8);
            }
        });
        view4.setScaleX(0.1f);
        view4.setScaleY(0.7f);
        view4.setTranslationY(-30.0f);
        propertyValuesHolderArr2 = new PropertyValuesHolder[3];
        propertyValuesHolderArr2[0] = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f});
        propertyValuesHolderArr2[1] = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f});
        propertyValuesHolderArr2[2] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(view4, propertyValuesHolderArr2).setDuration(j);
        duration2.setInterpolator(new AccelerateInterpolator(0.8f));
        duration2.setStartDelay(j);
        view4.setRotationY(-92.0f);
        PropertyValuesHolder[] propertyValuesHolderArr3 = new PropertyValuesHolder[1];
        propertyValuesHolderArr3[0] = PropertyValuesHolder.ofFloat("rotationY", new float[]{0.0f});
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(view4, propertyValuesHolderArr3).setDuration(j);
        duration3.setInterpolator(new DecelerateInterpolator(1.0f));
        duration3.setStartDelay(j);
        view4.setAlpha(0.1f);
        PropertyValuesHolder[] propertyValuesHolderArr4 = new PropertyValuesHolder[1];
        propertyValuesHolderArr4[0] = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f});
        ObjectAnimator duration4 = ObjectAnimator.ofPropertyValuesHolder(view4, propertyValuesHolderArr4).setDuration(j3);
        duration4.setInterpolator(new AccelerateInterpolator(2.0f));
        duration4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view4.setVisibility(0);
            }
        });
        duration4.setStartDelay(j);
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{r5, duration, r2, duration2, duration3, duration4});
        return animatorSet;
    }

    public static Animator bR(View view) {
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.8f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.9f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.9f, 1.0f})});
        ofPropertyValuesHolder.setRepeatCount(2);
        ofPropertyValuesHolder.setRepeatMode(1);
        ofPropertyValuesHolder.setDuration(1200);
        ofPropertyValuesHolder.addListener(new AnimatorListener() {
            boolean doJ = false;

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                this.doJ = false;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.doJ) {
                    animator.setStartDelay(3000);
                    animator.start();
                }
            }

            public void onAnimationCancel(Animator animator) {
                this.doJ = true;
            }
        });
        ofPropertyValuesHolder.setInterpolator(d.dEM);
        return ofPropertyValuesHolder;
    }

    public static int bQ(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.dp4);
    }

    public static Animator o(View view, int i) {
        Animator p = p(view, i);
        p.start();
        return p;
    }

    public static Animator p(View view, int i) {
        Keyframe[] keyframeArr = new Keyframe[6];
        int length = keyframeArr.length;
        float f = 1.0f / ((float) length);
        float f2 = f / 2.0f;
        for (int i2 = 0; i2 < length; i2++) {
            keyframeArr[i2] = Keyframe.ofFloat((((float) i2) * f) + f2, i2 % 2 == 0 ? (float) i : (float) (-i));
        }
        keyframeArr[length - 1] = Keyframe.ofFloat(1.0f, 0.0f);
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, keyframeArr)});
        ofPropertyValuesHolder.setDuration(400);
        ofPropertyValuesHolder.setInterpolator(d.aQZ);
        return ofPropertyValuesHolder;
    }

    public static Animator o(TextView textView) {
        int currentTextColor = textView.getCurrentTextColor();
        Animator ofInt = ObjectAnimator.ofInt(textView, "textColor", new int[]{-1, currentTextColor});
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setInterpolator(d.dEM);
        ofInt.setDuration(1600);
        return ofInt;
    }

    public static AnimatorSet a(AnimatorSet animatorSet, long j) {
        float f;
        try {
            f = Global.getFloat(IQApp.Dk().getContentResolver(), "animator_duration_scale", 0.0f);
        } catch (Throwable unused) {
            f = 0.0f;
        }
        if (f != 0.0f) {
            animatorSet.setDuration(j);
        }
        return animatorSet;
    }
}
