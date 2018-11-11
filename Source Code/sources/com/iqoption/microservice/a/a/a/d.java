package com.iqoption.microservice.a.a.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0002\u0010\bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnairesItem;", "", "isReanswerNeed", "", "isAnswered", "type", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/iqoption/microservice/kyc/questionnaire/response/KycQuestionnairesItem;", "equals", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: KycQuestionnairesItem.kt */
public final class d {
    @SerializedName("isReanswerNeed")
    private final Boolean cRA;
    @SerializedName("isAnswered")
    private final Boolean cRB;
    @SerializedName("type")
    private final Integer type;

    public d() {
        this(null, null, null, 7, null);
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.type, r3.type) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.microservice.a.a.a.d;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.microservice.a.a.a.d) r3;
        r0 = r2.cRA;
        r1 = r3.cRA;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.cRB;
        r1 = r3.cRB;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.type;
        r3 = r3.type;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r3 = 0;
        return r3;
    L_0x0029:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.microservice.a.a.a.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Boolean bool = this.cRA;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.cRB;
        hashCode = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Integer num = this.type;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KycQuestionnairesItem(isReanswerNeed=");
        stringBuilder.append(this.cRA);
        stringBuilder.append(", isAnswered=");
        stringBuilder.append(this.cRB);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(Boolean bool, Boolean bool2, Integer num) {
        this.cRA = bool;
        this.cRB = bool2;
        this.type = num;
    }

    public /* synthetic */ d(Boolean bool, Boolean bool2, Integer num, int i, f fVar) {
        if ((i & 1) != 0) {
            bool = (Boolean) null;
        }
        if ((i & 2) != 0) {
            bool2 = (Boolean) null;
        }
        if ((i & 4) != 0) {
            num = (Integer) null;
        }
        this(bool, bool2, num);
    }

    public final Boolean asu() {
        return this.cRA;
    }

    public final Boolean asv() {
        return this.cRB;
    }

    public final Integer asr() {
        return this.type;
    }
}
