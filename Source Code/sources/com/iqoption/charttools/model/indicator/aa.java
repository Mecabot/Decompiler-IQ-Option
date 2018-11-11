package com.iqoption.charttools.model.indicator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.iqoption.charttools.o;
import com.iqoption.charttools.o.e;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.event.OtnEmissionExecuted;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u001a"}, aXE = {"Lcom/iqoption/charttools/model/indicator/Momentum;", "Lcom/iqoption/charttools/model/indicator/LocalIndicator;", "()V", "LOCALIZED_TYPE_IDS", "", "getLOCALIZED_TYPE_IDS", "()[I", "TYPES", "", "", "[Ljava/lang/String;", "keys", "getKeys", "()[Ljava/lang/String;", "titleKeysIndices", "getTitleKeysIndices", "getParsedValue", "Lcom/google/gson/JsonElement;", "key", "index", "", "json", "Lcom/google/gson/JsonObject;", "getWrittenValue", "values", "Lcom/google/gson/JsonArray;", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public final class aa extends v {
    private static final String[] TYPES = new String[]{"close", Position.STATUS_OPEN, "min", "max"};
    private static final String[] axV = new String[]{"ma_value", OtnEmissionExecuted.COUNT, "color", "ma_width"};
    private static final int[] axW = new int[]{1};
    private static final int[] ayF = new int[]{o.i.close_noun, o.i.open_noun, o.i.min_abbr, o.i.max_abbr};
    public static final aa ayG = new aa();

    private aa() {
        super("Momentum", "Momentum", o.i.momentum, o.i.momentum_descr, e.ic_icon_instrument_momentum, null);
    }

    public final int[] Mm() {
        return ayF;
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
        if (i != i.indexOf(getKeys(), "ma_value")) {
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

    /* JADX WARNING: Missing block: B:7:0x002a, code:
            if (r3 != null) goto L_0x0032;
     */
    public com.google.gson.JsonElement a(java.lang.String r3, int r4, com.google.gson.JsonObject r5) {
        /*
        r2 = this;
        r0 = "key";
        kotlin.jvm.internal.h.e(r3, r0);
        r0 = "json";
        kotlin.jvm.internal.h.e(r5, r0);
        r0 = r2.getKeys();
        r1 = "ma_value";
        r0 = kotlin.collections.i.indexOf(r0, r1);
        if (r4 != r0) goto L_0x0042;
    L_0x0016:
        r4 = new com.google.gson.JsonPrimitive;
        r0 = TYPES;
        r3 = r5.get(r3);
        if (r3 == 0) goto L_0x002d;
    L_0x0020:
        r3 = r3.getAsJsonPrimitive();
        if (r3 == 0) goto L_0x002d;
    L_0x0026:
        r3 = r3.getAsString();
        if (r3 == 0) goto L_0x002d;
    L_0x002c:
        goto L_0x0032;
    L_0x002d:
        r3 = TYPES;
        r5 = 0;
        r3 = r3[r5];
    L_0x0032:
        r3 = kotlin.collections.i.indexOf(r0, r3);
        r3 = java.lang.Integer.valueOf(r3);
        r3 = (java.lang.Number) r3;
        r4.<init>(r3);
        r4 = (com.google.gson.JsonElement) r4;
        return r4;
    L_0x0042:
        r3 = super.a(r3, r4, r5);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.model.indicator.aa.a(java.lang.String, int, com.google.gson.JsonObject):com.google.gson.JsonElement");
    }
}
