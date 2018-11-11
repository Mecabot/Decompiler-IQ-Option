package com.iqoption.quiz.api.response.a;

import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iqoption.quiz.aj;

/* compiled from: User */
public class g {
    public static final g djk = new g() {
        {
            setId("");
            setName("");
            jt("");
            ju("");
            setFlag("");
        }
    };
    @SerializedName("sender_avatar_url")
    @Expose
    private String cPS;
    @SerializedName("country_id")
    @Expose
    private String djh;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    @NonNull
    public String getId() {
        return aj.dhZ.jc(this.id);
    }

    public void setId(@NonNull String str) {
        this.id = str;
    }

    @NonNull
    public String getName() {
        return aj.dhZ.jc(this.name);
    }

    public void setName(@NonNull String str) {
        this.name = str;
    }

    @NonNull
    public String arr() {
        return aj.dhZ.jc(this.cPS);
    }

    public void jt(@NonNull String str) {
        this.cPS = str;
    }

    @NonNull
    public String aAS() {
        return aj.dhZ.jc(this.djh);
    }

    public void ju(@NonNull String str) {
        this.djh = str;
    }

    @NonNull
    public String getFlag() {
        return aj.dhZ.jc(this.flag);
    }

    public void setFlag(@NonNull String str) {
        this.flag = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (!this.id == null ? this.id.equals(gVar.id) : gVar.id == null) {
            return false;
        }
        if (!this.name == null ? this.name.equals(gVar.name) : gVar.name == null) {
            return false;
        }
        if (!this.cPS == null ? this.cPS.equals(gVar.cPS) : gVar.cPS == null) {
            return false;
        }
        if (!this.djh == null ? this.djh.equals(gVar.djh) : gVar.djh == null) {
            return false;
        }
        if (this.flag != null) {
            z = this.flag.equals(gVar.flag);
        } else if (gVar.flag != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((this.id != null ? this.id.hashCode() : 0) * 31) + (this.name != null ? this.name.hashCode() : 0)) * 31) + (this.cPS != null ? this.cPS.hashCode() : 0)) * 31) + (this.djh != null ? this.djh.hashCode() : 0)) * 31;
        if (this.flag != null) {
            i = this.flag.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User{id='");
        stringBuilder.append(this.id);
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", senderAvatarUrl='");
        stringBuilder.append(this.cPS);
        stringBuilder.append('\'');
        stringBuilder.append(", countryId='");
        stringBuilder.append(this.djh);
        stringBuilder.append('\'');
        stringBuilder.append(", flag='");
        stringBuilder.append(this.flag);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
