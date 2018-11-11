package com.iqoption.fragment.rightpanel;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.iqoption.app.managers.feature.b;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.f;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.entity.Feature;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/fragment/rightpanel/MinDealUtils;", "", "()V", "LIMIT_NOT_SET", "", "paramsCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/iqoption/core/features/deal/DealLimitParams;", "getMinDeal", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MinDealUtils.kt */
public final class as {
    private static final ConcurrentHashMap<String, com.iqoption.core.c.a.a> bVr = new ConcurrentHashMap();
    public static final as cHr = new as();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/ext/GsonExtensionsKt$parseGson$$inlined$typeOf$4"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<com.iqoption.core.c.a.a> {
    }

    private as() {
    }

    public static final double H(InstrumentType instrumentType) {
        h.e(instrumentType, "instrumentType");
        Feature fd = b.HT().fd("instruments-minimal-deal");
        double d = -1.0d;
        if (fd == null) {
            return -1.0d;
        }
        try {
            JsonElement jsonElement = fd.params;
            String jsonElement2 = jsonElement.toString();
            com.iqoption.core.c.a.a aVar = (com.iqoption.core.c.a.a) bVr.get(jsonElement2);
            if (aVar == null) {
                h.d(jsonElement, "params");
                Gson Dq = f.RQ().Dq();
                Type type = new a().getType();
                h.d(type, "object : TypeToken<T>() {}.type");
                aVar = (com.iqoption.core.c.a.a) Dq.fromJson(jsonElement, type);
                Map map = bVr;
                h.d(jsonElement2, "key");
                map.put(jsonElement2, aVar);
            }
            if (!aVar.Ik().contains(instrumentType.getServerValue())) {
                return -1.0d;
            }
            for (Object next : aVar.SZ()) {
                if (h.E(((com.iqoption.core.c.c.b) next).Tc(), fd.status)) {
                    break;
                }
            }
            Object next2 = null;
            com.iqoption.core.c.c.b bVar = (com.iqoption.core.c.c.b) next2;
            if (bVar == null) {
                return -1.0d;
            }
            com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
            h.d(Cw, "IQAccount.instance()");
            ConversionCurrency CF = Cw.CF();
            Object obj = CF != null ? CF.name : null;
            for (Object next22 : bVar.Td()) {
                if (h.E(((com.iqoption.core.c.c.a) next22).getName(), obj)) {
                    break;
                }
            }
            next22 = null;
            com.iqoption.core.c.c.a aVar2 = (com.iqoption.core.c.c.a) next22;
            if (aVar2 != null) {
                BigDecimal Tb = aVar2.Tb();
                if (Tb != null) {
                    d = Tb.doubleValue();
                }
            }
            return d;
        } catch (Exception unused) {
            return -1.0d;
        }
    }
}
