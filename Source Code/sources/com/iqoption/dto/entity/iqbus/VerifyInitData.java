package com.iqoption.dto.entity.iqbus;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, aXE = {"Lcom/iqoption/dto/entity/iqbus/VerifyInitData;", "", "token", "", "secret", "uuid", "callbackUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCallbackUrl", "()Ljava/lang/String;", "getSecret", "getToken", "getUuid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyInitResult.kt */
public final class VerifyInitData {
    @SerializedName("callback_url")
    private final String callbackUrl;
    @SerializedName("secret")
    private final String secret;
    @SerializedName("token")
    private final String token;
    @SerializedName("uuid")
    private final String uuid;

    public static /* synthetic */ VerifyInitData copy$default(VerifyInitData verifyInitData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyInitData.token;
        }
        if ((i & 2) != 0) {
            str2 = verifyInitData.secret;
        }
        if ((i & 4) != 0) {
            str3 = verifyInitData.uuid;
        }
        if ((i & 8) != 0) {
            str4 = verifyInitData.callbackUrl;
        }
        return verifyInitData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.secret;
    }

    public final String component3() {
        return this.uuid;
    }

    public final String component4() {
        return this.callbackUrl;
    }

    public final VerifyInitData copy(String str, String str2, String str3, String str4) {
        h.e(str, "token");
        h.e(str2, "secret");
        h.e(str3, "uuid");
        h.e(str4, "callbackUrl");
        return new VerifyInitData(str, str2, str3, str4);
    }

    /* JADX WARNING: Missing block: B:10:0x002e, code:
            if (kotlin.jvm.internal.h.E(r2.callbackUrl, r3.callbackUrl) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.dto.entity.iqbus.VerifyInitData;
        if (r0 == 0) goto L_0x0031;
    L_0x0006:
        r3 = (com.iqoption.dto.entity.iqbus.VerifyInitData) r3;
        r0 = r2.token;
        r1 = r3.token;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0012:
        r0 = r2.secret;
        r1 = r3.secret;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x001c:
        r0 = r2.uuid;
        r1 = r3.uuid;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0026:
        r0 = r2.callbackUrl;
        r3 = r3.callbackUrl;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0033;
    L_0x0031:
        r3 = 0;
        return r3;
    L_0x0033:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dto.entity.iqbus.VerifyInitData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.token;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.secret;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.uuid;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.callbackUrl;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerifyInitData(token=");
        stringBuilder.append(this.token);
        stringBuilder.append(", secret=");
        stringBuilder.append(this.secret);
        stringBuilder.append(", uuid=");
        stringBuilder.append(this.uuid);
        stringBuilder.append(", callbackUrl=");
        stringBuilder.append(this.callbackUrl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public VerifyInitData(String str, String str2, String str3, String str4) {
        h.e(str, "token");
        h.e(str2, "secret");
        h.e(str3, "uuid");
        h.e(str4, "callbackUrl");
        this.token = str;
        this.secret = str2;
        this.uuid = str3;
        this.callbackUrl = str4;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getCallbackUrl() {
        return this.callbackUrl;
    }
}
