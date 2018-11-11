package com.iqoption.core.microservices.billing.response;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/CreateSessionResult;", "", "isSuccessful", "", "message", "", "", "result", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "(ZLjava/util/List;Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;)V", "()Z", "getMessage", "()Ljava/util/List;", "getResult", "()Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "setResult", "(Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;)V", "CreateSession", "core_release"})
/* compiled from: CreateSessionResult.kt */
public final class b {
    @SerializedName("result")
    private a aTe;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "", "host", "", "session", "mobileCashboxUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "getMobileCashboxUrl", "setMobileCashboxUrl", "getSession", "setSession", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"})
    /* compiled from: CreateSessionResult.kt */
    public static final class a {
        @SerializedName("session")
        private String aTf;
        @SerializedName("mobile_cashbox_url")
        private String aTg;
        @SerializedName("host")
        private String host;

        /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.aTg, r3.aTg) != false) goto L_0x0029;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x0029;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.core.microservices.billing.response.b.a;
            if (r0 == 0) goto L_0x0027;
        L_0x0006:
            r3 = (com.iqoption.core.microservices.billing.response.b.a) r3;
            r0 = r2.host;
            r1 = r3.host;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0027;
        L_0x0012:
            r0 = r2.aTf;
            r1 = r3.aTf;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0027;
        L_0x001c:
            r0 = r2.aTg;
            r3 = r3.aTg;
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
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.b.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.host;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.aTf;
            hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            str2 = this.aTg;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CreateSession(host=");
            stringBuilder.append(this.host);
            stringBuilder.append(", session=");
            stringBuilder.append(this.aTf);
            stringBuilder.append(", mobileCashboxUrl=");
            stringBuilder.append(this.aTg);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public final String getHost() {
            return this.host;
        }

        public final String Uy() {
            return this.aTf;
        }
    }

    public final a Ux() {
        return this.aTe;
    }
}
