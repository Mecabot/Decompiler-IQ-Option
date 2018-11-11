package com.iqoption.core.ui.b.b;

import android.support.transition.Transition;
import com.iqoption.core.ui.b.b.e.a;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, aXE = {"Lcom/iqoption/core/ui/animation/transitions/EnterReturnTransitionProvider;", "Lcom/iqoption/core/ui/animation/transitions/TransitionProvider;", "()V", "getEnterTransition", "Landroid/support/transition/Transition;", "getExitTransition", "getReenterTransition", "getReturnTransition", "core_release"})
/* compiled from: EnterReturnTransitionProvider.kt */
public abstract class c implements e {
    public final Transition YA() {
        return a.b(this);
    }

    public final Transition YB() {
        return a.c(this);
    }
}
