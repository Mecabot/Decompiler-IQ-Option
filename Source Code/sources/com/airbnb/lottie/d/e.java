package com.airbnb.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.airbnb.lottie.a.a.j;
import com.airbnb.lottie.model.a;
import com.airbnb.lottie.model.content.h;
import java.util.List;

/* compiled from: MiscUtils */
public class e {
    public static double a(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return d + (d3 * (d2 - d));
    }

    public static boolean b(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float lerp(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int lerp(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (((float) i) + (f * ((float) (i2 - i))));
    }

    public static PointF b(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF eE = hVar.eE();
        path.moveTo(eE.x, eE.y);
        PointF pointF = new PointF(eE.x, eE.y);
        for (int i = 0; i < hVar.eF().size(); i++) {
            a aVar = (a) hVar.eF().get(i);
            PointF dP = aVar.dP();
            PointF dQ = aVar.dQ();
            PointF dR = aVar.dR();
            if (dP.equals(pointF) && dQ.equals(dR)) {
                path.lineTo(dR.x, dR.y);
            } else {
                path.cubicTo(dP.x, dP.y, dQ.x, dQ.y, dR.x, dR.y);
            }
            pointF.set(dR.x, dR.y);
        }
        if (hVar.isClosed()) {
            path.close();
        }
    }

    static int f(float f, float f2) {
        return floorMod((int) f, (int) f2);
    }

    private static int floorMod(int i, int i2) {
        return i - (i2 * floorDiv(i, i2));
    }

    private static int floorDiv(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0 ? 1 : null) != null || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2, j jVar) {
        if (eVar.h(jVar.getName(), i)) {
            list.add(eVar2.af(jVar.getName()).a(jVar));
        }
    }
}
