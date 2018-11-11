package com.airbnb.lottie.a.b;

import com.airbnb.lottie.e.a;
import com.airbnb.lottie.model.content.c;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation */
public class d extends f<c> {
    private final c lw;

    public d(List<a<c>> list) {
        super(list);
        int i = 0;
        c cVar = (c) ((a) list.get(0)).oP;
        if (cVar != null) {
            i = cVar.getSize();
        }
        this.lw = new c(new float[i], new int[i]);
    }

    /* renamed from: d */
    c a(a<c> aVar, float f) {
        this.lw.a((c) aVar.oP, (c) aVar.oQ, f);
        return this.lw;
    }
}
