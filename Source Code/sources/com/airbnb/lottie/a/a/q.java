package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.ShapeStroke;

/* compiled from: StrokeContent */
public class q extends a {
    @Nullable
    private a<ColorFilter, ColorFilter> kC;
    private final a<Integer, Integer> kM;
    private final com.airbnb.lottie.model.layer.a ku;
    private final String name;

    public q(h hVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(hVar, aVar, shapeStroke.en().toPaintCap(), shapeStroke.eo().toPaintJoin(), shapeStroke.ec(), shapeStroke.em(), shapeStroke.ep(), shapeStroke.eq());
        this.ku = aVar;
        this.name = shapeStroke.getName();
        this.kM = shapeStroke.eG().dW();
        this.kM.b(this);
        aVar.a(this.kM);
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        this.kx.setColor(((Integer) this.kM.getValue()).intValue());
        if (this.kC != null) {
            this.kx.setColorFilter((ColorFilter) this.kC.getValue());
        }
        super.a(canvas, matrix, i);
    }

    public String getName() {
        return this.name;
    }

    public <T> void a(T t, @Nullable c<T> cVar) {
        super.a((Object) t, (c) cVar);
        if (t == com.airbnb.lottie.q.jO) {
            this.kM.a(cVar);
        } else if (t != com.airbnb.lottie.q.kk) {
        } else {
            if (cVar == null) {
                this.kC = null;
                return;
            }
            this.kC = new p(cVar);
            this.kC.b(this);
            this.ku.a(this.kM);
        }
    }
}
