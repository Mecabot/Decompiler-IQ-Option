package com.iqoption.quiz.api.response;

import com.google.gson.annotations.SerializedName;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: SplashResponse */
public class i {
    public static i diu = new i();
    @SerializedName("amount")
    public String amount = "";
    @SerializedName("currency")
    public String currency = "";
    @SerializedName("timestamp")
    public Long div = Long.valueOf(0);
    @SerializedName("line3")
    private String diw = "";
    @SerializedName("line4")
    private String dix = "";
    @SerializedName("line5")
    private String diy = "";
    private transient String diz = "";
    @SerializedName("line1")
    private String line1 = "";
    @SerializedName("line2")
    private String line2 = "";

    public String aAi() {
        return jn(this.line1);
    }

    public String aAj() {
        return jn(this.line2);
    }

    public String aAk() {
        return jn(this.diw);
    }

    public String aAl() {
        return jn(this.dix);
    }

    public String aAm() {
        return jn(this.diy);
    }

    public boolean aAn() {
        return jo(this.line1);
    }

    public boolean aAo() {
        return jo(this.line2);
    }

    public boolean aAp() {
        return jo(this.diw);
    }

    public boolean aAq() {
        return jo(this.dix);
    }

    public boolean aAr() {
        return jo(this.diy);
    }

    private String jn(String str) {
        return jo(str) ? str.replace("<timestamp>", aAs()) : str;
    }

    private boolean jo(String str) {
        return str.contains("<timestamp>");
    }

    private String aAs() {
        if (this.div != null && this.div.longValue() > 0 && "".equals(this.diz)) {
            try {
                TimeZone timeZone = Calendar.getInstance().getTimeZone();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                simpleDateFormat.setTimeZone(timeZone);
                this.diz = simpleDateFormat.format(new Date(this.div.longValue() * 1000));
            } catch (Exception unused) {
                return this.diz;
            }
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (!this.amount == null ? this.amount.equals(iVar.amount) : iVar.amount == null) {
            return false;
        }
        if (!this.currency == null ? this.currency.equals(iVar.currency) : iVar.currency == null) {
            return false;
        }
        if (!this.line1 == null ? this.line1.equals(iVar.line1) : iVar.line1 == null) {
            return false;
        }
        if (!this.line2 == null ? this.line2.equals(iVar.line2) : iVar.line2 == null) {
            return false;
        }
        if (!this.diw == null ? this.diw.equals(iVar.diw) : iVar.diw == null) {
            return false;
        }
        if (!this.dix == null ? this.dix.equals(iVar.dix) : iVar.dix == null) {
            return false;
        }
        if (this.diy != null) {
            z = this.diy.equals(iVar.diy);
        } else if (iVar.diy != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((this.amount != null ? this.amount.hashCode() : 0) * 31) + (this.currency != null ? this.currency.hashCode() : 0)) * 31) + (this.line1 != null ? this.line1.hashCode() : 0)) * 31) + (this.line2 != null ? this.line2.hashCode() : 0)) * 31) + (this.diw != null ? this.diw.hashCode() : 0)) * 31) + (this.dix != null ? this.dix.hashCode() : 0)) * 31;
        if (this.diy != null) {
            i = this.diy.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SplashResponse{amount='");
        stringBuilder.append(this.amount);
        stringBuilder.append('\'');
        stringBuilder.append(", currency='");
        stringBuilder.append(this.currency);
        stringBuilder.append('\'');
        stringBuilder.append(", line1='");
        stringBuilder.append(this.line1);
        stringBuilder.append('\'');
        stringBuilder.append(", line2='");
        stringBuilder.append(this.line2);
        stringBuilder.append('\'');
        stringBuilder.append(", line3='");
        stringBuilder.append(this.diw);
        stringBuilder.append('\'');
        stringBuilder.append(", line4='");
        stringBuilder.append(this.dix);
        stringBuilder.append('\'');
        stringBuilder.append(", line5='");
        stringBuilder.append(this.diy);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
