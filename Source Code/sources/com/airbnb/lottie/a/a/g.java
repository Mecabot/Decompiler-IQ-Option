package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.model.content.d;
import com.airbnb.lottie.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent */
public class g implements d, j, a {
    private final h iS;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> kC;
    private final List<l> kD = new ArrayList();
    private final com.airbnb.lottie.a.b.a<c, c> kM;
    private final LongSparseArray<LinearGradient> kN = new LongSparseArray();
    private final LongSparseArray<RadialGradient> kO = new LongSparseArray();
    private final Matrix kP = new Matrix();
    private final RectF kQ = new RectF();
    private final GradientType kR;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> kS;
    private final com.airbnb.lottie.a.b.a<PointF, PointF> kT;
    private final int kU;
    private final Path kr = new Path();
    private final com.airbnb.lottie.model.layer.a ku;
    private final Paint kx = new Paint(1);
    private final com.airbnb.lottie.a.b.a<Integer, Integer> kz;
    @NonNull
    private final String name;

    public g(h hVar, com.airbnb.lottie.model.layer.a aVar, d dVar) {
        this.ku = aVar;
        this.name = dVar.getName();
        this.iS = hVar;
        this.kR = dVar.ei();
        this.kr.setFillType(dVar.getFillType());
        this.kU = (int) (hVar.getComposition().cZ() / 32.0f);
        this.kM = dVar.ej().dW();
        this.kM.b(this);
        aVar.a(this.kM);
        this.kz = dVar.ec().dW();
        this.kz.b(this);
        aVar.a(this.kz);
        this.kS = dVar.ek().dW();
        this.kS.b(this);
        aVar.a(this.kS);
        this.kT = dVar.el().dW();
        this.kT.b(this);
        aVar.a(this.kT);
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

    public void a(Canvas canvas, Matrix matrix, int i) {
        Shader ds;
        com.airbnb.lottie.d.beginSection("GradientFillContent#draw");
        this.kr.reset();
        for (int i2 = 0; i2 < this.kD.size(); i2++) {
            this.kr.addPath(((l) this.kD.get(i2)).getPath(), matrix);
        }
        this.kr.computeBounds(this.kQ, false);
        if (this.kR == GradientType.Linear) {
            ds = ds();
        } else {
            ds = dt();
        }
        this.kP.set(matrix);
        ds.setLocalMatrix(this.kP);
        this.kx.setShader(ds);
        if (this.kC != null) {
            this.kx.setColorFilter((ColorFilter) this.kC.getValue());
        }
        this.kx.setAlpha(e.clamp((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.kz.getValue()).intValue())) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.kr, this.kx);
        com.airbnb.lottie.d.X("GradientFillContent#draw");
    }

    public void a(RectF rectF, Matrix matrix) {
        this.kr.reset();
        for (int i = 0; i < this.kD.size(); i++) {
            this.kr.addPath(((l) this.kD.get(i)).getPath(), matrix);
        }
        this.kr.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public String getName() {
        return this.name;
    }

    private LinearGradient ds() {
        long du = (long) du();
        LinearGradient linearGradient = (LinearGradient) this.kN.get(du);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.kS.getValue();
        PointF pointF2 = (PointF) this.kT.getValue();
        c cVar = (c) this.kM.getValue();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, cVar.getColors(), cVar.getPositions(), TileMode.CLAMP);
        this.kN.put(du, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient dt() {
        long du = (long) du();
        RadialGradient radialGradient = (RadialGradient) this.kO.get(du);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.kS.getValue();
        PointF pointF2 = (PointF) this.kT.getValue();
        c cVar = (c) this.kM.getValue();
        int[] colors = cVar.getColors();
        float[] positions = cVar.getPositions();
        float f = pointF.x;
        float f2 = pointF.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (pointF2.x - f), (double) (pointF2.y - f2)), colors, positions, TileMode.CLAMP);
        this.kO.put(du, radialGradient2);
        return radialGradient2;
    }

    private int du() {
        int round = Math.round(this.kS.getProgress() * ((float) this.kU));
        int round2 = Math.round(this.kT.getProgress() * ((float) this.kU));
        int round3 = Math.round(this.kM.getProgress() * ((float) this.kU));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = (i * 31) * round2;
        }
        return round3 != 0 ? (i * 31) * round3 : i;
    }

    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        e.a(eVar, i, list, eVar2, this);
    }

    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t != q.kk) {
            return;
        }
        if (cVar == null) {
            this.kC = null;
            return;
        }
        this.kC = new p(cVar);
        this.kC.b(this);
        this.ku.a(this.kC);
    }
}
