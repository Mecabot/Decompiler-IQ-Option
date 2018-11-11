package com.iqoption.signals;

import android.support.annotation.IntRange;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\nHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u0006,"}, aXE = {"Lcom/iqoption/signals/SignalItem;", "Lcom/iqoption/signals/AdapterItem;", "isBull", "", "time", "", "activeName", "type", "value", "level", "", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "signal", "Lcom/iqoption/core/microservices/pricemovements/response/Signal;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/iqoption/core/microservices/tradingengine/response/active/Active;Lcom/iqoption/core/microservices/pricemovements/response/Signal;)V", "getActive", "()Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "getActiveName", "()Ljava/lang/String;", "id", "getId", "()Z", "getLevel", "()I", "getSignal", "()Lcom/iqoption/core/microservices/pricemovements/response/Signal;", "getTime", "getType", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: _AdapterItems.kt */
public final class c extends a {
    private final String aXE;
    private final String activeName;
    private final a aiJ;
    private final boolean drc;
    private final com.iqoption.core.microservices.pricemovements.a.a drd;
    private final String id;
    private final int level;
    private final String type;
    private final String value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if ((this.drc == cVar.drc ? 1 : null) != null && h.E(this.aXE, cVar.aXE) && h.E(this.activeName, cVar.activeName) && h.E(this.type, cVar.type) && h.E(this.value, cVar.value)) {
                return (this.level == cVar.level ? 1 : null) != null && h.E(this.aiJ, cVar.aiJ) && h.E(this.drd, cVar.drd);
            }
        }
    }

    public int hashCode() {
        int i = this.drc;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        String str = this.aXE;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.activeName;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.type;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.value;
        i = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.level) * 31;
        a aVar = this.aiJ;
        i = (i + (aVar != null ? aVar.hashCode() : 0)) * 31;
        com.iqoption.core.microservices.pricemovements.a.a aVar2 = this.drd;
        if (aVar2 != null) {
            i2 = aVar2.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignalItem(isBull=");
        stringBuilder.append(this.drc);
        stringBuilder.append(", time=");
        stringBuilder.append(this.aXE);
        stringBuilder.append(", activeName=");
        stringBuilder.append(this.activeName);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", level=");
        stringBuilder.append(this.level);
        stringBuilder.append(", active=");
        stringBuilder.append(this.aiJ);
        stringBuilder.append(", signal=");
        stringBuilder.append(this.drd);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final boolean aDZ() {
        return this.drc;
    }

    public final String getTime() {
        return this.aXE;
    }

    public final String getActiveName() {
        return this.activeName;
    }

    public final String getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final int getLevel() {
        return this.level;
    }

    public final a Jg() {
        return this.aiJ;
    }

    public final com.iqoption.core.microservices.pricemovements.a.a aEa() {
        return this.drd;
    }

    public c(boolean z, String str, String str2, String str3, String str4, @IntRange(from = 1, to = 2) int i, a aVar, com.iqoption.core.microservices.pricemovements.a.a aVar2) {
        h.e(str, "time");
        h.e(str2, "activeName");
        h.e(str3, Param.TYPE);
        h.e(str4, b.VALUE);
        h.e(aVar, "active");
        h.e(aVar2, "signal");
        super();
        this.drc = z;
        this.aXE = str;
        this.activeName = str2;
        this.type = str3;
        this.value = str4;
        this.level = i;
        this.aiJ = aVar;
        this.drd = aVar2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("signal:");
        stringBuilder.append(this.drd.getId());
        this.id = stringBuilder.toString();
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }
}
