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

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bHÂ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÂ\u0003J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J=\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020#HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020#HÖ\u0001R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0004¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\u0004\u0018\u00010\u00068FX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0014\u001a\u0004\u0018\u00010\u00068FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006."}, aXE = {"Lcom/iqoption/core/microservices/videoeducation/response/Category;", "Landroid/os/Parcelable;", "()V", "id", "", "localizedTitle", "", "imageLinks", "", "Lcom/iqoption/core/microservices/videoeducation/response/ImageLink;", "iconLinks", "(JLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()J", "localizedIcon", "localizedIcon$annotations", "getLocalizedIcon", "()Ljava/lang/String;", "localizedIcon$delegate", "Lkotlin/Lazy;", "localizedImage", "localizedImage$annotations", "getLocalizedImage", "localizedImage$delegate", "getLocalizedTitle", "component1", "component2", "component3", "component4", "contains", "", "video", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: Category.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "localizedImage", "getLocalizedImage()Ljava/lang/String;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "localizedIcon", "getLocalizedIcon()Ljava/lang/String;"))};
    private final transient d aZB;
    private final transient d aZC;
    @SerializedName("locale_title")
    private final String aZD;
    @SerializedName("images")
    private final List<b> aZE;
    @SerializedName("icons")
    private final List<b> aZF;
    @SerializedName("id")
    private final long id;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            List arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((b) b.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            readInt = parcel.readInt();
            List arrayList2 = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList2.add((b) b.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new a(readLong, readString, arrayList, arrayList2);
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public final String XQ() {
        d dVar = this.aZC;
        j jVar = apP[1];
        return (String) dVar.getValue();
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
            return ((this.id > aVar.id ? 1 : (this.id == aVar.id ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.aZD, aVar.aZD) && h.E(this.aZE, aVar.aZE) && h.E(this.aZF, aVar.aZF);
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.aZD;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.aZE;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.aZF;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Category(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", localizedTitle=");
        stringBuilder.append(this.aZD);
        stringBuilder.append(", imageLinks=");
        stringBuilder.append(this.aZE);
        stringBuilder.append(", iconLinks=");
        stringBuilder.append(this.aZF);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.aZD);
        Collection<b> collection = this.aZE;
        parcel.writeInt(collection.size());
        for (b writeToParcel : collection) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        collection = this.aZF;
        parcel.writeInt(collection.size());
        for (b writeToParcel2 : collection) {
            writeToParcel2.writeToParcel(parcel, 0);
        }
    }

    public a(long j, String str, List<b> list, List<b> list2) {
        h.e(str, "localizedTitle");
        h.e(list, "imageLinks");
        h.e(list2, "iconLinks");
        this.id = j;
        this.aZD = str;
        this.aZE = list;
        this.aZF = list2;
        this.aZB = g.f(new Category$localizedImage$2(this));
        this.aZC = g.f(new Category$localizedIcon$2(this));
    }

    public final long getId() {
        return this.id;
    }

    public final String Mi() {
        return this.aZD;
    }

    public /* synthetic */ a(long j, String str, List list, List list2, int i, f fVar) {
        if ((i & 1) != 0) {
            j = -1;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list = m.emptyList();
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = m.emptyList();
        }
        this(j2, str2, list3, list2);
    }

    public a() {
        this(-1, null, null, null, 14, null);
    }

    public final boolean a(g gVar) {
        h.e(gVar, "video");
        for (Object next : gVar.Kj()) {
            Object obj;
            if (((a) next).id == this.id) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        return next2 != null;
    }
}
