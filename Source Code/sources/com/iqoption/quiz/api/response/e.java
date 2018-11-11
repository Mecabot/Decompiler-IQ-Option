package com.iqoption.quiz.api.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* compiled from: QuestionResponse */
public class e {
    public static e dio = new e() {
        {
            this.number = -1;
            this.total = 0;
            this.question = "";
            aY(Collections.emptyList());
            this.dip = 0;
            this.diq = false;
            this.dis = -1;
        }
    };
    @SerializedName("answers")
    private List<String> answers;
    @SerializedName("timestamp")
    public int dip;
    @SerializedName("can_answer")
    public boolean diq = false;
    @SerializedName("last_answer")
    public int dis;
    @SerializedName("number")
    public int number;
    @SerializedName("question")
    public String question = "";
    @SerializedName("total")
    public int total;

    public List<String> asA() {
        return this.answers == null ? Collections.EMPTY_LIST : this.answers;
    }

    protected void aY(List<String> list) {
        this.answers = list;
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
        if (this.number != eVar.number || this.total != eVar.total || this.dip != eVar.dip || this.diq != eVar.diq) {
            return false;
        }
        if (!this.question == null ? this.question.equals(eVar.question) : eVar.question == null) {
            return false;
        }
        if (this.answers != null) {
            z = this.answers.equals(eVar.answers);
        } else if (eVar.answers != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.number * 31) + this.total) * 31) + (this.question != null ? this.question.hashCode() : 0)) * 31;
        if (this.answers != null) {
            i = this.answers.hashCode();
        }
        return ((((hashCode + i) * 31) + this.dip) * 31) + this.diq;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QuestionResponse{number=");
        stringBuilder.append(this.number);
        stringBuilder.append(", total=");
        stringBuilder.append(this.total);
        stringBuilder.append(", question='");
        stringBuilder.append(this.question);
        stringBuilder.append('\'');
        stringBuilder.append(", answers=");
        stringBuilder.append(this.answers);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.dip);
        stringBuilder.append(", canAnswer=");
        stringBuilder.append(this.diq);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
