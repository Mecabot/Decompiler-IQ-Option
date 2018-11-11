package com.iqoption.microservice.a.a.a;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/PutKycQuestionnaireItem;", "", "questionId", "", "answers", "", "(ILjava/util/List;)V", "getAnswers", "()Ljava/util/List;", "getQuestionId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PutKycQuestionnaireItem.kt */
public final class g {
    @SerializedName("answers")
    private final List<Integer> answers;
    @SerializedName("questionId")
    private final int cME;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return (this.cME == gVar.cME ? 1 : null) != null && h.E(this.answers, gVar.answers);
        }
    }

    public int hashCode() {
        int i = this.cME * 31;
        List list = this.answers;
        return i + (list != null ? list.hashCode() : 0);
    }

    public g(int i, List<Integer> list) {
        h.e(list, "answers");
        this.cME = i;
        this.answers = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"questionId\":");
        stringBuilder.append(this.cME);
        stringBuilder.append(",\"answers\":[");
        String stringBuilder2 = stringBuilder.toString();
        String str = "";
        int length = str.length();
        String str2 = str;
        for (int i = 0; i < length; i++) {
            StringBuilder stringBuilder3;
            char charAt = str.charAt(i);
            if ((((CharSequence) str2).length() == 0 ? 1 : null) == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str2);
                stringBuilder3.append(",");
                str2 = stringBuilder3.toString();
            }
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str2);
            stringBuilder3.append(String.valueOf(charAt));
            str2 = stringBuilder3.toString();
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder2);
        stringBuilder4.append(str2);
        stringBuilder4.append("]");
        return stringBuilder4.toString();
    }
}
