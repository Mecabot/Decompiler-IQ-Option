package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.model.content.h;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation */
public class l extends a<h, Path> {
    private final h lE = new h();
    private final Path lF = new Path();

    public l(List<a<h>> list) {
        super(list);
    }

    /* renamed from: g */
    public Path a(a<h> aVar, float f) {
        this.lE.a((h) aVar.oP, (h) aVar.oQ, f);
        e.a(this.lE, this.lF);
        return this.lF;
    }
}
