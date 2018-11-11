package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.e;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.a.m;

/* compiled from: CircleShape */
public class a implements b {
    private final f mC;
    private final boolean mD;
    private final m<PointF, PointF> mw;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, f fVar, boolean z) {
        this.name = str;
        this.mw = mVar;
        this.mC = fVar;
        this.mD = z;
    }

    public b a(h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new e(hVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> dZ() {
        return this.mw;
    }

    public f eg() {
        return this.mC;
    }

    public boolean eh() {
        return this.mD;
    }
}
