package com.iqoption.operations;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.pg;
import com.iqoption.util.ba;
import com.iqoption.widget.g;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\t\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0014J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006!"}, aXE = {"Lcom/iqoption/operations/OperationSearchResultFragment;", "Lcom/iqoption/operations/BaseOperationHistoryFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentOperationSearchResultBinding;", "currentlyLoading", "", "hasMore", "listListener", "com/iqoption/operations/OperationSearchResultFragment$listListener$1", "Lcom/iqoption/operations/OperationSearchResultFragment$listListener$1;", "resultAdapter", "Lcom/iqoption/operations/OperationSearchResultAdapter;", "viewModel", "Lcom/iqoption/operations/OperationViewModel;", "getRootView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "", "outState", "onViewCreated", "view", "performSearch", "offset", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OperationSearchResultFragment.kt */
public final class f extends a {
    private static final String TAG = "javaClass";
    public static final a cXs = new a();
    private boolean aWg = true;
    private HashMap atz;
    private OperationViewModel cXj;
    private pg cXp;
    private e cXq;
    private final b cXr = new b(this);
    private boolean clL;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/operations/OperationSearchResultFragment$Companion;", "", "()V", "INITIAL_SEARCH_STATE_DONE", "", "TAG", "getTAG", "()Ljava/lang/String;", "VISIBLE_THREAD_HOLD", "", "show", "", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationSearchResultFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return f.TAG;
        }

        public final void e(FragmentManager fragmentManager) {
            h.e(fragmentManager, "fragmentManager");
            a aVar = this;
            fragmentManager.beginTransaction().add(R.id.fragment_container, new f(), aVar.Ll()).addToBackStack(aVar.Ll()).commitAllowingStateLoss();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: OperationSearchResultFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ f cXt;

        c(f fVar) {
            this.cXt = fVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.ext.a.n(this.cXt).onBackPressed();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, aXE = {"com/iqoption/operations/OperationSearchResultFragment$listListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationSearchResultFragment.kt */
    public static final class b extends OnScrollListener {
        final /* synthetic */ f cXt;

        b(f fVar) {
            this.cXt = fVar;
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            h.e(recyclerView, "recyclerView");
            i = recyclerView.getChildCount();
            if (i != 0 && recyclerView.getAdapter() != null && this.cXt.aWg) {
                i = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i - 1));
                if (!this.cXt.clL) {
                    Adapter adapter = recyclerView.getAdapter();
                    h.d(adapter, "recyclerView.adapter");
                    if (i > adapter.getItemCount() - 15) {
                        f fVar = this.cXt;
                        Adapter adapter2 = recyclerView.getAdapter();
                        h.d(adapter2, "recyclerView.adapter");
                        fVar.fB(adapter2.getItemCount());
                    }
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/util/Resource;", "Lcom/iqoption/operations/OperationViewModel$OperationsResult;", "onChanged"})
    /* compiled from: OperationSearchResultFragment.kt */
    static final class d<T> implements Observer<ba<com.iqoption.operations.OperationViewModel.d>> {
        final /* synthetic */ f cXt;
        final /* synthetic */ int cXu;

        d(f fVar, int i) {
            this.cXt = fVar;
            this.cXu = i;
        }

        /* renamed from: c */
        public final void onChanged(ba<com.iqoption.operations.OperationViewModel.d> baVar) {
            if (baVar != null) {
                RecyclerView recyclerView;
                LinearLayout linearLayout;
                switch (baVar.aGv()) {
                    case SUCCESS:
                        if (this.cXu == 0) {
                            f.a(this.cXt).bnO.hide();
                            Object data = baVar.getData();
                            if (data == null) {
                                h.aXZ();
                            }
                            if (((com.iqoption.operations.OperationViewModel.d) data).getItems().isEmpty()) {
                                recyclerView = f.a(this.cXt).bzy;
                                h.d(recyclerView, "binding.resultList");
                                recyclerView.setVisibility(8);
                                linearLayout = f.a(this.cXt).bzx;
                                h.d(linearLayout, "binding.notFound");
                                linearLayout.setVisibility(0);
                                f.a(this.cXt).bzw.setText(R.string.no_operation_found);
                            } else {
                                TextView textView = f.a(this.cXt).bzw;
                                h.d(textView, "binding.toolbarTitle");
                                textView.setText(this.cXt.getString(R.string.operation_found_n1, String.valueOf(((com.iqoption.operations.OperationViewModel.d) baVar.getData()).avC())));
                                f.b(this.cXt).notifyDataSetChanged();
                                this.cXt.aWg = ((com.iqoption.operations.OperationViewModel.d) baVar.getData()).VW();
                            }
                        } else {
                            f.b(this.cXt).notifyDataSetChanged();
                            f fVar = this.cXt;
                            Object data2 = baVar.getData();
                            if (data2 == null) {
                                h.aXZ();
                            }
                            fVar.aWg = ((com.iqoption.operations.OperationViewModel.d) data2).VW();
                        }
                        this.cXt.clL = false;
                        return;
                    case ERROR:
                        f.a(this.cXt).bnO.hide();
                        recyclerView = f.a(this.cXt).bzy;
                        h.d(recyclerView, "binding.resultList");
                        recyclerView.setVisibility(8);
                        linearLayout = f.a(this.cXt).bzx;
                        h.d(linearLayout, "binding.notFound");
                        linearLayout.setVisibility(0);
                        f.a(this.cXt).bzw.setText(R.string.no_operation_found);
                        this.cXt.clL = false;
                        this.cXt.aWg = false;
                        return;
                    default:
                        return;
                }
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

    public static final /* synthetic */ pg a(f fVar) {
        pg pgVar = fVar.cXp;
        if (pgVar == null) {
            h.lS("binding");
        }
        return pgVar;
    }

    public static final /* synthetic */ e b(f fVar) {
        e eVar = fVar.cXq;
        if (eVar == null) {
            h.lS("resultAdapter");
        }
        return eVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.cXp = (pg) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_operation_search_result, viewGroup, false, 4, null);
        OperationViewModel s = OperationViewModel.cXA.s(com.iqoption.core.ext.a.n(this));
        h.d(s, "OperationViewModel.get(act)");
        this.cXj = s;
        if (bundle == null) {
            s = this.cXj;
            if (s == null) {
                h.lS("viewModel");
            }
            s.avw();
        }
        OperationViewModel operationViewModel = this.cXj;
        if (operationViewModel == null) {
            h.lS("viewModel");
        }
        this.cXq = new e(operationViewModel.avv());
        pg pgVar = this.cXp;
        if (pgVar == null) {
            h.lS("binding");
        }
        View view = pgVar.biw;
        if (view != null) {
            view.setOnClickListener(new c(this));
        }
        pgVar = this.cXp;
        if (pgVar == null) {
            h.lS("binding");
        }
        pgVar.bzw.setText(R.string.search);
        pgVar = this.cXp;
        if (pgVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = pgVar.bzy;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        e eVar = this.cXq;
        if (eVar == null) {
            h.lS("resultAdapter");
        }
        recyclerView.setAdapter(eVar);
        recyclerView.addOnScrollListener(this.cXr);
        Context context = recyclerView.getContext();
        h.d(context, "context");
        recyclerView.addItemDecoration(new g(context.getResources().getDimensionPixelOffset(R.dimen.dp28), false, true));
        pgVar = this.cXp;
        if (pgVar == null) {
            h.lS("binding");
        }
        return pgVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        if (bundle == null || !bundle.getBoolean("initial_done_state", false)) {
            a(this, 0, 1, null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        String str = "initial_done_state";
        e eVar = this.cXq;
        if (eVar == null) {
            h.lS("resultAdapter");
        }
        bundle.putBoolean(str, eVar.getItemCount() != 0);
    }

    static /* synthetic */ void a(f fVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        fVar.fB(i);
    }

    private final void fB(int i) {
        if (i == 0) {
            pg pgVar = this.cXp;
            if (pgVar == null) {
                h.lS("binding");
            }
            pgVar.bnO.show();
        }
        OperationViewModel operationViewModel = this.cXj;
        if (operationViewModel == null) {
            h.lS("viewModel");
        }
        operationViewModel.fC(i).observe(this, new d(this, i));
    }

    protected View getRootView() {
        pg pgVar = this.cXp;
        if (pgVar == null) {
            h.lS("binding");
        }
        View root = pgVar.getRoot();
        h.d(root, "binding.root");
        return root;
    }
}
