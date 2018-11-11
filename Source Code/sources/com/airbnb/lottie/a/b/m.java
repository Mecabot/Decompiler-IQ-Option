package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.a.a;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation */
public class m extends a<PointF, PointF> {
    private final PointF lA = new PointF();
    private final a<Float, Float> lG;
    private final a<Float, Float> lH;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.lG = aVar;
        this.lH = aVar2;
        setProgress(getProgress());
    }

    public void setProgress(float f) {
        this.lG.setProgress(f);
        this.lH.setProgress(f);
        this.lA.set(((Float) this.lG.getValue()).floatValue(), ((Float) this.lH.getValue()).floatValue());
        for (int i = 0; i < this.ln.size(); i++) {
            ((a) this.ln.get(i)).dp();
        }
    }

    /* renamed from: dL */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* renamed from: e */
    PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        return this.lA;
    }
}
