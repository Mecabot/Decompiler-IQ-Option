package com.iqoption.quiz.api.response.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, aXE = {"Lcom/iqoption/quiz/api/response/chat/ChatMessageSendSocket;", "", "roomId", "", "text", "isLargeText", "", "requestId", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "()Z", "getRequestId", "()Ljava/lang/String;", "getRoomId", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "quiz_release"})
/* compiled from: ChatMessageSendSocket.kt */
public final class d {
    @SerializedName("room_id")
    private final String aUv;
    @SerializedName("request_id")
    private final String cPL;
    @SerializedName("is_large_text")
    private final boolean dji;
    @SerializedName("text")
    private final String text;

    public d() {
        this(null, null, false, null, 15, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (h.E(this.aUv, dVar.aUv) && h.E(this.text, dVar.text)) {
                return (this.dji == dVar.dji ? 1 : null) != null && h.E(this.cPL, dVar.cPL);
            }
        }
    }

    public int hashCode() {
        String str = this.aUv;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.dji;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str2 = this.cPL;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatMessageSendSocket(roomId=");
        stringBuilder.append(this.aUv);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", isLargeText=");
        stringBuilder.append(this.dji);
        stringBuilder.append(", requestId=");
        stringBuilder.append(this.cPL);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(String str, String str2, boolean z, String str3) {
        h.e(str, "roomId");
        h.e(str2, "text");
        h.e(str3, "requestId");
        this.aUv = str;
        this.text = str2;
        this.dji = z;
        this.cPL = str3;
    }

    public final String Re() {
        return this.aUv;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean aAP() {
        return this.dji;
    }

    public /* synthetic */ d(String str, String str2, boolean z, String str3, int i, f fVar) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str3 = "";
        }
        this(str, str2, z, str3);
    }

    public final String auD() {
        return this.cPL;
    }
}
