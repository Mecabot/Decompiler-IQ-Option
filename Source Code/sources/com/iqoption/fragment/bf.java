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
import com.iqoption.d.jf;
import com.iqoption.fragment.base.b;
import com.iqoption.system.a.c;
import com.iqoption.util.g;
import com.iqoption.util.z;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: InvestPortfolioInfoDialog */
public final class bf extends b {
    private jf cpA;

    /* compiled from: InvestPortfolioInfoDialog */
    public static class a extends c<Boolean> {
    }

    @NonNull
    private static bf ao(int i, int i2) {
        bf bfVar = new bf();
        bfVar.setArguments(new g().O("arg.anchorX", i).O("arg.anchorY", i2).toBundle());
        return bfVar;
    }

    public static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, int i2, int i3) {
        if (fragmentManager.findFragmentByTag("CommisionInfoDialog") == null) {
            fragmentManager.beginTransaction().add(i, ao(i2, i3), "CommisionInfoDialog").addToBackStack("CommisionInfoDialog").commit();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cpA = (jf) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_portfolio_invest_info, viewGroup, false);
        this.cpA.a(this);
        Bundle arguments = getArguments();
        final int i = arguments.getInt("arg.anchorX");
        final int i2 = arguments.getInt("arg.anchorY");
        final z zVar = new z(getContext());
        this.cpA.getRoot().getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                bf.this.cpA.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) bf.this.cpA.blV.getLayoutParams();
                layoutParams.topMargin = i2 - zVar.L(8.0f);
                layoutParams.leftMargin = i + zVar.L(4.0f);
                bf.this.cpA.blV.requestLayout();
                return false;
            }
        });
        return this.cpA.getRoot();
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
        this.cpA.blV.setAlpha(0.0f);
        float f = (float) (-getResources().getDimensionPixelOffset(R.dimen.dp12));
        this.cpA.blV.setTranslationX(f);
        this.cpA.blV.setTranslationY(f);
        this.cpA.blV.setPivotX(1.0f);
        this.cpA.blV.setPivotY(1.0f);
        this.cpA.blV.setScaleX(0.3f);
        this.cpA.blV.setScaleY(0.3f);
        this.cpA.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.cpA.blV.setPivotX(1.0f);
        this.cpA.blV.setPivotY(1.0f);
        this.cpA.blV.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(d.dEM).start();
    }
}
