package com.iqoption.core.microservices.videoeducation.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0017J\t\u00107\u001a\u00020\u0004HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eHÂ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0004HÂ\u0003¢\u0006\u0002\u0010:J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\fHÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eHÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eHÂ\u0003J\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010DJ\t\u0010E\u001a\u00020\fHÖ\u0001J\u0013\u0010F\u001a\u00020\b2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\u0006\u0010I\u001a\u00020\u0004J\t\u0010J\u001a\u00020\fHÖ\u0001J\t\u0010K\u001a\u00020\u0006HÖ\u0001J\u0019\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\fHÖ\u0001R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001dR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001dR#\u0010\u001e\u001a\u0004\u0018\u00010\f8FX\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010!R#\u0010$\u001a\u0004\u0018\u00010\u00068FX\u0002¢\u0006\u0012\n\u0004\b(\u0010#\u0012\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010'R#\u0010)\u001a\u0004\u0018\u00010\u00068FX\u0002¢\u0006\u0012\n\u0004\b,\u0010#\u0012\u0004\b*\u0010\u0002\u001a\u0004\b+\u0010'R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R#\u0010.\u001a\u0004\u0018\u00010\u00158BX\u0002¢\u0006\u0012\n\u0004\b2\u0010#\u0012\u0004\b/\u0010\u0002\u001a\u0004\b0\u00101R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0019R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006Q"}, aXE = {"Lcom/iqoption/core/microservices/videoeducation/response/Video;", "Landroid/os/Parcelable;", "()V", "id", "", "localizedTitle", "", "isNew", "", "isWatched", "platform", "weight", "", "categories", "", "Lcom/iqoption/core/microservices/videoeducation/response/Category;", "tags", "Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "imageLinks", "Lcom/iqoption/core/microservices/videoeducation/response/ImageLink;", "videoLinks", "Lcom/iqoption/core/microservices/videoeducation/response/VideoLink;", "createdAt", "(JLjava/lang/String;ZZLjava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)V", "getCategories", "()Ljava/util/List;", "Ljava/lang/Long;", "getId", "()J", "()Z", "localizedDuration", "localizedDuration$annotations", "getLocalizedDuration", "()Ljava/lang/Integer;", "localizedDuration$delegate", "Lkotlin/Lazy;", "localizedIcon", "localizedIcon$annotations", "getLocalizedIcon", "()Ljava/lang/String;", "localizedIcon$delegate", "localizedPath", "localizedPath$annotations", "getLocalizedPath", "localizedPath$delegate", "getLocalizedTitle", "localizedVideoLink", "localizedVideoLink$annotations", "getLocalizedVideoLink", "()Lcom/iqoption/core/microservices/videoeducation/response/VideoLink;", "localizedVideoLink$delegate", "getPlatform", "getTags", "getWeight", "()I", "component1", "component10", "component11", "()Ljava/lang/Long;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;ZZLjava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)Lcom/iqoption/core/microservices/videoeducation/response/Video;", "describeContents", "equals", "other", "", "getCreatedAt", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: Video.kt */
public final class g implements Parcelable {
    public static final Creator CREATOR = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "localizedVideoLink", "getLocalizedVideoLink()Lcom/iqoption/core/microservices/videoeducation/response/VideoLink;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "localizedDuration", "getLocalizedDuration()Ljava/lang/Integer;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "localizedPath", "getLocalizedPath()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(g.class), "localizedIcon", "getLocalizedIcon()Ljava/lang/String;"))};
    private final transient d aZC;
    @SerializedName("locale_title")
    private final String aZD;
    @SerializedName("images")
    private final List<b> aZE;
    @SerializedName("platform")
    private final String aZG;
    private final transient d aZJ;
    private final transient d aZK;
    private final transient d aZL;
    @SerializedName("watched")
    private final boolean aZM;
    @SerializedName("video_locales")
    private final List<h> aZN;
    @SerializedName("created_at")
    private final Long aZO;
    @SerializedName("categories")
    private final List<a> asQ;
    @SerializedName("tags")
    private final List<f> gD;
    @SerializedName("id")
    private final long id;
    @SerializedName("new")
    private final boolean isNew;
    @SerializedName("weight")
    private final int weight;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Long valueOf;
            Parcel parcel2 = parcel;
            h.e(parcel2, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((a) a.CREATOR.createFromParcel(parcel2));
                readInt2--;
            }
            readInt2 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList3.add((f) f.CREATOR.createFromParcel(parcel2));
                readInt2--;
            }
            readInt2 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList4.add((b) b.CREATOR.createFromParcel(parcel2));
                readInt2--;
            }
            readInt2 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList5.add((h) h.CREATOR.createFromParcel(parcel2));
                readInt2--;
            }
            if (parcel.readInt() != 0) {
                arrayList = arrayList5;
                valueOf = Long.valueOf(parcel.readLong());
            } else {
                arrayList = arrayList5;
                valueOf = null;
            }
            return new g(readLong, readString, z2, z, readString2, readInt, arrayList2, arrayList3, arrayList4, arrayList, valueOf);
        }

        public final Object[] newArray(int i) {
            return new g[i];
        }
    }

    private final h XS() {
        d dVar = this.aZJ;
        j jVar = apP[0];
        return (h) dVar.getValue();
    }

    public static /* bridge */ /* synthetic */ g a(g gVar, long j, String str, boolean z, boolean z2, String str2, int i, List list, List list2, List list3, List list4, Long l, int i2, Object obj) {
        g gVar2 = gVar;
        int i3 = i2;
        return gVar2.a((i3 & 1) != 0 ? gVar2.id : j, (i3 & 2) != 0 ? gVar2.aZD : str, (i3 & 4) != 0 ? gVar2.isNew : z, (i3 & 8) != 0 ? gVar2.aZM : z2, (i3 & 16) != 0 ? gVar2.aZG : str2, (i3 & 32) != 0 ? gVar2.weight : i, (i3 & 64) != 0 ? gVar2.asQ : list, (i3 & 128) != 0 ? gVar2.gD : list2, (i3 & 256) != 0 ? gVar2.aZE : list3, (i3 & 512) != 0 ? gVar2.aZN : list4, (i3 & 1024) != 0 ? gVar2.aZO : l);
    }

    public final String XQ() {
        d dVar = this.aZC;
        j jVar = apP[3];
        return (String) dVar.getValue();
    }

    public final Integer XT() {
        d dVar = this.aZK;
        j jVar = apP[1];
        return (Integer) dVar.getValue();
    }

    public final String XU() {
        d dVar = this.aZL;
        j jVar = apP[2];
        return (String) dVar.getValue();
    }

    public final g a(long j, String str, boolean z, boolean z2, String str2, int i, List<a> list, List<f> list2, List<b> list3, List<h> list4, Long l) {
        String str3 = str;
        h.e(str3, "localizedTitle");
        String str4 = str2;
        h.e(str4, "platform");
        List<a> list5 = list;
        h.e(list5, "categories");
        List<f> list6 = list2;
        h.e(list6, "tags");
        List<b> list7 = list3;
        h.e(list7, "imageLinks");
        List<h> list8 = list4;
        h.e(list8, "videoLinks");
        return new g(j, str3, z, z2, str4, i, list5, list6, list7, list8, l);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if ((this.id == gVar.id ? 1 : null) != null && h.E(this.aZD, gVar.aZD)) {
                if ((this.isNew == gVar.isNew ? 1 : null) != null) {
                    if ((this.aZM == gVar.aZM ? 1 : null) != null && h.E(this.aZG, gVar.aZG)) {
                        return (this.weight == gVar.weight ? 1 : null) != null && h.E(this.asQ, gVar.asQ) && h.E(this.gD, gVar.gD) && h.E(this.aZE, gVar.aZE) && h.E(this.aZN, gVar.aZN) && h.E(this.aZO, gVar.aZO);
                    }
                }
            }
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.aZD;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        int i3 = this.isNew;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.aZM;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        str = this.aZG;
        i = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.weight) * 31;
        List list = this.asQ;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.gD;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.aZE;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.aZN;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        Long l = this.aZO;
        if (l != null) {
            i2 = l.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Video(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", localizedTitle=");
        stringBuilder.append(this.aZD);
        stringBuilder.append(", isNew=");
        stringBuilder.append(this.isNew);
        stringBuilder.append(", isWatched=");
        stringBuilder.append(this.aZM);
        stringBuilder.append(", platform=");
        stringBuilder.append(this.aZG);
        stringBuilder.append(", weight=");
        stringBuilder.append(this.weight);
        stringBuilder.append(", categories=");
        stringBuilder.append(this.asQ);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.gD);
        stringBuilder.append(", imageLinks=");
        stringBuilder.append(this.aZE);
        stringBuilder.append(", videoLinks=");
        stringBuilder.append(this.aZN);
        stringBuilder.append(", createdAt=");
        stringBuilder.append(this.aZO);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.aZD);
        parcel.writeInt(this.isNew);
        parcel.writeInt(this.aZM);
        parcel.writeString(this.aZG);
        parcel.writeInt(this.weight);
        Collection<a> collection = this.asQ;
        parcel.writeInt(collection.size());
        for (a writeToParcel : collection) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        Collection<f> collection2 = this.gD;
        parcel.writeInt(collection2.size());
        for (f writeToParcel2 : collection2) {
            writeToParcel2.writeToParcel(parcel, 0);
        }
        Collection<b> collection3 = this.aZE;
        parcel.writeInt(collection3.size());
        for (b writeToParcel3 : collection3) {
            writeToParcel3.writeToParcel(parcel, 0);
        }
        Collection<h> collection4 = this.aZN;
        parcel.writeInt(collection4.size());
        for (h writeToParcel4 : collection4) {
            writeToParcel4.writeToParcel(parcel, 0);
        }
        Long l = this.aZO;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
            return;
        }
        parcel.writeInt(0);
    }

    public g(long j, String str, boolean z, boolean z2, String str2, int i, List<a> list, List<f> list2, List<b> list3, List<h> list4, Long l) {
        h.e(str, "localizedTitle");
        h.e(str2, "platform");
        h.e(list, "categories");
        h.e(list2, "tags");
        h.e(list3, "imageLinks");
        h.e(list4, "videoLinks");
        this.id = j;
        this.aZD = str;
        this.isNew = z;
        this.aZM = z2;
        this.aZG = str2;
        this.weight = i;
        this.asQ = list;
        this.gD = list2;
        this.aZE = list3;
        this.aZN = list4;
        this.aZO = l;
        this.aZJ = g.f(new Video$localizedVideoLink$2(this));
        this.aZK = g.f(new Video$localizedDuration$2(this));
        this.aZL = g.f(new Video$localizedPath$2(this));
        this.aZC = g.f(new Video$localizedIcon$2(this));
    }

    public final long getId() {
        return this.id;
    }

    public final String Mi() {
        return this.aZD;
    }

    public final boolean XV() {
        return this.isNew;
    }

    public final boolean XW() {
        return this.aZM;
    }

    public final int getWeight() {
        return this.weight;
    }

    public /* synthetic */ g(long j, String str, boolean z, boolean z2, String str2, int i, List list, List list2, List list3, List list4, Long l, int i2, f fVar) {
        int i3 = i2;
        this((i3 & 1) != 0 ? -1 : j, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? "mobile" : str2, (i3 & 32) != 0 ? 0 : i, (i3 & 64) != 0 ? m.emptyList() : list, (i3 & 128) != 0 ? m.emptyList() : list2, (i3 & 256) != 0 ? m.emptyList() : list3, (i3 & 512) != 0 ? m.emptyList() : list4, (i3 & 1024) != 0 ? (Long) null : l);
    }

    public final List<a> Kj() {
        return this.asQ;
    }

    public final List<f> XX() {
        return this.gD;
    }

    public g() {
        this(-1, null, false, false, null, 0, null, null, null, null, null, 2046, null);
    }

    public final long Wh() {
        return this.aZO != null ? this.aZO.longValue() * ((long) 1000) : 0;
    }
}
