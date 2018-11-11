package com.iqoption.microservice.authorization.a;

import android.support.annotation.Nullable;
import com.google.common.base.e;
import com.google.common.base.j;
import com.google.common.collect.s;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: LoginResponse */
public class b {
    public static final j<b> cPq = new j<b>() {
        /* renamed from: b */
        public boolean apply(b bVar) {
            return bVar.errors == null || bVar.errors.isEmpty();
        }
    };
    public static final j<b> cPr = new j<b>() {
        /* renamed from: b */
        public boolean apply(b bVar) {
            return bVar.getErrorCode() == 100;
        }
    };
    public static final j<b> cPs = new j<b>() {
        /* renamed from: b */
        public boolean apply(b bVar) {
            return bVar.getErrorCode() == 300;
        }
    };
    public static final j<b> cPt = new j<b>() {
        /* renamed from: b */
        public boolean apply(b bVar) {
            return bVar.getErrorCode() == 101;
        }
    };
    @SerializedName("data")
    public a cPu;
    @SerializedName("errors")
    public List<a> errors;

    /* compiled from: LoginResponse */
    public static class a {
        @SerializedName("phone")
        public String cPv;
        @SerializedName("ttl")
        public String cPw;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Data{phone='");
            stringBuilder.append(this.cPv);
            stringBuilder.append('\'');
            stringBuilder.append(", ttl='");
            stringBuilder.append(this.cPw);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    @Nullable
    public String getErrorMessage() {
        return (this.errors == null || this.errors.isEmpty()) ? null : ((a) s.u(this.errors)).title;
    }

    public int getErrorCode() {
        if (this.errors == null || this.errors.isEmpty()) {
            return 0;
        }
        return ((Integer) e.h(((a) s.u(this.errors)).cPp, Integer.valueOf(0))).intValue();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LoginResponse{data=");
        stringBuilder.append(this.cPu);
        stringBuilder.append(", errors=");
        stringBuilder.append(this.errors);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
