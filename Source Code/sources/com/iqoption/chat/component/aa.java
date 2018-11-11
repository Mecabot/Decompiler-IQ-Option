package com.iqoption.chat.component;

import android.support.v4.app.NotificationCompat;
import com.iqoption.microservice.chat.g;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, aXE = {"Lcom/iqoption/chat/component/MessageItem;", "Lcom/iqoption/chat/component/MessageAdapterItem;", "Lcom/iqoption/chat/component/Bubbled;", "msg", "Lcom/iqoption/microservice/chat/ChatMessage;", "bubble", "", "(Lcom/iqoption/microservice/chat/ChatMessage;I)V", "getBubble", "()I", "getMsg", "()Lcom/iqoption/microservice/chat/ChatMessage;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageAdapterItems.kt */
public final class aa extends y {
    private final g aCS;
    private final int bubble;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof aa) {
            aa aaVar = (aa) obj;
            if (h.E(this.aCS, aaVar.aCS)) {
                if ((Oz() == aaVar.Oz() ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        g gVar = this.aCS;
        return ((gVar != null ? gVar.hashCode() : 0) * 31) + Oz();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MessageItem(msg=");
        stringBuilder.append(this.aCS);
        stringBuilder.append(", bubble=");
        stringBuilder.append(Oz());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final g Ox() {
        return this.aCS;
    }

    public aa(g gVar, int i) {
        h.e(gVar, NotificationCompat.CATEGORY_MESSAGE);
        super();
        this.aCS = gVar;
        this.bubble = i;
    }

    public int Oz() {
        return this.bubble;
    }
}
