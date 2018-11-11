package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.r;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.layer.a;

public class ShapeTrimPath implements b {
    private final Type lo;
    private final String name;
    private final b ne;
    private final b nn;
    private final b np;

    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown trim path type ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public ShapeTrimPath(String str, Type type, b bVar, b bVar2, b bVar3) {
        this.name = str;
        this.lo = type;
        this.nn = bVar;
        this.np = bVar2;
        this.ne = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dy() {
        return this.lo;
    }

    public b eI() {
        return this.np;
    }

    public b eJ() {
        return this.nn;
    }

    public b eC() {
        return this.ne;
    }

    public com.airbnb.lottie.a.a.b a(h hVar, a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trim Path: {start: ");
        stringBuilder.append(this.nn);
        stringBuilder.append(", end: ");
        stringBuilder.append(this.np);
        stringBuilder.append(", offset: ");
        stringBuilder.append(this.ne);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
