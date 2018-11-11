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
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.google.common.base.f;
import com.iqoption.analytics.EventManager;
import com.iqoption.analytics.m;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.d.iv;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.system.a.c;
import com.iqoption.util.ax;
import com.iqoption.util.g;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;
import java.text.DecimalFormat;
import java.util.Locale;

/* compiled from: OtnCommisssionChangedDialog */
public final class bt extends com.iqoption.fragment.base.b {
    private Builder adT;
    private iv cqd;

    /* compiled from: OtnCommisssionChangedDialog */
    public static class a extends c<Boolean> {
    }

    /* compiled from: OtnCommisssionChangedDialog */
    public static class b extends c<Boolean> {
    }

    @NonNull
    private static bt a(int i, int i2, double d) {
        bt btVar = new bt();
        btVar.setArguments(new g().O("arg.anchorX", i).O("arg.anchorY", i2).e("arg.comm.value", d).toBundle());
        return btVar;
    }

    public static void a(FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager, @IdRes int i, int i2, int i3, double d) {
        PopupViewModel.j(fragmentActivity).a(new bu(fragmentManager, i, i2, i3, d), "OtnCommisssionChangedDialog");
    }

    private static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, int i2, int i3, double d) {
        if (fragmentManager.findFragmentByTag("OtnCommisssionChangedDialog") == null) {
            fragmentManager.beginTransaction().add(i, a(i2, i3, d), "OtnCommisssionChangedDialog").addToBackStack("OtnCommisssionChangedDialog").commit();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        String str;
        CharSequence a;
        String str2;
        ConversionCurrency conversionCurrency;
        this.cqd = (iv) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_otn_commision_changed, viewGroup, false);
        this.cqd.a(this);
        Bundle arguments = getArguments();
        int i = arguments.getInt("arg.anchorY");
        double d = arguments.getDouble("arg.comm.value");
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        Balance CA = com.iqoption.app.a.Cw().CA();
        boolean z = (CA == null || !f.equal(CA.amount, Double.valueOf(0.0d))) && af.eN("otn_commmision");
        ConversionCurrency eh = Cw.eh(Balance.getCurrency(Cw.cG(1)));
        ConversionCurrency eh2 = Cw.eh(Currencies.OTN_CURRENCY);
        String d2 = l.d(eh);
        String d3 = l.d(eh2);
        double doubleValue = l.c(eh).doubleValue();
        double doubleValue2 = l.c(eh2).doubleValue();
        if (eh2 == null) {
            str = Currencies.OTN_CURRENCY;
        } else {
            str = eh2.name;
        }
        DecimalFormat dX = q.dX(2);
        DecimalFormat aGc = l.aGc();
        int i2 = i;
        boolean z2 = z;
        this.cqd.bsF.setText(l.a(d2, Double.valueOf(d), dX));
        this.cqd.bsE.setText(l.e(eh));
        double doubleValue3 = l.d(l.e(Double.valueOf(Balance.getBalanceValue(Cw.CA())), Double.valueOf(doubleValue2)), Double.valueOf(doubleValue)).doubleValue() - d;
        if (doubleValue3 > 0.0d) {
            a = l.a(d3, Double.valueOf(l.d(l.e(Double.valueOf(d), Double.valueOf(doubleValue)), Double.valueOf(doubleValue2)).doubleValue()), aGc);
            str2 = str;
            conversionCurrency = eh;
        } else {
            str2 = str;
            conversionCurrency = eh;
            String a2 = l.a(d2, Double.valueOf(Math.abs(doubleValue3)), dX);
            doubleValue3 = l.d(l.e(Double.valueOf(d - Math.abs(doubleValue3)), Double.valueOf(doubleValue)), Double.valueOf(doubleValue2)).doubleValue();
            a = String.format(Locale.US, "%s + %s", new Object[]{l.a(d3, Double.valueOf(doubleValue3), aGc), a2});
        }
        this.cqd.bsL.setText(a);
        str = str2;
        this.cqd.bsI.setText(str);
        if (com.iqoption.app.managers.feature.b.HT().fg("show-otn-rate")) {
            Object[] objArr = new Object[2];
            objArr[0] = String.format(Locale.US, d3, new Object[]{String.valueOf(1)});
            objArr[1] = l.a(d2, l.d(l.e(Double.valueOf(1.0d), Double.valueOf(doubleValue2)), Double.valueOf(doubleValue)), dX);
            this.cqd.bsJ.setText(String.format(Locale.US, "%s = %s", objArr));
            this.cqd.bsK.setVisibility(0);
            this.cqd.bsJ.setVisibility(0);
        } else {
            this.cqd.bsK.setVisibility(8);
            this.cqd.bsJ.setVisibility(8);
        }
        this.cqd.bsD.setSelected(z2 ^ 1);
        final ConversionCurrency conversionCurrency2 = conversionCurrency;
        this.cqd.bsD.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (!bt.this.cqd.bsD.isSelected()) {
                    bt.this.cqd.bsD.setSelected(true);
                    bt.this.cqd.bsH.setSelected(false);
                    af.i("otn_commmision", false);
                    IQApp.Dn().aE(new a().setValue(Boolean.valueOf(false)));
                    m.b(true, l.e(conversionCurrency2));
                }
            }
        });
        this.cqd.bsH.setSelected(z2);
        this.cqd.bsH.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                Balance CA = com.iqoption.app.a.Cw().CA();
                if (CA == null || !f.equal(CA.amount, Double.valueOf(0.0d))) {
                    if (!bt.this.cqd.bsH.isSelected()) {
                        bt.this.cqd.bsH.setSelected(true);
                        bt.this.cqd.bsD.setSelected(false);
                        af.i("otn_commmision", true);
                        IQApp.Dn().aE(new a().setValue(Boolean.valueOf(true)));
                        m.b(true, str);
                    }
                    return;
                }
                m.b(false, str);
                com.iqoption.app.a.b.eO(bt.this.getString(R.string.the_otn_balance_is_0));
            }
        });
        i = i2;
        this.cqd.getRoot().getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                bt.this.cqd.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
                ((LayoutParams) bt.this.cqd.blV.getLayoutParams()).topMargin = i;
                bt.this.cqd.blV.requestLayout();
                return false;
            }
        });
        return this.cqd.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "crypto-confirmation_change-commission-currency");
        IQApp.Dn().aE(new b().setValue(Boolean.valueOf(true)));
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        PopupViewModel.j(requireActivity()).hO("OtnCommisssionChangedDialog");
        IQApp.Dn().aE(new b().setValue(Boolean.valueOf(false)));
        return true;
    }

    public void ND() {
        this.cqd.blV.setAlpha(0.0f);
        if (ax.dws) {
            TimeInterpolator timeInterpolator = d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            this.cqd.avm.setTranslationX((float) dimensionPixelSize2);
            this.cqd.avm.setTranslationY((float) (-dimensionPixelSize2));
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cqd.blV, this.cqd.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cqd.blV.getWidth(), (double) this.cqd.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            LinearLayout linearLayout = this.cqd.avm;
            r3 = new PropertyValuesHolder[2];
            r3[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout, r3);
            ofPropertyValuesHolder.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.start();
            this.cqd.blV.setAlpha(1.0f);
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        float f = (float) (-dimensionPixelOffset);
        this.cqd.blV.setTranslationX(f);
        this.cqd.blV.setTranslationY(f);
        this.cqd.blV.setPivotX((float) (this.cqd.blV.getWidth() - dimensionPixelOffset));
        this.cqd.blV.setPivotY(1.0f);
        this.cqd.blV.setScaleX(0.3f);
        this.cqd.blV.setScaleY(0.3f);
        this.cqd.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(d.dEM).start();
    }

    public void NE() {
        this.cqd.blV.setPivotX((float) this.cqd.blV.getWidth());
        this.cqd.blV.setPivotY(1.0f);
        this.cqd.blV.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(d.dEM).start();
    }
}
