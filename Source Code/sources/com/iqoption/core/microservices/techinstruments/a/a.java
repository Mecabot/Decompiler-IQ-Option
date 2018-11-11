package com.iqoption.core.microservices.techinstruments.a;

import com.google.android.gms.plus.PlusShare;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, aXE = {"Lcom/iqoption/core/microservices/techinstruments/response/Category;", "", "()V", "id", "", "name", "", "description", "iconUrl", "indicatorIds", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "getIconUrl", "getId", "()J", "getIndicatorIds", "()Ljava/util/List;", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"})
/* compiled from: Category.kt */
public final class a {
    @SerializedName("indicators")
    private final List<Long> aXX;
    @SerializedName("description")
    private final String description;
    @SerializedName("icon_url")
    private final String iconUrl;
    @SerializedName("id")
    private final long id;
    @SerializedName("name")
    private final String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return ((this.id > aVar.id ? 1 : (this.id == aVar.id ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.name, aVar.name) && h.E(this.description, aVar.description) && h.E(this.iconUrl, aVar.iconUrl) && h.E(this.aXX, aVar.aXX);
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.description;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.iconUrl;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.aXX;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Category(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", indicatorIds=");
        stringBuilder.append(this.aXX);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(long j, String str, String str2, String str3, List<Long> list) {
        h.e(str, "name");
        h.e(str2, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        h.e(str3, "iconUrl");
        h.e(list, "indicatorIds");
        this.id = j;
        this.name = str;
        this.description = str2;
        this.iconUrl = str3;
        this.aXX = list;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public /* synthetic */ a(long j, String str, String str2, String str3, List list, int i, f fVar) {
        if ((i & 1) != 0) {
            j = -1;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = "";
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = "";
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = "";
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            list = m.emptyList();
        }
        this(j2, str4, str5, str6, list);
    }

    public final List<Long> WP() {
        return this.aXX;
    }

    public a() {
        this(-1, null, null, null, null, 30, null);
    }
}
