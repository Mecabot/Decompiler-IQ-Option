package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.model.layer.a;

/* compiled from: AnimatableTransform */
public class l implements b {
    @Nullable
    private final b mA;
    @Nullable
    private final b mB;
    private final e mv;
    private final m<PointF, PointF> mw;
    private final g mx;
    private final b my;
    private final d mz;

    @Nullable
    public com.airbnb.lottie.a.a.b a(h hVar, a aVar) {
        return null;
    }

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.mv = eVar;
        this.mw = mVar;
        this.mx = gVar;
        this.my = bVar;
        this.mz = dVar;
        this.mA = bVar2;
        this.mB = bVar3;
    }

    public e dY() {
        return this.mv;
    }

    public m<PointF, PointF> dZ() {
        return this.mw;
    }

    public g ea() {
        return this.mx;
    }

    public b eb() {
        return this.my;
    }

    public d ec() {
        return this.mz;
    }

    @Nullable
    public b ed() {
        return this.mA;
    }

    @Nullable
    public b ee() {
        return this.mB;
    }

    public o ef() {
        return new o(this);
    }
}
