package com.iqoption.microservice.withdraw;

import com.google.common.util.concurrent.s;
import com.google.gson.reflect.TypeToken;
import com.iqoption.microservice.withdraw.response.c;
import com.iqoption.microservice.withdraw.response.j;
import com.iqoption.microservice.withdraw.response.l;
import com.iqoption.microservice.withdraw.response.n;
import com.iqoption.mobbtech.connect.RequestManager;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;
import org.json.JSONObject;

@i(aXC = {1, 1, 11}, aXD = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\"\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00120\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J8\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/microservice/withdraw/WithdrawRequests;", "", "()V", "CARD_ID", "", "CARD_LIST_TYPE", "Ljava/lang/reflect/Type;", "ID", "IQOPTION_PAYMENT_METHOD_ID", "WITHDRAW_PAYOUT_LIST_TYPE", "cancel", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "host", "sessionId", "id", "", "getCards", "", "Lcom/iqoption/microservice/withdraw/response/Card;", "getPayoutMethods", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethodsResponse;", "payoutHistory", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "withdrawal", "Lcom/iqoption/microservice/withdraw/response/WithdrawResponse;", "method", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "params", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawRequests.kt */
public final class a {
    private static final Type cTm;
    private static final Type cTn;
    public static final a cTo = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, aXE = {"com/iqoption/microservice/withdraw/WithdrawRequests$CARD_LIST_TYPE$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/iqoption/microservice/withdraw/response/Card;", "Lkotlin/collections/ArrayList;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawRequests.kt */
    public static final class a extends TypeToken<ArrayList<com.iqoption.microservice.withdraw.response.b>> {
        a() {
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, aXE = {"com/iqoption/microservice/withdraw/WithdrawRequests$WITHDRAW_PAYOUT_LIST_TYPE$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "Lkotlin/collections/ArrayList;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawRequests.kt */
    public static final class b extends TypeToken<ArrayList<l>> {
        b() {
        }
    }

    static {
        Type type = new a().getType();
        if (type == null) {
            h.aXZ();
        }
        cTm = type;
        type = new b().getType();
        if (type == null) {
            h.aXZ();
        }
        cTn = type;
    }

    private a() {
    }

    public final s<List<com.iqoption.microservice.withdraw.response.b>> ao(String str, String str2) {
        h.e(str, "host");
        h.e(str2, "sessionId");
        s<List<com.iqoption.microservice.withdraw.response.b>> auF = com.iqoption.mobbtech.connect.request.a.a.b.o(cTm).iF(str).iG("api/external/card").o("Session-Id", str2).o("Content-Type", RequestManager.cTO.toString()).auF();
        h.d(auF, "RequestTask.httpOf<List<…)\n                .exec()");
        return auF;
    }

    public final s<j> ap(String str, String str2) {
        h.e(str, "host");
        h.e(str2, "sessionId");
        s<j> auF = com.iqoption.mobbtech.connect.request.a.a.b.B(j.class).iF(str).iG("api/external/payout/methods").o("Session-Id", str2).o("Content-Type", RequestManager.cTO.toString()).auF();
        h.d(auF, "RequestTask.httpOf(Withd…)\n                .exec()");
        return auF;
    }

    public final s<n> a(String str, String str2, com.iqoption.microservice.withdraw.response.a aVar, Map<String, ? extends Object> map) {
        Object obj;
        h.e(str, "host");
        h.e(str2, "sessionId");
        h.e(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
        h.e(map, "params");
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            jSONObject.put("card_id", cVar.Vf());
            Long atA = cVar.atA();
            if (atA != null) {
                jSONObject.put("iqoption_payment_method_id", atA.longValue());
            }
            obj = 1;
        } else if (aVar instanceof com.iqoption.microservice.withdraw.response.h) {
            jSONObject.put("payout_method_id", ((com.iqoption.microservice.withdraw.response.h) aVar).getId());
            obj = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected method type: ");
            stringBuilder.append(aVar);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        s<n> auF = com.iqoption.mobbtech.connect.request.a.a.b.B(n.class).ft(2).iF(str).iG(obj != null ? "api/external/withdrawal" : "api/external/withdrawal/payout").n("Session-Id", str2).o("Content-Type", RequestManager.cTO.toString()).o("Session-Id", str2).iH(jSONObject.toString()).auF();
        h.d(auF, "RequestTask.httpOf(Withd…)\n                .exec()");
        return auF;
    }

    public final s<List<l>> aq(String str, String str2) {
        h.e(str, "host");
        h.e(str2, "sessionId");
        s<List<l>> auF = com.iqoption.mobbtech.connect.request.a.a.b.o(cTn).ft(1).iF(str).iG("api/external/withdrawal/payout").o("Content-Type", RequestManager.cTO.toString()).o("Session-Id", str2).auF();
        h.d(auF, "RequestTask.httpOf<List<…)\n                .exec()");
        return auF;
    }

    public final s<Void> b(String str, String str2, long j) {
        h.e(str, "host");
        h.e(str2, "sessionId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", j);
        s<Void> auF = com.iqoption.mobbtech.connect.request.a.a.b.B(Void.class).ft(2).iF(str).iG("api/external/payout/cancel").o("Content-Type", RequestManager.cTO.toString()).o("Session-Id", str2).iH(jSONObject.toString()).auF();
        h.d(auF, "RequestTask.httpOf(Void:…)\n                .exec()");
        return auF;
    }
}
