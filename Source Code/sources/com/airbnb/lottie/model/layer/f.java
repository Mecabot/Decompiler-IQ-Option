package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.model.e;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeLayer */
public class f extends a {
    private final c ll;

    f(h hVar, Layer layer) {
        super(hVar, layer);
        this.ll = new c(hVar, this, new j("__container", layer.dT()));
        this.ll.a(Collections.emptyList(), Collections.emptyList());
    }

    void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.ll.a(canvas, matrix, i);
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.ll.a(rectF, this.nA);
    }

    protected void b(e eVar, int i, List<e> list, e eVar2) {
        this.ll.a(eVar, i, list, eVar2);
    }
}
