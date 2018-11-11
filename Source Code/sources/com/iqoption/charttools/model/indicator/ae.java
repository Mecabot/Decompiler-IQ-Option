package com.iqoption.charttools.model.indicator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.c;
import com.iqoption.core.ext.d;
import com.iqoption.core.microservices.techinstruments.a.b;
import com.iqoption.core.microservices.videoeducation.response.g;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\b\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bB\u000f\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eBq\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u001aJ\t\u0010.\u001a\u00020\u0010HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0016HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00105\u001a\u00020\u0019HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003Ju\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\b\u00108\u001a\u00020\u0016H\u0016J\u0013\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\b\u0010<\u001a\u00020\u001cH\u0016J\n\u0010=\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010>\u001a\u00020\u0012H\u0016J\b\u0010?\u001a\u00020\u0016H\u0016J\b\u0010@\u001a\u00020\u0012H\u0016J\u000f\u0010A\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010BJ\n\u0010C\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010D\u001a\u00020\u0016H\u0016J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J\t\u0010I\u001a\u00020\u0012HÖ\u0001J\u0018\u0010J\u001a\u00020K2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u0016H\u0016J\u0018\u0010M\u001a\u00020K2\u0006\u0010G\u001a\u00020H2\u0006\u0010N\u001a\u00020FH\u0016R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u00020\u00198\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0014\u0010*\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\"R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006P"}, aXE = {"Lcom/iqoption/charttools/model/indicator/ScriptedIndicator;", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "Landroid/os/Parcelable;", "()V", "indicator", "Lcom/iqoption/core/microservices/techinstruments/response/Indicator;", "video", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "categories", "", "Lcom/iqoption/charttools/model/IndicatorCategory;", "(Lcom/iqoption/core/microservices/techinstruments/response/Indicator;Lcom/iqoption/core/microservices/videoeducation/response/Video;Ljava/util/Set;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "name", "", "description", "iconUrl", "instanceCount", "", "suppressedLocal", "canHostFigures", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iqoption/core/microservices/videoeducation/response/Video;ILjava/lang/String;ZLjava/util/Set;)V", "cachedIcon", "Lcom/iqoption/core/data/model/UrlOrRes;", "getCanHostFigures", "()Z", "getCategories", "()Ljava/util/Set;", "getDescription", "()Ljava/lang/String;", "getIconUrl", "getId", "()J", "getInstanceCount", "()I", "getName", "getSuppressedLocal", "uid", "getUid", "getVideo", "()Lcom/iqoption/core/microservices/videoeducation/response/Video;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getIcon", "getInfo", "getLocalizedTitle", "getMaxInstances", "getStaticTitle", "getVideoDuration", "()Ljava/lang/Integer;", "getVideoUrl", "hashCode", "parseValues", "Lcom/google/gson/JsonArray;", "json", "Lcom/google/gson/JsonObject;", "toString", "writeToParcel", "", "flags", "writeValues", "values", "CREATOR", "techtools_release"})
/* compiled from: MetaIndicator.kt */
public final class ae extends x implements Parcelable {
    public static final a CREATOR = new a();
    private c ayA;
    @SerializedName("video")
    private final g ayK;
    @SerializedName("instCount")
    private final int ayL;
    @SerializedName("suppress")
    private final String ayM;
    @SerializedName("canHostFigures")
    private final boolean ayN;
    private final transient Set<com.iqoption.charttools.model.a> ayO;
    @SerializedName("desc")
    private final String description;
    @SerializedName("icon")
    private final String iconUrl;
    @SerializedName("id")
    private final long id;
    @SerializedName("name")
    private final String name;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, aXE = {"Lcom/iqoption/charttools/model/indicator/ScriptedIndicator$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/charttools/model/indicator/ScriptedIndicator;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/iqoption/charttools/model/indicator/ScriptedIndicator;", "techtools_release"})
    /* compiled from: MetaIndicator.kt */
    public static final class a implements Creator<ae> {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        /* renamed from: F */
        public ae createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new ae(parcel);
        }

        /* renamed from: dp */
        public ae[] newArray(int i) {
            return new ae[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScriptedIndicator(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", video=");
        stringBuilder.append(this.ayK);
        stringBuilder.append(", instanceCount=");
        stringBuilder.append(this.ayL);
        stringBuilder.append(", suppressedLocal=");
        stringBuilder.append(this.ayM);
        stringBuilder.append(", canHostFigures=");
        stringBuilder.append(LY());
        stringBuilder.append(", categories=");
        stringBuilder.append(this.ayO);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ ae(long j, String str, String str2, String str3, g gVar, int i, String str4, boolean z, Set set, int i2, f fVar) {
        int i3 = i2;
        this((i3 & 1) != 0 ? -1 : j, (i3 & 2) != 0 ? (String) null : str, (i3 & 4) != 0 ? (String) null : str2, (i3 & 8) != 0 ? (String) null : str3, (i3 & 16) != 0 ? (g) null : gVar, (i3 & 32) != 0 ? 1 : i, (i3 & 64) != 0 ? (String) null : str4, (i3 & 128) != 0 ? false : z, (i3 & 256) != 0 ? (Set) null : set);
    }

    public final String Mo() {
        return this.ayM;
    }

    public boolean LY() {
        return this.ayN;
    }

    public final Set<com.iqoption.charttools.model.a> getCategories() {
        return this.ayO;
    }

    public ae(long j, String str, String str2, String str3, g gVar, int i, String str4, boolean z, Set<com.iqoption.charttools.model.a> set) {
        super("Scripted", null);
        this.id = j;
        this.name = str;
        this.description = str2;
        this.iconUrl = str3;
        this.ayK = gVar;
        this.ayL = i;
        this.ayM = str4;
        this.ayN = z;
        this.ayO = set;
    }

    public String Ml() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.Ml());
        stringBuilder.append(':');
        stringBuilder.append(this.id);
        return stringBuilder.toString();
    }

    public ae() {
        this(-1, null, null, null, null, 0, null, false, null, 510, null);
    }

    public ae(b bVar, g gVar, Set<com.iqoption.charttools.model.a> set) {
        h.e(bVar, "indicator");
        long id = bVar.getId();
        String name = bVar.getName();
        String description = bVar.getDescription();
        String iconUrl = bVar.getIconUrl();
        if ((((CharSequence) iconUrl).length() > 0 ? 1 : null) == null) {
            iconUrl = null;
        }
        this(id, name, description, iconUrl, gVar, bVar.WR(), bVar.Mo(), bVar.LY(), set);
    }

    public ae(Parcel parcel) {
        h.e(parcel, "parcel");
        long readLong = parcel.readLong();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        g gVar = (g) parcel.readParcelable(g.class.getClassLoader());
        int readInt = parcel.readInt();
        String readString4 = parcel.readString();
        if (readString4 == null) {
            h.aXZ();
        }
        this(readLong, readString, readString2, readString3, gVar, readInt, readString4, parcel.readByte() != ((byte) 0), com.iqoption.core.ext.a.a(parcel, com.iqoption.charttools.model.a.class.getClassLoader()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.iconUrl);
        parcel.writeParcelable(this.ayK, i);
        parcel.writeInt(this.ayL);
        parcel.writeString(this.ayM);
        parcel.writeByte(LY());
        com.iqoption.core.ext.a.a(parcel, this.ayO, i);
    }

    public JsonArray b(JsonObject jsonObject) {
        h.e(jsonObject, "json");
        return d.a(jsonObject, "values", null, 2, null);
    }

    public void a(JsonObject jsonObject, JsonArray jsonArray) {
        h.e(jsonObject, "json");
        h.e(jsonArray, "values");
        jsonObject.add("values", jsonArray);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.model.indicator.ScriptedIndicator");
        }
        if (this.id != ((ae) obj).id) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Long.valueOf(this.id).hashCode();
    }

    public String Mi() {
        return com.iqoption.core.ext.c.gr(this.name);
    }

    public String getInfo() {
        return com.iqoption.core.ext.c.gr(this.description);
    }

    public c Mj() {
        c cVar = this.ayA;
        if (cVar != null) {
            return cVar;
        }
        cVar = new c(this.iconUrl, 0, 2, null);
        this.ayA = cVar;
        return cVar;
    }

    public String Mk() {
        g gVar = this.ayK;
        return gVar != null ? gVar.XU() : null;
    }

    public int LZ() {
        return this.ayL != 0 ? this.ayL : ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }
}
