package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.e.a;
import java.util.List;

/* compiled from: PathKeyframeAnimation */
public class i extends f<PointF> {
    private final PointF lA = new PointF();
    private final float[] lB = new float[2];
    private h lC;
    private PathMeasure lD;

    public i(List<? extends a<PointF>> list) {
        super(list);
    }

    /* renamed from: e */
    public PointF a(a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return (PointF) aVar.oP;
        }
        if (this.lu != null) {
            return (PointF) this.lu.b(hVar.jr, hVar.oS.floatValue(), hVar.oP, hVar.oQ, dE(), f, getProgress());
        }
        if (this.lC != hVar) {
            this.lD = new PathMeasure(path, false);
            this.lC = hVar;
        }
        this.lD.getPosTan(f * this.lD.getLength(), this.lB, null);
        this.lA.set(this.lB[0], this.lB[1]);
        return this.lA;
    }
}
