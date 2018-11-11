package com.iqoption.mobbtech.connect.request.api;

import android.content.Context;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.dto.Balance;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.a;
import com.iqoption.mobbtech.connect.request.a.a.b;
import com.iqoption.mobbtech.connect.request.a.a.k;
import com.iqoption.mobbtech.connect.response.options.j;
import com.iqoption.mobbtech.connect.response.p;
import java.util.Collection;
import java.util.HashMap;

public final class Requests {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.api.Requests";

    public enum OptionType {
        turbo,
        binary
    }

    private Requests() {
    }

    public static void auA() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(IQApp.Dl().getClusterApi());
        stringBuilder.append("api/demo/reset");
        new a(RequestManager.b(stringBuilder.toString(), null, IQApp.Dk()), null, "api/demo/reset").auG();
    }

    public static void w(Long l) {
        HashMap hashMap = new HashMap();
        hashMap.put("balance_id", l);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(IQApp.Dl().getClusterApi());
        stringBuilder.append("api/profile/changebalance");
        new a(RequestManager.b(stringBuilder.toString(), hashMap, IQApp.Dk()), null, "api/profile/changebalance").auG();
    }

    public static void a(Context context, Balance balance, com.iqoption.mobbtech.connect.a.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("balance_id", balance.id);
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/profile/changebalance");
        new a(RequestManager.b(stringBuilder.toString(), hashMap, context), aVar, "api/profile/changebalance").auG();
    }

    public static s<j> a(Context context, OptionType optionType, int i, long j) {
        return b.A(j.class).ga("get-options").j("user_balance_id", Long.valueOf(j)).j(Param.TYPE, optionType.name()).j(Order.LIMIT, Integer.valueOf(i)).Sa();
    }

    public static s<com.iqoption.mobbtech.connect.response.a> a(Context context, Collection<Long> collection) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("betInfo optionIds=");
        stringBuilder.append(collection);
        i.d(str, stringBuilder.toString());
        ImmutableListMultimap.a aVar = new ImmutableListMultimap.a();
        for (Long l : collection) {
            aVar.q("id[]", l.toString());
        }
        ImmutableMultimap sR = aVar.sS();
        str = IQApp.Dl().getClusterApi();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("api/game/betinfo");
        return new k(com.iqoption.mobbtech.connect.response.a.class, RequestManager.a(stringBuilder.toString(), sR, context), "api/game/betinfo").auG();
    }

    public static s<p> f(Context context, String str, String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loadTerms articleKey=");
        stringBuilder.append(str);
        i.d(str3, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("key", str);
        hashMap.put("lang", str2);
        return RequestManager.a(IQApp.Dl().getClusterApi(), "api/article/get", hashMap, context, p.class);
    }
}
