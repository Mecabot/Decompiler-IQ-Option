package com.iqoption.bottomsheet;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.BottomSheetCallback;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.iqoption.core.ui.b.b.d;
import com.iqoption.core.util.j;
import com.iqoption.dialogs.a.e;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0014J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H&J\b\u0010-\u001a\u00020\u001dH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8DX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8TX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8TX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, aXE = {"Lcom/iqoption/bottomsheet/BottomSheetFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "Lcom/iqoption/bottomsheet/BottomSheetCloseListener;", "()V", "behavior", "Landroid/support/design/widget/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "binding", "Lcom/iqoption/dialogs/databinding/FragmentBottomSheetBinding;", "bottomSheetBinding", "getBottomSheetBinding", "()Lcom/iqoption/dialogs/databinding/FragmentBottomSheetBinding;", "bottomSheetInitialState", "", "getBottomSheetInitialState", "()I", "bottomSheetPeekHeight", "getBottomSheetPeekHeight", "bottomSheetTopMargin", "getBottomSheetTopMargin", "bottomsSheetCallback", "Landroid/support/design/widget/BottomSheetBehavior$BottomSheetCallback;", "lifecycleBackListener", "Lcom/iqoption/core/ui/navigation/LifecycleBackListener;", "time", "", "closeBottomSheet", "", "closeIfPresent", "", "onBottomSheetClosed", "onCreateTransitionProvider", "Lcom/iqoption/core/ui/animation/transitions/TransitionProvider;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOffsetChanged", "slideOffset", "", "provideView", "shouldHideKeyboard", "dialogs_release"})
/* compiled from: BottomSheetFragment.kt */
public abstract class c extends com.iqoption.core.ui.fragment.b implements b {
    private BottomSheetBehavior<FrameLayout> arB;
    private e arC;
    private final BottomSheetCallback arD = new a(this);
    private long time;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BottomSheetFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ c this$0;

        b(c cVar) {
            this.this$0 = cVar;
        }

