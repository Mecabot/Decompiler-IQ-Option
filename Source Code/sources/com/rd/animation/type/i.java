package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.b.a.h;
import java.util.Iterator;

/* compiled from: WormAnimation */
public class i extends a<AnimatorSet> {
    int eie;
    int eif;
    boolean eil;
    int eim;
    int ein;
    private h eio = new h();
    int radius;

    /* compiled from: WormAnimation */
    class a {
        final int eis;
        final int eit;
        final int fromX;
        final int toX;

        a(int i, int i2, int i3, int i4) {
            this.fromX = i;
            this.toX = i2;
            this.eis = i3;
            this.eit = i4;
        }
    }

    public i(@NonNull com.rd.animation.a.b.a aVar) {
        super(aVar);
    }

    @NonNull
    /* renamed from: aSZ */
    public AnimatorSet aIz() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    /* renamed from: cL */
    public i cI(long j) {
        super.cI(j);
        return this;
    }

    public i a(int i, int i2, int i3, boolean z) {
        if (b(i, i2, i3, z)) {
            this.animator = aIz();
            this.eie = i;
            this.eif = i2;
            this.radius = i3;
            this.eil = z;
            this.eim = i - i3;
            this.ein = i + i3;
            this.eio.ix(this.eim);
            this.eio.iy(this.ein);
            a gi = gi(z);
            long j = this.ehL / 2;
            ValueAnimator a = a(gi.fromX, gi.toX, j, false, this.eio);
            ValueAnimator a2 = a(gi.eis, gi.eit, j, true, this.eio);
            ((AnimatorSet) this.animator).playSequentially(new Animator[]{a, a2});
        }
        return this;
    }

    /* renamed from: ac */
    public i W(float f) {
        if (this.animator == null) {
            return this;
        }
        long j = (long) (f * ((float) this.ehL));
        Iterator it = ((AnimatorSet) this.animator).getChildAnimations().iterator();
        while (it.hasNext()) {
            ValueAnimator valueAnimator = (ValueAnimator) ((Animator) it.next());
            long duration = valueAnimator.getDuration();
            if (j <= duration) {
                duration = j;
            }
            valueAnimator.setCurrentPlayTime(duration);
            j -= duration;
        }
        return this;
    }

    ValueAnimator a(int i, int i2, long j, final boolean z, final h hVar) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                i.this.a(hVar, valueAnimator, z);
            }
        });
        return ofInt;
    }

    private void a(@NonNull h hVar, @NonNull ValueAnimator valueAnimator, boolean z) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.eil) {
            if (z) {
                hVar.ix(intValue);
            } else {
                hVar.iy(intValue);
            }
        } else if (z) {
            hVar.iy(intValue);
        } else {
            hVar.ix(intValue);
        }
        if (this.eho != null) {
            this.eho.a(hVar);
        }
    }

    boolean b(int i, int i2, int i3, boolean z) {
        if (this.eie == i && this.eif == i2 && this.radius == i3 && this.eil == z) {
            return false;
        }
        return true;
    }

    @NonNull
    a gi(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        if (z) {
            i = this.eie + this.radius;
            i2 = this.eif + this.radius;
            i3 = this.eie - this.radius;
            i4 = this.eif - this.radius;
        } else {
            i = this.eie - this.radius;
            i2 = this.eif - this.radius;
            i3 = this.eie + this.radius;
            i4 = this.eif + this.radius;
        }
        return new a(i, i2, i3, i4);
    }
}
