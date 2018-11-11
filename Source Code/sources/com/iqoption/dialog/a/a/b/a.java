package com.iqoption.dialog.a.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import com.google.common.collect.ImmutableList;
import com.iqoption.dialog.a.a.b;
import com.iqoption.dialog.a.a.c;
import com.iqoption.dialog.a.a.e;
import com.iqoption.dialog.a.a.f;
import com.iqoption.dto.Point;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.x.R;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/* compiled from: DigitalDecorDrawer */
public final class a implements com.iqoption.dialog.a.a.d.a {
    @ColorInt
    private final int ahg;
    @ColorInt
    private final int ahh;
    private final String ciB;
    private double ciC;
    private final Path ciE = new Path();
    private final Drawable ciG;
    private final Drawable ciH;
    private final Drawable ciI;
    private final Drawable ciJ;
    private final Rect ciK;
    private final float ciL;
    private final float ciM;
    private final Paint ciN = new Paint(1);
    private final Paint ciO = new Paint(1);
    private final RectF ciP = new RectF();
    private final RectF ciQ = new RectF();
    private final RectF ciR = new RectF();
    private final RectF ciS = new RectF();
    private final RectF ciT = new RectF();
    private final float ciU;
    private final float ciV;
    private final float ciW;
    private final float ciX;
    private final e ciY;
    private final float ciZ;
    private final Resources cic;
    private final float cja;
    private final e cjb;
    private final float cjc;
    private final float cjd;
    private final Drawable cje;
    private final Drawable cjf;
    private final RectF cjg = new RectF();
    private final f cjh;
    private final float cji;
    private final float cjj;
    private c[] cjk;
    private d[] cjl;
    private d[] cjm;

    public a(Context context, String str) {
        this.ciB = str;
        this.cic = context.getResources();
        this.ahh = ContextCompat.getColor(context, R.color.red);
        this.ahg = ContextCompat.getColor(context, R.color.green);
        this.ciG = b.m(context, R.drawable.ic_point_red_8dp);
        this.ciH = b.m(context, R.drawable.ic_point_green_8dp);
        this.ciI = b.m(context, R.drawable.ic_strike_red_18dp);
        this.ciJ = b.m(context, R.drawable.ic_strike_green_18dp);
        this.ciK = new Rect();
        this.ciL = (float) (this.ciI.getIntrinsicWidth() / 2);
        this.ciM = (float) (this.ciI.getIntrinsicWidth() / 2);
        this.ciN.setColor(this.ahh);
        this.ciN.setStyle(Style.STROKE);
        this.ciN.setStrokeCap(Cap.ROUND);
        this.ciN.setStrokeJoin(Join.ROUND);
        this.ciN.setPathEffect(new DashPathEffect(new float[]{this.cic.getDimension(R.dimen.dp4), this.cic.getDimension(R.dimen.dp2)}, 0.0f));
        this.ciO.setColor(this.ahh);
        this.ciO.setStyle(Style.STROKE);
        this.ciW = this.cic.getDimension(R.dimen.dp65);
        this.ciX = this.cic.getDimension(R.dimen.dp11);
        this.ciU = this.cic.getDimension(R.dimen.dp1);
        this.ciV = this.cic.getDimension(R.dimen.dp1);
        this.ciY = new e((float) this.cic.getDimensionPixelSize(R.dimen.dp1), ContextCompat.getColor(context, R.color.grey_blur_70), ContextCompat.getColor(context, R.color.grey_blur));
        this.ciY.E((float) this.cic.getDimensionPixelSize(R.dimen.dp8));
        this.ciY.F(this.cic.getDimension(R.dimen.dp10));
        this.ciZ = this.cic.getDimension(R.dimen.dp8);
        this.cja = this.cic.getDimension(R.dimen.dp4);
        this.cjb = new e(this.cic.getDimension(R.dimen.dp1), ContextCompat.getColor(context, R.color.grey_blur), ContextCompat.getColor(context, R.color.white));
        this.cjb.E(this.cic.getDimension(R.dimen.dp8));
        this.cjb.F(this.cic.getDimension(R.dimen.dp10));
        this.cjc = this.cic.getDimension(R.dimen.dp4);
        this.cjd = this.cic.getDimension(R.dimen.dp6);
        this.cje = b.m(context, R.drawable.ic_indicator_call_10dp);
        this.cjf = b.m(context, R.drawable.ic_indicator_put_10dp);
        this.cjh = new f("ITM");
        this.cjh.setSize(this.cic.getDimension(R.dimen.dp8));
        this.cjh.setColor(ContextCompat.getColor(context, R.color.white));
        this.cji = this.cic.getDimension(R.dimen.dp2);
        float dimension = this.cic.getDimension(R.dimen.dp4);
        this.cjj = this.cic.getDimension(R.dimen.dp4);
        this.cjg.set(0.0f, 0.0f, (((float) (this.cje.getIntrinsicWidth() + this.cjh.getIntrinsicWidth())) + this.cji) + dimension, (float) Math.max(this.cje.getIntrinsicHeight(), this.cjh.getIntrinsicHeight()));
    }