        public final void onClick(View view) {
            this.this$0.JQ();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, aXE = {"com/iqoption/bottomsheet/BottomSheetFragment$bottomsSheetCallback$1", "Landroid/support/design/widget/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "dialogs_release"})
    /* compiled from: BottomSheetFragment.kt */
    public static final class a extends BottomSheetCallback {
        final /* synthetic */ c this$0;

        a(c cVar) {
            this.this$0 = cVar;
        }

        public void onSlide(View view, float f) {
            h.e(view, "bottomSheet");
            float f2 = (float) 1;
            f = Math.min(f + f2, 1.0f);
            if (f > ((float) null) && f < f2) {
                view = c.a(this.this$0).bqo;
                h.d(view, "binding.veil");
                view.setAlpha(f);
                this.this$0.m(f);
            }
            view = c.a(this.this$0).bqo;
            h.d(view, "binding.veil");
            view.setVisibility(0);
        }

        public void onStateChanged(View view, int i) {
            h.e(view, "bottomSheet");
            if (i == 3) {
                com.iqoption.core.i.d("BottomSheetAnimEnter", String.valueOf(System.currentTimeMillis() - this.this$0.time));
                view = c.a(this.this$0).bqo;
                h.d(view, "binding.veil");
                view.setVisibility(0);
                view = c.a(this.this$0).bqo;
                h.d(view, "binding.veil");
                view.setAlpha(1.0f);
                this.this$0.m(1.0f);
            } else if (i == 5) {
                view = c.a(this.this$0).bqo;
                h.d(view, "binding.veil");
                view.setVisibility(8);
                view = c.a(this.this$0).bqo;
                h.d(view, "binding.veil");
                view.setAlpha(0.0f);
                this.this$0.m(0.0f);
                if (this.this$0.isAdded()) {
                    com.iqoption.core.i.d("BottomSheetAnimExit", String.valueOf(System.currentTimeMillis() - this.this$0.time));
                    this.this$0.JP();
                }
            }
            if (this.this$0.JR()) {
                j.n(this.this$0.zzakw());
            }
        }
    }

    protected int JN() {
        return 4;
    }

    public void JP() {
    }

    public boolean JR() {
        return true;
    }

    public abstract View d(ViewGroup viewGroup);

    public void m(float f) {
    }

    public static final /* synthetic */ e a(c cVar) {
        e eVar = cVar.arC;
        if (eVar == null) {
            h.lS("binding");
        }
        return eVar;
    }

    public static final /* synthetic */ BottomSheetBehavior b(c cVar) {
        BottomSheetBehavior bottomSheetBehavior = cVar.arB;
        if (bottomSheetBehavior == null) {
            h.lS("behavior");
        }
        return bottomSheetBehavior;
    }

    protected int JL() {
        return com.iqoption.core.ext.a.c((Fragment) this, com.iqoption.dialogs.c.b.dp64);
    }

    protected int JM() {
        return com.iqoption.core.ext.a.c((Fragment) this, com.iqoption.dialogs.c.b.dp420);
    }

    protected com.iqoption.core.ui.b.b.e JO() {
        return new d(this, new BottomSheetFragment$onCreateTransitionProvider$1(this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.arC = (e) com.iqoption.core.ext.a.a((Fragment) this, com.iqoption.dialogs.c.d.fragment_bottom_sheet, viewGroup, false, 4, null);
        e eVar = this.arC;
        if (eVar == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout = eVar.ckT;
        h.d(frameLayout, "binding.contentViewContainer");
        View d = d((ViewGroup) frameLayout);
        e eVar2 = this.arC;
        if (eVar2 == null) {
            h.lS("binding");
        }
        BottomSheetBehavior from = BottomSheetBehavior.from(eVar2.ckT);
        from.setHideable(true);
        from.setSkipCollapsed(true);
        from.setPeekHeight(JM());
        from.setState(JN());
        from.setBottomSheetCallback(this.arD);
        h.d(from, "BottomSheetBehavior.from…sSheetCallback)\n        }");
        this.arB = from;
        eVar2 = this.arC;
        if (eVar2 == null) {
            h.lS("binding");
        }
        CoordinatorLayout coordinatorLayout = eVar2.bHC;
        h.d(coordinatorLayout, "binding.coordinatorLayout");
        LayoutParams layoutParams = coordinatorLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(layoutParams2.leftMargin, JL(), layoutParams2.rightMargin, layoutParams2.bottomMargin);
        eVar2 = this.arC;
        if (eVar2 == null) {
            h.lS("binding");
        }
        eVar2.ckT.addView(d);
        eVar = this.arC;
        if (eVar == null) {
            h.lS("binding");
        }
        eVar.bqo.setOnClickListener(new b(this));
        Lifecycle lifecycle = getLifecycle();
        FragmentActivity n = com.iqoption.core.ext.a.n(this);
        if (n == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.ui.navigation.BackController");
        }
        lifecycle.a(new BottomSheetFragment$onCreateView$4(this, (com.iqoption.core.ui.navigation.a) n));
        if (JR()) {
            j.n(zzakw());
        }
        eVar = this.arC;
        if (eVar == null) {
            h.lS("binding");
        }
        return eVar.getRoot();
    }

    public void JK() {
        JQ();
    }

    private final boolean JQ() {
        this.time = System.currentTimeMillis();
        BottomSheetBehavior bottomSheetBehavior = this.arB;
        if (bottomSheetBehavior == null) {
            h.lS("behavior");
        }
        switch (bottomSheetBehavior.getState()) {
            case 3:
            case 4:
                bottomSheetBehavior = this.arB;
                if (bottomSheetBehavior == null) {
                    h.lS("behavior");
                }
                bottomSheetBehavior.setState(5);
                Fragment parentFragment = getParentFragment();
                if (!(parentFragment instanceof b)) {
                    parentFragment = null;
                }
                b bVar = (b) parentFragment;
                if (bVar != null) {
                    bVar.JK();
                }
                return true;
            default:
                return false;
        }
    }
}
