package com.airbnb.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.d;
import com.airbnb.lottie.a.b.c;
import com.airbnb.lottie.a.b.g;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.Mask.MaskMode;
import com.airbnb.lottie.model.e;
import com.airbnb.lottie.model.f;
import com.airbnb.lottie.model.layer.Layer.MatteType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseLayer */
public abstract class a implements d, com.airbnb.lottie.a.b.a.a, f {
    private static boolean nq = false;
    final h iS;
    private final Path kr = new Path();
    private final RectF kt = new RectF();
    final o lk;
    private final Matrix matrix = new Matrix();
    final Matrix nA = new Matrix();
    final Layer nB;
    @Nullable
    private g nC;
    @Nullable
    private a nD;
    @Nullable
    private a nE;
    private List<a> nF;
    private final List<com.airbnb.lottie.a.b.a<?, ?>> nG = new ArrayList();
    private final Paint nr = new Paint(1);
    private final Paint ns = new Paint(1);
    private final Paint nt = new Paint(1);
    private final Paint nu = new Paint(1);
    private final Paint nv = new Paint();
    private final RectF nw = new RectF();
    private final RectF nx = new RectF();
    private final RectF ny = new RectF();
    private final String nz;
    private boolean visible = true;

    public void a(List<b> list, List<b> list2) {
    }

    abstract void b(Canvas canvas, Matrix matrix, int i);

    void b(e eVar, int i, List<e> list, e eVar2) {
    }

    @Nullable
    static a a(Layer layer, h hVar, com.airbnb.lottie.g gVar) {
        switch (layer.eV()) {
            case Shape:
                return new f(hVar, layer);
            case PreComp:
                return new c(hVar, layer, gVar.Z(layer.eS()), gVar);
            case Solid:
                return new g(hVar, layer);
            case Image:
                return new d(hVar, layer);
            case Null:
                return new e(hVar, layer);
            case Text:
                return new h(hVar, layer);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown layer type ");
                stringBuilder.append(layer.eV());
                com.airbnb.lottie.d.warn(stringBuilder.toString());
                return null;
        }
    }

