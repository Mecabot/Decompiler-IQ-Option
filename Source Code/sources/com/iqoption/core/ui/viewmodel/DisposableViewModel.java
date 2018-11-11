package com.iqoption.core.ui.viewmodel;

import android.arch.lifecycle.ViewModel;
import io.reactivex.disposables.a;
import io.reactivex.disposables.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0014J\f\u0010\u000b\u001a\u00020\u0007*\u00020\u0002H\u0004R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/DisposableViewModel;", "Landroid/arch/lifecycle/ViewModel;", "Lio/reactivex/disposables/Disposable;", "()V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "dispose", "", "isDisposed", "", "onCleared", "disposeOnCleared", "core_release"})
/* compiled from: DisposableViewModel.kt */
public abstract class DisposableViewModel extends ViewModel implements b {
    private final a bco = new a();

    public void dispose() {
        this.bco.clear();
    }

    public boolean isDisposed() {
        return this.bco.isDisposed();
    }

    protected final void b(b bVar) {
        h.e(bVar, "$receiver");
        this.bco.e(bVar);
    }

    protected void onCleared() {
        super.onCleared();
        dispose();
    }
}
