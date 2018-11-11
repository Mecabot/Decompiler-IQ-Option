package com.iqoption.mobbtech.connect.response;

import com.google.common.base.e;
import com.google.gson.annotations.SerializedName;

/* compiled from: RegulationResponse */
public class k extends m {
    @SerializedName("result")
    public a cVU;

    /* compiled from: RegulationResponse */
    public static class a {
        @SerializedName("cysec")
        public Boolean cVV;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Result{cysec=");
            stringBuilder.append(this.cVV);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static k ee(boolean z) {
        k kVar = new k();
        kVar.cVU = new a();
        kVar.cVU.cVV = Boolean.valueOf(z);
        return kVar;
    }

    public String toString() {
        return e.B(this).d("super", super.toString()).d("result", this.cVU).toString();
    }
}
