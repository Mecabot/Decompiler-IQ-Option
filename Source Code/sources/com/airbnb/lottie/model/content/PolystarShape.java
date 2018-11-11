package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.layer.a;

public class PolystarShape implements b {
    private final Type kZ;
    private final b mV;
    private final b mW;
    private final b mZ;
    private final m<PointF, PointF> mw;
    private final b my;
    private final b na;
    private final String name;
    private final b nb;

    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        private Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6) {
        this.name = str;
        this.kZ = type;
        this.mV = bVar;
        this.mw = mVar;
        this.my = bVar2;
        this.mW = bVar3;
        this.mZ = bVar4;
        this.na = bVar5;
        this.nb = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type eu() {
        return this.kZ;
    }

    public b ev() {
        return this.mV;
    }

    public m<PointF, PointF> dZ() {
        return this.mw;
    }

    public b eb() {
        return this.my;
    }

    public b ew() {
        return this.mW;
    }

    public b ex() {
        return this.mZ;
    }

    public b ey() {
        return this.na;
    }

    public b ez() {
        return this.nb;
    }

    public com.airbnb.lottie.a.a.b a(h hVar, a aVar) {
        return new com.airbnb.lottie.a.a.m(hVar, aVar, this);
    }
}
