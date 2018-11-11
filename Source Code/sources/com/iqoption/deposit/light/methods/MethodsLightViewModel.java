package com.iqoption.deposit.light.methods;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.b;
import com.iqoption.deposit.DepositSelectionViewModel;
import com.iqoption.deposit.r;
import com.iqoption.deposit.time.MethodTimeUnit;
import java.util.Map;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, aXE = {"Lcom/iqoption/deposit/light/methods/MethodsLightViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "depositSelectionViewModel", "Lcom/iqoption/deposit/DepositSelectionViewModel;", "methodsTimeMap", "", "", "Lcom/iqoption/deposit/time/MethodTime;", "getMethodsTimeMap", "()Ljava/util/Map;", "methodsTimeMap$delegate", "Lkotlin/Lazy;", "currentMethod", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "getMethodTimeString", "", "payMethod", "loadedCashbox", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "selectMethod", "", "Companion", "deposit_release"})
/* compiled from: MethodsLightViewModel.kt */
public final class MethodsLightViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(MethodsLightViewModel.class), "methodsTimeMap", "getMethodsTimeMap()Ljava/util/Map;"))};
    public static final a cbc = new a();
    private DepositSelectionViewModel bWd;
    private final d cbb = g.f(MethodsLightViewModel$methodsTimeMap$2.cbd);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/light/methods/MethodsLightViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/deposit/light/methods/MethodsLightViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "deposit_release"})
    /* compiled from: MethodsLightViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final MethodsLightViewModel C(Fragment fragment) {
            h.e(fragment, "fragment");
            MethodsLightViewModel methodsLightViewModel = (MethodsLightViewModel) ViewModelProviders.d(fragment).h(MethodsLightViewModel.class);
            methodsLightViewModel.bWd = DepositSelectionViewModel.bVO.u(fragment);
            h.d(methodsLightViewModel, "viewModel");
            return methodsLightViewModel;
        }
    }

    private final Map<Integer, com.iqoption.deposit.time.a> adt() {
        d dVar = this.cbb;
        j jVar = apP[0];
        return (Map) dVar.getValue();
    }

    public MethodsLightViewModel(Application application) {
        h.e(application, "app");
        super(application);
    }

    public final LiveData<b> aaI() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaI();
    }

    public final void f(PayMethod payMethod) {
        h.e(payMethod, "payMethod");
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        depositSelectionViewModel.f(payMethod);
    }

    public final LiveData<PayMethod> aaJ() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaJ();
    }

    public final String m(PayMethod payMethod) {
        h.e(payMethod, "payMethod");
        com.iqoption.deposit.time.a aVar = (com.iqoption.deposit.time.a) adt().get(Integer.valueOf((int) payMethod.UQ()));
        Application application = getApplication();
        Integer num = null;
        if ((aVar != null ? aVar.aef() : null) == MethodTimeUnit.INSTANT) {
            return application.getString(r.h.instantly);
        }
        if (aVar == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar.getMin() != null) {
            stringBuilder.append(String.valueOf(aVar.getMin()));
        }
        CharSequence charSequence = stringBuilder;
        Object obj = null;
        if (!((charSequence.length() > 0 ? 1 : null) == null || aVar.aee() == null)) {
            stringBuilder.append("-");
            stringBuilder.append(String.valueOf(aVar.aee()));
        }
        if (charSequence.length() > 0) {
            obj = 1;
        }
        if (!(obj == null || aVar.aef() == null)) {
            MethodTimeUnit aef = aVar.aef();
            if (aef != null) {
                switch (aef) {
                    case MINUTES:
                        num = Integer.valueOf(r.h.minutes);
                        break;
                    case HOURS:
                        num = Integer.valueOf(r.h.hour3);
                        break;
                    case DAYS:
                        num = Integer.valueOf(r.h.days3);
                        break;
                }
            }
            if (num != null) {
                String string = application.getString(num.intValue());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(' ');
                stringBuilder2.append(string);
                stringBuilder.append(stringBuilder2.toString());
            }
        }
        return stringBuilder.toString();
    }
}
