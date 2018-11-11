package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent */
public abstract class a implements d, j, com.airbnb.lottie.a.b.a.a {
    private final h iS;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> kA;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> kB;
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> kC;
    private final PathMeasure kq = new PathMeasure();
    private final Path kr = new Path();
    private final Path ks = new Path();
    private final RectF kt = new RectF();
    private final com.airbnb.lottie.model.layer.a ku;
    private final List<a> kv = new ArrayList();
    private final float[] kw;
    final Paint kx = new Paint(1);
    private final com.airbnb.lottie.a.b.a<?, Float> ky;
    private final com.airbnb.lottie.a.b.a<?, Integer> kz;

    /* compiled from: BaseStrokeContent */
    private static final class a {
        private final List<l> kD;
        @Nullable
        private final r kE;

        private a(@Nullable r rVar) {
            this.kD = new ArrayList();
            this.kE = rVar;
        }
    }

    a(h hVar, com.airbnb.lottie.model.layer.a aVar, Cap cap, Join join, d dVar, b bVar, List<b> list, b bVar2) {
        int i;
        this.iS = hVar;
        this.ku = aVar;
        this.kx.setStyle(Style.STROKE);
        this.kx.setStrokeCap(cap);
        this.kx.setStrokeJoin(join);
        this.kz = dVar.dW();
        this.ky = bVar.dW();
        if (bVar2 == null) {
            this.kB = null;
        } else {
            this.kB = bVar2.dW();
        }
        this.kA = new ArrayList(list.size());
        this.kw = new float[list.size()];
        for (i = 0; i < list.size(); i++) {
            this.kA.add(((b) list.get(i)).dW());
        }
        aVar.a(this.kz);
        aVar.a(this.ky);
        for (i = 0; i < this.kA.size(); i++) {
            aVar.a((com.airbnb.lottie.a.b.a) this.kA.get(i));
        }
        if (this.kB != null) {
            aVar.a(this.kB);
        }
        this.kz.b(this);
        this.ky.b(this);
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((com.airbnb.lottie.a.b.a) this.kA.get(i2)).b(this);
        }
        if (this.kB != null) {
            this.kB.b(this);
        }
    }

    public void dp() {
        this.iS.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        b bVar;
        r rVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            bVar = (b) list.get(size);
            if (bVar instanceof r) {
                r rVar2 = (r) bVar;
                if (rVar2.dy() == Type.Individually) {
                    rVar = rVar2;
                }
            }
        }
        if (rVar != null) {
            rVar.a(this);
        }
        Object obj = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            bVar = (b) list2.get(size2);
            if (bVar instanceof r) {
                r rVar3 = (r) bVar;
                if (rVar3.dy() == Type.Individually) {
                    if (obj != null) {
                        this.kv.add(obj);
                    }
                    obj = new a(rVar3);
                    rVar3.a(this);
                }
            }
            if (bVar instanceof l) {
                if (obj == null) {
                    obj = new a(rVar);
                }
                obj.kD.add((l) bVar);
            }
        }
        if (obj != null) {
            this.kv.add(obj);
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection("StrokeContent#draw");
        int i2 = 0;
        this.kx.setAlpha(e.clamp((int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.kz.getValue()).intValue())) / 100.0f) * 255.0f), 0, 255));
        this.kx.setStrokeWidth(((Float) this.ky.getValue()).floatValue() * f.b(matrix));
        if (this.kx.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.d.X("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.kC != null) {
            this.kx.setColorFilter((ColorFilter) this.kC.getValue());
        }
        while (i2 < this.kv.size()) {
            a aVar = (a) this.kv.get(i2);
            if (aVar.kE != null) {
                a(canvas, aVar, matrix);
            } else {
                com.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                this.kr.reset();
                for (int size = aVar.kD.size() - 1; size >= 0; size--) {
                    this.kr.addPath(((l) aVar.kD.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.d.X("StrokeContent#buildPath");
                com.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.kr, this.kx);
                com.airbnb.lottie.d.X("StrokeContent#drawPath");
            }
            i2++;
        }
        com.airbnb.lottie.d.X("StrokeContent#draw");
    }

    private void a(Canvas canvas, a aVar, Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (aVar.kE == null) {
            com.airbnb.lottie.d.X("StrokeContent#applyTrimPath");
            return;
        }
        this.kr.reset();
        for (int size = aVar.kD.size() - 1; size >= 0; size--) {
            this.kr.addPath(((l) aVar.kD.get(size)).getPath(), matrix);
        }
        this.kq.setPath(this.kr, false);
        float length = this.kq.getLength();
        while (this.kq.nextContour()) {
            length += this.kq.getLength();
        }
        float floatValue = (((Float) aVar.kE.dB().getValue()).floatValue() * length) / 360.0f;
        float floatValue2 = ((((Float) aVar.kE.dz().getValue()).floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((((Float) aVar.kE.dA().getValue()).floatValue() * length) / 100.0f) + floatValue;
        float f = 0.0f;
        for (int size2 = aVar.kD.size() - 1; size2 >= 0; size2--) {
            float f2;
            this.ks.set(((l) aVar.kD.get(size2)).getPath());
            this.ks.transform(matrix);
            this.kq.setPath(this.ks, false);
            float length2 = this.kq.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                f2 = floatValue3 - length;
                if (f2 < f + length2 && f < f2) {
                    f.a(this.ks, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f2 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.ks, this.kx);
                    f += length2;
                }
            }
            f2 = f + length2;
            if (f2 >= floatValue2 && f <= floatValue3) {
                if (f2 > floatValue3 || floatValue2 >= f) {
                    float f4 = floatValue2 < f ? 0.0f : (floatValue2 - f) / length2;
                    if (floatValue3 <= f2) {
                        f3 = (floatValue3 - f) / length2;
                    }
                    f.a(this.ks, f4, f3, 0.0f);
                    canvas.drawPath(this.ks, this.kx);
                } else {
                    canvas.drawPath(this.ks, this.kx);
                }
            }
            f += length2;
        }
        com.airbnb.lottie.d.X("StrokeContent#applyTrimPath");
    }

    public void a(RectF rectF, Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.kr.reset();
        for (int i = 0; i < this.kv.size(); i++) {
            a aVar = (a) this.kv.get(i);
            for (int i2 = 0; i2 < aVar.kD.size(); i2++) {
                this.kr.addPath(((l) aVar.kD.get(i2)).getPath(), matrix);
            }
        }
        this.kr.computeBounds(this.kt, false);
        float floatValue = ((Float) this.ky.getValue()).floatValue() / 2.0f;
        this.kt.set(this.kt.left - floatValue, this.kt.top - floatValue, this.kt.right + floatValue, this.kt.bottom + floatValue);
        rectF.set(this.kt);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.d.X("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.kA.isEmpty()) {
            com.airbnb.lottie.d.X("StrokeContent#applyDashPattern");
            return;
        }
        float b = f.b(matrix);
        for (int i = 0; i < this.kA.size(); i++) {
            this.kw[i] = ((Float) ((com.airbnb.lottie.a.b.a) this.kA.get(i)).getValue()).floatValue();
            if (i % 2 == 0) {
                if (this.kw[i] < 1.0f) {
                    this.kw[i] = 1.0f;
                }
            } else if (this.kw[i] < 0.1f) {
                this.kw[i] = 0.1f;
            }
            float[] fArr = this.kw;
            fArr[i] = fArr[i] * b;
        }
        this.kx.setPathEffect(new DashPathEffect(this.kw, this.kB == null ? 0.0f : ((Float) this.kB.getValue()).floatValue()));
        com.airbnb.lottie.d.X("StrokeContent#applyDashPattern");
    }

    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        e.a(eVar, i, list, eVar2, this);
    }

    @CallSuper
    public <T> void a(T t, @Nullable c<T> cVar) {
        if (t == q.jQ) {
            this.kz.a(cVar);
        } else if (t == q.jX) {
            this.ky.a(cVar);
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
