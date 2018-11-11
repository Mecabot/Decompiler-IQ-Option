package com.iqoption.core.microservices.livedeals.response.instrument;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010\"J\t\u00100\u001a\u00020\u0014HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u00122\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u0003HÖ\u0001J\t\u0010?\u001a\u00020\rHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\t\u001a\u00020\n8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\r8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0016X\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0011\u0010\"R\u0014\u0010$\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u000b\u001a\u00020\n8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001e¨\u0006@"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/response/instrument/LiveDealInstrument;", "Lcom/iqoption/core/microservices/livedeals/response/LiveDeal;", "activeId", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "positionId", "amount", "", "createdAt", "", "userId", "name", "", "countryId", "flag", "avatar", "isBig", "", "positionType", "Lcom/iqoption/core/microservices/livedeals/response/instrument/PositionType;", "(ILcom/iqoption/core/data/model/InstrumentType;Ljava/lang/Integer;DJJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/iqoption/core/microservices/livedeals/response/instrument/PositionType;)V", "getActiveId", "()I", "getAmount", "()D", "getAvatar", "()Ljava/lang/String;", "getCountryId", "getCreatedAt", "()J", "getFlag", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isCall", "()Z", "getName", "getPositionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPositionType", "()Lcom/iqoption/core/microservices/livedeals/response/instrument/PositionType;", "getUserId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILcom/iqoption/core/data/model/InstrumentType;Ljava/lang/Integer;DJJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/iqoption/core/microservices/livedeals/response/instrument/PositionType;)Lcom/iqoption/core/microservices/livedeals/response/instrument/LiveDealInstrument;", "equals", "other", "", "hashCode", "toString", "core_release"})
/* compiled from: LiveDealInstrument.kt */
public final class a implements com.iqoption.core.microservices.livedeals.response.a {
    @SerializedName("amount_enrolled")
    private final double aTA;
    @SerializedName("country_id")
    private final int aWA;
    @SerializedName("position_id")
    private final Integer aWL;
    @SerializedName("created_at")
    private final long aWN;
    @SerializedName("avatar")
    private final String aWO;
    @SerializedName("is_big")
    private final Boolean aWP;
    @SerializedName("position_type")
    private final PositionType aWR;
    @SerializedName("instrument_active_id")
    private final int activeId;
    @SerializedName("flag")
    private final String flag;
    @SerializedName("instrument_type")
    private final InstrumentType instrumentType;
    @SerializedName("name")
    private final String name;
    @SerializedName("user_id")
    private final long userId;

    public static /* synthetic */ a a(a aVar, int i, InstrumentType instrumentType, Integer num, double d, long j, long j2, String str, int i2, String str2, String str3, Boolean bool, PositionType positionType, int i3, Object obj) {
        a aVar2;
        PositionType positionType2;
        int i4 = i3;
        int activeId = (i4 & 1) != 0 ? aVar.getActiveId() : i;
        InstrumentType instrumentType2 = (i4 & 2) != 0 ? aVar.getInstrumentType() : instrumentType;
        Integer Wl = (i4 & 4) != 0 ? aVar.Wl() : num;
        double UO = (i4 & 8) != 0 ? aVar.UO() : d;
        long Wh = (i4 & 16) != 0 ? aVar.Wh() : j;
        long userId = (i4 & 32) != 0 ? aVar.getUserId() : j2;
        String name = (i4 & 64) != 0 ? aVar.getName() : str;
        int Wi = (i4 & 128) != 0 ? aVar.Wi() : i2;
        String flag = (i4 & 256) != 0 ? aVar.getFlag() : str2;
        String Wj = (i4 & 512) != 0 ? aVar.Wj() : str3;
        Boolean Wk = (i4 & 1024) != 0 ? aVar.Wk() : bool;
        if ((i4 & 2048) != 0) {
            aVar2 = aVar;
            positionType2 = aVar2.aWR;
        } else {
            aVar2 = aVar;
            positionType2 = positionType;
        }
        return aVar2.a(activeId, instrumentType2, Wl, UO, Wh, userId, name, Wi, flag, Wj, Wk, positionType2);
    }

