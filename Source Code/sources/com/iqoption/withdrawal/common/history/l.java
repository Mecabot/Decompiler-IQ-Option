package com.iqoption.withdrawal.common.history;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.uo;
import com.iqoption.fragment.base.f;
import com.iqoption.x.R;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006\""}, aXE = {"Lcom/iqoption/withdrawal/common/history/WithdrawHistoryFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "Lcom/iqoption/withdrawal/common/history/CancelClickListener;", "()V", "binding", "Lcom/iqoption/databinding/FragmentWithdrawHistoryBinding;", "cancellationIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "historyAdapter", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryAdapter;", "payouts", "", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "viewModel", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryViewModel;", "onCancelClick", "", "payout", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onViewCreated", "view", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryFragment.kt */
public final class l extends f implements b {
    public static final String TAG = "com.iqoption.withdrawal.common.history.l";
    public static final a dRq = new a();
    private HashMap atz;
    private List<com.iqoption.microservice.withdraw.response.l> dRb;
    private uo dRm;
    private WithdrawHistoryViewModel dRn;
    private j dRo;
    private HashSet<Long> dRp;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/withdrawal/common/history/WithdrawHistoryFragment$Companion;", "", "()V", "STATE_CANCELLATION_IDS", "", "TAG", "newInstance", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawHistoryFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final l aNI() {
            return new l();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Ljava/lang/Void;", "onChanged"})
    /* compiled from: WithdrawHistoryFragment.kt */
    static final class b<T> implements Observer<Void> {
        final /* synthetic */ com.iqoption.microservice.withdraw.response.l dRj;
        final /* synthetic */ l dRr;

        b(l lVar, com.iqoption.microservice.withdraw.response.l lVar2) {
            this.dRr = lVar;
            this.dRj = lVar2;
        }

        /* renamed from: f */
        public final void onChanged(Void voidR) {
            l.b(this.dRr).remove(Long.valueOf(this.dRj.getId()));
            l.c(this.dRr).aNO();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "value", "", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "onChanged"})
    /* compiled from: WithdrawHistoryFragment.kt */
    static final class c<T> implements Observer<List<? extends com.iqoption.microservice.withdraw.response.l>> {
        final /* synthetic */ l dRr;

        c(l lVar) {
            this.dRr = lVar;
        }

        /* renamed from: L */
        public final void onChanged(List<com.iqoption.microservice.withdraw.response.l> list) {
            this.dRr.dRb = list;
            if (list != null) {
                l.a(this.dRr).a(new a(list, l.b(this.dRr)));
            } else {
                l.a(this.dRr).zy();
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ HashSet b(l lVar) {
        HashSet hashSet = lVar.dRp;
        if (hashSet == null) {
            h.lS("cancellationIds");
        }
        return hashSet;
    }

    public static final /* synthetic */ WithdrawHistoryViewModel c(l lVar) {
        WithdrawHistoryViewModel withdrawHistoryViewModel = lVar.dRn;
        if (withdrawHistoryViewModel == null) {
            h.lS("viewModel");
        }
        return withdrawHistoryViewModel;
    }

    static {
        if (l.class.getName() == null) {
            h.aXZ();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Serializable serializable = bundle != null ? bundle.getSerializable("STATE_CANCELLATION_IDS") : null;
        if (!(serializable instanceof HashSet)) {
            serializable = null;
        }
        HashSet hashSet = (HashSet) serializable;
        if (hashSet == null) {
            hashSet = new HashSet();
        }
        this.dRp = hashSet;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        uo H = uo.H(layoutInflater, viewGroup, false);
        h.d(H, "this");
        this.dRm = H;
        h.d(H, "FragmentWithdrawHistoryB….apply { binding = this }");
        return H.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.dRo = new j(com.iqoption.core.ext.a.m(this), this);
        uo uoVar = this.dRm;
        if (uoVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = uoVar.bHm;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setAutoMeasureEnabled(true);
        h.d(recyclerView, "historyRecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        j jVar = this.dRo;
        if (jVar == null) {
            h.lS("historyAdapter");
        }
        recyclerView.setAdapter(jVar);
        recyclerView.setNestedScrollingEnabled(false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(com.iqoption.core.ext.a.m(this), 1);
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.separator_grey));
        recyclerView.addItemDecoration(dividerItemDecoration);
        j jVar2 = this.dRo;
        if (jVar2 == null) {
            h.lS("historyAdapter");
        }
        jVar2.arc();
        WithdrawHistoryViewModel N = WithdrawHistoryViewModel.dRx.N(com.iqoption.core.ext.a.n(this));
        h.d(N, "WithdrawHistoryViewModel.create(act)");
        this.dRn = N;
        N = this.dRn;
        if (N == null) {
            h.lS("viewModel");
        }
        N.aNN().observe(this, new c(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.e(bundle, "outState");
        String str = "STATE_CANCELLATION_IDS";
        HashSet hashSet = this.dRp;
        if (hashSet == null) {
            h.lS("cancellationIds");
        }
        bundle.putSerializable(str, hashSet);
        super.onSaveInstanceState(bundle);
    }

    public void a(com.iqoption.microservice.withdraw.response.l lVar) {
        h.e(lVar, "payout");
        HashSet hashSet = this.dRp;
        if (hashSet == null) {
            h.lS("cancellationIds");
        }
        hashSet.add(Long.valueOf(lVar.getId()));
        List list = this.dRb;
        if (list != null) {
            j jVar = this.dRo;
            if (jVar == null) {
                h.lS("historyAdapter");
            }
            HashSet hashSet2 = this.dRp;
            if (hashSet2 == null) {
                h.lS("cancellationIds");
            }
            jVar.a(new a(list, hashSet2));
        }
        WithdrawHistoryViewModel withdrawHistoryViewModel = this.dRn;
        if (withdrawHistoryViewModel == null) {
            h.lS("viewModel");
        }
        withdrawHistoryViewModel.e(lVar).observe(this, new b(this, lVar));
    }
}
