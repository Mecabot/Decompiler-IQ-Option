package com.iqoption.core.microservices.usersettings.b.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/microservices/usersettings/response/config/PrivacySettingsConfig;", "", "()V", "allowShareDeals", "", "(Ljava/lang/Boolean;)V", "getAllowShareDeals", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/iqoption/core/microservices/usersettings/response/config/PrivacySettingsConfig;", "equals", "other", "hashCode", "", "toString", "", "core_release"})
/* compiled from: PrivacySettingsConfig.kt */
public final class a {
    @SerializedName("allow_share_deals")
    private final Boolean aZz;

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.aZz, ((com.iqoption.core.microservices.usersettings.b.a.a) r2).aZz) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.core.microservices.usersettings.b.a.a;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.core.microservices.usersettings.b.a.a) r2;
        r0 = r1.aZz;
        r2 = r2.aZz;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.usersettings.b.a.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Boolean bool = this.aZz;
        return bool != null ? bool.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PrivacySettingsConfig(allowShareDeals=");
        stringBuilder.append(this.aZz);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(Boolean bool) {
        this.aZz = bool;
    }

    public final Boolean XN() {
        return this.aZz;
    }

    public a() {
        this(null);
    }
}
