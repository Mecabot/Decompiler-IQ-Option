package com.iqoption.core.microservices.b.a;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, aXE = {"Lcom/iqoption/core/microservices/chat/response/ChatSuggestions;", "", "roomId", "", "suggestions", "", "Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;", "(Ljava/lang/String;Ljava/util/List;)V", "getRoomId", "()Ljava/lang/String;", "getSuggestions", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"})
/* compiled from: ChatSuggestions.kt */
public final class b {
    @SerializedName("suggestions")
    private final List<a> aLM;
    @SerializedName("room_id")
    private final String aUv;

    public b() {
        this(null, null, 3, null);
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.aLM, r3.aLM) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.b.a.b;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.b.a.b) r3;
        r0 = r2.aUv;
        r1 = r3.aUv;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.aLM;
        r3 = r3.aLM;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.b.a.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.aUv;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.aLM;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChatSuggestions(roomId=");
        stringBuilder.append(this.aUv);
        stringBuilder.append(", suggestions=");
        stringBuilder.append(this.aLM);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(String str, List<a> list) {
        h.e(str, "roomId");
        h.e(list, "suggestions");
        this.aUv = str;
        this.aLM = list;
    }

    public /* synthetic */ b(String str, List list, int i, f fVar) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            list = m.emptyList();
        }
        this(str, list);
    }

    public final List<a> Vz() {
        return this.aLM;
    }
}
