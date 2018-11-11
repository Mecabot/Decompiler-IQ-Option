package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape.Type;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.e;
import com.airbnb.lottie.q;
import java.util.List;

/* compiled from: PolystarContent */
public class m implements j, l, a {
    private final h iS;
    @Nullable
    private r kE;
    private final com.airbnb.lottie.a.b.a<?, PointF> kJ;
    private boolean kL;
    private final Type kZ;
    private final Path kr = new Path();
    private final com.airbnb.lottie.a.b.a<?, Float> la;
    private final com.airbnb.lottie.a.b.a<?, Float> lb;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> lc;
    private final com.airbnb.lottie.a.b.a<?, Float> ld;
    @Nullable
    private final com.airbnb.lottie.a.b.a<?, Float> le;
    private final com.airbnb.lottie.a.b.a<?, Float> lf;
    private final String name;

    public m(h hVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.iS = hVar;
        this.name = polystarShape.getName();
        this.kZ = polystarShape.eu();
        this.la = polystarShape.ev().dW();
        this.kJ = polystarShape.dZ().dW();
        this.lb = polystarShape.eb().dW();
        this.ld = polystarShape.ex().dW();
        this.lf = polystarShape.ez().dW();
        if (this.kZ == Type.Star) {
            this.lc = polystarShape.ew().dW();
            this.le = polystarShape.ey().dW();
        } else {
            this.lc = null;
            this.le = null;
        }
        aVar.a(this.la);
        aVar.a(this.kJ);
        aVar.a(this.lb);
        aVar.a(this.ld);
        aVar.a(this.lf);
        if (this.kZ == Type.Star) {
            aVar.a(this.lc);
            aVar.a(this.le);
        }
        this.la.b(this);
        this.kJ.b(this);
        this.lb.b(this);
        this.ld.b(this);
        this.lf.b(this);
        if (this.kZ == Type.Star) {
            this.ld.b(this);
            this.lf.b(this);
        }
    }

    public void dp() {
        invalidate();
    }

