package com.iqoption.fragment.cashbox.deppage;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/fragment/cashbox/deppage/DepositSelectorViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "depositMethod", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/fragment/cashbox/deppage/DepositMethod;", "getDepositMethod", "()Landroid/arch/lifecycle/LiveData;", "depositMethodData", "Landroid/arch/lifecycle/MutableLiveData;", "select", "", "method", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DepositSelectorViewModel.kt */
public final class DepositSelectorViewModel extends ViewModel {
    private final MutableLiveData<DepositMethod> czn = new MutableLiveData();

    public final LiveData<DepositMethod> akU() {
        return this.czn;
    }

    public final void b(DepositMethod depositMethod) {
        h.e(depositMethod, b.METHOD);
        this.czn.setValue(depositMethod);
    }
}
