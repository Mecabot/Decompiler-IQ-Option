package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.iqoption.core.d.a;
import com.iqoption.d.on;
import com.iqoption.fragment.base.b;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.ax;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: FragmentMarketIsOpen */
public class bb extends b {
    private on cpv;
    private final Runnable cpw = new bc(this);

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cpv = (on) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_market_is_open, viewGroup, false);
        this.cpv.bxe.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                bb.this.onClose();
            }
        });
        return this.cpv.getRoot();
    }

    public void ND() {
        this.cpv.blV.setAlpha(0.0f);
        if (ax.dws) {
            TimeInterpolator timeInterpolator = d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            this.cpv.bxi.setTranslationX((float) dimensionPixelSize2);
            this.cpv.bxi.setTranslationY((float) (-dimensionPixelSize2));
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cpv.blV, this.cpv.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cpv.blV.getWidth(), (double) this.cpv.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            LinearLayout linearLayout = this.cpv.bxi;
            r3 = new PropertyValuesHolder[2];
            r3[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout, r3);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.start();
            this.cpv.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        float f = (float) (-dimensionPixelOffset);
        this.cpv.blV.setTranslationX(f);
        this.cpv.blV.setTranslationY(f);
        this.cpv.blV.setPivotX((float) (this.cpv.blV.getWidth() - dimensionPixelOffset));
        this.cpv.blV.setPivotY(1.0f);
        this.cpv.blV.setScaleX(0.3f);
        this.cpv.blV.setScaleY(0.3f);
        this.cpv.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.cpv.blV.animate().alpha(0.0f).scaleY(0.8f).scaleX(0.8f).setDuration(300).setInterpolator(d.dEM).start();
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        PopupViewModel.j(requireActivity()).hO("FragmentMarketIsOpen");
        return true;
    }

    public void onResume() {
        super.onResume();
        a.aSe.postDelayed(this.cpw, 4000);
    }

    public void onPause() {
        a.aSe.removeCallbacks(this.cpw);
        super.onPause();
    }

    public static void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, int i) {
        PopupViewModel.j(fragmentActivity).a(new bd(fragmentManager, i, new bb()), "FragmentMarketIsOpen");
    }

    private static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, Fragment fragment) {
        if (fragmentManager.findFragmentByTag("FragmentMarketIsOpen") == null) {
            fragmentManager.beginTransaction().add(i, fragment, "FragmentMarketIsOpen").addToBackStack("FragmentMarketIsOpen").commitAllowingStateLoss();
        }
    }
}
