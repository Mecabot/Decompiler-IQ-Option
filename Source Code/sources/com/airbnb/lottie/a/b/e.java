package com.airbnb.lottie.a.b;

import com.airbnb.lottie.e.a;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation */
public class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    /* renamed from: b */
    Integer a(a<Integer> aVar, float f) {
        if (aVar.oP == null || aVar.oQ == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        } else if (this.lu == null) {
            return Integer.valueOf(com.airbnb.lottie.d.e.lerp(((Integer) aVar.oP).intValue(), ((Integer) aVar.oQ).intValue(), f));
        } else {
            return (Integer) this.lu.b(aVar.jr, aVar.oS.floatValue(), aVar.oP, aVar.oQ, f, dE(), getProgress());
        }
    }
}
