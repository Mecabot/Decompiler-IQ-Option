package com.iqoption.core.microservices.risks.response.overnightfee;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006$"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeData;", "Landroid/os/Parcelable;", "activeId", "", "fee", "", "Lcom/iqoption/core/microservices/risks/response/overnightfee/Day;", "Lcom/iqoption/core/microservices/risks/response/overnightfee/FeeData;", "(ILjava/util/Map;)V", "getActiveId", "()I", "getFee", "()Ljava/util/Map;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "getFeeMap", "Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeMap;", "timeZoneOffset", "", "hashCode", "parseTime", "time", "", "(Ljava/lang/String;)Ljava/lang/Long;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: OvernightFeeData.kt */
public final class c implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("fee")
    private final Map<Day, b> aXH;
    @SerializedName("active_id")
    private final int activeId;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            Map linkedHashMap = new LinkedHashMap(readInt2);
            while (readInt2 != 0) {
                linkedHashMap.put((Day) Enum.valueOf(Day.class, parcel.readString()), (b) b.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new c(readInt, linkedHashMap);
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
            return (this.activeId == cVar.activeId ? 1 : null) != null && h.E(this.aXH, cVar.aXH);
        }
    }

    public int hashCode() {
        int i = this.activeId * 31;
        Map map = this.aXH;
        return i + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OvernightFeeData(activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", fee=");
        stringBuilder.append(this.aXH);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeInt(this.activeId);
        Map map = this.aXH;
        parcel.writeInt(map.size());
        for (Entry next : map.entrySet()) {
            parcel.writeString(((Day) next.getKey()).name());
            ((b) next.getValue()).writeToParcel(parcel, 0);
        }
    }

    public c(int i, Map<Day, b> map) {
        h.e(map, "fee");
        this.activeId = i;
        this.aXH = map;
    }

    public final int getActiveId() {
        return this.activeId;
    }

    private final Long gJ(String str) {
        try {
            List b = v.b((CharSequence) str, new String[]{":"}, false, 0, 6, null);
            return Long.valueOf(TimeUnit.HOURS.toMillis((long) Integer.parseInt((String) b.get(0))) + TimeUnit.MINUTES.toMillis((long) Integer.parseInt((String) b.get(1))));
        } catch (Exception e) {
            com.iqoption.core.i.d("OvernightFeeData", (Throwable) e);
            return null;
        }
    }

    public final d aY(long j) {
        d dVar = new d(new HashMap());
        long toMillis = TimeUnit.HOURS.toMillis(24);
        for (Entry entry : this.aXH.entrySet()) {
            int convertToCalendarDay = ((Day) entry.getKey()).convertToCalendarDay();
            b bVar = (b) entry.getValue();
            Long gJ = gJ(bVar.getTime());
            if (gJ != null) {
                long longValue = gJ.longValue();
                long j2 = longValue + j;
                bVar.setTime(com.iqoption.core.ext.c.aR(longValue));
                int i = 7;
                int i2 = 1;
                if (j2 >= toMillis) {
                    if (7 != convertToCalendarDay) {
                        i2 = convertToCalendarDay + 1;
                    }
                    convertToCalendarDay = i2;
                } else if (j2 < 0) {
                    if (1 != convertToCalendarDay) {
                        i = convertToCalendarDay - 1;
                    }
                    convertToCalendarDay = i;
                }
            }
            dVar.WL().put(Integer.valueOf(convertToCalendarDay), bVar);
        }
        return dVar;
    }
}
