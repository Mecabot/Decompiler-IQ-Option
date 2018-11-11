package com.iqoption.mobbtech.connect.response;

import android.text.TextUtils;
import com.google.common.base.Joiner;
import com.google.common.collect.s;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: PayResponse */
public class i extends o {
    @SerializedName("data")
    public a cVQ;
    public transient b cVR;

    /* compiled from: PayResponse */
    public static class a {
        @SerializedName("redirect")
        public c cVS;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Data{redirect=");
            stringBuilder.append(this.cVS);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: PayResponse */
    public static class b {
        @SerializedName("validation")
        public d cVT;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Errors{validation=");
            stringBuilder.append(this.cVT);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: PayResponse */
    public static class c {
        @SerializedName("params")
        public HashMap<String, String> anM;
        @SerializedName("method")
        public String method;
        @SerializedName("url")
        public String url;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Redirect{method='");
            stringBuilder.append(this.method);
            stringBuilder.append('\'');
            stringBuilder.append(",url='");
            stringBuilder.append(this.url);
            stringBuilder.append('\'');
            stringBuilder.append(",params=");
            stringBuilder.append(this.anM);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: PayResponse */
    public static class d {
        @SerializedName("extra_params")
        public HashMap<String, ArrayList<String>> aTl;
        @SerializedName("params")
        public HashMap<String, ArrayList<String>> anM;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Validation{params=");
            stringBuilder.append(this.anM);
            stringBuilder.append(",extraParams=");
            stringBuilder.append(this.aTl);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public String getErrorMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(getMessage())) {
            stringBuilder.append(getMessage());
            stringBuilder.append(' ');
        }
        if (!(this.cVR == null || this.cVR.cVT == null)) {
            String join = Joiner.on(", ").join(s.b(this.cVR.cVT.anM != null ? this.cVR.cVT.anM.values() : Collections.emptyList(), this.cVR.cVT.aTl != null ? this.cVR.cVT.aTl.values() : Collections.emptyList()));
            if (!join.isEmpty()) {
                stringBuilder.append("(");
                stringBuilder.append(join);
                stringBuilder.append(")");
            }
        }
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PayResponse{message='");
        stringBuilder.append(this.message);
        stringBuilder.append('\'');
        stringBuilder.append(",isSuccessful=");
        stringBuilder.append(this.isSuccessful);
        stringBuilder.append(",data=");
        stringBuilder.append(this.cVQ);
        stringBuilder.append(",errors=");
        stringBuilder.append(this.cVR);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
