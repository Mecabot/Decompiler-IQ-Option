package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.m;

/* compiled from: AnimatableSplitDimensionPathValue */
public class i implements m<PointF, PointF> {
    private final b mp;
    private final b mq;

    public i(b bVar, b bVar2) {
        this.mp = bVar;
        this.mq = bVar2;
    }

    public a<PointF, PointF> dW() {
        return new m(this.mp.dW(), this.mq.dW());
    }
}
