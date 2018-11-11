package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.content.f;
import com.airbnb.lottie.model.e;
import java.util.List;

/* compiled from: RectangleContent */
public class n implements j, l, a {
    private final h iS;
    @Nullable
    private r kE;
    private final com.airbnb.lottie.a.b.a<?, PointF> kI;
    private final com.airbnb.lottie.a.b.a<?, PointF> kJ;
    private boolean kL;
    private final Path kr = new Path();
    private final RectF kt = new RectF();
    private final com.airbnb.lottie.a.b.a<?, Float> lh;
    private final String name;

    public <T> void a(T t, @Nullable c<T> cVar) {
    }

    public n(h hVar, com.airbnb.lottie.model.layer.a aVar, f fVar) {
        this.name = fVar.getName();
        this.iS = hVar;
        this.kJ = fVar.dZ().dW();
        this.kI = fVar.eg().dW();
        this.lh = fVar.eA().dW();
        aVar.a(this.kJ);
        aVar.a(this.kI);
        aVar.a(this.lh);
        this.kJ.b(this);
        this.kI.b(this);
        this.lh.b(this);
    }

    public String getName() {
        return this.name;
    }

    public void dp() {
        invalidate();
    }

    private void invalidate() {
        this.kL = false;
        this.iS.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.dy() == Type.Simultaneously) {
                    this.kE = rVar;
                    this.kE.a(this);
                }
            }
        }
    }

    public Path getPath() {
        if (this.kL) {
            return this.kr;
        }
        this.kr.reset();
        PointF pointF = (PointF) this.kI.getValue();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float floatValue = this.lh == null ? 0.0f : ((Float) this.lh.getValue()).floatValue();
        float min = Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF pointF2 = (PointF) this.kJ.getValue();
        this.kr.moveTo(pointF2.x + f, (pointF2.y - f2) + floatValue);
        this.kr.lineTo(pointF2.x + f, (pointF2.y + f2) - floatValue);
        if (floatValue > 0.0f) {
            float f3 = floatValue * 2.0f;
            this.kt.set((pointF2.x + f) - f3, (pointF2.y + f2) - f3, pointF2.x + f, pointF2.y + f2);
            this.kr.arcTo(this.kt, 0.0f, 90.0f, false);
        }
        this.kr.lineTo((pointF2.x - f) + floatValue, pointF2.y + f2);
        if (floatValue > 0.0f) {
            float f4 = floatValue * 2.0f;
            this.kt.set(pointF2.x - f, (pointF2.y + f2) - f4, (pointF2.x - f) + f4, pointF2.y + f2);
            this.kr.arcTo(this.kt, 90.0f, 90.0f, false);
        }
        this.kr.lineTo(pointF2.x - f, (pointF2.y - f2) + floatValue);
        if (floatValue > 0.0f) {
            float f5 = floatValue * 2.0f;
            this.kt.set(pointF2.x - f, pointF2.y - f2, (pointF2.x - f) + f5, (pointF2.y - f2) + f5);
            this.kr.arcTo(this.kt, 180.0f, 90.0f, false);
        }
        this.kr.lineTo((pointF2.x + f) - floatValue, pointF2.y - f2);
        if (floatValue > 0.0f) {
            floatValue *= 2.0f;
            this.kt.set((pointF2.x + f) - floatValue, pointF2.y - f2, pointF2.x + f, (pointF2.y - f2) + floatValue);
            this.kr.arcTo(this.kt, 270.0f, 90.0f, false);
        }
        this.kr.close();
        com.airbnb.lottie.d.f.a(this.kr, this.kE);
        this.kL = true;
        return this.kr;
    }

    public void a(e eVar, int i, List<e> list, e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }
}
