package com.iqoption.withdrawal.common.methods;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.microservice.withdraw.response.PayoutFieldType;
import com.iqoption.microservice.withdraw.response.WithdrawMethodType;
import com.iqoption.microservice.withdraw.response.g;
import com.iqoption.withdrawal.common.f;
import com.iqoption.withdrawal.common.fields.WithdrawFieldsViewModel;
import com.iqoption.x.R;
import io.card.payment.CardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 =2\u00020\u0001:\u0001=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\"\u001a\n #*\u0004\u0018\u00010\u001d0\u001d2\b\b\u0001\u0010$\u001a\u00020%H\u0002J3\u0010\"\u001a\n #*\u0004\u0018\u00010\u001d0\u001d2\b\b\u0001\u0010$\u001a\u00020%2\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'\"\u00020(H\u0002¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,J\u0010\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0013H\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J \u00101\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J9\u00101\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u00132\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001032\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u00107J\u001e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f092\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fR\u001b\u0010\u0005\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, aXE = {"Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "context", "getContext", "()Landroid/app/Application;", "context$delegate", "Lkotlin/Lazy;", "fieldsViewModel", "Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsViewModel;", "prevMethodsLiveData", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/microservice/withdraw/response/CardsAndWithdrawMethods;", "compose", "Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsData;", "cardsAndMethods", "createCardAmountField", "Lcom/iqoption/microservice/withdraw/response/PayoutField;", "createCardWithdrawMethod", "Lcom/iqoption/microservice/withdraw/response/CardWithdrawMethod;", "card", "Lcom/iqoption/microservice/withdraw/response/Card;", "bankCardServerMethod", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethod;", "balanceHolder", "Lcom/iqoption/withdrawal/common/methods/BalanceHolder;", "getMethodWarningMessage", "", "method", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "availableType", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethodType;", "getString", "kotlin.jvm.PlatformType", "id", "", "arguments", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getWithdrawData", "useCache", "", "refresh", "isAmountField", "field", "networkRequest", "prepareAmountField", "commission", "", "refundAmount", "withMethodLimit", "Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;", "(Lcom/iqoption/microservice/withdraw/response/PayoutField;DLjava/lang/Double;Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;Lcom/iqoption/withdrawal/common/methods/BalanceHolder;)Lcom/iqoption/microservice/withdraw/response/PayoutField;", "prepareMethods", "", "selectMethod", "", "data", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawMethodsViewModel.kt */
public final class WithdrawMethodsViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(WithdrawMethodsViewModel.class), "context", "getContext()Landroid/app/Application;"))};
    public static final a dRN = new a();
    private final kotlin.d dRK = g.f(new WithdrawMethodsViewModel$context$2(this));
    private LiveData<com.iqoption.microservice.withdraw.response.d> dRL;
    private WithdrawFieldsViewModel dRM;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawMethodsViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final WithdrawMethodsViewModel O(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            WithdrawMethodsViewModel withdrawMethodsViewModel = (WithdrawMethodsViewModel) ViewModelProviders.b(fragmentActivity).h(WithdrawMethodsViewModel.class);
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(WithdrawFieldsViewModel.class);
            h.d(h, "ViewModelProviders.of(ac…ldsViewModel::class.java]");
            withdrawMethodsViewModel.dRM = (WithdrawFieldsViewModel) h;
            h.d(withdrawMethodsViewModel, "methodsViewModel");
            return withdrawMethodsViewModel;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* compiled from: Comparisons.kt */
    public static final class e<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            com.iqoption.withdrawal.common.a aty = ((com.iqoption.microservice.withdraw.response.a) t2).aty();
            Double d = null;
            Comparable valueOf = aty != null ? Double.valueOf(aty.getValue()) : null;
            com.iqoption.withdrawal.common.a aty2 = ((com.iqoption.microservice.withdraw.response.a) t).aty();
            if (aty2 != null) {
                d = Double.valueOf(aty2.getValue());
            }
            return b.c(valueOf, d);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/withdraw/response/CardsAndWithdrawMethods;", "onChanged", "com/iqoption/withdrawal/common/methods/WithdrawMethodsViewModel$getWithdrawData$liveData$1$2"})
    /* compiled from: WithdrawMethodsViewModel.kt */
    static final class b<T> implements Observer<S> {
        final /* synthetic */ boolean dRO;
        final /* synthetic */ boolean dRP;
        final /* synthetic */ boolean dRQ;
        final /* synthetic */ MediatorLiveData receiver$0;
        final /* synthetic */ WithdrawMethodsViewModel this$0;

        b(MediatorLiveData mediatorLiveData, WithdrawMethodsViewModel withdrawMethodsViewModel, boolean z, boolean z2, boolean z3) {
            this.receiver$0 = mediatorLiveData;
            this.this$0 = withdrawMethodsViewModel;
            this.dRO = z;
            this.dRP = z2;
            this.dRQ = z3;
        }

        /* renamed from: b */
        public final void onChanged(com.iqoption.microservice.withdraw.response.d dVar) {
            if (dVar != null || !this.dRQ) {
                this.receiver$0.postValue(dVar);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsData;", "methods", "Lcom/iqoption/microservice/withdraw/response/CardsAndWithdrawMethods;", "kotlin.jvm.PlatformType", "apply"})
    /* compiled from: WithdrawMethodsViewModel.kt */
    static final class c<I, O> implements Function<X, Y> {
        final /* synthetic */ WithdrawMethodsViewModel this$0;

        c(WithdrawMethodsViewModel withdrawMethodsViewModel) {
            this.this$0 = withdrawMethodsViewModel;
        }

        /* renamed from: c */
        public final e apply(com.iqoption.microservice.withdraw.response.d dVar) {
            return this.this$0.a(dVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/withdraw/response/CardsAndWithdrawMethods;", "onChanged"})
    /* compiled from: WithdrawMethodsViewModel.kt */
    static final class d<T> implements Observer<S> {
        final /* synthetic */ MediatorLiveData receiver$0;

        d(MediatorLiveData mediatorLiveData) {
            this.receiver$0 = mediatorLiveData;
        }

        /* renamed from: b */
        public final void onChanged(com.iqoption.microservice.withdraw.response.d dVar) {
            this.receiver$0.postValue(dVar);
        }
    }

    private final Application aNU() {
        kotlin.d dVar = this.dRK;
        j jVar = apP[0];
        return (Application) dVar.getValue();
    }

    public WithdrawMethodsViewModel(Application application) {
        h.e(application, "app");
        super(application);
    }

    public final void a(e eVar, com.iqoption.microservice.withdraw.response.a aVar) {
        h.e(eVar, "data");
        h.e(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
        WithdrawFieldsViewModel withdrawFieldsViewModel = this.dRM;
        if (withdrawFieldsViewModel == null) {
            h.lS("fieldsViewModel");
        }
        withdrawFieldsViewModel.d(new com.iqoption.withdrawal.common.fields.c(aVar, eVar.aNd(), eVar.aNe(), eVar.aNf()));
    }

    public final LiveData<e> k(boolean z, boolean z2) {
        LiveData liveData = this.dRL;
        boolean z3 = (liveData != null ? (com.iqoption.microservice.withdraw.response.d) liveData.getValue() : null) != null;
        if (z3) {
            MediatorLiveData mediatorLiveData = new MediatorLiveData();
            if (z) {
                LiveData liveData2 = this.dRL;
                if (liveData2 == null) {
                    h.aXZ();
                }
                mediatorLiveData.a(liveData2, new d(mediatorLiveData));
            }
            if (z2) {
                mediatorLiveData.a(aNV(), new b(mediatorLiveData, this, z, z2, z3));
            }
            liveData = mediatorLiveData;
        } else {
            liveData = aNV();
        }
        this.dRL = liveData;
        LiveData<e> a = Transformations.a(liveData, new c(this));
        h.d(a, "Transformations.map(live…ds -> compose(methods) })");
        return a;
    }

    private final LiveData<com.iqoption.microservice.withdraw.response.d> aNV() {
        return f.dPY.aMU();
    }

    private final e a(com.iqoption.microservice.withdraw.response.d dVar) {
        if (dVar == null) {
            return null;
        }
        com.iqoption.app.a aL = com.iqoption.app.a.aL((Context) aNU());
        int i = 1;
        Balance cG = aL.cG(1);
        if (cG == null) {
            h.aXZ();
        }
        ConversionCurrency eh = aL.eh(cG.currency);
        if (eh == null) {
            h.aXZ();
        }
        Iterable<com.iqoption.microservice.withdraw.response.b> atB = dVar.atB();
        Collection arrayList = new ArrayList(n.e(atB, 10));
        for (com.iqoption.microservice.withdraw.response.b atz : atB) {
            arrayList.add(Double.valueOf(atz.atz()));
        }
        Collection arrayList2 = new ArrayList();
        Iterator it = ((List) arrayList).iterator();
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Number) next).doubleValue() > ((double) null)) {
                i2 = 1;
            }
            if (i2 != 0) {
                arrayList2.add(next);
            }
        }
        double ad = u.ad((List) arrayList2);
        if (ad <= ((double) null)) {
            i = 0;
        }
        WithdrawMethodType withdrawMethodType = i != 0 ? WithdrawMethodType.CARD : WithdrawMethodType.COMMON;
        Application aNU = aNU();
        h.d(aNU, "context");
        Context context = aNU;
        h.d(cG, "balance");
        h.d(eh, "conversion");
        a aVar = new a(context, cG, eh, ad);
        List<com.iqoption.microservice.withdraw.response.a> a = a(dVar, aVar);
        Map linkedHashMap = new LinkedHashMap();
        for (com.iqoption.microservice.withdraw.response.a aVar2 : a) {
            String a2 = a(aVar2, withdrawMethodType, aVar);
            if (a2 != null) {
                String str = (String) linkedHashMap.put(aVar2, a2);
            }
        }
        return new e(a, cG, eh, withdrawMethodType, linkedHashMap, ad);
    }

    private final List<com.iqoption.microservice.withdraw.response.a> a(com.iqoption.microservice.withdraw.response.d dVar, a aVar) {
        a aVar2 = aVar;
        List arrayList = new ArrayList();
        for (com.iqoption.microservice.withdraw.response.h hVar : dVar.atC()) {
            if (h.E(hVar.UZ(), "bank_card")) {
                for (com.iqoption.microservice.withdraw.response.b bVar : dVar.atB()) {
                    if (bVar.atz() > ((double) 0)) {
                        arrayList.add(a(bVar, hVar, aVar2));
                    }
                }
            } else {
                List arrayList2 = new ArrayList();
                for (Object obj : hVar.atw()) {
                    Object obj2;
                    if (a((com.iqoption.microservice.withdraw.response.f) obj2)) {
                        obj2 = a((com.iqoption.microservice.withdraw.response.f) obj2, (com.iqoption.microservice.withdraw.response.a) hVar, aVar2);
                    }
                    arrayList2.add(obj2);
                }
                q.a(arrayList2, g.dRR);
                arrayList.add(com.iqoption.microservice.withdraw.response.h.a(hVar, null, 0.0d, arrayList2, 0, null, null, null, null, null, aVar2.c(hVar), 507, null));
            }
        }
        return u.a((Iterable) arrayList, (Comparator) new e());
    }

    private final com.iqoption.microservice.withdraw.response.c a(com.iqoption.microservice.withdraw.response.b bVar, com.iqoption.microservice.withdraw.response.h hVar, a aVar) {
        a aVar2 = aVar;
        String number = bVar.getNumber();
        CardType gV = com.iqoption.core.util.a.gV(number);
        if (gV == null) {
            gV = CardType.UNKNOWN;
        }
        CardType cardType = gV;
        int length = number.length() - 4;
        if (number == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        h.d(number.substring(length), "(this as java.lang.String).substring(startIndex)");
        double atz = bVar.atz();
        g d = aVar2.d(hVar);
        long id = bVar.getId();
        String string = getString(R.string.card_n1, number);
        h.d(string, "getString(R.string.card_n1, cardEndDigits)");
        return new com.iqoption.microservice.withdraw.response.c(string, 0.0d, l.cr(a(aNW(), 0.0d, Double.valueOf(atz), null, aVar2)), id, atz, bVar.atA(), cardType, hVar.atx(), aVar2.a(0.0d, Double.valueOf(atz), d));
    }

    private final boolean a(com.iqoption.microservice.withdraw.response.f fVar) {
        return h.E(fVar.getName(), "amount");
    }

    private final com.iqoption.microservice.withdraw.response.f aNW() {
        String string = getString(R.string.amount);
        h.d(string, "getString(R.string.amount)");
        return new com.iqoption.microservice.withdraw.response.f("amount", string, "front.amount", PayoutFieldType.TEXT, "\\d+|\\d+\\.\\d{1,2}", 255, true, "");
    }

    private final com.iqoption.microservice.withdraw.response.f a(com.iqoption.microservice.withdraw.response.f fVar, com.iqoption.microservice.withdraw.response.a aVar, a aVar2) {
        Double d = null;
        com.iqoption.microservice.withdraw.response.c cVar = (com.iqoption.microservice.withdraw.response.c) (!(aVar instanceof com.iqoption.microservice.withdraw.response.c) ? null : aVar);
        if (cVar != null) {
            d = Double.valueOf(cVar.atz());
        }
        return a(fVar, aVar.atv(), d, aVar2.d(aVar), aVar2);
    }

    private final com.iqoption.microservice.withdraw.response.f a(com.iqoption.microservice.withdraw.response.f fVar, double d, Double d2, g gVar, a aVar) {
        a aVar2 = aVar;
        String string = getString(R.string.up_to_n1, aVar2.a(aVar2.a(d, d2, gVar)));
        h.d(string, "getString(R.string.up_to_n1, limit)");
        return com.iqoption.microservice.withdraw.response.f.a(fVar, null, null, null, null, null, 0, false, string, 127, null);
    }

    private final String a(com.iqoption.microservice.withdraw.response.a aVar, WithdrawMethodType withdrawMethodType, a aVar2) {
        WithdrawMethodType att = aVar.att();
        if (withdrawMethodType == att) {
            return (!(aVar instanceof com.iqoption.microservice.withdraw.response.c) || ((com.iqoption.microservice.withdraw.response.c) aVar).atz() > ((double) null)) ? null : getString(R.string.amount_cannot_exeed);
        } else {
            if (att == WithdrawMethodType.CARD) {
                return getString(R.string.remaining_refund_hint_2);
            }
            return getString(R.string.you_need_first_withdraw_refund_n1, aVar2.aNP());
        }
    }

    private final String getString(@StringRes int i) {
        return getApplication().getString(i);
    }

    private final String getString(@StringRes int i, Object... objArr) {
        return getApplication().getString(i, Arrays.copyOf(objArr, objArr.length));
    }
}
