package com.iqoption.vip;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.analytics.r;
import com.iqoption.core.a.d;
import com.iqoption.d.tx;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.Status;
import com.iqoption.util.ba;
import com.iqoption.widget.g;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/vip/VipEducationFragment;", "Lcom/iqoption/fragment/base/IQSmartFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentVipEducationBinding;", "showEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "viewModel", "Lcom/iqoption/vip/VipManagerViewModel;", "getContentView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getEventName", "", "getRequiredWidth", "", "onClose", "", "onCreateView", "onDestroyView", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VipEducationFragment.kt */
public final class i extends com.iqoption.fragment.base.i {
    private static final String TAG = "javaClass";
    public static final a dLv = new a();
    private HashMap atz;
    private VipManagerViewModel dKL;
    private tx dLu;
    private d dez;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\f"}, aXE = {"Lcom/iqoption/vip/VipEducationFragment$Companion;", "", "()V", "TAG", "", "TAG$annotations", "show", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipEducationFragment.kt */
    public static final class a {

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: VipEducationFragment.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;

            a(FragmentManager fragmentManager) {
                this.cBh = fragmentManager;
            }

            public final void run() {
                a aVar = i.dLv;
                FragmentManager fragmentManager = this.cBh;
                h.d(fragmentManager, "fm");
                aVar.e(fragmentManager);
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void u(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            PopupViewModel.cBp.j(fragmentActivity).a((Runnable) new a(fragmentActivity.getSupportFragmentManager()), i.TAG);
        }

        private final void e(FragmentManager fragmentManager) {
            fragmentManager.beginTransaction().add(R.id.fragment, new i(), i.TAG).addToBackStack(i.TAG).commitAllowingStateLoss();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: VipEducationFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ i dLw;

        b(i iVar) {
            this.dLw = iVar;
        }

        public final void onClick(View view) {
            r.ajo.Cb();
            this.dLw.onClose();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/util/Resource;", "Lcom/iqoption/microservice/vip/VipManager;", "onChanged"})
    /* compiled from: VipEducationFragment.kt */
    static final class c<T> implements Observer<ba<com.iqoption.microservice.vip.d>> {
        final /* synthetic */ i dLw;

        c(i iVar) {
            this.dLw = iVar;
        }

        /* renamed from: c */
        public final void onChanged(ba<com.iqoption.microservice.vip.d> baVar) {
            if ((baVar != null ? baVar.aGv() : null) == Status.SUCCESS) {
                com.iqoption.microservice.vip.d dVar = (com.iqoption.microservice.vip.d) baVar.getData();
                if (dVar != null) {
                    RecyclerView recyclerView = i.a(this.dLw).bFP;
                    h.d(recyclerView, "binding.contentList");
                    recyclerView.setAdapter(new h(dVar));
                }
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public String gF() {
        return "vip-education-opened";
    }

    public static final /* synthetic */ tx a(i iVar) {
        tx txVar = iVar.dLu;
        if (txVar == null) {
            h.lS("binding");
        }
        return txVar;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_vip_education, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…cation, container, false)");
        this.dLu = (tx) inflate;
        tx txVar = this.dLu;
        if (txVar == null) {
            h.lS("binding");
        }
        txVar.blw.setOnClickListener(new b(this));
        txVar = this.dLu;
        if (txVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = txVar.bFP;
        h.d(recyclerView, "binding.contentList");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        txVar = this.dLu;
        if (txVar == null) {
            h.lS("binding");
        }
        txVar.bFP.setHasFixedSize(true);
        txVar = this.dLu;
        if (txVar == null) {
            h.lS("binding");
        }
        recyclerView = txVar.bFP;
        Context context = getContext();
        if (context == null) {
            h.aXZ();
        }
        h.d(context, "context!!");
        recyclerView.addItemDecoration(new g(context.getResources().getDimensionPixelOffset(R.dimen.dp20), true, true));
        txVar = this.dLu;
        if (txVar == null) {
            h.lS("binding");
        }
        txVar.bFP.addItemDecoration(new d());
        com.iqoption.vip.VipManagerViewModel.b bVar = VipManagerViewModel.dLy;
        FragmentActivity activity = zzakw();
        if (activity == null) {
            h.aXZ();
        }
        h.d(activity, "activity!!");
        this.dKL = bVar.J(activity);
        VipManagerViewModel vipManagerViewModel = this.dKL;
        if (vipManagerViewModel == null) {
            h.lS("viewModel");
        }
        vipManagerViewModel.aKv().observe(this, new c(this));
        txVar = this.dLu;
        if (txVar == null) {
            h.lS("binding");
        }
        View root = txVar.getRoot();
        h.d(root, "binding.root");
        return root;
    }

    protected int ahd() {
        return getResources().getDimensionPixelSize(R.dimen.dp450);
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.dez = r.ajo.BQ();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        d dVar = this.dez;
        if (dVar != null) {
            dVar.Bs();
        }
        super.onDestroyView();
        KH();
    }
}
