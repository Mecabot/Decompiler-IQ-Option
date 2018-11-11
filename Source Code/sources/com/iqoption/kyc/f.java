package com.iqoption.kyc;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.TreeMultimap;
import com.google.common.collect.v;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.dto.entity.iqbus.Country;
import com.iqoption.dto.entity.result.KycQuestionsResult;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.dto.entity.result.ProofDocsResult;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.api.d;
import com.iqoption.mobbtech.connect.response.j;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.mobbtech.connect.response.m;
import com.iqoption.util.as;
import com.iqoption.util.bf;
import com.iqoption.util.k;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: KycRequests */
public class f {
    private static final String TAG = "com.iqoption.kyc.f";
    private final Context context;

    /* compiled from: KycRequests */
    /* renamed from: com.iqoption.kyc.f$1 */
    class AnonymousClass1 implements n<m> {
        /* renamed from: b */
        public void onSuccess(m mVar) {
            if (mVar.isSuccessful()) {
                com.iqoption.app.a.aL(IQApp.Dk()).setActivated(true);
            }
        }

        public void l(Throwable th) {
            com.crashlytics.android.a.log("confirm email error");
            k.c(th);
        }
    }

    /* compiled from: KycRequests */
    private static class a implements n<Object> {
        private final String abQ;

        public void onSuccess(Object obj) {
        }

        /* synthetic */ a(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private a(String str) {
            this.abQ = str;
        }

        public void l(Throwable th) {
            com.crashlytics.android.a.log(this.abQ);
            k.c(th);
        }
    }

    /* compiled from: KycRequests */
    private class b extends com.iqoption.system.c.b<Context, l> {
        public b(Context context) {
            super((Object) context);
        }

        /* renamed from: a */
        public void z(Context context, l lVar) {
            super.z(context, lVar);
            af.aR(context).ac(System.currentTimeMillis());
        }

        /* renamed from: a */
        public void c(Context context, Throwable th) {
            super.c(context, th);
            com.crashlytics.android.a.log("request phone confirm code error");
            k.c(th);
        }
    }

    public f(Context context) {
        this.context = context;
    }

    public s<m> hX(String str) {
        s C;
        com.iqoption.app.a aL = com.iqoption.app.a.aL(this.context);
        if (aL.isActivated()) {
            C = com.iqoption.mobbtech.connect.request.api.a.C(this.context, str);
        } else if (TextUtils.equals(aL.getEmail(), str)) {
            C = com.iqoption.mobbtech.connect.request.api.a.c(this.context, aL.getEmail(), aL.getUserId());
        } else {
            C = com.iqoption.mobbtech.connect.request.api.a.e(this.context, aL.getEmail(), str);
        }
        o.a(C, new a("change email error", null));
        return C;
    }

    public Pair<? extends s<? extends l>, Long> a(int i, long j, KycState kycState) {
        Object a;
        c cVar = new c(this.context, kycState);
        PhoneNumber aoB = cVar.aoB();
        boolean z = i == aoB.xE() && j == aoB.ye();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConfirmPhone() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        stringBuilder.append(", isSamePhone=");
        stringBuilder.append(z);
        i.d(str, stringBuilder.toString());
        if (!z) {
            i.d(TAG, "save phone & request confirm code");
            a = o.a(com.iqoption.mobbtech.connect.request.api.a.b(this.context, (long) i, j), new g<m, com.iqoption.mobbtech.connect.response.o>() {
                /* renamed from: a */
                public s<com.iqoption.mobbtech.connect.response.o> aP(m mVar) {
                    return com.iqoption.mobbtech.connect.request.api.a.bE(f.this.context);
                }
            });
            j = System.currentTimeMillis();
            o.a((s) a, new b(this.context));
        } else if (cVar.aoE()) {
            i.d(TAG, "confirmation code is expired");
            a = com.iqoption.mobbtech.connect.request.api.a.bE(this.context);
            j = System.currentTimeMillis();
            o.a((s) a, new b(this.context));
        } else {
            i = af.aR(this.context).EL();
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("confirmation code is not expired, confirmCode:");
            stringBuilder2.append(i);
            i.d(str2, stringBuilder2.toString());
            com.iqoption.mobbtech.connect.response.o oVar = new com.iqoption.mobbtech.connect.response.o();
            oVar.isSuccessful = Boolean.valueOf(true);
            j = cVar.EK();
            a = o.aR(oVar);
        }
        return Pair.create(a, Long.valueOf(j));
    }

    public s<com.iqoption.mobbtech.connect.response.o> hY(String str) {
        s D = com.iqoption.mobbtech.connect.request.api.a.D(this.context, str);
        o.a(D, new n<com.iqoption.mobbtech.connect.response.o>() {
            /* renamed from: a */
            public void onSuccess(com.iqoption.mobbtech.connect.response.o oVar) {
                if (oVar.isSuccessful()) {
                    com.iqoption.app.a.aL(IQApp.Dk()).aJ(true);
                }
            }

            public void l(Throwable th) {
                com.crashlytics.android.a.log("confirm phone error");
                k.c(th);
            }
        });
        return D;
    }

    public s<Country> aoP() {
        return by(com.iqoption.app.a.aL(this.context).Db());
    }

    public s<Country> by(long j) {
        s by = d.by(j);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get country error, country id=");
        stringBuilder.append(j);
        o.a(by, new a(stringBuilder.toString(), null));
        return by;
    }

