package com.iqoption.core.microservices.billing.response.extraparams;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FrameMetricsAggregator;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00101J\t\u00102\u001a\u000203HÖ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000203HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0019\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000203HÖ\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u0006?"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParams;", "Landroid/os/Parcelable;", "title", "", "required", "Ljava/util/ArrayList;", "properties", "Ljava/util/HashMap;", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "id", "", "mask", "name", "symbol", "min_dep", "max_dep", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMask", "()Ljava/lang/String;", "setMask", "(Ljava/lang/String;)V", "getMax_dep", "setMax_dep", "getMin_dep", "setMin_dep", "getName", "setName", "getProperties", "()Ljava/util/HashMap;", "getRequired", "()Ljava/util/ArrayList;", "getSymbol", "setSymbol", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: ExtraParams.kt */
public final class e implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("required")
    private final ArrayList<String> aUk;
    private Long aUl;
    private Long aUm;
    private Long id;
    private String mask;
    private String name;
    @SerializedName("properties")
    private final HashMap<String, ExtraParamProperty> properties;
    private String symbol;
    @SerializedName("title")
    private final String title;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            int readInt;
            ArrayList arrayList;
            Map hashMap;
            h.e(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(parcel.readString());
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                hashMap = new HashMap(readInt);
                while (readInt != 0) {
                    hashMap.put(parcel.readString(), (ExtraParamProperty) parcel.readParcelable(e.class.getClassLoader()));
                    readInt--;
                }
            } else {
                hashMap = null;
            }
            return new e(readString, arrayList, hashMap, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        public final Object[] newArray(int i) {
            return new e[i];
        }
    }

    public e() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:20:0x0060, code:
            if (kotlin.jvm.internal.h.E(r2.aUm, r3.aUm) != false) goto L_0x0065;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0065;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.billing.response.extraparams.e;
        if (r0 == 0) goto L_0x0063;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.billing.response.extraparams.e) r3;
        r0 = r2.title;
        r1 = r3.title;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0012:
        r0 = r2.aUk;
        r1 = r3.aUk;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x001c:
        r0 = r2.properties;
        r1 = r3.properties;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0026:
        r0 = r2.id;
        r1 = r3.id;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0030:
        r0 = r2.mask;
        r1 = r3.mask;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x003a:
        r0 = r2.name;
        r1 = r3.name;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0044:
        r0 = r2.symbol;
        r1 = r3.symbol;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x004e:
        r0 = r2.aUl;
        r1 = r3.aUl;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0063;
    L_0x0058:
        r0 = r2.aUm;
        r3 = r3.aUm;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0063;
    L_0x0062:
        goto L_0x0065;
    L_0x0063:
        r3 = 0;
        return r3;
    L_0x0065:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.extraparams.e.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList arrayList = this.aUk;
        hashCode = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        HashMap hashMap = this.properties;
        hashCode = (hashCode + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        Long l = this.id;
        hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.mask;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.name;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.symbol;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        l = this.aUl;
        hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        l = this.aUm;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtraParams(title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", required=");
        stringBuilder.append(this.aUk);
        stringBuilder.append(", properties=");
        stringBuilder.append(this.properties);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", mask=");
        stringBuilder.append(this.mask);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", symbol=");
        stringBuilder.append(this.symbol);
        stringBuilder.append(", min_dep=");
        stringBuilder.append(this.aUl);
        stringBuilder.append(", max_dep=");
        stringBuilder.append(this.aUm);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.title);
        Collection<String> collection = this.aUk;
        if (collection != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection.size());
            for (String writeString : collection) {
                parcel.writeString(writeString);
            }
        } else {
            parcel.writeInt(0);
        }
        Map map = this.properties;
        if (map != null) {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeParcelable((ExtraParamProperty) next.getValue(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        Long l = this.id;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.mask);
        parcel.writeString(this.name);
        parcel.writeString(this.symbol);
        l = this.aUl;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        l = this.aUm;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
            return;
        }
        parcel.writeInt(0);
    }

    public e(String str, ArrayList<String> arrayList, HashMap<String, ExtraParamProperty> hashMap, Long l, String str2, String str3, String str4, Long l2, Long l3) {
        this.title = str;
        this.aUk = arrayList;
        this.properties = hashMap;
        this.id = l;
        this.mask = str2;
        this.name = str3;
        this.symbol = str4;
        this.aUl = l2;
        this.aUm = l3;
    }

    public /* synthetic */ e(String str, ArrayList arrayList, HashMap hashMap, Long l, String str2, String str3, String str4, Long l2, Long l3, int i, f fVar) {
        int i2 = i;
        this((i2 & 1) != 0 ? (String) null : str, (i2 & 2) != 0 ? (ArrayList) null : arrayList, (i2 & 4) != 0 ? (HashMap) null : hashMap, (i2 & 8) != 0 ? (Long) null : l, (i2 & 16) != 0 ? (String) null : str2, (i2 & 32) != 0 ? (String) null : str3, (i2 & 64) != 0 ? (String) null : str4, (i2 & 128) != 0 ? (Long) null : l2, (i2 & 256) != 0 ? (Long) null : l3);
    }

    public final ArrayList<String> Vn() {
        return this.aUk;
    }

    public final HashMap<String, ExtraParamProperty> Vo() {
        return this.properties;
    }
}
