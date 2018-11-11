package com.iqoption.core.microservices.avatar;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: Avatar */
public final class a {
    private Status aSV;
    private ValidateStatus aSW;
    @SerializedName("crop")
    private b aSX;
    @SerializedName("id")
    private String id;
    @SerializedName("thumbnails")
    private List<d> thumbnails;
    @SerializedName("url")
    private String url;

    @Nullable
    public d ai(int i, int i2) {
        i *= i2;
        d dVar = null;
        if (this.thumbnails != null) {
            for (d a : this.thumbnails) {
                dVar = a(dVar, a, i);
            }
        }
        return dVar;
    }

    private d a(@Nullable d dVar, @NonNull d dVar2, int i) {
        if (dVar == null) {
            return dVar2;
        }
        float f = (float) i;
        return ((float) dVar.Uu()) / f < ((float) dVar2.Uu()) / f ? dVar : dVar2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.id == null ? this.id.equals(aVar.id) : aVar.id == null) {
            return false;
        }
        if (!this.aSV == null ? this.aSV.equals(aVar.aSV) : aVar.aSV == null) {
            return false;
        }
        if (!this.aSW == null ? this.aSW.equals(aVar.aSW) : aVar.aSW == null) {
            return false;
        }
        if (!this.url == null ? this.url.equals(aVar.url) : aVar.url == null) {
            return false;
        }
        if (!this.aSX == null ? this.aSX.equals(aVar.aSX) : aVar.aSX == null) {
            return false;
        }
        if (this.thumbnails != null) {
            z = this.thumbnails.equals(aVar.thumbnails);
        } else if (aVar.thumbnails != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((this.id != null ? this.id.hashCode() : 0) * 31) + (this.aSV != null ? this.aSV.hashCode() : 0)) * 31) + (this.aSW != null ? this.aSW.hashCode() : 0)) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + (this.aSX != null ? this.aSX.hashCode() : 0)) * 31;
        if (this.thumbnails != null) {
            i = this.thumbnails.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Avatar{id='");
        stringBuilder.append(this.id);
        stringBuilder.append('\'');
        stringBuilder.append(", status='");
        stringBuilder.append(this.aSV);
        stringBuilder.append('\'');
        stringBuilder.append(", validateStatus='");
        stringBuilder.append(this.aSW);
        stringBuilder.append('\'');
        stringBuilder.append(", url='");
        stringBuilder.append(this.url);
        stringBuilder.append('\'');
        stringBuilder.append(", crop=");
        stringBuilder.append(this.aSX);
        stringBuilder.append(", thumbnails=");
        stringBuilder.append(this.thumbnails);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
