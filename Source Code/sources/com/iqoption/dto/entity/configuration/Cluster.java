package com.iqoption.dto.entity.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import okhttp3.HttpUrl.Builder;

public class Cluster implements Parcelable {
    public static final Creator<Cluster> CREATOR = new Creator<Cluster>() {
        public Cluster createFromParcel(Parcel parcel) {
            return new Cluster(parcel);
        }

        public Cluster[] newArray(int i) {
            return new Cluster[i];
        }
    };
    @Nullable
    @SerializedName("host")
    private String host;
    @Nullable
    @SerializedName("port")
    private Integer port;
    @Nullable
    @SerializedName("protocol")
    private String protocol;

    public int describeContents() {
        return 0;
    }

    @Nullable
    public String buildUrl() {
        if (this.protocol == null || this.host == null || this.port == null) {
            return null;
        }
        if (this.protocol.equals("wss")) {
            this.protocol = "https";
        } else if (this.protocol.equals("ws")) {
            this.protocol = "http";
        }
        return new Builder().scheme(this.protocol).host(this.host).port(this.port.intValue()).build().toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cluster{protocol='");
        stringBuilder.append(this.protocol);
        stringBuilder.append('\'');
        stringBuilder.append(", host='");
        stringBuilder.append(this.host);
        stringBuilder.append('\'');
        stringBuilder.append(", port=");
        stringBuilder.append(this.port);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cluster)) {
            return false;
        }
        Cluster cluster = (Cluster) obj;
        if (!this.protocol == null ? this.protocol.equals(cluster.protocol) : cluster.protocol == null) {
            return false;
        }
        if (!this.host == null ? this.host.equals(cluster.host) : cluster.host == null) {
            return false;
        }
        if (this.port != null) {
            z = this.port.equals(cluster.port);
        } else if (cluster.port != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((this.protocol != null ? this.protocol.hashCode() : 0) * 31) + (this.host != null ? this.host.hashCode() : 0)) * 31;
        if (this.port != null) {
            i = this.port.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.protocol);
        parcel.writeString(this.host);
        parcel.writeValue(this.port);
    }

    protected Cluster(Parcel parcel) {
        this.protocol = parcel.readString();
        this.host = parcel.readString();
        this.port = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
