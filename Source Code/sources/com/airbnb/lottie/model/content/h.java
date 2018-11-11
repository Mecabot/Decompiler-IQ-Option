package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.model.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData */
public class h {
    private boolean closed;
    private final List<a> ng = new ArrayList();
    private PointF nh;

    public h(PointF pointF, boolean z, List<a> list) {
        this.nh = pointF;
        this.closed = z;
        this.ng.addAll(list);
    }

    private void e(float f, float f2) {
        if (this.nh == null) {
            this.nh = new PointF();
        }
        this.nh.set(f, f2);
    }

    public PointF eE() {
        return this.nh;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<a> eF() {
        return this.ng;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.nh == null) {
            this.nh = new PointF();
        }
        boolean z = hVar.isClosed() || hVar2.isClosed();
        this.closed = z;
        if (this.ng.isEmpty() || this.ng.size() == hVar.eF().size() || this.ng.size() == hVar2.eF().size()) {
            int size;
            if (this.ng.isEmpty()) {
                for (size = hVar.eF().size() - 1; size >= 0; size--) {
                    this.ng.add(new a());
                }
            }
            PointF eE = hVar.eE();
            PointF eE2 = hVar2.eE();
            e(e.lerp(eE.x, eE2.x, f), e.lerp(eE.y, eE2.y, f));
            for (size = this.ng.size() - 1; size >= 0; size--) {
                a aVar = (a) hVar.eF().get(size);
                a aVar2 = (a) hVar2.eF().get(size);
                PointF dP = aVar.dP();
                PointF dQ = aVar.dQ();
                PointF dR = aVar.dR();
                PointF dP2 = aVar2.dP();
                PointF dQ2 = aVar2.dQ();
                eE2 = aVar2.dR();
                ((a) this.ng.get(size)).b(e.lerp(dP.x, dP2.x, f), e.lerp(dP.y, dP2.y, f));
                ((a) this.ng.get(size)).c(e.lerp(dQ.x, dQ2.x, f), e.lerp(dQ.y, dQ2.y, f));
                ((a) this.ng.get(size)).d(e.lerp(dR.x, eE2.x, f), e.lerp(dR.y, eE2.y, f));
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Curves must have the same number of control points. This: ");
        stringBuilder.append(eF().size());
        stringBuilder.append("\tShape 1: ");
        stringBuilder.append(hVar.eF().size());
        stringBuilder.append("\tShape 2: ");
        stringBuilder.append(hVar2.eF().size());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeData{numCurves=");
        stringBuilder.append(this.ng.size());
        stringBuilder.append("closed=");
        stringBuilder.append(this.closed);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
