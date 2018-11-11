package com.iqoption.dto.entity.iqbus;

import com.google.gson.annotations.SerializedName;

public class NetverifyToken {
    private static final String TAG = "com.iqoption.dto.entity.iqbus.NetverifyToken";
    @SerializedName("merchantScanReference")
    public String merchantScanReference;
    @SerializedName("message")
    public String message;
    @SerializedName("result")
    public String result;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetverifyToken{merchantScanReference='");
        stringBuilder.append(this.merchantScanReference);
        stringBuilder.append('\'');
        stringBuilder.append(", result='");
        stringBuilder.append(this.result);
        stringBuilder.append('\'');
        stringBuilder.append(", message='");
        stringBuilder.append(this.message);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
