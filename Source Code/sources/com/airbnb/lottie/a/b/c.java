package com.airbnb.lottie.a.b;

import com.airbnb.lottie.d.e;
import com.airbnb.lottie.e.a;
import java.util.List;

/* compiled from: FloatKeyframeAnimation */
public class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    /* renamed from: c */
    Float a(a<Float> aVar, float f) {
        if (aVar.oP == null || aVar.oQ == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else if (this.lu == null) {
            return Float.valueOf(e.lerp(((Float) aVar.oP).floatValue(), ((Float) aVar.oQ).floatValue(), f));
        } else {
            return (Float) this.lu.b(aVar.jr, aVar.oS.floatValue(), aVar.oP, aVar.oQ, f, dE(), getProgress());
        }
    }
}
