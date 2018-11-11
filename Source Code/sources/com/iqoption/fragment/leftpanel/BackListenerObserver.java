package com.iqoption.fragment.leftpanel;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.iqoption.view.e;
import com.iqoption.view.e.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/fragment/leftpanel/BackListenerObserver;", "Landroid/arch/lifecycle/LifecycleObserver;", "Lcom/iqoption/view/BackController$OnBackListener;", "controller", "Lcom/iqoption/view/BackController;", "onBackClick", "Lkotlin/Function0;", "", "(Lcom/iqoption/view/BackController;Lkotlin/jvm/functions/Function0;)V", "onBackPressed", "registerListener", "", "unregisterListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: BackListenerObserver.kt */
public final class BackListenerObserver implements LifecycleObserver, a {
    private final e cDf;
    private final kotlin.jvm.a.a<Boolean> cDg;

    public BackListenerObserver(e eVar, kotlin.jvm.a.a<Boolean> aVar) {
        h.e(eVar, "controller");
        h.e(aVar, "onBackClick");
        this.cDf = eVar;
        this.cDg = aVar;
    }

    public boolean onBackPressed() {
        return ((Boolean) this.cDg.invoke()).booleanValue();
    }

    @OnLifecycleEvent(R = Event.ON_CREATE)
    public final void registerListener() {
        this.cDf.a(this);
    }

    @OnLifecycleEvent(R = Event.ON_DESTROY)
    public final void unregisterListener() {
        this.cDf.b(this);
    }
}
