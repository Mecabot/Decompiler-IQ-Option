package com.iqoption.microservice.chat;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002Bw\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u0011¢\u0006\u0002\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u001b\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u0011HÆ\u0003J{\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u001a\b\u0002\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u0011HÆ\u0001J\u0013\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\tHÖ\u0001R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0019R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u0006,"}, aXE = {"Lcom/iqoption/microservice/chat/ChatState;", "", "()V", "isModerator", "", "isBanned", "isBannedDialog", "isRegulated", "currency", "", "tradingVolume", "", "tradingVolumeNeed", "banDuration", "", "", "banReason", "", "(ZZZZLjava/lang/String;DDLjava/util/List;Ljava/util/Map;)V", "getBanDuration", "()Ljava/util/List;", "getBanReason", "()Ljava/util/Map;", "getCurrency", "()Ljava/lang/String;", "()Z", "getTradingVolume", "()D", "getTradingVolumeNeed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Responses.kt */
public final class o {
    @SerializedName("is_banned")
    private final boolean aFz;
    @SerializedName("is_regulated")
    private final boolean aMv;
    @SerializedName("is_moderator")
    private final boolean cQt;
    @SerializedName("is_banned_dialog")
    private final boolean cQu;
    @SerializedName("tradingvolume")
    private final double cQv;
    @SerializedName("tradingvolume_need")
    private final double cQw;
    @SerializedName("ban_duration")
    private final List<Long> cQx;
    @SerializedName("ban_reason")
    private final Map<String, List<String>> cQy;
    @SerializedName("currency")
    private final String currency;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if ((this.cQt == oVar.cQt ? 1 : null) != null) {
                if ((this.aFz == oVar.aFz ? 1 : null) != null) {
                    if ((this.cQu == oVar.cQu ? 1 : null) != null) {
                        return (this.aMv == oVar.aMv ? 1 : null) != null && h.E(this.currency, oVar.currency) && Double.compare(this.cQv, oVar.cQv) == 0 && Double.compare(this.cQw, oVar.cQw) == 0 && h.E(this.cQx, oVar.cQx) && h.E(this.cQy, oVar.cQy);
                    }
                }
            }
        }
    }

    public int hashCode() {
        int i = this.cQt;
        int i2 = 1;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        int i3 = this.aFz;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.cQu;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        boolean z = this.aMv;
        if (!z) {
            i2 = z;
        }
        i = (i + i2) * 31;
        String str = this.currency;
        i3 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.cQv);
        i = (i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Double.doubleToLongBits(this.cQw);
        i = (i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        List list = this.cQx;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        Map map = this.cQy;
        if (map != null) {
            i3 = map.hashCode();
        }
        return i + i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatState(isModerator=");
        stringBuilder.append(this.cQt);
        stringBuilder.append(", isBanned=");
        stringBuilder.append(this.aFz);
        stringBuilder.append(", isBannedDialog=");
        stringBuilder.append(this.cQu);
        stringBuilder.append(", isRegulated=");
        stringBuilder.append(this.aMv);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.currency);
        stringBuilder.append(", tradingVolume=");
        stringBuilder.append(this.cQv);
        stringBuilder.append(", tradingVolumeNeed=");
        stringBuilder.append(this.cQw);
        stringBuilder.append(", banDuration=");
        stringBuilder.append(this.cQx);
        stringBuilder.append(", banReason=");
        stringBuilder.append(this.cQy);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public o(boolean z, boolean z2, boolean z3, boolean z4, String str, double d, double d2, List<Long> list, Map<String, ? extends List<String>> map) {
        h.e(str, b.CURRENCY);
        h.e(list, "banDuration");
        h.e(map, "banReason");
        this.cQt = z;
        this.aFz = z2;
        this.cQu = z3;
        this.aMv = z4;
        this.currency = str;
        this.cQv = d;
        this.cQw = d2;
        this.cQx = list;
        this.cQy = map;
    }

    public final boolean arO() {
        return this.aFz;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final double arP() {
        return this.cQv;
    }

    public final double arQ() {
        return this.cQw;
    }

    public /* synthetic */ o(boolean z, boolean z2, boolean z3, boolean z4, String str, double d, double d2, List list, Map map, int i, f fVar) {
        int i2 = i;
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? false : z4, (i2 & 16) != 0 ? "" : str, (i2 & 32) != 0 ? 0.0d : d, (i2 & 64) != 0 ? 0.0d : d2, (i2 & 128) != 0 ? m.emptyList() : list, (i2 & 256) != 0 ? ad.emptyMap() : map);
    }

    public o() {
        this(false, false, false, false, null, 0.0d, 0.0d, null, null, 510, null);
    }
}
