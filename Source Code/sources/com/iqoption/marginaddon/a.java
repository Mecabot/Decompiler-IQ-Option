package com.iqoption.marginaddon;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.ip;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.popup.PopupPriority;
import com.iqoption.util.ax;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\u001a\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J)\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0006\u0010\b\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\tR\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000¨\u00062"}, aXE = {"Lcom/iqoption/marginaddon/MarginAddOnInfoDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "binding", "Lcom/iqoption/databinding/DialogMarginAddOnInfoBinding;", "closeRunnable", "Ljava/lang/Runnable;", "event", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "handler", "Landroid/os/Handler;", "isEnabled", "", "rightOffset", "", "getRightOffset", "()I", "rightOffset$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/iqoption/marginaddon/MarginAddOnViewModel;", "enableMarginAddOn", "", "onClose", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "reportEvent", "category", "", "value", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "setUiStateEnabled", "enabled", "animate", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MarginAddOnInfoDialog.kt */
public final class a extends com.iqoption.fragment.base.b implements com.iqoption.view.e.a {
    private static final String TAG = "com.iqoption.marginaddon.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "rightOffset", "getRightOffset()I"))};
    public static final a cOb = new a();
    private Builder ajG;
    private HashMap atz;
    private ip cNY;
    private MarginAddOnViewModel cNZ;
    private final kotlin.d cOa = g.f(new MarginAddOnInfoDialog$rightOffset$2(this));
    private final Runnable cpw = new b(this);
    private final Handler handler = new Handler();
    private boolean isEnabled;

    @i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\"\u0010\b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/marginaddon/MarginAddOnInfoDialog$Companion;", "", "()V", "ARG_RIGHT_OFFSET", "", "CLOSE_DELAY_MILLIS", "", "TAG", "show", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "containerViewId", "", "rightOffset", "", "fm", "Landroid/support/v4/app/FragmentManager;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MarginAddOnInfoDialog.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: MarginAddOnInfoDialog.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;
            final /* synthetic */ int cOc;
            final /* synthetic */ int cOd;

            a(FragmentManager fragmentManager, int i, int i2) {
                this.cBh = fragmentManager;
                this.cOc = i;
                this.cOd = i2;
            }

