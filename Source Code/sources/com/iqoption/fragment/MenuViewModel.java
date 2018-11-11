package com.iqoption.fragment;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import java.util.concurrent.Future;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, aXE = {"Lcom/iqoption/fragment/MenuViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "forgetUser", "Lio/reactivex/Completable;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MenuViewModel.kt */
public final class MenuViewModel extends AndroidViewModel {
    public static final a cpT = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/fragment/MenuViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/fragment/MenuViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MenuViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final MenuViewModel i(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (MenuViewModel) ViewModelProviders.b(fragmentActivity).h(MenuViewModel.class);
        }
    }

    public static final MenuViewModel i(FragmentActivity fragmentActivity) {
        return cpT.i(fragmentActivity);
    }

    public MenuViewModel(Application application) {
        h.e(application, "app");
        super(application);
    }

    public final io.reactivex.a ahF() {
        io.reactivex.a a = io.reactivex.a.d((Future) com.iqoption.core.microservices.busapi.a.aUn.Vp()).b(com.iqoption.core.h.i.Yo()).a(com.iqoption.core.h.i.Yp());
        h.d(a, "Completable.fromFuture(B…           .observeOn(ui)");
        return a;
    }
}
