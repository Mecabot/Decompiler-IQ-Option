package com.iqoption.withdrawal.common.fields.verify;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.google.common.util.concurrent.s;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.util.af;
import com.iqoption.verify.list.VerifyCardsViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r0\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "cardsWarning", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "docLiveData", "Landroid/arch/lifecycle/MediatorLiveData;", "docWarning", "refreshDocLiveData", "Landroid/arch/lifecycle/LiveData;", "verifyCardsViewModel", "Lcom/iqoption/verify/list/VerifyCardsViewModel;", "warningsLiveData", "", "getCardsWarning", "getDocWarning", "getVerificationWarnings", "postValueIfAllLoaded", "", "refreshCardsWaring", "refreshDocWarning", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawVerifyViewModel.kt */
public final class WithdrawVerifyViewModel extends ViewModel {
    public static final a dQT = new a();
    private MediatorLiveData<List<d>> dQO;
    private MediatorLiveData<d> dQP = new MediatorLiveData();
    private LiveData<d> dQQ;
    private d dQR;
    private d dQS;
    private VerifyCardsViewModel dxi;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawVerifyViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final WithdrawVerifyViewModel M(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            WithdrawVerifyViewModel withdrawVerifyViewModel = (WithdrawVerifyViewModel) ViewModelProviders.b(fragmentActivity).h(WithdrawVerifyViewModel.class);
            withdrawVerifyViewModel.dxi = VerifyCardsViewModel.dxT.F(fragmentActivity);
            h.d(withdrawVerifyViewModel, "viewModel");
            return withdrawVerifyViewModel;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "cards", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "apply"})
    /* compiled from: WithdrawVerifyViewModel.kt */
    static final class b<I, O> implements Function<X, Y> {
        public static final b dQU = new b();

        b() {
        }

        /* renamed from: bC */
        public final d apply(List<q> list) {
            List list2;
            if (list != null) {
                Collection arrayList = new ArrayList();
                for (Object next : list) {
                    if ((((q) next).auX() != CardStatus.VERIFIED ? 1 : null) != null) {
                        arrayList.add(next);
                    }
                }
                list2 = (List) arrayList;
            } else {
                list2 = m.emptyList();
            }
            if (list2.isEmpty()) {
                return new e(VerificationWarningType.NONE);
            }
            return new a(list2);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "onChanged"})
    /* compiled from: WithdrawVerifyViewModel.kt */
    static final class c<T> implements Observer<S> {
        final /* synthetic */ WithdrawVerifyViewModel dQV;

        c(WithdrawVerifyViewModel withdrawVerifyViewModel) {
            this.dQV = withdrawVerifyViewModel;
        }

        /* renamed from: a */
        public final void onChanged(d dVar) {
            this.dQV.dQR = dVar;
            this.dQV.aNx();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "onChanged"})
    /* compiled from: WithdrawVerifyViewModel.kt */
    static final class d<T> implements Observer<S> {
        final /* synthetic */ WithdrawVerifyViewModel dQV;

        d(WithdrawVerifyViewModel withdrawVerifyViewModel) {
            this.dQV = withdrawVerifyViewModel;
        }

        /* renamed from: a */
        public final void onChanged(d dVar) {
            this.dQV.dQS = dVar;
            this.dQV.aNx();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "onChanged"})
    /* compiled from: WithdrawVerifyViewModel.kt */
    static final class e<T> implements Observer<S> {
        final /* synthetic */ WithdrawVerifyViewModel dQV;

        e(WithdrawVerifyViewModel withdrawVerifyViewModel) {
            this.dQV = withdrawVerifyViewModel;
        }

        /* renamed from: a */
        public final void onChanged(d dVar) {
            this.dQV.dQP.postValue(dVar);
        }
    }

    public final LiveData<List<d>> aNw() {
        MediatorLiveData mediatorLiveData;
        if (this.dQO == null) {
            mediatorLiveData = new MediatorLiveData();
            mediatorLiveData.a(aNy(), new c(this));
            mediatorLiveData.a(aNA(), new d(this));
            this.dQO = mediatorLiveData;
        }
        aNz();
        aNB();
        mediatorLiveData = this.dQO;
        if (mediatorLiveData == null) {
            h.aXZ();
        }
        return mediatorLiveData;
    }

    private final void aNx() {
        if (this.dQR != null && this.dQS != null) {
            MediatorLiveData mediatorLiveData = this.dQO;
            if (mediatorLiveData == null) {
                h.aXZ();
            }
            d[] dVarArr = new d[2];
            d dVar = this.dQR;
            if (dVar == null) {
                h.aXZ();
            }
            dVarArr[0] = dVar;
            dVar = this.dQS;
            if (dVar == null) {
                h.aXZ();
            }
            dVarArr[1] = dVar;
            Collection arrayList = new ArrayList();
            for (Object next : m.listOf(dVarArr)) {
                if ((((d) next).aNr() != VerificationWarningType.NONE ? 1 : null) != null) {
                    arrayList.add(next);
                }
            }
            mediatorLiveData.postValue((List) arrayList);
        }
    }

    private final LiveData<d> aNy() {
        aNz();
        return this.dQP;
    }

    public final void aNz() {
        LiveData liveData = this.dQQ;
        if (liveData != null) {
            this.dQP.a(liveData);
        }
        MutableLiveData mutableLiveData = new MutableLiveData();
        LiveData liveData2 = mutableLiveData;
        this.dQP.a(liveData2, new e(this));
        s eb = com.iqoption.microservice.a.a.eb(false);
        h.d(eb, "KycBusRequests.getKycDocumentsStatus(false)");
        af.a(eb, new WithdrawVerifyViewModel$refreshDocWarning$3(mutableLiveData), new WithdrawVerifyViewModel$refreshDocWarning$4(mutableLiveData), null, 4, null);
        this.dQQ = liveData2;
    }

    private final LiveData<d> aNA() {
        if (com.iqoption.app.managers.feature.a.HR()) {
            VerifyCardsViewModel verifyCardsViewModel = this.dxi;
            if (verifyCardsViewModel == null) {
                h.lS("verifyCardsViewModel");
            }
            LiveData<d> a = Transformations.a(verifyCardsViewModel.aGW(), b.dQU);
            h.d(a, "Transformations.map(veri…\n            }\n        })");
            return a;
        }
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.postValue(new e(VerificationWarningType.NONE));
        return mediatorLiveData;
    }

    public final void aNB() {
        VerifyCardsViewModel verifyCardsViewModel = this.dxi;
        if (verifyCardsViewModel == null) {
            h.lS("verifyCardsViewModel");
        }
        verifyCardsViewModel.aGX();
    }
}
