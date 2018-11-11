package com.iqoption.tutorial;

import android.app.Activity;
import android.databinding.ViewStubProxy;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.td;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.tutorial.a.k;
import com.iqoption.tutorial.dictionary.TutorialAction;
import com.iqoption.tutorial.utils.DialogOrientation;
import com.iqoption.tutorial.utils.PointerRotation;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u000b\u001a\u00060\fR\u00020\rX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000¨\u0006,"}, aXE = {"Lcom/iqoption/tutorial/TutorialFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentTutorialBinding;", "coolDownSeconds", "", "getCoolDownSeconds", "()J", "coolDownSeconds$delegate", "Lkotlin/Lazy;", "eventBuilder", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "listener", "Lcom/iqoption/tutorial/TutorialFragment$TutorialCloseListener;", "type", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "getType", "()Lcom/iqoption/tutorial/dictionary/TutorialAction;", "type$delegate", "viewModel", "Lcom/iqoption/tutorial/TutorialViewModel;", "close", "", "stepDoneType", "Lcom/iqoption/tutorial/StepDoneType;", "getAnalyticsEventName", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "placeView", "point", "Landroid/graphics/Point;", "Companion", "TutorialCloseListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialFragment.kt */
public final class c extends com.iqoption.fragment.base.f {
    private static final String TAG = "com.iqoption.tutorial.c";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), Param.TYPE, "getType()Lcom/iqoption/tutorial/dictionary/TutorialAction;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "coolDownSeconds", "getCoolDownSeconds()J"))};
    private static final List<PointerRotation> dtX = l.cr(PointerRotation.RIGHT_TO_LEFT);
    public static final a dtY = new a();
    private Builder aFE;
    private HashMap atz;
    private final kotlin.d den = g.f(new TutorialFragment$type$2(this));
    private final kotlin.d dtT = g.f(new TutorialFragment$coolDownSeconds$2(this));
    private td dtU;
    private TutorialViewModel dtV;
    private b dtW;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J,\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/tutorial/TutorialFragment$Companion;", "", "()V", "ARG_COOL_DOWN_SECONDS", "", "ARG_TYPE", "LEFT_POINTER_ORIENTATIONS", "", "Lcom/iqoption/tutorial/utils/PointerRotation;", "TAG", "findShownFragment", "Lcom/iqoption/tutorial/TutorialFragment;", "fragmentManager", "Landroid/support/v4/app/FragmentManager;", "isShowing", "", "show", "container", "", "type", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "coolDownSeconds", "", "listener", "Lcom/iqoption/tutorial/TutorialFragment$TutorialCloseListener;", "step", "Lcom/iqoption/tutorial/dictionary/TutorialStep;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* bridge */ /* synthetic */ boolean a(a aVar, FragmentManager fragmentManager, int i, com.iqoption.tutorial.dictionary.b bVar, b bVar2, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                bVar2 = (b) null;
            }
            return aVar.a(fragmentManager, i, bVar, bVar2);
        }

        public final boolean a(FragmentManager fragmentManager, int i, com.iqoption.tutorial.dictionary.b bVar, b bVar2) {
            h.e(fragmentManager, "fragmentManager");
            h.e(bVar, "step");
            if (bVar.aFI() == TutorialAction.UNKNOWN) {
                return false;
            }
            return a(fragmentManager, i, bVar.aFI(), bVar.aFJ(), bVar2);
        }

        public final boolean a(FragmentManager fragmentManager, int i, TutorialAction tutorialAction, long j, b bVar) {
            h.e(fragmentManager, "fragmentManager");
            h.e(tutorialAction, Param.TYPE);
            c r = r(fragmentManager);
            if (r != null) {
                r.dtW = bVar;
                return false;
            }
            r = new c();
            Bundle bundle = new Bundle();
            bundle.putSerializable("ARG_TYPE", tutorialAction);
            bundle.putLong("ARG_COOL_DOWN_SECONDS", j);
            r.setArguments(bundle);
            r.dtW = bVar;
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.fade_in_short, R.anim.fade_out_short, R.anim.fade_in_short, R.anim.fade_out_short).add(i, r, c.TAG).addToBackStack(c.TAG).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return true;
        }

        public final boolean q(FragmentManager fragmentManager) {
            h.e(fragmentManager, "fragmentManager");
            return ((a) this).r(fragmentManager) != null;
        }

        private final c r(FragmentManager fragmentManager) {
            return (c) fragmentManager.findFragmentByTag(c.TAG);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/tutorial/TutorialFragment$TutorialCloseListener;", "", "onTutorialClose", "", "type", "Lcom/iqoption/tutorial/dictionary/TutorialAction;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TutorialFragment.kt */
    public interface b {
        void a(TutorialAction tutorialAction);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: TutorialFragment.kt */
    static final class c implements Runnable {
        final /* synthetic */ StepDoneType dtZ;
        final /* synthetic */ c this$0;

        c(c cVar, StepDoneType stepDoneType) {
            this.this$0 = cVar;
            this.dtZ = stepDoneType;
        }

        public final void run() {
            c.b(this.this$0).a(this.this$0.aFn(), this.dtZ);
            c.b(this.this$0).E(Long.valueOf(System.currentTimeMillis() + (this.this$0.aFo() * ((long) 1000))));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
    /* compiled from: TutorialFragment.kt */
    static final class d implements OnTouchListener {
        final /* synthetic */ c this$0;

        d(c cVar) {
            this.this$0 = cVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.this$0.a(StepDoneType.TAP_AWAY);
            return false;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: TutorialFragment.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ c this$0;

        e(c cVar) {
            this.this$0 = cVar;
        }

        public final void onClick(View view) {
            this.this$0.a(StepDoneType.TAP_ON_DIALOG);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: TutorialFragment.kt */
    static final class f implements Runnable {
        final /* synthetic */ com.iqoption.tutorial.a.j dua;
        final /* synthetic */ ImageView dub;
        final /* synthetic */ View duc;
        final /* synthetic */ c this$0;

        f(c cVar, com.iqoption.tutorial.a.j jVar, ImageView imageView, View view) {
            this.this$0 = cVar;
            this.dua = jVar;
            this.dub = imageView;
            this.duc = view;
        }

        public final void run() {
            com.iqoption.tutorial.a.j jVar = this.dua;
            Activity n = com.iqoption.core.ext.a.n(this.this$0);
            ImageView imageView = this.dub;
            h.d(imageView, "pointer");
            View view = imageView;
            View view2 = this.duc;
            h.d(view2, "dialog");
            com.iqoption.tutorial.utils.b a = jVar.a(n, view, view2);
            if (a != null) {
                c cVar = this.this$0;
                imageView = this.dub;
                h.d(imageView, "pointer");
                cVar.a((View) imageView, a.aFT());
                cVar = this.this$0;
                view = this.duc;
                h.d(view, "dialog");
                cVar.a(view, a.aFV());
                ImageView imageView2 = this.dub;
                h.d(imageView2, "pointer");
                com.iqoption.tutorial.utils.c.a(imageView2, a.aFT(), a.aFU(), this.dua.aFP());
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to calculate training view position (type=");
            stringBuilder.append(this.this$0.aFn());
            stringBuilder.append(')');
            com.iqoption.core.i.d(stringBuilder.toString());
            this.this$0.a(StepDoneType.ILLEGAL_STATE);
        }
    }

    public static final boolean a(FragmentManager fragmentManager, int i, com.iqoption.tutorial.dictionary.b bVar) {
        return a.a(dtY, fragmentManager, i, bVar, null, 8, null);
    }

    public static final boolean a(FragmentManager fragmentManager, int i, com.iqoption.tutorial.dictionary.b bVar, b bVar2) {
        return dtY.a(fragmentManager, i, bVar, bVar2);
    }

    private final TutorialAction aFn() {
        kotlin.d dVar = this.den;
        j jVar = apP[0];
        return (TutorialAction) dVar.getValue();
    }

    private final long aFo() {
        kotlin.d dVar = this.dtT;
        j jVar = apP[1];
        return ((Number) dVar.getValue()).longValue();
    }

    public static final boolean q(FragmentManager fragmentManager) {
        return dtY.q(fragmentManager);
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

    public static final /* synthetic */ TutorialViewModel b(c cVar) {
        TutorialViewModel tutorialViewModel = cVar.dtV;
        if (tutorialViewModel == null) {
            h.lS("viewModel");
        }
        return tutorialViewModel;
    }

    static {
        if (c.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        td B = td.B(layoutInflater, viewGroup, false);
        h.d(B, "this");
        this.dtU = B;
        h.d(B, "FragmentTutorialBinding.….apply { binding = this }");
        return B.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.dtV = TutorialViewModel.duq.D(com.iqoption.core.ext.a.n(this));
        td tdVar = this.dtU;
        if (tdVar == null) {
            h.lS("binding");
        }
        tdVar.getRoot().setOnTouchListener(new d(this));
        com.iqoption.tutorial.a.j a = new k().a(com.iqoption.core.ext.a.m(this), aFn());
        if (a == null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to prepare strategy (type=");
            stringBuilder.append(aFn());
            stringBuilder.append(')');
            com.iqoption.core.i.d(str, stringBuilder.toString());
            a(StepDoneType.ILLEGAL_STATE);
            return;
        }
        View inflate;
        float f;
        td tdVar2;
        ViewStubProxy viewStubProxy;
        ViewStub viewStub;
        if (a.aFL() == DialogOrientation.CHECK_MARK_RIGHT) {
            tdVar2 = this.dtU;
            if (tdVar2 == null) {
                h.lS("binding");
            }
            viewStubProxy = tdVar2.bEY;
            h.d(viewStubProxy, "binding.tutorialLeftDialogStub");
            viewStub = viewStubProxy.getViewStub();
            if (viewStub == null) {
                h.aXZ();
            }
            inflate = viewStub.inflate();
        } else {
            tdVar2 = this.dtU;
            if (tdVar2 == null) {
                h.lS("binding");
            }
            viewStubProxy = tdVar2.bFa;
            h.d(viewStubProxy, "binding.tutorialRightDialogStub");
            viewStub = viewStubProxy.getViewStub();
            if (viewStub == null) {
                h.aXZ();
            }
            inflate = viewStub.inflate();
        }
        int i = dtX.contains(a.aFM()) ? R.drawable.pointer_left : R.drawable.pointer_right;
        td tdVar3 = this.dtU;
        if (tdVar3 == null) {
            h.lS("binding");
        }
        ImageView imageView = tdVar3.bEZ;
        imageView.setImageDrawable(ContextCompat.getDrawable(com.iqoption.core.ext.a.m(this), i));
        h.d(imageView, "pointer");
        switch (a.aFM()) {
            case TOP_TO_BOTTOM:
                f = 90.0f;
                break;
            case BOTTOM_TO_TOP:
                f = 270.0f;
                break;
            default:
                f = 0.0f;
                break;
        }
        imageView.setRotation(f);
        td tdVar4 = this.dtU;
        if (tdVar4 == null) {
            h.lS("binding");
        }
        View root = tdVar4.getRoot();
        h.d(root, "binding.root");
        TextView textView = (TextView) root.findViewById(com.iqoption.b.a.tutorialMessageText);
        h.d(textView, "binding.root.tutorialMessageText");
        textView.setText(a.message());
        inflate.setOnTouchListener(new com.iqoption.view.d.c());
        inflate.setOnClickListener(new e(this));
        bg.b(imageView, new f(this, a, imageView, inflate));
        Builder Builder = Event.Builder(Event.CATEGORY_POPUP_SERVED, aFp());
        h.d(Builder, "Event.Builder(CATEGORY_P… getAnalyticsEventName())");
        this.aFE = Builder;
    }

    private final void a(StepDoneType stepDoneType) {
        com.iqoption.core.ext.a.p(this).popBackStackImmediate();
        b bVar = this.dtW;
        if (bVar != null) {
            bVar.a(aFn());
        }
        com.iqoption.core.d.a.aSe.postDelayed(new c(this, stepDoneType), 200);
        if (stepDoneType != StepDoneType.ILLEGAL_STATE) {
            double d = stepDoneType == StepDoneType.TAP_ON_DIALOG ? 1.0d : 0.0d;
            Builder builder = this.aFE;
            if (builder == null) {
                h.lS("eventBuilder");
            }
            builder.setValue(Double.valueOf(d));
            builder = this.aFE;
            if (builder == null) {
                h.lS("eventBuilder");
            }
            builder.calcDuration();
            EventManager Bm = EventManager.Bm();
            Builder builder2 = this.aFE;
            if (builder2 == null) {
                h.lS("eventBuilder");
            }
            Bm.a(builder2.build());
        }
    }

    private final void a(View view, Point point) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.AbsoluteLayout.LayoutParams");
        }
        AbsoluteLayout.LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) layoutParams;
        layoutParams2.x = point.x;
        layoutParams2.y = point.y;
        view.setLayoutParams(layoutParams2);
    }

    private final String aFp() {
        switch (aFn()) {
            case PRACTICE_BALANCE:
                return "tutorial_try-practice-balance";
            case TIME_SCALE:
                return "tutorial_historical-price";
            case ADD_TAB:
                return "tutorial_add-tab";
            case CHOOSE_INSTRUMENT:
                return "tutorial_choose-instrument";
            case CHOOSE_ASSET:
                return "tutorial_choose-asset";
            case CALL_PUT:
            case CALL_PUT_ANOTHER_INSTRUMENT:
                return "tutorial_make-trade";
            case CHART_TYPE:
                return "tutorial_choose-chart-type";
            case EDUCATIONAL_VIDEOS:
                return "tutorial_try-video";
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to get analytic event name for type: ");
                stringBuilder.append(aFn());
                throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
