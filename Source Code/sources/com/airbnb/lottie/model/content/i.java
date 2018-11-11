package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.f;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.d;

/* compiled from: ShapeFill */
public class i implements b {
    private final FillType mH;
    @Nullable
    private final a mr;
    @Nullable
    private final d mz;
    private final String name;
    private final boolean ni;

    public i(String str, boolean z, FillType fillType, @Nullable a aVar, @Nullable d dVar) {
        this.name = str;
        this.ni = z;
        this.mH = fillType;
        this.mr = aVar;
        this.mz = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public a eG() {
        return this.mr;
    }

    @Nullable
    public d ec() {
        return this.mz;
    }

    public FillType getFillType() {
        return this.mH;
    }

    public b a(h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new f(hVar, aVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeFill{color=, fillEnabled=");
        stringBuilder.append(this.ni);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
