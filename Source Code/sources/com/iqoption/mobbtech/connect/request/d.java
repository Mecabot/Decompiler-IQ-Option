package com.iqoption.mobbtech.connect.request;

import android.content.Context;
import com.iqoption.app.IQApp;
import com.iqoption.app.a.b;
import com.iqoption.dto.Country;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.mobbtech.connect.response.h;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CountriesRequest */
public class d {

    /* compiled from: CountriesRequest */
    public interface a {
        void aO(List<Country> list);
    }

    public void a(final Context context, final a aVar) {
        String clusterApi = IQApp.Dl().getClusterApi();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clusterApi);
        stringBuilder.append("api/register/getregdata");
        com.iqoption.mobbtech.connect.request.a.a.a.a(RequestManager.e(stringBuilder.toString(), context), new com.iqoption.mobbtech.connect.a.a() {
            /* renamed from: a */
            public void onSuccess(h hVar) {
                try {
                    JSONObject jSONObject = hVar.auV().getJSONObject("result");
                    List<Country> a = h.a(Country.class, jSONObject.getJSONArray("country"));
                    jSONObject = jSONObject.getJSONObject("phone_codes");
                    for (Country country : a) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(country.id);
                        stringBuilder.append("");
                        if (jSONObject.has(stringBuilder.toString())) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(country.id);
                            stringBuilder.append("");
                            country.phoneCode = jSONObject.getInt(stringBuilder.toString());
                        }
                    }
                    Collections.sort(a, new Comparator<Country>() {
                        /* renamed from: a */
                        public int compare(Country country, Country country2) {
                            return country.name.compareTo(country2.name);
                        }
                    });
                    aVar.aO(a);
                } catch (JSONException unused) {
                    b.aT(context);
                }
            }

            public void a(g gVar) {
                try {
                    b.b(gVar.auS().optString("message", ""), context);
                } catch (Exception unused) {
                    b.aT(context);
                }
            }
        }, "api/register/getregdata");
    }
}
