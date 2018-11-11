package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.b;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.q;
import com.airbnb.lottie.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer */
public class h extends a {
    private final com.airbnb.lottie.h iS;
    private final g ja;
    @Nullable
    private a<Integer, Integer> kM;
    private final Matrix matrix = new Matrix();
    private final char[] og = new char[1];
    private final RectF oh = new RectF();
    private final Paint oi = new Paint(1) {
    };
    private final Paint oj = new Paint(1) {
    };
    private final Map<d, List<c>> ol = new HashMap();
    private final n om;
    @Nullable
    private a<Integer, Integer> oo;
    @Nullable
    private a<Float, Float> op;
    @Nullable
    private a<Float, Float> oq;

    h(com.airbnb.lottie.h hVar, Layer layer) {
        super(hVar, layer);
        this.iS = hVar;
        this.ja = layer.getComposition();
        this.om = layer.fa().dW();
        this.om.b(this);
        a(this.om);
        k fb = layer.fb();
        if (!(fb == null || fb.mr == null)) {
            this.kM = fb.mr.dW();
            this.kM.b(this);
            a(this.kM);
        }
        if (!(fb == null || fb.ms == null)) {
            this.oo = fb.ms.dW();
            this.oo.b(this);
            a(this.oo);
        }
        if (!(fb == null || fb.mt == null)) {
            this.op = fb.mt.dW();
            this.op.b(this);
            a(this.op);
        }
        if (fb != null && fb.mu != null) {
            this.oq = fb.mu.dW();
            this.oq.b(this);
            a(this.oq);
        }
    }

    void b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.iS.dl()) {
            canvas.setMatrix(matrix);
        }
        b bVar = (b) this.om.getValue();
        com.airbnb.lottie.model.c cVar = (com.airbnb.lottie.model.c) this.ja.de().get(bVar.md);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        if (this.kM != null) {
            this.oi.setColor(((Integer) this.kM.getValue()).intValue());
        } else {
            this.oi.setColor(bVar.color);
        }
        if (this.oo != null) {
            this.oj.setColor(((Integer) this.oo.getValue()).intValue());
        } else {
            this.oj.setColor(bVar.strokeColor);
        }
        int intValue = (((Integer) this.lk.dM().getValue()).intValue() * 255) / 100;
        this.oi.setAlpha(intValue);
        this.oj.setAlpha(intValue);
        if (this.op != null) {
            this.oj.setStrokeWidth(((Float) this.op.getValue()).floatValue());
        } else {
            this.oj.setStrokeWidth((((float) bVar.strokeWidth) * f.fo()) * f.b(matrix));
        }
        if (this.iS.dl()) {
            a(bVar, matrix, cVar, canvas);
        } else {
            a(bVar, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float f = ((float) bVar.me) / 100.0f;
        float b = f.b(matrix);
        String str = bVar.text;
        for (int i = 0; i < str.length(); i++) {
            d dVar = (d) this.ja.dd().get(d.a(str.charAt(i), cVar.getFamily(), cVar.dS()));
            if (dVar != null) {
                a(dVar, matrix, f, bVar, canvas);
                float width = ((((float) dVar.getWidth()) * f) * f.fo()) * b;
                float f2 = ((float) bVar.mg) / 10.0f;
                if (this.oq != null) {
                    f2 += ((Float) this.oq.getValue()).floatValue();
                }
                canvas.translate(width + (f2 * b), 0.0f);
            }
        }
    }

    private void a(b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float b = f.b(matrix);
        Typeface g = this.iS.g(cVar.getFamily(), cVar.dS());
        if (g != null) {
            String str = bVar.text;
            w dk = this.iS.dk();
            if (dk != null) {
                str = dk.ac(str);
            }
            this.oi.setTypeface(g);
            this.oi.setTextSize((float) (bVar.me * ((double) f.fo())));
            this.oj.setTypeface(this.oi.getTypeface());
            this.oj.setTextSize(this.oi.getTextSize());
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                a(charAt, bVar, canvas);
                this.og[0] = charAt;
                float measureText = this.oi.measureText(this.og, 0, 1);
                float f = ((float) bVar.mg) / 10.0f;
                if (this.oq != null) {
                    f += ((Float) this.oq.getValue()).floatValue();
                }
                canvas.translate(measureText + (f * b), 0.0f);
            }
        }
    }

    private void a(d dVar, Matrix matrix, float f, b bVar, Canvas canvas) {
        List a = a(dVar);
        for (int i = 0; i < a.size(); i++) {
            Path path = ((c) a.get(i)).getPath();
            path.computeBounds(this.oh, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-bVar.mi)) * f.fo());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (bVar.mj) {
                a(path, this.oi, canvas);
                a(path, this.oj, canvas);
            } else {
                a(path, this.oj, canvas);
                a(path, this.oi, canvas);
            }
        }
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void a(char c, b bVar, Canvas canvas) {
        this.og[0] = c;
        if (bVar.mj) {
            a(this.og, this.oi, canvas);
            a(this.og, this.oj, canvas);
            return;
        }
        a(this.og, this.oj, canvas);
        a(this.og, this.oi, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<c> a(d dVar) {
        if (this.ol.containsKey(dVar)) {
            return (List) this.ol.get(dVar);
        }
        List dT = dVar.dT();
        int size = dT.size();
        List<c> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new c(this.iS, this, (j) dT.get(i)));
        }
        this.ol.put(dVar, arrayList);
        return arrayList;
    }

    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((Object) t, (com.airbnb.lottie.e.c) cVar);
        if (t == q.jN && this.kM != null) {
            this.kM.a(cVar);
        } else if (t == q.jO && this.oo != null) {
            this.oo.a(cVar);
        } else if (t == q.jX && this.op != null) {
            this.op.a(cVar);
        } else if (t == q.jY && this.oq != null) {
            this.oq.a(cVar);
        }
    }
}
