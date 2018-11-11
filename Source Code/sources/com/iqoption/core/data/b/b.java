package com.iqoption.core.data.b;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.MainThread;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0017J\u0017\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/data/livedata/IQLiveEvent;", "T", "Landroid/arch/lifecycle/MutableLiveData;", "()V", "mPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "call", "", "observe", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "observer", "Landroid/arch/lifecycle/Observer;", "setValue", "t", "(Ljava/lang/Object;)V", "Companion", "core_release"})
/* compiled from: IQLiveEvent.kt */
public final class b<T> extends MutableLiveData<T> {
    private static final String TAG = "b";
    public static final a aOq = new a();
    private final AtomicBoolean aOp = new AtomicBoolean(false);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/core/data/livedata/IQLiveEvent$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "core_release"})
    /* compiled from: IQLiveEvent.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "T", "t", "onChanged", "(Ljava/lang/Object;)V"})
    /* compiled from: IQLiveEvent.kt */
    static final class b<T> implements Observer<T> {
        final /* synthetic */ b aOr;
        final /* synthetic */ Observer aOs;

        b(b bVar, Observer observer) {
            this.aOr = bVar;
            this.aOs = observer;
        }

        public final void onChanged(T t) {
            if (this.aOr.aOp.compareAndSet(true, false)) {
                this.aOs.onChanged(t);
            }
        }
    }

    @MainThread
    public void observe(LifecycleOwner lifecycleOwner, Observer<T> observer) {
        h.e(lifecycleOwner, "owner");
        h.e(observer, "observer");
        if (hasActiveObservers()) {
            com.iqoption.core.i.w(TAG, "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(lifecycleOwner, new b(this, observer));
    }

    @MainThread
    public void setValue(T t) {
        this.aOp.set(true);
        super.setValue(t);
    }
}
