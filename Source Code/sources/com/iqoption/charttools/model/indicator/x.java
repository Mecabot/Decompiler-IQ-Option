package com.iqoption.charttools.model.indicator;

import android.os.Parcel;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0012H\u0016J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0019H&R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n\u0001\u0002#$¨\u0006%"}, aXE = {"Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "", "type", "", "(Ljava/lang/String;)V", "canHostFigures", "", "getCanHostFigures", "()Z", "getType", "()Ljava/lang/String;", "uid", "getUid", "getIcon", "Lcom/iqoption/core/data/model/UrlOrRes;", "getInfo", "getLocalizedTitle", "getMaxInstances", "", "getStaticTitle", "getVideoDuration", "()Ljava/lang/Integer;", "getVideoUrl", "isTypeMatches", "parseValues", "Lcom/google/gson/JsonArray;", "json", "Lcom/google/gson/JsonObject;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "writeValues", "values", "Lcom/iqoption/charttools/model/indicator/LocalIndicator;", "Lcom/iqoption/charttools/model/indicator/ScriptedIndicator;", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public abstract class x {
    @SerializedName("type")
    private final String type;

    public boolean LY() {
        return true;
    }

    public abstract int LZ();

    public abstract String Mi();

    public abstract c Mj();

    public abstract String Mk();

    public abstract void a(JsonObject jsonObject, JsonArray jsonArray);

    public abstract JsonArray b(JsonObject jsonObject);

    public abstract String getInfo();

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
    }

    private x(String str) {
        this.type = str;
    }

    public /* synthetic */ x(String str, f fVar) {
        this(str);
    }

    public final String getType() {
        return this.type;
    }

    public String Ml() {
        return this.type;
    }

    public boolean fC(String str) {
        h.e(str, Param.TYPE);
        return h.E(this.type, str);
    }
}
