package com.iqoption.quiz.api.response;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, aXE = {"Lcom/iqoption/quiz/api/response/StatResponse;", "", "position", "", "user", "Lcom/iqoption/quiz/api/response/User;", "amount", "Ljava/math/BigDecimal;", "(ILcom/iqoption/quiz/api/response/User;Ljava/math/BigDecimal;)V", "getAmount", "()Ljava/math/BigDecimal;", "getPosition", "()I", "getUser", "()Lcom/iqoption/quiz/api/response/User;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "quiz_release"})
/* compiled from: StatResponse.kt */
public final class j {
    @SerializedName("amount")
    private final BigDecimal aWn;
    @SerializedName("user")
    private final l diA;
    @SerializedName("position")
    private final int position;

    public j() {
        this(0, null, null, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return (this.position == jVar.position ? 1 : null) != null && h.E(this.diA, jVar.diA) && h.E(this.aWn, jVar.aWn);
        }
    }

    public int hashCode() {
        int i = this.position * 31;
        l lVar = this.diA;
        int i2 = 0;
        i = (i + (lVar != null ? lVar.hashCode() : 0)) * 31;
        BigDecimal bigDecimal = this.aWn;
        if (bigDecimal != null) {
            i2 = bigDecimal.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StatResponse(position=");
        stringBuilder.append(this.position);
        stringBuilder.append(", user=");
        stringBuilder.append(this.diA);
        stringBuilder.append(", amount=");
        stringBuilder.append(this.aWn);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public j(int i, l lVar, BigDecimal bigDecimal) {
        h.e(lVar, "user");
        this.position = i;
        this.diA = lVar;
        this.aWn = bigDecimal;
    }

    public final int getPosition() {
        return this.position;
    }

    public /* synthetic */ j(int i, l lVar, BigDecimal bigDecimal, int i2, f fVar) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        if ((i2 & 2) != 0) {
            lVar = l.diK;
            h.d(lVar, "User.EMPTY");
        }
        if ((i2 & 4) != 0) {
            bigDecimal = (BigDecimal) null;
        }
        this(i, lVar, bigDecimal);
    }

    public final l aAt() {
        return this.diA;
    }

    public final BigDecimal VZ() {
        return this.aWn;
    }
}
