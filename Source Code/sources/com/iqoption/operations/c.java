package com.iqoption.operations;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.d.pa;
import com.iqoption.operations.OperationViewModel.FilterType;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lcom/iqoption/operations/OperationHistoryFragment;", "Landroid/support/v4/app/Fragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentOperationHistoryBinding;", "viewModel", "Lcom/iqoption/operations/OperationViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "performSearch", "", "selectOptions", "filterType", "Lcom/iqoption/operations/OperationViewModel$FilterType;", "updateSelectionTextForType", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OperationHistoryFragment.kt */
public final class c extends Fragment {
    private static final String TAG = "com.iqoption.operations.c";
    public static final a cXk = new a();
    private HashMap atz;
    private pa cXi;
    private OperationViewModel cXj;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/operations/OperationHistoryFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: OperationHistoryFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return c.TAG;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/operations/OperationHistoryFragment$onCreateView$2$1"})
    /* compiled from: OperationHistoryFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ c cXl;

        b(c cVar) {
            this.cXl = cVar;
        }

        public final void onClick(View view) {
            com.iqoption.core.ext.a.n(this.cXl).onBackPressed();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/operations/OperationHistoryFragment$onCreateView$2$2"})
    /* compiled from: OperationHistoryFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ c cXl;

        c(c cVar) {
            this.cXl = cVar;
        }

        public final void onClick(View view) {
            this.cXl.avr();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/operations/OperationHistoryFragment$onCreateView$2$3"})
    /* compiled from: OperationHistoryFragment.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ c cXl;

        d(c cVar) {
            this.cXl = cVar;
        }

        public final void onClick(View view) {
            this.cXl.b(FilterType.OPERATION);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/operations/OperationHistoryFragment$onCreateView$2$4"})
    /* compiled from: OperationHistoryFragment.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ c cXl;

        e(c cVar) {
            this.cXl = cVar;
        }

        public final void onClick(View view) {
            this.cXl.b(FilterType.STATUS);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/operations/OperationHistoryFragment$onCreateView$2$5"})
    /* compiled from: OperationHistoryFragment.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ c cXl;

        f(c cVar) {
            this.cXl = cVar;
        }

        public final void onClick(View view) {
            this.cXl.b(FilterType.DATE);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/operations/OperationViewModel$FilterType;", "onChanged"})
    /* compiled from: OperationHistoryFragment.kt */
    static final class g<T> implements Observer<FilterType> {
        final /* synthetic */ c cXl;

        g(c cVar) {
            this.cXl = cVar;
        }

        /* renamed from: c */
        public final void onChanged(FilterType filterType) {
            if (filterType != null) {
                c cVar = this.cXl;
                h.d(filterType, "it");
                cVar.a(filterType);
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

    static {
        h.d(c.class.getName(), "OperationHistoryFragment::class.java.name");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.cXi = (pa) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_operation_history, viewGroup, false, 4, null);
        OperationViewModel s = OperationViewModel.cXA.s(com.iqoption.core.ext.a.n(this));
        h.d(s, "OperationViewModel.get(act)");
        this.cXj = s;
        s = this.cXj;
        if (s == null) {
            h.lS("viewModel");
        }
        s.avu().observe(this, new g(this));
        pa paVar = this.cXi;
        if (paVar == null) {
            h.lS("binding");
        }
        View view = paVar.biw;
        if (view != null) {
            view.setOnClickListener(new b(this));
        }
        paVar.bzs.setOnClickListener(new c(this));
        paVar.bzq.setOnClickListener(new d(this));
        paVar.bzt.setOnClickListener(new e(this));
        paVar.bzn.setOnClickListener(new f(this));
        a(FilterType.OPERATION);
        a(FilterType.STATUS);
        a(FilterType.DATE);
        paVar = this.cXi;
        if (paVar == null) {
            h.lS("binding");
        }
        return paVar.getRoot();
    }

    private final void a(FilterType filterType) {
        OperationViewModel operationViewModel = this.cXj;
        if (operationViewModel == null) {
            h.lS("viewModel");
        }
        String d = operationViewModel.d(filterType);
        pa paVar;
        TextView textView;
        switch (filterType) {
            case OPERATION:
                paVar = this.cXi;
                if (paVar == null) {
                    h.lS("binding");
                }
                textView = paVar.bzr;
                h.d(textView, "binding.operationFilter");
                textView.setText(d);
                return;
            case STATUS:
                paVar = this.cXi;
                if (paVar == null) {
                    h.lS("binding");
                }
                textView = paVar.bzu;
                h.d(textView, "binding.statusFilter");
                textView.setText(d);
                return;
            case DATE:
                paVar = this.cXi;
                if (paVar == null) {
                    h.lS("binding");
                }
                textView = paVar.bzo;
                h.d(textView, "binding.dateFilter");
                textView.setText(d);
                return;
            default:
                return;
        }
    }

    private final void b(FilterType filterType) {
        j.cXP.a(com.iqoption.core.ext.a.p(this), filterType);
    }

    private final void avr() {
        f.cXs.e(com.iqoption.core.ext.a.p(this));
    }
}
