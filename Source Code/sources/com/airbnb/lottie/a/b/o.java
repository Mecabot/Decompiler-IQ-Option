package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.e.d;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.q;

/* compiled from: TransformKeyframeAnimation */
public class o {
    private final a<PointF, PointF> lI;
    private final a<?, PointF> lJ;
    private final a<d, d> lK;
    private final a<Float, Float> lL;
    private final a<Integer, Integer> lM;
    @Nullable
    private final a<?, Float> lN;
    @Nullable
    private final a<?, Float> lO;
    private final Matrix matrix = new Matrix();

    public o(l lVar) {
        this.lI = lVar.dY().dW();
        this.lJ = lVar.dZ().dW();
        this.lK = lVar.ea().dW();
        this.lL = lVar.eb().dW();
        this.lM = lVar.ec().dW();
        if (lVar.ed() != null) {
            this.lN = lVar.ed().dW();
        } else {
            this.lN = null;
        }
        if (lVar.ee() != null) {
            this.lO = lVar.ee().dW();
        } else {
            this.lO = null;
        }
    }

    public void a(a aVar) {
        aVar.a(this.lI);
        aVar.a(this.lJ);
        aVar.a(this.lK);
        aVar.a(this.lL);
        aVar.a(this.lM);
        if (this.lN != null) {
            aVar.a(this.lN);
        }
        if (this.lO != null) {
            aVar.a(this.lO);
        }
    }

    public void a(a.a aVar) {
        this.lI.b(aVar);
        this.lJ.b(aVar);
        this.lK.b(aVar);
        this.lL.b(aVar);
        this.lM.b(aVar);
        if (this.lN != null) {
            this.lN.b(aVar);
        }
        if (this.lO != null) {
            this.lO.b(aVar);
        }
    }

    public void setProgress(float f) {
        this.lI.setProgress(f);
        this.lJ.setProgress(f);
        this.lK.setProgress(f);
        this.lL.setProgress(f);
        this.lM.setProgress(f);
        if (this.lN != null) {
            this.lN.setProgress(f);
        }
        if (this.lO != null) {
            this.lO.setProgress(f);
        }
    }

    public a<?, Integer> dM() {
        return this.lM;
    }

    @Nullable
    public a<?, Float> dN() {
        return this.lN;
    }

    @Nullable
    public a<?, Float> dO() {
        return this.lO;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF pointF = (PointF) this.lJ.getValue();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.matrix.preTranslate(pointF.x, pointF.y);
        }
        float floatValue = ((Float) this.lL.getValue()).floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        d dVar = (d) this.lK.getValue();
        if (!(dVar.getScaleX() == 1.0f && dVar.getScaleY() == 1.0f)) {
            this.matrix.preScale(dVar.getScaleX(), dVar.getScaleY());
        }
        pointF = (PointF) this.lI.getValue();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.matrix.preTranslate(-pointF.x, -pointF.y);
        }
        return this.matrix;
    }

    public Matrix e(float f) {
        PointF pointF = (PointF) this.lJ.getValue();
        PointF pointF2 = (PointF) this.lI.getValue();
        d dVar = (d) this.lK.getValue();
        float floatValue = ((Float) this.lL.getValue()).floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(pointF.x * f, pointF.y * f);
        double d = (double) f;
        this.matrix.preScale((float) Math.pow((double) dVar.getScaleX(), d), (float) Math.pow((double) dVar.getScaleY(), d));
        this.matrix.preRotate(floatValue * f, pointF2.x, pointF2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable c<T> cVar) {
        if (t == q.jR) {
            this.lI.a(cVar);
        } else if (t == q.jS) {
            this.lJ.a(cVar);
        } else if (t == q.jV) {
            this.lK.a(cVar);
        } else if (t == q.jW) {
            this.lL.a(cVar);
        } else if (t == q.jP) {
            this.lM.a(cVar);
        } else if (t == q.kh && this.lN != null) {
            this.lN.a(cVar);
        } else if (t != q.ki || this.lO == null) {
            return false;
        } else {
            this.lO.a(cVar);
        }
        return true;
    }
}
