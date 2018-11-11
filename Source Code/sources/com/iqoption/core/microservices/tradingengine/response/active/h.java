package com.iqoption.core.microservices.tradingengine.response.active;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.ActiveType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b0\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 f2\u00020\u0001:\u0003efgB­\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018\u0018\u00010\u0017¢\u0006\u0002\u0010\u0019J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÄ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000bHÂ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÄ\u0003J\u001d\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018\u0018\u00010\u0017HÂ\u0003J\t\u0010;\u001a\u00020\u0005HÄ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010=\u001a\u0004\u0018\u00010\bHÄ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u000eHÄ\u0003¢\u0006\u0002\u0010)J\t\u0010A\u001a\u00020\u0003HÄ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000e\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u0003JÆ\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010FJ\t\u0010G\u001a\u00020\u0005HÖ\u0001J\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u000eJ\u0013\u0010K\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010MHÖ\u0003J\b\u0010N\u001a\u00020\u0005H\u0016J\n\u0010O\u001a\u0004\u0018\u00010\bH\u0016J\u000f\u0010P\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010%J\u0014\u0010Q\u001a\u0010\u0012\f\u0012\n R*\u0004\u0018\u00010\u00140\u00140\u0018J\r\u0010S\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010%J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020UH\u0016J\b\u0010W\u001a\u00020\u0005H\u0016J\b\u0010X\u001a\u00020UH\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010Z\u001a\u00020\u0005HÖ\u0001J\b\u0010[\u001a\u00020\u000eH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020UH\u0016J\b\u0010\\\u001a\u00020\u000eH\u0016J\b\u0010]\u001a\u00020\u000eH\u0016J\t\u0010^\u001a\u00020\u0003HÖ\u0001J\u0010\u0010_\u001a\u00020I2\u0006\u0010`\u001a\u00020\u0001H\u0016J\u0019\u0010a\u001a\u00020I2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\u00038\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0012\u001a\u00020\u00058\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u001a\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b\r\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010!\"\u0004\b.\u0010/R&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018\u0018\u00010\u00178\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!¨\u0006h"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive;", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "instrumentId", "", "_activeId", "", "activeGroupId", "_activeType", "Lcom/iqoption/core/data/model/ActiveType;", "underlying", "schedules", "Ljava/util/ArrayList;", "Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive$Schedule;", "isEnabled", "", "_name", "localizationKey", "image", "_precision", "expirations", "Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive$CfdExpiration;", "_ticker", "tags", "", "", "(Ljava/lang/String;ILjava/lang/Integer;Lcom/iqoption/core/data/model/ActiveType;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;Ljava/lang/String;Ljava/util/Map;)V", "get_activeId", "()I", "get_activeType", "()Lcom/iqoption/core/data/model/ActiveType;", "set_activeType", "(Lcom/iqoption/core/data/model/ActiveType;)V", "get_name", "()Ljava/lang/String;", "get_precision", "get_ticker", "getActiveGroupId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImage", "getInstrumentId", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLocalizationKey", "setLocalizationKey", "(Ljava/lang/String;)V", "getSchedules", "()Ljava/util/ArrayList;", "setSchedules", "(Ljava/util/ArrayList;)V", "getUnderlying", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "containsTag", "tag", "copy", "(Ljava/lang/String;ILjava/lang/Integer;Lcom/iqoption/core/data/model/ActiveType;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;Ljava/lang/String;Ljava/util/Map;)Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive;", "describeContents", "enabledExpiration", "", "isCfdExpirationEnabled", "equals", "other", "", "getActiveId", "getActiveType", "getCommission", "getExpirations", "kotlin.jvm.PlatformType", "getGroupId", "getNextSchedule", "", "timeSync", "getPrecision", "getStartTime", "getTicker", "hashCode", "isBuybackEnabled", "isExpired", "isTopTradersEnabled", "toString", "update", "value", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "CfdExpiration", "Companion", "Schedule", "core_release"})
/* compiled from: InstrumentActive.kt */
public final class h extends a {
    public static final Creator CREATOR = new d();
    private static final Comparator<e> aYI = new a();
    public static final c aYJ = new c();
    @SerializedName("name")
    private final String _name;
    @SerializedName("active_id")
    private final int aYA;
    @SerializedName("active_group_id")
    private final Integer aYB;
    @SerializedName("active_type")
    private ActiveType aYC;
    @SerializedName("schedule")
    private volatile ArrayList<e> aYD;
    @SerializedName("localization_key")
    private String aYE;
    @SerializedName("precision")
    private final int aYF;
    @SerializedName("ticker")
    private final String aYG;
    @SerializedName("tags")
    private final Map<String, List<String>> aYH;
    @SerializedName("expirations")
    private volatile ArrayList<b> expirations;
    @SerializedName("image")
    private final String image;
    @SerializedName("id")
    private final String instrumentId;
    @SerializedName("is_enabled")
    private Boolean isEnabled;
    @SerializedName("underlying")
    private final String underlying;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return b.c(Long.valueOf(((e) t).Xt()), Long.valueOf(((e) t2).Xt()));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive$CfdExpiration;", "Landroid/os/Parcelable;", "expiration", "", "deadtime", "(JJ)V", "getDeadtime", "()J", "getExpiration", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
    /* compiled from: InstrumentActive.kt */
    public static final class b implements Parcelable {
        public static final Creator CREATOR = new a();
        @SerializedName("deadtime")
        private final long aYK;
        @SerializedName("expiration")
        private final long expiration;

        @i(aXC = {1, 1, 11})
        public static class a implements Creator {
            public final Object createFromParcel(Parcel parcel) {
                kotlin.jvm.internal.h.e(parcel, "in");
                return new b(parcel.readLong(), parcel.readLong());
            }

            public final Object[] newArray(int i) {
                return new b[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if ((this.expiration == bVar.expiration ? 1 : null) != null) {
                    if ((this.aYK == bVar.aYK ? 1 : null) != null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            long j = this.expiration;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.aYK;
            return i + ((int) (j2 ^ (j2 >>> 32)));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CfdExpiration(expiration=");
            stringBuilder.append(this.expiration);
            stringBuilder.append(", deadtime=");
            stringBuilder.append(this.aYK);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            parcel.writeLong(this.expiration);
            parcel.writeLong(this.aYK);
        }

        public b(long j, long j2) {
            this.expiration = j;
            this.aYK = j2;
        }

        public final long getExpiration() {
            return this.expiration;
        }

        public final long Xs() {
            return this.aYK;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive$Companion;", "", "()V", "scheduleComparator", "Ljava/util/Comparator;", "Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive$Schedule;", "Lkotlin/Comparator;", "core_release"})
    /* compiled from: InstrumentActive.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11})
    public static class d implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            int readInt;
            ArrayList arrayList;
            Boolean valueOf;
            ArrayList arrayList2;
            ArrayList arrayList3;
            Map map;
            Parcel parcel2 = parcel;
            kotlin.jvm.internal.h.e(parcel2, "in");
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            ActiveType activeType = parcel.readInt() != 0 ? (ActiveType) Enum.valueOf(ActiveType.class, parcel.readString()) : null;
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((e) e.CREATOR.createFromParcel(parcel2));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                valueOf = null;
            }
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            int readInt3 = parcel.readInt();
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add((b) b.CREATOR.createFromParcel(parcel2));
                    readInt--;
                }
            } else {
                arrayList2 = null;
            }
            String readString6 = parcel.readString();
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                Map linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    arrayList3 = arrayList2;
                    linkedHashMap.put(parcel.readString(), parcel.createStringArrayList());
                    readInt--;
                    arrayList2 = arrayList3;
                    parcel2 = parcel;
                }
                arrayList3 = arrayList2;
                map = linkedHashMap;
            } else {
                arrayList3 = arrayList2;
                map = null;
            }
            return new h(readString, readInt2, valueOf2, activeType, readString2, arrayList, valueOf, readString3, readString4, readString5, readInt3, arrayList3, readString6, map);
        }

        public final Object[] newArray(int i) {
            return new h[i];
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive$Schedule;", "Landroid/os/Parcelable;", "open", "", "close", "(JJ)V", "getClose", "()J", "getOpen", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
    /* compiled from: InstrumentActive.kt */
    public static final class e implements Parcelable {
        public static final Creator CREATOR = new a();
        @SerializedName("open")
        private final long aYL;
        @SerializedName("close")
        private final long aYM;

        @i(aXC = {1, 1, 11})
        public static class a implements Creator {
            public final Object createFromParcel(Parcel parcel) {
                kotlin.jvm.internal.h.e(parcel, "in");
                return new e(parcel.readLong(), parcel.readLong());
            }

            public final Object[] newArray(int i) {
                return new e[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                if ((this.aYL == eVar.aYL ? 1 : null) != null) {
                    if ((this.aYM == eVar.aYM ? 1 : null) != null) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            long j = this.aYL;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.aYM;
            return i + ((int) (j2 ^ (j2 >>> 32)));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Schedule(open=");
            stringBuilder.append(this.aYL);
            stringBuilder.append(", close=");
            stringBuilder.append(this.aYM);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            parcel.writeLong(this.aYL);
            parcel.writeLong(this.aYM);
        }

        public e(long j, long j2) {
            this.aYL = j;
            this.aYM = j2;
        }

        public final long Xt() {
            return this.aYL;
        }

        public final long Xu() {
            return this.aYM;
        }
    }

    public boolean Xh() {
        return true;
    }

    public boolean Xj() {
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (kotlin.jvm.internal.h.E(getInstrumentId(), hVar.getInstrumentId())) {
                if ((this.aYA == hVar.aYA ? 1 : null) != null && kotlin.jvm.internal.h.E(this.aYB, hVar.aYB) && kotlin.jvm.internal.h.E(this.aYC, hVar.aYC) && kotlin.jvm.internal.h.E(Xf(), hVar.Xf()) && kotlin.jvm.internal.h.E(this.aYD, hVar.aYD) && kotlin.jvm.internal.h.E(this.isEnabled, hVar.isEnabled) && kotlin.jvm.internal.h.E(this._name, hVar._name) && kotlin.jvm.internal.h.E(this.aYE, hVar.aYE) && kotlin.jvm.internal.h.E(getImage(), hVar.getImage())) {
                    return (this.aYF == hVar.aYF ? 1 : null) != null && kotlin.jvm.internal.h.E(this.expirations, hVar.expirations) && kotlin.jvm.internal.h.E(this.aYG, hVar.aYG) && kotlin.jvm.internal.h.E(this.aYH, hVar.aYH);
                }
            }
        }
    }

    public long getStartTime() {
        return 0;
    }

    public int hashCode() {
        String instrumentId = getInstrumentId();
        int i = 0;
        int hashCode = (((instrumentId != null ? instrumentId.hashCode() : 0) * 31) + this.aYA) * 31;
        Integer num = this.aYB;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        ActiveType activeType = this.aYC;
        hashCode = (hashCode + (activeType != null ? activeType.hashCode() : 0)) * 31;
        String Xf = Xf();
        hashCode = (hashCode + (Xf != null ? Xf.hashCode() : 0)) * 31;
        ArrayList arrayList = this.aYD;
        hashCode = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        Boolean bool = this.isEnabled;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Xf = this._name;
        hashCode = (hashCode + (Xf != null ? Xf.hashCode() : 0)) * 31;
        Xf = this.aYE;
        hashCode = (hashCode + (Xf != null ? Xf.hashCode() : 0)) * 31;
        Xf = getImage();
        hashCode = (((hashCode + (Xf != null ? Xf.hashCode() : 0)) * 31) + this.aYF) * 31;
        arrayList = this.expirations;
        hashCode = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        Xf = this.aYG;
        hashCode = (hashCode + (Xf != null ? Xf.hashCode() : 0)) * 31;
        Map map = this.aYH;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InstrumentActive(instrumentId=");
        stringBuilder.append(getInstrumentId());
        stringBuilder.append(", _activeId=");
        stringBuilder.append(this.aYA);
        stringBuilder.append(", activeGroupId=");
        stringBuilder.append(this.aYB);
        stringBuilder.append(", _activeType=");
        stringBuilder.append(this.aYC);
        stringBuilder.append(", underlying=");
        stringBuilder.append(Xf());
        stringBuilder.append(", schedules=");
        stringBuilder.append(this.aYD);
        stringBuilder.append(", isEnabled=");
        stringBuilder.append(this.isEnabled);
        stringBuilder.append(", _name=");
        stringBuilder.append(this._name);
        stringBuilder.append(", localizationKey=");
        stringBuilder.append(this.aYE);
        stringBuilder.append(", image=");
        stringBuilder.append(getImage());
        stringBuilder.append(", _precision=");
        stringBuilder.append(this.aYF);
        stringBuilder.append(", expirations=");
        stringBuilder.append(this.expirations);
        stringBuilder.append(", _ticker=");
        stringBuilder.append(this.aYG);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.aYH);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        kotlin.jvm.internal.h.e(parcel, "parcel");
        parcel.writeString(this.instrumentId);
        parcel.writeInt(this.aYA);
        Integer num = this.aYB;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Enum enumR = this.aYC;
        if (enumR != null) {
            parcel.writeInt(1);
            parcel.writeString(enumR.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.underlying);
        Collection<e> collection = this.aYD;
        if (collection != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection.size());
            for (e writeToParcel : collection) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.isEnabled;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this._name);
        parcel.writeString(this.aYE);
        parcel.writeString(this.image);
        parcel.writeInt(this.aYF);
        Collection<b> collection2 = this.expirations;
        if (collection2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection2.size());
            for (b writeToParcel2 : collection2) {
                writeToParcel2.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.aYG);
        Map map = this.aYH;
        if (map != null) {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeStringList((List) next.getValue());
            }
            return;
        }
        parcel.writeInt(0);
    }

    public String getInstrumentId() {
        return this.instrumentId;
    }

    public String Xf() {
        return this.underlying;
    }

    public final String Xr() {
        return this.aYE;
    }

    public String getImage() {
        return this.image;
    }

    public h(String str, int i, Integer num, ActiveType activeType, String str2, ArrayList<e> arrayList, Boolean bool, String str3, String str4, String str5, int i2, ArrayList<b> arrayList2, String str6, Map<String, ? extends List<String>> map) {
        kotlin.jvm.internal.h.e(str, "instrumentId");
        kotlin.jvm.internal.h.e(str2, "underlying");
        kotlin.jvm.internal.h.e(str3, "_name");
        kotlin.jvm.internal.h.e(str4, "localizationKey");
        kotlin.jvm.internal.h.e(str5, "image");
        this.instrumentId = str;
        this.aYA = i;
        this.aYB = num;
        this.aYC = activeType;
        this.underlying = str2;
        this.aYD = arrayList;
        this.isEnabled = bool;
        this._name = str3;
        this.aYE = str4;
        this.image = str5;
        this.aYF = i2;
        this.expirations = arrayList2;
        this.aYG = str6;
        this.aYH = map;
    }

    public ActiveType getActiveType() {
        ActiveType activeType = this.aYC;
        return activeType != null ? activeType : super.getActiveType();
    }

    public int getActiveId() {
        return this.aYA;
    }

    public String Xg() {
        return this.aYG;
    }

    public int getPrecision() {
        return this.aYF;
    }

    public Integer Xi() {
        return Integer.valueOf(0);
    }

    public Integer Xk() {
        Integer num = this.aYB;
        return Integer.valueOf(num != null ? num.intValue() : -1);
    }

    public long bb(long j) {
        ArrayList arrayList = this.aYD;
        if (arrayList == null) {
            return Long.MAX_VALUE;
        }
        try {
            Long l = (Long) null;
            Collections.sort(arrayList, aYI);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long Xt = ((e) it.next()).Xt() * 1000;
                if (j < Xt) {
                    l = Long.valueOf(Xt);
                    break;
                }
            }
            if (l == null) {
                l = Long.valueOf(Long.MAX_VALUE);
            }
            return l.longValue();
        } catch (Exception unused) {
            return Long.MAX_VALUE;
        }
    }

    public boolean ba(long j) {
        if ((kotlin.jvm.internal.h.E(this.isEnabled, Boolean.valueOf(true)) ^ 1) != 0 || this.aYD == null) {
            return false;
        }
        ArrayList arrayList = this.aYD;
        if (arrayList == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            long j2 = (long) 1000;
            if (j > eVar.Xt() * j2 && j < eVar.Xu() * j2) {
                return true;
            }
        }
        return false;
    }

    public void r(a aVar) {
        kotlin.jvm.internal.h.e(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
        if (aVar instanceof h) {
            h hVar = (h) aVar;
            ArrayList arrayList = hVar.aYD;
            if (arrayList == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            Collections.sort(arrayList, aYI);
            this.aYD = hVar.aYD;
            this.isEnabled = hVar.isEnabled;
            this.expirations = hVar.expirations;
        }
    }

    public boolean isExpired() {
        switch (i.aoS[getInstrumentType().ordinal()]) {
            case 1:
            case 2:
                return true;
            default:
                ArrayList arrayList = this.expirations;
                if (arrayList == null || (arrayList.isEmpty() ^ 1) != 1) {
                    return false;
                }
                return true;
        }
    }

    public final void ci(boolean z) {
        if (!z) {
            this.expirations = (ArrayList) null;
        }
    }

    public final List<b> Xq() {
        ArrayList arrayList = this.expirations;
        return arrayList != null ? arrayList : m.emptyList();
    }

    public final boolean gK(String str) {
        kotlin.jvm.internal.h.e(str, "tag");
        if (this.aYH != null) {
            for (List it : this.aYH.values()) {
                for (Object next : it) {
                    if (u.m((String) next, str, true)) {
                        continue;
                        break;
                    }
                }
                Object next2 = null;
                continue;
                if (next2 != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
