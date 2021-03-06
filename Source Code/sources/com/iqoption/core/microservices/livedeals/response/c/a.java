package com.iqoption.core.microservices.livedeals.response.c;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.livedeals.ExpirationType;
import com.iqoption.core.microservices.livedeals.response.DirectionType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\t\u0010=\u001a\u00020\rHÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u00152\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\t\u0010F\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\b8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\t\u001a\u00020\n8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0012\u001a\u00020\u00108\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0016X\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b\u0014\u0010*R\u0014\u0010,\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0016\u0010\u000e\u001a\u00020\n8\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001f¨\u0006G"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/response/fx/LiveDealFx;", "Lcom/iqoption/core/microservices/livedeals/response/LiveDeal;", "activeId", "", "positionId", "direction", "Lcom/iqoption/core/microservices/livedeals/response/DirectionType;", "amount", "", "createdAt", "", "expiration", "expirationType", "Lcom/iqoption/core/microservices/livedeals/ExpirationType;", "userId", "name", "", "countryId", "flag", "avatar", "isBig", "", "(ILjava/lang/Integer;Lcom/iqoption/core/microservices/livedeals/response/DirectionType;DJJLcom/iqoption/core/microservices/livedeals/ExpirationType;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getActiveId", "()I", "getAmount", "()D", "getAvatar", "()Ljava/lang/String;", "getCountryId", "getCreatedAt", "()J", "getDirection", "()Lcom/iqoption/core/microservices/livedeals/response/DirectionType;", "getExpiration", "getExpirationType", "()Lcom/iqoption/core/microservices/livedeals/ExpirationType;", "getFlag", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isCall", "()Z", "getName", "getPositionId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/Integer;Lcom/iqoption/core/microservices/livedeals/response/DirectionType;DJJLcom/iqoption/core/microservices/livedeals/ExpirationType;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/iqoption/core/microservices/livedeals/response/fx/LiveDealFx;", "equals", "other", "", "hashCode", "toString", "core_release"})
/* compiled from: LiveDealFx.kt */
public final class a implements com.iqoption.core.microservices.livedeals.response.a {
    @SerializedName("amount_enrolled")
    private final double aTA;
    @SerializedName("country_id")
    private final int aWA;
    @SerializedName("expiration_type")
    private final ExpirationType aWH;
    @SerializedName("position_id")
    private final Integer aWL;
    @SerializedName("instrument_dir")
    private final DirectionType aWM;
    @SerializedName("created_at")
    private final long aWN;
    @SerializedName("avatar")
    private final String aWO;
    @SerializedName("is_big")
    private final Boolean aWP;
    @SerializedName("instrument_active_id")
    private final int activeId;
    @SerializedName("expiration_time")
    private final long expiration;
    @SerializedName("flag")
    private final String flag;
    @SerializedName("name")
    private final String name;
    @SerializedName("user_id")
    private final long userId;

    public static /* synthetic */ a a(a aVar, int i, Integer num, DirectionType directionType, double d, long j, long j2, ExpirationType expirationType, long j3, String str, int i2, String str2, String str3, Boolean bool, int i3, Object obj) {
        a aVar2 = aVar;
        int i4 = i3;
        return aVar2.b((i4 & 1) != 0 ? aVar.getActiveId() : i, (i4 & 2) != 0 ? aVar.Wl() : num, (i4 & 4) != 0 ? aVar2.aWM : directionType, (i4 & 8) != 0 ? aVar.UO() : d, (i4 & 16) != 0 ? aVar.Wh() : j, (i4 & 32) != 0 ? aVar2.expiration : j2, (i4 & 64) != 0 ? aVar2.aWH : expirationType, (i4 & 128) != 0 ? aVar.getUserId() : j3, (i4 & 256) != 0 ? aVar.getName() : str, (i4 & 512) != 0 ? aVar.Wi() : i2, (i4 & 1024) != 0 ? aVar.getFlag() : str2, (i4 & 2048) != 0 ? aVar.Wj() : str3, (i4 & 4096) != 0 ? aVar.Wk() : bool);
    }

