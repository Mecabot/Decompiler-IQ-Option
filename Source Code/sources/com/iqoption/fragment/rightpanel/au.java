package com.iqoption.fragment.rightpanel;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.app.af;
import com.iqoption.app.managers.feature.b;
import com.iqoption.core.microservices.risks.response.overnightfee.d;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.fragment.cr;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.util.Calendar;

/* compiled from: RightPanelDelegate */
abstract class au implements a {
    private int ahf = -1;
    private final RightPanelFragment cHs;
    protected final boolean cHt;

    void destroy() {
    }

    @NonNull
    abstract View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    void w(@NonNull a aVar) {
    }

    static void bn(View view) {
        if (!view.isEnabled()) {
            view.animate().cancel();
            view.animate().alpha(1.0f).start();
            view.setEnabled(true);
        }
    }

    static void bo(View view) {
        if (view.isEnabled()) {
            view.animate().cancel();
            view.animate().alpha(0.7f).start();
            view.setEnabled(false);
        }
    }

    au(RightPanelFragment rightPanelFragment) {
        this.cHs = rightPanelFragment;
        this.cHt = b.HT().ff("not-accept-deals");
    }

    protected final FragmentManager getFragmentManager() {
        return this.cHs.zzakw().getSupportFragmentManager();
    }

    public void amW() {
        cr ajW = this.cHs.ajW();
        if (ajW != null) {
            ajW.hD(this.cHs.getString(R.string.investment_bigger_then_balance));
        }
    }

    public void dt(boolean z) {
        cr ajW = this.cHs.ajW();
        if (ajW != null) {
            ajW.hD(this.cHs.getString(z ? R.string.maximum_investment_amount_for_deal : R.string.minimum_investment_amount_for_deal));
        }
    }

    public final Context getContext() {
        return this.cHs.getContext();
    }

    public cr getTradeFragment() {
        return this.cHs.ajW();
    }

    public TradeRoomActivity amV() {
        return this.cHs.getTradeRoomActivity();
    }

    public RightPanelFragment amU() {
        return this.cHs;
    }

    public LiveData<d> amT() {
        return this.cHs.cHy.amT();
    }

    public Calendar getCalendar() {
        return this.cHs.cHy.getCalendar();
    }

    public boolean amS() {
        cr ajW = this.cHs.ajW();
        if (ajW == null || !ajW.cV(true)) {
            return false;
        }
        return true;
    }

    public void amR() {
        cr ajW = this.cHs.ajW();
        if (ajW != null) {
            ajW.cW(false);
        }
    }

    public void bg(View view) {
        if (this.ahf == -1) {
            this.ahf = getContext().getResources().getDimensionPixelSize(R.dimen.dp1);
        }
        com.iqoption.util.b.o(view, this.ahf);
    }

    protected double Ea() {
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        double Ea = af.DX().Ea();
        if (Ea != 0.0d) {
            return Ea;
        }
        if (Cw.Cy() == 4) {
            return c(Cw);
        }
        return l.N(getInstrumentType())[0];
    }

    protected double c(com.iqoption.app.a aVar) {
        Double i = com.iqoption.util.au.i(aVar.Cx(), com.iqoption.app.managers.feature.a.bw(aVar.CZ()));
        if (i == null) {
            return 50.0d;
        }
        af.DX().k(i.doubleValue());
        return i.doubleValue();
    }
}
