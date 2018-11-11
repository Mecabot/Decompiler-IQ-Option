package com.iqoption.dto.entity.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.connect.a;

public class Configuration implements Parcelable, a {
    public static final Creator<Configuration> CREATOR = new Creator<Configuration>() {
        public Configuration createFromParcel(Parcel parcel) {
            return new Configuration(parcel);
        }

        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    @Nullable
    @SerializedName("auth_api")
    private String authApi;
    @Nullable
    @SerializedName("avatars_api")
    private String avatarsApi;
    @Nullable
    @SerializedName("chat_api")
    private String chatApi;
    @Nullable
    @SerializedName("trading_cluster_api")
    private Cluster clusterApi;
    @Nullable
    @SerializedName("trading_cluster_websocket")
    private Cluster clusterWebsocket;
    @Nullable
    @SerializedName("event_api")
    private String eventApi;
    @Nullable
    @SerializedName("tc")
    private Boolean tc;
    @Nullable
    @SerializedName("user_verify_api")
    private String userVerifyApi;
    @Nullable
    @SerializedName("wallet_referral_api")
    private String walletReferralApi;

    public int describeContents() {
        return 0;
    }

    public void setAuthApi(String str) {
        this.authApi = str;
    }

    public void setAvatarsApi(String str) {
        this.avatarsApi = str;
    }

    public void setClusterApi(Cluster cluster) {
        this.clusterApi = cluster;
    }

    public void setClusterWebsocket(Cluster cluster) {
        this.clusterWebsocket = cluster;
    }

    public void setEventApi(String str) {
        this.eventApi = str;
    }

    public void setTc(Boolean bool) {
        this.tc = bool;
    }

    public void setUserVerifyApi(String str) {
        this.userVerifyApi = str;
    }

    public Boolean getTc() {
        return this.tc;
    }

    @Nullable
    public String getClusterApi() {
        return this.clusterApi != null ? this.clusterApi.buildUrl() : null;
    }

    @Nullable
    public String getClusterWebsocket() {
        return this.clusterWebsocket != null ? this.clusterWebsocket.buildUrl() : null;
    }

    @Nullable
    public String getAuthApi() {
        return this.authApi;
    }

    @Nullable
    public String getAvatarsApi() {
        return this.avatarsApi;
    }

    @Nullable
    public String getEventApi() {
        return this.eventApi;
    }

    @Nullable
    public String getUserVerifyApi() {
        return this.userVerifyApi;
    }

    @Nullable
    public String getWalletReferralApi() {
        return this.walletReferralApi;
    }

    public String getChatApi() {
        return this.chatApi;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Configuration{clusterWebsocket=");
        stringBuilder.append(this.clusterWebsocket);
        stringBuilder.append(", clusterApi=");
        stringBuilder.append(this.clusterApi);
        stringBuilder.append(", tc=");
        stringBuilder.append(this.tc);
        stringBuilder.append(", userVerifyApi='");
        stringBuilder.append(this.userVerifyApi);
        stringBuilder.append('\'');
        stringBuilder.append(", eventApi='");
        stringBuilder.append(this.eventApi);
        stringBuilder.append('\'');
        stringBuilder.append(", authApi='");
        stringBuilder.append(this.authApi);
        stringBuilder.append('\'');
        stringBuilder.append(", avatarsApi='");
        stringBuilder.append(this.avatarsApi);
        stringBuilder.append('\'');
        stringBuilder.append(", walletReferralApi='");
        stringBuilder.append(this.walletReferralApi);
        stringBuilder.append('\'');
        stringBuilder.append(", chatApi='");
        stringBuilder.append(this.chatApi);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        if (!this.clusterWebsocket == null ? this.clusterWebsocket.equals(configuration.clusterWebsocket) : configuration.clusterWebsocket == null) {
            return false;
        }
        if (!this.clusterApi == null ? this.clusterApi.equals(configuration.clusterApi) : configuration.clusterApi == null) {
            return false;
        }
        if (!this.tc == null ? this.tc.equals(configuration.tc) : configuration.tc == null) {
            return false;
        }
        if (!this.userVerifyApi == null ? this.userVerifyApi.equals(configuration.userVerifyApi) : configuration.userVerifyApi == null) {
            return false;
        }
        if (!this.eventApi == null ? this.eventApi.equals(configuration.eventApi) : configuration.eventApi == null) {
            return false;
        }
        if (!this.authApi == null ? this.authApi.equals(configuration.authApi) : configuration.authApi == null) {
            return false;
        }
        if (!this.avatarsApi == null ? this.avatarsApi.equals(configuration.avatarsApi) : configuration.avatarsApi == null) {
            return false;
        }
        if (!this.walletReferralApi == null ? this.walletReferralApi.equals(configuration.walletReferralApi) : configuration.walletReferralApi == null) {
            return false;
        }
        if (this.chatApi != null) {
            z = this.chatApi.equals(configuration.chatApi);
        } else if (configuration.chatApi != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((this.clusterWebsocket != null ? this.clusterWebsocket.hashCode() : 0) * 31) + (this.clusterApi != null ? this.clusterApi.hashCode() : 0)) * 31) + (this.tc != null ? this.tc.hashCode() : 0)) * 31) + (this.userVerifyApi != null ? this.userVerifyApi.hashCode() : 0)) * 31) + (this.eventApi != null ? this.eventApi.hashCode() : 0)) * 31) + (this.authApi != null ? this.authApi.hashCode() : 0)) * 31) + (this.avatarsApi != null ? this.avatarsApi.hashCode() : 0)) * 31) + (this.walletReferralApi != null ? this.walletReferralApi.hashCode() : 0)) * 31;
        if (this.chatApi != null) {
            i = this.chatApi.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.clusterWebsocket, i);
        parcel.writeParcelable(this.clusterApi, i);
        parcel.writeValue(this.tc);
        parcel.writeString(this.userVerifyApi);
        parcel.writeString(this.eventApi);
        parcel.writeString(this.authApi);
        parcel.writeString(this.avatarsApi);
        parcel.writeString(this.walletReferralApi);
        parcel.writeString(this.chatApi);
    }

    protected Configuration(Parcel parcel) {
        this.clusterWebsocket = (Cluster) parcel.readParcelable(Cluster.class.getClassLoader());
        this.clusterApi = (Cluster) parcel.readParcelable(Cluster.class.getClassLoader());
        this.tc = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.userVerifyApi = parcel.readString();
        this.eventApi = parcel.readString();
        this.authApi = parcel.readString();
        this.avatarsApi = parcel.readString();
        this.walletReferralApi = parcel.readString();
        this.chatApi = parcel.readString();
    }
}
