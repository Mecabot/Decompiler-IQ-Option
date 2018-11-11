package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.e.a;
import java.util.List;

/* compiled from: PointKeyframeAnimation */
public class j extends f<PointF> {
    private final PointF lA = new PointF();

    public j(List<a<PointF>> list) {
        super(list);
    }

    /* renamed from: e */
    public PointF a(a<PointF> aVar, float f) {
        if (aVar.oP == null || aVar.oQ == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) aVar.oP;
        PointF pointF2 = (PointF) aVar.oQ;
        if (this.lu != null) {
            return (PointF) this.lu.b(aVar.jr, aVar.oS.floatValue(), pointF, pointF2, f, dE(), getProgress());
        }
        this.lA.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
        return this.lA;
    }
}
