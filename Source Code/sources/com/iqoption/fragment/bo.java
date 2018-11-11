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
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.d.it;
import com.iqoption.fragment.base.b;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.ax;
import com.iqoption.util.g;
import com.iqoption.util.z;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: MultiplierConfirmDialog */
public final class bo extends b {
    private Animator coM;
    private int coN;
    private it cpU;

    /* compiled from: MultiplierConfirmDialog */
    public static class a {
        public final boolean cpW;

        public a(boolean z) {
            this.cpW = z;
        }
    }

    @NonNull
    private static bo ap(int i, int i2) {
        bo boVar = new bo();
        boVar.setArguments(new g().O("arg.anchorX", i).O("arg.anchorY", i2).toBundle());
        return boVar;
    }

    public static void a(FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager, @IdRes int i, int i2, int i3) {
        PopupViewModel.j(fragmentActivity).a(new bp(fragmentManager, i, i2, i3), "MultiplierConfirmDialog");
    }

    private static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, int i2, int i3) {
        if (fragmentManager.findFragmentByTag("MultiplierConfirmDialog") == null) {
            fragmentManager.beginTransaction().add(i, ap(i2, i3), "MultiplierConfirmDialog").addToBackStack("MultiplierConfirmDialog").commitAllowingStateLoss();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cpU = (it) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_multiplier_confirm, viewGroup, false);
        this.cpU.a(this);
        this.coN = com.iqoption.util.b.bQ(getContext());
        z zVar = new z(getContext());
        Bundle arguments = getArguments();
        arguments.getInt("arg.anchorX");
        final int i = arguments.getInt("arg.anchorY");
        this.cpU.getRoot().getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                bo.this.cpU.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
                ((LayoutParams) bo.this.cpU.blV.getLayoutParams()).topMargin = i;
                bo.this.cpU.blV.requestLayout();
                return false;
            }
        });
        return this.cpU.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        IQApp.Dn().aE(new a(true));
    }

    public boolean onClose() {
        if (af.eN("multiplier_confirmed")) {
            requireFragmentManager().popBackStack();
            PopupViewModel.j(requireActivity()).hO("MultiplierConfirmDialog");
            IQApp.Dn().aE(new a(false));
        } else {
            ahn();
        }
        return true;
    }

    private void ahn() {
        if (this.coM != null) {
            this.coM.cancel();
        }
        this.coM = com.iqoption.util.b.o(this.cpU.blV, this.coN);
    }

    public void ahm() {
        af.i("multiplier_confirmed", true);
        onClose();
    }

    public void ND() {
        this.cpU.blV.setAlpha(0.0f);
        if (ax.dws) {
            TimeInterpolator timeInterpolator = d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            this.cpU.blV.setTranslationX((float) dimensionPixelSize2);
            this.cpU.blV.setTranslationY((float) (-dimensionPixelSize2));
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cpU.blV, this.cpU.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cpU.blV.getWidth(), (double) this.cpU.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            FrameLayout frameLayout = this.cpU.blV;
            r3 = new PropertyValuesHolder[2];
            r3[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r3);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.start();
            this.cpU.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        float f = (float) (-dimensionPixelOffset);
        this.cpU.blV.setTranslationX(f);
        this.cpU.blV.setTranslationY(f);
        this.cpU.blV.setPivotX((float) (this.cpU.blV.getWidth() - dimensionPixelOffset));
        this.cpU.blV.setPivotY(1.0f);
        this.cpU.blV.setScaleX(0.3f);
        this.cpU.blV.setScaleY(0.3f);
        this.cpU.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.cpU.blV.setPivotX((float) this.cpU.blV.getWidth());
        this.cpU.blV.setPivotY(1.0f);
        this.cpU.blV.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(d.dEM).start();
    }
}
