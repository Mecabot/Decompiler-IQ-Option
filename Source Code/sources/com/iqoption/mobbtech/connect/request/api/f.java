package com.iqoption.mobbtech.connect.request.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.google.gson.JsonElement;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.connect.k;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.h.g;
import com.iqoption.core.i;
import com.iqoption.core.microservices.tradingengine.response.active.j;
import com.iqoption.core.microservices.tradingengine.response.active.l;
import com.iqoption.dto.Currencies.ConversionCurrency.List;
import com.iqoption.dto.entity.iqbus.SignalLegacy;
import com.iqoption.dto.entity.iqbus.Subscriptions;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.PendingOrderWrapper;
import com.iqoption.dto.entity.position.PositionAndOrder;
import com.iqoption.dto.entity.position.result.DeferredOrdersResult;
import com.iqoption.dto.entity.position.result.HistoryResult;
import com.iqoption.dto.entity.position.result.PositionResult;
import com.iqoption.dto.entity.position.result.PositionsResult;
import com.iqoption.dto.entity.result.ExpirationsResult;
import com.iqoption.dto.entity.result.SpotResult;
import com.iqoption.dto.entity.result.StrikesResult;
import com.iqoption.dto.entity.strike.GroupStrikeKey;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.service.websocket.a.b;
import com.iqoption.trading.history.b.c;
import com.iqoption.util.ag;
import com.iqoption.util.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IQBusRequests */
public class f {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.api.f";

    /* compiled from: IQBusRequests */
    public static class a {
        private HashMap<String, Object> anM;
        private String cUR = null;
        private String name;
        private final String type;
        private String version;

        public a(String str) {
            this.type = str;
        }

        public a iz(String str) {
            this.name = str;
            return this;
        }

        public a iA(String str) {
            this.version = str;
            return this;
        }

        public a iB(String str) {
            this.cUR = str;
            return this;
        }

        public a g(HashMap<String, Object> hashMap) {
            this.anM = hashMap;
            return this;
        }

        public a m(String str, Object obj) {
            if (obj != null) {
                if (this.anM == null) {
                    this.anM = new HashMap();
                }
                this.anM.put(str, obj);
            }
            return this;
        }

        public boolean exec() {
            if (this.version == null) {
                this.version = "1.0";
            }
            return WebSocketHandler.aDm().c(b.a(this.type, this.name, this.anM).jJ(this.version).jK(this.cUR));
        }
    }

    public static boolean iv(String str) {
        Map hashMap = new HashMap();
        hashMap.put("provider", "google");
        hashMap.put("token", str);
        hashMap.put("app_id", Integer.valueOf(17));
        return WebSocketHandler.aDm().c(b.a("sendMessage", "register-token", hashMap));
    }

    public static boolean iw(String str) {
        Map hashMap = new HashMap();
        hashMap.put("provider", "google");
        hashMap.put("token", str);
        hashMap.put("app_id", Integer.valueOf(17));
        return WebSocketHandler.aDm().c(b.a("sendMessage", "unregister-token", hashMap));
    }

    public static s<SignalLegacy[]> c(long j, boolean z) {
        HashMap hashMap = new HashMap();
        if (j > 0) {
            hashMap.put("created", Long.valueOf(j));
        }
        hashMap.put("recent", Boolean.valueOf(z));
        return new com.iqoption.mobbtech.connect.request.a.a.b(SignalLegacy[].class, null, "get-signals").b("get-signals", hashMap);
    }

    public static s<SignalLegacy[]> a(long j, boolean z, int i) {
        HashMap hashMap = new HashMap();
        if (j > 0) {
            hashMap.put("created", Long.valueOf(j));
        }
        hashMap.put("recent", Boolean.valueOf(z));
        hashMap.put("subtype", Integer.valueOf(i));
        return new com.iqoption.mobbtech.connect.request.a.a.b(SignalLegacy[].class, null, "get-hf-signals").b("get-hf-signals", hashMap);
    }

    public static s<Subscriptions> auw() {
        HashMap hashMap = new HashMap();
        hashMap.put("locale", com.iqoption.core.f.getLocale());
        hashMap.put(NotificationCompat.CATEGORY_TRANSPORT, "push");
        hashMap.put("platform", Integer.valueOf(17));
        return new com.iqoption.mobbtech.connect.request.a.a.b(Subscriptions.class, null, "get-subscriptions").b("get-subscriptions", hashMap);
    }

