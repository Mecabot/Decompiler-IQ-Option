package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.content.ShapeStroke.LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke.LineJoinType;
import com.airbnb.lottie.model.layer.a;
import java.util.List;

/* compiled from: GradientStroke */
public class e implements b {
    private final GradientType mG;
    private final c mI;
    private final f mJ;
    private final f mK;
    private final b mN;
    private final LineCapType mO;
    private final LineJoinType mP;
    private final List<b> mQ;
    @Nullable
    private final b mR;
    private final d mz;
    private final String name;

    public e(String str, GradientType gradientType, c cVar, d dVar, f fVar, f fVar2, b bVar, LineCapType lineCapType, LineJoinType lineJoinType, List<b> list, @Nullable b bVar2) {
        this.name = str;
        this.mG = gradientType;
        this.mI = cVar;
        this.mz = dVar;
        this.mJ = fVar;
        this.mK = fVar2;
        this.mN = bVar;
        this.mO = lineCapType;
        this.mP = lineJoinType;
        this.mQ = list;
        this.mR = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType ei() {
        return this.mG;
    }

    public c ej() {
        return this.mI;
    }

    public d ec() {
        return this.mz;
    }

    public f ek() {
        return this.mJ;
    }

    public f el() {
        return this.mK;
    }

    public b em() {
        return this.mN;
    }

    public LineCapType en() {
        return this.mO;
    }

    public LineJoinType eo() {
        return this.mP;
    }

    public List<b> ep() {
        return this.mQ;
    }

    @Nullable
    public b eq() {
        return this.mR;
    }

    public com.airbnb.lottie.a.a.b a(h hVar, a aVar) {
        return new com.airbnb.lottie.a.a.h(hVar, aVar, this);
    }
}
