package com.iqoption.charttools.model.indicator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 /2\u00020\u0001:\u0001/B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\f8FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u0016R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\f8TX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001c\u0010\u0013\u0001\u00070123456¨\u00067"}, aXE = {"Lcom/iqoption/charttools/model/indicator/Figure;", "Lcom/iqoption/charttools/model/indicator/LocalIndicator;", "uid", "", "titleId", "", "(Ljava/lang/String;I)V", "canHostFigures", "", "getCanHostFigures", "()Z", "commonKeys", "", "[Ljava/lang/String;", "commonValues", "", "[Ljava/lang/Object;", "dataKeys", "getDataKeys", "()[Ljava/lang/String;", "dataValues", "getDataValues", "()[Ljava/lang/Object;", "defaults", "getDefaults", "defaults$delegate", "Lkotlin/Lazy;", "keys", "getKeys", "keys$delegate", "getActiveId", "values", "Lcom/google/gson/JsonArray;", "getColor", "getHostIndex", "getParsedValue", "Lcom/google/gson/JsonElement;", "key", "index", "json", "Lcom/google/gson/JsonObject;", "getWidth", "setActiveId", "", "activeId", "setHostIndex", "hostIndex", "Companion", "Lcom/iqoption/charttools/model/indicator/FigureInterval;", "Lcom/iqoption/charttools/model/indicator/FigureRay;", "Lcom/iqoption/charttools/model/indicator/FigureHorizontalLine;", "Lcom/iqoption/charttools/model/indicator/FigureVerticalLine;", "Lcom/iqoption/charttools/model/indicator/FigureFibonacciLine;", "Lcom/iqoption/charttools/model/indicator/FigureFibonacciArcLine;", "Lcom/iqoption/charttools/model/indicator/FigureFibonacciSpiral;", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public abstract class k extends v {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(k.class), "keys", "getKeys()[Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(k.class), "defaults", "getDefaults()[Ljava/lang/Object;"))};
    public static final a ayn = new a();
    private final String[] ayj;
    private final Object[] ayk;
    private final transient d ayl;
    private final transient d aym;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/charttools/model/indicator/Figure$Companion;", "", "()V", "ACTIVE_ID", "", "COLOR", "HOST_INSTR_ID", "WIDTH", "techtools_release"})
    /* compiled from: MetaIndicator.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public boolean LY() {
        return false;
    }

    protected abstract String[] Md();

    protected abstract Object[] Me();

    public final Object[] Mf() {
        d dVar = this.aym;
        j jVar = apP[1];
        return (Object[]) dVar.getValue();
    }

    protected String[] getKeys() {
        d dVar = this.ayl;
        j jVar = apP[0];
        return (String[]) dVar.getValue();
    }

    private k(String str, int i) {
        super(str, "", i, 0, 0, null);
        this.ayj = new String[]{"active_id", "color", "width", "host_instr_id"};
        this.ayk = new Object[]{Integer.valueOf(1), Integer.valueOf(i.ayg[0]), Integer.valueOf(i.ayh[0]), Integer.valueOf(-1)};
        this.ayl = g.f(new Figure$keys$2(this));
        this.aym = g.f(new Figure$defaults$2(this));
    }

    public /* synthetic */ k(String str, int i, f fVar) {
        this(str, i);
    }

    public JsonElement a(String str, int i, JsonObject jsonObject) {
        h.e(str, "key");
        h.e(jsonObject, "json");
        JsonElement a = super.a(str, i, jsonObject);
        return a.isJsonNull() ? com.iqoption.core.ext.d.b(Mf()[i], null, 1, null) : a;
    }

    public final int a(JsonArray jsonArray) {
        h.e(jsonArray, "values");
        return com.iqoption.core.ext.d.a(jsonArray, i.indexOf(this.ayj, "host_instr_id"), -1);
    }

    public final void a(int i, JsonArray jsonArray) {
        h.e(jsonArray, "values");
        jsonArray.set(i.indexOf(this.ayj, "host_instr_id"), new JsonPrimitive((Number) Integer.valueOf(i)));
    }

    public final int b(JsonArray jsonArray) {
        h.e(jsonArray, "values");
        return com.iqoption.core.ext.d.a(jsonArray, i.indexOf(this.ayj, "active_id"), 0);
    }

    public final void b(int i, JsonArray jsonArray) {
        h.e(jsonArray, "values");
        jsonArray.set(i.indexOf(this.ayj, "active_id"), new JsonPrimitive((Number) Integer.valueOf(i)));
    }

    public final int c(JsonArray jsonArray) {
        h.e(jsonArray, "values");
        return com.iqoption.core.ext.d.a(jsonArray, i.indexOf(this.ayj, "color"), i.ayg[0]);
    }

    public final int d(JsonArray jsonArray) {
        h.e(jsonArray, "values");
        return com.iqoption.core.ext.d.a(jsonArray, i.indexOf(this.ayj, "width"), i.ayh[0]);
    }
}
