package com.rd.animation.type;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: BaseAnimation */
public abstract class a<T extends Animator> {
    protected T animator;
    protected long ehL = 350;
    protected com.rd.animation.a.b.a eho;

    public abstract a W(float f);

    @NonNull
    public abstract T aIz();

    public a(@Nullable com.rd.animation.a.b.a aVar) {
        this.eho = aVar;
        this.animator = aIz();
    }

    public a cI(long j) {
        this.ehL = j;
        if (this.animator instanceof ValueAnimator) {
            this.animator.setDuration(this.ehL);
        }
        return this;
    }

    public void start() {
        if (this.animator != null && !this.animator.isRunning()) {
            this.animator.start();
        }
    }

    public void end() {
        if (this.animator != null && this.animator.isStarted()) {
            this.animator.end();
        }
    }
}
