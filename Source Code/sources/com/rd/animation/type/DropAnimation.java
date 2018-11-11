package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.a.b.a;
import com.rd.animation.b.a.b;
import java.util.Iterator;

public class DropAnimation extends a<AnimatorSet> {
    private int ehQ;
    private int ehR;
    private int ehS;
    private int ehT;
    private b ehU = new b();
    private int radius;

    private enum AnimationType {
        Width,
        Height,
        Radius
    }

    public DropAnimation(@NonNull a aVar) {
        super(aVar);
    }

    @NonNull
    /* renamed from: aSZ */
    public AnimatorSet aIz() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    /* renamed from: Y */
    public DropAnimation W(float f) {
        if (this.animator != null) {
            long j = (long) (f * ((float) this.ehL));
            Object obj = null;
            Iterator it = ((AnimatorSet) this.animator).getChildAnimations().iterator();
            while (it.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) ((Animator) it.next());
                long duration = valueAnimator.getDuration();
                long j2 = obj != null ? j - duration : j;
                if (j2 >= 0) {
                    if (j2 >= duration) {
                        j2 = duration;
                    }
                    if (valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                        valueAnimator.setCurrentPlayTime(j2);
                    }
                    if (obj == null && duration >= this.ehL) {
                        obj = 1;
                    }
                }
            }
        }
        return this;
    }

    /* renamed from: cJ */
    public DropAnimation cI(long j) {
        super.cI(j);
        return this;
    }

    public DropAnimation b(int i, int i2, int i3, int i4, int i5) {
        int i6 = i5;
        if (c(i, i2, i3, i4, i5)) {
            this.animator = aIz();
            int i7 = i;
            this.ehQ = i7;
            int i8 = i2;
            this.ehR = i8;
            int i9 = i3;
            this.ehS = i9;
            int i10 = i4;
            this.ehT = i10;
            this.radius = i6;
            int i11 = (int) (((double) i6) / 1.5d);
            long j = this.ehL / 2;
            Animator a = a(i7, i8, this.ehL, AnimationType.Width);
            long j2 = j;
            Animator a2 = a(i9, i10, j2, AnimationType.Height);
            Animator a3 = a(i6, i11, j2, AnimationType.Radius);
            Animator a4 = a(i10, i9, j2, AnimationType.Height);
            ((AnimatorSet) this.animator).play(a2).with(a3).with(a).before(a4).before(a(i11, i6, j2, AnimationType.Radius));
        }
        return this;
    }

    private ValueAnimator a(int i, int i2, long j, final AnimationType animationType) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropAnimation.this.a(valueAnimator, animationType);
            }
        });
        return ofInt;
    }

    private void a(@NonNull ValueAnimator valueAnimator, @NonNull AnimationType animationType) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        switch (animationType) {
            case Width:
                this.ehU.setWidth(intValue);
                break;
            case Height:
                this.ehU.setHeight(intValue);
                break;
            case Radius:
                this.ehU.setRadius(intValue);
                break;
        }
        if (this.eho != null) {
            this.eho.a(this.ehU);
        }
    }

    private boolean c(int i, int i2, int i3, int i4, int i5) {
        if (this.ehQ == i && this.ehR == i2 && this.ehS == i3 && this.ehT == i4 && this.radius == i5) {
            return false;
        }
        return true;
    }
}
