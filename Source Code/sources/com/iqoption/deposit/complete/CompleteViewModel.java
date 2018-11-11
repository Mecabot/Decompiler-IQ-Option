package com.iqoption.deposit.complete;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import io.reactivex.c.f;
import io.reactivex.e;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/complete/CompleteViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "realBalance", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/data/mediators/BalanceData;", "currencyName", "", "Companion", "deposit_release"})
/* compiled from: CompleteViewModel.kt */
public final class CompleteViewModel extends ViewModel {
    private static final String TAG = "com.iqoption.deposit.complete.CompleteViewModel";
    public static final a bWO = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, aXE = {"Lcom/iqoption/deposit/complete/CompleteViewModel$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "create", "Lcom/iqoption/deposit/complete/CompleteViewModel;", "f", "Landroid/support/v4/app/Fragment;", "deposit_release"})
    /* compiled from: CompleteViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final CompleteViewModel x(Fragment fragment) {
            h.e(fragment, "f");
            Factory factory = (Factory) null;
            ViewModelProvider d = ViewModelProviders.d(fragment);
            h.d(d, "ViewModelProviders.of(f)");
            ViewModel h = d.h(CompleteViewModel.class);
            h.d(h, "if (factory != null) {\n …f(f)\n    }[T::class.java]");
            return (CompleteViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/data/mediators/BalanceData;", "kotlin.jvm.PlatformType", "balances", "", "apply"})
    /* compiled from: CompleteViewModel.kt */
    static final class b<T, R> implements f<T, org.a.b<? extends R>> {
        final /* synthetic */ String bWP;

        b(String str) {
            this.bWP = str;
        }

        /* renamed from: J */
        public final e<com.iqoption.core.data.c.a> apply(List<com.iqoption.core.data.c.a> list) {
            e<com.iqoption.core.data.c.a> bW;
            h.e(list, "balances");
            for (Object next : list) {
                Object obj;
                com.iqoption.core.data.c.a aVar = (com.iqoption.core.data.c.a) next;
                if (aVar.isReal() && h.E(aVar.SA(), this.bWP)) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    break;
                }
            }
            Object next2 = null;
            com.iqoption.core.data.c.a aVar2 = (com.iqoption.core.data.c.a) next2;
            if (aVar2 != null) {
                bW = e.bW(aVar2);
                if (bW != null) {
                    return bW;
                }
            }
            bW = e.aVU();
            h.d(bW, "Flowable.empty()");
            return bW;
        }
    }

    static {
        if (CompleteViewModel.class.getName() == null) {
            h.aXZ();
        }
    }

    public final e<com.iqoption.core.data.c.a> he(String str) {
        h.e(str, "currencyName");
        e<com.iqoption.core.data.c.a> a = com.iqoption.core.data.c.b.aOv.SB().a((f) new b(str));
        h.d(a, "BalanceMediator.observeB…?: Flowable.empty()\n    }");
        return a;
    }
}
