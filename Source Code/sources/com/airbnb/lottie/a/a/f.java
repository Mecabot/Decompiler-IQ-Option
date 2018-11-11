package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.d;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.i;
import com.airbnb.lottie.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent */
public class f implements d, j, a {
    private final h iS;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> kC;
    private final List<l> kD = new ArrayList();
    private final com.airbnb.lottie.a.b.a<Integer, Integer> kM;
    private final Path kr = new Path();
    private final com.airbnb.lottie.model.layer.a ku;
    private final Paint kx = new Paint(1);
    private final com.airbnb.lottie.a.b.a<Integer, Integer> kz;
    private final String name;

    public f(h hVar, com.airbnb.lottie.model.layer.a aVar, i iVar) {
        this.ku = aVar;
        this.name = iVar.getName();
        this.iS = hVar;
        if (iVar.eG() == null || iVar.ec() == null) {
            this.kM = null;
            this.kz = null;
            return;
        }
        this.kr.setFillType(iVar.getFillType());
        this.kM = iVar.eG().dW();
        this.kM.b(this);
        aVar.a(this.kM);
        this.kz = iVar.ec().dW();
        this.kz.b(this);
        aVar.a(this.kz);
    }

    public void dp() {
        this.iS.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            b bVar = (b) list2.get(i);
            if (bVar instanceof l) {
                this.kD.add((l) bVar);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        d.beginSection("FillContent#draw");
        this.kx.setColor(((Integer) this.kM.getValue()).intValue());
        int i2 = 0;
        this.kx.setAlpha(e.clamp((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.kz.getValue()).intValue())) / 100.0f) * 255.0f), 0, 255));
        if (this.kC != null) {
            this.kx.setColorFilter((ColorFilter) this.kC.getValue());
        }
        this.kr.reset();
        while (i2 < this.kD.size()) {
            this.kr.addPath(((l) this.kD.get(i2)).getPath(), matrix);
            i2++;
        }
        canvas.drawPath(this.kr, this.kx);
        d.X("FillContent#draw");
    }

    public void a(RectF rectF, Matrix matrix) {
        this.kr.reset();
        for (int i = 0; i < this.kD.size(); i++) {
            this.kr.addPath(((l) this.kD.get(i)).getPath(), matrix);
        }
        this.kr.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        e.a(eVar, i, list, eVar2, this);
    }

    public <T> void a(T t, @Nullable c<T> cVar) {
        if (t == q.jN) {
            this.kM.a(cVar);
        } else if (t == q.jQ) {
            this.kz.a(cVar);
        } else if (t != q.kk) {
        } else {
            if (cVar == null) {
                this.kC = null;
                return;
            }
            this.kC = new p(cVar);
            this.kC.b(this);
            this.ku.a(this.kC);
        }
    }
}
