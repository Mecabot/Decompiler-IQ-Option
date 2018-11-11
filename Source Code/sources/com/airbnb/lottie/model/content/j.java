package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup */
public class j implements b {
    private final String name;
    private final List<b> nj;

    public j(String str, List<b> list) {
        this.name = str;
        this.nj = list;
    }

    public String getName() {
        return this.name;
    }

    public List<b> getItems() {
        return this.nj;
    }

    public b a(h hVar, a aVar) {
        return new c(hVar, aVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeGroup{name='");
        stringBuilder.append(this.name);
        stringBuilder.append("' Shapes: ");
        stringBuilder.append(Arrays.toString(this.nj.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
