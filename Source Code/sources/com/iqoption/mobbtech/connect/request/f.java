package com.iqoption.mobbtech.connect.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.TreeMultimap;
import com.google.common.collect.v;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.a;
import com.iqoption.app.a.b;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.mobbtech.connect.response.j;
import com.iqoption.util.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: PersonalInfoRequest */
public class f {
    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j, String str10) {
        final Context context2 = context;
        final String str11 = str;
        final String str12 = str2;
        final String str13 = str10;
        final String str14 = str3;
        final String str15 = str4;
        final String str16 = str5;
        final String str17 = str6;
        final String str18 = str7;
        final String str19 = str8;
        final String str20 = str9;
        s a = a(context, str, str2, str6, str7, str8, str9, j, str10);
        n nVar = r1;
        final long j2 = j;
        AnonymousClass1 anonymousClass1 = new n<j>() {
            public void l(Throwable th) {
            }

            /* renamed from: b */
            public void onSuccess(j jVar) {
                a aL = a.aL(context2);
                aL.setFirstName(str11);
                aL.setLastName(str12);
                if (!TextUtils.isEmpty(str13)) {
                    aL.em(str13);
                }
                f.this.a(context2, str14, str15, str16, str17, str18, str19, str20, j2, str13);
            }
        };
        o.a(a, nVar);
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8) {
        final String str9 = str7;
        HashMap hashMap = new HashMap();
        final String str10 = str;
        hashMap.put("email", str10);
        final String str11 = str2;
        hashMap.put("phone_code", str11);
        if (j != -1) {
            hashMap.put("country_id", Long.valueOf(j));
        }
        if (str9 != null) {
            hashMap.put("gender", str9);
        }
        final String str12 = str3;
        hashMap.put("phone", str12);
        final String str13 = str4;
        hashMap.put("city", str13);
        final String str14 = str5;
        hashMap.put("postal_index", str14);
        final String str15 = str6;
        hashMap.put("address", str15);
        hashMap.put("skey", a.aL(context).Dc());
        List<String> arrayList = new ArrayList();
        arrayList.addAll(hashMap.keySet());
        Collections.sort(arrayList);
        String str16 = "";
        for (String str17 : arrayList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str16);
            stringBuilder.append(str17);
            stringBuilder.append("=");
            stringBuilder.append(hashMap.get(str17));
            str16 = stringBuilder.toString();
        }
        hashMap.remove("skey");
        hashMap.put("fkey", as.jM(str16));
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(clusterApi);
        stringBuilder2.append("api/profile/general");
        clusterApi = stringBuilder2.toString();
        final Context context2 = context;
        final long j2 = j;
        final String str172 = str8;
        com.iqoption.mobbtech.connect.request.a.a.a.a(RequestManager.b(clusterApi, hashMap, context2), new com.iqoption.mobbtech.connect.a.a() {
            /* renamed from: a */
            public void onSuccess(h hVar) {
                try {
                    b.b(hVar.auV().getJSONArray("message").getString(0), context2);
                    a aL = a.aL(context2);
                    aL.en(str10);
                    aL.setCountryCode(str11);
                    aL.Y(j2);
                    aL.setPhone(str12);
                    aL.setCity(str13);
                    aL.el(str14);
                    aL.setAddress(str15);
                    aL.ek(str9);
                    if (!TextUtils.isEmpty(str172)) {
                        aL.em(str172);
                    }
                    aL.aN(context2);
                } catch (JSONException unused) {
                }
            }

            public void a(g gVar) {
                try {
                    if (gVar.auS() == null) {
                        b.aT(context2);
                    } else {
                        b.b(gVar.auS().getString("message"), context2);
                    }
                } catch (JSONException unused) {
                    b.aT(context2);
                }
            }
        }, "api/profile/general");
    }

    private static s<j> a(Context context, String str, String str2, String str3, String str4, String str5, String str6, long j, String str7) {
        ImmutableSortedSet.a tC = ImmutableSortedSet.tC();
        v uQ = TreeMultimap.uQ();
        uQ.j("first_name", str);
        uQ.j("last_name", str2);
        uQ.j("gender", str6);
        uQ.j("country_id", String.valueOf(j));
        uQ.j("city", str3);
        uQ.j("postal_index", str4);
        uQ.j("address", str5);
        tC.l("first_name", "last_name", "gender", "country_id", "city", "postal_index", "address");
        if (!TextUtils.isEmpty(str7)) {
            uQ.j("tin", str7);
            tC.an("tin");
        }
        uQ.j("skey", a.aL(context).Dc());
        tC.an("skey");
        str2 = "";
        Iterator sI = tC.tt().iterator();
        while (sI.hasNext()) {
            str3 = (String) sI.next();
            for (String str52 : uQ.Z(str3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(str3);
                stringBuilder.append("=");
                stringBuilder.append(str52);
                str2 = stringBuilder.toString();
            }
        }
        uQ.aa("skey");
        uQ.j("fkey", as.jM(str2));
        return RequestManager.a(IQApp.Dl().getClusterApi(), "api/profile/v2/save-data", ImmutableListMultimap.c(uQ), context, j.class);
    }
}
