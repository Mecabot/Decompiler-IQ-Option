package com.iqoption.chat.component;

import android.support.v4.app.NotificationCompat;
import com.iqoption.microservice.chat.g;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, aXE = {"Lcom/iqoption/chat/component/AttachmentItem;", "Lcom/iqoption/chat/component/MessageAdapterItem;", "Lcom/iqoption/chat/component/Bubbled;", "msg", "Lcom/iqoption/microservice/chat/ChatMessage;", "attachment", "Lcom/iqoption/microservice/chat/ChatAttachment;", "bubble", "", "(Lcom/iqoption/microservice/chat/ChatMessage;Lcom/iqoption/microservice/chat/ChatAttachment;I)V", "getAttachment", "()Lcom/iqoption/microservice/chat/ChatAttachment;", "getBubble", "()I", "getMsg", "()Lcom/iqoption/microservice/chat/ChatMessage;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageAdapterItems.kt */
public final class a extends y {
    private final g aCS;
    private final com.iqoption.microservice.chat.a aCT;
    private final int bubble;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (h.E(this.aCS, aVar.aCS) && h.E(this.aCT, aVar.aCT)) {
                if ((Oz() == aVar.Oz() ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        g gVar = this.aCS;
        int i = 0;
        int hashCode = (gVar != null ? gVar.hashCode() : 0) * 31;
        com.iqoption.microservice.chat.a aVar = this.aCT;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return ((hashCode + i) * 31) + Oz();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AttachmentItem(msg=");
        stringBuilder.append(this.aCS);
        stringBuilder.append(", attachment=");
        stringBuilder.append(this.aCT);
        stringBuilder.append(", bubble=");
        stringBuilder.append(Oz());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final g Ox() {
        return this.aCS;
    }

    public final com.iqoption.microservice.chat.a Oy() {
        return this.aCT;
    }

    public a(g gVar, com.iqoption.microservice.chat.a aVar, int i) {
        h.e(gVar, NotificationCompat.CATEGORY_MESSAGE);
        h.e(aVar, "attachment");
        super();
        this.aCS = gVar;
        this.aCT = aVar;
        this.bubble = i;
    }

    public int Oz() {
        return this.bubble;
    }
}
