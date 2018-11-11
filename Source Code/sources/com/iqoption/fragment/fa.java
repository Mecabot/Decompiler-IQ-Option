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
import com.iqoption.d.jv;
import com.iqoption.fragment.base.b;
import com.iqoption.util.g;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: TrailingStopInfoDialog */
public final class fa extends b {
    private jv ctb;

    @NonNull
    private static fa at(int i, int i2) {
        fa faVar = new fa();
        faVar.setArguments(new g().O("arg.anchorX", i).O("arg.anchorY", i2).toBundle());
        return faVar;
    }

    public static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, int i2, int i3) {
        if (fragmentManager.findFragmentByTag("TrailingStopInfoDialog") == null) {
            fragmentManager.beginTransaction().add(i, at(i2, i3), "TrailingStopInfoDialog").addToBackStack("TrailingStopInfoDialog").commit();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.ctb = (jv) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_trailing_info, viewGroup, false);
        this.ctb.a(this);
        Bundle arguments = getArguments();
        final int i = arguments.getInt("arg.anchorX");
        final int i2 = arguments.getInt("arg.anchorY");
        this.ctb.getRoot().getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                fa.this.ctb.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) fa.this.ctb.blV.getLayoutParams();
                layoutParams.topMargin = i2;
                layoutParams.leftMargin = i;
                fa.this.ctb.blV.requestLayout();
                return false;
            }
        });
        return this.ctb.getRoot();
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        return true;
    }

    public void ND() {
        this.ctb.blV.setAlpha(0.0f);
        float f = (float) (-getResources().getDimensionPixelOffset(R.dimen.dp12));
        this.ctb.blV.setTranslationX(f);
        this.ctb.blV.setTranslationY(f);
        this.ctb.blV.setPivotX(1.0f);
        this.ctb.blV.setPivotY(1.0f);
        this.ctb.blV.setScaleX(0.3f);
        this.ctb.blV.setScaleY(0.3f);
        this.ctb.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.ctb.blV.setPivotX(1.0f);
        this.ctb.blV.setPivotY(1.0f);
        this.ctb.blV.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(d.dEM).start();
    }
}
