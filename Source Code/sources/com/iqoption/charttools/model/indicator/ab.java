package com.iqoption.charttools.model.indicator;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.iqoption.charttools.o;
import com.iqoption.charttools.o.e;
import com.iqoption.dto.event.OtnEmissionExecuted;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, aXE = {"Lcom/iqoption/charttools/model/indicator/MovingAverage;", "Lcom/iqoption/charttools/model/indicator/LocalIndicator;", "()V", "TYPES", "", "", "getTYPES", "()[Ljava/lang/String;", "[Ljava/lang/String;", "canHostFigures", "", "getCanHostFigures", "()Z", "keys", "getKeys", "titleKeysIndices", "", "getTitleKeysIndices", "()[I", "getMaxInstances", "", "getParsedValue", "Lcom/google/gson/JsonElement;", "key", "index", "json", "Lcom/google/gson/JsonObject;", "getWrittenValue", "values", "Lcom/google/gson/JsonArray;", "isTypeMatches", "type", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public final class ab extends v {
    private static final String[] TYPES = new String[]{"SMA", "WMA", "EMA", "SSMA"};
    private static final String[] axV = new String[]{Param.TYPE, OtnEmissionExecuted.COUNT, "color", "ma_width"};
    private static final int[] axW = new int[]{1};
    public static final ab ayH = new ab();

    public boolean LY() {
        return false;
    }

    public int LZ() {
        return 32;
    }

    private ab() {
        super("MovingAverage", "MA", o.i.iq4_indicators_title_moving_average, o.i.iq4_indicators_hint_moving_average, e.ic_icon_instrument_ma, null);
    }

    public final String[] Mn() {
        return TYPES;
    }

    protected String[] getKeys() {
        return axV;
    }

    public int[] LX() {
        return axW;
    }

    public JsonElement a(String str, int i, JsonArray jsonArray) {
        h.e(str, "key");
        h.e(jsonArray, "values");
        if (i != i.indexOf(getKeys(), Param.TYPE)) {
            return super.a(str, i, jsonArray);
        }
        String[] strArr = TYPES;
        JsonElement jsonElement = jsonArray.get(i);
        if (jsonElement != null) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive != null) {
                i = asJsonPrimitive.getAsInt();
                return new JsonPrimitive(strArr[i]);
            }
        }
        i = 0;
        return new JsonPrimitive(strArr[i]);
    }

    /* JADX WARNING: Missing block: B:7:0x002b, code:
            if (r3 != null) goto L_0x0033;
     */
    public com.google.gson.JsonElement a(java.lang.String r3, int r4, com.google.gson.JsonObject r5) {
        /*
        r2 = this;
        r0 = "key";
        kotlin.jvm.internal.h.e(r3, r0);
        r0 = "json";
        kotlin.jvm.internal.h.e(r5, r0);
        r0 = r2.getKeys();
        r1 = "type";
        r0 = kotlin.collections.i.indexOf(r0, r1);
        if (r4 != r0) goto L_0x0043;
    L_0x0017:
        r4 = new com.google.gson.JsonPrimitive;
        r0 = TYPES;
        r3 = r5.get(r3);
        if (r3 == 0) goto L_0x002e;
    L_0x0021:
        r3 = r3.getAsJsonPrimitive();
        if (r3 == 0) goto L_0x002e;
    L_0x0027:
        r3 = r3.getAsString();
        if (r3 == 0) goto L_0x002e;
    L_0x002d:
        goto L_0x0033;
    L_0x002e:
        r3 = TYPES;
        r5 = 0;
        r3 = r3[r5];
    L_0x0033:
        r3 = kotlin.collections.i.indexOf(r0, r3);
        r3 = java.lang.Integer.valueOf(r3);
        r3 = (java.lang.Number) r3;
        r4.<init>(r3);
        r4 = (com.google.gson.JsonElement) r4;
        return r4;
    L_0x0043:
        r3 = super.a(r3, r4, r5);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.model.indicator.ab.a(java.lang.String, int, com.google.gson.JsonObject):com.google.gson.JsonElement");
    }

    public boolean fC(String str) {
        h.e(str, Param.TYPE);
        return i.b((Object[]) TYPES, (Object) str) || super.fC(str);
    }
}