            public final void run() {
                a aVar = a.cOb;
                FragmentManager fragmentManager = this.cBh;
                h.d(fragmentManager, "fm");
                aVar.a(fragmentManager, this.cOc, this.cOd);
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(FragmentActivity fragmentActivity, @IdRes int i, int i2) {
            h.e(fragmentActivity, "activity");
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            PopupViewModel j = PopupViewModel.cBp.j(fragmentActivity);
            if (!j.hP(a.TAG)) {
                j.a((Runnable) new a(supportFragmentManager, i, i2), a.TAG, PopupPriority.HIGH);
            }
        }

        private final boolean a(FragmentManager fragmentManager, @IdRes int i, int i2) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_RIGHT_OFFSET", i2);
            aVar.setArguments(bundle);
            fragmentManager.beginTransaction().replace(i, aVar, a.TAG).addToBackStack(a.TAG).commitAllowingStateLoss();
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: MarginAddOnInfoDialog.kt */
    static final class b implements Runnable {
        final /* synthetic */ a this$0;

        b(a aVar) {
            this.this$0 = aVar;
        }

        public final void run() {
            this.this$0.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class c implements OnPreDrawListener {
        final /* synthetic */ View aGz;
        final /* synthetic */ a this$0;

        public c(View view, a aVar) {
            this.aGz = view;
            this.this$0 = aVar;
        }

        public boolean onPreDraw() {
            this.aGz.getViewTreeObserver().removeOnPreDrawListener(this);
            View view = a.b(this.this$0).bsy;
            h.d(view, "binding.dialogMarginTouchablePart");
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ((MarginLayoutParams) layoutParams).width = this.this$0.aqG();
            a.b(this.this$0).bsy.requestLayout();
            return false;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: MarginAddOnInfoDialog.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ a this$0;

        d(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            a.a(this.this$0, Event.CATEGORY_BUTTON_PRESSED, "trading-tip_close", null, 4, null);
            this.this$0.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: MarginAddOnInfoDialog.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ a this$0;

        e(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.onClose();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
    /* compiled from: MarginAddOnInfoDialog.kt */
    static final class f implements OnTouchListener {
        final /* synthetic */ a this$0;

        f(a aVar) {
            this.this$0 = aVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.this$0.onClose();
            return false;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: MarginAddOnInfoDialog.kt */
    static final class g implements OnClickListener {
        final /* synthetic */ a this$0;

        g(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.a(Event.CATEGORY_BUTTON_PRESSED, "trading-tip_enable", Double.valueOf(1.0d));
            this.this$0.aqH();
        }
    }

    public static final void a(FragmentActivity fragmentActivity, @IdRes int i, int i2) {
        cOb.a(fragmentActivity, i, i2);
    }

    private final int aqG() {
        kotlin.d dVar = this.cOa;
        j jVar = apP[0];
        return ((Number) dVar.getValue()).intValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public static final /* synthetic */ ip b(a aVar) {
        ip ipVar = aVar.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        return ipVar;
    }

    static {
        if (a.class.getName() == null) {
            h.aXZ();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cNZ = MarginAddOnViewModel.cOi.U(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.cNY = (ip) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.dialog_margin_add_on_info, viewGroup, false, 4, null);
        ip ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        return ipVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        MarginAddOnViewModel marginAddOnViewModel = this.cNZ;
        if (marginAddOnViewModel == null) {
            h.lS("viewModel");
        }
        h(marginAddOnViewModel.aqQ(), false);
        ip ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        ipVar.bsr.setOnClickListener(new d(this));
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        ipVar.bsq.setOnClickListener(new e(this));
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        ipVar.bsy.setOnTouchListener(new f(this));
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        ipVar.bsn.setOnClickListener(new g(this));
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        view = ipVar.getRoot();
        h.d(view, "binding.root");
        view.getViewTreeObserver().addOnPreDrawListener(new c(view, this));
        if (bundle == null) {
            String str = Event.CATEGORY_POPUP_SERVED;
            String str2 = "trading-tip_show";
            MarginAddOnViewModel marginAddOnViewModel2 = this.cNZ;
            if (marginAddOnViewModel2 == null) {
                h.lS("viewModel");
            }
            a(str, str2, Double.valueOf((double) marginAddOnViewModel2.aqS()));
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.handler.removeCallbacks(this.cpw);
        Builder builder = this.ajG;
        if (builder != null) {
            EventManager.Bm().a(builder.calcDuration().build());
        }
        KH();
    }

    private final void h(boolean z, boolean z2) {
        this.isEnabled = z;
        if (z2) {
            ip ipVar = this.cNY;
            if (ipVar == null) {
                h.lS("binding");
            }
            TransitionManager.beginDelayedTransition(ipVar.bso);
        }
        ip ipVar2;
        TextView textView;
        ImageView imageView;
        if (z) {
            ipVar2 = this.cNY;
            if (ipVar2 == null) {
                h.lS("binding");
            }
            textView = ipVar2.bsn;
            h.d(textView, "binding.dialogMarginButton");
            com.iqoption.core.ext.a.M(textView);
            ipVar2 = this.cNY;
            if (ipVar2 == null) {
                h.lS("binding");
            }
            imageView = ipVar2.bst;
            h.d(imageView, "binding.dialogMarginEnabledIcon");
            com.iqoption.core.ext.a.L(imageView);
            ipVar2 = this.cNY;
            if (ipVar2 == null) {
                h.lS("binding");
            }
            textView = ipVar2.bsu;
            h.d(textView, "binding.dialogMarginEnabledText");
            com.iqoption.core.ext.a.L(textView);
            return;
        }
        ipVar2 = this.cNY;
        if (ipVar2 == null) {
            h.lS("binding");
        }
        textView = ipVar2.bsn;
        h.d(textView, "binding.dialogMarginButton");
        com.iqoption.core.ext.a.L(textView);
        ipVar2 = this.cNY;
        if (ipVar2 == null) {
            h.lS("binding");
        }
        imageView = ipVar2.bst;
        h.d(imageView, "binding.dialogMarginEnabledIcon");
        com.iqoption.core.ext.a.M(imageView);
        ipVar2 = this.cNY;
        if (ipVar2 == null) {
            h.lS("binding");
        }
        textView = ipVar2.bsu;
        h.d(textView, "binding.dialogMarginEnabledText");
        com.iqoption.core.ext.a.M(textView);
    }

    private final void aqH() {
        MarginAddOnViewModel marginAddOnViewModel = this.cNZ;
        if (marginAddOnViewModel == null) {
            h.lS("viewModel");
        }
        marginAddOnViewModel.aqR();
        h(true, true);
        this.handler.postDelayed(this.cpw, 2000);
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        com.iqoption.core.ext.a.p(this).executePendingTransactions();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
        return true;
    }

    public void ND() {
        ip ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = ipVar.bss;
        h.d(linearLayout, "binding.dialogMarginContainer");
        linearLayout.setAlpha(0.0f);
        float dimension;
        ip ipVar2;
        LinearLayout linearLayout2;
        ip ipVar3;
        LinearLayout linearLayout3;
        float height;
        if (ax.dws) {
            dimension = getResources().getDimension(R.dimen.dp12);
            float dimension2 = getResources().getDimension(R.dimen.dp6);
            ipVar2 = this.cNY;
            if (ipVar2 == null) {
                h.lS("binding");
            }
            linearLayout2 = ipVar2.bss;
            h.d(linearLayout2, "binding.dialogMarginContainer");
            linearLayout2.setTranslationX(dimension2);
            ipVar2 = this.cNY;
            if (ipVar2 == null) {
                h.lS("binding");
            }
            linearLayout2 = ipVar2.bss;
            h.d(linearLayout2, "binding.dialogMarginContainer");
            linearLayout2.setTranslationY(-dimension2);
            ipVar3 = this.cNY;
            if (ipVar3 == null) {
                h.lS("binding");
            }
            linearLayout3 = ipVar3.bss;
            h.d(linearLayout3, "binding.dialogMarginContainer");
            dimension2 = ((float) linearLayout3.getWidth()) - dimension;
            ipVar2 = this.cNY;
            if (ipVar2 == null) {
                h.lS("binding");
            }
            linearLayout2 = ipVar2.bss;
            h.d(linearLayout2, "binding.dialogMarginContainer");
            height = ((float) linearLayout2.getHeight()) - dimension;
            ip ipVar4 = this.cNY;
            if (ipVar4 == null) {
                h.lS("binding");
            }
            LinearLayout linearLayout4 = ipVar4.bss;
            h.d(linearLayout4, "binding.dialogMarginContainer");
            double width = (double) linearLayout4.getWidth();
            ip ipVar5 = this.cNY;
            if (ipVar5 == null) {
                h.lS("binding");
            }
            LinearLayout linearLayout5 = ipVar5.bss;
            h.d(linearLayout5, "binding.dialogMarginContainer");
            float hypot = (float) Math.hypot(width, (double) linearLayout5.getHeight());
            ip ipVar6 = this.cNY;
            if (ipVar6 == null) {
                h.lS("binding");
            }
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(ipVar6.bss, (int) dimension2, (int) height, dimension, hypot);
            Animator duration = createCircularReveal.setDuration(400);
            h.d(duration, "animator.setDuration(400)");
            duration.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
            ip ipVar7 = this.cNY;
            if (ipVar7 == null) {
                h.lS("binding");
            }
            LinearLayout linearLayout6 = ipVar7.bss;
            r3 = new PropertyValuesHolder[2];
            r3[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(linearLayout6, r3);
            ObjectAnimator duration2 = ofPropertyValuesHolder.setDuration(200);
            h.d(duration2, "shift.setDuration(200)");
            duration2.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.start();
            ipVar = this.cNY;
            if (ipVar == null) {
                h.lS("binding");
            }
            linearLayout = ipVar.bss;
            h.d(linearLayout, "binding.dialogMarginContainer");
            linearLayout.setAlpha(1.0f);
            return;
        }
        dimension = getResources().getDimension(R.dimen.dp12);
        ipVar3 = this.cNY;
        if (ipVar3 == null) {
            h.lS("binding");
        }
        linearLayout3 = ipVar3.bss;
        h.d(linearLayout3, "binding.dialogMarginContainer");
        height = -dimension;
        linearLayout3.setTranslationX(height);
        ipVar3 = this.cNY;
        if (ipVar3 == null) {
            h.lS("binding");
        }
        linearLayout3 = ipVar3.bss;
        h.d(linearLayout3, "binding.dialogMarginContainer");
        linearLayout3.setTranslationY(height);
        ipVar3 = this.cNY;
        if (ipVar3 == null) {
            h.lS("binding");
        }
        linearLayout3 = ipVar3.bss;
        h.d(linearLayout3, "binding.dialogMarginContainer");
        ipVar2 = this.cNY;
        if (ipVar2 == null) {
            h.lS("binding");
        }
        linearLayout2 = ipVar2.bss;
        h.d(linearLayout2, "binding.dialogMarginContainer");
        linearLayout3.setPivotX(((float) linearLayout2.getWidth()) - dimension);
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        linearLayout = ipVar.bss;
        h.d(linearLayout, "binding.dialogMarginContainer");
        linearLayout.setPivotY(1.0f);
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        linearLayout = ipVar.bss;
        h.d(linearLayout, "binding.dialogMarginContainer");
        linearLayout.setScaleX(0.3f);
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        linearLayout = ipVar.bss;
        h.d(linearLayout, "binding.dialogMarginContainer");
        linearLayout.setScaleY(0.3f);
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        ipVar.bss.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void NE() {
        ip ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = ipVar.bss;
        h.d(linearLayout, "binding.dialogMarginContainer");
        ip ipVar2 = this.cNY;
        if (ipVar2 == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout2 = ipVar2.bss;
        h.d(linearLayout2, "binding.dialogMarginContainer");
        linearLayout.setPivotX((float) linearLayout2.getWidth());
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        linearLayout = ipVar.bss;
        h.d(linearLayout, "binding.dialogMarginContainer");
        linearLayout.setPivotY(1.0f);
        ipVar = this.cNY;
        if (ipVar == null) {
            h.lS("binding");
        }
        ipVar.bss.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    static /* bridge */ /* synthetic */ void a(a aVar, String str, String str2, Double d, int i, Object obj) {
        if ((i & 4) != 0) {
            d = (Double) null;
        }
        aVar.a(str, str2, d);
    }

    private final void a(String str, String str2, Double d) {
        Builder parameters = Event.Builder(str, str2).setParameters(com.iqoption.core.util.i.ZZ().l(Param.TYPE, "margin_add_on").aab());
        if (d != null) {
            parameters.setValue(Double.valueOf(d.doubleValue()));
        }
        EventManager.Bm().a(parameters.build());
    }
}
