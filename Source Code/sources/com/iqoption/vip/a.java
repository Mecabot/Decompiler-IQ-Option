package com.iqoption.vip;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.analytics.r;
import com.iqoption.d.tt;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.Status;
import com.iqoption.util.ba;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/vip/AboutVipFragment;", "Lcom/iqoption/fragment/base/IQSmartFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentVipAboutBinding;", "showEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "viewModel", "Lcom/iqoption/vip/VipManagerViewModel;", "getContentView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getEventName", "", "getRequiredWidth", "", "onClose", "", "onCreateView", "onDestroyView", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: AboutVipFragment.kt */
public final class a extends com.iqoption.fragment.base.i {
    private static final String TAG = "javaClass";
    public static final a dKM = new a();
    private HashMap atz;
    private tt dKK;
    private VipManagerViewModel dKL;
    private com.iqoption.core.a.d dez;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u000e"}, aXE = {"Lcom/iqoption/vip/AboutVipFragment$Companion;", "", "()V", "DEFAULT_SPAN_COUNT", "", "TAG", "", "TAG$annotations", "show", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: AboutVipFragment.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: AboutVipFragment.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;

            a(FragmentManager fragmentManager) {
                this.cBh = fragmentManager;
            }

            public final void run() {
                a aVar = a.dKM;
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
            PopupViewModel.cBp.j(fragmentActivity).a((Runnable) new a(fragmentActivity.getSupportFragmentManager()), a.TAG);
        }

        private final void e(FragmentManager fragmentManager) {
            fragmentManager.beginTransaction().add(R.id.fragment, new a(), a.TAG).addToBackStack(a.TAG).commitAllowingStateLoss();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: AboutVipFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ a dKN;

        b(a aVar) {
            this.dKN = aVar;
        }

        public final void onClick(View view) {
            this.dKN.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: AboutVipFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ a dKN;

        c(a aVar) {
            this.dKN = aVar;
        }

        public final void onClick(View view) {
            r.ajo.BT();
            com.iqoption.vip.e.a aVar = e.dLc;
            FragmentActivity activity = this.dKN.zzakw();
            if (activity == null) {
                h.aXZ();
            }
            h.d(activity, "activity!!");
            com.iqoption.vip.e.a.a(aVar, activity, 0, false, 6, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, aXE = {"com/iqoption/vip/AboutVipFragment$getContentView$3$1$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: AboutVipFragment.kt */
    public static final class d extends SpanSizeLookup {
        public int getSpanSize(int i) {
            return i == 0 ? 3 : 1;
        }

        d() {
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/util/Resource;", "Lcom/iqoption/microservice/vip/VipManager;", "onChanged"})
    /* compiled from: AboutVipFragment.kt */
    static final class e<T> implements Observer<ba<com.iqoption.microservice.vip.d>> {
        final /* synthetic */ a dKN;

        e(a aVar) {
            this.dKN = aVar;
        }

        /* renamed from: c */
        public final void onChanged(ba<com.iqoption.microservice.vip.d> baVar) {
            if ((baVar != null ? baVar.aGv() : null) == Status.SUCCESS) {
                com.iqoption.microservice.vip.d dVar = (com.iqoption.microservice.vip.d) baVar.getData();
                if (dVar != null) {
                    RecyclerView recyclerView = a.a(this.dKN).bFP;
                    h.d(recyclerView, "binding.contentList");
                    recyclerView.setAdapter(new g(dVar));
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
        return "vip-about-opened";
    }

    public static final /* synthetic */ tt a(a aVar) {
        tt ttVar = aVar.dKK;
        if (ttVar == null) {
            h.lS("binding");
        }
        return ttVar;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_vip_about, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…_about, container, false)");
        this.dKK = (tt) inflate;
        tt ttVar = this.dKK;
        if (ttVar == null) {
            h.lS("binding");
        }
        ttVar.blw.setOnClickListener(new b(this));
        ttVar = this.dKK;
        if (ttVar == null) {
            h.lS("binding");
        }
        ttVar.bFO.setOnClickListener(new c(this));
        ttVar = this.dKK;
        if (ttVar == null) {
            h.lS("binding");
        }
        RecyclerView recyclerView = ttVar.bFP;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new d());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
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
        vipManagerViewModel.aKv().observe(this, new e(this));
        ttVar = this.dKK;
        if (ttVar == null) {
            h.lS("binding");
        }
        View root = ttVar.getRoot();
        h.d(root, "binding.root");
        return root;
    }

    protected int ahd() {
        return getResources().getDimensionPixelSize(R.dimen.dp450);
    }

    public boolean onClose() {
        r.ajo.BS();
        com.iqoption.core.ext.a.p(this).popBackStack();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.dez = r.ajo.BN();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        com.iqoption.core.a.d dVar = this.dez;
        if (dVar != null) {
            dVar.Bs();
        }
        super.onDestroyView();
        KH();
    }
}
