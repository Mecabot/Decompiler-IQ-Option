package com.iqoption.fragment.rightpanel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.Tracker;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.c;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import com.iqoption.core.util.i.b;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.fragment.cr;
import com.iqoption.util.MusicUtil;
import com.iqoption.util.MusicUtil.Sound;
import com.iqoption.util.l;
import com.iqoption.welcomeonboarding.registration.f;
import java.util.concurrent.TimeUnit;

/* compiled from: CallPutInteractor */
final class e {
    @NonNull
    private final a cEZ;

    /* compiled from: CallPutInteractor */
    interface a {
        double UO();

        boolean amH();

        void amI();

        void amJ();

        boolean amK();

        void amR();

        boolean amS();

        TradeRoomActivity amV();

        void amW();

        void dt(boolean z);

        Context getContext();

        @Nullable
        InstrumentType getInstrumentType();

        cr getTradeFragment();
    }

    e(@NonNull a aVar) {
        this.cEZ = aVar;
    }

    final void ane() {
        if (this.cEZ.amS()) {
            this.cEZ.amR();
        } else if (this.cEZ.amH()) {
            this.cEZ.amI();
        } else {
            anf();
        }
    }

    final boolean anf() {
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        double UO = this.cEZ.UO();
        double doubleValue = Cw.Cx().doubleValue();
        double[] N = l.N(this.cEZ.getInstrumentType());
        if (UO > doubleValue) {
            this.cEZ.amW();
            FragmentActivity amV = this.cEZ.amV();
            if (!(amV == null || doubleValue >= N[0] || c.Gn().Gq())) {
                if (Cw.CZ()) {
                    f.a(amV, amV.getSupportFragmentManager());
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_open-account").build());
                } else if (Cw.Cy() == 1) {
                    amV.Aq();
                }
            }
            return false;
        } else if (UO > N[1]) {
            this.cEZ.dt(true);
            return false;
        } else if (UO < N[0]) {
            this.cEZ.dt(false);
            return false;
        } else {
            this.cEZ.amJ();
            MusicUtil.a(this.cEZ.getContext(), Sound.DO_BUY);
            com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
            Strike Ix = com.iqoption.app.managers.tab.a.Il().Ix();
            com.iqoption.core.d.a.aSc.execute(new f(this, UO, this.cEZ.amK(), Iw, Ix));
            return true;
        }
    }

    private void a(double d, boolean z, com.iqoption.core.microservices.tradingengine.response.active.a aVar, Strike strike) {
        if (aVar != null) {
            try {
                Thread.sleep(100);
                af DX = af.DX();
                com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
                Context Dk = IQApp.Dk();
                if (Cw.Cy() != 1 || Cw.CZ()) {
                    if (Cw.Cy() == 4) {
                        if (!DX.Ef()) {
                            DX.aM(true);
                            EventManager.Bm().b(new Event(Event.CATEGORY_SYSTEM, "M_First_Training_Deal"));
                        }
                        if (!Cw.CZ()) {
                            IQApp.a("demo_deal", null);
                        } else if (!DX.Eg()) {
                            DX.aN(true);
                            EventManager.Bm().b(new Event(Event.CATEGORY_SYSTEM, "M_First_Demo_Deal"));
                        }
                    }
                } else if (!DX.Eh()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("blue_first_deposit");
                    stringBuilder.append(com.iqoption.app.a.Cw().getUserId());
                    boolean eN = af.eN(stringBuilder.toString());
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("first_real_bet_sent");
                    stringBuilder2.append(com.iqoption.app.a.Cw().getUserId());
                    boolean eN2 = af.eN(stringBuilder2.toString());
                    if (eN && !eN2) {
                        IQApp.a("first_deal_real", null);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("first_real_bet_sent");
                    stringBuilder.append(com.iqoption.app.a.Cw().getUserId());
                    af.i(stringBuilder.toString(), true);
                    EventManager.Bm().b(new Event(Event.CATEGORY_SYSTEM, "M_First_Real_Deal"));
                    DX.aO(true);
                }
                int Ei = DX.Ei();
                cr tradeFragment = this.cEZ.getTradeFragment();
                if (!(tradeFragment == null || tradeFragment.crC)) {
                    Tracker aP = IQApp.aP(this.cEZ.getContext());
                    EventBuilder action = new EventBuilder().setCategory("Android").setAction("Deal");
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("activeId=");
                    stringBuilder3.append(aVar.getActiveId());
                    aP.send(action.setLabel(stringBuilder3.toString()).build());
                    tradeFragment.crC = true;
                }
                if (Cw.Cy() == 1 && !Cw.CZ()) {
                    EventManager.Bm().b(new Event(Event.CATEGORY_SYSTEM, "M_Real_Deal"));
                } else if (Cw.Cy() == 4) {
                    EventManager.Bm().b(new Event(Event.CATEGORY_SYSTEM, "M_Training_Deal"));
                } else if (Cw.CZ()) {
                    EventManager.Bm().b(new Event(Event.CATEGORY_SYSTEM, "M_Demo_Deal"));
                }
                if (Ei == 0) {
                    IQApp.a("deal", null);
                    AppEventsLogger.T(Dk).bq("First Deal");
                } else if (Ei == 4) {
                    AppEventsLogger.T(Dk).bq("Fifth Deal");
                } else if (Ei == 19) {
                    AppEventsLogger.T(Dk).bq("Twentieth Deal");
                } else if (Ei >= 20 && !DX.EX()) {
                    long EW = DX.EW();
                    long currentTimeMillis = System.currentTimeMillis() - EW;
                    if (EW > 0 && currentTimeMillis <= TimeUnit.HOURS.toMillis(72)) {
                        AppEventsLogger.T(Dk).bq("fb_mobile_rate");
                        EventManager.Bm().b(Event.Builder(Event.CATEGORY_SYSTEM, Event.MQL).build());
                        IQApp.a(Event.MQL, null);
                        DX.bc(true);
                    }
                }
                DX.cM(Ei + 1);
                b l = i.ZZ().l("balance_type_id", Integer.valueOf(Cw.CZ() ? 0 : Cw.Cy())).l("instrument_type", aVar.getInstrumentType());
                if (strike != null) {
                    l.l("strike_value", String.valueOf(strike.getValue()));
                }
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, z ? "traderoom_deal-call" : "traderoom_deal-put").setValue(Double.valueOf(d)).setParameters(l.aab()).build());
            } catch (Exception unused) {
            }
        }
    }
}
