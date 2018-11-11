package com.iqoption.microservice.withdraw.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007HÆ\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\t\u00102\u001a\u00020\nHÖ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\nHÖ\u0001J\b\u00108\u001a\u00020\u0003H\u0016J\t\u00109\u001a\u00020\u0003HÖ\u0001J\b\u0010:\u001a\u00020;H\u0016J\u0019\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\nHÖ\u0001R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u0006A"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/WithdrawMethod;", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "name", "", "commission", "", "fields", "", "Lcom/iqoption/microservice/withdraw/response/PayoutField;", "id", "", "cssName", "comment", "limits", "Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;", "currency", "", "paySystem", "maxLimit", "Lcom/iqoption/withdrawal/common/AmountLimit;", "(Ljava/lang/String;DLjava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Lcom/iqoption/withdrawal/common/AmountLimit;)V", "getComment", "()Ljava/lang/String;", "getCommission", "()D", "getCssName", "getCurrency", "()Ljava/util/Map;", "getFields", "()Ljava/util/List;", "getId", "()I", "getLimits", "getMaxLimit", "()Lcom/iqoption/withdrawal/common/AmountLimit;", "setMaxLimit", "(Lcom/iqoption/withdrawal/common/AmountLimit;)V", "getName", "getPaySystem", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "methodId", "toString", "type", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawMethod.kt */
public final class h implements a {
    public static final Creator CREATOR = new a();
    @SerializedName("paysystem")
    private final String aTM;
    @SerializedName("css_name")
    private final String cTB;
    @SerializedName("currency")
    private final Map<String, String> cTC;
    @SerializedName("commission")
    private final double cTr;
    @SerializedName("limits")
    private final List<g> cTs;
    private transient com.iqoption.withdrawal.common.a cTt;
    @SerializedName("comment")
    private final String comment;
    @SerializedName("fields")
    private final List<f> fields;
    @SerializedName("id")
    private final int id;
    @SerializedName("name")
    private final String name;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            kotlin.jvm.internal.h.e(parcel, "in");
            String readString = parcel.readString();
            double readDouble = parcel.readDouble();
            int readInt = parcel.readInt();
            List arrayList2 = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList2.add((f) f.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((g) g.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            readInt = parcel.readInt();
            Map linkedHashMap = new LinkedHashMap(readInt);
            while (readInt != 0) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
                readInt--;
            }
            return new h(readString, readDouble, arrayList2, readInt2, readString2, readString3, arrayList, linkedHashMap, parcel.readString(), parcel.readInt() != 0 ? (com.iqoption.withdrawal.common.a) com.iqoption.withdrawal.common.a.CREATOR.createFromParcel(parcel) : null);
        }

