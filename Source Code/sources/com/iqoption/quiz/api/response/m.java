package com.iqoption.quiz.api.response;

import com.google.gson.annotations.SerializedName;

/* compiled from: UserAnswer */
public class m {
    @SerializedName("answer")
    private final int answer;
    @SerializedName("question")
    private final int question = -1;
    @SerializedName("session_id")
    private final String uQ = "";

    public int aAD() {
        return this.answer;
    }

    public m(int i) {
        this.answer = i;
    }
}
