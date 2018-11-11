package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.d;
import com.airbnb.lottie.g;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.e;
import com.airbnb.lottie.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompositionLayer */
public class c extends a {
    private final List<a> jq = new ArrayList();
    private final RectF kt = new RectF();
    @Nullable
    private a<Float, Float> nL;
    private final RectF nM = new RectF();

    public c(h hVar, Layer layer, List<Layer> list, g gVar) {
        super(hVar, layer);
        b fc = layer.fc();
        if (fc != null) {
            this.nL = fc.dW();
            a(this.nL);
            this.nL.b(this);
        } else {
            this.nL = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(gVar.dc().size());
        int size = list.size() - 1;
        a aVar = null;
        while (true) {
            int i = 0;
            if (size >= 0) {
                Layer layer2 = (Layer) list.get(size);
                a a = a.a(layer2, hVar, gVar);
                if (a != null) {
                    longSparseArray.put(a.eK().getId(), a);
                    if (aVar == null) {
                        this.jq.add(0, a);
                        switch (layer2.eW()) {
                            case Add:
                            case Invert:
                                aVar = a;
                                break;
                            default:
                                break;
                        }
                    }
                    aVar.b(a);
                    aVar = null;
                }
                size--;
            } else {
                while (i < longSparseArray.size()) {
                    a aVar2 = (a) longSparseArray.get(longSparseArray.keyAt(i));
                    if (aVar2 != null) {
                        a aVar3 = (a) longSparseArray.get(aVar2.eK().eX());
                        if (aVar3 != null) {
                            aVar2.c(aVar3);
                        }
                    }
                    i++;
                }
                return;
            }
        }
    }

    void b(Canvas canvas, Matrix matrix, int i) {
        d.beginSection("CompositionLayer#draw");
        canvas.save();
        this.nM.set(0.0f, 0.0f, (float) this.nB.eT(), (float) this.nB.eU());
        matrix.mapRect(this.nM);
        for (int size = this.jq.size() - 1; size >= 0; size--) {
            if (!this.nM.isEmpty() ? canvas.clipRect(this.nM) : true) {
                ((a) this.jq.get(size)).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        d.X("CompositionLayer#draw");
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.kt.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.jq.size() - 1; size >= 0; size--) {
            ((a) this.jq.get(size)).a(this.kt, this.nA);
            if (rectF.isEmpty()) {
                rectF.set(this.kt);
            } else {
                rectF.set(Math.min(rectF.left, this.kt.left), Math.min(rectF.top, this.kt.top), Math.max(rectF.right, this.kt.right), Math.max(rectF.bottom, this.kt.bottom));
            }
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.setProgress(f);
        if (this.nL != null) {
            f = ((float) ((long) (((Float) this.nL.getValue()).floatValue() * 1000.0f))) / this.iS.getComposition().cZ();
        }
        if (this.nB.eP() != 0.0f) {
            f /= this.nB.eP();
        }
        f -= this.nB.eQ();
        for (int size = this.jq.size() - 1; size >= 0; size--) {
            ((a) this.jq.get(size)).setProgress(f);
        }
    }

    protected void b(e eVar, int i, List<e> list, e eVar2) {
        for (int i2 = 0; i2 < this.jq.size(); i2++) {
            ((a) this.jq.get(i2)).a(eVar, i, list, eVar2);
        }
    }

    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((Object) t, (com.airbnb.lottie.e.c) cVar);
        if (t != q.kj) {
            return;
        }
        if (cVar == null) {
            this.nL = null;
            return;
        }
        this.nL = new p(cVar);
        a(this.nL);
    }
}
