package com.iqoption.charttools.model.indicator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.iqoption.core.data.model.c;
import com.iqoption.core.f;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u000bH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u000e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\u000f\u0010(\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010)J\n\u0010*\u001a\u0004\u0018\u00010\u0003H\u0016J \u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010,\u001a\u00020 2\u0006\u0010%\u001a\u00020&J\u0016\u0010-\u001a\u00020.2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0001\u0013/0123456789:;<=>?@A¨\u0006B"}, aXE = {"Lcom/iqoption/charttools/model/indicator/LocalIndicator;", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "uid", "", "title", "localizedTitleId", "", "infoId", "iconRes", "(Ljava/lang/String;Ljava/lang/String;III)V", "cachedIcon", "Lcom/iqoption/core/data/model/UrlOrRes;", "getIconRes", "()I", "getInfoId", "keys", "", "getKeys", "()[Ljava/lang/String;", "getLocalizedTitleId", "getTitle", "()Ljava/lang/String;", "titleKeysIndices", "", "getTitleKeysIndices", "()[I", "getIcon", "getInfo", "getLocalizedTitle", "getMaxInstances", "getParams", "values", "Lcom/google/gson/JsonArray;", "getParsedValue", "Lcom/google/gson/JsonElement;", "key", "index", "json", "Lcom/google/gson/JsonObject;", "getStaticTitle", "getVideoDuration", "()Ljava/lang/Integer;", "getVideoUrl", "getWrittenValue", "parseValues", "writeValues", "", "Lcom/iqoption/charttools/model/indicator/Figure;", "Lcom/iqoption/charttools/model/indicator/BollingerBands;", "Lcom/iqoption/charttools/model/indicator/Alligator;", "Lcom/iqoption/charttools/model/indicator/MovingAverage;", "Lcom/iqoption/charttools/model/indicator/RSI;", "Lcom/iqoption/charttools/model/indicator/ADX;", "Lcom/iqoption/charttools/model/indicator/ATR;", "Lcom/iqoption/charttools/model/indicator/AwesomeOscillator;", "Lcom/iqoption/charttools/model/indicator/CCI;", "Lcom/iqoption/charttools/model/indicator/Fractal;", "Lcom/iqoption/charttools/model/indicator/MACD;", "Lcom/iqoption/charttools/model/indicator/ParabolicSAR;", "Lcom/iqoption/charttools/model/indicator/StochasticOscillator;", "Lcom/iqoption/charttools/model/indicator/BelkhayateTiming;", "Lcom/iqoption/charttools/model/indicator/DPO;", "Lcom/iqoption/charttools/model/indicator/Ichimoku;", "Lcom/iqoption/charttools/model/indicator/KDJ;", "Lcom/iqoption/charttools/model/indicator/Momentum;", "Lcom/iqoption/charttools/model/indicator/WilliamsPercentRange;", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public abstract class v extends x {
    private c ayA;
    private final int ayB;
    private final int ayC;
    private final int iconRes;
    private final String title;

    public int LZ() {
        return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public String Mk() {
        return null;
    }

    protected abstract String[] getKeys();

    public /* synthetic */ v(String str, String str2, int i, int i2, int i3, f fVar) {
        this(str, str2, i, i2, i3);
    }

    private v(String str, String str2, int i, int i2, int i3) {
        super(str, null);
        this.title = str2;
        this.ayB = i;
        this.ayC = i2;
        this.iconRes = i3;
    }

    public int[] LX() {
        return com.iqoption.core.ext.c.SU();
    }

    public final JsonArray b(JsonObject jsonObject) {
        h.e(jsonObject, "json");
        JsonArray jsonArray = new JsonArray();
        String[] keys = getKeys();
        int length = keys.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            jsonArray.add(a(keys[i], i2, jsonObject));
            i++;
            i2 = i3;
        }
        return jsonArray;
    }

    public final void a(JsonObject jsonObject, JsonArray jsonArray) {
        h.e(jsonObject, "json");
        h.e(jsonArray, "values");
        y.a(getKeys(), jsonArray);
        String[] keys = getKeys();
        int length = keys.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = keys[i];
            int i3 = i2 + 1;
            jsonObject.add(str, a(str, i2, jsonArray));
            i++;
            i2 = i3;
        }
    }

    public JsonElement a(String str, int i, JsonArray jsonArray) {
        h.e(str, "key");
        h.e(jsonArray, "values");
        JsonElement jsonElement = jsonArray.get(i);
        h.d(jsonElement, "values[index]");
        return jsonElement;
    }

    public JsonElement a(String str, int i, JsonObject jsonObject) {
        h.e(str, "key");
        h.e(jsonObject, "json");
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return jsonElement;
        }
        JsonNull jsonNull = JsonNull.INSTANCE;
        h.d(jsonNull, "JsonNull.INSTANCE");
        return jsonNull;
    }

    public final String e(JsonArray jsonArray) {
        h.e(jsonArray, "values");
        return i.a(LX(), (CharSequence) ", ", null, null, 0, null, (b) new LocalIndicator$getParams$1(jsonArray), 30, null);
    }

    public String Mi() {
        return f.getString(this.ayB);
    }

    public String getInfo() {
        return f.getString(this.ayC);
    }

    public c Mj() {
        c cVar = this.ayA;
        if (cVar != null) {
            return cVar;
        }
        cVar = new c(null, this.iconRes, 1, null);
        this.ayA = cVar;
        return cVar;
    }
}
