package com.iqoption.dto.entity.result;

import com.google.gson.annotations.SerializedName;
import com.iqoption.mobbtech.connect.response.o;

public class NetverifyUploadStatus extends o {
    public static String RESULT_OK = "OK";
    @SerializedName("result")
    public String result;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetverifyUploadStatus{result='");
        stringBuilder.append(this.result);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean isSuccessful() {
        return this.result != null && RESULT_OK.equals(this.result);
    }
}
