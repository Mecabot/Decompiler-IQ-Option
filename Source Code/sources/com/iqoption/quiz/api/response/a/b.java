package com.iqoption.quiz.api.response.a;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* compiled from: ChatMessageResponse */
public class b {
    @SerializedName("user_display_name")
    @Expose
    private String dje;
    @SerializedName("user_avatar")
    @Expose
    private String djf;
    @SerializedName("is_large_text")
    @Expose
    private Boolean djg;
    @SerializedName("country_id")
    @Expose
    private String djh;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public static b a(e eVar) {
        b bVar = new b();
        bVar.id = Long.valueOf(eVar.getId());
        g aAR = eVar.aAR();
        bVar.userId = aAR.getId();
        bVar.dje = aAR.getName();
        bVar.djf = aAR.arr();
        bVar.text = eVar.getText();
        bVar.djg = Boolean.valueOf(eVar.aAQ());
        bVar.djh = aAR.aAS();
        bVar.flag = aAR.getFlag();
        return bVar;
    }

    public Long getId() {
        return this.id;
    }

    public String getUserId() {
        return this.userId;
    }

    public String aAM() {
        return this.dje;
    }

    public String aAN() {
        return this.djf;
    }

    public String getText() {
        return this.text;
    }

    public Boolean aAO() {
        return this.djg;
    }

    public String getFlag() {
        return this.flag;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.id == null ? this.id.equals(bVar.id) : bVar.id == null) {
            return false;
        }
        if (!this.userId == null ? this.userId.equals(bVar.userId) : bVar.userId == null) {
            return false;
        }
        if (!this.dje == null ? this.dje.equals(bVar.dje) : bVar.dje == null) {
            return false;
        }
        if (!this.djf == null ? this.djf.equals(bVar.djf) : bVar.djf == null) {
            return false;
        }
        if (!this.text == null ? this.text.equals(bVar.text) : bVar.text == null) {
            return false;
        }
        if (!this.djg == null ? this.djg.equals(bVar.djg) : bVar.djg == null) {
            return false;
        }
        if (!this.djh == null ? this.djh.equals(bVar.djh) : bVar.djh == null) {
            return false;
        }
        if (this.flag != null) {
            z = this.flag.equals(bVar.flag);
        } else if (bVar.flag != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((this.id != null ? this.id.hashCode() : 0) * 31) + (this.userId != null ? this.userId.hashCode() : 0)) * 31) + (this.dje != null ? this.dje.hashCode() : 0)) * 31) + (this.djf != null ? this.djf.hashCode() : 0)) * 31) + (this.text != null ? this.text.hashCode() : 0)) * 31) + (this.djg != null ? this.djg.hashCode() : 0)) * 31) + (this.djh != null ? this.djh.hashCode() : 0)) * 31;
        if (this.flag != null) {
            i = this.flag.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatMessageResponse{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", userId='");
        stringBuilder.append(this.userId);
        stringBuilder.append('\'');
        stringBuilder.append(", userDisplayName='");
        stringBuilder.append(this.dje);
        stringBuilder.append('\'');
        stringBuilder.append(", userAvatar='");
        stringBuilder.append(this.djf);
        stringBuilder.append('\'');
        stringBuilder.append(", text='");
        stringBuilder.append(this.text);
        stringBuilder.append('\'');
        stringBuilder.append(", isLargeText=");
        stringBuilder.append(this.djg);
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
