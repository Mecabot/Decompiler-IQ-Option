package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.p;
import com.airbnb.lottie.model.a.h;
import com.airbnb.lottie.model.layer.a;

/* compiled from: ShapePath */
public class k implements b {
    private final int index;
    private final String name;
    private final h nk;

    public k(String str, int i, h hVar) {
        this.name = str;
        this.index = i;
        this.nk = hVar;
    }

    public String getName() {
        return this.name;
    }

    public h eH() {
        return this.nk;
    }

    public b a(com.airbnb.lottie.h hVar, a aVar) {
        return new p(hVar, aVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapePath{name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", index=");
        stringBuilder.append(this.index);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
