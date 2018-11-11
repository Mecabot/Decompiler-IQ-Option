package com.iqoption.charttools.tools.data;

import com.google.android.gms.plus.PlusShare;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.core.data.model.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006&"}, aXE = {"Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "meta", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "title", "", "icon", "Lcom/iqoption/core/data/model/UrlOrRes;", "info", "isExpanded", "", "isFavorite", "isAvailable", "(Lcom/iqoption/charttools/model/indicator/MetaIndicator;Ljava/lang/String;Lcom/iqoption/core/data/model/UrlOrRes;Ljava/lang/String;ZZZ)V", "getIcon", "()Lcom/iqoption/core/data/model/UrlOrRes;", "id", "getId", "()Ljava/lang/String;", "getInfo", "()Z", "getMeta", "()Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: IndicatorAdapterItems.kt */
public final class m extends h {
    private final c aBW;
    private final boolean aBX;
    private final boolean apU;
    private final x atH;
    private final String id;
    private final String info;
    private final boolean isExpanded;
    private final String title;

    public static /* bridge */ /* synthetic */ m a(m mVar, x xVar, String str, c cVar, String str2, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            xVar = mVar.atH;
        }
        if ((i & 2) != 0) {
            str = mVar.title;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            cVar = mVar.aBW;
        }
        c cVar2 = cVar;
        if ((i & 8) != 0) {
            str2 = mVar.info;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            z = mVar.isExpanded;
        }
        boolean z4 = z;
        if ((i & 32) != 0) {
            z2 = mVar.apU;
        }
        boolean z5 = z2;
        if ((i & 64) != 0) {
            z3 = mVar.aBX;
        }
        return mVar.a(xVar, str3, cVar2, str4, z4, z5, z3);
    }

    public final m a(x xVar, String str, c cVar, String str2, boolean z, boolean z2, boolean z3) {
        x xVar2 = xVar;
        h.e(xVar2, "meta");
        String str3 = str;
        h.e(str3, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        c cVar2 = cVar;
        h.e(cVar2, "icon");
        return new m(xVar2, str3, cVar2, str2, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (h.E(this.atH, mVar.atH) && h.E(this.title, mVar.title) && h.E(this.aBW, mVar.aBW) && h.E(this.info, mVar.info)) {
                if ((this.isExpanded == mVar.isExpanded ? 1 : null) != null) {
                    if ((this.apU == mVar.apU ? 1 : null) != null) {
                        if ((this.aBX == mVar.aBX ? 1 : null) != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        x xVar = this.atH;
        int i = 0;
        int hashCode = (xVar != null ? xVar.hashCode() : 0) * 31;
        String str = this.title;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        c cVar = this.aBW;
        hashCode = (hashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
        str = this.info;
        if (str != null) {
            i = str.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.isExpanded;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.apU;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.aBX;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TitleIndicatorItem(meta=");
        stringBuilder.append(this.atH);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", icon=");
        stringBuilder.append(this.aBW);
        stringBuilder.append(", info=");
        stringBuilder.append(this.info);
        stringBuilder.append(", isExpanded=");
        stringBuilder.append(this.isExpanded);
        stringBuilder.append(", isFavorite=");
        stringBuilder.append(this.apU);
        stringBuilder.append(", isAvailable=");
        stringBuilder.append(this.aBX);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final x KJ() {
        return this.atH;
    }

    public final String getTitle() {
        return this.title;
    }

    public final c Mj() {
        return this.aBW;
    }

    public final String getInfo() {
        return this.info;
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final boolean Ok() {
        return this.apU;
    }

    public final boolean isAvailable() {
        return this.aBX;
    }

    public m(x xVar, String str, c cVar, String str2, boolean z, boolean z2, boolean z3) {
        h.e(xVar, "meta");
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        h.e(cVar, "icon");
        super();
        this.atH = xVar;
        this.title = str;
        this.aBW = cVar;
        this.info = str2;
        this.isExpanded = z;
        this.apU = z2;
        this.aBX = z3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("item:");
        stringBuilder.append(this.atH.Ml());
        this.id = stringBuilder.toString();
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }
}
