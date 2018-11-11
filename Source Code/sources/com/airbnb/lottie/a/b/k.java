package com.airbnb.lottie.a.b;

import com.airbnb.lottie.d.e;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.e.d;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation */
public class k extends f<d> {
    public k(List<a<d>> list) {
        super(list);
    }

    /* renamed from: f */
    public d a(a<d> aVar, float f) {
        if (aVar.oP == null || aVar.oQ == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar = (d) aVar.oP;
        d dVar2 = (d) aVar.oQ;
        if (this.lu == null) {
            return new d(e.lerp(dVar.getScaleX(), dVar2.getScaleX(), f), e.lerp(dVar.getScaleY(), dVar2.getScaleY(), f));
        }
        return (d) this.lu.b(aVar.jr, aVar.oS.floatValue(), dVar, dVar2, f, dE(), getProgress());
    }
}
