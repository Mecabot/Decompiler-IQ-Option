package com.iqoption.launcher;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.google.common.util.concurrent.s;
import com.iqoption.util.af;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\t"}, aXE = {"Lcom/iqoption/launcher/LauncherViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "isDocumentsNeeded", "Landroid/arch/lifecycle/LiveData;", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LauncherViewModel.kt */
public final class LauncherViewModel extends AndroidViewModel {
    public static final a cNN = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/launcher/LauncherViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/launcher/LauncherViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LauncherViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final LauncherViewModel q(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (LauncherViewModel) ViewModelProviders.b(fragmentActivity).h(LauncherViewModel.class);
        }
    }

    public static final LauncherViewModel q(FragmentActivity fragmentActivity) {
        return cNN.q(fragmentActivity);
    }

    public LauncherViewModel(Application application) {
        h.e(application, "app");
        super(application);
    }

    public final LiveData<Boolean> aqD() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        s eb = com.iqoption.microservice.a.a.eb(false);
        h.d(eb, "KycBusRequests.getKycDocumentsStatus(false)");
        af.a(eb, new LauncherViewModel$isDocumentsNeeded$1(mutableLiveData), new LauncherViewModel$isDocumentsNeeded$2(this, mutableLiveData), null, 4, null);
        return mutableLiveData;
    }
}
