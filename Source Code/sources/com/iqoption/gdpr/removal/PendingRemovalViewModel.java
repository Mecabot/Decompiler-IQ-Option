package com.iqoption.gdpr.removal;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import java.util.concurrent.Future;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, aXE = {"Lcom/iqoption/gdpr/removal/PendingRemovalViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "cancelForgetUser", "Lio/reactivex/Completable;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PendingRemovalViewModel.kt */
public final class PendingRemovalViewModel extends ViewModel {
    public static final a cIx = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/gdpr/removal/PendingRemovalViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/gdpr/removal/PendingRemovalViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PendingRemovalViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final PendingRemovalViewModel o(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (PendingRemovalViewModel) ViewModelProviders.b(fragmentActivity).h(PendingRemovalViewModel.class);
        }
    }

    public final io.reactivex.a aou() {
        io.reactivex.a a = io.reactivex.a.d((Future) com.iqoption.core.microservices.busapi.a.aUn.Vq()).b(com.iqoption.core.h.i.Yo()).a(com.iqoption.core.h.i.Yp());
        h.d(a, "Completable.fromFuture(B…           .observeOn(ui)");
        return a;
    }
}
