package com.airbnb.lottie.a.b;

import com.airbnb.lottie.e.a;
import java.util.List;

/* compiled from: ColorKeyframeAnimation */
public class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    /* renamed from: b */
    public Integer a(a<Integer> aVar, float f) {
        if (aVar.oP == null || aVar.oQ == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) aVar.oP).intValue();
        int intValue2 = ((Integer) aVar.oQ).intValue();
        if (this.lu == null) {
            return Integer.valueOf(com.airbnb.lottie.d.b.a(f, intValue, intValue2));
        }
        return (Integer) this.lu.b(aVar.jr, aVar.oS.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, dE(), getProgress());
    }
}
