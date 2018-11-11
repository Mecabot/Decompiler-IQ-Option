package com.iqoption.quiz.api.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* compiled from: AnswerResponse */
public class a {
    public static a die = new a() {
        {
            this.dif = Integer.valueOf(-1);
            this.dig = Integer.valueOf(-1);
            this.dih = Integer.valueOf(0);
            aX(Collections.emptyList());
            a(e.dio);
        }
    };
    @SerializedName("correct_answer")
    public Integer dif;
    @SerializedName("user_answer")
    public Integer dig;
    @SerializedName("total_users")
    public Integer dih;
    @SerializedName("answer_counters")
    private List<Integer> dii;
    @SerializedName("question")
    private e dij;

    public List<Integer> aAe() {
        return this.dii == null ? Collections.EMPTY_LIST : this.dii;
    }

    public void aX(List<Integer> list) {
        this.dii = list;
    }

    public e aAf() {
        return this.dij == null ? new e() : this.dij;
    }

    public void a(e eVar) {
        this.dij = eVar;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.dif == null ? this.dif.equals(aVar.dif) : aVar.dif == null) {
            return false;
        }
        if (!this.dig == null ? this.dig.equals(aVar.dig) : aVar.dig == null) {
            return false;
        }
        if (!this.dih == null ? this.dih.equals(aVar.dih) : aVar.dih == null) {
            return false;
        }
        if (!this.dii == null ? this.dii.equals(aVar.dii) : aVar.dii == null) {
            return false;
        }
        if (this.dij != null) {
            z = this.dij.equals(aVar.dij);
        } else if (aVar.dij != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((this.dif != null ? this.dif.hashCode() : 0) * 31) + (this.dig != null ? this.dig.hashCode() : 0)) * 31) + (this.dih != null ? this.dih.hashCode() : 0)) * 31) + (this.dii != null ? this.dii.hashCode() : 0)) * 31;
        if (this.dij != null) {
            i = this.dij.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AnswerResponse{correctAnswer=");
        stringBuilder.append(this.dif);
        stringBuilder.append(", userAnswer=");
        stringBuilder.append(this.dig);
        stringBuilder.append(", totalUsers=");
        stringBuilder.append(this.dih);
        stringBuilder.append(", answerCounters=");
        stringBuilder.append(this.dii);
        stringBuilder.append(", question=");
        stringBuilder.append(this.dij);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