    public static boolean a(Long l, Boolean bool) {
        Map hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_TRANSPORT, "push");
        hashMap.put("group", l);
        hashMap.put("enabled", bool);
        boolean c = WebSocketHandler.aDm().c(b.a("sendMessage", "set-group-state", hashMap));
        if (c) {
            af.aR(IQApp.Dk().getApplicationContext()).a(l.longValue(), bool.booleanValue());
        }
        return c;
    }

    public static boolean a(Long l, Long l2) {
        if (l == null || l2 == null || l.longValue() == 0 || l2.longValue() == 0) {
            return false;
        }
        Map hashMap = new HashMap();
        hashMap.put("token_id", l2);
        hashMap.put("push_id", l);
        return WebSocketHandler.aDm().c(b.a("sendMessage", "confirm-push", hashMap));
    }

    public static s<JsonElement> aux() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", "android-x");
        CharSequence FA = af.DX().FA();
        if (!TextUtils.isEmpty(FA)) {
            hashMap.put("identity", FA);
        }
        return com.iqoption.mobbtech.connect.request.a.a.b.A(JsonElement.class).ga("get-features").b(hashMap).gb("2.0").Sa();
    }

    public static boolean auy() {
        i.d(TAG, "subscribe for SignalCreatedEvent");
        return WebSocketHandler.aDm().c(b.a("subscribeMessage", "signal-created", null).jJ("1.0"));
    }

    public static boolean fr(int i) {
        i.d(TAG, "subscribe for SignalCreatedEvent");
        Map hashMap = new HashMap();
        hashMap.put("subtype", Integer.valueOf(i));
        return WebSocketHandler.aDm().c(b.a("subscribeMessage", "hf-signal-created", hashMap).jJ("1.0"));
    }

    public static s<List> auz() {
        return com.iqoption.mobbtech.connect.request.a.a.b.A(List.class).ga("get-currencies-list").Sa();
    }

    public static s<l> I(@NonNull InstrumentType instrumentType) {
        return g.a(com.iqoption.core.microservices.tradingengine.a.aYp.A(instrumentType));
    }

    public static s<j> J(@NonNull InstrumentType instrumentType) {
        return g.a(com.iqoption.core.microservices.tradingengine.a.aYp.B(instrumentType));
    }

    public static s<com.iqoption.core.microservices.tradingengine.response.b.b> K(InstrumentType instrumentType) {
        return g.a(com.iqoption.core.microservices.tradingengine.a.aYp.y(instrumentType));
    }

    public static s<ExpirationsResult> a(InstrumentType instrumentType, String str, int i, String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SPOTP getExpirations nameActive=");
        stringBuilder.append(str);
        i.d(str3, stringBuilder.toString());
        s Sa = com.iqoption.mobbtech.connect.request.a.a.b.A(ExpirationsResult.class).gc(str2).j(Param.TYPE, instrumentType).j("underlying", str).gb("4.0").ga("get-expiration-list").Sa();
        com.iqoption.core.a.a.a.aMG.a(Sa, instrumentType, (long) i);
        return Sa;
    }

    public static s<ExpirationsResult> a(InstrumentType instrumentType, String str, int i) {
        return a(instrumentType, str, i, null);
    }

    public static s<StrikesResult> a(GroupStrikeKey groupStrikeKey, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SPOTP getStrikes strikesKey=");
        stringBuilder.append(groupStrikeKey);
        i.d(str2, stringBuilder.toString());
        return com.iqoption.mobbtech.connect.request.a.a.b.A(StrikesResult.class).gc(str).ga("get-strike-list").j(Param.TYPE, groupStrikeKey.instrumentType).j("underlying", groupStrikeKey.underlying).j("expiration", groupStrikeKey.expiration).j("period", groupStrikeKey.period).gb("4.0").Sa();
    }

    public static s<StrikesResult> c(GroupStrikeKey groupStrikeKey) {
        return a(groupStrikeKey, null);
    }

    public static s<? extends StrikesResult> b(GroupStrikeKey groupStrikeKey, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SPOTP getSpotStrikes strikesKey=");
        stringBuilder.append(groupStrikeKey);
        i.d(str2, stringBuilder.toString());
        return com.iqoption.mobbtech.connect.request.a.a.b.A(SpotResult.class).gc(str).ga("get-spot-list").j(Param.TYPE, groupStrikeKey.instrumentType).j("underlying", groupStrikeKey.underlying).j("expiration", groupStrikeKey.expiration).j("period", groupStrikeKey.period).gb("1.0").Sa();
    }

    public static s<? extends StrikesResult> d(GroupStrikeKey groupStrikeKey) {
        return b(groupStrikeKey, null);
    }

    public static void a(InstrumentType instrumentType, ImmutableList<String> immutableList) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator sI = immutableList.iterator();
            while (sI.hasNext()) {
                String str = (String) sI.next();
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", str);
                    jSONObject.put(Param.TYPE, instrumentType);
                    jSONArray.put(jSONObject);
                }
            }
        } catch (JSONException unused) {
            Map hashMap = new HashMap();
            hashMap.put("instruments", jSONArray);
            WebSocketHandler.aDm().c(b.a("sendMessage", "get-last-quote", hashMap).jK(InstrumentType.FX_INSTRUMENT == instrumentType ? "instruments-quotes-fx-option" : null));
        }
    }

    public static s<PositionsResult> m(long j, InstrumentType instrumentType) {
        y wb = y.wb();
        a(wb, new ArrayList(), j, instrumentType);
        return wb;
    }

    private static void a(y<PositionsResult> yVar, ArrayList<PositionAndOrder> arrayList, long j, InstrumentType instrumentType) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_balance_id", Long.valueOf(j));
        hashMap.put("instrument_type", instrumentType);
        hashMap.put("skip", Integer.valueOf(arrayList.size()));
        hashMap.put(Order.LIMIT, Integer.valueOf(50));
        s a = new com.iqoption.mobbtech.connect.request.a.a.b(PositionsResult.class, null, "get-positions").a("get-positions", hashMap, InstrumentType.FX_INSTRUMENT == instrumentType ? "trading-fx-option" : null);
        final y<PositionsResult> yVar2 = yVar;
        final ArrayList<PositionAndOrder> arrayList2 = arrayList;
        final long j2 = j;
        final InstrumentType instrumentType2 = instrumentType;
        ag.a(a, new n<PositionsResult>() {
            /* renamed from: a */
            public void onSuccess(PositionsResult positionsResult) {
                if (positionsResult == null || positionsResult.positions == null) {
                    yVar2.h(new Throwable("api GET_POSITIONS  - not valid result"));
                    return;
                }
                positionsResult.positions.addAll(arrayList2);
                if (positionsResult.total == null || positionsResult.total.equals(Integer.valueOf(positionsResult.positions.size()))) {
                    yVar2.P(positionsResult);
                } else {
                    f.a(yVar2, positionsResult.positions, j2, instrumentType2);
                }
            }

            public void l(Throwable th) {
                yVar2.h(th);
            }
        });
    }

    public static s<DeferredOrdersResult> n(long j, InstrumentType instrumentType) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_balance_id", Long.valueOf(j));
        hashMap.put("instrument_type", instrumentType);
        return new com.iqoption.mobbtech.connect.request.a.a.b(DeferredOrdersResult.class, null, "get-deferred-orders").b("get-deferred-orders", hashMap);
    }

    public static s<HistoryResult> o(long j, InstrumentType instrumentType) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_balance_id", Long.valueOf(j));
        hashMap.put("instrument_type", instrumentType);
        return new com.iqoption.mobbtech.connect.request.a.a.b(HistoryResult.class, null, "get-position-history").a("get-position-history", hashMap, InstrumentType.FX_INSTRUMENT == instrumentType ? "trading-fx-option" : null);
    }

    public static s<PositionResult> p(long j, @Nullable InstrumentType instrumentType) {
        return new com.iqoption.mobbtech.connect.request.a.a.b.a(PositionResult.class).ga("get-position").j(PendingOrderWrapper.POSITION_ID, Long.valueOf(j)).gc(InstrumentType.FX_INSTRUMENT == instrumentType ? "trading-fx-option" : null).Sa();
    }

    public static s<com.iqoption.core.microservices.tradingengine.response.a.b> L(InstrumentType instrumentType) {
        return new com.iqoption.mobbtech.connect.request.a.a.b.a(com.iqoption.core.microservices.tradingengine.response.a.b.class).ga("get-commission-settings").j("instrument_type", instrumentType).cd(false).Sa();
    }

    public static boolean b(Long l, Boolean bool) {
        return iy("sendMessage").iz("change-auto-margin-call").m(PendingOrderWrapper.POSITION_ID, l).m("auto_margin_call", bool).exec();
    }

    public static s<c> a(long j, InstrumentType[] instrumentTypeArr, int[] iArr, long j2, long j3, int i, int i2) {
        java.util.List arrayList = new ArrayList(instrumentTypeArr.length);
        for (InstrumentType optionActiveOrInstrumentValue : instrumentTypeArr) {
            arrayList.add(optionActiveOrInstrumentValue.getOptionActiveOrInstrumentValue());
        }
        k cd = new com.iqoption.mobbtech.connect.request.a.a.b.a(c.class).gc("portfolio").ga("get-history").j("user_id", Long.valueOf(com.iqoption.app.a.Cw().getUserId())).j("user_balance_id", Long.valueOf(j)).j("instrument_types", arrayList).j(Order.LIMIT, Integer.valueOf(i)).j("offset", Integer.valueOf(i2)).cd(false);
        if (iArr != null && iArr.length > 0) {
            cd.j("active_ids", iArr);
        }
        if (j2 > 0 && j3 > 0) {
            cd.j("end", Long.valueOf(j3));
            cd.j("start", Long.valueOf(j2));
        }
        return cd.Sa();
    }

    public static boolean ix(String str) {
        return at(str, "1.0");
    }

    public static boolean at(String str, @NonNull String str2) {
        return WebSocketHandler.aDm().c(b.a("subscribeMessage", str, null).jJ(str2));
    }

    public static boolean a(String str, HashMap<String, Object> hashMap) {
        return WebSocketHandler.aDm().c(b.a("subscribeMessage", str, (Map) hashMap).jJ("1.0"));
    }

    public static boolean a(String str, String str2, HashMap<String, Object> hashMap) {
        return WebSocketHandler.aDm().c(b.a("subscribeMessage", str, (Map) hashMap).jJ("1.0").jK(str2));
    }

    public static void r(long j, long j2) {
        WebSocketHandler.aDm().jF(ah.aGg().toJson(new c(j, j2)));
    }

    public static a iy(String str) {
        return new a(str);
    }
}
