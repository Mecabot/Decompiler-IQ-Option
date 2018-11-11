package com.iqoption.core.ui.b.b;

import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, aXE = {"Lcom/iqoption/core/ui/animation/transitions/AnimatorTransition;", "Landroid/support/transition/Transition;", "targetName", "", "(Ljava/lang/String;)V", "captureEndValues", "", "transitionValues", "Landroid/support/transition/TransitionValues;", "captureStartValues", "core_release"})
/* compiled from: AnimatorTransition.kt */
public class b extends Transition {
    public void captureEndValues(TransitionValues transitionValues) {
        h.e(transitionValues, "transitionValues");
    }

    public void captureStartValues(TransitionValues transitionValues) {
        h.e(transitionValues, "transitionValues");
    }

    public b(String str) {
        if (str != null) {
            addTarget(str);
        }
    }
}
