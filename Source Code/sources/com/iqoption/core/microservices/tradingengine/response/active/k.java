package com.iqoption.core.microservices.tradingengine.response.active;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 [2\u00020\u0001:\u0003[\\]B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0017J\t\u00100\u001a\u00020\u0003HÄ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\u0013HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0015HÄ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010.J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0005HÄ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J¢\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010>J\t\u0010?\u001a\u00020\u0005HÖ\u0001J\u0013\u0010@\u001a\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\b\u0010C\u001a\u00020\u0005H\u0016J\r\u0010D\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001bJ\r\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u0015H\u0016J\b\u0010G\u001a\u00020\u0005H\u0016J\b\u0010H\u001a\u00020\u0015H\u0016J\b\u0010I\u001a\u00020\u0003H\u0016J\t\u0010J\u001a\u00020\u0005HÖ\u0001J\b\u0010K\u001a\u00020\bH\u0016J\u0010\u0010L\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u0015H\u0016J\b\u0010M\u001a\u00020\bH\u0016J\b\u0010N\u001a\u00020\bH\u0016J\u000e\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010R\u001a\u00020P2\u0006\u0010S\u001a\u00020\u0010J\t\u0010T\u001a\u00020\u0003HÖ\u0001J\u0010\u0010U\u001a\u00020P2\u0006\u0010V\u001a\u00020\u0001H\u0016J\u0019\u0010W\u001a\u00020P2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00058\u0004X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0004X\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0016\u0010\u0006\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u0016\u0010\u001bR\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.¨\u0006^"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive;", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "_name", "", "groupId", "", "image", "topTradersEnabled", "", "id", "_precision", "option", "Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option;", "deadTime", "schedule", "Ljava/util/ArrayList;", "", "enabled", "minmax", "Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$MinMax;", "_startTime", "", "isBuyback", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;ILjava/lang/Integer;Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option;ILjava/util/ArrayList;ZLcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$MinMax;Ljava/lang/Long;Ljava/lang/Integer;)V", "get_name", "()Ljava/lang/String;", "get_precision", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "get_startTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDeadTime", "()I", "getEnabled", "()Z", "getGroupId", "getId", "getImage", "getMinmax", "()Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$MinMax;", "getOption", "()Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option;", "getSchedule", "()Ljava/util/ArrayList;", "getTopTradersEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;ILjava/lang/Integer;Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option;ILjava/util/ArrayList;ZLcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$MinMax;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive;", "describeContents", "equals", "other", "", "getActiveId", "getCommission", "getNextSchedule", "timeSync", "getPrecision", "getStartTime", "getTicker", "hashCode", "isBuybackEnabled", "isEnabled", "isExpired", "isTopTradersEnabled", "setCommission", "", "commission", "setSchedule", "scheduleObj", "toString", "update", "value", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "MinMax", "Option", "core_release"})
/* compiled from: TurboBinaryActive.kt */
public final class k extends a {
    public static final Creator CREATOR = new b();
    public static final a aYX = new a();
    @SerializedName("name")
    private final String _name;
    @SerializedName("top_traders_enabled")
    private final Boolean aYP;
    @SerializedName("precision")
    private final Integer aYQ;
    @SerializedName("option")
    private final d aYR;
    @SerializedName("deadtime")
    private final int aYS;
    @SerializedName("schedule")
    private final ArrayList<int[]> aYT;
    @SerializedName("minmax")
    private final c aYU;
    @SerializedName("start_time")
    private final Long aYV;
    @SerializedName("is_buyback")
    private final Integer aYW;
    @SerializedName("enabled")
    private final boolean enabled;
    @SerializedName("group_id")
    private final int groupId;
    @SerializedName("id")
    private final int id;
    @SerializedName("image")
    private final String image;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Companion;", "", "()V", "DEFAULT_PRECISION", "", "core_release"})
    /* compiled from: TurboBinaryActive.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean valueOf;
            ArrayList arrayList;
            Parcel parcel2 = parcel;
            h.e(parcel2, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                valueOf = null;
            }
            int readInt2 = parcel.readInt();
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            d dVar = parcel.readInt() != 0 ? (d) d.CREATOR.createFromParcel(parcel2) : null;
            int readInt3 = parcel.readInt();
            if (parcel.readInt() != 0) {
                int readInt4 = parcel.readInt();
                arrayList = new ArrayList(readInt4);
                while (readInt4 != 0) {
                    arrayList.add(parcel.createIntArray());
                    readInt4--;
                }
            } else {
                arrayList = null;
            }
            return new k(readString, readInt, readString2, valueOf, readInt2, valueOf2, dVar, readInt3, arrayList, parcel.readInt() != 0, (c) c.CREATOR.createFromParcel(parcel2), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        public final Object[] newArray(int i) {
            return new k[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u001c"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$MinMax;", "Landroid/os/Parcelable;", "min", "", "max", "(II)V", "getMax", "()I", "setMax", "(I)V", "getMin", "setMin", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
    /* compiled from: TurboBinaryActive.kt */
    public static final class c implements Parcelable {
        public static final Creator CREATOR = new a();
        @SerializedName("max")
        private int max;
        @SerializedName("min")
        private int min;

