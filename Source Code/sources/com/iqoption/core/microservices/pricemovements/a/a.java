package com.iqoption.core.microservices.pricemovements.a;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b$\b\b\u0018\u0000 52\u00020\u0001:\u00015By\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\u0012HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J}\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00101\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010 R\u0016\u0010\u0010\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015¨\u00066"}, aXE = {"Lcom/iqoption/core/microservices/pricemovements/response/Signal;", "", "id", "", "activeId", "", "type", "instruments", "", "", "startTime", "finishTime", "startValue", "", "finishValue", "created", "percent", "isHigh", "", "(JIILjava/util/List;JJDDJDZ)V", "getActiveId", "()I", "createTime", "getCreateTime", "()J", "getCreated", "getFinishTime", "getFinishValue", "()D", "getId", "getInstruments", "()Ljava/util/List;", "()Z", "getPercent", "getStartTime", "getStartValue", "getType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "core_release"})
/* compiled from: Signal.kt */
public final class a {
    public static final a aXl = new a();
    @SerializedName("start_value")
    private final double aXi;
    @SerializedName("finish_value")
    private final double aXj;
    @SerializedName("high")
    private final boolean aXk;
    @SerializedName("underline_asset_id")
    private final int activeId;
    @SerializedName("finish_time")
    private final long ahD;
    @SerializedName("percent")
    private final double amY;
    @SerializedName("instruments")
    private final List<String> azz;
    @SerializedName("created")
    private final long created;
    @SerializedName("id")
    private final long id;
    @SerializedName("start_time")
    private final long startTime;
    @SerializedName("type")
    private final int type;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/core/microservices/pricemovements/response/Signal$Companion;", "", "()V", "TYPE_GAP", "", "TYPE_SHARP_JUMP", "core_release"})
    /* compiled from: Signal.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public a() {
        this(0, 0, 0, null, 0, 0, 0.0d, 0.0d, 0, 0.0d, false, 2047, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if ((this.id == aVar.id ? 1 : null) != null) {
                if ((this.activeId == aVar.activeId ? 1 : null) != null) {
                    if ((this.type == aVar.type ? 1 : null) != null && h.E(this.azz, aVar.azz)) {
                        if ((this.startTime == aVar.startTime ? 1 : null) != null) {
                            if ((this.ahD == aVar.ahD ? 1 : null) != null && Double.compare(this.aXi, aVar.aXi) == 0 && Double.compare(this.aXj, aVar.aXj) == 0) {
                                if ((this.created == aVar.created ? 1 : null) != null && Double.compare(this.amY, aVar.amY) == 0) {
                                    if ((this.aXk == aVar.aXk ? 1 : null) != null) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + this.activeId) * 31) + this.type) * 31;
        List list = this.azz;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        long j2 = this.startTime;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        j2 = this.ahD;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        j2 = Double.doubleToLongBits(this.aXi);
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        j2 = Double.doubleToLongBits(this.aXj);
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        j2 = this.created;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        j2 = Double.doubleToLongBits(this.amY);
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        int i2 = this.aXk;
        if (i2 != 0) {
            i2 = 1;
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Signal(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", instruments=");
        stringBuilder.append(this.azz);
        stringBuilder.append(", startTime=");
        stringBuilder.append(this.startTime);
        stringBuilder.append(", finishTime=");
        stringBuilder.append(this.ahD);
        stringBuilder.append(", startValue=");
        stringBuilder.append(this.aXi);
        stringBuilder.append(", finishValue=");
        stringBuilder.append(this.aXj);
        stringBuilder.append(", created=");
        stringBuilder.append(this.created);
        stringBuilder.append(", percent=");
        stringBuilder.append(this.amY);
        stringBuilder.append(", isHigh=");
        stringBuilder.append(this.aXk);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(long j, int i, int i2, List<String> list, long j2, long j3, double d, double d2, long j4, double d3, boolean z) {
        List<String> list2 = list;
        h.e(list2, "instruments");
        this.id = j;
        this.activeId = i;
        this.type = i2;
        this.azz = list2;
        this.startTime = j2;
        this.ahD = j3;
        this.aXi = d;
        this.aXj = d2;
        this.created = j4;
        this.amY = d3;
        this.aXk = z;
    }

    public final long getId() {
        return this.id;
    }

    public final int getActiveId() {
        return this.activeId;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ a(long j, int i, int i2, List list, long j2, long j3, double d, double d2, long j4, double d3, boolean z, int i3, f fVar) {
        int i4 = i3;
        this((i4 & 1) != 0 ? -1 : j, (i4 & 2) != 0 ? -1 : i, (i4 & 4) != 0 ? 1 : i2, (i4 & 8) != 0 ? m.emptyList() : list, (i4 & 16) != 0 ? 0 : j2, (i4 & 32) != 0 ? 0 : j3, (i4 & 64) != 0 ? 0.0d : d, (i4 & 128) != 0 ? 0.0d : d2, (i4 & 256) != 0 ? 0 : j4, (i4 & 512) != 0 ? 0.0d : d3, (i4 & 1024) != 0 ? false : z);
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long Wv() {
        return this.ahD;
    }

    public final double Ww() {
        return this.aXi;
    }

    public final double Wx() {
        return this.aXj;
    }

    public final long Vs() {
        return this.created;
    }

    public final double Wy() {
        return this.amY;
    }

    public final boolean Wz() {
        return this.aXk;
    }

    public final long getCreateTime() {
        return this.created * ((long) 1000);
    }
}
