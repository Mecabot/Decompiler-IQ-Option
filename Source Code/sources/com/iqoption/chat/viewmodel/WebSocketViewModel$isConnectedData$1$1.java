package com.iqoption.chat.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
/* compiled from: WebSocketViewModel.kt */
final class WebSocketViewModel$isConnectedData$1$1 extends Lambda implements b<Void, l> {
    final /* synthetic */ MutableLiveData receiver$0;

    WebSocketViewModel$isConnectedData$1$1(MutableLiveData mutableLiveData) {
        this.receiver$0 = mutableLiveData;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((Void) obj);
        return l.etX;
    }

    public final void b(Void voidR) {
        this.receiver$0.postValue(Boolean.valueOf(true));
    }
}
