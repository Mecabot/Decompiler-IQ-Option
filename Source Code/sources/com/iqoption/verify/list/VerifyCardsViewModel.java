package com.iqoption.verify.list;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.iqoption.mobbtech.connect.response.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bJ\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/verify/list/VerifyCardsViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "localStatusRepository", "Lcom/iqoption/verify/VerifyLocalStatusesRepository;", "prevRefreshLiveData", "Landroid/arch/lifecycle/LiveData;", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "verifyCardsLiveData", "Landroid/arch/lifecycle/MediatorLiveData;", "applyCards", "", "source", "loadVerifyCards", "persistLocalStatuses", "cards", "refreshVerifyCards", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCardsViewModel.kt */
public final class VerifyCardsViewModel extends AndroidViewModel {
    private static final String TAG = "com.iqoption.verify.list.VerifyCardsViewModel";
    public static final a dxT = new a();
    private final com.iqoption.verify.b dsp;
    private final MediatorLiveData<List<q>> dxR = new MediatorLiveData();
    private LiveData<List<q>> dxS;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/verify/list/VerifyCardsViewModel$Companion;", "", "()V", "TAG", "", "create", "Lcom/iqoption/verify/list/VerifyCardsViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyCardsViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final VerifyCardsViewModel F(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(VerifyCardsViewModel.class);
            h.d(h, "ViewModelProviders.of(ac…rdsViewModel::class.java]");
            return (VerifyCardsViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return b.c(Long.valueOf(((q) t).getId()), Long.valueOf(((q) t2).getId()));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: VerifyCardsViewModel.kt */
    static final class c implements Runnable {
        public static final c dxU = new c();

        c() {
        }

        public final void run() {
            com.iqoption.core.i.i(VerifyCardsViewModel.TAG, "card statuses updated");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "onChanged"})
    /* compiled from: VerifyCardsViewModel.kt */
    static final class d<T> implements Observer<S> {
        final /* synthetic */ VerifyCardsViewModel dxV;

        d(VerifyCardsViewModel verifyCardsViewModel) {
            this.dxV = verifyCardsViewModel;
        }

        /* renamed from: L */
        public final void onChanged(List<q> list) {
            this.dxV.bu(list);
        }
    }

    public VerifyCardsViewModel(Application application) {
        h.e(application, "application");
        super(application);
        this.dsp = com.iqoption.verify.b.dxt.bU(application);
    }

    static {
        if (VerifyCardsViewModel.class.getName() == null) {
            h.aXZ();
        }
    }

    public final LiveData<List<q>> aGW() {
        aGX();
        return this.dxR;
    }

    public final void aGX() {
        long userId = com.iqoption.app.a.aL((Context) getApplication()).getUserId();
        LiveData liveData = this.dxS;
        if (liveData != null) {
            this.dxR.a(liveData);
        }
        LiveData cm = com.iqoption.verify.a.dxq.cm(userId);
        this.dxR.a(cm, new d(this));
        this.dxS = cm;
    }

    private final void bu(List<q> list) {
        List a = list != null ? u.a((Iterable) list, (Comparator) new b()) : null;
        if (a != null || this.dxR.getValue() == null) {
            this.dxR.postValue(a);
        }
        if (a != null) {
            bv(a);
        }
    }

    private final void bv(List<q> list) {
        Iterable<q> iterable = list;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (q d : iterable) {
            arrayList.add(com.iqoption.verify.d.dxx.d(d));
        }
        this.dsp.bt((List) arrayList).a(c.dxU, com.iqoption.core.d.a.aSc);
    }
}
