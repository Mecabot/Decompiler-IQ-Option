package com.iqoption.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.a;
import com.iqoption.app.af;
import com.iqoption.d.jt;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.b;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.mobbtech.connect.request.api.Requests;
import com.iqoption.util.bg;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: TradeOnPracticeDialog */
public class u extends b {
    private Builder adT;
    private jt cfH;

    public long getAnimationDuration() {
        return 350;
    }

    private static u aex() {
        return new u();
    }

    public static void c(@NonNull FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager) {
        a Cw = a.Cw();
        if (!af.eN("is_showed_trade_on_practice_dialog") && af.DX().Es().booleanValue() && Cw.Cy() == 1 && Cw.Cx().doubleValue() == 0.0d) {
            a(fragmentActivity, fragmentManager);
        }
    }

    public static void a(@NonNull FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager) {
        PopupViewModel.j(fragmentActivity).a(new v(fragmentManager), "TradeOnPracticeDialog");
    }

    private static void e(@NonNull FragmentManager fragmentManager) {
        if (fragmentManager.findFragmentByTag("TradeOnPracticeDialog") == null) {
            fragmentManager.beginTransaction().add(R.id.fragment, aex(), "TradeOnPracticeDialog").addToBackStack("TradeOnPracticeDialog").commitAllowingStateLoss();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cfH = (jt) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_trade_on_practice, viewGroup, false);
        af.i("is_showed_trade_on_practice_dialog", true);
        this.cfH.btH.setOnClickListener(new w(this));
        this.cfH.bjF.setOnClickListener(new x(this));
        if (a.Cw().CZ()) {
            this.cfH.buz.setText(R.string.trade);
        }
        this.cfH.buz.setOnClickListener(new y(this));
        return this.cfH.getRoot();
    }

    final /* synthetic */ void aa(View view) {
        a Cw = a.Cw();
        if (!Cw.CZ()) {
            Long l;
            Balance cG = Cw.cG(4);
            if (cG == null) {
                l = null;
            } else {
                l = cG.id;
            }
            if (l != null) {
                Requests.w(l);
            }
        }
        aN();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "trade_on_practice_dialog");
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }

    private void aey() {
        com.iqoption.util.b.o(this.cfH.btI, com.iqoption.util.b.bQ(requireContext()));
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        PopupViewModel.j(requireActivity()).hO("TradeOnPracticeDialog");
        return true;
    }

    public void ND() {
        com.iqoption.view.a.a.a.c(this.cfH.bjF, bg.getColor(R.color.transparent), bg.getColor(R.color.black_66)).setInterpolator(d.dEM);
        ObjectAnimator.ofPropertyValuesHolder(this.cfH.btI, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f, 1.0f})}).setInterpolator(new OvershootInterpolator(2.5f));
        ObjectAnimator.ofFloat(this.cfH.btI, View.ALPHA, new float[]{0.0f, 1.0f}).setInterpolator(d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{r0, r1, r3});
        animatorSet.start();
    }

    public void NE() {
        Animator c = com.iqoption.view.a.a.a.c(this.cfH.bjF, bg.getColor(R.color.black_66), bg.getColor(R.color.transparent));
        FrameLayout frameLayout = this.cfH.btI;
        r2 = new PropertyValuesHolder[3];
        r2[0] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f});
        r2[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f});
        r2[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, getAnimationDuration());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder});
        animatorSet.setInterpolator(d.dEM);
        animatorSet.start();
    }
}
