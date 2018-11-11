package com.iqoption.quiz.api.response.a;

import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iqoption.quiz.aj;

/* compiled from: ChatMessageSocketResponse */
public class e {
    @SerializedName("request_id")
    @Expose
    private String cPL;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("is_large_text")
    @Expose
    private Boolean djg;
    @SerializedName("user")
    @Expose
    private g djj;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("text")
    @Expose
    private String text;

    public long getId() {
        return this.id == null ? 0 : this.id.longValue();
    }

    @NonNull
    public String getText() {
        return aj.dhZ.jc(this.text);
    }

    public boolean aAQ() {
        return this.djg == null ? false : this.djg.booleanValue();
    }

    @NonNull
    public g aAR() {
        return this.djj == null ? g.djk : this.djj;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.id == null ? this.id.equals(eVar.id) : eVar.id == null) {
            return false;
        }
        if (!this.cPL == null ? this.cPL.equals(eVar.cPL) : eVar.cPL == null) {
            return false;
        }
        if (!this.text == null ? this.text.equals(eVar.text) : eVar.text == null) {
            return false;
        }
        if (!this.djg == null ? this.djg.equals(eVar.djg) : eVar.djg == null) {
            return false;
        }
        if (!this.created == null ? this.created.equals(eVar.created) : eVar.created == null) {
            return false;
        }
        if (this.djj != null) {
            z = this.djj.equals(eVar.djj);
        } else if (eVar.djj != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((this.id != null ? this.id.hashCode() : 0) * 31) + (this.cPL != null ? this.cPL.hashCode() : 0)) * 31) + (this.text != null ? this.text.hashCode() : 0)) * 31) + (this.djg != null ? this.djg.hashCode() : 0)) * 31) + (this.created != null ? this.created.hashCode() : 0)) * 31;
        if (this.djj != null) {
            i = this.djj.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatMessageSocketResponse{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", requestId='");
        stringBuilder.append(this.cPL);
        stringBuilder.append('\'');
        stringBuilder.append(", text='");
        stringBuilder.append(this.text);
        stringBuilder.append('\'');
        stringBuilder.append(", isLargeText=");
        stringBuilder.append(this.djg);
        stringBuilder.append(", created=");
        stringBuilder.append(this.created);
        stringBuilder.append(", user=");
        stringBuilder.append(this.djj);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
