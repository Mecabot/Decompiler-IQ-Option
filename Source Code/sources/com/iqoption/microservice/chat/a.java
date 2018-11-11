package com.iqoption.microservice.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0018"}, aXE = {"Lcom/iqoption/microservice/chat/ChatAttachment;", "", "()V", "id", "", "url", "thumbnail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "isImage", "", "()Z", "getThumbnail", "getUrl", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Responses.kt */
public final class a {
    @SerializedName("thumbnail")
    private final String cPz;
    @SerializedName("id")
    private final String id;
    @SerializedName("url")
    private final String url;

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.cPz, r3.cPz) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.microservice.chat.a;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.microservice.chat.a) r3;
        r0 = r2.id;
        r1 = r3.id;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.url;
        r1 = r3.url;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.cPz;
        r3 = r3.cPz;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.microservice.chat.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.cPz;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatAttachment(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", thumbnail=");
        stringBuilder.append(this.cPz);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(String str, String str2, String str3) {
        h.e(str, "id");
        this.id = str;
        this.url = str2;
        this.cPz = str3;
    }

    public final String getId() {
        return this.id;
    }

    public /* synthetic */ a(String str, String str2, String str3, int i, f fVar) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = (String) null;
        }
        if ((i & 4) != 0) {
            str3 = (String) null;
        }
        this(str, str2, str3);
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean arf() {
        return this.cPz != null;
    }

    public a() {
        this("", null, null, 6, null);
    }
}
