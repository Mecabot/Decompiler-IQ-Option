package com.iqoption.verify;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.mobbtech.connect.response.r;
import com.iqoption.verify.list.VerifyCardsViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\fH\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\fR\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/verify/NonVerifiedCardsViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "verifyCardsViewModel", "Lcom/iqoption/verify/list/VerifyCardsViewModel;", "filterCards", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "source", "getNotVerifiedCards", "Landroid/arch/lifecycle/LiveData;", "isCardVerificationFailed", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: NonVerifiedCardsViewModel.kt */
public final class NonVerifiedCardsViewModel extends AndroidViewModel {
    public static final a dxj = new a();
    private VerifyCardsViewModel dxi;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/verify/NonVerifiedCardsViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/verify/NonVerifiedCardsViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NonVerifiedCardsViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final NonVerifiedCardsViewModel E(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            NonVerifiedCardsViewModel nonVerifiedCardsViewModel = (NonVerifiedCardsViewModel) ViewModelProviders.b(fragmentActivity).h(NonVerifiedCardsViewModel.class);
            nonVerifiedCardsViewModel.dxi = VerifyCardsViewModel.dxT.F(fragmentActivity);
            h.d(nonVerifiedCardsViewModel, "viewModel");
            return nonVerifiedCardsViewModel;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "source", "apply"})
    /* compiled from: NonVerifiedCardsViewModel.kt */
    static final class b<I, O> implements Function<X, Y> {
        final /* synthetic */ NonVerifiedCardsViewModel dxk;

        b(NonVerifiedCardsViewModel nonVerifiedCardsViewModel) {
            this.dxk = nonVerifiedCardsViewModel;
        }

        /* renamed from: m */
        public final List<q> apply(List<q> list) {
            return this.dxk.bs(list);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "cards", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "kotlin.jvm.PlatformType", "apply"})
    /* compiled from: NonVerifiedCardsViewModel.kt */
    static final class c<I, O> implements Function<X, Y> {
        public static final c dxl = new c();

        c() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return Boolean.valueOf(aJ((List) obj));
        }

        public final boolean aJ(List<q> list) {
            q qVar = null;
            if (list != null) {
                Object obj;
                for (Object next : list) {
                    if (com.iqoption.core.ext.c.b(((q) next).auX(), CardStatus.DECLINED, CardStatus.FAILED)) {
                        obj = next;
                        break;
                    }
                }
                qVar = (q) obj;
            }
            return qVar != null;
        }
    }

    public static final NonVerifiedCardsViewModel E(FragmentActivity fragmentActivity) {
        return dxj.E(fragmentActivity);
    }

    public NonVerifiedCardsViewModel(Application application) {
        h.e(application, "app");
        super(application);
    }

    private final LiveData<List<q>> aGK() {
        VerifyCardsViewModel verifyCardsViewModel = this.dxi;
        if (verifyCardsViewModel == null) {
            h.lS("verifyCardsViewModel");
        }
        LiveData<List<q>> a = Transformations.a(verifyCardsViewModel.aGW(), new b(this));
        h.d(a, "Transformations.map(veri…-> filterCards(source) })");
        return a;
    }

    public final LiveData<Boolean> aED() {
        LiveData<Boolean> a = Transformations.a(aGK(), c.dxl);
        h.d(a, "Transformations.map(getN…NED, FAILED) } != null })");
        return a;
    }

    private final List<q> bs(List<q> list) {
        if (list == null) {
            return m.emptyList();
        }
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            CardStatus auX = ((q) next).auX();
            Object obj = (auX == CardStatus.VERIFIED || r.auZ().contains(auX)) ? null : 1;
            if (obj != null) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
