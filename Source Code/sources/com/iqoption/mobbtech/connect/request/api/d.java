package com.iqoption.mobbtech.connect.request.api;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.gson.reflect.TypeToken;
import com.iqoption.dto.entity.iqbus.Country;
import com.iqoption.mobbtech.connect.request.a.a.b;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: IQBusGeoRequests */
public class d {
    private static final String TAG = "com.iqoption.mobbtech.connect.request.api.d";
    private static ImmutableMap<Long, Country> cUI = ImmutableMap.sT();
    private static ImmutableList<Country> cUJ = ImmutableList.sL();

    public static s<Country> by(final long j) {
        if (cUI.containsKey(Long.valueOf(j))) {
            return o.aR(cUI.get(Long.valueOf(j)));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", Long.valueOf(j));
        s b = new b(Country.class, null, "get-country").b("get-country", hashMap);
        o.a(b, new n<Country>() {
            public void l(Throwable th) {
            }

            /* renamed from: d */
            public void onSuccess(Country country) {
                d.cUI = ImmutableMap.sU().o(d.cUI).r(Long.valueOf(j), country).tc();
            }
        });
        return b;
    }

    public static s<ImmutableList<Country>> aus() {
        if (!cUJ.isEmpty()) {
            return o.aR(cUJ);
        }
        return o.a(new b(new TypeToken<ArrayList<Country>>() {
        }.getType(), "get-countries-list").b("get-countries-list", new HashMap()), new com.google.common.base.d<ArrayList<Country>, ImmutableList<Country>>() {
            /* renamed from: i */
            public ImmutableList<Country> apply(ArrayList<Country> arrayList) {
                d.cUJ = ImmutableList.m(Country.ORDERING.sortedCopy(arrayList));
                d.cUI = Maps.b(d.cUJ, new com.google.common.base.d<Country, Long>() {
                    public Long apply(Country country) {
                        return country.id;
                    }
                });
                return d.cUJ;
            }
        });
    }
}
