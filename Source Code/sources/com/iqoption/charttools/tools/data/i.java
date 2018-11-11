package com.iqoption.charttools.tools.data;

import com.iqoption.charttools.model.indicator.x;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, aXE = {"Lcom/iqoption/charttools/tools/data/InfoIndicatorItem;", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "meta", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "info", "", "videoUrl", "(Lcom/iqoption/charttools/model/indicator/MetaIndicator;Ljava/lang/String;Ljava/lang/String;)V", "id", "getId", "()Ljava/lang/String;", "getInfo", "getMeta", "()Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "getVideoUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: IndicatorAdapterItems.kt */
public final class i extends h {
    private final String aBS;
    private final x atH;
    private final String id;
    private final String info;

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.aBS, r3.aBS) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.charttools.tools.data.i;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.charttools.tools.data.i) r3;
        r0 = r2.atH;
        r1 = r3.atH;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.info;
        r1 = r3.info;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.aBS;
        r3 = r3.aBS;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r3 = 0;
        return r3;
    L_0x0029:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.tools.data.i.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        x xVar = this.atH;
        int i = 0;
        int hashCode = (xVar != null ? xVar.hashCode() : 0) * 31;
        String str = this.info;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aBS;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InfoIndicatorItem(meta=");
        stringBuilder.append(this.atH);
        stringBuilder.append(", info=");
        stringBuilder.append(this.info);
        stringBuilder.append(", videoUrl=");
        stringBuilder.append(this.aBS);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final x KJ() {
        return this.atH;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String Mk() {
        return this.aBS;
    }

    public i(x xVar, String str, String str2) {
        h.e(xVar, "meta");
        h.e(str, "info");
        super();
        this.atH = xVar;
        this.info = str;
        this.aBS = str2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("info:");
        stringBuilder.append(this.atH.Ml());
        this.id = stringBuilder.toString();
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }
}
