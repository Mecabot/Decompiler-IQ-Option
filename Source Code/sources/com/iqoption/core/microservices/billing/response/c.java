package com.iqoption.core.microservices.billing.response;

import android.text.TextUtils;
import com.google.common.base.Joiner;
import com.google.common.collect.s;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0004\"#$%B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001e\u001a\u00020\u0005J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0002\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/PayResponse;", "", "isSuccessful", "", "message", "", "data", "Lcom/iqoption/core/microservices/billing/response/PayResponse$Data;", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/iqoption/core/microservices/billing/response/PayResponse$Data;)V", "getData", "()Lcom/iqoption/core/microservices/billing/response/PayResponse$Data;", "setData", "(Lcom/iqoption/core/microservices/billing/response/PayResponse$Data;)V", "errors", "Lcom/iqoption/core/microservices/billing/response/PayResponse$Errors;", "getErrors", "()Lcom/iqoption/core/microservices/billing/response/PayResponse$Errors;", "setErrors", "(Lcom/iqoption/core/microservices/billing/response/PayResponse$Errors;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/iqoption/core/microservices/billing/response/PayResponse$Data;)Lcom/iqoption/core/microservices/billing/response/PayResponse;", "equals", "other", "errorMessage", "hashCode", "", "toString", "Data", "Errors", "Redirect", "Validation", "core_release"})
/* compiled from: PayResponse.kt */
public final class c {
    private transient b aTh;
    @SerializedName("data")
    private a aTi;
    @SerializedName("isSuccessful")
    private final Boolean isSuccessful;
    @SerializedName("message")
    private final String message;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/PayResponse$Data;", "", "redirect", "Lcom/iqoption/core/microservices/billing/response/PayResponse$Redirect;", "(Lcom/iqoption/core/microservices/billing/response/PayResponse$Redirect;)V", "getRedirect", "()Lcom/iqoption/core/microservices/billing/response/PayResponse$Redirect;", "setRedirect", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"})
    /* compiled from: PayResponse.kt */
    public static final class a {
        @SerializedName("redirect")
        private c aTj;

        public a() {
            this(null, 1, null);
        }

        /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.aTj, ((com.iqoption.core.microservices.billing.response.c.a) r2).aTj) != false) goto L_0x0015;
     */
        public boolean equals(java.lang.Object r2) {
            /*
            r1 = this;
            if (r1 == r2) goto L_0x0015;
        L_0x0002:
            r0 = r2 instanceof com.iqoption.core.microservices.billing.response.c.a;
            if (r0 == 0) goto L_0x0013;
        L_0x0006:
            r2 = (com.iqoption.core.microservices.billing.response.c.a) r2;
            r0 = r1.aTj;
            r2 = r2.aTj;
            r2 = kotlin.jvm.internal.h.E(r0, r2);
            if (r2 == 0) goto L_0x0013;
        L_0x0012:
            goto L_0x0015;
        L_0x0013:
            r2 = 0;
            return r2;
        L_0x0015:
            r2 = 1;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.c.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            c cVar = this.aTj;
            return cVar != null ? cVar.hashCode() : 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Data(redirect=");
            stringBuilder.append(this.aTj);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(c cVar) {
            this.aTj = cVar;
        }

        public /* synthetic */ a(c cVar, int i, f fVar) {
            if ((i & 1) != 0) {
                cVar = (c) null;
            }
            this(cVar);
        }

        public final c UC() {
            return this.aTj;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/PayResponse$Errors;", "", "validation", "Lcom/iqoption/core/microservices/billing/response/PayResponse$Validation;", "(Lcom/iqoption/core/microservices/billing/response/PayResponse$Validation;)V", "getValidation", "()Lcom/iqoption/core/microservices/billing/response/PayResponse$Validation;", "setValidation", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"})
    /* compiled from: PayResponse.kt */
    public static final class b {
        @SerializedName("validation")
        private d aTk;

        public b() {
            this(null, 1, null);
        }

        /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.aTk, ((com.iqoption.core.microservices.billing.response.c.b) r2).aTk) != false) goto L_0x0015;
     */
        public boolean equals(java.lang.Object r2) {
            /*
            r1 = this;
            if (r1 == r2) goto L_0x0015;
        L_0x0002:
            r0 = r2 instanceof com.iqoption.core.microservices.billing.response.c.b;
            if (r0 == 0) goto L_0x0013;
        L_0x0006:
            r2 = (com.iqoption.core.microservices.billing.response.c.b) r2;
            r0 = r1.aTk;
            r2 = r2.aTk;
            r2 = kotlin.jvm.internal.h.E(r0, r2);
            if (r2 == 0) goto L_0x0013;
        L_0x0012:
            goto L_0x0015;
        L_0x0013:
            r2 = 0;
            return r2;
        L_0x0015:
            r2 = 1;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.c.b.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            d dVar = this.aTk;
            return dVar != null ? dVar.hashCode() : 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Errors(validation=");
            stringBuilder.append(this.aTk);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public b(d dVar) {
            this.aTk = dVar;
        }

        public /* synthetic */ b(d dVar, int i, f fVar) {
            if ((i & 1) != 0) {
                dVar = (d) null;
            }
            this(dVar);
        }

        public final d UD() {
            return this.aTk;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR,\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001c"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/PayResponse$Redirect;", "", "method", "", "url", "params", "Ljava/util/HashMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "getUrl", "setUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"})
    /* compiled from: PayResponse.kt */
    public static final class c {
        @SerializedName("params")
        private HashMap<String, String> anM;
        @SerializedName("method")
        private String method;
        @SerializedName("url")
        private String url;

        public c() {
            this(null, null, null, 7, null);
        }

        /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.anM, r3.anM) != false) goto L_0x0029;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x0029;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.core.microservices.billing.response.c.c;
            if (r0 == 0) goto L_0x0027;
        L_0x0006:
            r3 = (com.iqoption.core.microservices.billing.response.c.c) r3;
            r0 = r2.method;
            r1 = r3.method;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0027;
        L_0x0012:
            r0 = r2.url;
            r1 = r3.url;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0027;
        L_0x001c:
            r0 = r2.anM;
            r3 = r3.anM;
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
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.c.c.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.method;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.url;
            hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            HashMap hashMap = this.anM;
            if (hashMap != null) {
                i = hashMap.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Redirect(method=");
            stringBuilder.append(this.method);
            stringBuilder.append(", url=");
            stringBuilder.append(this.url);
            stringBuilder.append(", params=");
            stringBuilder.append(this.anM);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public c(String str, String str2, HashMap<String, String> hashMap) {
            this.method = str;
            this.url = str2;
            this.anM = hashMap;
        }

        public /* synthetic */ c(String str, String str2, HashMap hashMap, int i, f fVar) {
            if ((i & 1) != 0) {
                str = (String) null;
            }
            if ((i & 2) != 0) {
                str2 = (String) null;
            }
            if ((i & 4) != 0) {
                hashMap = (HashMap) null;
            }
            this(str, str2, hashMap);
        }

        public final String getMethod() {
            return this.method;
        }

        public final String getUrl() {
            return this.url;
        }

        public final HashMap<String, String> UE() {
            return this.anM;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u0003HÆ\u0003JE\u0010\u0010\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u00032\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R2\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0017"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/PayResponse$Validation;", "", "params", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "extraParams", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", "getExtraParams", "()Ljava/util/HashMap;", "setExtraParams", "(Ljava/util/HashMap;)V", "getParams", "setParams", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"})
    /* compiled from: PayResponse.kt */
    public static final class d {
        @SerializedName("extra_params")
        private HashMap<String, ArrayList<String>> aTl;
        @SerializedName("params")
        private HashMap<String, ArrayList<String>> anM;

        public d() {
            this(null, null, 3, null);
        }

        /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.aTl, r3.aTl) != false) goto L_0x001f;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x001f;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.core.microservices.billing.response.c.d;
            if (r0 == 0) goto L_0x001d;
        L_0x0006:
            r3 = (com.iqoption.core.microservices.billing.response.c.d) r3;
            r0 = r2.anM;
            r1 = r3.anM;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x001d;
        L_0x0012:
            r0 = r2.aTl;
            r3 = r3.aTl;
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x001d;
        L_0x001c:
            goto L_0x001f;
        L_0x001d:
            r3 = 0;
            return r3;
        L_0x001f:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.c.d.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            HashMap hashMap = this.anM;
            int i = 0;
            int hashCode = (hashMap != null ? hashMap.hashCode() : 0) * 31;
            HashMap hashMap2 = this.aTl;
            if (hashMap2 != null) {
                i = hashMap2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Validation(params=");
            stringBuilder.append(this.anM);
            stringBuilder.append(", extraParams=");
            stringBuilder.append(this.aTl);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public d(HashMap<String, ArrayList<String>> hashMap, HashMap<String, ArrayList<String>> hashMap2) {
            this.anM = hashMap;
            this.aTl = hashMap2;
        }

        public /* synthetic */ d(HashMap hashMap, HashMap hashMap2, int i, f fVar) {
            if ((i & 1) != 0) {
                hashMap = (HashMap) null;
            }
            if ((i & 2) != 0) {
                hashMap2 = (HashMap) null;
            }
            this(hashMap, hashMap2);
        }

        public final HashMap<String, ArrayList<String>> UE() {
            return this.anM;
        }

        public final HashMap<String, ArrayList<String>> UF() {
            return this.aTl;
        }
    }

    public c() {
        this(null, null, null, 7, null);
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.aTi, r3.aTi) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.billing.response.c;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.billing.response.c) r3;
        r0 = r2.isSuccessful;
        r1 = r3.isSuccessful;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.message;
        r1 = r3.message;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.aTi;
        r3 = r3.aTi;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Boolean bool = this.isSuccessful;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        String str = this.message;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        a aVar = this.aTi;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PayResponse(isSuccessful=");
        stringBuilder.append(this.isSuccessful);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", data=");
        stringBuilder.append(this.aTi);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public c(Boolean bool, String str, a aVar) {
        this.isSuccessful = bool;
        this.message = str;
        this.aTi = aVar;
    }

    public /* synthetic */ c(Boolean bool, String str, a aVar, int i, f fVar) {
        if ((i & 1) != 0) {
            bool = Boolean.valueOf(false);
        }
        if ((i & 2) != 0) {
            str = (String) null;
        }
        if ((i & 4) != 0) {
            aVar = (a) null;
        }
        this(bool, str, aVar);
    }

    public final Boolean UA() {
        return this.isSuccessful;
    }

    public final a UB() {
        return this.aTi;
    }

    public final String Uz() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.message)) {
            stringBuilder.append(this.message);
            stringBuilder.append(' ');
        }
        if (this.aTh != null) {
            b bVar = this.aTh;
            if (bVar == null) {
                h.aXZ();
            }
            if (bVar.UD() != null) {
                Collection values;
                Collection values2;
                bVar = this.aTh;
                if (bVar == null) {
                    h.aXZ();
                }
                d UD = bVar.UD();
                if (UD == null) {
                    h.aXZ();
                }
                if (UD.UE() != null) {
                    bVar = this.aTh;
                    if (bVar == null) {
                        h.aXZ();
                    }
                    UD = bVar.UD();
                    if (UD == null) {
                        h.aXZ();
                    }
                    HashMap UE = UD.UE();
                    if (UE == null) {
                        h.aXZ();
                    }
                    values = UE.values();
                    h.d(values, "errors!!.validation!!.params!!.values");
                } else {
                    values = m.emptyList();
                }
                b bVar2 = this.aTh;
                if (bVar2 == null) {
                    h.aXZ();
                }
                d UD2 = bVar2.UD();
                if (UD2 == null) {
                    h.aXZ();
                }
                if (UD2.UF() != null) {
                    bVar2 = this.aTh;
                    if (bVar2 == null) {
                        h.aXZ();
                    }
                    UD2 = bVar2.UD();
                    if (UD2 == null) {
                        h.aXZ();
                    }
                    HashMap UF = UD2.UF();
                    if (UF == null) {
                        h.aXZ();
                    }
                    values2 = UF.values();
                    h.d(values2, "errors!!.validation!!.extraParams!!.values");
                } else {
                    values2 = m.emptyList();
                }
                String join = Joiner.on(", ").join(s.b((Iterable) values, (Iterable) values2));
                h.d(join, "join");
                if ((((CharSequence) join).length() == 0 ? 1 : null) == null) {
                    stringBuilder.append("(");
                    stringBuilder.append(join);
                    stringBuilder.append(")");
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "sb.toString()");
        return stringBuilder2;
    }
}
