package com.iqoption.core.ui.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.MainThread;
import android.support.v4.app.Fragment;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/AnimViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isEntering", "Landroid/arch/lifecycle/LiveData;", "", "()Landroid/arch/lifecycle/LiveData;", "isEnteringData", "Landroid/arch/lifecycle/MutableLiveData;", "isExiting", "isExitingData", "enter", "", "animation", "Landroid/view/animation/Animation;", "exit", "Companion", "core_release"})
/* compiled from: AnimViewModel.kt */
public final class AnimViewModel extends ViewModel {
    public static final a bcm = new a();
    private final MutableLiveData<Boolean> bck = new MutableLiveData();
    private final MutableLiveData<Boolean> bcl = new MutableLiveData();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/ui/viewmodel/AnimViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/core/ui/viewmodel/AnimViewModel;", "f", "Landroid/support/v4/app/Fragment;", "core_release"})
    /* compiled from: AnimViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final AnimViewModel s(Fragment fragment) {
            h.e(fragment, "f");
            return (AnimViewModel) ViewModelProviders.d(fragment).h(AnimViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, aXE = {"com/iqoption/core/ui/viewmodel/AnimViewModel$enter$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "core_release"})
    /* compiled from: AnimViewModel.kt */
    public static final class b implements AnimationListener {
        final /* synthetic */ AnimViewModel bcn;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        b(AnimViewModel animViewModel) {
            this.bcn = animViewModel;
        }

        public void onAnimationEnd(Animation animation) {
            this.bcn.bck.setValue(Boolean.valueOf(false));
        }
    }

    public static final AnimViewModel s(Fragment fragment) {
        return bcm.s(fragment);
    }

    public final LiveData<Boolean> YZ() {
        return this.bck;
    }

    @MainThread
    public final void a(Animation animation) {
        h.e(animation, "animation");
        this.bck.setValue(Boolean.valueOf(true));
        animation.setAnimationListener(new b(this));
    }
}
