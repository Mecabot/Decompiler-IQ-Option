package com.iqoption.charttools.constructor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.AnyThread;
import android.support.v4.app.FragmentActivity;
import com.iqoption.charttools.model.indicator.h;
import com.iqoption.core.data.b.b;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/charttools/constructor/IndicatorOutputViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "output", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "getOutput", "()Landroid/arch/lifecycle/LiveData;", "outputData", "Lcom/iqoption/core/data/livedata/IQLiveEvent;", "publishOutput", "", "publishOutput$techtools_release", "Companion", "techtools_release"})
/* compiled from: IndicatorOutputViewModel.kt */
public final class IndicatorOutputViewModel extends ViewModel {
    public static final a atv = new a();
    private final b<h> att = new b();
    private final LiveData<h> atu = this.att;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/constructor/IndicatorOutputViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/charttools/constructor/IndicatorOutputViewModel;", "a", "Landroid/support/v4/app/FragmentActivity;", "techtools_release"})
    /* compiled from: IndicatorOutputViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final IndicatorOutputViewModel d(FragmentActivity fragmentActivity) {
            kotlin.jvm.internal.h.e(fragmentActivity, com.iqoption.fragment.cashbox.deppage.a.TAG);
            Factory factory = (Factory) null;
            ViewModelProvider b = ViewModelProviders.b(fragmentActivity);
            kotlin.jvm.internal.h.d(b, "ViewModelProviders.of(a)");
            ViewModel h = b.h(IndicatorOutputViewModel.class);
            kotlin.jvm.internal.h.d(h, "if (factory != null) {\n …f(a)\n    }[T::class.java]");
            return (IndicatorOutputViewModel) h;
        }
    }

    public final LiveData<h> KB() {
        return this.atu;
    }

    @AnyThread
    public final void d(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "output");
        com.iqoption.core.ext.a.a((MutableLiveData) this.att, (Object) hVar);
    }
}
