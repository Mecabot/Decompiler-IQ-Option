package com.iqoption.microservice.a.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.util.concurrent.s;
import com.google.gson.reflect.TypeToken;
import com.iqoption.core.connect.k;
import com.iqoption.microservice.a.a.a.c;
import com.iqoption.microservice.a.a.a.d;
import com.iqoption.microservice.a.a.a.f;
import com.iqoption.microservice.a.a.a.g;
import com.iqoption.mobbtech.connect.request.a.a.b;
import com.iqoption.util.ah;
import java.util.List;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.h;
import org.json.JSONArray;
import org.json.JSONObject;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0007J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/KycQuestionnaireRequests;", "", "()V", "APPROPRIATENESS_ASSESSMENT", "", "ECONOMIC_PROFILE", "getKycQuestionnaire", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnaire;", "questionnaireType", "getKycQuestionnaires", "", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnairesItem;", "getKycRiskWarning", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycRiskWarning;", "putKycQuestionnaire", "Ljava/lang/Void;", "type", "questions", "Lcom/iqoption/microservice/kyc/questionnaire/response/PutKycQuestionnaireItem;", "putKycRiskWarning", "agree", "", "signature", "", "QuestionnaireType", "IqOption-5.5.1_optionXRelease"})
/* compiled from: KycQuestionnaireRequests.kt */
public final class a {
    public static final a cRa = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, aXE = {"com/iqoption/microservice/kyc/questionnaire/KycQuestionnaireRequests$getKycQuestionnaires$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnairesItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: KycQuestionnaireRequests.kt */
    public static final class a extends TypeToken<List<? extends d>> {
        a() {
        }
    }

    private a() {
    }

    public final s<c> fk(int i) {
        Locale locale = Locale.getDefault();
        h.d(locale, "Locale.getDefault()");
        return b.A(c.class).ga("get-kyc-questionnaire").cd(false).j(Param.TYPE, Integer.valueOf(i)).j("locale", locale.getLanguage()).Sa();
    }

    public final s<List<d>> asd() {
        return b.n(new a().getType()).ga("get-kyc-questionnaires").cd(false).Sa();
    }

    public final s<f> ase() {
        Locale locale = Locale.getDefault();
        h.d(locale, "Locale.getDefault()");
        return b.A(f.class).ga("get-kyc-risk-warning").j("locale", locale.getLanguage()).cd(false).Sa();
    }

    public final s<Void> b(int i, List<g> list) {
        h.e(list, "questions");
        JSONArray jSONArray = new JSONArray(ah.aGg().toJson((Object) list));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Param.TYPE, i);
        jSONObject.put("questions", jSONArray);
        return b.A(Void.class).ga("put-kyc-questionnaire").m(jSONObject).cd(false).Sa();
    }

    public final s<Void> h(boolean z, String str) {
        k cd = b.A(Void.class).ga("put-kyc-risk-warning").j("agree", Boolean.valueOf(z)).cd(false);
        if (str != null) {
            cd.j("signature", str);
        }
        return cd.Sa();
    }
}
