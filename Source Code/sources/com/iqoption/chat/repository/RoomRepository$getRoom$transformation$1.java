package com.iqoption.chat.repository;

import com.iqoption.microservice.chat.n;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/microservice/chat/ChatRoom;", "it", "", "invoke"})
/* compiled from: RoomRepository.kt */
final class RoomRepository$getRoom$transformation$1 extends Lambda implements b<List<? extends n>, n> {
    final /* synthetic */ String $id;

    RoomRepository$getRoom$transformation$1(String str) {
        this.$id = str;
        super(1);
    }

    /* renamed from: T */
    public final n invoke(List<n> list) {
        n nVar = null;
        if (list == null) {
            return null;
        }
        for (n next : list) {
            if (h.E(next.getId(), this.$id)) {
                nVar = next;
                break;
            }
        }
        return nVar;
    }
}
