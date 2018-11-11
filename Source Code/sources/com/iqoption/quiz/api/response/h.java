package com.iqoption.quiz.api.response;

import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iqoption.quiz.aj;

/* compiled from: SessionResponse */
public class h {
    @SerializedName("referral_code")
    @Expose
    private String dit;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("session_id")
    @Expose
    private String uQ;

    @NonNull
    public String FC() {
        return aj.dhZ.jc(this.uQ);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (!this.email == null ? this.email.equals(hVar.email) : hVar.email == null) {
            return false;
        }
        if (!this.dit == null ? this.dit.equals(hVar.dit) : hVar.dit == null) {
            return false;
        }
        if (this.uQ != null) {
            z = this.uQ.equals(hVar.uQ);
        } else if (hVar.uQ != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((this.email != null ? this.email.hashCode() : 0) * 31) + (this.dit != null ? this.dit.hashCode() : 0)) * 31;
        if (this.uQ != null) {
            i = this.uQ.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SessionResponse{email='");
        stringBuilder.append(this.email);
        stringBuilder.append('\'');
        stringBuilder.append(", сode='");
        stringBuilder.append(this.dit);
        stringBuilder.append('\'');
        stringBuilder.append(", id='");
        stringBuilder.append(this.uQ);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
