package com.iqoption.verify.status;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.MainThread;
import android.support.v4.app.FragmentActivity;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.verify.list.VerifyCardsViewModel;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/verify/status/VerifyStatusViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "verifyCardsViewModel", "Lcom/iqoption/verify/list/VerifyCardsViewModel;", "getCard", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "id", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyStatusViewModel.kt */
public final class VerifyStatusViewModel extends AndroidViewModel {
    public static final a dyC = new a();
    private VerifyCardsViewModel dxi;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/verify/status/VerifyStatusViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/verify/status/VerifyStatusViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyStatusViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final VerifyStatusViewModel G(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            VerifyStatusViewModel verifyStatusViewModel = (VerifyStatusViewModel) ViewModelProviders.b(fragmentActivity).h(VerifyStatusViewModel.class);
            verifyStatusViewModel.dxi = VerifyCardsViewModel.dxT.F(fragmentActivity);
            h.d(verifyStatusViewModel, "viewModel");
            return verifyStatusViewModel;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "cards", "", "apply"})
    /* compiled from: VerifyStatusViewModel.kt */
    static final class b<I, O> implements Function<X, Y> {
        final /* synthetic */ long ath;

        b(long j) {
            this.ath = j;
        }

        /* renamed from: bw */
        public final q apply(List<q> list) {
            q qVar = null;
            if (list == null) {
                return null;
            }
            for (q next : list) {
                Object obj;
                if (next.getId() == this.ath) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    qVar = next;
                    break;
                }
            }
            return qVar;
        }
    }

    public VerifyStatusViewModel(Application application) {
        h.e(application, "application");
        super(application);
    }

    @MainThread
    public final LiveData<q> co(long j) {
        VerifyCardsViewModel verifyCardsViewModel = this.dxi;
        if (verifyCardsViewModel == null) {
            h.lS("verifyCardsViewModel");
        }
        LiveData<q> a = Transformations.a(verifyCardsViewModel.aGW(), new b(j));
        h.d(a, "Transformations.map(veri…?.find { it.id == id } })");
        return a;
    }
}
