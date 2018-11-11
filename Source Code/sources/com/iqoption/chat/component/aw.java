package com.iqoption.chat.component;

import android.arch.lifecycle.Observer;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B-\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/chat/component/VHObserver;", "T", "Landroid/arch/lifecycle/Observer;", "validator", "Lkotlin/Function1;", "", "handler", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onChanged", "event", "(Ljava/lang/Object;)V", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VHObserver.kt */
public final class aw<T> implements Observer<T> {
    private final b<T, Boolean> aFk;
    private final b<T, l> aFl;

    public aw(b<? super T, Boolean> bVar, b<? super T, l> bVar2) {
        h.e(bVar, "validator");
        h.e(bVar2, "handler");
        this.aFk = bVar;
        this.aFl = bVar2;
    }

    public void onChanged(T t) {
        if (t != null && ((Boolean) this.aFk.invoke(t)).booleanValue()) {
            this.aFl.invoke(t);
        }
    }
}
