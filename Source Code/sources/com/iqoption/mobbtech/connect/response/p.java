package com.iqoption.mobbtech.connect.response;

import android.support.annotation.Nullable;
import com.google.common.base.e;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* compiled from: TermsResponse */
public class p extends m {
    @SerializedName("result")
    public b cVX;

    /* compiled from: TermsResponse */
    public static class a {
        @SerializedName("author")
        public String aVS;
        @SerializedName("header")
        public String cjO;
        @SerializedName("text")
        public String text;

        public String toString() {
            return e.B(this).d("text", this.text).d("header", this.cjO).d("author", this.aVS).toString();
        }
    }

    /* compiled from: TermsResponse */
    public static class b {
        @SerializedName("date")
        public Long cVY;
        @SerializedName("content")
        public HashMap<String, a> cVZ;

        public String toString() {
            return e.B(this).d("date", this.cVY).d(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, this.cVZ).toString();
        }

        @Nullable
        public a iK(String str) {
            return (this.cVZ == null || !this.cVZ.containsKey(str)) ? null : (a) this.cVZ.get(str);
        }
    }

    public String toString() {
        return e.B(this).d("super", super.toString()).d("result", this.cVX).toString();
    }
}
