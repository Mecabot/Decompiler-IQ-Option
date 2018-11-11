package com.iqoption.core.ui.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.core.j.g;
import java.util.Map;

public class TextScaleResize extends Transition {
    private static final String[] PROPERTIES = new String[]{"TextScaleResize:fontSize"};
    private float bcc = 0.0f;
    private float bcd = -1.0f;
    private float bce = -1.0f;

    public String[] getTransitionProperties() {
        return PROPERTIES;
    }

    public TextScaleResize() {
        addTarget(TextView.class);
    }

    public TextScaleResize(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.TextScaleResize);
        this.bcc = obtainStyledAttributes.getDimension(g.TextScaleResize_scaleEndTextSize, 0.0f);
        this.bcd = obtainStyledAttributes.getDimension(g.TextScaleResize_scalePivotX, -1.0f);
        this.bce = obtainStyledAttributes.getDimension(g.TextScaleResize_scalePivotY, -1.0f);
        obtainStyledAttributes.recycle();
        addTarget(TextView.class);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues, false);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues, true);
    }

    private void a(TransitionValues transitionValues, boolean z) {
        if (transitionValues.view instanceof TextView) {
            TextView textView = (TextView) transitionValues.view;
            transitionValues.values.put("TextScaleResize:scale", Float.valueOf(textView.getScaleX()));
            float textSize = z ? this.bcc > 0.0f ? this.bcc : textView.getTextSize() : textView.getTextSize();
            transitionValues.values.put("TextScaleResize:fontSize", Float.valueOf(textSize));
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof TextView) || !(transitionValues2.view instanceof TextView)) {
            return null;
        }
        float floatValue;
        float floatValue2;
        final TextView textView = (TextView) transitionValues2.view;
        Map map = transitionValues.values;
        Map map2 = transitionValues2.values;
        if (map.get("TextScaleResize:fontSize") != null) {
            floatValue = ((Float) map.get("TextScaleResize:fontSize")).floatValue();
        } else {
            floatValue = ((TextView) transitionValues.view).getTextSize();
        }
        if (map2.get("TextScaleResize:fontSize") != null) {
            floatValue2 = ((Float) map2.get("TextScaleResize:fontSize")).floatValue();
        } else {
            floatValue2 = ((TextView) transitionValues2.view).getTextSize();
        }
        float f = 1.0f;
        float floatValue3 = map.get("TextScaleResize:scale") != null ? ((Float) map.get("TextScaleResize:scale")).floatValue() : 1.0f;
        float f2 = floatValue2 / floatValue;
        if (map2.get("TextScaleResize:scale") != null) {
            f = ((Float) map2.get("TextScaleResize:scale")).floatValue();
        }
        if (floatValue3 == f2) {
            return null;
        }
        if (this.bcd >= 0.0f) {
            textView.setPivotX(this.bcd);
        }
        if (this.bce >= 0.0f) {
            textView.setPivotY(this.bce);
        }
        textView.setTextSize(0, floatValue);
        textView.setScaleX(floatValue3);
        textView.setScaleY(floatValue3);
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue3, f2});
        ofFloat.addUpdateListener(new a(textView));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            private boolean bcg;

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.bcg) {
                    textView.setTextSize(0, floatValue2);
                    textView.setScaleX(f);
                    textView.setScaleY(f);
                }
            }

            public void onAnimationCancel(Animator animator) {
                this.bcg = true;
                super.onAnimationCancel(animator);
            }
        });
        return ofFloat;
    }
}
