package com.iqoption.core.microservices.billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.iqoption.core.f;
import com.iqoption.core.microservices.billing.response.b;
import com.iqoption.core.microservices.billing.response.c;
import io.reactivex.o;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Pair;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.Request;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J:\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004JT\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006%"}, aXE = {"Lcom/iqoption/core/microservices/billing/CashBoxRequests;", "", "()V", "CMD_CASHBOX_COUNTING", "", "CMD_CASHBOX_PAY", "CMD_CREATE_SESSION", "SESSION_ID", "WITH_KYC_LIMIT", "createSession", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult;", "getCashBoxCounting", "Lcom/iqoption/core/microservices/billing/response/CashboxResult;", "sessionHost", "sessionId", "withKycLimit", "", "mapLinkedCardParams", "", "cardId", "", "mapNewCardFields", "cardNumber", "cardHolderName", "cardExpMonth", "", "cardExpYear", "cardCvv", "pay", "Lcom/iqoption/core/microservices/billing/response/PayResponse;", "paymentMethodId", "currency", "amount", "Ljava/math/BigDecimal;", "bonusCode", "extraParams", "core_release"})
/* compiled from: CashBoxRequests.kt */
public final class a {
    public static final a aSZ = new a();

    private a() {
    }

    public final o<b> Uv() {
        FormBody build = new Builder().build();
        Request.Builder a = com.iqoption.core.connect.http.b.a(com.iqoption.core.connect.http.b.aNM, new Request.Builder(), null, 1, null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f.RQ().Du().getClusterApi());
        stringBuilder.append("api/new-billing/create-session");
        Request.Builder post = a.url(stringBuilder.toString()).post(build);
        com.iqoption.core.connect.http.b bVar = com.iqoption.core.connect.http.b.aNM;
        h.d(post, "builder");
        return bVar.b(post, CashBoxRequests$createSession$1.aTa, com.iqoption.core.connect.http.a.aNE, com.iqoption.core.connect.http.b.Sp());
    }

    public final o<com.iqoption.core.microservices.billing.response.a> e(String str, String str2, boolean z) {
        h.e(str, "sessionHost");
        h.e(str2, "sessionId");
        if (u.M(str2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Session must not be empty: ");
            stringBuilder.append(str2);
            o<com.iqoption.core.microservices.billing.response.a> S = o.S(new IllegalArgumentException(stringBuilder.toString()));
            h.d(S, "Single.error(IllegalArgu…t be empty: $sessionId\"))");
            return S;
        }
        return com.iqoption.core.connect.http.b.aNM.b(com.iqoption.core.connect.http.b.aNM.a(new Request.Builder(), str, "/external/cashbox/counting", ad.a(j.D("sess_id", str2), j.D("with_kyc_limit", Boolean.valueOf(z)))), CashBoxRequests$getCashBoxCounting$1.aTb, com.iqoption.core.connect.http.a.aNE, com.iqoption.core.connect.http.b.Sp());
    }

    public final o<c> a(String str, String str2, long j, String str3, BigDecimal bigDecimal, String str4, Map<String, ? extends Object> map) {
        h.e(str, "sessionHost");
        h.e(str2, "sessionId");
        h.e(str3, FirebaseAnalytics.b.CURRENCY);
        h.e(bigDecimal, "amount");
        Builder add = new Builder().add("sess_id", str2).add("payment_method", String.valueOf(j)).add(FirebaseAnalytics.b.CURRENCY, str3).add("amount", bigDecimal.toPlainString());
        if (str4 != null) {
            if ((((CharSequence) str4).length() > 0 ? 1 : null) != null) {
                add.add("bonuscode", str4);
            }
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                str4 = (String) entry.getKey();
                Object value = entry.getValue();
                m mVar = m.euz;
                Locale locale = Locale.US;
                h.d(locale, "Locale.US");
                Object[] objArr = new Object[]{str4};
                str4 = String.format(locale, "extra_params[%s]", Arrays.copyOf(objArr, objArr.length));
                h.d(str4, "java.lang.String.format(locale, format, *args)");
                add.add(str4, value.toString());
            }
        }
        Request.Builder a = com.iqoption.core.connect.http.b.a(com.iqoption.core.connect.http.b.aNM, new Request.Builder(), null, 1, null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/external/cashbox/pay");
        Request.Builder post = a.url(stringBuilder.toString()).post(add.build());
        com.iqoption.core.connect.http.b bVar = com.iqoption.core.connect.http.b.aNM;
        h.d(post, "builder");
        return bVar.b(post, CashBoxRequests$pay$1.aTc, com.iqoption.core.connect.http.a.aNE, com.iqoption.core.connect.http.b.Sp());
    }

    public final Map<String, Object> a(String str, String str2, int i, int i2, String str3) {
        h.e(str, "cardNumber");
        h.e(str2, "cardHolderName");
        h.e(str3, "cardCvv");
        Pair[] pairArr = new Pair[6];
        pairArr[0] = j.D("card_number", str);
        pairArr[1] = j.D("card_holder", str2);
        m mVar = m.euz;
        Locale locale = Locale.US;
        h.d(locale, "Locale.US");
        Object[] objArr = new Object[]{Integer.valueOf(i)};
        String format = String.format(locale, "%02d", Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(locale, format, *args)");
        pairArr[2] = j.D("card_exp_month", format);
        pairArr[3] = j.D("card_exp_year", Integer.valueOf(i2));
        pairArr[4] = j.D("card_cvv", str3);
        pairArr[5] = j.D("link_card_agree", Boolean.valueOf(true));
        return ad.a(pairArr);
    }

    public final Map<String, Object> aW(long j) {
        return ac.h(j.D("card_id", Long.valueOf(j)));
    }
}
