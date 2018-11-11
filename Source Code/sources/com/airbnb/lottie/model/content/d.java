package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.g;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.layer.a;

/* compiled from: GradientFill */
public class d implements b {
    private final GradientType mG;
    private final FillType mH;
    private final c mI;
    private final f mJ;
    private final f mK;
    @Nullable
    private final b mL;
    @Nullable
    private final b mM;
    private final com.airbnb.lottie.model.a.d mz;
    private final String name;

    public d(String str, GradientType gradientType, FillType fillType, c cVar, com.airbnb.lottie.model.a.d dVar, f fVar, f fVar2, b bVar, b bVar2) {
        this.mG = gradientType;
        this.mH = fillType;
        this.mI = cVar;
        this.mz = dVar;
        this.mJ = fVar;
        this.mK = fVar2;
        this.name = str;
        this.mL = bVar;
        this.mM = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType ei() {
        return this.mG;
    }

    public FillType getFillType() {
        return this.mH;
    }

    public c ej() {
        return this.mI;
    }

    public com.airbnb.lottie.model.a.d ec() {
        return this.mz;
    }

    public f ek() {
        return this.mJ;
    }

    public f el() {
        return this.mK;
    }

    public com.airbnb.lottie.a.a.b a(h hVar, a aVar) {
        return new g(hVar, aVar, this);
    }
}
