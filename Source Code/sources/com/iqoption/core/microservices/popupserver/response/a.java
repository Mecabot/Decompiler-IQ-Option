package com.iqoption.core.microservices.popupserver.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\b\u0016¢\u0006\u0002\u0010\u0004Bs\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0002HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013HÆ\u0003Jw\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\r2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013HÆ\u0001J\t\u0010/\u001a\u00020\rHÖ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\rHÖ\u0001J\t\u00105\u001a\u00020\u0007HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\rHÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0011\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00028\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0010\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#¨\u0006;"}, aXE = {"Lcom/iqoption/core/microservices/popupserver/response/Popup;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "Landroid/os/Parcelable;", "()V", "id", "name", "", "anchor", "Lcom/iqoption/core/microservices/popupserver/response/PopupAnchor;", "fields", "", "formatId", "", "formatName", "Lcom/iqoption/core/microservices/popupserver/response/PopupFormat;", "locale", "formatVersion", "availableEvents", "", "(JLjava/lang/String;Lcom/iqoption/core/microservices/popupserver/response/PopupAnchor;Ljava/util/Map;ILcom/iqoption/core/microservices/popupserver/response/PopupFormat;Ljava/lang/String;ILjava/util/List;)V", "getAnchor", "()Lcom/iqoption/core/microservices/popupserver/response/PopupAnchor;", "getAvailableEvents", "()Ljava/util/List;", "getFields", "()Ljava/util/Map;", "getFormatId", "()I", "getFormatName", "()Lcom/iqoption/core/microservices/popupserver/response/PopupFormat;", "getFormatVersion", "getId", "()Ljava/lang/Long;", "getLocale", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: Popup.kt */
public final class a implements Parcelable, d<Long> {
    public static final Creator CREATOR = new a();
    @SerializedName("anchor")
    private final PopupAnchor aWZ;
    @SerializedName("fields")
    private final Map<String, String> aXa;
    @SerializedName("format_id")
    private final int aXb;
    @SerializedName("format_name")
    private final PopupFormat aXc;
    @SerializedName("format_version")
    private final int aXd;
    @SerializedName("available_events")
    private final List<String> aXe;
    @SerializedName("id")
    private final long id;
    @SerializedName("locale")
    private final String locale;
    @SerializedName("name")
    private final String name;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            PopupAnchor popupAnchor;
            h.e(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                popupAnchor = (PopupAnchor) Enum.valueOf(PopupAnchor.class, parcel.readString());
            } else {
                popupAnchor = null;
            }
            PopupAnchor popupAnchor2 = popupAnchor;
            int readInt = parcel.readInt();
            Map linkedHashMap = new LinkedHashMap(readInt);
            while (readInt != 0) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
                readInt--;
            }
            return new a(readLong, readString, popupAnchor2, linkedHashMap, parcel.readInt(), (PopupFormat) Enum.valueOf(PopupFormat.class, parcel.readString()), parcel.readString(), parcel.readInt(), parcel.createStringArrayList());
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if ((Jf().longValue() == aVar.Jf().longValue() ? 1 : null) != null && h.E(this.name, aVar.name) && h.E(this.aWZ, aVar.aWZ) && h.E(this.aXa, aVar.aXa)) {
                if ((this.aXb == aVar.aXb ? 1 : null) != null && h.E(this.aXc, aVar.aXc) && h.E(this.locale, aVar.locale)) {
                    return (this.aXd == aVar.aXd ? 1 : null) != null && h.E(this.aXe, aVar.aXe);
                }
            }
        }
    }

    public int hashCode() {
        long longValue = Jf().longValue();
        int i = ((int) (longValue ^ (longValue >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        PopupAnchor popupAnchor = this.aWZ;
        i = (i + (popupAnchor != null ? popupAnchor.hashCode() : 0)) * 31;
        Map map = this.aXa;
        i = (((i + (map != null ? map.hashCode() : 0)) * 31) + this.aXb) * 31;
        PopupFormat popupFormat = this.aXc;
        i = (i + (popupFormat != null ? popupFormat.hashCode() : 0)) * 31;
        str = this.locale;
        i = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.aXd) * 31;
        List list = this.aXe;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Popup(id=");
        stringBuilder.append(Jf());
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", anchor=");
        stringBuilder.append(this.aWZ);
        stringBuilder.append(", fields=");
        stringBuilder.append(this.aXa);
        stringBuilder.append(", formatId=");
        stringBuilder.append(this.aXb);
        stringBuilder.append(", formatName=");
        stringBuilder.append(this.aXc);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", formatVersion=");
        stringBuilder.append(this.aXd);
        stringBuilder.append(", availableEvents=");
        stringBuilder.append(this.aXe);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        Enum enumR = this.aWZ;
        if (enumR != null) {
            parcel.writeInt(1);
            parcel.writeString(enumR.name());
        } else {
            parcel.writeInt(0);
        }
        Map map = this.aXa;
        parcel.writeInt(map.size());
        for (Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
        parcel.writeInt(this.aXb);
        parcel.writeString(this.aXc.name());
        parcel.writeString(this.locale);
        parcel.writeInt(this.aXd);
        parcel.writeStringList(this.aXe);
    }

    public a(long j, String str, PopupAnchor popupAnchor, Map<String, String> map, int i, PopupFormat popupFormat, String str2, int i2, List<String> list) {
        h.e(str, "name");
        h.e(map, "fields");
        h.e(popupFormat, "formatName");
        h.e(str2, "locale");
        h.e(list, "availableEvents");
        this.id = j;
        this.name = str;
        this.aWZ = popupAnchor;
        this.aXa = map;
        this.aXb = i;
        this.aXc = popupFormat;
        this.locale = str2;
        this.aXd = i2;
        this.aXe = list;
    }

    /* renamed from: getId */
    public Long Jf() {
        return Long.valueOf(this.id);
    }

    public /* synthetic */ a(long j, String str, PopupAnchor popupAnchor, Map map, int i, PopupFormat popupFormat, String str2, int i2, List list, int i3, f fVar) {
        int i4 = i3;
        this((i4 & 1) != 0 ? -1 : j, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? (PopupAnchor) null : popupAnchor, (i4 & 8) != 0 ? ad.emptyMap() : map, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? PopupFormat.UNKNOWN : popupFormat, (i4 & 64) != 0 ? "" : str2, (i4 & 128) != 0 ? 0 : i2, (i4 & 256) != 0 ? m.emptyList() : list);
    }

    public final PopupAnchor Wr() {
        return this.aWZ;
    }

    public final Map<String, String> Ws() {
        return this.aXa;
    }

    public final PopupFormat Wt() {
        return this.aXc;
    }

    public a() {
        this(-1, null, null, null, 0, null, null, 0, null, 510, null);
    }
}
