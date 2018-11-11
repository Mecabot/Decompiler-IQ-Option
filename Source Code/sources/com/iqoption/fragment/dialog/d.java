package com.iqoption.fragment.dialog;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.dialogs.a.c;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Event.Builder;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.util.EventSenderLifecycleObserver;
import com.iqoption.util.bc;
import com.iqoption.util.g;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import kotlin.l;

/* compiled from: ConfirmClosePositionDialog */
public class d extends com.iqoption.fragment.base.b {
    private boolean JF = false;
    private a cAd;
    private e cAe;
    private com.iqoption.mobbtech.connect.response.options.b cAf;
    private n<com.iqoption.core.ui.d.a> cAh = Suppliers.a(new n<com.iqoption.core.ui.d.a>() {
        /* renamed from: akZ */
        public com.iqoption.core.ui.d.a get() {
            return new com.iqoption.core.ui.d.a(d.this.ckK.awS, d.this.ckK.btF);
        }
    });
    private String cAo = "";
    private ForegroundColorSpan cAp;
    private ForegroundColorSpan cAq;
    private String[] cAr;
    private b cAs = new b(this, null);
    private c ckK;

    /* compiled from: ConfirmClosePositionDialog */
    public interface a {
        void air();

        void b(com.iqoption.mobbtech.connect.response.options.b bVar);

        void o(e eVar);
    }

    /* compiled from: ConfirmClosePositionDialog */
    private static class b implements com.iqoption.view.a.b.a {
        private final WeakReference<d> ckC;

        /* synthetic */ b(d dVar, AnonymousClass1 anonymousClass1) {
            this(dVar);
        }

        private b(d dVar) {
            this.ckC = new WeakReference(dVar);
        }

        public void onTick(long j) {
            d dVar = (d) this.ckC.get();
            if (dVar != null && dVar.isAdded()) {
                dVar.afo();
            }
        }
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, a aVar, com.iqoption.mobbtech.connect.response.options.b bVar) {
        a(fragmentManager, i, new g().a("arg.OpenOptionGroup", (Parcelable) bVar).toBundle(), aVar);
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, a aVar, e eVar) {
        a(fragmentManager, i, new g().a("arg.position", (Parcelable) eVar).toBundle(), aVar);
    }

    private static void a(FragmentManager fragmentManager, @IdRes int i, Bundle bundle, a aVar) {
        if (fragmentManager.findFragmentByTag("ConfirmClosePositionDialog") == null) {
            fragmentManager.beginTransaction().add(i, b(bundle, aVar), "ConfirmClosePositionDialog").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("ConfirmClosePositionDialog").commit();
        }
    }

    private static d b(Bundle bundle, a aVar) {
        d dVar = new d();
        dVar.setArguments(bundle);
        dVar.cAd = aVar;
        return dVar;
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
            i.d("ConfirmClosePositionDialog", "Callback is null");
            onClose();
            return null;
        }
        this.ckK = (c) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_simple, viewGroup, false);
        this.ckK.agA.setVisibility(8);
        this.ckK.blj.setVisibility(8);
        Bundle arguments = getArguments();
        this.cAe = (e) arguments.getParcelable("arg.position");
        this.cAf = (com.iqoption.mobbtech.connect.response.options.b) arguments.getParcelable("arg.OpenOptionGroup");
        this.cAp = new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.white));
        this.cAq = new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.white));
        OnClickListener anonymousClass2 = new com.iqoption.view.d.b() {
            public void q(View view) {
                d.this.cAd.air();
                d.this.JF = true;
                d.this.aN();
            }
        };
        this.ckK.getRoot().setOnClickListener(anonymousClass2);
        this.ckK.ckR.setText(R.string.cancel);
        this.ckK.ckS.setText(R.string.confirm);
        this.ckK.ckR.setOnClickListener(anonymousClass2);
        this.ckK.ckS.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (d.this.cAe == null) {
                    d.this.cAd.b(d.this.cAf);
                } else {
                    d.this.cAd.o(d.this.cAe);
                }
                d.this.aN();
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getString(R.string.confirm_closing_with));
        stringBuilder.append(" %s");
        String stringBuilder2 = stringBuilder.toString();
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(getActiveId()), getInstrumentType());
        if (a != null) {
            this.cAo = com.iqoption.util.e.a.s(a);
        }
        this.cAr = stringBuilder2.split(Currencies.REPLACE_CURRENCY_MASK);
        akY();
        return this.ckK.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getLifecycle().a(new EventSenderLifecycleObserver("sell_confirm-show", new e(this)));
    }

    final /* synthetic */ l i(Builder builder) {
        builder.setValue(Double.valueOf(this.JF ? 1.0d : 0.0d));
        return null;
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        return true;
    }

    private void akY() {
        if (this.cAr.length != 0) {
            if (!(this.cAe == null && this.cAf == null)) {
                this.ckK.aip.setText(new bc().jO(this.cAr[0]).bM(this.cAp).jO(this.cAo).aGw().jO(this.cAr[1]).bM(this.cAq).jO(com.iqoption.util.l.r(Double.valueOf(ala() + getSellPnl()))).aCT());
            }
        }
    }

    private double getSellPnl() {
        return this.cAe == null ? this.cAf.getSellPnl() : this.cAe.getSellPnl();
    }

    private double ala() {
        return (this.cAe == null ? this.cAf.getInvestSum() : this.cAe.getInvestSum()).doubleValue();
    }

    private int getActiveId() {
        return this.cAe == null ? this.cAf.activeId.intValue() : this.cAe.getActiveId();
    }

    private InstrumentType getInstrumentType() {
        return this.cAe == null ? this.cAf.instrumentType : this.cAe.getInstrumentType();
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
        com.iqoption.view.a.b.aIK().a(this.cAs, Integer.valueOf(5));
    }

    private void afr() {
        com.iqoption.view.a.b.aIK().b(this.cAs);
    }
}
