package com.iqoption.trading.history.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.Predicates;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.y;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.st;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.trading.history.a.b;
import com.iqoption.util.ag;
import com.iqoption.util.g;
import com.iqoption.util.i;
import com.iqoption.widget.h;
import com.iqoption.x.R;
import java.util.List;

/* compiled from: TradingHistorySearchResultFragment */
public class c extends a {
    private long cSy;
    private long cUZ;
    private InstrumentType[] dsF;
    private int[] dsG;
    private long dsH;
    private st dsZ;
    private b dta;
    private final y<com.iqoption.trading.history.b.c> dtb = y.wb();

    /* compiled from: TradingHistorySearchResultFragment */
    private static final class a extends com.iqoption.system.c.b<c, com.iqoption.trading.history.b.c> {
        public a(c cVar, Class<com.iqoption.trading.history.b.c> cls) {
            super(cVar, cls);
        }

        /* renamed from: a */
        public void z(@NonNull c cVar, @NonNull com.iqoption.trading.history.b.c cVar2) {
            cVar.dsZ.bnO.setVisibility(8);
            if (cVar2.total == 0) {
                cVar.dsZ.bEg.setVisibility(0);
                return;
            }
            cVar.dsZ.bEg.setVisibility(8);
            cVar.dta.a(cVar2);
        }

        /* renamed from: a */
        public void c(@NonNull c cVar, Throwable th) {
            cVar.dsZ.bnO.setVisibility(8);
            cVar.dsZ.bEg.setVisibility(0);
        }
    }

    @NonNull
    private static c a(long j, List<InstrumentType> list, int[] iArr, long j2, long j3) {
        c cVar = new c();
        cVar.setArguments(new g().b("arg.option.type", InstrumentType.convertToStringArray((List) list)).j("arg.balance.id", j).a("arg.asset.ids", iArr).j("arg.from", j2).j("arg.to", j3).toBundle());
        return cVar;
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, long j, List<InstrumentType> list, int[] iArr, long j2, long j3) {
        if (fragmentManager.findFragmentByTag("TradingHistorySearchResultFragment") == null) {
            fragmentManager.beginTransaction().add(i, a(j, list, iArr, j2, j3), "TradingHistorySearchResultFragment").addToBackStack("TradingHistorySearchResultFragment").commit();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cUZ = bundle.getLong("arg.balance.id");
            this.dsF = InstrumentType.convertToInstrumentTypeArray(bundle.getStringArray("arg.option.type"));
            this.dsG = bundle.getIntArray("arg.asset.ids");
            this.dsH = bundle.getLong("arg.from", 0);
            this.cSy = bundle.getLong("arg.to", 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dsZ = (st) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_trading_history_search_result, viewGroup, false);
        this.dsZ.biw.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                c.this.aN();
            }
        });
        this.dta = new b(new d(this), ((com.iqoption.trading.history.a.c.a) zzakw()).cc(this.cUZ), this.dsZ.bEh, this.cUZ, this.dsF, this.dsG, this.dsH, this.cSy);
        this.dsZ.bEh.setAdapter(this.dta);
        this.dsZ.bEh.addItemDecoration(new h(getResources().getDimensionPixelSize(R.dimen.dp8)));
        aET();
        return this.dsZ.getRoot();
    }

    final /* synthetic */ void c(com.iqoption.trading.history.b.b bVar) {
        b.a(R.id.stackFrame, getFragmentManager(), bVar);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.dtb.P(null);
        }
        ag.b(o.b(o.a(f.a(this.cUZ, this.dsF, this.dsG, this.dsH, this.cSy, 50, 0), this.dtb), e.$instance, com.iqoption.core.d.a.aSd), new a(this, com.iqoption.trading.history.b.c.class));
    }

    static final /* synthetic */ com.iqoption.trading.history.b.c bo(List list) {
        return !i.H(list) ? (com.iqoption.trading.history.b.c) com.google.common.collect.i.c((Iterable) list).e(Predicates.pS()).pq() : null;
    }

    protected View aeO() {
        return this.dsZ.getRoot();
    }

    protected View aeP() {
        FragmentActivity activity = zzakw();
        return activity instanceof com.iqoption.trading.history.fragment.a.a ? ((com.iqoption.trading.history.fragment.a.a) activity).aeP() : null;
    }

    public void ND() {
        super.ND();
        com.iqoption.core.d.a.aSe.postDelayed(new f(this), getAnimationDuration());
    }

    final /* synthetic */ void aEU() {
        this.dtb.P(null);
    }

    private void aET() {
        com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
        StringBuilder stringBuilder = new StringBuilder();
        int length = this.dsG == null ? 0 : this.dsG.length;
        if (length == 0) {
            stringBuilder.append(getString(R.string.all_assets));
        } else {
            int i = 0;
            for (int i2 : this.dsG) {
                if (i == 3) {
                    stringBuilder.append(' ');
                    stringBuilder.append('&');
                    stringBuilder.append(' ');
                    stringBuilder.append(length - 3);
                    stringBuilder.append(' ');
                    stringBuilder.append(getString(R.string.more));
                    break;
                }
                com.iqoption.core.microservices.tradingengine.response.active.a cZ = FI.cZ(i2);
                if (cZ != null) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                        stringBuilder.append(' ');
                    }
                    stringBuilder.append(com.iqoption.util.e.a.s(cZ));
                }
                i++;
            }
        }
        this.dsZ.bEi.setText(stringBuilder.toString());
    }

    public void onStart() {
        super.onStart();
        if (this.dta != null) {
            this.dta.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.dta != null) {
            this.dta.onStop();
        }
    }
}
