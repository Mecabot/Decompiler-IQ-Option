package com.iqoption.core.microservices.avatar;

import com.google.gson.annotations.SerializedName;

/* compiled from: Thumbnail */
public final class d {
    @SerializedName("size")
    private c aSY;
    @SerializedName("url")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public int Uu() {
        return this.aSY != null ? this.aSY.Uu() : 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.url == null ? this.url.equals(dVar.url) : dVar.url == null) {
            return false;
        }
        if (this.aSY != null) {
            z = this.aSY.equals(dVar.aSY);
        } else if (dVar.aSY != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.url != null ? this.url.hashCode() : 0) * 31;
        if (this.aSY != null) {
            i = this.aSY.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thumbnail{url='");
        stringBuilder.append(this.url);
        stringBuilder.append('\'');
        stringBuilder.append(", size=");
        stringBuilder.append(this.aSY);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
