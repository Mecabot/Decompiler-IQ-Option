package com.iqoption.core.microservices.busapi.response;

import com.google.gson.JsonObject;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020\u0003J\t\u0010%\u001a\u00020&HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006'"}, aXE = {"Lcom/iqoption/core/microservices/busapi/response/PersonalDataPolicy;", "", "agreement", "", "email", "push", "call", "thirdPartyAccepted", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAgreement", "()Ljava/lang/Boolean;", "setAgreement", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCall", "setCall", "getEmail", "setEmail", "getPush", "setPush", "getThirdPartyAccepted", "setThirdPartyAccepted", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/iqoption/core/microservices/busapi/response/PersonalDataPolicy;", "createWithUpdatedStatuses", "jsonObject", "Lcom/google/gson/JsonObject;", "equals", "other", "hashCode", "", "isMarketingSetup", "toString", "", "core_release"})
/* compiled from: PersonalDataPolicy.kt */
public final class b {
    private Boolean aUq;
    private Boolean aUr;
    private Boolean aUs;
    private Boolean aUt;
    private Boolean aUu;

    public b() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARNING: Missing block: B:12:0x0038, code:
            if (kotlin.jvm.internal.h.E(r2.aUu, r3.aUu) != false) goto L_0x003d;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x003d;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.busapi.response.b;
        if (r0 == 0) goto L_0x003b;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.busapi.response.b) r3;
        r0 = r2.aUq;
        r1 = r3.aUq;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x0012:
        r0 = r2.aUr;
        r1 = r3.aUr;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x001c:
        r0 = r2.aUs;
        r1 = r3.aUs;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x0026:
        r0 = r2.aUt;
        r1 = r3.aUt;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x0030:
        r0 = r2.aUu;
        r3 = r3.aUu;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x003b;
    L_0x003a:
        goto L_0x003d;
    L_0x003b:
        r3 = 0;
        return r3;
    L_0x003d:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.busapi.response.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Boolean bool = this.aUq;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.aUr;
        hashCode = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        bool2 = this.aUs;
        hashCode = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        bool2 = this.aUt;
        hashCode = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        bool2 = this.aUu;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PersonalDataPolicy(agreement=");
        stringBuilder.append(this.aUq);
        stringBuilder.append(", email=");
        stringBuilder.append(this.aUr);
        stringBuilder.append(", push=");
        stringBuilder.append(this.aUs);
        stringBuilder.append(", call=");
        stringBuilder.append(this.aUt);
        stringBuilder.append(", thirdPartyAccepted=");
        stringBuilder.append(this.aUu);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        this.aUq = bool;
        this.aUr = bool2;
        this.aUs = bool3;
        this.aUt = bool4;
        this.aUu = bool5;
    }

    public /* synthetic */ b(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, int i, f fVar) {
        if ((i & 1) != 0) {
            bool = (Boolean) null;
        }
        if ((i & 2) != 0) {
            bool2 = (Boolean) null;
        }
        Boolean bool6 = bool2;
        if ((i & 4) != 0) {
            bool3 = (Boolean) null;
        }
        Boolean bool7 = bool3;
        if ((i & 8) != 0) {
            bool4 = (Boolean) null;
        }
        Boolean bool8 = bool4;
        if ((i & 16) != 0) {
            bool5 = (Boolean) null;
        }
        this(bool, bool6, bool7, bool8, bool5);
    }

    public final Boolean Vu() {
        return this.aUq;
    }

    public final Boolean Vv() {
        return this.aUr;
    }

    public final Boolean Vw() {
        return this.aUs;
    }

    public final Boolean Vx() {
        return this.aUt;
    }

    public final Boolean Vy() {
        return this.aUu;
    }

    public final b e(JsonObject jsonObject) {
        h.e(jsonObject, "jsonObject");
        b bVar = this;
        if (jsonObject.has("is_agreement_accepted")) {
            bVar.aUq = c.b(jsonObject, "is_agreement_accepted");
        }
        if (jsonObject.has("is_email_accepted")) {
            bVar.aUr = c.b(jsonObject, "is_email_accepted");
        }
        if (jsonObject.has("is_push_accepted")) {
            bVar.aUs = c.b(jsonObject, "is_push_accepted");
        }
        if (jsonObject.has("is_call_accepted")) {
            bVar.aUt = c.b(jsonObject, "is_call_accepted");
        }
        if (jsonObject.has("is_thirdparty_accepted")) {
            bVar.aUu = c.b(jsonObject, "is_thirdparty_accepted");
        }
        return bVar;
    }
}
