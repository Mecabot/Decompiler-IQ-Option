package com.iqoption.mobbtech.connect.request.api;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.dto.entity.billing.CryptoPaymentMethods;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.k;
import com.iqoption.mobbtech.connect.response.e;
import com.iqoption.util.as;
import com.iqoption.util.av;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: CashBoxRequests */
public class b {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.api.b";
    private static com.google.common.cache.b<a, e> cUD = CacheBuilder.qh().A(1000).a(5, TimeUnit.MINUTES).qw();

    /* compiled from: CashBoxRequests */
    private static class a {
        private final String assetName;
        private final double cnV;
        private final double cnW;

        public static a c(double d, double d2, String str) {
            return new a(d, d2, str);
        }

        private a(double d, double d2, String str) {
            this.cnV = d;
            this.cnW = d2;
            this.assetName = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Double.compare(aVar.cnV, this.cnV) == 0 && Double.compare(aVar.cnW, this.cnW) == 0) {
                return this.assetName.equals(aVar.assetName);
            }
            return false;
        }

        public int hashCode() {
            long doubleToLongBits = Double.doubleToLongBits(this.cnV);
            int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
            long doubleToLongBits2 = Double.doubleToLongBits(this.cnW);
            return (((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.assetName.hashCode();
        }
    }

    private b() {
    }

    public static s<com.iqoption.core.microservices.billing.response.b> bF(Context context) {
        i.d(TAG, "createSession");
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/new-billing/create-session");
        return new k(com.iqoption.core.microservices.billing.response.b.class, RequestManager.b(stringBuilder.toString(), null, context), "api/new-billing/create-session").auG();
    }

    public static s<com.iqoption.core.microservices.billing.response.a> d(Context context, String str, String str2, boolean z) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cashBoxCounting sessionHost=");
        stringBuilder.append(str);
        stringBuilder.append(", sessionId=");
        stringBuilder.append(str2);
        i.d(str3, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("sess_id", str2);
        hashMap.put("with_kyc_limit", Boolean.valueOf(z));
        str = av.aB(str, "external/cashbox/counting");
        if (TextUtils.isEmpty(str2)) {
            return o.m(new RuntimeException("empty session id"));
        }
        return new k(com.iqoption.core.microservices.billing.response.a.class, RequestManager.a(str, hashMap, context), "external/cashbox/counting").auG();
    }

    public static s<com.iqoption.mobbtech.connect.response.i> a(Context context, String str, String str2, long j, long j2, Double d, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("card_id", Long.valueOf(j2));
        return a(context, str, str2, j, str3, d, str4, true, hashMap);
    }

    public static s<com.iqoption.mobbtech.connect.response.i> a(Context context, String str, String str2, long j, String str3, Double d, String str4, int i, int i2, String str5, String str6, String str7, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("card_number", str6);
        hashMap.put("card_holder", str7);
        hashMap.put("card_exp_month", String.format(Locale.US, "%02d", new Object[]{Integer.valueOf(i)}));
        hashMap.put("card_exp_year", Integer.valueOf(i2));
        hashMap.put("card_cvv", str5);
        if (j2 != -1) {
            hashMap.put("card_id", Long.valueOf(j2));
        }
        return a(context, str, str2, j, str3, d, str4, true, hashMap);
    }

    public static s<com.iqoption.mobbtech.connect.response.i> a(Context context, String str, String str2, long j, String str3, Double d, String str4, boolean z, HashMap<String, Object> hashMap) {
        String str5 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("process =");
        stringBuilder.append(d);
        i.d(str5, stringBuilder.toString());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sess_id", str2);
        hashMap2.put("payment_method", Long.valueOf(j));
        hashMap2.put(com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY, str3);
        hashMap2.put("amount", d);
        if (!TextUtils.isEmpty(str4)) {
            hashMap2.put("bonuscode", str4);
        }
        hashMap2.put("link_card_agree", Boolean.valueOf(z));
        if (hashMap != null) {
            for (Entry key : hashMap.entrySet()) {
                Object[] objArr = new Object[]{key.getKey()};
                hashMap2.put(String.format(Locale.US, "extra_params[%s]", objArr), ((Entry) r5.next()).getValue());
            }
        }
        if (com.iqoption.app.managers.feature.b.HT().ff("billing-pay-socket")) {
            return new k(com.iqoption.mobbtech.connect.response.i.class, RequestManager.b(av.aB(str, "external/cashbox/pay"), hashMap2, context), "external/cashbox/pay").auG();
        }
        return RequestManager.a(av.aB(str, ""), "external/cashbox/pay", hashMap2, context, com.iqoption.mobbtech.connect.response.i.class);
    }

    public static s<e> a(String str, String str2, double d, double d2, String str3) {
        String str4 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cryptoPayoutAvailable purchaseAmount=");
        stringBuilder.append(d);
        stringBuilder.append(", assetAmount=");
        stringBuilder.append(d2);
        stringBuilder.append(", assetName=");
        stringBuilder.append(str3);
        stringBuilder.append(", sessionHost=");
        stringBuilder.append(str);
        stringBuilder.append(", sessionId=");
        stringBuilder.append(str2);
        i.d(str4, stringBuilder.toString());
        final a c = a.c(d, d2, str3);
        e eVar = (e) cUD.I(c);
        if (eVar != null) {
            return o.aR(eVar);
        }
        try {
            return o.b(com.iqoption.mobbtech.connect.request.a.a.b.B(e.class).ft(2).iF(str).iG("external/crypto/payout/available").iH(new JSONObject().put("purchase_amount", d).put("asset_amount", d2).put("asset", str3).toString()).iI(str2).auF(), new g<e, e>() {
                /* renamed from: a */
                public s<e> aP(e eVar) {
                    b.cUD.put(c, eVar);
                    return o.aR(eVar);
                }
            }, com.iqoption.core.d.a.aSe);
        } catch (Throwable e) {
            i.e(TAG, "cryptoPayoutAvailable json error", e);
            return o.m(e);
        }
    }

    public static e b(double d, double d2, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cryptoPayoutAvailableCached purchaseAmount=");
        stringBuilder.append(d);
        stringBuilder.append(", assetAmount=");
        stringBuilder.append(d2);
        stringBuilder.append(", assetName=");
        stringBuilder.append(str);
        i.d(str2, stringBuilder.toString());
        return (e) cUD.I(a.c(d, d2, str));
    }

    public static s<com.iqoption.mobbtech.connect.response.s> a(Context context, String str, String str2, long j, double d, String str3, String str4) {
        String str5 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("process w =");
        stringBuilder.append(d);
        stringBuilder.append(str4);
        stringBuilder.append(", ");
        stringBuilder.append(str3);
        i.d(str5, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        com.google.common.collect.ImmutableSortedSet.a tC = ImmutableSortedSet.tC();
        hashMap.put("payment_method_id", Long.valueOf(j));
        tC.an("payment_method_id");
        hashMap.put("payout_method_id", Long.valueOf(j));
        tC.an("payout_method_id");
        hashMap.put(com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY, str4);
        tC.an(com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY);
        if (d > 0.0d) {
            hashMap.put("amount", Double.valueOf(d));
            tC.an("amount");
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("address", str3);
            tC.an("address");
        }
        hashMap.put("skey", com.iqoption.app.a.aL(context).Dc());
        tC.an("skey");
        String str6 = "";
        Iterator sI = tC.tt().iterator();
        while (sI.hasNext()) {
            String str7 = (String) sI.next();
            Object obj = hashMap.get(str7);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str6);
            stringBuilder2.append(str7);
            stringBuilder2.append("=");
            stringBuilder2.append(obj);
            str6 = stringBuilder2.toString();
        }
        hashMap.remove("skey");
        hashMap.put("fkey", as.jM(str6));
        try {
            JSONObject jSONObject = new JSONObject();
            for (Entry entry : hashMap.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            return com.iqoption.mobbtech.connect.request.a.a.b.B(com.iqoption.mobbtech.connect.response.s.class).ft(2).iF(str).iG("api/external/withdrawal/payout").iH(jSONObject.toString()).iI(str2).auF();
        } catch (Throwable e) {
            i.e(TAG, "cryptoPayoutAvailable json error", e);
            return o.m(e);
        }
    }

    public static s<CryptoPaymentMethods> as(String str, String str2) {
        return com.iqoption.mobbtech.connect.request.a.a.b.B(CryptoPaymentMethods.class).iF(str).iG("api/external/crypto/methods/payment").o("Session-Id", str2).o("Content-Type", RequestManager.cTO.toString()).auF();
    }
}
