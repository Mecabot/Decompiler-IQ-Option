package com.iqoption.charttools.model.indicator.constructor;

import com.iqoption.charttools.model.indicator.constructor.InputItem.Type;
import com.iqoption.core.f;
import com.iqoption.dto.ChartTimeInterval;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0015\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0019J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u0019J \u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0019JI\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010!J3\u0010\"\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0$2\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010%J\"\u0010&\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0019JI\u0010'\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010(J3\u0010)\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160$2\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010*J\"\u0010+\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0019J \u0010,\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0019J3\u0010-\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010.J(\u0010-\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010#\u001a\u00020/2\b\b\u0002\u0010\u0018\u001a\u00020\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u00060"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/InputGroupBuilder;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "inputs", "", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "getInputs", "()Ljava/util/List;", "name", "getName", "setName", "activeInput", "", "", "value", "hidden", "", "booleanInput", "colorInput", "doubleInput", "", "min", "max", "step", "(IDLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Z)V", "doubleSelectionInput", "options", "", "(II[Ljava/lang/Double;Z)V", "hostInput", "intInput", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "intSelectionInput", "(II[Ljava/lang/Integer;Z)V", "lineWidthInput", "stringInput", "stringSelectionInput", "(II[Ljava/lang/String;Z)V", "", "techtools_release"})
/* compiled from: InputBuilder.kt */
public final class d {
    private final List<InputItem> ayV = new ArrayList();
    private String description;
    private String iconUrl;
    private String name = "";

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        h.e(str, "<set-?>");
        this.name = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void fD(String str) {
        this.iconUrl = str;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<InputItem> Mt() {
        return this.ayV;
    }

    public final void a(int i, int i2, Integer num, Integer num2, Integer num3, boolean z) {
        List list = this.ayV;
        Type type = Type.INT;
        String string = i != 0 ? f.getString(i) : "";
        String valueOf = String.valueOf(i2);
        Double d = null;
        Double valueOf2 = num != null ? Double.valueOf((double) num.intValue()) : null;
        Double valueOf3 = num2 != null ? Double.valueOf((double) num2.intValue()) : null;
        if (num3 != null) {
            d = Double.valueOf((double) num3.intValue());
        }
        list.add(new InputItem(type, string, valueOf, valueOf2, valueOf3, d, null, z, 64, null));
    }

    public final void a(int i, double d, Double d2, Double d3, Double d4, boolean z) {
        this.ayV.add(new InputItem(Type.DOUBLE, i != 0 ? f.getString(i) : "", String.valueOf(d), d2, d3, d4, null, z, 64, null));
    }

    public final void a(int i, boolean z, boolean z2) {
        this.ayV.add(new InputItem(Type.BOOL, i != 0 ? f.getString(i) : "", String.valueOf(z), null, null, null, null, z2, ChartTimeInterval.CANDLE_2m, null));
    }

    public final void a(int i, int i2, int[] iArr, boolean z) {
        h.e(iArr, "options");
        String[] strArr = new String[iArr.length];
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            strArr[i3] = f.getString(iArr[i3]);
        }
        a(i, i2, strArr, z);
    }

    public final void a(int i, int i2, String[] strArr, boolean z) {
        Object obj = strArr;
        h.e(obj, "options");
        this.ayV.add(new InputItem(Type.STRING_SELECTION, i != 0 ? f.getString(i) : "", String.valueOf(i2), null, null, null, obj, z, 56, null));
    }

    public final void c(int i, int i2, boolean z) {
        this.ayV.add(new InputItem(Type.ACTIVE, i != 0 ? f.getString(i) : "", String.valueOf(i2), null, null, null, null, z, ChartTimeInterval.CANDLE_2m, null));
    }

    public final void d(int i, int i2, boolean z) {
        this.ayV.add(new InputItem(Type.COLOR, i != 0 ? f.getString(i) : "", String.valueOf(i2), null, null, null, null, z, ChartTimeInterval.CANDLE_2m, null));
    }

    public static /* synthetic */ void b(d dVar, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        dVar.e(i, i2, z);
    }

    public final void e(int i, int i2, boolean z) {
        this.ayV.add(new InputItem(Type.LINE_WIDTH, i != 0 ? f.getString(i) : "", String.valueOf(i2), null, null, null, null, z, ChartTimeInterval.CANDLE_2m, null));
    }

    public static /* synthetic */ void c(d dVar, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        dVar.f(i, i2, z);
    }

    public final void f(int i, int i2, boolean z) {
        this.ayV.add(new InputItem(Type.HOST, i != 0 ? f.getString(i) : "", String.valueOf(i2), null, null, null, null, z, ChartTimeInterval.CANDLE_2m, null));
    }
}
