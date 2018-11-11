package com.iqoption.dialog.a.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import com.google.common.collect.ImmutableList;
import com.iqoption.dialog.a.a.b;
import com.iqoption.dialog.a.a.c;
import com.iqoption.dialog.a.a.f;
import com.iqoption.dto.Point;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.x.R;
import java.util.Locale;

/* compiled from: BinaryDecorDrawer */
public final class a implements com.iqoption.dialog.a.a.d.a {
    @ColorInt
    private final int ahg;
    @ColorInt
    private final int ahh;
    private b[] ciA;
    private String ciB;
    private double ciC;
    private boolean ciD;
    private final Path ciE = new Path();
    private final Resources cic;
    private final Drawable cid;
    private final Drawable cie;
    private final float cif;
    private final float cig;
    private final Paint cih = new Paint(1);
    private final Paint cii = new Paint(1);
    private final Paint cij = new Paint(1);
    private final Paint cik = new Paint(1);
    private final float cil;
    private final float cim;
    private final f cin;
    private final float cio;
    private final Drawable cip;
    private final float ciq;
    private final float cir;
    private final float cis;
    private final float cit;
    private float ciu;
    private float civ;
    private boolean ciw;
    @ColorInt
    private final int cix;
    @ColorInt
    private final int ciy;
    @ColorInt
    private final int ciz;

    public a(Context context, String str) {
        this.ciB = str;
        this.cic = context.getResources();
        this.cid = b.m(context, R.drawable.ic_strike_red_18dp);
        this.cie = b.m(context, R.drawable.ic_strike_green_18dp);
        this.cix = ContextCompat.getColor(context, R.color.grey_blur);
        this.ciz = ContextCompat.getColor(context, R.color.grey_blur_20);
        this.ciy = ContextCompat.getColor(context, R.color.grey_blur_00);
        this.ahh = ContextCompat.getColor(context, R.color.red);
        this.ahg = ContextCompat.getColor(context, R.color.green);
        this.cif = (float) (this.cid.getIntrinsicWidth() / 2);
        this.cig = (float) (this.cid.getIntrinsicHeight() / 2);
        this.cih.setStyle(Style.STROKE);
        this.cih.setPathEffect(new DashPathEffect(new float[]{this.cic.getDimension(R.dimen.dp4), this.cic.getDimension(R.dimen.dp2)}, 0.0f));
        this.cii.setStyle(Style.STROKE);
        this.cii.setStrokeWidth(this.cic.getDimension(R.dimen.dp2));
        this.cil = this.cic.getDimension(R.dimen.dp3);
        this.cim = this.cic.getDimension(R.dimen.dp3);
        this.cin = new f();
        this.cin.setSize(this.cic.getDimension(R.dimen.dp10));
        this.cio = this.cic.getDimension(R.dimen.dp36);
        this.cip = b.m(context, R.drawable.ic_flag_in_circle);
        this.ciq = (float) (this.cip.getIntrinsicWidth() / 2);
        this.cir = (float) (this.cip.getIntrinsicHeight() / 2);
        this.cis = this.cic.getDimension(R.dimen.dp38);
        this.cit = this.cic.getDimension(R.dimen.dp16);
        this.cik.setStyle(Style.STROKE);
    }

    public void a(ImmutableList<e> immutableList, Point point, PointF[] pointFArr) {
        this.ciA = new b[pointFArr.length];
        boolean z = false;
        for (int i = 0; i < this.ciA.length; i++) {
            PointF pointF = pointFArr[i];
            if (pointF != null) {
                e eVar = (e) immutableList.get(i);
                String format = String.format(Locale.US, this.ciB, new Object[]{eVar.getValue()});
                boolean isSold = eVar.isSold() ^ 1;
                if (NotificationCompat.CATEGORY_CALL.equalsIgnoreCase(eVar.getDir())) {
                    this.ciA[i] = new b(format, pointF, this.cie, this.ahg, isSold);
                } else {
                    this.ciA[i] = new b(format, pointF, this.cid, this.ahh, isSold);
                }
            }
        }
        e eVar2 = (e) immutableList.get(0);
        if (eVar2.getExpired().longValue() <= point.timestamp) {
            z = true;
        }
        this.ciD = z;
        if (((long) (eVar2.getExpValue().doubleValue() * 1000000.0d)) > 0) {
            this.ciC = eVar2.getExpValue().doubleValue();
        } else {
            this.ciC = point.rate;
        }
    }

    public void b(RectF rectF) {
        rectF.right -= this.cic.getDimension(R.dimen.dp120);
    }

