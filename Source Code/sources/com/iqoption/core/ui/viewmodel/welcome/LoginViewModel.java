package com.iqoption.core.ui.viewmodel.welcome;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.iqoption.core.data.b.c;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/LoginViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "email", "", "getEmail", "()Ljava/lang/String;", "isProgressShown", "Landroid/arch/lifecycle/LiveData;", "", "()Landroid/arch/lifecycle/LiveData;", "isProgressShownData", "Lcom/iqoption/core/data/livedata/IQMutableLiveData;", "route", "Lcom/iqoption/core/ui/viewmodel/welcome/WelcomeScreen;", "getRoute", "routeData", "Landroid/arch/lifecycle/MutableLiveData;", "toastMessage", "getToastMessage", "toastMessageData", "login", "", "password", "Companion", "core_release"})
/* compiled from: LoginViewModel.kt */
public final class LoginViewModel extends ViewModel {
    private static final String TAG = "LoginViewModel";
    public static final a bcF = new a();
    private final LiveData<Boolean> bcA = this.bcz;
    private final MutableLiveData<String> bcB = new MutableLiveData();
    private final LiveData<String> bcC = this.bcB;
    private final MutableLiveData<c> bcD = new MutableLiveData();
    private final LiveData<c> bcE = this.bcD;
    private final c<Boolean> bcz = new c(Boolean.valueOf(false));
    private final String email = com.iqoption.core.data.d.a.aOz.EH();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/welcome/LoginViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/core/ui/viewmodel/welcome/LoginViewModel;", "f", "Landroid/support/v4/app/Fragment;", "core_release"})
    /* compiled from: LoginViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }
}
