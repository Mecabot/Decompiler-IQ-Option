package com.iqoption.microservice.a.a.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0005J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, aXE = {"Lcom/iqoption/microservice/kyc/questionnaire/response/KycRiskWarning;", "", "warningKey", "", "showWarning", "", "showUserSignatureField", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getShowUserSignatureField", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowWarning", "getWarningKey", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/iqoption/microservice/kyc/questionnaire/response/KycRiskWarning;", "equals", "other", "hashCode", "", "isShowWarning", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: KycRiskWarning.kt */
public final class f {
    @SerializedName("warningKey")
    private final String cRI;
    @SerializedName("showWarning")
    private final Boolean cRJ;
    @SerializedName("showUserSignatureField")
    private final Boolean cRK;

    public f() {
        this(null, null, null, 7, null);
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.cRK, r3.cRK) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.microservice.a.a.a.f;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.microservice.a.a.a.f) r3;
        r0 = r2.cRI;
        r1 = r3.cRI;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.cRJ;
        r1 = r3.cRJ;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.cRK;
        r3 = r3.cRK;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.microservice.a.a.a.f.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.cRI;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.cRJ;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.cRK;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KycRiskWarning(warningKey=");
        stringBuilder.append(this.cRI);
        stringBuilder.append(", showWarning=");
        stringBuilder.append(this.cRJ);
        stringBuilder.append(", showUserSignatureField=");
        stringBuilder.append(this.cRK);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public f(String str, Boolean bool, Boolean bool2) {
        this.cRI = str;
        this.cRJ = bool;
        this.cRK = bool2;
    }

    public /* synthetic */ f(String str, Boolean bool, Boolean bool2, int i, f fVar) {
        if ((i & 1) != 0) {
            str = (String) null;
        }
        if ((i & 2) != 0) {
            bool = (Boolean) null;
        }
        if ((i & 4) != 0) {
            bool2 = (Boolean) null;
        }
        this(str, bool, bool2);
    }

    public final String asC() {
        return this.cRI;
    }

    public final Boolean asD() {
        return this.cRK;
    }

    public final boolean aoN() {
        Boolean bool = this.cRJ;
        return bool != null ? bool.booleanValue() : false;
    }
}
