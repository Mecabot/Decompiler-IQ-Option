package com.iqoption.core.microservices.avatar;

import com.google.gson.annotations.SerializedName;

/* compiled from: Size */
public final class c {
    @SerializedName("height")
    private int height;
    @SerializedName("width")
    private int width;

    public int Uu() {
        return this.width * this.height;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.width != cVar.width) {
            return false;
        }
        if (this.height != cVar.height) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size{width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
