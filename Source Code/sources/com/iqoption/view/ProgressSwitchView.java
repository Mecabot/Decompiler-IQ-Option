package com.iqoption.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import com.iqoption.widget.d;
import com.iqoption.x.R;

public class ProgressSwitchView extends FrameLayout {
    private ImageView bik;
    private d cux;
    private Switch dDp;

    public ProgressSwitchView(Context context) {
        super(context);
        e(context, null);
    }

    public ProgressSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
    }

    public ProgressSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context, attributeSet);
    }

    @TargetApi(21)
    public ProgressSwitchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        e(context, attributeSet);
    }

    public void setChecked(boolean z) {
        this.dDp.setChecked(z);
    }

    public boolean isChecked() {
        return this.dDp.isChecked();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.dDp.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private void e(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.account_security_progress_switch_layout, this, true);
        this.dDp = (Switch) inflate.findViewById(R.id.switchView);
        this.cux = new d(context, inflate);
        this.bik = (ImageView) inflate.findViewById(R.id.progressView);
        if (!isInEditMode()) {
            this.bik.setImageDrawable(this.cux);
        }
    }

    public void f(boolean z, boolean z2) {
        this.dDp.setClickable(z ^ 1);
        if (z) {
            if (z2) {
                this.dDp.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f);
                this.bik.setAlpha(0.0f);
                this.bik.setScaleX(0.0f);
                this.bik.setScaleY(0.0f);
                this.bik.setVisibility(0);
                this.bik.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f);
            } else {
                this.dDp.setAlpha(0.0f);
                this.bik.setVisibility(0);
                this.bik.setAlpha(1.0f);
            }
            this.cux.start();
        } else if (z2) {
            this.dDp.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f);
            this.bik.animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ProgressSwitchView.this.cux.stop();
                    ProgressSwitchView.this.bik.setVisibility(8);
                }
            });
        } else {
            this.cux.stop();
            this.dDp.setScaleX(1.0f);
            this.dDp.setScaleY(1.0f);
            this.dDp.setAlpha(1.0f);
            this.dDp.setVisibility(0);
            this.bik.setAlpha(0.0f);
            this.bik.setVisibility(8);
        }
    }
}
