package com.iqoption.quiz.api.response.a;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* compiled from: ChatMessageSend */
public class c {
    @SerializedName("user_display_name")
    @Expose
    private String dje = "";
    @SerializedName("user_avatar")
    @Expose
    private String djf = "";
    @SerializedName("is_large_text")
    @Expose
    private Boolean djg = Boolean.valueOf(false);
    @SerializedName("text")
    @Expose
    private String text = "";
    @SerializedName("user_id")
    @Expose
    private String userId = "";

    public void setUserId(String str) {
        this.userId = str;
    }

    public void jr(String str) {
        this.dje = str;
    }

    public void js(String str) {
        this.djf = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public Boolean aAO() {
        return this.djg;
    }

    public void s(Boolean bool) {
        this.djg = bool;
    }
}
