package com.iqoption.verify.list;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.th;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.util.ar;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002*+B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0010H\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0018H\u0016J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006,"}, aXE = {"Lcom/iqoption/verify/list/VerifyCardsFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "Lcom/iqoption/verify/list/VerifyCardListener;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "adapter", "Lcom/iqoption/verify/list/VerifyCardsAdapter;", "binding", "Lcom/iqoption/databinding/FragmentVerifyCardsBinding;", "callback", "Lcom/iqoption/verify/list/VerifyCardsFragment$ShowDetailsCallback;", "getCallback", "()Lcom/iqoption/verify/list/VerifyCardsFragment$ShowDetailsCallback;", "setCallback", "(Lcom/iqoption/verify/list/VerifyCardsFragment$ShowDetailsCallback;)V", "clickedCard", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "viewModel", "Lcom/iqoption/verify/list/VerifyCardsViewModel;", "onClose", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetailsClick", "card", "onSaveInstanceState", "outState", "onViewCreated", "view", "onVisible", "showContent", "showEmpty", "showError", "showProgress", "Companion", "ShowDetailsCallback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCardsFragment.kt */
public final class f extends com.iqoption.fragment.base.f implements b, com.iqoption.view.e.a {
    public static final String TAG = "com.iqoption.verify.list.f";
    public static final a dxP = new a();
    private HashMap atz;
    private b dxK;
    private th dxL;
    private VerifyCardsViewModel dxM;
    private e dxN;
    private q dxO;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/verify/list/VerifyCardsFragment$Companion;", "", "()V", "STATE_CLICKED_CARD_ID", "", "TAG", "newInstance", "Lcom/iqoption/verify/list/VerifyCardsFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyCardsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final f aGV() {
            return new f();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/verify/list/VerifyCardsFragment$ShowDetailsCallback;", "", "showDetails", "", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyCardsFragment.kt */
    public interface b {
        void b(q qVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: VerifyCardsFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ f dxQ;

        c(f fVar) {
            this.dxQ = fVar;
        }

        public final void onClick(View view) {
            this.dxQ.aN();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "value", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "onChanged"})
    /* compiled from: VerifyCardsFragment.kt */
    static final class d<T> implements Observer<List<? extends q>> {
        final /* synthetic */ f dxQ;

        d(f fVar) {
            this.dxQ = fVar;
        }

        /* renamed from: L */
        public final void onChanged(List<q> list) {
            if (list == null) {
                this.dxQ.zy();
            } else if (list.isEmpty()) {
                this.dxQ.aGT();
            } else {
                this.dxQ.aGU();
                f.d(this.dxQ).aR(list);
                q e = this.dxQ.dxO;
                if (e != null) {
                    f.d(this.dxQ).j(e);
                }
                this.dxQ.dxO = (q) null;
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

    public static final /* synthetic */ e d(f fVar) {
        e eVar = fVar.dxN;
        if (eVar == null) {
            h.lS("adapter");
        }
        return eVar;
    }

    static {
        if (f.class.getName() == null) {
            h.aXZ();
        }
    }

    public final void a(b bVar) {
        this.dxK = bVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxM = VerifyCardsViewModel.dxT.F(com.iqoption.core.ext.a.n(this));
        if (bundle != null) {
            this.dxO = (q) bundle.getParcelable("STATE_CLICKED_CARD_ID");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        th C = th.C(layoutInflater, viewGroup, false);
        h.d(C, "this");
        this.dxL = C;
        h.d(C, "FragmentVerifyCardsBindi….apply { binding = this }");
        return C.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        th thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        view = thVar.getRoot();
        h.d(view, "binding.root");
        Toolbar toolbar = (Toolbar) view.findViewById(com.iqoption.b.a.toolbar);
        com.iqoption.kyc.i.a((AppCompatActivity) ajV(), toolbar, (int) R.string.bank_cards);
        toolbar.setNavigationOnClickListener(new c(this));
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = thVar.bFp;
        h.d(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.dxN = new e(com.iqoption.core.ext.a.m(this), this);
        e eVar = this.dxN;
        if (eVar == null) {
            h.lS("adapter");
        }
        recyclerView.setAdapter(eVar);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.separator_grey_transparent));
        recyclerView.addItemDecoration(dividerItemDecoration);
        arc();
        VerifyCardsViewModel verifyCardsViewModel = this.dxM;
        if (verifyCardsViewModel == null) {
            h.lS("viewModel");
        }
        ar.a(verifyCardsViewModel.aGW(), (Fragment) this, (Observer) new d(this));
    }

    public void aGG() {
        super.aGG();
        VerifyCardsViewModel verifyCardsViewModel = this.dxM;
        if (verifyCardsViewModel == null) {
            h.lS("viewModel");
        }
        verifyCardsViewModel.aGX();
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.e(bundle, "outState");
        q qVar = this.dxO;
        if (qVar != null) {
            bundle.putParcelable("STATE_CLICKED_CARD_ID", qVar);
        }
        super.onSaveInstanceState(bundle);
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.n(this).finish();
        return true;
    }

    private final void arc() {
        th thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = thVar.bFo;
        h.d(contentLoadingProgressBar, "binding.verifyCardsProgress");
        contentLoadingProgressBar.setVisibility(0);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        TextView textView = thVar.bFn;
        h.d(textView, "binding.verifyCardsErrorTextView");
        com.iqoption.core.ext.a.M(textView);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = thVar.bFp;
        h.d(recyclerView, "binding.verifyCardsRecyclerView");
        com.iqoption.core.ext.a.M(recyclerView);
    }

    private final void zy() {
        th thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = thVar.bFo;
        h.d(contentLoadingProgressBar, "binding.verifyCardsProgress");
        com.iqoption.core.ext.a.M(contentLoadingProgressBar);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        TextView textView = thVar.bFn;
        h.d(textView, "binding.verifyCardsErrorTextView");
        com.iqoption.core.ext.a.L(textView);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = thVar.bFp;
        h.d(recyclerView, "binding.verifyCardsRecyclerView");
        com.iqoption.core.ext.a.M(recyclerView);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        thVar.bFn.setText(R.string.unknown_error_occurred);
    }

    private final void aGT() {
        th thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = thVar.bFo;
        h.d(contentLoadingProgressBar, "binding.verifyCardsProgress");
        com.iqoption.core.ext.a.M(contentLoadingProgressBar);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        TextView textView = thVar.bFn;
        h.d(textView, "binding.verifyCardsErrorTextView");
        com.iqoption.core.ext.a.L(textView);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = thVar.bFp;
        h.d(recyclerView, "binding.verifyCardsRecyclerView");
        com.iqoption.core.ext.a.M(recyclerView);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        thVar.bFn.setText(R.string.you_have_no_added_cards);
    }

    private final void aGU() {
        th thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = thVar.bFo;
        h.d(contentLoadingProgressBar, "binding.verifyCardsProgress");
        com.iqoption.core.ext.a.M(contentLoadingProgressBar);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        TextView textView = thVar.bFn;
        h.d(textView, "binding.verifyCardsErrorTextView");
        com.iqoption.core.ext.a.M(textView);
        thVar = this.dxL;
        if (thVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = thVar.bFp;
        h.d(recyclerView, "binding.verifyCardsRecyclerView");
        com.iqoption.core.ext.a.L(recyclerView);
    }

    public void f(q qVar) {
        h.e(qVar, "card");
        this.dxO = qVar;
        b bVar = this.dxK;
        if (bVar == null) {
            h.aXZ();
        }
        bVar.b(qVar);
    }
}