    public s<j> j(e eVar) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("saveProfile ");
        stringBuilder.append(eVar);
        i.d(str, stringBuilder.toString());
        if (eVar.aoO()) {
            String stringBuilder2;
            StringBuilder stringBuilder3;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(bf.cgq.format(eVar.cJq));
            stringBuilder4.append(" UTC");
            str = stringBuilder4.toString();
            com.google.common.collect.ImmutableSortedSet.a tC = ImmutableSortedSet.tC();
            v uQ = TreeMultimap.uQ();
            uQ.j("first_name", eVar.firstName);
            uQ.j("last_name", eVar.lastName);
            uQ.j("birthday", str);
            uQ.j("gender", eVar.cJr.booleanValue() ? "male" : "female");
            uQ.j("country_id", String.valueOf(eVar.cJs));
            uQ.j("nationality", eVar.nationality);
            uQ.j("city", eVar.city);
            uQ.j("postal_index", eVar.cJu);
            uQ.j("address", eVar.address);
            tC.l("first_name", "last_name", "birthday", "gender", "country_id", "nationality", "city", "postal_index", "address");
            if (eVar.cJv != null) {
                for (Integer num : eVar.cJv.sb()) {
                    Object<Integer> obj = eVar.cJv.get(num);
                    if (obj.size() == 1) {
                        StringBuilder stringBuilder5 = new StringBuilder();
                        stringBuilder5.append("answers[");
                        stringBuilder5.append(num);
                        stringBuilder5.append("]");
                        stringBuilder2 = stringBuilder5.toString();
                        uQ.j(stringBuilder2, String.valueOf(com.google.common.collect.s.r(obj)));
                        tC.an(stringBuilder2);
                    } else {
                        for (Integer num2 : obj) {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("answers[");
                            stringBuilder3.append(num);
                            stringBuilder3.append("][]");
                            String stringBuilder6 = stringBuilder3.toString();
                            uQ.j(stringBuilder6, String.valueOf(num2));
                            tC.an(stringBuilder6);
                        }
                    }
                }
            }
            uQ.j("skey", com.iqoption.app.a.aL(this.context).Dc());
            tC.an("skey");
            ImmutableSortedSet tG = tC.tt();
            String str2 = "";
            Iterator sI = tG.iterator();
            while (sI.hasNext()) {
                stringBuilder2 = (String) sI.next();
                for (String str3 : uQ.Z(stringBuilder2)) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str2);
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append("=");
                    stringBuilder3.append(str3);
                    str2 = stringBuilder3.toString();
                }
            }
            uQ.aa("skey");
            uQ.j("fkey", as.jM(str2));
            s a = RequestManager.a(IQApp.Dl().getClusterApi(), "api/profile/v2/save-data", ImmutableListMultimap.c(uQ), this.context, j.class);
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append("save profile error, kycProfile=");
            stringBuilder7.append(eVar);
            o.a(a, new a(stringBuilder7.toString(), null));
            return a;
        }
        i.e(TAG, "profile is not filled");
        return o.m(new RuntimeException("profile is not filled"));
    }

    public void dJ(boolean z) {
        af.aR(this.context).b(com.iqoption.app.a.aL(this.context).getUserId(), z);
    }

    public s<KycQuestionsResult> aoQ() {
        i.d(TAG, "getQuestion");
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/profile/kyc-questions");
        s auG = new com.iqoption.mobbtech.connect.request.a.a.k(KycQuestionsResult.class, RequestManager.a(stringBuilder.toString(), null, this.context), "api/profile/kyc-questions").auG();
        o.a(auG, new a("kyc-questions error", null));
        return auG;
    }

    public s<KycState> aoR() {
        i.d(TAG, "getKycState");
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/profile/kyc");
        return new com.iqoption.mobbtech.connect.request.a.a.k(KycState.class, RequestManager.a(stringBuilder.toString(), null, this.context), "api/profile/kyc").auF();
    }

    public s<ProofDocsResult> g(@Nullable Integer num) {
        i.d(TAG, "getKycDocs");
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/profile/get-docs");
        clusterApi = stringBuilder.toString();
        HashMap hashMap = new HashMap();
        hashMap.put(Param.TYPE, num == null ? "" : num);
        s auF = new com.iqoption.mobbtech.connect.request.a.a.k(ProofDocsResult.class, RequestManager.b(clusterApi, hashMap, this.context), "api/profile/get-docs").auF();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("profile get-docs error, docType=");
        stringBuilder2.append(num);
        o.a(auF, new a(stringBuilder2.toString(), null));
        return auF;
    }

    public s<? extends l> aoS() {
        i.d(TAG, "saveSkipPhone");
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/profile/skipphone");
        s auF = new com.iqoption.mobbtech.connect.request.a.a.k(m.class, RequestManager.a(stringBuilder.toString(), null, this.context), "api/profile/skipphone").auF();
        o.a(auF, new a("profile skipphone error", null));
        return auF;
    }

    public s<? extends l> aoT() {
        i.d(TAG, "saveSkipDocuments");
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/profile/skipdocuments");
        s auF = new com.iqoption.mobbtech.connect.request.a.a.k(m.class, RequestManager.a(stringBuilder.toString(), null, this.context), "api/profile/skipdocuments").auF();
        o.a(auF, new a("profile skipdocuments error", null));
        return auF;
    }
}
