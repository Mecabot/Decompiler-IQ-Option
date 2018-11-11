package com.iqoption.operations;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.d.pd;
import com.iqoption.operations.OperationViewModel.FilterType;
import com.iqoption.widget.g;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\rH\u0014J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lcom/iqoption/operations/SelectOptionsFragment;", "Lcom/iqoption/operations/BaseOperationHistoryFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentOperationHistoryOptionsBinding;", "viewModel", "Lcom/iqoption/operations/OperationViewModel;", "applyListTitle", "", "filterType", "Lcom/iqoption/operations/OperationViewModel$FilterType;", "applyToolbarTitle", "getRootView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SelectOptionsFragment.kt */
public final class j extends a {
    private static final String TAG = "javaClass";
    public static final a cXP = new a();
    private HashMap atz;
    private pd cXO;
    private OperationViewModel cXj;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, aXE = {"Lcom/iqoption/operations/SelectOptionsFragment$Companion;", "", "()V", "FILTER_TYPE_EXTRA", "", "TAG", "getTAG", "()Ljava/lang/String;", "show", "", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "filterType", "Lcom/iqoption/operations/OperationViewModel$FilterType;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SelectOptionsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return j.TAG;
        }

        public final void a(FragmentManager fragmentManager, FilterType filterType) {
            h.e(fragmentManager, "fragmentManager");
            h.e(filterType, "filterType");
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            j jVar = new j();
            Bundle bundle = new Bundle();
            bundle.putString("filter_type", filterType.name());
            jVar.setArguments(bundle);
            a aVar = this;
            beginTransaction.add(R.id.fragment_container, jVar, aVar.Ll()).addToBackStack(aVar.Ll()).commitAllowingStateLoss();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: SelectOptionsFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ j this$0;

        b(j jVar) {
            this.this$0 = jVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.ext.a.n(this.this$0).onBackPressed();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/operations/OperationViewModel$FilterType;", "onChanged"})
    /* compiled from: SelectOptionsFragment.kt */
    static final class c<T> implements Observer<FilterType> {
        final /* synthetic */ FilterType $filterType;
        final /* synthetic */ i cXQ;

        c(FilterType filterType, i iVar) {
            this.$filterType = filterType;
            this.cXQ = iVar;
        }

        /* renamed from: c */
        public final void onChanged(FilterType filterType) {
            if (filterType == this.$filterType) {
                this.cXQ.notifyDataSetChanged();
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

    public static final /* synthetic */ OperationViewModel a(j jVar) {
        OperationViewModel operationViewModel = jVar.cXj;
        if (operationViewModel == null) {
            h.lS("viewModel");
        }
        return operationViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_operation_history_options, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…ptions, container, false)");
        this.cXO = (pd) inflate;
        OperationViewModel s = OperationViewModel.cXA.s(com.iqoption.core.ext.a.n(this));
        h.d(s, "OperationViewModel.get(act)");
        this.cXj = s;
        String string = com.iqoption.core.ext.a.o(this).getString("filter_type");
        h.d(string, "args.getString(FILTER_TYPE_EXTRA)");
        FilterType valueOf = FilterType.valueOf(string);
        pd pdVar = this.cXO;
        if (pdVar == null) {
            h.lS("binding");
        }
        View view = pdVar.biw;
        if (view != null) {
            view.setOnClickListener(new b(this));
        }
        OperationViewModel operationViewModel = this.cXj;
        if (operationViewModel == null) {
            h.lS("viewModel");
        }
        com.iqoption.operations.OperationViewModel.b e = operationViewModel.e(valueOf);
        OperationViewModel operationViewModel2 = this.cXj;
        if (operationViewModel2 == null) {
            h.lS("viewModel");
        }
        i iVar = new i(operationViewModel2.a(e), e.avy(), new SelectOptionsFragment$onCreateView$selectionAdapter$1(this, valueOf));
        pdVar = this.cXO;
        if (pdVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = pdVar.bzv;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(iVar);
        Drawable h = com.iqoption.core.ext.a.h(recyclerView, R.drawable.operation_history_item_separator);
        if (h != null) {
            b bVar = new b(recyclerView.getContext(), 1);
            bVar.setDrawable(h);
            recyclerView.addItemDecoration(bVar);
        }
        Context context = recyclerView.getContext();
        h.d(context, "context");
        recyclerView.addItemDecoration(new g(context.getResources().getDimensionPixelOffset(R.dimen.dp28), false, true));
        operationViewModel = this.cXj;
        if (operationViewModel == null) {
            h.lS("viewModel");
        }
        operationViewModel.avu().observe(this, new c(valueOf, iVar));
        g(valueOf);
        f(valueOf);
        pd pdVar2 = this.cXO;
        if (pdVar2 == null) {
            h.lS("binding");
        }
        return pdVar2.getRoot();
    }

    private final void f(FilterType filterType) {
        int i;
        switch (filterType) {
            case DATE:
                i = R.string.date;
                break;
            case OPERATION:
                i = R.string.operation;
                break;
            case STATUS:
                i = R.string.status;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        pd pdVar = this.cXO;
        if (pdVar == null) {
            h.lS("binding");
        }
        pdVar.bzw.setText(i);
    }

    private final void g(FilterType filterType) {
        OperationViewModel operationViewModel = this.cXj;
        if (operationViewModel == null) {
            h.lS("viewModel");
        }
        OperationViewModel operationViewModel2 = this.cXj;
        if (operationViewModel2 == null) {
            h.lS("viewModel");
        }
        int size = operationViewModel.a(operationViewModel2.e(filterType)).size();
        pd pdVar = this.cXO;
        if (pdVar == null) {
            h.lS("binding");
        }
        TextView textView = pdVar.bnk;
        h.d(textView, "binding.countTitle");
        textView.setText(getResources().getQuantityString(R.plurals.items, size, new Object[]{Integer.valueOf(size)}));
    }

    protected View getRootView() {
        pd pdVar = this.cXO;
        if (pdVar == null) {
            h.lS("binding");
        }
        View root = pdVar.getRoot();
        h.d(root, "binding.root");
        return root;
    }
}