        @i(aXC = {1, 1, 11})
        public static class a implements Creator {
            public final Object createFromParcel(Parcel parcel) {
                h.e(parcel, "in");
                return new c(parcel.readInt(), parcel.readInt());
            }

            public final Object[] newArray(int i) {
                return new c[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if ((this.min == cVar.min ? 1 : null) != null) {
                    if ((this.max == cVar.max ? 1 : null) != null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MinMax(min=");
            stringBuilder.append(this.min);
            stringBuilder.append(", max=");
            stringBuilder.append(this.max);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            h.e(parcel, "parcel");
            parcel.writeInt(this.min);
            parcel.writeInt(this.max);
        }

        public c(int i, int i2) {
            this.min = i;
            this.max = i2;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u00029:BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003Jb\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010+J\t\u0010,\u001a\u00020\tHÖ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\tHÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\tHÖ\u0001R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u0006;"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option;", "Landroid/os/Parcelable;", "profit", "Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option$Profit;", "expTime", "", "startTime", "startExpTime", "count", "", "specials", "", "Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option$Special;", "(Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option$Profit;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/Map;)V", "getCount", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExpTime", "()Ljava/lang/Long;", "setExpTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getProfit", "()Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option$Profit;", "setProfit", "(Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option$Profit;)V", "getSpecials", "()Ljava/util/Map;", "setSpecials", "(Ljava/util/Map;)V", "getStartExpTime", "setStartExpTime", "getStartTime", "setStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option$Profit;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/Map;)Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Profit", "Special", "core_release"})
    /* compiled from: TurboBinaryActive.kt */
    public static final class d implements Parcelable {
        public static final Creator CREATOR = new a();
        @SerializedName("profit")
        private b aYY;
        @SerializedName("start_time")
        private Long aYZ;
        private Long aZa;
        @SerializedName("special")
        private Map<Long, c> aZb;
        @SerializedName("count")
        private Integer count;
        @SerializedName("exp_time")
        private Long expTime;

        @i(aXC = {1, 1, 11})
        public static class a implements Creator {
            public final Object createFromParcel(Parcel parcel) {
                h.e(parcel, "in");
                Map map = null;
                b bVar = parcel.readInt() != 0 ? (b) b.CREATOR.createFromParcel(parcel) : null;
                Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
                Long valueOf2 = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
                Long valueOf3 = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
                Integer valueOf4 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    map = new LinkedHashMap(readInt);
                    while (readInt != 0) {
                        map.put(Long.valueOf(parcel.readLong()), (c) c.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                }
                return new d(bVar, valueOf, valueOf2, valueOf3, valueOf4, map);
            }

            public final Object[] newArray(int i) {
                return new d[i];
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\tR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t¨\u0006#"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option$Profit;", "Landroid/os/Parcelable;", "commissionDefault", "", "commission", "refundMin", "refundMax", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCommission", "()Ljava/lang/Integer;", "setCommission", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCommissionDefault", "getRefundMax", "getRefundMin", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option$Profit;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
        /* compiled from: TurboBinaryActive.kt */
        public static final class b implements Parcelable {
            public static final Creator CREATOR = new a();
            @SerializedName("commission_default")
            private final Integer aZc;
            @SerializedName("commission")
            private Integer aZd;
            @SerializedName("refund_min")
            private final Integer aZe;
            @SerializedName("refund_max")
            private final Integer aZf;

            @i(aXC = {1, 1, 11})
            public static class a implements Creator {
                public final Object createFromParcel(Parcel parcel) {
                    h.e(parcel, "in");
                    Integer num = null;
                    Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
                    Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
                    Integer valueOf3 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
                    if (parcel.readInt() != 0) {
                        num = Integer.valueOf(parcel.readInt());
                    }
                    return new b(valueOf, valueOf2, valueOf3, num);
                }

                public final Object[] newArray(int i) {
                    return new b[i];
                }
            }

            public b() {
                this(null, null, null, null, 15, null);
            }

            public int describeContents() {
                return 0;
            }

            /* JADX WARNING: Missing block: B:10:0x002e, code:
            if (kotlin.jvm.internal.h.E(r2.aZf, r3.aZf) != false) goto L_0x0033;
     */
            public boolean equals(java.lang.Object r3) {
                /*
                r2 = this;
                if (r2 == r3) goto L_0x0033;
            L_0x0002:
                r0 = r3 instanceof com.iqoption.core.microservices.tradingengine.response.active.k.d.b;
                if (r0 == 0) goto L_0x0031;
            L_0x0006:
                r3 = (com.iqoption.core.microservices.tradingengine.response.active.k.d.b) r3;
                r0 = r2.aZc;
                r1 = r3.aZc;
                r0 = kotlin.jvm.internal.h.E(r0, r1);
                if (r0 == 0) goto L_0x0031;
            L_0x0012:
                r0 = r2.aZd;
                r1 = r3.aZd;
                r0 = kotlin.jvm.internal.h.E(r0, r1);
                if (r0 == 0) goto L_0x0031;
            L_0x001c:
                r0 = r2.aZe;
                r1 = r3.aZe;
                r0 = kotlin.jvm.internal.h.E(r0, r1);
                if (r0 == 0) goto L_0x0031;
            L_0x0026:
                r0 = r2.aZf;
                r3 = r3.aZf;
                r3 = kotlin.jvm.internal.h.E(r0, r3);
                if (r3 == 0) goto L_0x0031;
            L_0x0030:
                goto L_0x0033;
            L_0x0031:
                r3 = 0;
                return r3;
            L_0x0033:
                r3 = 1;
                return r3;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.tradingengine.response.active.k.d.b.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                Integer num = this.aZc;
                int i = 0;
                int hashCode = (num != null ? num.hashCode() : 0) * 31;
                Integer num2 = this.aZd;
                hashCode = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
                num2 = this.aZe;
                hashCode = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
                num2 = this.aZf;
                if (num2 != null) {
                    i = num2.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Profit(commissionDefault=");
                stringBuilder.append(this.aZc);
                stringBuilder.append(", commission=");
                stringBuilder.append(this.aZd);
                stringBuilder.append(", refundMin=");
                stringBuilder.append(this.aZe);
                stringBuilder.append(", refundMax=");
                stringBuilder.append(this.aZf);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public void writeToParcel(Parcel parcel, int i) {
                h.e(parcel, "parcel");
                Integer num = this.aZc;
                if (num != null) {
                    parcel.writeInt(1);
                    parcel.writeInt(num.intValue());
                } else {
                    parcel.writeInt(0);
                }
                num = this.aZd;
                if (num != null) {
                    parcel.writeInt(1);
                    parcel.writeInt(num.intValue());
                } else {
                    parcel.writeInt(0);
                }
                num = this.aZe;
                if (num != null) {
                    parcel.writeInt(1);
                    parcel.writeInt(num.intValue());
                } else {
                    parcel.writeInt(0);
                }
                num = this.aZf;
                if (num != null) {
                    parcel.writeInt(1);
                    parcel.writeInt(num.intValue());
                    return;
                }
                parcel.writeInt(0);
            }

            public b(Integer num, Integer num2, Integer num3, Integer num4) {
                this.aZc = num;
                this.aZd = num2;
                this.aZe = num3;
                this.aZf = num4;
            }

            public /* synthetic */ b(Integer num, Integer num2, Integer num3, Integer num4, int i, f fVar) {
                if ((i & 1) != 0) {
                    num = (Integer) null;
                }
                if ((i & 2) != 0) {
                    num2 = (Integer) null;
                }
                if ((i & 4) != 0) {
                    num3 = (Integer) null;
                }
                if ((i & 8) != 0) {
                    num4 = (Integer) null;
                }
                this(num, num2, num3, num4);
            }

            public final Integer Xi() {
                return this.aZd;
            }

            public final void d(Integer num) {
                this.aZd = num;
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/TurboBinaryActive$Option$Special;", "Landroid/os/Parcelable;", "enabled", "", "title", "", "(ZLjava/lang/String;)V", "getEnabled", "()Z", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
        /* compiled from: TurboBinaryActive.kt */
        public static final class c implements Parcelable {
            public static final Creator CREATOR = new a();
            @SerializedName("enabled")
            private final boolean enabled;
            @SerializedName("title")
            private final String title;

            @i(aXC = {1, 1, 11})
            public static class a implements Creator {
                public final Object createFromParcel(Parcel parcel) {
                    h.e(parcel, "in");
                    return new c(parcel.readInt() != 0, parcel.readString());
                }

                public final Object[] newArray(int i) {
                    return new c[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    return (this.enabled == cVar.enabled ? 1 : null) != null && h.E(this.title, cVar.title);
                }
            }

            public int hashCode() {
                int i = this.enabled;
                if (i != 0) {
                    i = 1;
                }
                i *= 31;
                String str = this.title;
                return i + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Special(enabled=");
                stringBuilder.append(this.enabled);
                stringBuilder.append(", title=");
                stringBuilder.append(this.title);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }

            public void writeToParcel(Parcel parcel, int i) {
                h.e(parcel, "parcel");
                parcel.writeInt(this.enabled);
                parcel.writeString(this.title);
            }

            public c(boolean z, String str) {
                h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                this.enabled = z;
                this.title = str;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }

            public final String getTitle() {
                return this.title;
            }
        }

        public d() {
            this(null, null, null, null, null, null, 63, null);
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Missing block: B:14:0x0042, code:
            if (kotlin.jvm.internal.h.E(r2.aZb, r3.aZb) != false) goto L_0x0047;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x0047;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.core.microservices.tradingengine.response.active.k.d;
            if (r0 == 0) goto L_0x0045;
        L_0x0006:
            r3 = (com.iqoption.core.microservices.tradingengine.response.active.k.d) r3;
            r0 = r2.aYY;
            r1 = r3.aYY;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0045;
        L_0x0012:
            r0 = r2.expTime;
            r1 = r3.expTime;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0045;
        L_0x001c:
            r0 = r2.aYZ;
            r1 = r3.aYZ;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0045;
        L_0x0026:
            r0 = r2.aZa;
            r1 = r3.aZa;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0045;
        L_0x0030:
            r0 = r2.count;
            r1 = r3.count;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0045;
        L_0x003a:
            r0 = r2.aZb;
            r3 = r3.aZb;
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x0045;
        L_0x0044:
            goto L_0x0047;
        L_0x0045:
            r3 = 0;
            return r3;
        L_0x0047:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.tradingengine.response.active.k.d.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            b bVar = this.aYY;
            int i = 0;
            int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
            Long l = this.expTime;
            hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
            l = this.aYZ;
            hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
            l = this.aZa;
            hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
            Integer num = this.count;
            hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            Map map = this.aZb;
            if (map != null) {
                i = map.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Option(profit=");
            stringBuilder.append(this.aYY);
            stringBuilder.append(", expTime=");
            stringBuilder.append(this.expTime);
            stringBuilder.append(", startTime=");
            stringBuilder.append(this.aYZ);
            stringBuilder.append(", startExpTime=");
            stringBuilder.append(this.aZa);
            stringBuilder.append(", count=");
            stringBuilder.append(this.count);
            stringBuilder.append(", specials=");
            stringBuilder.append(this.aZb);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            h.e(parcel, "parcel");
            Parcelable parcelable = this.aYY;
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Long l = this.expTime;
            if (l != null) {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            } else {
                parcel.writeInt(0);
            }
            l = this.aYZ;
            if (l != null) {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            } else {
                parcel.writeInt(0);
            }
            l = this.aZa;
            if (l != null) {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            } else {
                parcel.writeInt(0);
            }
            Integer num = this.count;
            if (num != null) {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            } else {
                parcel.writeInt(0);
            }
            Map map = this.aZb;
            if (map != null) {
                parcel.writeInt(1);
                parcel.writeInt(map.size());
                for (Entry next : map.entrySet()) {
                    parcel.writeLong(((Long) next.getKey()).longValue());
                    ((c) next.getValue()).writeToParcel(parcel, 0);
                }
                return;
            }
            parcel.writeInt(0);
        }

        public d(b bVar, Long l, Long l2, Long l3, Integer num, Map<Long, c> map) {
            this.aYY = bVar;
            this.expTime = l;
            this.aYZ = l2;
            this.aZa = l3;
            this.count = num;
            this.aZb = map;
        }

        public /* synthetic */ d(b bVar, Long l, Long l2, Long l3, Integer num, Map map, int i, f fVar) {
            if ((i & 1) != 0) {
                bVar = (b) null;
            }
            if ((i & 2) != 0) {
                l = (Long) null;
            }
            Long l4 = l;
            if ((i & 4) != 0) {
                l2 = (Long) null;
            }
            Long l5 = l2;
            if ((i & 8) != 0) {
                l3 = (Long) null;
            }
            Long l6 = l3;
            if ((i & 16) != 0) {
                num = (Integer) null;
            }
            Integer num2 = num;
            if ((i & 32) != 0) {
                map = (Map) null;
            }
            this(bVar, l4, l5, l6, num2, map);
        }

        public final b XA() {
            return this.aYY;
        }

        public final Long XB() {
            return this.expTime;
        }

        public final void o(Long l) {
            this.expTime = l;
        }

        public final Long XC() {
            return this.aYZ;
        }

        public final void p(Long l) {
            this.aYZ = l;
        }

        public final Long XD() {
            return this.aZa;
        }

        public final void q(Long l) {
            this.aZa = l;
        }

        public final void c(Integer num) {
            this.count = num;
        }

        public final Integer getCount() {
            return this.count;
        }

        public final Map<Long, c> XE() {
            return this.aZb;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (h.E(this._name, kVar._name)) {
                if ((this.groupId == kVar.groupId ? 1 : null) != null && h.E(getImage(), kVar.getImage()) && h.E(this.aYP, kVar.aYP)) {
                    if ((this.id == kVar.id ? 1 : null) != null && h.E(this.aYQ, kVar.aYQ) && h.E(this.aYR, kVar.aYR)) {
                        if ((this.aYS == kVar.aYS ? 1 : null) != null && h.E(this.aYT, kVar.aYT)) {
                            return (this.enabled == kVar.enabled ? 1 : null) != null && h.E(this.aYU, kVar.aYU) && h.E(this.aYV, kVar.aYV) && h.E(this.aYW, kVar.aYW);
                        }
                    }
                }
            }
        }
    }

    public int hashCode() {
        String str = this._name;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.groupId) * 31;
        String image = getImage();
        hashCode = (hashCode + (image != null ? image.hashCode() : 0)) * 31;
        Boolean bool = this.aYP;
        hashCode = (((hashCode + (bool != null ? bool.hashCode() : 0)) * 31) + this.id) * 31;
        Integer num = this.aYQ;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        d dVar = this.aYR;
        hashCode = (((hashCode + (dVar != null ? dVar.hashCode() : 0)) * 31) + this.aYS) * 31;
        ArrayList arrayList = this.aYT;
        hashCode = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        int i2 = this.enabled;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        c cVar = this.aYU;
        hashCode = (hashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
        Long l = this.aYV;
        hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        num = this.aYW;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public boolean isExpired() {
        return true;
    }

    public void r(a aVar) {
        h.e(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TurboBinaryActive(_name=");
        stringBuilder.append(this._name);
        stringBuilder.append(", groupId=");
        stringBuilder.append(this.groupId);
        stringBuilder.append(", image=");
        stringBuilder.append(getImage());
        stringBuilder.append(", topTradersEnabled=");
        stringBuilder.append(this.aYP);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", _precision=");
        stringBuilder.append(this.aYQ);
        stringBuilder.append(", option=");
        stringBuilder.append(this.aYR);
        stringBuilder.append(", deadTime=");
        stringBuilder.append(this.aYS);
        stringBuilder.append(", schedule=");
        stringBuilder.append(this.aYT);
        stringBuilder.append(", enabled=");
        stringBuilder.append(this.enabled);
        stringBuilder.append(", minmax=");
        stringBuilder.append(this.aYU);
        stringBuilder.append(", _startTime=");
        stringBuilder.append(this.aYV);
        stringBuilder.append(", isBuyback=");
        stringBuilder.append(this.aYW);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this._name);
        parcel.writeInt(this.groupId);
        parcel.writeString(this.image);
        Boolean bool = this.aYP;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.id);
        Integer num = this.aYQ;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Parcelable parcelable = this.aYR;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.aYS);
        Collection<int[]> collection = this.aYT;
        if (collection != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection.size());
            for (int[] writeIntArray : collection) {
                parcel.writeIntArray(writeIntArray);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.enabled);
        this.aYU.writeToParcel(parcel, 0);
        Long l = this.aYV;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        num = this.aYW;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
            return;
        }
        parcel.writeInt(0);
    }

    public String getImage() {
        return this.image;
    }

    public final d Xy() {
        return this.aYR;
    }

    public final int Xz() {
        return this.aYS;
    }

    public k(String str, int i, String str2, Boolean bool, int i2, Integer num, d dVar, int i3, ArrayList<int[]> arrayList, boolean z, c cVar, Long l, Integer num2) {
        h.e(str, "_name");
        h.e(str2, "image");
        h.e(cVar, "minmax");
        this._name = str;
        this.groupId = i;
        this.image = str2;
        this.aYP = bool;
        this.id = i2;
        this.aYQ = num;
        this.aYR = dVar;
        this.aYS = i3;
        this.aYT = arrayList;
        this.enabled = z;
        this.aYU = cVar;
        this.aYV = l;
        this.aYW = num2;
    }

    public Integer Xk() {
        return Integer.valueOf(this.groupId);
    }

    public String Xg() {
        return this._name;
    }

    public int getActiveId() {
        return this.id;
    }

    public boolean Xh() {
        return this.aYW != null && this.aYW.intValue() > 0;
    }

    public boolean Xj() {
        return h.E(this.aYP, Boolean.valueOf(true));
    }

    public Integer Xi() {
        int intValue;
        d dVar = this.aYR;
        if (dVar != null) {
            b XA = dVar.XA();
            if (XA != null) {
                Integer Xi = XA.Xi();
                if (Xi != null) {
                    intValue = Xi.intValue();
                    return Integer.valueOf(intValue);
                }
            }
        }
        intValue = 0;
        return Integer.valueOf(intValue);
    }

    public int getPrecision() {
        Integer num = this.aYQ;
        return num != null ? num.intValue() : 4;
    }

    public long getStartTime() {
        Long l = this.aYV;
        return l != null ? l.longValue() : 0;
    }

    public long bb(long j) {
        if (this.aYT == null) {
            return Long.MAX_VALUE;
        }
        try {
            Long l = (Long) null;
            Iterator it = this.aYT.iterator();
            while (it.hasNext()) {
                int[] iArr = (int[]) it.next();
                if (j < ((long) iArr[0]) * 1000) {
                    l = Long.valueOf(((long) iArr[0]) * 1000);
                    break;
                }
            }
            if (l == null) {
                l = Long.valueOf(Long.MAX_VALUE);
            }
            j = l.longValue();
        } catch (Exception unused) {
            j = Long.MAX_VALUE;
        }
        return j;
    }

    public boolean ba(long j) {
        if (this.aYT == null) {
            return false;
        }
        Iterator it = this.aYT.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            long j2 = (long) 1000;
            if (j >= ((long) iArr[0]) * j2 && j <= ((long) iArr[1]) * j2) {
                return true;
            }
        }
        return false;
    }

    public final void k(int[] iArr) {
        h.e(iArr, "scheduleObj");
        ArrayList arrayList = this.aYT;
        if (arrayList != null) {
            arrayList.add(iArr);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0012  */
    public final void dR(int r2) {
        /*
        r1 = this;
        r0 = r1.aYR;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = r0.XA();
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        r0 = r0.Xi();
        goto L_0x0010;
    L_0x000f:
        r0 = 0;
    L_0x0010:
        if (r0 == 0) goto L_0x0025;
    L_0x0012:
        r0 = r1.aYR;
        r0 = r0.XA();
        if (r0 != 0) goto L_0x001d;
    L_0x001a:
        kotlin.jvm.internal.h.aXZ();
    L_0x001d:
        r2 = java.lang.Integer.valueOf(r2);
        r0.d(r2);
        return;
    L_0x0025:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.tradingengine.response.active.k.dR(int):void");
    }
}
