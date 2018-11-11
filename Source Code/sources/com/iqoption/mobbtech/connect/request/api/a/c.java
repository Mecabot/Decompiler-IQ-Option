package com.iqoption.mobbtech.connect.request.api.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.connect.k;
import com.iqoption.core.connect.m;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.i;
import com.iqoption.core.microservices.tradingengine.response.active.h;
import com.iqoption.dto.Balance;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.PendingOrderWrapper;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.util.ag;
import java.util.Iterator;
import java.util.Set;

/* compiled from: OrderRequests */
public class c extends a {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.api.a.c";
    private static final Set<Long> cUV = Sets.uJ();

    /* compiled from: OrderRequests */
    public static class a {
        private double aTA;
        private boolean cFG;
        private h cUY;
        private long cUZ;
        private boolean cVa;
        private Double cVb;
        private Boolean cVc;
        private String cVd;
        private Double cjY;
        private Double cjZ;
        private int leverage;

        public a a(h hVar) {
            this.cUY = hVar;
            return this;
        }

        public a iC(String str) {
            this.cVd = str;
            return this;
        }

        public a fs(int i) {
            this.leverage = i;
            return this;
        }

        public a z(double d) {
            this.aTA = d;
            return this;
        }

        public a bF(long j) {
            this.cUZ = j;
            return this;
        }

        public a ec(boolean z) {
            this.cVa = z;
            return this;
        }

        public a ed(boolean z) {
            this.cFG = z;
            return this;
        }

        public a m(Double d) {
            this.cVb = d;
            return this;
        }

        public a n(Double d) {
            this.cjZ = d;
            return this;
        }

        public a o(Double d) {
            this.cjY = d;
            return this;
        }

        public a q(Boolean bool) {
            this.cVc = bool;
            return this;
        }
    }

    /* compiled from: OrderRequests */
    public static class b {
        public final boolean cvu;
        public final Position position;

        public b(Position position, boolean z) {
            this.position = position;
            this.cvu = z;
        }
    }

    public static boolean y(Long l) {
        return cUV.contains(l);
    }

    public static boolean q(ImmutableList<e> immutableList) {
        boolean z = false;
        if (cUV.isEmpty()) {
            return false;
        }
        Iterator sI = immutableList.iterator();
        while (sI.hasNext()) {
            e eVar = (e) sI.next();
            if (cUV.contains(eVar.getId())) {
                cUV.remove(eVar.getId());
                z = true;
            }
        }
        return z;
    }

    private c() {
    }

    public static s<com.iqoption.core.microservices.tradingengine.response.c.a> a(a aVar) {
        if (aVar.cUY == null) {
            return o.m(new NullPointerException("Active is null"));
        }
        String c = aVar.cVd == null ? Order.MARKET : aVar.cVd;
        InstrumentType instrumentType = aVar.cUY.getInstrumentType();
        int d = aVar.leverage;
        if (aVar.cVb != null) {
            ActiveQuote da = com.iqoption.app.managers.c.Gn().da(aVar.cUY.getActiveId());
            if (da != null) {
                if (aVar.cVb.doubleValue() > (aVar.cVa ? da.getAsk(instrumentType, d) : da.getBid(instrumentType, d))) {
                    c = aVar.cVa ? Order.STOP : Order.LIMIT;
                } else {
                    if (aVar.cVb.doubleValue() < (aVar.cVa ? da.getAsk(instrumentType, d) : da.getBid(instrumentType, d))) {
                        c = aVar.cVa ? Order.LIMIT : Order.STOP;
                    }
                }
            }
        }
        k j = com.iqoption.mobbtech.connect.request.a.a.b.A(com.iqoption.core.microservices.tradingengine.response.c.a.class).ga("place-order-temp").gb("3.0").cd(false).j("user_balance_id", Long.valueOf(aVar.cUZ)).j("client_platform_id", Integer.valueOf(17)).j("instrument_id", aVar.cUY.getInstrumentId()).j("instrument_type", instrumentType).j(PendingOrderWrapper.SIDE, aVar.cVa ? Order.BUY : Order.SELL).j(Param.TYPE, c).j("amount", Double.valueOf(aVar.aTA)).j("leverage", Integer.valueOf(d)).j("use_token_for_commission", Boolean.valueOf(aVar.cFG));
        if (Order.LIMIT.equalsIgnoreCase(c)) {
            j.j("limit_price", aVar.cVb);
        } else if (Order.STOP.equalsIgnoreCase(c)) {
            j.j("stop_price", aVar.cVb);
        }
        if (aVar.cjZ != null) {
            j.j("take_profit_price", aVar.cjZ);
        }
        if (aVar.cjY != null) {
            j.j("stop_lose_price", aVar.cjY);
        }
        if (aVar.cVc != null) {
            j.j("auto_margin_call", aVar.cVc);
        }
        if (!Order.MARKET.equals(c)) {
            return j.Sa();
        }
        c = com.iqoption.mobbtech.connect.request.a.a.b.auB();
        j.gd(c);
        com.iqoption.core.a.a.a.aMG.a(aVar.cVa, (long) aVar.cUY.getActiveId(), c, instrumentType, (long) Balance.getBalanceType(com.iqoption.app.a.Cw().d(Long.valueOf(aVar.cUZ))));
        s<com.iqoption.core.microservices.tradingengine.response.c.a> Sa = j.Sa();
        com.iqoption.core.a.a.a.aMG.a((s) Sa, instrumentType, (long) aVar.cUY.getActiveId(), c);
        return Sa;
    }

