package com.iqoption.gdpr;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.google.common.util.concurrent.s;
import com.iqoption.core.microservices.busapi.response.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, aXE = {"Lcom/iqoption/gdpr/GdprViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "setPersonalDataPolicy", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "policy", "Lcom/iqoption/core/microservices/busapi/response/PersonalDataPolicy;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: GdprViewModel.kt */
public final class GdprViewModel extends AndroidViewModel {
    public static final a cIh = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/gdpr/GdprViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/gdpr/GdprViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: GdprViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final GdprViewModel m(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (GdprViewModel) ViewModelProviders.b(fragmentActivity).h(GdprViewModel.class);
        }
    }

    public GdprViewModel(Application application) {
        h.e(application, "app");
        super(application);
    }

    public final s<Void> b(b bVar) {
        h.e(bVar, "policy");
        return com.iqoption.core.microservices.busapi.a.aUn.b(bVar);
    }
}
