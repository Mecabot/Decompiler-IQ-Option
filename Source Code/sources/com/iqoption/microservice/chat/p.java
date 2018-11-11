package com.iqoption.microservice.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, aXE = {"Lcom/iqoption/microservice/chat/ChatTypingInfo;", "", "roomId", "", "user", "Lcom/iqoption/microservice/chat/ChatTypingUser;", "(Ljava/lang/String;Lcom/iqoption/microservice/chat/ChatTypingUser;)V", "getRoomId", "()Ljava/lang/String;", "getUser", "()Lcom/iqoption/microservice/chat/ChatTypingUser;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Events.kt */
public final class p {
    @SerializedName("room_id")
    private final String aUv;
    @SerializedName("user")
    private final q cQz;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.cQz, r3.cQz) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.microservice.chat.p;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.microservice.chat.p) r3;
        r0 = r2.aUv;
        r1 = r3.aUv;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.cQz;
        r3 = r3.cQz;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.microservice.chat.p.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.aUv;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        q qVar = this.cQz;
        if (qVar != null) {
            i = qVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatTypingInfo(roomId=");
        stringBuilder.append(this.aUv);
        stringBuilder.append(", user=");
        stringBuilder.append(this.cQz);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final String Re() {
        return this.aUv;
    }

    public final q arR() {
        return this.cQz;
    }
}
