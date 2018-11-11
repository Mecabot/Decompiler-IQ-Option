package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.a.b.a;
import com.rd.animation.b.a.g;

/* compiled from: ThinWormAnimation */
public class h extends i {
    private g eij = new g();

    public h(@NonNull a aVar) {
        super(aVar);
    }

    /* renamed from: cK */
    public h cL(long j) {
        super.cI(j);
        return this;
    }

    public i a(int i, int i2, int i3, boolean z) {
        int i4 = i;
        int i5 = i3;
        boolean z2 = z;
        if (b(i, i2, i3, z)) {
            this.animator = aIz();
            this.eie = i4;
            this.eif = i2;
            this.radius = i5;
            this.eil = z2;
            int i6 = i5 * 2;
            this.eim = i4 - i5;
            this.ein = i4 + i5;
            this.eij.ix(this.eim);
            this.eij.iy(this.ein);
            this.eij.setHeight(i6);
            a gi = gi(z2);
            long j = (long) (((double) this.ehL) * 0.8d);
            long j2 = (long) (((double) this.ehL) * 0.2d);
            long j3 = (long) (((double) this.ehL) * 0.5d);
            long j4 = (long) (((double) this.ehL) * 0.5d);
            long j5 = j4;
            j4 = j;
            int i7 = i6;
            long j6 = j3;
            ValueAnimator a = a(gi.fromX, gi.toX, j4, false, this.eij);
            a(gi.eis, gi.eit, j4, true, this.eij).setStartDelay(j2);
            j4 = j6;
            int i8 = i7;
            int i9 = i3;
            ValueAnimator a2 = a(i8, i9, j4);
            a(i9, i8, j4).setStartDelay(j5);
            ((AnimatorSet) this.animator).playTogether(new Animator[]{a, r0, a2, r1});
        }
        return this;
    }

    private ValueAnimator a(int i, int i2, long j) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.e(valueAnimator);
            }
        });
        return ofInt;
    }

    private void e(@NonNull ValueAnimator valueAnimator) {
        this.eij.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
        if (this.eho != null) {
            this.eho.a(this.eij);
        }
    }

    /* renamed from: ab */
    public h ac(float f) {
        if (this.animator != null) {
            long j = (long) (f * ((float) this.ehL));
            int size = ((AnimatorSet) this.animator).getChildAnimations().size();
            for (int i = 0; i < size; i++) {
                ValueAnimator valueAnimator = (ValueAnimator) ((AnimatorSet) this.animator).getChildAnimations().get(i);
                long startDelay = j - valueAnimator.getStartDelay();
                long duration = valueAnimator.getDuration();
                if (startDelay <= duration) {
                    duration = startDelay < 0 ? 0 : startDelay;
                }
                if ((i != size - 1 || duration > 0) && valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                    valueAnimator.setCurrentPlayTime(duration);
                }
            }
        }
        return this;
    }
}
