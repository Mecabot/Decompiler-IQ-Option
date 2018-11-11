package com.iqoption.gl;

import android.content.SharedPreferences;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.common.base.Predicates;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;
import com.google.gson.JsonObject;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.ae;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.MusicUtil;
import com.iqoption.util.MusicUtil.Sound;
import com.iqoption.util.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NativeHandler extends com.iqoption.core.gl.a {
    private static final String TAG = "com.iqoption.gl.NativeHandler";
    private static final com.google.common.base.n<NativeHandler> nativeHandlerSupplier = Suppliers.a(l.ajD);
    private Map<String, Builder> eventMap = new HashMap();
    private final i handlerEvent = new i();
    private com.iqoption.view.d.a<String> onAskForSelling = new com.iqoption.view.d.a<String>() {
        /* renamed from: hT */
        public void bu(String str) {
            com.iqoption.core.d.a.aSc.execute(new v(str));
        }

        static final /* synthetic */ void hV(String str) {
            Object[] parsePositionSplitId = Position.parsePositionSplitId(str);
            Long l = (Long) parsePositionSplitId[0];
            com.iqoption.mobbtech.connect.response.options.b a = com.iqoption.app.managers.c.Gn().a((com.iqoption.mobbtech.connect.response.options.i) parsePositionSplitId[1]);
            if (a != null) {
                Iterator sI = a.avh().iterator();
                while (sI.hasNext()) {
                    com.iqoption.mobbtech.connect.response.options.e eVar = (com.iqoption.mobbtech.connect.response.options.e) sI.next();
                    if (eVar.getId().equals(l)) {
                        if (!com.iqoption.mobbtech.connect.request.api.a.a.x(l)) {
                            IQApp.Dn().aE(new a((Position) eVar));
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    };
    private com.iqoption.view.d.a<String> onSellClick = new com.iqoption.view.d.a<String>() {
        /* renamed from: hT */
        public void bu(String str) {
            com.iqoption.core.d.a.aSc.execute(new u(str));
        }

        static final /* synthetic */ void hU(String str) {
            Object[] parsePositionSplitId = Position.parsePositionSplitId(str);
            Long l = (Long) parsePositionSplitId[0];
            com.iqoption.mobbtech.connect.response.options.b a = com.iqoption.app.managers.c.Gn().a((com.iqoption.mobbtech.connect.response.options.i) parsePositionSplitId[1]);
            if (a != null) {
                Iterator sI = a.avh().iterator();
                while (sI.hasNext()) {
                    com.iqoption.mobbtech.connect.response.options.e eVar = (com.iqoption.mobbtech.connect.response.options.e) sI.next();
                    if (eVar.getId().equals(l)) {
                        if (!com.iqoption.mobbtech.connect.request.api.a.a.x(l)) {
                            com.iqoption.mobbtech.connect.request.api.a.c.k((Position) eVar);
                            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_sell-from-graph").setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", eVar.getInstrumentType()).aab()).build());
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    };
    public final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    public static class a {
        public final Position position;

        public a(Position position) {
            this.position = position;
        }
    }

    public static class b {
    }

    public static class e {
        public final String cIQ;
        public final String cIR;
        public final int cIS;
        public final InstrumentType instrumentType;

        public e(InstrumentType instrumentType, String str, String str2, int i) {
            this.instrumentType = instrumentType;
            this.cIQ = str;
            this.cIR = str2;
            this.cIS = i;
        }
    }

    public static class f {
    }

    private static final class j {
        private static j cJb = new j();
        private final SharedPreferences alq = IQApp.Dk().getSharedPreferences("gl_pref_name", 0);

        j() {
        }

        static void c(String str, boolean z) {
            cJb.alq.edit().putBoolean(str, z).apply();
        }

        static boolean getBoolean(String str, boolean z) {
            return cJb.alq.getBoolean(str, z);
        }
    }

    public static class m {
        public final double cJc;
        public final double cJd;
        public final double cJe;

        public m(double d, double d2, double d3) {
            this.cJc = d;
            this.cJd = d2;
            this.cJe = d3;
        }
    }

    public static class n {
        public final int activeId;
        public final String cJf;
        public final long expiration;
        public final String id;
        public final boolean isSpot;

        public n(int i, long j, String str, String str2, boolean z) {
            this.activeId = i;
            this.expiration = j;
            this.cJf = str;
            this.id = str2;
            this.isSpot = z;
        }
    }

    public static class o {
        public String cJg;

        o(String str) {
            this.cJg = str;
        }
    }

    public static class p {
    }

    public static class q {
        public boolean aVB;
        public String cJh;
        public int cJi;
        public int type;

        public q(String str, int i, boolean z, int i2) {
            this.cJh = str;
            this.cJi = i;
            this.aVB = z;
            this.type = i2;
        }
    }

    public static class c extends com.iqoption.system.a.c<Double> {
    }

    public static class d extends com.iqoption.system.a.c<Double> {
    }

    public static class g extends com.iqoption.system.a.c<Double> {
    }

    public static class h extends com.iqoption.system.a.c<Long> {
    }

    private static class i extends com.iqoption.system.a.d {
        private i() {
        }

        /* synthetic */ i(AnonymousClass1 anonymousClass1) {
            this();
        }

        @com.google.common.b.e
        public void oHiLowChartChanged(com.iqoption.settings.a.c cVar) {
            com.iqoption.core.d.a.aSc.execute(new w(cVar));
        }

        @com.google.common.b.e
        public void onOpenOptionGroups(com.iqoption.mobbtech.connect.response.options.OptionEvents.m mVar) {
            NativeHandler.instance().singleThreadExecutor.execute(x.alc);
        }

        static final /* synthetic */ void aoy() {
            b.aow().glchTabClearBets();
            b.aow().glchClearPositions();
            b.aow().glchClearOrders();
            b.aow().glchClearVisibleUnits();
        }

        @com.google.common.b.e
        public void onNewOpenOptionGroup(com.iqoption.mobbtech.connect.response.options.OptionEvents.h hVar) {
            ImmutableList avh = hVar.cWF.avh();
            if (avh != null) {
                NativeHandler.instance().singleThreadExecutor.execute(new y(hVar, avh));
            }
        }

        static final /* synthetic */ void a(com.iqoption.mobbtech.connect.response.options.OptionEvents.h hVar, ImmutableList immutableList) {
            switch (hVar.cWF.instrumentType) {
                case TURBO_INSTRUMENT:
                case BINARY_INSTRUMENT:
                    com.iqoption.app.managers.c.e(immutableList);
                    return;
                case DIGITAL_INSTRUMENT:
                case FX_INSTRUMENT:
                case FOREX_INSTRUMENT:
                case CFD_INSTRUMENT:
                case CRYPTO_INSTRUMENT:
                    Iterator sI = immutableList.iterator();
                    while (sI.hasNext()) {
                        Position position = (Position) ((com.iqoption.mobbtech.connect.response.options.e) sI.next());
                        com.iqoption.app.managers.c.f(position);
                        immutableList = com.iqoption.app.managers.c.Gn().i(position.getId());
                        if (immutableList != null) {
                            Iterator sI2 = immutableList.iterator();
                            while (sI2.hasNext()) {
                                com.iqoption.app.managers.c.j((Order) sI2.next());
                            }
                        }
                    }
                    return;
                default:
                    return;
            }
        }

        @com.google.common.b.e
        public void onOpenOptionGroupOptionAdded(com.iqoption.mobbtech.connect.response.options.OptionEvents.i iVar) {
            if (iVar.cWH != null) {
                NativeHandler.instance().singleThreadExecutor.execute(new z(iVar));
            }
        }

        @com.google.common.b.e
        public void onOpenOptionGroupOptionRemoved(com.iqoption.mobbtech.connect.response.options.OptionEvents.j jVar) {
            if (jVar.cWJ != null) {
                NativeHandler.instance().singleThreadExecutor.execute(new aa(jVar));
            }
        }

        @com.google.common.b.e
        public void onOpenOptionGroupRemoved(com.iqoption.mobbtech.connect.response.options.OptionEvents.k kVar) {
            if (kVar.cWK != null && !kVar.cWK.isEmpty()) {
                NativeHandler.instance().singleThreadExecutor.execute(new ab(kVar));
            }
        }

        @com.google.common.b.e
        public void onPositionClosed(com.iqoption.mobbtech.connect.response.options.OptionEvents.n nVar) {
            Position position = (Position) nVar.getValue();
            if (position != null) {
                InstrumentType instrumentType = position.getInstrumentType();
                if (instrumentType != null) {
                    switch (instrumentType) {
                        case TURBO_INSTRUMENT:
                        case BINARY_INSTRUMENT:
                        case DIGITAL_INSTRUMENT:
                        case FX_INSTRUMENT:
                            return;
                        default:
                            if (!com.iqoption.mobbtech.connect.request.api.a.c.y(position.getId())) {
                                double doubleValue = position.getInvestSum().doubleValue();
                                double winAmount = position.getWinAmount();
                                String p = com.iqoption.util.l.p(Double.valueOf(winAmount - doubleValue));
                                com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(position.getActiveId()), instrumentType);
                                String s = a != null ? com.iqoption.util.e.a.s(a) : null;
                                if (s == null) {
                                    s = "";
                                }
                                NativeHandler.instance().singleThreadExecutor.execute(new ac(position, s, p, instrumentType, winAmount, doubleValue));
                                return;
                            }
                            return;
                    }
                }
            }
        }

        static final /* synthetic */ void a(Position position, String str, String str2, InstrumentType instrumentType, double d, double d2) {
            b.aow().glchTabAddSmallDealCFD(position.getActiveId(), TimeUnit.MILLISECONDS.toSeconds(position.getCloseTime()), position.getExpValue().doubleValue(), position.getWinAmount(), position.getInvestSum().doubleValue(), str, str2, ah.aGg().toJson(ImmutableList.af(position)), instrumentType.getOptionActiveOrInstrumentValue(), position.getPositionSplitId(), 0);
            MusicUtil.a(IQApp.Dk(), d >= d2 ? Sound.GAME_WIN : Sound.GAME_LOSE);
        }
    }

    public static class k extends com.iqoption.system.a.c<Integer> {
    }

    public static class l extends com.iqoption.system.a.c<Long> {
    }

    private NativeHandler() {
    }

    public static NativeHandler instance() {
        return (NativeHandler) nativeHandlerSupplier.get();
    }

    public void onStart() {
        this.handlerEvent.register();
    }

    public void onStop() {
        this.handlerEvent.unregister();
    }

    public void onChangeVisibleTimeDelta(double d) {
        com.iqoption.core.d.a.aSc.execute(new c(d));
    }

    public void onCrossedReferenceTimeOnTimeScaleBar(double d) {
        com.iqoption.core.d.a.aSc.execute(new d(d));
    }

    public void onSelectChartQuote(double d, double d2, double d3) {
        com.iqoption.core.d.a.aSc.execute(new m(d, d2, d3));
    }

    public void onCancelSelectChartQuote() {
        com.iqoption.core.d.a.aSc.execute(n.alc);
    }

    public void onTapTimeScaleBar() {
        com.iqoption.core.d.a.aSc.execute(o.alc);
    }

    public void onSetStrikesAutoSelectionState(boolean z) {
        com.iqoption.core.d.a.aSc.execute(new p(z));
    }

    static final /* synthetic */ void lambda$onSetStrikesAutoSelectionState$5$NativeHandler(boolean z) {
        com.iqoption.app.managers.tab.a.g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null) {
            IC.by(z);
        }
    }

    public void onRequestMarginCall(String str) {
        com.iqoption.core.d.a.aSc.execute(new q(str));
    }

    public void onFeeInfoPressed(String str) {
        com.iqoption.core.d.a.aSc.execute(new r(str));
    }

    public void onChangeLimitOrderValue(double d, int i) {
        IQApp.Dn().aE(new c().setValue(Double.valueOf(d)));
    }

    public void onChangeTPSL(String str, String str2, String str3, double d, double d2) {
        com.iqoption.core.d.a.aSc.execute(new s(str, d, d2, str3));
    }

    static final /* synthetic */ void lambda$onChangeTPSL$8$NativeHandler(String str, double d, double d2, String str2) {
        Long l = (Long) Position.parsePositionSplitId(str)[0];
        Double valueOf = Double.valueOf(d);
        Double valueOf2 = Double.valueOf(d2);
        Boolean valueOf3 = Boolean.valueOf(com.iqoption.settings.b.aDQ().Eo());
        if (TextUtils.isEmpty(str2)) {
            valueOf3 = Boolean.valueOf(false);
        } else {
            Long cN = Longs.cN(str2);
            if (cN != null) {
                valueOf3 = Boolean.valueOf(Order.isTrailStoPOrder((Order) com.google.common.collect.i.c(com.iqoption.app.managers.c.Gn().Gm()).e(Predicates.a(Predicates.G(cN), Order.getOrderId)).pq()));
            }
        }
        if (valueOf.doubleValue() < 0.0d) {
            valueOf = null;
        }
        if (valueOf2.doubleValue() < 0.0d) {
            valueOf2 = null;
        }
        com.iqoption.mobbtech.connect.request.api.a.c.a(l, valueOf, valueOf2, valueOf3);
    }

    public static void vibrate(long j) {
        Vibrator vibrator = (Vibrator) IQApp.Dk().getSystemService("vibrator");
        if (vibrator == null) {
            return;
        }
        if (com.iqoption.core.ext.a.SQ()) {
            vibrator.vibrate(VibrationEffect.createOneShot(j, -1));
        } else {
            vibrator.vibrate(j);
        }
    }

    public void onNeedVibrate(int i) {
        if (i > 0) {
            com.iqoption.core.d.a.aSe.execute(new t(i));
        }
    }

    public void onUpdateInstrumentParams(int i) {
        IQApp.Dn().aE(new k().setValue(Integer.valueOf(i)));
    }

    public void onCloseInstrument(int i) {
        com.iqoption.charttools.f.arM.y(com.iqoption.app.managers.tab.a.Il().IE(), i).b(com.iqoption.core.h.i.Yr()).aVS();
    }

    public void onSellTradingPosition(String str) {
        this.onSellClick.bP(str);
    }

    public void onSelectTradingPosition(String str) {
        IQApp.Dn().aE(new o(str));
    }

    public void onEnlargeSellControl() {
        af.i("first_do_sell_experience", true);
        com.iqoption.core.d.a.aSc.execute(e.alc);
    }

    public void onAskForSellingTradingPosition(String str) {
        this.onAskForSelling.bP(str);
    }

    void onPrefSet(String str, boolean z) {
        j.c(str, z);
    }

    boolean onPrefGet(String str, boolean z) {
        return j.getBoolean(str, z);
    }

    public void onLineInstrumentEditEnd(@NonNull String str) {
        com.iqoption.charttools.l.asx.Km().i(new f(str)).b(com.iqoption.core.h.i.Yr()).aVS();
    }

    static final /* synthetic */ io.reactivex.c lambda$onLineInstrumentEditEnd$13$NativeHandler(@NonNull String str, com.iqoption.charttools.k kVar) {
        com.iqoption.charttools.model.indicator.h a = com.iqoption.charttools.l.asx.a(kVar, (JsonObject) ah.aGg().fromJson(str, JsonObject.class));
        if (a == null) {
            return io.reactivex.a.aVR();
        }
        return com.iqoption.charttools.f.arM.fn(com.iqoption.app.managers.tab.a.Il().IE()).i(new j(a));
    }

    static final /* synthetic */ io.reactivex.c lambda$null$12$NativeHandler(com.iqoption.charttools.model.indicator.h hVar, List list) {
        com.iqoption.charttools.model.indicator.h hVar2 = (com.iqoption.charttools.model.indicator.h) com.google.common.collect.i.c((Iterable) list).e(new k(hVar)).pq();
        if (hVar2 == null) {
            return io.reactivex.a.aVR();
        }
        com.iqoption.charttools.tools.d.aAz.fG(hVar2.KJ().getType());
        com.iqoption.charttools.model.indicator.k kVar = (com.iqoption.charttools.model.indicator.k) hVar.KJ();
        kVar.b(kVar.b(hVar2.Mc()), hVar.Mc());
        return com.iqoption.charttools.f.arM.a(com.iqoption.app.managers.tab.a.Il().IE(), hVar.getIndex(), null, hVar.Mc(), true);
    }

    static final /* synthetic */ boolean lambda$null$11$NativeHandler(com.iqoption.charttools.model.indicator.h hVar, com.iqoption.charttools.model.indicator.h hVar2) {
        return hVar2 != null && hVar2.getIndex() == hVar.getIndex();
    }

    public void onSelectStrike(int i, long j, String str, String str2, boolean z) {
        IQApp.Dn().aE(new n(i, j, str, str2, z));
    }

    public void onSendRequestForFirstCandles(int i) {
        WebSocketHandler.a(WebSocketHandler.aDm(), i);
    }

    public void onVisibleCandlesSizeChanged(String str, int i, boolean z, int i2) {
        IQApp.Dn().aE(new q(str, i, z, i2));
    }

    public void onSendCandleRequest(int i, int i2, long j, long j2, int i3, int i4, int i5) {
        WebSocketHandler.a(WebSocketHandler.aDm(), i, i2, j, j2, i3, i4, i5);
    }

    public void onClickSmallDealView(String str, String str2, String str3, int i) {
        InstrumentType toInstrumentType;
        ActiveType fromServerValue = ActiveType.fromServerValue(str);
        if (fromServerValue != ActiveType.UNKNOWN) {
            toInstrumentType = fromServerValue.toInstrumentType();
        } else {
            toInstrumentType = InstrumentType.fromServerValue(str);
        }
        IQApp.Dn().aE(new e(toInstrumentType, str2, str3, i));
    }

    public void onClickTradersMoodView() {
        IQApp.Dn().aE(new f());
    }

    public void onBestActivePushed(String str, int i) {
        com.iqoption.core.d.a.aSe.execute(new g(i));
    }

    static final /* synthetic */ void lambda$onBestActivePushed$14$NativeHandler(int i) {
        InstrumentType Iv = com.iqoption.app.managers.tab.a.Il().Iv();
        if (com.iqoption.core.ext.c.b((Object) Iv, InstrumentType.BINARY_INSTRUMENT, InstrumentType.TURBO_INSTRUMENT)) {
            com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(i), Iv);
            if (a != null) {
                com.iqoption.app.managers.tab.a.Il().d(i, Iv);
                ae.d(IQApp.Dk(), 128);
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "traderoom_new-tab-top-asset").setValue(Double.valueOf((double) com.iqoption.app.managers.tab.a.Il().IG())).setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", a.getInstrumentType()).aab()).build());
            }
        }
    }

    public void onSignalPressed(final int i, final String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSignalPressed activeId=");
        stringBuilder.append(i);
        stringBuilder.append(", typeId=");
        stringBuilder.append(str);
        com.iqoption.core.i.v(str2, stringBuilder.toString());
        com.iqoption.core.d.a.aSe.execute(new Runnable() {
            public void run() {
                com.iqoption.app.managers.tab.a.Il().d(i, InstrumentType.fromServerValue(str));
            }
        });
    }

    public void onAnalyticsEventPopupServed(String str, boolean z, double d) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onAnalyticsEventPopupServed ");
        stringBuilder.append(str);
        stringBuilder.append(", isOpen=");
        stringBuilder.append(z);
        stringBuilder.append(", value=");
        stringBuilder.append(d);
        com.iqoption.core.i.i(str2, stringBuilder.toString());
        com.iqoption.core.d.a.aSc.execute(new h(this, z, str, d));
    }

    final /* synthetic */ void lambda$onAnalyticsEventPopupServed$15$NativeHandler(boolean z, String str, double d) {
        Builder Builder;
        if (z) {
            Builder = Event.Builder(Event.CATEGORY_POPUP_SERVED, str);
            if (d != -1.0d) {
                Builder.setValue(Double.valueOf(d));
            }
            this.eventMap.put(str, Builder);
            return;
        }
        Builder = (Builder) this.eventMap.get(str);
        if (Builder != null) {
            this.eventMap.remove(str);
            EventManager.Bm().a(Builder.calcDuration().build());
        }
    }

    public void onAnalyticsEventButtonPressed(String str, double d) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onAnalyticsEventPopupServed ");
        stringBuilder.append(str);
        stringBuilder.append(", value=");
        stringBuilder.append(d);
        com.iqoption.core.i.i(str2, stringBuilder.toString());
        com.iqoption.core.d.a.aSc.execute(new i(str, d));
    }

    static final /* synthetic */ void lambda$onAnalyticsEventButtonPressed$16$NativeHandler(String str, double d) {
        Builder Builder = Event.Builder(Event.CATEGORY_BUTTON_PRESSED, str);
        if (d != -1.0d) {
            Builder.setValue(Double.valueOf(d));
        }
        EventManager.Bm().a(Builder.build());
        if ("signals_choose-signal".equals(str)) {
            IQApp.Dn().aE(new com.iqoption.fragment.b.c.a());
        }
    }

    public void onChangeStrikesDisplayMode(int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onChangeStrikesDisplayMode displayMode=");
        stringBuilder.append(i);
        com.iqoption.core.i.d(str, stringBuilder.toString());
    }

    public void onLiveDealsRequestedForInterval(int i, @NonNull String str, long j, long j2) {
        com.iqoption.f.a.onLiveDealsRequestedForInterval(i, str, j, j2);
    }

    public void onLiveDealsRequestedForExpiration(int i, @NonNull String str, int i2) {
        com.iqoption.f.a.onLiveDealsRequestedForExpiration(i, str, i2);
    }

    public void onFlagImageRequested(@NonNull String str) {
        com.iqoption.f.a.id(str);
    }

    public void onUserWeekPlaceAndProfitRequested(int i) {
        com.iqoption.f.a.bB((long) i);
    }

    public void onImageByUrlRequested(@NonNull String str) {
        com.iqoption.f.a.ie(str);
    }
}