    public static s<com.iqoption.core.microservices.tradingengine.response.c.a> a(Strike strike, Long l, Long l2, double d, long j, boolean z) {
        Strike strike2 = strike;
        if (strike2 == null) {
            return o.m(new NullPointerException("Strike in null"));
        }
        String str = (z ? strike2.call : strike2.put).id;
        String str2 = strike2.optionType == InstrumentType.FX_INSTRUMENT ? "trading-fx-option" : null;
        String auB = com.iqoption.mobbtech.connect.request.a.a.b.auB();
        com.iqoption.core.a.a.a.aMG.a(true, l2.longValue(), auB, strike2.optionType, (long) Balance.getBalanceType(com.iqoption.app.a.Cw().d(Long.valueOf(j))));
        s<com.iqoption.core.microservices.tradingengine.response.c.a> Sa = com.iqoption.mobbtech.connect.request.a.a.b.A(com.iqoption.core.microservices.tradingengine.response.c.a.class).ga("place-order-temp").gb("3.0").cd(false).gc(str2).j(PendingOrderWrapper.POSITION_ID, l).j("user_balance_id", Long.valueOf(j)).j("client_platform_id", Integer.valueOf(17)).j("instrument_id", str).j("instrument_type", strike2.optionType).j(PendingOrderWrapper.SIDE, Order.BUY).j(Param.TYPE, Order.MARKET).j("amount", Double.valueOf(d)).j("leverage", Integer.valueOf(1)).gd(auB).Sa();
        com.iqoption.core.a.a.a.aMG.a((s) Sa, strike2.optionType, l2.longValue(), auB);
        return Sa;
    }

    public static s<Order> k(final Position position) {
        cUS.add(position.getId());
        final com.iqoption.core.a.a RV = com.iqoption.core.a.a.a.aMG.RV();
        s Sa = com.iqoption.mobbtech.connect.request.a.a.b.A(Order.class).cd(false).gc(InstrumentType.FX_INSTRUMENT == position.getInstrumentType() ? "trading-fx-option" : null).ga("close-position").j(PendingOrderWrapper.POSITION_ID, position.getId()).Sa();
        ag.a(Sa, new n<Order>() {
            /* renamed from: n */
            public void onSuccess(Order order) {
                com.iqoption.core.a.a.a.aMG.a(RV, (long) position.getActiveId(), position.getId().longValue());
                a.cUS.remove(position.getId());
                IQApp.Dn().aE(new b(position, false));
            }

            public void l(Throwable th) {
                if (th instanceof m) {
                    m mVar = (m) th;
                    com.iqoption.core.a.a.a.aMG.a(RV, (long) position.getActiveId(), mVar.getMessage(), Integer.valueOf(mVar.getCode()));
                } else {
                    com.iqoption.core.a.a.a.aMG.a(RV, (long) position.getActiveId(), "", Integer.valueOf(0));
                }
                a.cUS.remove(position.getId());
                com.iqoption.app.a.b.aT(IQApp.Dk());
                IQApp.Dn().aE(new b(position, true));
            }
        });
        return Sa;
    }

    public static boolean r(ImmutableList<e> immutableList) {
        Iterator sI = immutableList.iterator();
        boolean z = false;
        while (sI.hasNext()) {
            Position position = (Position) ((e) sI.next());
            if (!a.x(position.getId())) {
                k(position);
                z = true;
            }
            cUV.add(position.getId());
        }
        return z;
    }

    public static s<com.iqoption.core.microservices.tradingengine.response.c.a> a(Long l, Double d, Double d2, Boolean bool) {
        k j = com.iqoption.mobbtech.connect.request.a.a.b.A(com.iqoption.core.microservices.tradingengine.response.c.a.class).cd(false).ga("change-tpsl").j(PendingOrderWrapper.POSITION_ID, l).j(Position.CLOSE_REASON_TAKE_PROFIT, d).j(Position.CLOSE_REASON_STOP_LOSE, d2);
        if (bool != null) {
            j.j("use_trail_stop", bool);
        }
        return j.Sa();
    }

    public static s<Order> a(final Position position, String str) {
        cUS.add(position.getId());
        s Sa = com.iqoption.mobbtech.connect.request.a.a.b.A(Order.class).cd(false).ga("withdraw-position").j(PendingOrderWrapper.POSITION_ID, position.getId()).j("withdraw_wallet", str).Sa();
        o.a(Sa, new n<Order>() {
            /* renamed from: n */
            public void onSuccess(Order order) {
                a.cUS.remove(position.getId());
            }

            public void l(Throwable th) {
                i.e(c.TAG, "withdraw error", th);
                a.cUS.remove(position.getId());
                com.iqoption.app.a.b.aT(IQApp.Dk());
            }
        });
        return Sa;
    }

    public static s<com.iqoption.core.microservices.tradingengine.response.c.a> z(Long l) {
        return com.iqoption.mobbtech.connect.request.a.a.b.A(com.iqoption.core.microservices.tradingengine.response.c.a.class).cd(false).ga("cancel-order").j("order_id", l).Sa();
    }
}
