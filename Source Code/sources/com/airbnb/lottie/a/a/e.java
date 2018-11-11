package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.q;
import java.util.List;

/* compiled from: EllipseContent */
public class e implements j, l, a {
    private final h iS;
    @Nullable
    private r kE;
    private final com.airbnb.lottie.a.b.a<?, PointF> kI;
    private final com.airbnb.lottie.a.b.a<?, PointF> kJ;
    private final com.airbnb.lottie.model.content.a kK;
    private boolean kL;
    private final Path kr = new Path();
    private final String name;

    public e(h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.iS = hVar;
        this.kI = aVar2.eg().dW();
        this.kJ = aVar2.dZ().dW();
        this.kK = aVar2;
        aVar.a(this.kI);
        aVar.a(this.kJ);
        this.kI.b(this);
        this.kJ.b(this);
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

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        if (this.kL) {
            return this.kr;
        }
        this.kr.reset();
        PointF pointF = (PointF) this.kI.getValue();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.kr.reset();
        float f5;
        if (this.kK.eh()) {
            float f6 = -f2;
            this.kr.moveTo(0.0f, f6);
            float f7 = 0.0f - f3;
            float f8 = -f;
            float f9 = 0.0f - f4;
            this.kr.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            f4 += 0.0f;
            f5 = f6;
            this.kr.cubicTo(f8, f4, f7, f2, 0.0f, f2);
            f3 += 0.0f;
            this.kr.cubicTo(f3, f2, f, f4, f, 0.0f);
            this.kr.cubicTo(f, f9, f3, f5, 0.0f, f5);
        } else {
            float f10 = -f2;
            this.kr.moveTo(0.0f, f10);
            f5 = f3 + 0.0f;
            float f11 = 0.0f - f4;
            this.kr.cubicTo(f5, f10, f, f11, f, 0.0f);
            f4 += 0.0f;
            this.kr.cubicTo(f, f4, f5, f2, 0.0f, f2);
            f3 = 0.0f - f3;
            float f12 = -f;
            this.kr.cubicTo(f3, f2, f12, f4, f12, 0.0f);
            f2 = f10;
            this.kr.cubicTo(f12, f11, f3, f2, 0.0f, f2);
        }
        pointF = (PointF) this.kJ.getValue();
        this.kr.offset(pointF.x, pointF.y);
        this.kr.close();
        f.a(this.kr, this.kE);
        this.kL = true;
        return this.kr;
    }

    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    public <T> void a(T t, @Nullable c<T> cVar) {
        if (t == q.jT) {
            this.kI.a(cVar);
        } else if (t == q.jU) {
            this.kJ.a(cVar);
        }
    }
}