    private void invalidate() {
        this.kL = false;
        this.iS.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.dy() == ShapeTrimPath.Type.Simultaneously) {
                    this.kE = rVar;
                    this.kE.a(this);
                }
            }
        }
    }

    public Path getPath() {
        if (this.kL) {
            return this.kr;
        }
        this.kr.reset();
        switch (this.kZ) {
            case Star:
                dw();
                break;
            case Polygon:
                dx();
                break;
        }
        this.kr.close();
        f.a(this.kr, this.kE);
        this.kL = true;
        return this.kr;
    }

    public String getName() {
        return this.name;
    }

    private void dw() {
        float f;
        double d;
        float sin;
        float f2;
        float f3;
        float f4;
        double d2;
        float floatValue = ((Float) this.la.getValue()).floatValue();
        double toRadians = Math.toRadians((this.lb == null ? 0.0d : (double) ((Float) this.lb.getValue()).floatValue()) - 90.0d);
        double d3 = (double) floatValue;
        float f5 = (float) (6.283185307179586d / d3);
        float f6 = f5 / 2.0f;
        floatValue -= (float) ((int) floatValue);
        if (floatValue != 0.0f) {
            toRadians += (double) ((1.0f - floatValue) * f6);
        }
        float floatValue2 = ((Float) this.ld.getValue()).floatValue();
        float floatValue3 = ((Float) this.lc.getValue()).floatValue();
        float floatValue4 = this.le != null ? ((Float) this.le.getValue()).floatValue() / 100.0f : 0.0f;
        float floatValue5 = this.lf != null ? ((Float) this.lf.getValue()).floatValue() / 100.0f : 0.0f;
        double d4;
        float cos;
        if (floatValue != 0.0f) {
            f = ((floatValue2 - floatValue3) * floatValue) + floatValue3;
            float f7 = floatValue2;
            d = (double) f;
            d4 = d3;
            cos = (float) (d * Math.cos(toRadians));
            sin = (float) (d * Math.sin(toRadians));
            this.kr.moveTo(cos, sin);
            f2 = cos;
            f3 = sin;
            f4 = f7;
            d2 = toRadians + ((double) ((f5 * floatValue) / 2.0f));
            toRadians = d4;
        } else {
            d4 = d3;
            cos = floatValue2;
            d3 = (double) cos;
            f2 = (float) (Math.cos(toRadians) * d3);
            sin = (float) (d3 * Math.sin(toRadians));
            this.kr.moveTo(f2, sin);
            f4 = cos;
            f3 = sin;
            d2 = toRadians + ((double) f6);
            toRadians = d4;
            f = 0.0f;
        }
        toRadians = Math.ceil(toRadians) * 2.0d;
        int i = 0;
        float f8 = f2;
        float f9 = floatValue3;
        float f10 = floatValue4;
        d = d2;
        sin = f3;
        int i2 = 0;
        while (true) {
            double d5 = (double) i;
            if (d5 < toRadians) {
                float f11;
                float f12;
                double d6;
                double d7;
                float f13;
                float f14;
                float f15 = i2 != 0 ? f4 : f9;
                if (f == 0.0f || d5 != toRadians - 2.0d) {
                    f11 = f5;
                    f5 = f6;
                } else {
                    f11 = f5;
                    f5 = (f5 * floatValue) / 2.0f;
                }
                if (f == 0.0f || d5 != toRadians - 1.0d) {
                    f12 = f6;
                    d6 = d5;
                    f6 = f15;
                } else {
                    f12 = f6;
                    d6 = d5;
                    f6 = f;
                }
                d5 = (double) f6;
                double d8 = toRadians;
                float cos2 = (float) (d5 * Math.cos(d));
                float sin2 = (float) (d5 * Math.sin(d));
                if (f10 == 0.0f && floatValue5 == 0.0f) {
                    this.kr.lineTo(cos2, sin2);
                    d7 = d;
                    f13 = floatValue5;
                    f14 = f;
                } else {
                    d7 = d;
                    double atan2 = (double) ((float) (Math.atan2((double) sin, (double) f8) - 1.5707963267948966d));
                    floatValue2 = (float) Math.cos(atan2);
                    f6 = (float) Math.sin(atan2);
                    f13 = floatValue5;
                    f14 = f;
                    d5 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                    f2 = (float) Math.cos(d5);
                    floatValue3 = (float) Math.sin(d5);
                    floatValue4 = i2 != 0 ? f10 : f13;
                    f = ((i2 != 0 ? f9 : f4) * floatValue4) * 0.47829f;
                    floatValue2 *= f;
                    f *= f6;
                    f15 = ((i2 != 0 ? f4 : f9) * (i2 != 0 ? f13 : f10)) * 0.47829f;
                    f2 *= f15;
                    f15 *= floatValue3;
                    if (floatValue != 0.0f) {
                        if (i == 0) {
                            floatValue2 *= floatValue;
                            f *= floatValue;
                        } else if (d6 == d8 - 1.0d) {
                            f2 *= floatValue;
                            f15 *= floatValue;
                        }
                    }
                    this.kr.cubicTo(f8 - floatValue2, sin - f, cos2 + f2, sin2 + f15, cos2, sin2);
                }
                d = d7 + ((double) f5);
                i2 ^= 1;
                i++;
                f8 = cos2;
                sin = sin2;
                f5 = f11;
                f6 = f12;
                toRadians = d8;
                floatValue5 = f13;
                f = f14;
            } else {
                PointF pointF = (PointF) this.kJ.getValue();
                this.kr.offset(pointF.x, pointF.y);
                this.kr.close();
                return;
            }
        }
    }

    private void dx() {
        int floor = (int) Math.floor((double) ((Float) this.la.getValue()).floatValue());
        double toRadians = Math.toRadians((this.lb == null ? 0.0d : (double) ((Float) this.lb.getValue()).floatValue()) - 90.0d);
        double d = (double) floor;
        float f = (float) (6.283185307179586d / d);
        float floatValue = ((Float) this.lf.getValue()).floatValue() / 100.0f;
        float floatValue2 = ((Float) this.ld.getValue()).floatValue();
        double d2 = (double) floatValue2;
        float cos = (float) (Math.cos(toRadians) * d2);
        float sin = (float) (Math.sin(toRadians) * d2);
        this.kr.moveTo(cos, sin);
        double d3 = (double) f;
        toRadians += d3;
        d = Math.ceil(d);
        floor = 0;
        while (((double) floor) < d) {
            double d4;
            int i;
            double d5;
            double d6;
            float cos2 = (float) (Math.cos(toRadians) * d2);
            double d7 = d;
            float sin2 = (float) (d2 * Math.sin(toRadians));
            if (floatValue != 0.0f) {
                d4 = d2;
                i = floor;
                d5 = toRadians;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                d6 = d3;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f2 = (floatValue2 * floatValue) * 0.25f;
                this.kr.cubicTo(cos - (((float) Math.cos(atan2)) * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                i = floor;
                d5 = toRadians;
                d4 = d2;
                d6 = d3;
                this.kr.lineTo(cos2, sin2);
            }
            toRadians = d5 + d6;
            floor = i + 1;
            sin = sin2;
            cos = cos2;
            d = d7;
            d2 = d4;
            d3 = d6;
        }
        PointF pointF = (PointF) this.kJ.getValue();
        this.kr.offset(pointF.x, pointF.y);
        this.kr.close();
    }

    public void a(e eVar, int i, List<e> list, e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    public <T> void a(T t, @Nullable c<T> cVar) {
        if (t == q.kb) {
            this.la.a(cVar);
        } else if (t == q.kc) {
            this.lb.a(cVar);
        } else if (t == q.jU) {
            this.kJ.a(cVar);
        } else if (t == q.kd && this.lc != null) {
            this.lc.a(cVar);
        } else if (t == q.ke) {
            this.ld.a(cVar);
        } else if (t == q.kf && this.le != null) {
            this.le.a(cVar);
        } else if (t == q.kg) {
            this.lf.a(cVar);
        }
    }
}
