package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import com.iqoption.microservice.chat.g;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/microservice/chat/ChatMessage;", "invoke"})
/* compiled from: LastMessagesViewModel.kt */
final class LastMessagesViewModel$postLastMessage$1 extends Lambda implements b<MutableLiveData<g>, l> {
    final /* synthetic */ g $message;

    LastMessagesViewModel$postLastMessage$1(g gVar) {
        this.$message = gVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((MutableLiveData) obj);
        return l.etX;
    }

    public final void a(MutableLiveData<g> mutableLiveData) {
        h.e(mutableLiveData, "it");
        mutableLiveData.postValue(this.$message);
    }
}
