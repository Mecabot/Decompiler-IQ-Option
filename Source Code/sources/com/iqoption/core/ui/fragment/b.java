package com.iqoption.core.ui.fragment;

import android.os.Bundle;
import android.support.transition.Transition;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.ui.b.b.e;
import java.util.HashMap;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u0004\u0018\u00010 J\b\u0010!\u001a\u00020\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\n\u0010&\u001a\u0004\u0018\u00010$H\u0016J\n\u0010'\u001a\u0004\u0018\u00010$H\u0016J\u0006\u0010(\u001a\u00020\u0013J\"\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\u0005H\u0014J\b\u00100\u001a\u00020\u0016H\u0014J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u001bH\u0016J\u001a\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u0004\u0018\u00010*2\u0006\u0010.\u001a\u00020,R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018¨\u0006;"}, aXE = {"Lcom/iqoption/core/ui/fragment/IQFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/iqoption/core/ui/animation/EnterExitAnimatable;", "()V", "animationProvider", "Lcom/iqoption/core/ui/animation/AnimationProvider;", "getAnimationProvider", "()Lcom/iqoption/core/ui/animation/AnimationProvider;", "animationProvider$delegate", "Lkotlin/Lazy;", "disposablesOnDestroy", "Lio/reactivex/disposables/CompositeDisposable;", "enterAnimationDuration", "", "getEnterAnimationDuration", "()J", "exitAnimationDuration", "getExitAnimationDuration", "isCustomAnimationsEnabled", "", "()Z", "transitionProvider", "Lcom/iqoption/core/ui/animation/transitions/TransitionProvider;", "getTransitionProvider", "()Lcom/iqoption/core/ui/animation/transitions/TransitionProvider;", "transitionProvider$delegate", "back", "", "disposeOnDestroy", "disposable", "Lio/reactivex/disposables/Disposable;", "getBackController", "Lcom/iqoption/core/ui/navigation/BackController;", "getContentTransitionName", "", "getEnterTransition", "", "getExitTransition", "getReenterTransition", "getReturnTransition", "isKeyboardVisible", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "nextAnim", "onCreateAnimationProvider", "onCreateTransitionProvider", "onDestroy", "onEnterAnimation", "onExitAnimation", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "tryLoadAnimation", "Companion", "core_release"})
/* compiled from: IQFragment.kt */
public class b extends Fragment {
    private static final String LOG_TAG = "b";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "animationProvider", "getAnimationProvider()Lcom/iqoption/core/ui/animation/AnimationProvider;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "transitionProvider", "getTransitionProvider()Lcom/iqoption/core/ui/animation/transitions/TransitionProvider;"))};
    private static final c bbA = new c();
    public static final a bbB = new a();
    private static final b bbz = new b();
    private HashMap atz;
    private final io.reactivex.disposables.a bbt = new io.reactivex.disposables.a();
    private final d bbu = g.f(new IQFragment$animationProvider$2(this));
    private final d bbv = g.f(new IQFragment$transitionProvider$2(this));
    private final boolean bbw;
    private final long bbx = 250;
    private final long bby = 250;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003*\u0002\u0007\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\f"}, aXE = {"Lcom/iqoption/core/ui/fragment/IQFragment$Companion;", "", "()V", "LOG_TAG", "", "kotlin.jvm.PlatformType", "NO_ANIMATION_PROVIDER", "com/iqoption/core/ui/fragment/IQFragment$Companion$NO_ANIMATION_PROVIDER$1", "Lcom/iqoption/core/ui/fragment/IQFragment$Companion$NO_ANIMATION_PROVIDER$1;", "NO_TRANSITION_PROVIDER", "com/iqoption/core/ui/fragment/IQFragment$Companion$NO_TRANSITION_PROVIDER$1", "Lcom/iqoption/core/ui/fragment/IQFragment$Companion$NO_TRANSITION_PROVIDER$1;", "core_release"})
    /* compiled from: IQFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, aXE = {"com/iqoption/core/ui/fragment/IQFragment$Companion$NO_ANIMATION_PROVIDER$1", "Lcom/iqoption/core/ui/animation/AnimationProvider;", "core_release"})
    /* compiled from: IQFragment.kt */
    public static final class b implements com.iqoption.core.ui.b.a {
        b() {
        }

