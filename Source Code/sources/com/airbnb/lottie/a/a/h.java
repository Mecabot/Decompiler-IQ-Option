package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.c;
import com.airbnb.lottie.model.content.e;

/* compiled from: GradientStrokeContent */
public class h extends a {
    private final a<c, c> kM;
    private final LongSparseArray<LinearGradient> kN = new LongSparseArray();
    private final LongSparseArray<RadialGradient> kO = new LongSparseArray();
    private final RectF kQ = new RectF();
    private final GradientType kR;
    private final a<PointF, PointF> kS;
    private final a<PointF, PointF> kT;
    private final int kU;
    private final String name;

    public h(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, e eVar) {
        super(hVar, aVar, eVar.en().toPaintCap(), eVar.eo().toPaintJoin(), eVar.ec(), eVar.em(), eVar.ep(), eVar.eq());
        this.name = eVar.getName();
        this.kR = eVar.ei();
        this.kU = (int) (hVar.getComposition().cZ() / 32.0f);
        this.kM = eVar.ej().dW();
        this.kM.b(this);
        aVar.a(this.kM);
        this.kS = eVar.ek().dW();
        this.kS.b(this);
        aVar.a(this.kS);
        this.kT = eVar.el().dW();
        this.kT.b(this);
        aVar.a(this.kT);
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        a(this.kQ, matrix);
        if (this.kR == GradientType.Linear) {
            this.kx.setShader(ds());
        } else {
            this.kx.setShader(dt());
        }
        super.a(canvas, matrix, i);
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
        LinearGradient linearGradient2 = new LinearGradient((float) ((int) ((this.kQ.left + (this.kQ.width() / 2.0f)) + pointF.x)), (float) ((int) ((this.kQ.top + (this.kQ.height() / 2.0f)) + pointF.y)), (float) ((int) ((this.kQ.left + (this.kQ.width() / 2.0f)) + pointF2.x)), (float) ((int) ((this.kQ.top + (this.kQ.height() / 2.0f)) + pointF2.y)), cVar.getColors(), cVar.getPositions(), TileMode.CLAMP);
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
        int width = (int) ((this.kQ.left + (this.kQ.width() / 2.0f)) + pointF.x);
        int height = (int) ((this.kQ.top + (this.kQ.height() / 2.0f)) + pointF.y);
        float f = (float) width;
        float f2 = (float) height;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (((int) ((this.kQ.left + (this.kQ.width() / 2.0f)) + pointF2.x)) - width), (double) (((int) ((this.kQ.top + (this.kQ.height() / 2.0f)) + pointF2.y)) - height)), colors, positions, TileMode.CLAMP);
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
}
