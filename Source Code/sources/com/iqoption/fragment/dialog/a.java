package com.iqoption.fragment.dialog;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.dialogs.a.c;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.b;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.util.EventSenderLifecycleObserver;
import com.iqoption.util.g;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import kotlin.l;

/* compiled from: ConfirmCloseFullInvestPositionDialog */
public class a extends b {
    private com.iqoption.fragment.dialog.d.a cAd;
    private e cAe;
    private com.iqoption.mobbtech.connect.response.options.b cAf;
    private String cAg;
    private n<com.iqoption.core.ui.d.a> cAh = Suppliers.a(new n<com.iqoption.core.ui.d.a>() {
        /* renamed from: akZ */
        public com.iqoption.core.ui.d.a get() {
            return new com.iqoption.core.ui.d.a(a.this.ckK.awS, a.this.ckK.btF);
        }
    });
    private a cAi = new a(this, null);
    private c ckK;

    /* compiled from: ConfirmCloseFullInvestPositionDialog */
    private static class a implements com.iqoption.view.a.b.a {
        private final WeakReference<a> ckC;

        /* synthetic */ a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private a(a aVar) {
            this.ckC = new WeakReference(aVar);
        }

        public void onTick(long j) {
            a aVar = (a) this.ckC.get();
            if (aVar != null && aVar.isAdded()) {
                aVar.afo();
            }
        }
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, com.iqoption.fragment.dialog.d.a aVar, com.iqoption.mobbtech.connect.response.options.b bVar) {
        a(fragmentManager, i, new g().a("arg.OpenOptionGroup", (Parcelable) bVar).toBundle(), aVar);
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, com.iqoption.fragment.dialog.d.a aVar, e eVar) {
        a(fragmentManager, i, new g().a("arg.position", (Parcelable) eVar).toBundle(), aVar);
    }

    private static void a(FragmentManager fragmentManager, @IdRes int i, Bundle bundle, com.iqoption.fragment.dialog.d.a aVar) {
        if (fragmentManager.findFragmentByTag("ConfirmCloseFullInvestPositionDialog") == null) {
            fragmentManager.beginTransaction().add(i, a(bundle, aVar), "ConfirmCloseFullInvestPositionDialog").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("ConfirmCloseFullInvestPositionDialog").commit();
        }
    }

    private static a a(Bundle bundle, com.iqoption.fragment.dialog.d.a aVar) {
        a aVar2 = new a();
        aVar2.setArguments(bundle);
        aVar2.cAd = aVar;
        return aVar2;
    }

    public void ND() {
        ((com.iqoption.core.ui.d.a) this.cAh.get()).bd(NF()).start();
    }

    public void NE() {
        ((com.iqoption.core.ui.d.a) this.cAh.get()).be(NG()).start();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.cAd == null) {
            i.d("ConfirmCloseFullInvestPositionDialog", "Callback is null");
            onClose();
            return null;
        }
        this.ckK = (c) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_simple, viewGroup, false);
        this.ckK.agA.setVisibility(8);
        this.ckK.blj.setVisibility(8);
        Bundle arguments = getArguments();
        this.cAe = (e) arguments.getParcelable("arg.position");
        this.cAf = (com.iqoption.mobbtech.connect.response.options.b) arguments.getParcelable("arg.OpenOptionGroup");
        OnClickListener anonymousClass2 = new com.iqoption.view.d.b() {
            public void q(View view) {
                a.this.cAd.air();
                a.this.aN();
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "sell-zero_cancel").setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", a.this.getInstrumentType()).l("asset_id", a.this.getActiveId()).aab()).build());
            }
        };
        this.ckK.getRoot().setOnClickListener(anonymousClass2);
        this.ckK.ckR.setText(R.string.cancel);
        this.ckK.ckS.setText(R.string.confirm);
        this.ckK.ckR.setOnClickListener(anonymousClass2);
        this.ckK.ckS.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (a.this.cAe == null) {
                    a.this.cAd.b(a.this.cAf);
                } else {
                    a.this.cAd.o(a.this.cAe);
                }
                a.this.aN();
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "sell-zero_confirm").setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", a.this.getInstrumentType()).l("asset_id", a.this.getActiveId()).aab()).build());
            }
        });
        this.cAg = getString(R.string.you_will_lose_the_full_invest_amount_n1);
        akY();
        return this.ckK.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getLifecycle().a(new EventSenderLifecycleObserver("sell-zero_show-popup", new b(this)));
    }

    final /* synthetic */ l h(Builder builder) {
        builder.setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", getInstrumentType()).l("asset_id", getActiveId()).aab());
        return null;
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        return true;
    }

    private void akY() {
        if (!TextUtils.isEmpty(this.cAg)) {
            if (!(this.cAe == null && this.cAf == null)) {
                this.ckK.aip.setText(String.format(this.cAg, new Object[]{com.iqoption.util.l.r(Double.valueOf(Math.abs(getSellPnl())))}));
            }
        }
    }

    private double getSellPnl() {
        return this.cAe == null ? this.cAf.getSellPnl() : this.cAe.getSellPnl();
    }

    private InstrumentType getInstrumentType() {
        return this.cAe == null ? this.cAf.instrumentType : this.cAe.getInstrumentType();
    }

    private Integer getActiveId() {
        return Integer.valueOf(this.cAe == null ? this.cAf.activeId.intValue() : this.cAe.getActiveId());
    }

    public void onStart() {
        super.onStart();
        startTimer();
    }

    public void onStop() {
        super.onStop();
        afr();
    }

    private void afo() {
        akY();
    }

    private void startTimer() {
        com.iqoption.view.a.b.aIK().a(this.cAi, Integer.valueOf(5));
    }

    private void afr() {
        com.iqoption.view.a.b.aIK().b(this.cAi);
    }
}