    public final a b(int i, Integer num, DirectionType directionType, double d, long j, long j2, ExpirationType expirationType, long j3, String str, int i2, String str2, String str3, Boolean bool) {
        DirectionType directionType2 = directionType;
        h.e(directionType2, "direction");
        ExpirationType expirationType2 = expirationType;
        h.e(expirationType2, "expirationType");
        h.e(str2, "flag");
        return new a(i, num, directionType2, d, j, j2, expirationType2, j3, str, i2, str2, str3, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if ((getActiveId() == aVar.getActiveId() ? 1 : null) != null && h.E(Wl(), aVar.Wl()) && h.E(this.aWM, aVar.aWM) && Double.compare(UO(), aVar.UO()) == 0) {
                if ((Wh() == aVar.Wh() ? 1 : null) != null) {
                    if ((this.expiration == aVar.expiration ? 1 : null) != null && h.E(this.aWH, aVar.aWH)) {
                        if ((getUserId() == aVar.getUserId() ? 1 : null) != null && h.E(getName(), aVar.getName())) {
                            return (Wi() == aVar.Wi() ? 1 : null) != null && h.E(getFlag(), aVar.getFlag()) && h.E(Wj(), aVar.Wj()) && h.E(Wk(), aVar.Wk());
                        }
                    }
                }
            }
        }
    }

    public int hashCode() {
        int activeId = getActiveId() * 31;
        Integer Wl = Wl();
        int i = 0;
        activeId = (activeId + (Wl != null ? Wl.hashCode() : 0)) * 31;
        DirectionType directionType = this.aWM;
        activeId = (activeId + (directionType != null ? directionType.hashCode() : 0)) * 31;
        long doubleToLongBits = Double.doubleToLongBits(UO());
        activeId = (activeId + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Wh();
        activeId = (activeId + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = this.expiration;
        activeId = (activeId + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        ExpirationType expirationType = this.aWH;
        activeId = (activeId + (expirationType != null ? expirationType.hashCode() : 0)) * 31;
        doubleToLongBits = getUserId();
        activeId = (activeId + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        String name = getName();
        activeId = (((activeId + (name != null ? name.hashCode() : 0)) * 31) + Wi()) * 31;
        name = getFlag();
        activeId = (activeId + (name != null ? name.hashCode() : 0)) * 31;
        name = Wj();
        activeId = (activeId + (name != null ? name.hashCode() : 0)) * 31;
        Boolean Wk = Wk();
        if (Wk != null) {
            i = Wk.hashCode();
        }
        return activeId + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LiveDealFx(activeId=");
        stringBuilder.append(getActiveId());
        stringBuilder.append(", positionId=");
        stringBuilder.append(Wl());
        stringBuilder.append(", direction=");
        stringBuilder.append(this.aWM);
        stringBuilder.append(", amount=");
        stringBuilder.append(UO());
        stringBuilder.append(", createdAt=");
        stringBuilder.append(Wh());
        stringBuilder.append(", expiration=");
        stringBuilder.append(this.expiration);
        stringBuilder.append(", expirationType=");
        stringBuilder.append(this.aWH);
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
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(int i, Integer num, DirectionType directionType, double d, long j, long j2, ExpirationType expirationType, long j3, String str, int i2, String str2, String str3, Boolean bool) {
        DirectionType directionType2 = directionType;
        ExpirationType expirationType2 = expirationType;
        String str4 = str2;
        h.e(directionType2, "direction");
        h.e(expirationType2, "expirationType");
        h.e(str4, "flag");
        this.activeId = i;
        this.aWL = num;
        this.aWM = directionType2;
        this.aTA = d;
        this.aWN = j;
        this.expiration = j2;
        this.aWH = expirationType2;
        this.userId = j3;
        this.name = str;
        this.aWA = i2;
        this.flag = str4;
        this.aWO = str3;
        this.aWP = bool;
    }

    public int getActiveId() {
        return this.activeId;
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

    public InstrumentType getInstrumentType() {
        return InstrumentType.DIGITAL_INSTRUMENT;
    }

    public boolean isCall() {
        return this.aWM == DirectionType.CALL;
    }
}
