package com.iqoption.fragment.dialog.whatsnew.depositpage;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.JsonObject;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.microservices.popupserver.response.a;
import com.iqoption.d.amc;
import com.iqoption.dto.Event;
import com.iqoption.fragment.base.i;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.g;
import com.iqoption.view.d.b;
import com.iqoption.welcomeonboarding.registration.f;
import com.iqoption.x.R;

/* compiled from: WhatsNewDepositPageDialogFragment */
public class c extends i {
    private PopupViewModel aep;
    private a cAZ;

    public String gF() {
        return "whats-new_show-popup";
    }

    public static void a(FragmentActivity fragmentActivity, a aVar) {
        PopupViewModel.j(fragmentActivity).a(new d(fragmentActivity.getSupportFragmentManager(), aVar), aVar);
    }

    private static void a(FragmentManager fragmentManager, a aVar) {
        fragmentManager.beginTransaction().add(R.id.fragment, l(aVar), "WhatsNewDepositPageDialogFragment").addToBackStack("WhatsNewDepositPageDialogFragment").commitAllowingStateLoss();
    }

    private static c l(a aVar) {
        c cVar = new c();
        cVar.setArguments(new g().b("ARG_DIALOG_TYPE", (Parcelable) aVar).toBundle());
        return cVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.aep = PopupViewModel.j(requireActivity());
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        amc amc = (amc) DataBindingUtil.inflate(layoutInflater, R.layout.whats_new_dialog_experimental_deposit_page, viewGroup, false);
        amc.a(this);
        Adapter aVar = new a(new e(this));
        amc.axw.addItemDecoration(new com.iqoption.widget.c(2, ef(R.dimen.dp10), false));
        amc.axw.hasFixedSize();
        amc.axw.setAdapter(aVar);
        bundle = getArguments();
        if (bundle != null) {
            this.cAZ = (a) bundle.getParcelable("ARG_DIALOG_TYPE");
            BanksViewModel R = BanksViewModel.R(this);
            R.k(this.cAZ);
            R.alA().observe(this, new f(aVar));
        }
        amc.bUE.setOnClickListener(new b() {
            public void q(View view) {
                Context tradeRoomActivity = c.this.getTradeRoomActivity();
                if (tradeRoomActivity != null) {
                    if (com.iqoption.app.a.aL(tradeRoomActivity).CZ()) {
                        f.a(tradeRoomActivity, tradeRoomActivity.getSupportFragmentManager());
                    } else {
                        tradeRoomActivity.Aq();
                    }
                }
                c.this.aN();
            }
        });
        return amc.getRoot();
    }

    final /* synthetic */ void g(BankItem bankItem) {
        Context tradeRoomActivity = getTradeRoomActivity();
        if (tradeRoomActivity != null) {
            if (com.iqoption.app.a.aL(tradeRoomActivity).CZ()) {
                f.a(tradeRoomActivity, tradeRoomActivity.getSupportFragmentManager());
            } else {
                tradeRoomActivity.b(null, bankItem.alz());
            }
        }
        aN();
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Nullable
    public JsonObject ajZ() {
        return com.iqoption.core.util.i.ZZ().l(Param.TYPE, this.cAZ.Wr() != null ? this.cAZ.Wr() : "").aab();
    }

    public boolean onClose() {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "whats-new_close").build());
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.popBackStack();
        }
        this.aep.i(this.cAZ);
        return true;
    }
}