        public Animation a(int i, boolean z, int i2) {
            return com.iqoption.core.ui.b.a.a.a(this, i, z, i2);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, aXE = {"com/iqoption/core/ui/fragment/IQFragment$Companion$NO_TRANSITION_PROVIDER$1", "Lcom/iqoption/core/ui/animation/transitions/TransitionProvider;", "core_release"})
    /* compiled from: IQFragment.kt */
    public static final class c implements e {
        c() {
        }

        public Transition YA() {
            return com.iqoption.core.ui.b.b.e.a.b(this);
        }

        public Transition YB() {
            return com.iqoption.core.ui.b.b.e.a.c(this);
        }

        public Transition Yy() {
            return com.iqoption.core.ui.b.b.e.a.a(this);
        }

        public Transition Yz() {
            return com.iqoption.core.ui.b.b.e.a.d(this);
        }
    }

    private final com.iqoption.core.ui.b.a YD() {
        d dVar = this.bbu;
        j jVar = apP[0];
        return (com.iqoption.core.ui.b.a) dVar.getValue();
    }

    private final e YF() {
        d dVar = this.bbv;
        j jVar = apP[1];
        return (e) dVar.getValue();
    }

    public void KF() {
    }

    public void KG() {
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    protected com.iqoption.core.ui.b.a YE() {
        if (KE()) {
            return new com.iqoption.core.ui.b.b(this);
        }
        return bbz;
    }

    protected e JO() {
        return bbA;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return YD().a(i, z, i2);
    }

    public Object getEnterTransition() {
        Object enterTransition = super.getEnterTransition();
        return enterTransition != null ? enterTransition : YF().Yy();
    }

    public Object getExitTransition() {
        Object exitTransition = super.getExitTransition();
        return exitTransition != null ? exitTransition : YF().YA();
    }

    public Object getReenterTransition() {
        Object reenterTransition = super.getReenterTransition();
        return reenterTransition != null ? reenterTransition : YF().YB();
    }

    public Object getReturnTransition() {
        Object returnTransition = super.getReturnTransition();
        return returnTransition != null ? returnTransition : YF().Yz();
    }

    public String YG() {
        String name = getClass().getName();
        h.d(name, "javaClass.name");
        return name;
    }

    public final Animation dS(int i) {
        if (!h.E("anim", getResources().getResourceTypeName(i))) {
            return null;
        }
        try {
            return AnimationUtils.loadAnimation(getContext(), i);
        } catch (Throwable th) {
            com.iqoption.core.i.w(LOG_TAG, "Could not load animation", th);
            return null;
        }
    }

    public boolean KE() {
        return this.bbw;
    }

    public long Yw() {
        return this.bbx;
    }

    public long Yx() {
        return this.bby;
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ViewCompat.setTransitionName(view, YG());
    }

    public void onDestroy() {
        super.onDestroy();
        if (getRetainInstance()) {
            getViewModelStore().clear();
        }
        this.bbt.clear();
    }

    public final void a(io.reactivex.disposables.b bVar) {
        h.e(bVar, "disposable");
        this.bbt.e(bVar);
    }

    public final boolean Yu() {
        FragmentActivity activity = zzakw();
        if (!(activity instanceof com.iqoption.core.ui.a.a)) {
            activity = null;
        }
        com.iqoption.core.ui.a.a aVar = (com.iqoption.core.ui.a.a) activity;
        return aVar != null && aVar.Yu();
    }

    public final com.iqoption.core.ui.navigation.a YH() {
        FragmentActivity activity = zzakw();
        if (!(activity instanceof com.iqoption.core.ui.navigation.a)) {
            activity = null;
        }
        com.iqoption.core.ui.navigation.a aVar = (com.iqoption.core.ui.navigation.a) activity;
        if (aVar != null) {
            return aVar;
        }
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof com.iqoption.core.ui.navigation.a)) {
            parentFragment = null;
        }
        return (com.iqoption.core.ui.navigation.a) parentFragment;
    }

    public final void back() {
        FragmentActivity activity = zzakw();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
