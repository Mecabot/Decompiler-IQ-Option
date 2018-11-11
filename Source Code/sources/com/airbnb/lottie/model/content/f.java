package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.layer.a;

/* compiled from: RectangleShape */
public class f implements b {
    private final com.airbnb.lottie.model.a.f mC;
    private final m<PointF, PointF> mw;
    private final String name;
    private final b nc;

    public f(String str, m<PointF, PointF> mVar, com.airbnb.lottie.model.a.f fVar, b bVar) {
        this.name = str;
        this.mw = mVar;
        this.mC = fVar;
        this.nc = bVar;
    }

    public String getName() {
        return this.name;
    }

    public b eA() {
        return this.nc;
    }

    public com.airbnb.lottie.model.a.f eg() {
        return this.mC;
    }

    public m<PointF, PointF> dZ() {
        return this.mw;
    }

    public com.airbnb.lottie.a.a.b a(h hVar, a aVar) {
        return new n(hVar, aVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RectangleShape{position=");
        stringBuilder.append(this.mw);
        stringBuilder.append(", size=");
        stringBuilder.append(this.mC);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
