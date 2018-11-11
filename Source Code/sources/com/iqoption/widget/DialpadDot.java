package com.iqoption.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.iqoption.x.R;

public class DialpadDot extends FrameLayout {
    public static int cvm = 150;
    private View dOu;
    private View dOv;
    private View dOw;
    private View dOx;
    private State dOy = State.disabled;

    public enum State {
        disabled,
        enabled,
        error,
        success
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public DialpadDot(Context context) {
        super(context);
        e(context, null);
    }

    public DialpadDot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
    }

    public DialpadDot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context, attributeSet);
    }

    @TargetApi(21)
    public DialpadDot(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        e(context, attributeSet);
    }

    private void e(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialpad_dot_layout, this, true);
        this.dOu = inflate.findViewById(R.id.dotDisabled);
        this.dOv = inflate.findViewById(R.id.dotEnabled);
        this.dOw = inflate.findViewById(R.id.dotError);
        this.dOx = inflate.findViewById(R.id.dotSuccess);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void a(State state, boolean z) {
        if (this.dOy != state) {
            State state2 = this.dOy;
            this.dOy = state;
            switch (state) {
                case error:
                    c(this.dOw, z);
                    break;
                case success:
                    c(this.dOx, z);
                    break;
                case enabled:
                    if (state2 != State.error) {
                        c(this.dOv, z);
                        break;
                    }
                    this.dOv.setVisibility(0);
                    d(this.dOw, z);
                    break;
                case disabled:
                    this.dOu.setVisibility(0);
                    if (state2 != State.enabled) {
                        if (state2 == State.error) {
                            this.dOv.setVisibility(8);
                            d(this.dOw, z);
                            break;
                        }
                    }
                    d(this.dOv, z);
                    break;
                    break;
            }
        }
    }

    private void c(View view, boolean z) {
        if (z) {
            cw(view);
        } else {
            L(view);
        }
    }

    private void d(View view, boolean z) {
        if (z) {
            cx(view);
        } else {
            hide(view);
        }
    }

    private void cw(View view) {
        view.setAlpha(0.2f);
        view.setScaleX(0.2f);
        view.setScaleY(0.2f);
        view.setVisibility(0);
        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setListener(null).setDuration((long) cvm);
    }

    private void cx(final View view) {
        view.animate().scaleX(0.2f).scaleY(0.2f).alpha(0.2f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
                view.animate().setListener(null);
            }
        }).setDuration((long) cvm);
    }

    private void L(View view) {
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setVisibility(0);
    }

    private void hide(View view) {
        view.setVisibility(8);
        view.setAlpha(0.0f);
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
    }
}
