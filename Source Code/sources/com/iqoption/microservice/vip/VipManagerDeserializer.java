package com.iqoption.microservice.vip;

import android.text.TextUtils;
import com.google.common.base.d;
import com.google.common.collect.Lists;
import com.google.common.collect.h;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.iqoption.app.IQApp;
import com.iqoption.vip.WeekDay;
import com.iqoption.vip.j;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class VipManagerDeserializer implements JsonDeserializer<d> {
    private static DateFormat cTh = new SimpleDateFormat("HH:mm'Z'", Locale.US);
    public static DateFormat cTi = new SimpleDateFormat("HH:mm", Locale.US);
    public static DateFormat cgq = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public VipManagerDeserializer() {
        cTh.setTimeZone(TimeZone.getTimeZone("UTC"));
        cTi.setTimeZone(TimeZone.getDefault());
    }

    /* renamed from: f */
    public d deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            return g(jsonElement.getAsJsonObject());
        } catch (Exception unused) {
            return null;
        }
    }

    private d g(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject;
        boolean asBoolean = jsonObject2.get("canBeRated").getAsBoolean();
        boolean asBoolean2 = jsonObject2.get("canOrderCallback").getAsBoolean();
        boolean asBoolean3 = jsonObject2.get("canOrderVipSupportCallback").getAsBoolean();
        boolean asBoolean4 = jsonObject2.get("hasVipManager").getAsBoolean();
        if (!asBoolean4) {
            return null;
        }
        List emptyList;
        List emptyList2;
        String str;
        Map emptyMap;
        boolean asBoolean5 = jsonObject2.get("isOnline").getAsBoolean();
        JsonElement jsonElement = jsonObject2.get("managerBirthCountry");
        String asString = jsonElement.getAsJsonPrimitive().isBoolean() ? "" : jsonElement.getAsString();
        jsonElement = jsonObject2.get("managerBirthday");
        String asString2 = jsonElement.getAsJsonPrimitive().isBoolean() ? "" : jsonElement.getAsString();
        JsonElement jsonElement2 = jsonObject2.get("managerDescription");
        String asString3 = jsonElement2.getAsJsonPrimitive().isBoolean() ? "" : jsonElement2.getAsString();
        jsonElement2 = jsonObject2.get("managerGender");
        int asInt = jsonElement2.getAsJsonPrimitive().isBoolean() ? 0 : jsonElement2.getAsInt();
        jsonElement2 = jsonObject2.get("managerId");
        String asString4 = jsonElement2.getAsJsonPrimitive().isBoolean() ? "" : jsonElement2.getAsString();
        jsonElement2 = jsonObject2.get("managerLanguages");
        if (jsonElement2.isJsonPrimitive()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = (List) IQApp.Dk().Dq().fromJson(jsonElement2, new TypeToken<ArrayList<String>>() {
            }.getType());
        }
        List a = Lists.a(emptyList, new d<String, String>() {
            /* renamed from: cH */
            public String apply(String str) {
                if (str == null) {
                    return null;
                }
                String[] split = str.split("_");
                return new Locale(split[0], split[1]).getCountry();
            }
        });
        jsonElement2 = jsonObject2.get("managerName");
        String asString5 = jsonElement2.getAsJsonPrimitive().isBoolean() ? "" : jsonElement2.getAsString();
        jsonElement2 = jsonObject2.get("managerPhone");
        String asString6 = jsonElement2.getAsJsonPrimitive().isBoolean() ? "" : jsonElement2.getAsString();
        jsonElement2 = jsonObject2.get("managerPhoto");
        String asString7 = jsonElement2.getAsJsonPrimitive().isBoolean() ? "" : jsonElement2.getAsString();
        jsonElement2 = jsonObject2.get("managerPhotosList");
        if (jsonElement2.isJsonPrimitive()) {
            emptyList2 = Collections.emptyList();
            str = asString5;
        } else {
            str = asString5;
            emptyList2 = (List) IQApp.Dk().Dq().fromJson(jsonElement2, new TypeToken<ArrayList<String>>() {
            }.getType());
        }
        jsonElement2 = jsonObject2.get("trainingSessionsCategories");
        if (jsonElement2.isJsonPrimitive()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = (List) IQApp.Dk().Dq().fromJson(jsonElement2, new TypeToken<ArrayList<c>>() {
            }.getType());
        }
        List list = emptyList;
        jsonElement2 = jsonObject2.get("trainingSessions");
        if (jsonElement2.isJsonPrimitive()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = (List) IQApp.Dk().Dq().fromJson(jsonElement2, new TypeToken<ArrayList<b>>() {
            }.getType());
        }
        List list2 = emptyList;
        jsonElement2 = jsonObject2.get("certificates");
        if (jsonElement2.isJsonPrimitive()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = (List) IQApp.Dk().Dq().fromJson(jsonElement2, new TypeToken<ArrayList<Object>>() {
            }.getType());
        }
        List list3 = emptyList;
        jsonElement2 = jsonObject2.get("educationMaterials");
        if (jsonElement2.isJsonPrimitive()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = (List) IQApp.Dk().Dq().fromJson(jsonElement2, new TypeToken<ArrayList<Object>>() {
            }.getType());
        }
        List list4 = emptyList;
        jsonElement2 = jsonObject2.get("managerWorkStartDate");
        String asString8 = jsonElement2.getAsJsonPrimitive().isBoolean() ? "" : jsonElement2.getAsString();
        JsonElement jsonElement3 = jsonObject2.get("managerWorkTimeUTC");
        if (jsonElement3.isJsonPrimitive()) {
            emptyMap = Collections.emptyMap();
        } else {
            emptyMap = (Map) IQApp.Dk().Dq().fromJson(jsonElement3, new TypeToken<Map<String, ArrayList<String>>>() {
            }.getType());
        }
        return new d(asBoolean, asBoolean2, asBoolean3, asBoolean4, asBoolean5, asString, parseDate(asString2), asString3, asInt, asString4, a, str, asString6, asString7, emptyList2, list, list2, list3, list4, parseDate(asString8), A(emptyMap), B(emptyMap));
    }

    private static List<String> A(Map<String, List<String>> map) {
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> arrayList = new ArrayList();
        List list = null;
        String str = null;
        String str2 = str;
        for (WeekDay weekDay : WeekDay.values()) {
            List list2 = (List) map.get(weekDay.getMapValue());
            if (list == null || !list.equals(list2)) {
                if (list != null) {
                    a(str, str2, list, arrayList);
                }
                str = IQApp.Dk().getResources().getString(weekDay.getNameId());
                list = list2;
            }
            str2 = IQApp.Dk().getResources().getString(weekDay.getNameId());
        }
        a(str, str2, list, arrayList);
        return arrayList;
    }

    private static void a(String str, String str2, List<String> list, List<String> list2) {
        if (list != null) {
            Iterable a = h.a((Collection) list, new d<String, String>() {
                /* renamed from: cH */
                public String apply(String str) {
                    if (str == null) {
                        return null;
                    }
                    try {
                        return VipManagerDeserializer.ip(str);
                    } catch (Throwable e) {
                        throw new IllegalStateException(e);
                    }
                }
            });
            if (str.equals(str2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" ");
                stringBuilder.append(TextUtils.join(" - ", a));
                list2.add(stringBuilder.toString());
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(" - ");
                stringBuilder2.append(str2);
                stringBuilder2.append(" ");
                stringBuilder2.append(TextUtils.join(" - ", a));
                list2.add(stringBuilder2.toString());
            }
        }
    }

    private static Map<WeekDay, j> B(Map<String, List<String>> map) {
        Map<WeekDay, j> hashMap = new HashMap(map.size());
        for (WeekDay weekDay : WeekDay.values()) {
            List list = (List) map.get(weekDay.getMapValue());
            if (list != null) {
                hashMap.put(weekDay, new j(io((String) list.get(0)), io((String) list.get(1))));
            }
        }
        return hashMap;
    }

    private static Date io(String str) {
        try {
            return cTh.parse(str);
        } catch (ParseException unused) {
            return new Date();
        }
    }

    private static String ip(String str) {
        return cTi.format(cTh.parse(str));
    }

    private static Date parseDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Date();
        }
        try {
            return cgq.parse(str);
        } catch (ParseException unused) {
            return new Date();
        }
    }
}
