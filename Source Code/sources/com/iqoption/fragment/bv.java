package com.iqoption.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import com.iqoption.app.IQApp;
import com.iqoption.d.iz;
import com.iqoption.fragment.base.b;
import com.iqoption.system.a.c;
import com.iqoption.util.g;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: OtnRewardInfoDialog */
public final class bv extends b {
    private iz cqi;

    /* compiled from: OtnRewardInfoDialog */
    public static class a extends c<Boolean> {
    }

    @NonNull
    private static bv as(int i, int i2) {
        bv bvVar = new bv();
        bvVar.setArguments(new g().O("arg.anchorX", i).O("arg.anchorY", i2).toBundle());
        return bvVar;
    }

    public static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, int i2, int i3) {
        if (fragmentManager.findFragmentByTag("OtnRewardInfoDialog") == null) {
            fragmentManager.beginTransaction().add(i, as(i2, i3), "OtnRewardInfoDialog").addToBackStack("OtnRewardInfoDialog").commit();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cqi = (iz) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_otn_reward_info, viewGroup, false);
        this.cqi.a(this);
        final int i = getArguments().getInt("arg.anchorY");
        this.cqi.getRoot().getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                bv.this.cqi.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
                ((LayoutParams) bv.this.cqi.blV.getLayoutParams()).topMargin = i;
                bv.this.cqi.blV.requestLayout();
                return false;
            }
        });
        return this.cqi.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        IQApp.Dn().aE(new a().setValue(Boolean.valueOf(true)));
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        IQApp.Dn().aE(new a().setValue(Boolean.valueOf(false)));
        return true;
    }

    public void ND() {
        this.cqi.blV.setAlpha(0.0f);
        float f = (float) (-getResources().getDimensionPixelOffset(R.dimen.dp12));
        this.cqi.blV.setTranslationX(f);
        this.cqi.blV.setTranslationY(f);
        this.cqi.blV.setPivotX((float) this.cqi.blV.getWidth());
        this.cqi.blV.setPivotY(1.0f);
        this.cqi.blV.setScaleX(0.3f);
        this.cqi.blV.setScaleY(0.3f);
        this.cqi.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.cqi.blV.setPivotX((float) this.cqi.blV.getWidth());
        this.cqi.blV.setPivotY(1.0f);
        this.cqi.blV.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(d.dEM).start();
    }
}
