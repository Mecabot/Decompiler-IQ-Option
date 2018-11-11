package com.iqoption.vip;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.analytics.r;
import com.iqoption.d.tv;
import com.iqoption.widget.g;
import com.iqoption.x.R;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u000eJ\u001a\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006&"}, aXE = {"Lcom/iqoption/vip/ChooseTimeFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentVipChooseTimeBinding;", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "isPeriodSelected", "Lkotlin/Function2;", "", "Lcom/iqoption/vip/WorkingPeriod;", "", "periodSelected", "", "selectedDate", "selectedWorkingPeriod", "showEvent", "Lcom/iqoption/core/analytics/AnalyticsSendEvent;", "viewModel", "Lcom/iqoption/vip/VipManagerViewModel;", "clearSelectedPeriod", "notifyWorkingPeriodSelected", "date", "workingPeriod", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onHideAnimation", "onShowAnimation", "Companion", "OnWorkingPeriodSelected", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ChooseTimeFragment.kt */
public final class c extends com.iqoption.fragment.base.b {
    private static final String TAG = "javaClass";
    public static final a dKW = new a();
    private HashMap atz;
    private final Calendar calendar = Calendar.getInstance();
    private VipManagerViewModel dKL;
    private final m<Long, j, l> dKP = new ChooseTimeFragment$periodSelected$1(this);
    private final m<Long, j, Boolean> dKQ = new ChooseTimeFragment$isPeriodSelected$1(this);
    private tv dKT;
    private j dKU;
    private long dKV;
    private com.iqoption.core.a.d dez;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\n"}, aXE = {"Lcom/iqoption/vip/ChooseTimeFragment$Companion;", "", "()V", "TAG", "", "TAG$annotations", "show", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChooseTimeFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void u(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            fragmentActivity.getSupportFragmentManager().beginTransaction().add(R.id.fragment, new c(), c.TAG).addToBackStack(c.TAG).commitAllowingStateLoss();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, aXE = {"Lcom/iqoption/vip/ChooseTimeFragment$OnWorkingPeriodSelected;", "", "onWorkingPeriodSelected", "", "date", "", "workingPeriod", "Lcom/iqoption/vip/WorkingPeriod;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ChooseTimeFragment.kt */
    public interface b {
        void a(long j, j jVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/vip/ChooseTimeFragment$onCreateView$1$1"})
    /* compiled from: ChooseTimeFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ c this$0;

        c(c cVar) {
            this.this$0 = cVar;
        }

        public final void onClick(View view) {
            r.ajo.BX();
            FragmentManager fragmentManager = this.this$0.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStack();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/vip/ChooseTimeFragment$onCreateView$1$2"})
    /* compiled from: ChooseTimeFragment.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ c this$0;

        d(c cVar) {
            this.this$0 = cVar;
        }

        public final void onClick(View view) {
            r.ajo.Ca();
            FragmentManager fragmentManager = this.this$0.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStack();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/vip/ChooseTimeFragment$onCreateView$1$3"})
    /* compiled from: ChooseTimeFragment.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ c this$0;

        e(c cVar) {
            this.this$0 = cVar;
        }

        public final void onClick(View view) {
            r.ajo.BZ();
            this.this$0.b(this.this$0.dKV, this.this$0.dKU);
            FragmentManager fragmentManager = this.this$0.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.popBackStack();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    /* compiled from: ChooseTimeFragment.kt */
    static final class f implements AnimatorUpdateListener {
        final /* synthetic */ LayoutParams dKX;
        final /* synthetic */ c this$0;

        f(c cVar, LayoutParams layoutParams) {
            this.this$0 = cVar;
            this.dKX = layoutParams;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.this$0.isAdded()) {
                h.d(valueAnimator, "valueAnimator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                this.dKX.width = ((Integer) animatedValue).intValue();
                LinearLayout linearLayout = c.c(this.this$0).bFT;
                h.d(linearLayout, "binding.main");
                linearLayout.setLayoutParams(this.dKX);
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public static final /* synthetic */ tv c(c cVar) {
        tv tvVar = cVar.dKT;
        if (tvVar == null) {
            h.lS("binding");
        }
        return tvVar;
    }

    private final void b(long j, j jVar) {
        FragmentActivity activity = zzakw();
        if (!(activity instanceof b)) {
            activity = null;
        }
        b bVar = (b) activity;
        if (bVar != null) {
            bVar.a(j, jVar);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.dez = r.ajo.BP();
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_vip_choose_time, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…e_time, container, false)");
        this.dKT = (tv) inflate;
        tv tvVar = this.dKT;
        if (tvVar == null) {
            h.lS("binding");
        }
        tvVar.blw.setOnClickListener(new c(this));
        tvVar.bFS.setOnClickListener(new d(this));
        tvVar.bFQ.setOnClickListener(new e(this));
        RecyclerView recyclerView = tvVar.bFY;
        h.d(recyclerView, "todayPeriods");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        recyclerView = tvVar.bFY;
        Context context = getContext();
        if (context == null) {
            h.aXZ();
        }
        h.d(context, "context!!");
        recyclerView.addItemDecoration(new g(context.getResources().getDimensionPixelOffset(R.dimen.dp16), true, true));
        recyclerView = tvVar.bFU;
        h.d(recyclerView, "nextDayPeriods");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        recyclerView = tvVar.bFU;
        context = getContext();
        if (context == null) {
            h.aXZ();
        }
        h.d(context, "context!!");
        recyclerView.addItemDecoration(new g(context.getResources().getDimensionPixelOffset(R.dimen.dp16), true, true));
        recyclerView = tvVar.bFW;
        h.d(recyclerView, "nextNextDayPeriods");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView2 = tvVar.bFW;
        Context context2 = getContext();
        if (context2 == null) {
            h.aXZ();
        }
        h.d(context2, "context!!");
        recyclerView2.addItemDecoration(new g(context2.getResources().getDimensionPixelOffset(R.dimen.dp16), true, true));
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
        Triple aKw = vipManagerViewModel.aKw();
        if (aKw != null) {
            tv tvVar2 = this.dKT;
            if (tvVar2 == null) {
                h.lS("binding");
            }
            TextView textView = tvVar2.bFZ;
            h.d(textView, "todayTitle");
            textView.setText(((com.iqoption.vip.VipManagerViewModel.a) aKw.getFirst()).aKy());
            textView = tvVar2.bFV;
            h.d(textView, "nextDayTitle");
            textView.setText(((com.iqoption.vip.VipManagerViewModel.a) aKw.aXF()).aKy());
            textView = tvVar2.bFX;
            h.d(textView, "nextNextDayTitle");
            textView.setText(((com.iqoption.vip.VipManagerViewModel.a) aKw.aXI()).aKy());
            RecyclerView recyclerView3 = tvVar2.bFY;
            h.d(recyclerView3, "todayPeriods");
            recyclerView3.setAdapter(new b(((com.iqoption.vip.VipManagerViewModel.a) aKw.getFirst()).getDate().getTime(), ((com.iqoption.vip.VipManagerViewModel.a) aKw.getFirst()).aKz(), this.dKP, this.dKQ));
            this.calendar.add(5, 1);
            recyclerView3 = tvVar2.bFU;
            h.d(recyclerView3, "nextDayPeriods");
            recyclerView3.setAdapter(new b(((com.iqoption.vip.VipManagerViewModel.a) aKw.aXF()).getDate().getTime(), ((com.iqoption.vip.VipManagerViewModel.a) aKw.aXF()).aKz(), this.dKP, this.dKQ));
            this.calendar.add(5, 1);
            recyclerView = tvVar2.bFW;
            h.d(recyclerView, "nextNextDayPeriods");
            recyclerView.setAdapter(new b(((com.iqoption.vip.VipManagerViewModel.a) aKw.aXI()).getDate().getTime(), ((com.iqoption.vip.VipManagerViewModel.a) aKw.aXI()).aKz(), this.dKP, this.dKQ));
        }
        tvVar = this.dKT;
        if (tvVar == null) {
            h.lS("binding");
        }
        return tvVar.getRoot();
    }

    public void onDestroyView() {
        com.iqoption.core.a.d dVar = this.dez;
        if (dVar != null) {
            dVar.Bs();
        }
        super.onDestroyView();
        KH();
    }

    public void ND() {
        tv tvVar = this.dKT;
        if (tvVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = tvVar.bFT;
        h.d(linearLayout, "binding.main");
        linearLayout.setAlpha(0.0f);
        tvVar = this.dKT;
        if (tvVar == null) {
            h.lS("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tvVar.bFT, "alpha", new float[]{1.0f});
        h.d(ofFloat, "contentAlphaAnimation");
        ofFloat.setInterpolator(com.iqoption.view.a.a.d.dEM);
        ofFloat.setDuration(300);
        tv tvVar2 = this.dKT;
        if (tvVar2 == null) {
            h.lS("binding");
        }
        View root = tvVar2.getRoot();
        h.d(root, "binding.root");
        int width = root.getWidth();
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp450);
        tv tvVar3 = this.dKT;
        if (tvVar3 == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout2 = tvVar3.bFT;
        h.d(linearLayout2, "binding.main");
        LayoutParams layoutParams = linearLayout2.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{width, dimensionPixelOffset});
        ofInt.addUpdateListener(new f(this, layoutParams));
        h.d(ofInt, "widthAnimateStep");
        ofInt.setDuration(400);
        ofInt.setInterpolator(com.iqoption.view.a.a.d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt, ofFloat});
        animatorSet.start();
    }

    public void NE() {
        tv tvVar = this.dKT;
        if (tvVar == null) {
            h.lS("binding");
        }
        tvVar.bFT.animate().alpha(0.0f).scaleY(1.7f).scaleX(1.7f).setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }
}
