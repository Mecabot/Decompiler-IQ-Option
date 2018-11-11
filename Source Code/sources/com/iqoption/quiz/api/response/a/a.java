package com.iqoption.quiz.api.response.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, aXE = {"Lcom/iqoption/quiz/api/response/chat/ChatMessageDeleted;", "", "()V", "messageId", "", "roomId", "", "(JLjava/lang/String;)V", "getMessageId", "()J", "getRoomId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "quiz_release"})
/* compiled from: ChatMessageDeleted.kt */
public final class a {
    @SerializedName("room_id")
    private final String aUv;
    @SerializedName("message_id")
    private final long djd;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return ((this.djd > aVar.djd ? 1 : (this.djd == aVar.djd ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.aUv, aVar.aUv);
        }
    }

    public int hashCode() {
        long j = this.djd;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.aUv;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatMessageDeleted(messageId=");
        stringBuilder.append(this.djd);
        stringBuilder.append(", roomId=");
        stringBuilder.append(this.aUv);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(long j, String str) {
        h.e(str, "roomId");
        this.djd = j;
        this.aUv = str;
    }

    public final long aAL() {
        return this.djd;
    }

    public /* synthetic */ a(long j, String str, int i, f fVar) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        this(j, str);
    }

    public a() {
        this(0, null, 2, null);
    }
}
