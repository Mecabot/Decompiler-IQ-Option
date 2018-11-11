package com.iqoption.chat.component;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.iqoption.microservice.chat.n;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, aXE = {"Lcom/iqoption/chat/component/RoomViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/chat/component/RoomBinding;", "(Lcom/iqoption/chat/component/RoomBinding;)V", "getBinding", "()Lcom/iqoption/chat/component/RoomBinding;", "bound", "Lcom/iqoption/microservice/chat/ChatRoom;", "getBound", "()Lcom/iqoption/microservice/chat/ChatRoom;", "setBound", "(Lcom/iqoption/microservice/chat/ChatRoom;)V", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomViewHolder.kt */
public final class ai extends ViewHolder {
    private final ah aEA;
    private n aEz;

    public ai(ah ahVar) {
        h.e(ahVar, "binding");
        super(ahVar.getRoot());
        this.aEA = ahVar;
    }

    public final ah Pi() {
        return this.aEA;
    }

    public final n Ph() {
        return this.aEz;
    }

    public final void d(n nVar) {
        this.aEz = nVar;
    }
}
