package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.d.ol;
import com.iqoption.fragment.base.b;
import com.iqoption.util.ax;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: MarginNotAddedFragment */
public final class bg extends b {
    private ol cpE;

    public static void a(FragmentManager fragmentManager, @IdRes int i) {
        if (fragmentManager.findFragmentByTag("MarginNotAddedFragment") == null) {
            fragmentManager.beginTransaction().add(i, new bg(), "MarginNotAddedFragment").addToBackStack("MarginNotAddedFragment").commitAllowingStateLoss();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cpE = (ol) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_margin_not_added, viewGroup, false);
        this.cpE.bxe.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                bg.this.onClose();
            }
        });
        this.cpE.brN.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                TradeRoomActivity tradeRoomActivity = bg.this.getTradeRoomActivity();
                if (tradeRoomActivity != null) {
                    tradeRoomActivity.Aq();
                }
                bg.this.onClose();
            }
        });
        return this.cpE.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        return true;
    }

    public void ND() {
        this.cpE.blV.setAlpha(0.0f);
        if (ax.dws) {
            TimeInterpolator timeInterpolator = d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            this.cpE.bxi.setTranslationX((float) dimensionPixelSize2);
            this.cpE.bxi.setTranslationY((float) (-dimensionPixelSize2));
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cpE.blV, this.cpE.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cpE.blV.getWidth(), (double) this.cpE.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            LinearLayout linearLayout = this.cpE.bxi;
            r3 = new PropertyValuesHolder[2];
            r3[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout, r3);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.start();
            this.cpE.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        float f = (float) (-dimensionPixelOffset);
        this.cpE.blV.setTranslationX(f);
        this.cpE.blV.setTranslationY(f);
        this.cpE.blV.setPivotX((float) (this.cpE.blV.getWidth() - dimensionPixelOffset));
        this.cpE.blV.setPivotY(1.0f);
        this.cpE.blV.setScaleX(0.3f);
        this.cpE.blV.setScaleY(0.3f);
        this.cpE.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.cpE.blV.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(300).setInterpolator(d.dEM).start();
    }
}
