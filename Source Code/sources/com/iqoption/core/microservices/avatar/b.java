package com.iqoption.core.microservices.avatar;

import com.google.gson.annotations.SerializedName;

/* compiled from: Crop */
public final class b {
    @SerializedName("height")
    private int height;
    @SerializedName("width")
    private int width;
    @SerializedName("x")
    private int x;
    @SerializedName("y")
    private int y;

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.x != bVar.x || this.y != bVar.y || this.width != bVar.width) {
            return false;
        }
        if (this.height != bVar.height) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((this.x * 31) + this.y) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crop{x=");
        stringBuilder.append(this.x);
        stringBuilder.append(", y=");
        stringBuilder.append(this.y);
        stringBuilder.append(", width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
