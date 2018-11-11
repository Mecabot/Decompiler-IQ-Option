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
import com.iqoption.d.if;
import com.iqoption.fragment.base.b;
import com.iqoption.system.a.c;
import com.iqoption.util.g;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import java.util.Locale;

/* compiled from: CommisionInfoDialog */
public final class ap extends b {
    private if coG;

    /* compiled from: CommisionInfoDialog */
    public static class a extends c<Boolean> {
    }

    @NonNull
    private static ap f(int i, int i2, String str) {
        ap apVar = new ap();
        apVar.setArguments(new g().O("arg.anchorX", i).O("arg.anchorY", i2).aA("arg.stringValue", str).toBundle());
        return apVar;
    }

    public static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, int i2, int i3, String str) {
        if (fragmentManager.findFragmentByTag("CommisionInfoDialog") == null) {
            fragmentManager.beginTransaction().add(i, f(i2, i3, str), "CommisionInfoDialog").addToBackStack("CommisionInfoDialog").commit();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.coG = (if) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_commision_info, viewGroup, false);
        this.coG.a(this);
        final int i = getArguments().getInt("arg.anchorY");
        String format = String.format(Locale.US, "%s%%", new Object[]{r6.getString("arg.stringValue")});
        this.coG.brK.setText(getString(R.string.fixed_trade_commission, format));
        this.coG.getRoot().getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                ap.this.coG.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
                ((LayoutParams) ap.this.coG.blV.getLayoutParams()).topMargin = i;
                ap.this.coG.blV.requestLayout();
                return false;
            }
        });
        return this.coG.getRoot();
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
        this.coG.blV.setAlpha(0.0f);
        float f = (float) (-getResources().getDimensionPixelOffset(R.dimen.dp12));
        this.coG.blV.setTranslationX(f);
        this.coG.blV.setTranslationY(f);
        this.coG.blV.setPivotX((float) this.coG.blV.getWidth());
        this.coG.blV.setPivotY(1.0f);
        this.coG.blV.setScaleX(0.3f);
        this.coG.blV.setScaleY(0.3f);
        this.coG.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.coG.blV.setPivotX((float) this.coG.blV.getWidth());
        this.coG.blV.setPivotY(1.0f);
        this.coG.blV.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(d.dEM).start();
    }
}
