package com.iqoption.charttools.tools;

import android.animation.TimeInterpolator;
import android.support.transition.ChangeBounds;
import android.support.transition.Fade;
import android.support.transition.TransitionSet;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Landroid/support/transition/TransitionSet;", "invoke"})
/* compiled from: ToolsFragment.kt */
final class ToolsFragment$changeTransition$2 extends Lambda implements a<TransitionSet> {
    public static final ToolsFragment$changeTransition$2 aAL = new ToolsFragment$changeTransition$2();

    ToolsFragment$changeTransition$2() {
        super(0);
    }

    /* renamed from: NH */
    public final TransitionSet invoke() {
        TransitionSet transitionSet = new TransitionSet();
        Fade fade = new Fade(2);
        fade.addTarget((int) R.id.tools_content);
        transitionSet.addTransition(fade);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.addTarget((int) R.id.card);
        changeBounds.addTarget((int) R.id.tools_content);
        transitionSet.addTransition(changeBounds);
        fade = new Fade(1);
        fade.addTarget((int) R.id.tools_content);
        transitionSet.addTransition(fade);
        transitionSet.setDuration(250);
        transitionSet.setInterpolator((TimeInterpolator) com.iqoption.core.graphics.animation.i.TI());
        return transitionSet;
    }
}