    public void a(c cVar, Canvas canvas) {
        c cVar2 = cVar;
        Canvas canvas2 = canvas;
        int pointsToDrawCount = cVar.getPointsToDrawCount();
        if (pointsToDrawCount != 0) {
            float f;
            float f2;
            int pointsCount = cVar.getPointsCount();
            float graphProgress = cVar.getGraphProgress();
            float decorProgress = cVar.getDecorProgress();
            float f3 = 0.0f;
            float e = b.e(decorProgress, 0.0f, this.ciD ? 0.4f : 1.0f);
            float e2 = b.e(decorProgress, 0.4f, 1.0f);
            int i = pointsCount - 1;
            float eh = cVar2.eh(i);
            float ei = cVar2.ei(i);
            this.ciE.reset();
            this.ciE.moveTo(0.0f, ei);
            this.ciE.lineTo((eh * graphProgress) + ((this.cio - this.cil) * e), ei);
            this.cih.setColor(this.ciz);
            canvas2.drawPath(this.ciE, this.cih);
            if (e > 0.0f) {
                canvas.save();
                canvas2.translate(this.cio + eh, ei - (((float) this.cin.getIntrinsicHeight()) / 1.5f));
                this.cin.setAlpha((int) (e * 255.0f));
                this.cin.setColor(this.cix);
                f fVar = this.cin;
                Locale locale = Locale.US;
                String str = this.ciB;
                Object[] objArr = new Object[1];
                f = ei;
                objArr[0] = Double.valueOf(this.ciC);
                fVar.setText(String.format(locale, str, objArr));
                this.cin.draw(canvas2);
                canvas.restore();
            } else {
                f = ei;
            }
            while (0 < this.ciA.length) {
                float f4;
                b bVar = this.ciA[0];
                PointF pointF = bVar.lA;
                float C = cVar2.C(pointF.x);
                float D = cVar2.D(pointF.y);
                this.ciE.reset();
                this.ciE.moveTo(f3, D);
                this.cih.setColor(bVar.color);
                float f5 = cVar2.eg(pointsToDrawCount - 1).x;
                if (this.ciw || !bVar.ciF) {
                    f2 = e2;
                } else {
                    f3 = Math.abs(D - f);
                    f2 = e2;
                    if (this.civ < f3) {
                        this.civ = f3;
                    }
                }
                if (pointF.x > f5) {
                    this.ciE.lineTo(cVar2.C(f5), D);
                    canvas2.drawPath(this.ciE, this.cih);
                    f4 = graphProgress;
                    f3 = f;
                    graphProgress = eh;
                } else {
                    float f6;
                    b bVar2;
                    this.ciE.lineTo(C, D);
                    canvas2.drawPath(this.ciE, this.cih);
                    if (bVar.ciF) {
                        decorProgress = eh - C;
                        this.cii.setColor(bVar.color);
                        f5 = C;
                        float f7 = D;
                        f6 = C;
                        C += decorProgress * graphProgress;
                        bVar2 = bVar;
                        f3 = f;
                        f4 = graphProgress;
                        graphProgress = eh;
                        canvas2.drawLine(f5, D, C, f7, this.cii);
                        if (e > 0.0f) {
                            this.ciE.reset();
                            f5 = f7;
                            this.ciE.moveTo(graphProgress, f5);
                            this.ciE.lineTo(graphProgress + ((this.cio - this.cil) * e), f5);
                            canvas2.drawPath(this.ciE, this.cih);
                            this.cij.setColor(bVar2.color);
                            canvas2.drawCircle(graphProgress, f5, this.cim * e, this.cij);
                            canvas.save();
                            canvas2.translate(graphProgress + this.cio, f5 - (((float) this.cin.getIntrinsicHeight()) / 1.5f));
                            this.cin.setAlpha((int) (e * 255.0f));
                            this.cin.setColor(bVar2.color);
                            this.cin.setText(bVar2.value);
                            this.cin.draw(canvas2);
                            canvas.restore();
                        } else {
                            f5 = f7;
                        }
                    } else {
                        f5 = D;
                        f6 = C;
                        bVar2 = bVar;
                        f4 = graphProgress;
                        f3 = f;
                        graphProgress = eh;
                    }
                    canvas.save();
                    Drawable drawable = bVar2.aRS;
                    canvas2.translate(f6 - ((float) (drawable.getIntrinsicWidth() / 2)), f5 - ((float) (drawable.getIntrinsicHeight() / 2)));
                    decorProgress = ((float) ((pointsToDrawCount - 0) - 1)) / ((float) ((pointsCount - 0) - 1));
                    D = 1.0f - decorProgress;
                    decorProgress += 1.0f;
                    drawable.setBounds((int) (this.cif * D), (int) (this.cig * D), (int) (this.cif * decorProgress), (int) (this.cig * decorProgress));
                    drawable.draw(canvas2);
                    canvas.restore();
                }
                int i2 = 0 + 1;
                eh = graphProgress;
                f = f3;
                e2 = f2;
                graphProgress = f4;
                cVar2 = cVar;
            }
            graphProgress = eh;
            f2 = e2;
            f3 = f;
            if (!this.ciw) {
                if (this.civ + this.cit < this.cis) {
                    this.ciu = this.cis;
                } else {
                    this.ciu = this.civ + this.cit;
                }
                this.cik.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.ciu * 2.0f, new int[]{this.ciy, this.cix, this.ciy}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
                this.ciw = true;
            }
            if (this.ciD && f2 > 0.0f) {
                float f8 = 1.0f - f2;
                e2 = f2 + 1.0f;
                canvas.save();
                canvas2.translate(graphProgress, f3 - this.ciu);
                canvas2.drawLine(0.0f, this.ciu * f8, 0.0f, this.ciu * e2, this.cik);
                canvas.restore();
                canvas.save();
                canvas2.translate(graphProgress - this.ciq, f3 - this.cir);
                this.cip.setBounds((int) (this.ciq * f8), (int) (this.cir * f8), (int) (this.ciq * e2), (int) (this.cir * e2));
                this.cip.draw(canvas2);
                canvas.restore();
            }
        }
    }
}
