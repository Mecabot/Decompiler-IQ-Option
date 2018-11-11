package com.iqoption.dto.entity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class MemberTournament {
    @SerializedName("avatar_url")
    public String avatarUrl;
    @SerializedName("balance")
    public Double balance;
    @SerializedName("flag")
    public String flag;
    @SerializedName("name")
    public String name;
    @SerializedName("position")
    public Integer position;
    @SerializedName("user_id")
    public Long userId;

    public static class List extends ArrayList<MemberTournament> {
    }

    public String getTextName() {
        return this.name;
    }

    public void merge(MemberTournament memberTournament) {
        if (!TextUtils.isEmpty(memberTournament.avatarUrl)) {
            this.avatarUrl = memberTournament.avatarUrl;
        }
        if (!TextUtils.isEmpty(memberTournament.name)) {
            this.name = memberTournament.name;
        }
        if (!TextUtils.isEmpty(memberTournament.flag)) {
            this.flag = memberTournament.flag;
        }
        if (memberTournament.balance != null) {
            this.balance = memberTournament.balance;
        }
        if (memberTournament.position != null) {
            this.position = memberTournament.position;
        }
        if (memberTournament.userId != null) {
            this.userId = memberTournament.userId;
        }
    }
}