    public void a(@NonNull ImmutableList<Position> immutableList, Point point, @NonNull PointF[] pointFArr) {
        ImmutableList<Position> immutableList2 = immutableList;
        this.cjk = new c[immutableList.size()];
        this.cjl = new d[this.cjk.length];
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        Map arrayMap3 = new ArrayMap();
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            Map map;
            d dVar;
            boolean z;
            Position position = (Position) immutableList2.get(i);
            PointF pointF = pointFArr[i];
            boolean isCall = position.isCall();
            boolean equalsIgnoreCase = "win".equalsIgnoreCase(position.getWin());
            boolean isSold = position.isSold();
            Float valueOf = Float.valueOf(position.getValue().floatValue());
            d dVar2 = (d) arrayMap.get(valueOf);
            if (dVar2 == null) {
                dVar2 = new d(valueOf.floatValue());
                arrayMap.put(valueOf, dVar2);
            }
            d dVar3 = dVar2;
            e eVar;
            if (isCall) {
                eVar = (e) arrayMap2.get(valueOf);
                if (eVar == null) {
                    eVar = new e();
                    arrayMap2.put(valueOf, eVar);
                }
                e eVar2 = eVar;
                if (dVar3.cjq == null) {
                    dVar3.cjq = Float.valueOf(pointF.x);
                }
                if (dVar3.cjs == null) {
                    dVar3.cjs = eVar2;
                }
                if (eVar2.value == 0.0f && !dVar3.aeN()) {
                    eVar2.value = -this.ciV;
                    if (dVar3.cjt != null) {
                        dVar3.cjt.value = this.ciV;
                    }
                }
                map = arrayMap2;
                dVar = dVar3;
                z = isCall;
                this.cjk[i] = new c(pointF, this.ahg, this.ciH, this.ciJ, eVar2);
            } else {
                map = arrayMap2;
                dVar = dVar3;
                z = isCall;
                eVar = (e) arrayMap3.get(valueOf);
                if (eVar == null) {
                    eVar = new e();
                    arrayMap3.put(valueOf, eVar);
                }
                e eVar3 = eVar;
                if (dVar.cjr == null) {
                    dVar.cjr = Float.valueOf(pointF.x);
                }
                if (dVar.cjt == null) {
                    dVar.cjt = eVar3;
                }
                if (eVar3.value == 0.0f && !dVar.aeN()) {
                    eVar3.value = this.ciV;
                    if (dVar.cjs != null) {
                        dVar.cjs.value = -this.ciV;
                    }
                }
                this.cjk[i] = new c(pointF, this.ahh, this.ciG, this.ciI, eVar3);
            }
            if (equalsIgnoreCase && !isSold && dVar.cju == null) {
                dVar.cjv = z;
                dVar.cju = z ? this.cje : this.cjf;
            }
            this.cjl[i] = dVar;
            i++;
            arrayMap2 = map;
        }
        this.ciC = ((Double) com.google.common.base.e.h(((Position) immutableList2.get(0)).getExpValue(), Double.valueOf(point.rate))).doubleValue();
        this.cjm = (d[]) arrayMap.values().toArray(new d[arrayMap.size()]);
        Arrays.sort(this.cjm, b.$instance);
    }

    public void b(RectF rectF) {
        rectF.right -= this.cic.getDimension(R.dimen.dp143);
    }

    public void a(c cVar, Canvas canvas) {
        c cVar2 = cVar;
        Canvas canvas2 = canvas;
        int pointsToDrawCount = cVar.getPointsToDrawCount();
        if (pointsToDrawCount != 0) {
            float f;
            float D;
            float f2;
            float f3;
            int i;
            float f4;
            float f5;
            int i2;
            int i3;
            int i4;
            int pointsCount = cVar.getPointsCount();
            float decorProgress = cVar.getDecorProgress();
            float f6 = 0.0f;
            float e = b.e(decorProgress, 0.0f, 0.5f);
            float e2 = b.e(decorProgress, 0.2f, 0.8f);
            float e3 = b.e(decorProgress, 0.8f, 1.0f);
            Object obj = pointsToDrawCount == pointsCount ? 1 : null;
            if (obj != null) {
                PointF pointF;
                PointF eg = cVar2.eg(pointsCount - 1);
                float C = cVar2.C(eg.x);
                f = this.ciW + C;
                int i5 = 0;
                while (i5 < this.cjm.length) {
                    d dVar;
                    int i6;
                    float f7;
                    d dVar2 = this.cjm[i5];
                    D = cVar2.D(dVar2.value);
                    if (e2 > f6) {
                        canvas.save();
                        canvas2.translate(f6, D);
                        if (dVar2.cjq != null) {
                            float C2 = cVar2.C(dVar2.cjq.floatValue());
                            float f8 = f - C2;
                            this.ciO.setColor(this.ahg);
                            f6 = dVar2.cjs.value;
                            f2 = C2 + (f8 * e2);
                            f3 = e;
                            i = pointsCount;
                            dVar = dVar2;
                            i6 = i5;
                            f4 = C2;
                            C2 = f;
                            f = f6;
                            PointF pointF2 = eg;
                            f5 = f2;
                            f2 = D;
                            i2 = pointsToDrawCount;
                            f7 = C2;
                            pointF = pointF2;
                            i3 = 0;
                            canvas2.drawLine(f4, f, f5, dVar2.cjs.value, this.ciO);
                        } else {
                            i6 = i5;
                            pointF = eg;
                            f2 = D;
                            i2 = pointsToDrawCount;
                            i = pointsCount;
                            f3 = e;
                            i3 = 0;
                            dVar = dVar2;
                            f7 = f;
                        }
                        if (dVar.cjr != null) {
                            f4 = cVar2.C(dVar.cjr.floatValue());
                            f = f7 - f4;
                            this.ciO.setColor(this.ahh);
                            canvas2.drawLine(f4, dVar.cjt.value, f4 + (f * e2), dVar.cjt.value, this.ciO);
                        }
                        canvas.restore();
                    } else {
                        i6 = i5;
                        pointF = eg;
                        f2 = D;
                        i2 = pointsToDrawCount;
                        i = pointsCount;
                        f3 = e;
                        i3 = 0;
                        dVar = dVar2;
                        f7 = f;
                    }
                    if (e3 > 0.0f) {
                        i4 = (int) (e3 * 255.0f);
                        this.cjh.setAlpha(i4);
                        this.ciY.setAlpha(i4);
                        this.ciY.setText(String.format(Locale.US, this.ciB, new Object[]{Float.valueOf(dVar.value)}));
                        this.ciP.set(0.0f, 0.0f, ((float) this.ciY.getIntrinsicWidth()) + (this.ciZ * 2.0f), ((float) this.ciY.getIntrinsicHeight()) + (this.cja * 2.0f));
                        canvas.save();
                        canvas2.translate(f7, f2 - this.ciP.centerY());
                        canvas.save();
                        if (dVar.cju != null) {
                            f4 = (this.ciP.right - this.cjg.right) / 2.0f;
                            if (dVar.cjv) {
                                f = (this.ciP.top - this.cjg.height()) + this.cjj;
                            } else {
                                f = this.ciP.bottom - this.cjj;
                            }
                            this.ciR.set(f4, f, this.cjg.width() + f4, this.cjg.height() + f);
                            canvas.save();
                            canvas2.translate(f4 + this.cji, f);
                            dVar.cju.setAlpha(i4);
                            dVar.cju.draw(canvas2);
                            canvas2.translate((float) dVar.cju.getIntrinsicWidth(), 0.0f);
                            this.cjh.draw(canvas2);
                            canvas.restore();
                            canvas2.clipRect(this.ciR, Op.XOR);
                        }
                        canvas.save();
                        this.ciQ.set((this.ciP.right + this.ciU) * e3, this.ciP.top - this.ciU, this.ciP.right + this.ciU, this.ciP.bottom + this.ciU);
                        canvas2.clipRect(this.ciQ, Op.DIFFERENCE);
                        if (dVar.aeN()) {
                            if (dVar.cjq != null) {
                                this.ciO.setColor(this.ahg);
                            } else if (dVar.cjr != null) {
                                this.ciO.setColor(this.ahh);
                            } else {
                                this.ciO.setColor(i3);
                            }
                            canvas2.drawRoundRect(this.ciP, this.ciX, this.ciX, this.ciO);
                        } else {
                            canvas.save();
                            this.ciS.set(this.ciP.left - this.ciU, this.ciP.top - this.ciU, this.ciP.right + this.ciU, this.ciP.centerY() + dVar.cjt.value);
                            canvas2.clipRect(this.ciS, Op.DIFFERENCE);
                            this.ciO.setColor(this.ahh);
                            canvas2.drawRoundRect(this.ciP, this.ciX, this.ciX, this.ciO);
                            canvas.restore();
                            canvas.save();
                            this.ciT.set(this.ciP.left - this.ciU, this.ciP.centerY() + dVar.cjs.value, this.ciP.right + this.ciU, this.ciP.bottom + this.ciU);
                            canvas2.clipRect(this.ciT, Op.DIFFERENCE);
                            this.ciO.setColor(this.ahg);
                            canvas2.drawRoundRect(this.ciP, this.ciX, this.ciX, this.ciO);
                            canvas.restore();
                        }
                        canvas.restore();
                        canvas.restore();
                        canvas.save();
                        canvas2.translate(this.ciZ, this.cja);
                        this.ciY.draw(canvas2);
                        canvas.restore();
                        canvas.restore();
                    }
                    i5 = i6 + 1;
                    f = f7;
                    e = f3;
                    pointsCount = i;
                    pointsToDrawCount = i2;
                    eg = pointF;
                    f6 = 0.0f;
                }
                pointF = eg;
                i2 = pointsToDrawCount;
                i = pointsCount;
                f3 = e;
                i3 = 0;
                if (e3 > 0.0f) {
                    this.cjb.setAlpha((int) (e3 * 255.0f));
                    this.cjb.setText(String.format(Locale.US, this.ciB, new Object[]{Double.valueOf(this.ciC)}));
                    canvas.save();
                    canvas2.translate(C + this.cjc, cVar2.D(pointF.y) + this.cjd);
                    this.cjb.draw(canvas2);
                    canvas.restore();
                }
            } else {
                i2 = pointsToDrawCount;
                i = pointsCount;
                f3 = e;
                i3 = 0;
            }
            for (i4 = 0; i4 < this.cjk.length; i4++) {
                c cVar3 = this.cjk[i4];
                PointF pointF3 = cVar3.lA;
                if (pointF3.x > cVar2.eg(i2 - 1).x) {
                    break;
                }
                f5 = cVar2.C(pointF3.x);
                f = cVar2.D(pointF3.y);
                D = cVar2.D(this.cjl[i4].value) - f;
                canvas.save();
                Drawable drawable = cVar3.aRS;
                canvas2.translate(f5 - ((float) (drawable.getIntrinsicWidth() / 2)), f - ((float) (drawable.getIntrinsicHeight() / 2)));
                drawable.draw(canvas2);
                canvas.restore();
                this.ciE.reset();
                this.ciE.moveTo(f5, f);
                this.ciE.lineTo(f5, f + (D * (((float) ((i2 - i4) - 1)) / ((float) ((i - i4) - 1)))));
                this.ciN.setColor(cVar3.cjn);
                canvas2.drawPath(this.ciE, this.ciN);
            }
            if (obj != null) {
                for (i3 = 
/*
Method generation error in method: com.iqoption.dialog.a.a.b.a.a(com.iqoption.dialog.a.a.c, android.graphics.Canvas):void, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r11_14 'i3' int) = (r11_12 'i3' int), (r11_12 'i3' int), (r11_13 'i3' int) binds: {(r11_12 'i3' int)=B:45:0x02d2, (r11_12 'i3' int)=B:46:0x02d4, (r11_13 'i3' int)=B:47:0x0312} in method: com.iqoption.dialog.a.a.b.a.a(com.iqoption.dialog.a.a.c, android.graphics.Canvas):void, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:183)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:173)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:323)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:260)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:222)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 27 more

*/
}