    public final a a(int i, InstrumentType instrumentType, Integer num, double d, long j, long j2, String str, int i2, String str2, String str3, Boolean bool, PositionType positionType) {
        InstrumentType instrumentType2 = instrumentType;
        h.e(instrumentType2, "instrumentType");
        String str4 = str2;
        h.e(str4, "flag");
        h.e(positionType, "positionType");
        return new a(i, instrumentType2, num, d, j, j2, str, i2, str4, str3, bool, positionType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if ((getActiveId() == aVar.getActiveId() ? 1 : null) != null && h.E(getInstrumentType(), aVar.getInstrumentType()) && h.E(Wl(), aVar.Wl()) && Double.compare(UO(), aVar.UO()) == 0) {
                if ((Wh() == aVar.Wh() ? 1 : null) != null) {
                    if ((getUserId() == aVar.getUserId() ? 1 : null) != null && h.E(getName(), aVar.getName())) {
                        return (Wi() == aVar.Wi() ? 1 : null) != null && h.E(getFlag(), aVar.getFlag()) && h.E(Wj(), aVar.Wj()) && h.E(Wk(), aVar.Wk()) && h.E(this.aWR, aVar.aWR);
                    }
                }
            }
        }
    }

    public int hashCode() {
        int activeId = getActiveId() * 31;
        InstrumentType instrumentType = getInstrumentType();
        int i = 0;
        activeId = (activeId + (instrumentType != null ? instrumentType.hashCode() : 0)) * 31;
        Integer Wl = Wl();
        activeId = (activeId + (Wl != null ? Wl.hashCode() : 0)) * 31;
        long doubleToLongBits = Double.doubleToLongBits(UO());
        activeId = (activeId + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Wh();
        activeId = (activeId + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = getUserId();
        activeId = (activeId + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        String name = getName();
        activeId = (((activeId + (name != null ? name.hashCode() : 0)) * 31) + Wi()) * 31;
        name = getFlag();
        activeId = (activeId + (name != null ? name.hashCode() : 0)) * 31;
        name = Wj();
        activeId = (activeId + (name != null ? name.hashCode() : 0)) * 31;
        Boolean Wk = Wk();
        activeId = (activeId + (Wk != null ? Wk.hashCode() : 0)) * 31;
        PositionType positionType = this.aWR;
        if (positionType != null) {
            i = positionType.hashCode();
        }
        return activeId + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LiveDealInstrument(activeId=");
        stringBuilder.append(getActiveId());
        stringBuilder.append(", instrumentType=");
        stringBuilder.append(getInstrumentType());
        stringBuilder.append(", positionId=");
        stringBuilder.append(Wl());
        stringBuilder.append(", amount=");
        stringBuilder.append(UO());
        stringBuilder.append(", createdAt=");
        stringBuilder.append(Wh());
        stringBuilder.append(", userId=");
        stringBuilder.append(getUserId());
        stringBuilder.append(", name=");
        stringBuilder.append(getName());
        stringBuilder.append(", countryId=");
        stringBuilder.append(Wi());
        stringBuilder.append(", flag=");
        stringBuilder.append(getFlag());
        stringBuilder.append(", avatar=");
        stringBuilder.append(Wj());
        stringBuilder.append(", isBig=");
        stringBuilder.append(Wk());
        stringBuilder.append(", positionType=");
        stringBuilder.append(this.aWR);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(int i, InstrumentType instrumentType, Integer num, double d, long j, long j2, String str, int i2, String str2, String str3, Boolean bool, PositionType positionType) {
        InstrumentType instrumentType2 = instrumentType;
        String str4 = str2;
        PositionType positionType2 = positionType;
        h.e(instrumentType2, "instrumentType");
        h.e(str4, "flag");
        h.e(positionType2, "positionType");
        this.activeId = i;
        this.instrumentType = instrumentType2;
        this.aWL = num;
        this.aTA = d;
        this.aWN = j;
        this.userId = j2;
        this.name = str;
        this.aWA = i2;
        this.flag = str4;
        this.aWO = str3;
        this.aWP = bool;
        this.aWR = positionType2;
    }

    public int getActiveId() {
        return this.activeId;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public Integer Wl() {
        return this.aWL;
    }

    public double UO() {
        return this.aTA;
    }

    public long Wh() {
        return this.aWN;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public int Wi() {
        return this.aWA;
    }

    public String getFlag() {
        return this.flag;
    }

    public String Wj() {
        return this.aWO;
    }

    public Boolean Wk() {
        return this.aWP;
    }

    public boolean isCall() {
        return this.aWR == PositionType.LONG;
    }
}