    a(h hVar, Layer layer) {
        this.iS = hVar;
        this.nB = layer;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(layer.getName());
        stringBuilder.append("#draw");
        this.nz = stringBuilder.toString();
        this.nv.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.ns.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.nt.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        if (layer.eW() == MatteType.Invert) {
            this.nu.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        } else {
            this.nu.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        }
        this.lk = layer.eD().ef();
        this.lk.a((com.airbnb.lottie.a.b.a.a) this);
        if (!(layer.dI() == null || layer.dI().isEmpty())) {
            this.nC = new g(layer.dI());
            for (com.airbnb.lottie.a.b.a aVar : this.nC.dJ()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.airbnb.lottie.a.b.a aVar2 : this.nC.dK()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        eM();
    }

    public void dp() {
        invalidateSelf();
    }

    Layer eK() {
        return this.nB;
    }

    void b(@Nullable a aVar) {
        this.nD = aVar;
    }

    boolean eL() {
        return this.nD != null;
    }

    void c(@Nullable a aVar) {
        this.nE = aVar;
    }

    private void eM() {
        boolean z = true;
        if (this.nB.eR().isEmpty()) {
            setVisible(true);
            return;
        }
        com.airbnb.lottie.a.b.a cVar = new c(this.nB.eR());
        cVar.dC();
        cVar.b(new b(this, cVar));
        if (((Float) cVar.getValue()).floatValue() != 1.0f) {
            z = false;
        }
        setVisible(z);
        a(cVar);
    }

    private void invalidateSelf() {
        this.iS.invalidateSelf();
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, RectF rectF, Paint paint) {
        if (VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.nG.add(aVar);
    }

    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.nA.set(matrix);
        this.nA.preConcat(this.lk.getMatrix());
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.d.beginSection(this.nz);
        if (this.visible) {
            eO();
            com.airbnb.lottie.d.beginSection("Layer#parentMatrix");
            this.matrix.reset();
            this.matrix.set(matrix);
            for (int size = this.nF.size() - 1; size >= 0; size--) {
                this.matrix.preConcat(((a) this.nF.get(size)).lk.getMatrix());
            }
            com.airbnb.lottie.d.X("Layer#parentMatrix");
            i = (int) ((((((float) i) / 255.0f) * ((float) ((Integer) this.lk.dM().getValue()).intValue())) / 100.0f) * 255.0f);
            if (eL() || eN()) {
                com.airbnb.lottie.d.beginSection("Layer#computeBounds");
                this.kt.set(0.0f, 0.0f, 0.0f, 0.0f);
                a(this.kt, this.matrix);
                c(this.kt, this.matrix);
                this.matrix.preConcat(this.lk.getMatrix());
                b(this.kt, this.matrix);
                this.kt.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
                com.airbnb.lottie.d.X("Layer#computeBounds");
                com.airbnb.lottie.d.beginSection("Layer#saveLayer");
                a(canvas, this.kt, this.nr);
                com.airbnb.lottie.d.X("Layer#saveLayer");
                e(canvas);
                com.airbnb.lottie.d.beginSection("Layer#drawLayer");
                b(canvas, this.matrix, i);
                com.airbnb.lottie.d.X("Layer#drawLayer");
                if (eN()) {
                    a(canvas, this.matrix);
                }
                if (eL()) {
                    com.airbnb.lottie.d.beginSection("Layer#drawMatte");
                    com.airbnb.lottie.d.beginSection("Layer#saveLayer");
                    a(canvas, this.kt, this.nu);
                    com.airbnb.lottie.d.X("Layer#saveLayer");
                    e(canvas);
                    this.nD.a(canvas, matrix, i);
                    com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.d.X("Layer#restoreLayer");
                    com.airbnb.lottie.d.X("Layer#drawMatte");
                }
                com.airbnb.lottie.d.beginSection("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.d.X("Layer#restoreLayer");
                f(com.airbnb.lottie.d.X(this.nz));
                return;
            }
            this.matrix.preConcat(this.lk.getMatrix());
            com.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, i);
            com.airbnb.lottie.d.X("Layer#drawLayer");
            f(com.airbnb.lottie.d.X(this.nz));
            return;
        }
        com.airbnb.lottie.d.X(this.nz);
    }

    private void f(float f) {
        this.iS.getComposition().getPerformanceTracker().a(this.nB.getName(), f);
    }

    private void e(Canvas canvas) {
        com.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.kt.left - 1.0f, this.kt.top - 1.0f, this.kt.right + 1.0f, this.kt.bottom + 1.0f, this.nv);
        com.airbnb.lottie.d.X("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.nw.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (eN()) {
            int size = this.nC.dI().size();
            int i = 0;
            while (i < size) {
                Mask mask = (Mask) this.nC.dI().get(i);
                this.kr.set((Path) ((com.airbnb.lottie.a.b.a) this.nC.dJ().get(i)).getValue());
                this.kr.transform(matrix);
                switch (mask.er()) {
                    case MaskModeSubtract:
                        return;
                    case MaskModeIntersect:
                        return;
                    default:
                        this.kr.computeBounds(this.ny, false);
                        if (i == 0) {
                            this.nw.set(this.ny);
                        } else {
                            this.nw.set(Math.min(this.nw.left, this.ny.left), Math.min(this.nw.top, this.ny.top), Math.max(this.nw.right, this.ny.right), Math.max(this.nw.bottom, this.ny.bottom));
                        }
                        i++;
                }
            }
            rectF.set(Math.max(rectF.left, this.nw.left), Math.max(rectF.top, this.nw.top), Math.min(rectF.right, this.nw.right), Math.min(rectF.bottom, this.nw.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (eL() && this.nB.eW() != MatteType.Invert) {
            this.nD.a(this.nx, matrix);
            rectF.set(Math.max(rectF.left, this.nx.left), Math.max(rectF.top, this.nx.top), Math.min(rectF.right, this.nx.right), Math.min(rectF.bottom, this.nx.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, MaskMode.MaskModeAdd);
        a(canvas, matrix, MaskMode.MaskModeIntersect);
        a(canvas, matrix, MaskMode.MaskModeSubtract);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047 A:{RETURN} */
    private void a(android.graphics.Canvas r7, android.graphics.Matrix r8, com.airbnb.lottie.model.content.Mask.MaskMode r9) {
        /*
        r6 = this;
        r0 = com.airbnb.lottie.model.layer.a.AnonymousClass1.nK;
        r1 = r9.ordinal();
        r0 = r0[r1];
        r1 = 1;
        switch(r0) {
            case 1: goto L_0x001b;
            case 2: goto L_0x000d;
            default: goto L_0x000c;
        };
    L_0x000c:
        goto L_0x001e;
    L_0x000d:
        r0 = nq;
        if (r0 != 0) goto L_0x001e;
    L_0x0011:
        r0 = "LOTTIE";
        r2 = "Animation contains intersect masks. They are not supported but will be treated like add masks.";
        android.util.Log.w(r0, r2);
        nq = r1;
        goto L_0x001e;
    L_0x001b:
        r0 = r6.nt;
        goto L_0x0020;
    L_0x001e:
        r0 = r6.ns;
    L_0x0020:
        r2 = r6.nC;
        r2 = r2.dI();
        r2 = r2.size();
        r3 = 0;
        r4 = 0;
    L_0x002c:
        if (r4 >= r2) goto L_0x0044;
    L_0x002e:
        r5 = r6.nC;
        r5 = r5.dI();
        r5 = r5.get(r4);
        r5 = (com.airbnb.lottie.model.content.Mask) r5;
        r5 = r5.er();
        if (r5 != r9) goto L_0x0041;
    L_0x0040:
        goto L_0x0045;
    L_0x0041:
        r4 = r4 + 1;
        goto L_0x002c;
    L_0x0044:
        r1 = 0;
    L_0x0045:
        if (r1 != 0) goto L_0x0048;
    L_0x0047:
        return;
    L_0x0048:
        r1 = "Layer#drawMask";
        com.airbnb.lottie.d.beginSection(r1);
        r1 = "Layer#saveLayer";
        com.airbnb.lottie.d.beginSection(r1);
        r1 = r6.kt;
        r6.a(r7, r1, r0);
        r0 = "Layer#saveLayer";
        com.airbnb.lottie.d.X(r0);
        r6.e(r7);
    L_0x005f:
        if (r3 >= r2) goto L_0x00c7;
    L_0x0061:
        r0 = r6.nC;
        r0 = r0.dI();
        r0 = r0.get(r3);
        r0 = (com.airbnb.lottie.model.content.Mask) r0;
        r0 = r0.er();
        if (r0 == r9) goto L_0x0074;
    L_0x0073:
        goto L_0x00c4;
    L_0x0074:
        r0 = r6.nC;
        r0 = r0.dJ();
        r0 = r0.get(r3);
        r0 = (com.airbnb.lottie.a.b.a) r0;
        r0 = r0.getValue();
        r0 = (android.graphics.Path) r0;
        r1 = r6.kr;
        r1.set(r0);
        r0 = r6.kr;
        r0.transform(r8);
        r0 = r6.nC;
        r0 = r0.dK();
        r0 = r0.get(r3);
        r0 = (com.airbnb.lottie.a.b.a) r0;
        r1 = r6.nr;
        r1 = r1.getAlpha();
        r4 = r6.nr;
        r0 = r0.getValue();
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r0 = (float) r0;
        r5 = 1076048691; // 0x40233333 float:2.55 double:5.316386915E-315;
        r0 = r0 * r5;
        r0 = (int) r0;
        r4.setAlpha(r0);
        r0 = r6.kr;
        r4 = r6.nr;
        r7.drawPath(r0, r4);
        r0 = r6.nr;
        r0.setAlpha(r1);
    L_0x00c4:
        r3 = r3 + 1;
        goto L_0x005f;
    L_0x00c7:
        r8 = "Layer#restoreLayer";
        com.airbnb.lottie.d.beginSection(r8);
        r7.restore();
        r7 = "Layer#restoreLayer";
        com.airbnb.lottie.d.X(r7);
        r7 = "Layer#drawMask";
        com.airbnb.lottie.d.X(r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.a.a(android.graphics.Canvas, android.graphics.Matrix, com.airbnb.lottie.model.content.Mask$MaskMode):void");
    }

    boolean eN() {
        return (this.nC == null || this.nC.dJ().isEmpty()) ? false : true;
    }

    private void setVisible(boolean z) {
        if (z != this.visible) {
            this.visible = z;
            invalidateSelf();
        }
    }

    void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lk.setProgress(f);
        if (this.nB.eP() != 0.0f) {
            f /= this.nB.eP();
        }
        if (this.nD != null) {
            this.nD.setProgress(this.nD.nB.eP() * f);
        }
        for (int i = 0; i < this.nG.size(); i++) {
            ((com.airbnb.lottie.a.b.a) this.nG.get(i)).setProgress(f);
        }
    }

    private void eO() {
        if (this.nF == null) {
            if (this.nE == null) {
                this.nF = Collections.emptyList();
                return;
            }
            this.nF = new ArrayList();
            for (a aVar = this.nE; aVar != null; aVar = aVar.nE) {
                this.nF.add(aVar);
            }
        }
    }

    public String getName() {
        return this.nB.getName();
    }

    public void a(e eVar, int i, List<e> list, e eVar2) {
        if (eVar.f(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.af(getName());
                if (eVar.h(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.i(getName(), i)) {
                b(eVar, i + eVar.g(getName(), i), list, eVar2);
            }
        }
    }

    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        this.lk.b(t, cVar);
    }
}