        public final Object[] newArray(int i) {
            return new h[i];
        }
    }

    public static /* synthetic */ h a(h hVar, String str, double d, List list, int i, String str2, String str3, List list2, Map map, String str4, com.iqoption.withdrawal.common.a aVar, int i2, Object obj) {
        h hVar2 = hVar;
        int i3 = i2;
        return hVar2.a((i3 & 1) != 0 ? hVar2.getName() : str, (i3 & 2) != 0 ? hVar2.atv() : d, (i3 & 4) != 0 ? hVar2.atw() : list, (i3 & 8) != 0 ? hVar2.id : i, (i3 & 16) != 0 ? hVar2.cTB : str2, (i3 & 32) != 0 ? hVar2.comment : str3, (i3 & 64) != 0 ? hVar2.atx() : list2, (i3 & 128) != 0 ? hVar2.cTC : map, (i3 & 256) != 0 ? hVar2.aTM : str4, (i3 & 512) != 0 ? hVar2.aty() : aVar);
    }

    public final h a(String str, double d, List<f> list, int i, String str2, String str3, List<g> list2, Map<String, String> map, String str4, com.iqoption.withdrawal.common.a aVar) {
        String str5 = str;
        kotlin.jvm.internal.h.e(str5, "name");
        List<f> list3 = list;
        kotlin.jvm.internal.h.e(list3, "fields");
        String str6 = str2;
        kotlin.jvm.internal.h.e(str6, "cssName");
        String str7 = str3;
        kotlin.jvm.internal.h.e(str7, "comment");
        Map<String, String> map2 = map;
        kotlin.jvm.internal.h.e(map2, b.CURRENCY);
        String str8 = str4;
        kotlin.jvm.internal.h.e(str8, "paySystem");
        return new h(str5, d, list3, i, str6, str7, list2, map2, str8, aVar);
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
            if (kotlin.jvm.internal.h.E(getName(), hVar.getName()) && Double.compare(atv(), hVar.atv()) == 0 && kotlin.jvm.internal.h.E(atw(), hVar.atw())) {
                return (this.id == hVar.id ? 1 : null) != null && kotlin.jvm.internal.h.E(this.cTB, hVar.cTB) && kotlin.jvm.internal.h.E(this.comment, hVar.comment) && kotlin.jvm.internal.h.E(atx(), hVar.atx()) && kotlin.jvm.internal.h.E(this.cTC, hVar.cTC) && kotlin.jvm.internal.h.E(this.aTM, hVar.aTM) && kotlin.jvm.internal.h.E(aty(), hVar.aty());
            }
        }
    }

    public int hashCode() {
        String name = getName();
        int i = 0;
        int hashCode = (name != null ? name.hashCode() : 0) * 31;
        long doubleToLongBits = Double.doubleToLongBits(atv());
        hashCode = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        List atw = atw();
        hashCode = (((hashCode + (atw != null ? atw.hashCode() : 0)) * 31) + this.id) * 31;
        String str = this.cTB;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.comment;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        atw = atx();
        hashCode = (hashCode + (atw != null ? atw.hashCode() : 0)) * 31;
        Map map = this.cTC;
        hashCode = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        str = this.aTM;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        com.iqoption.withdrawal.common.a aty = aty();
        if (aty != null) {
            i = aty.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WithdrawMethod(name=");
        stringBuilder.append(getName());
        stringBuilder.append(", commission=");
        stringBuilder.append(atv());
        stringBuilder.append(", fields=");
        stringBuilder.append(atw());
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", cssName=");
        stringBuilder.append(this.cTB);
        stringBuilder.append(", comment=");
        stringBuilder.append(this.comment);
        stringBuilder.append(", limits=");
        stringBuilder.append(atx());
        stringBuilder.append(", currency=");
        stringBuilder.append(this.cTC);
        stringBuilder.append(", paySystem=");
        stringBuilder.append(this.aTM);
        stringBuilder.append(", maxLimit=");
        stringBuilder.append(aty());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        kotlin.jvm.internal.h.e(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeDouble(this.cTr);
        Collection<f> collection = this.fields;
        parcel.writeInt(collection.size());
        for (f writeToParcel : collection) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        parcel.writeInt(this.id);
        parcel.writeString(this.cTB);
        parcel.writeString(this.comment);
        Collection<g> collection2 = this.cTs;
        if (collection2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(collection2.size());
            for (g writeToParcel2 : collection2) {
                writeToParcel2.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Map map = this.cTC;
        parcel.writeInt(map.size());
        for (Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
        parcel.writeString(this.aTM);
        Parcelable parcelable = this.cTt;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public h(String str, double d, List<f> list, int i, String str2, String str3, List<g> list2, Map<String, String> map, String str4, com.iqoption.withdrawal.common.a aVar) {
        kotlin.jvm.internal.h.e(str, "name");
        kotlin.jvm.internal.h.e(list, "fields");
        kotlin.jvm.internal.h.e(str2, "cssName");
        kotlin.jvm.internal.h.e(str3, "comment");
        kotlin.jvm.internal.h.e(map, b.CURRENCY);
        kotlin.jvm.internal.h.e(str4, "paySystem");
        this.name = str;
        this.cTr = d;
        this.fields = list;
        this.id = i;
        this.cTB = str2;
        this.comment = str3;
        this.cTs = list2;
        this.cTC = map;
        this.aTM = str4;
        this.cTt = aVar;
    }

    public String getName() {
        return this.name;
    }

    public double atv() {
        return this.cTr;
    }

    public List<f> atw() {
        return this.fields;
    }

    public final int getId() {
        return this.id;
    }

    public final String atI() {
        return this.cTB;
    }

    public List<g> atx() {
        return this.cTs;
    }

    public final String UZ() {
        return this.aTM;
    }

    public com.iqoption.withdrawal.common.a aty() {
        return this.cTt;
    }

    public WithdrawMethodType att() {
        return WithdrawMethodType.COMMON;
    }

    public String atu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getName());
        stringBuilder.append('-');
        stringBuilder.append(this.id);
        return stringBuilder.toString();
    }
}
