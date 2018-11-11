package com.iqoption.trading.history.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.collect.Maps;
import com.iqoption.d.sz;
import com.iqoption.trading.history.fragment.a.a;
import com.iqoption.util.g;
import com.iqoption.view.materialcalendar.MaterialCalendarView;
import com.iqoption.view.materialcalendar.b;
import com.iqoption.x.R;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: TradingHistorySearchSetDateFragment */
public class m extends a {
    private b dts;
    private b dtt;
    private boolean dtu;
    private Map<Integer, Pair<b, b>> dtv = aEY();
    private sz dtw;

    @NonNull
    private static m b(b bVar, b bVar2) {
        m mVar = new m();
        mVar.setArguments(new g().b("arg.custom.from", (Parcelable) bVar).b("arg.custom.to", (Parcelable) bVar2).toBundle());
        return mVar;
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, b bVar, b bVar2) {
        if (fragmentManager.findFragmentByTag("TradingHistorySearchSetDateFragment") == null) {
            fragmentManager.beginTransaction().add(i, b(bVar, bVar2), "TradingHistorySearchSetDateFragment").addToBackStack("TradingHistorySearchSetDateFragment").commit();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dtw = (sz) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_trading_history_set_date, viewGroup, false);
        this.dtw.biw.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                m.this.aN();
            }
        });
        Bundle arguments = getArguments();
        this.dts = (b) arguments.getParcelable("arg.custom.from");
        this.dtt = (b) arguments.getParcelable("arg.custom.to");
        this.dtw.bEx.setSelectionMode(3);
        this.dtw.bEx.aJv().aJx().k(b.aJd()).commit();
        this.dtw.bEx.g(this.dts, this.dtt);
        this.dtw.bEx.setOnRangeSelectedListener(new n(this));
        this.dtw.bEx.setOnDateChangedListener(new o(this));
        this.dtw.bEA.setOnCheckedChangeListener(new p(this));
        aEX();
        return this.dtw.getRoot();
    }

    final /* synthetic */ void a(MaterialCalendarView materialCalendarView, b bVar, boolean z) {
        this.dtu = false;
        if (z) {
            this.dts = bVar;
            this.dtt = bVar;
            aEX();
            return;
        }
        this.dts = null;
        this.dtt = null;
        this.dtw.bEA.clearCheck();
    }

    private void aEX() {
        Pair pair = new Pair(this.dts, this.dtt);
        for (Entry entry : this.dtv.entrySet()) {
            if (((Pair) entry.getValue()).equals(pair)) {
                this.dtw.bEA.check(((Integer) entry.getKey()).intValue());
                this.dtu = false;
                return;
            }
        }
    }

    protected View aeO() {
        return this.dtw.getRoot();
    }

    protected View aeP() {
        FragmentActivity activity = zzakw();
        return activity instanceof a ? ((a) activity).aeP() : null;
    }

    public boolean onClose() {
        FragmentActivity activity = zzakw();
        if (activity instanceof com.iqoption.trading.history.fragment.viewmodel.b) {
            ((com.iqoption.trading.history.fragment.viewmodel.b) activity).a(this.dts, this.dtt);
        }
        return super.onClose();
    }

    public static Map<Integer, Pair<b, b>> aEY() {
        Map<Integer, Pair<b, b>> us = Maps.us();
        b aJd = b.aJd();
        us.put(Integer.valueOf(R.id.today), new Pair(aJd, aJd));
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        b b = b.b(instance);
        us.put(Integer.valueOf(R.id.yestarday), new Pair(b, b));
        instance.add(5, -5);
        us.put(Integer.valueOf(R.id.lastSevenDay), new Pair(b.b(instance), aJd));
        instance.add(5, -23);
        us.put(Integer.valueOf(R.id.last30days), new Pair(b.b(instance), aJd));
        instance.add(5, 29);
        instance.add(2, -3);
        us.put(Integer.valueOf(R.id.threeMonths), new Pair(b.b(instance), aJd));
        return us;
    }
}
