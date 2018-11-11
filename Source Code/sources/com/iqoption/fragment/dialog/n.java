package com.iqoption.fragment.dialog;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.a;
import com.iqoption.app.af;
import com.iqoption.d.abi;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.i;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.fragment.fb;
import com.iqoption.util.g;
import com.iqoption.x.R;
import java.util.Locale;

/* compiled from: MoreTradingOpportunities */
public class n extends i {
    private static final String TAG = "com.iqoption.fragment.dialog.n";

    public String gF() {
        return "more-opportunities_popup-shown";
    }

    public static boolean d(FragmentActivity fragmentActivity, FragmentManager fragmentManager) {
        if (!bq(fragmentActivity)) {
            return false;
        }
        PopupViewModel.j(fragmentActivity).a(new o(fragmentManager), TAG);
        return true;
    }

    private static void e(FragmentManager fragmentManager) {
        fragmentManager.beginTransaction().add(R.id.fragment, new n(), TAG).addToBackStack(TAG).commitAllowingStateLoss();
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        abi abi = (abi) DataBindingUtil.inflate(layoutInflater, R.layout.more_trading_opportunities, viewGroup, false);
        abi.bll.setOnClickListener(new p(this));
        abi.bMj.setOnClickListener(new q(this));
        af.DX().bf(true);
        return abi.getRoot();
    }

    private void alb() {
        bc();
        getFragmentManager().beginTransaction().add(R.id.other_fragment, fb.ab(new g().aA("EXTRA_URL", alc()).toBundle()), "WebFragment").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("WebFragment").commitAllowingStateLoss();
    }

    private String alc() {
        Builder Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "more-opportunities_download-button-click");
        if (a.Cw().CZ()) {
            CharSequence DN = af.DX().DN();
            CharSequence EE = af.DX().EE();
            if (TextUtils.isEmpty(DN) || TextUtils.isEmpty(EE)) {
                EventManager.Bm().a(Builder.build());
                return "https://iqoption.com/download";
            }
            EventManager.Bm().a(Builder.setParameters(com.iqoption.core.util.i.ZZ().l("aff", DN).l("aff_track", EE).aab()).build());
            return String.format(Locale.US, "https://iqoption.com/download?aff=%s&afftrack=%s&platform=2", new Object[]{DN, EE});
        }
        EventManager.Bm().a(Builder.build());
        return "https://iqoption.com/download";
    }

    protected int ahd() {
        return getResources().getDimensionPixelSize(R.dimen.dp394);
    }

    /* renamed from: onClose */
    public boolean bc() {
        requireFragmentManager().popBackStack();
        PopupViewModel.j(requireActivity()).hO(TAG);
        return true;
    }

    public static boolean bq(@NonNull Context context) {
        a aL = a.aL(context);
        return com.iqoption.app.managers.feature.a.eW("more-trading-opportunities") && (!aL.Dh() || aL.CU());
    }
}
