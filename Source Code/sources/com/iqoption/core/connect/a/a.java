package com.iqoption.core.connect.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.HttpUrl.Builder;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0004HÂ\u0003J\t\u0010\r\u001a\u00020\u0004HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÂ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0010\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, aXE = {"Lcom/iqoption/core/connect/dto/Cluster;", "", "()V", "protocol", "", "host", "port", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "url", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "core_release"})
/* compiled from: Cluster.kt */
public final class a {
    @SerializedName("host")
    private final String host;
    @SerializedName("port")
    private final int port;
    @SerializedName("protocol")
    private final String protocol;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (h.E(this.protocol, aVar.protocol) && h.E(this.host, aVar.host)) {
                if ((this.port == aVar.port ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.protocol;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.host;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.port;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cluster(protocol=");
        stringBuilder.append(this.protocol);
        stringBuilder.append(", host=");
        stringBuilder.append(this.host);
        stringBuilder.append(", port=");
        stringBuilder.append(this.port);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(String str, String str2, int i) {
        h.e(str, "protocol");
        h.e(str2, "host");
        this.protocol = str;
        this.host = str2;
        this.port = i;
    }

    public /* synthetic */ a(String str, String str2, int i, int i2, f fVar) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(str, str2, i);
    }

    public a() {
        this("", null, 0, 6, null);
    }

    public final String getUrl() {
        String str = this.protocol;
        int hashCode = str.hashCode();
        if (hashCode != 3804) {
            if (hashCode == 118039 && str.equals("wss")) {
                str = "https";
                str = new Builder().scheme(str).host(this.host).port(this.port).build().toString();
                h.d(str, "HttpUrl.Builder()\n      …              .toString()");
                return str;
            }
        } else if (str.equals("ws")) {
            str = "http";
            str = new Builder().scheme(str).host(this.host).port(this.port).build().toString();
            h.d(str, "HttpUrl.Builder()\n      …              .toString()");
            return str;
        }
        str = this.protocol;
        str = new Builder().scheme(str).host(this.host).port(this.port).build().toString();
        h.d(str, "HttpUrl.Builder()\n      …              .toString()");
        return str;
    }
}
