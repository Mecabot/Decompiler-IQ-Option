package com.iqoption.core.graphics.animation.a;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/graphics/animation/transition/TransitionInfo;", "", "durations", "Lcom/iqoption/core/graphics/animation/transition/Durations;", "(Lcom/iqoption/core/graphics/animation/transition/Durations;)V", "getDurations", "()Lcom/iqoption/core/graphics/animation/transition/Durations;", "core_release"})
/* compiled from: TransitionInfo.kt */
public abstract class d {
    private final b aRE;

    public d(b bVar) {
        h.e(bVar, "durations");
        this.aRE = bVar;
    }

    public final b TX() {
        return this.aRE;
    }
}
