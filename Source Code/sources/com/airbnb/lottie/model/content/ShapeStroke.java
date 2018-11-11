package com.airbnb.lottie.model.content;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import java.util.List;

public class ShapeStroke implements b {
    private final b mN;
    private final LineCapType mO;
    private final LineJoinType mP;
    private final List<b> mQ;
    private final a mr;
    private final d mz;
    private final String name;
    @Nullable
    private final b ne;

    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Cap toPaintCap() {
            switch (this) {
                case Butt:
                    return Cap.BUTT;
                case Round:
                    return Cap.ROUND;
                default:
                    return Cap.SQUARE;
            }
        }
    }

    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Join toPaintJoin() {
            switch (this) {
                case Bevel:
                    return Join.BEVEL;
                case Miter:
                    return Join.MITER;
                case Round:
                    return Join.ROUND;
                default:
                    return null;
            }
        }
    }

    public ShapeStroke(String str, @Nullable b bVar, List<b> list, a aVar, d dVar, b bVar2, LineCapType lineCapType, LineJoinType lineJoinType) {
        this.name = str;
        this.ne = bVar;
        this.mQ = list;
        this.mr = aVar;
        this.mz = dVar;
        this.mN = bVar2;
        this.mO = lineCapType;
        this.mP = lineJoinType;
    }

    public com.airbnb.lottie.a.a.b a(h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new q(hVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public a eG() {
        return this.mr;
    }

    public d ec() {
        return this.mz;
    }

    public b em() {
        return this.mN;
    }

    public List<b> ep() {
        return this.mQ;
    }

    public b eq() {
        return this.ne;
    }

    public LineCapType en() {
        return this.mO;
    }

    public LineJoinType eo() {
        return this.mP;
    }
}
