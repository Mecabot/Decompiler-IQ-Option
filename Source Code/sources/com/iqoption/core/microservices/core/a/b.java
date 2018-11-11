package com.iqoption.core.microservices.core.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0004HÂ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/microservices/core/response/OnlineCountResponses;", "", "()V", "result", "Lcom/iqoption/core/microservices/core/response/OnlineCountResponses$Result;", "(Lcom/iqoption/core/microservices/core/response/OnlineCountResponses$Result;)V", "online", "", "getOnline", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Result", "core_release"})
/* compiled from: OnlineCountResponses.kt */
public final class b {
    @SerializedName("result")
    private final a aVC;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/microservices/core/response/OnlineCountResponses$Result;", "", "()V", "online", "", "(I)V", "getOnline", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "core_release"})
    /* compiled from: OnlineCountResponses.kt */
    public static final class a {
        @SerializedName("online")
        private final int aVD;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                if ((this.aVD == ((a) obj).aVD ? 1 : null) != null) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.aVD;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Result(online=");
            stringBuilder.append(this.aVD);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(int i) {
            this.aVD = i;
        }

        public final int VJ() {
            return this.aVD;
        }

        public a() {
            this(0);
        }
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.aVC, ((com.iqoption.core.microservices.core.a.b) r2).aVC) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.core.microservices.core.a.b;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.core.microservices.core.a.b) r2;
        r0 = r1.aVC;
        r2 = r2.aVC;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.core.a.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        a aVar = this.aVC;
        return aVar != null ? aVar.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OnlineCountResponses(result=");
        stringBuilder.append(this.aVC);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(a aVar) {
        this.aVC = aVar;
    }

    public final int VJ() {
        a aVar = this.aVC;
        return aVar != null ? aVar.VJ() : 0;
    }

    public b() {
        this(null);
    }
}
