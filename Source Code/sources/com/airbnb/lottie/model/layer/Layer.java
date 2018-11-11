package com.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.b;
import java.util.List;
import java.util.Locale;

public class Layer {
    private final g ja;
    private final float jr;
    private final List<Mask> lz;
    private final List<b> mm;
    private final String nQ;
    private final long nR;
    private final LayerType nS;
    private final long nT;
    @Nullable
    private final String nU;
    private final int nV;
    private final int nW;
    private final int nX;
    private final float nY;
    private final int nZ;
    private final l nf;
    private final int oa;
    @Nullable
    private final j ob;
    @Nullable
    private final k oc;
    @Nullable
    private final com.airbnb.lottie.model.a.b od;
    private final List<a<Float>> oe;
    private final MatteType of;

    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<b> list, g gVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.mm = list;
        this.ja = gVar;
        this.nQ = str;
        this.nR = j;
        this.nS = layerType;
        this.nT = j2;
        this.nU = str2;
        this.lz = list2;
        this.nf = lVar;
        this.nV = i;
        this.nW = i2;
        this.nX = i3;
        this.nY = f;
        this.jr = f2;
        this.nZ = i4;
        this.oa = i5;
        this.ob = jVar;
        this.oc = kVar;
        this.oe = list3;
        this.of = matteType;
        this.od = bVar;
    }

    g getComposition() {
        return this.ja;
    }

    float eP() {
        return this.nY;
    }

    float eQ() {
        return this.jr / this.ja.dg();
    }

    List<a<Float>> eR() {
        return this.oe;
    }

    public long getId() {
        return this.nR;
    }

    String getName() {
        return this.nQ;
    }

    @Nullable
    String eS() {
        return this.nU;
    }

    int eT() {
        return this.nZ;
    }

    int eU() {
        return this.oa;
    }

    List<Mask> dI() {
        return this.lz;
    }

    public LayerType eV() {
        return this.nS;
    }

    MatteType eW() {
        return this.of;
    }

    long eX() {
        return this.nT;
    }

    List<b> dT() {
        return this.mm;
    }

    l eD() {
        return this.nf;
    }

    int getSolidColor() {
        return this.nX;
    }

    int eY() {
        return this.nW;
    }

    int eZ() {
        return this.nV;
    }

    @Nullable
    j fa() {
        return this.ob;
    }

    @Nullable
    k fb() {
        return this.oc;
    }

    @Nullable
    com.airbnb.lottie.model.a.b fc() {
        return this.od;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(getName());
        stringBuilder.append("\n");
        Layer f = this.ja.f(eX());
        if (f != null) {
            stringBuilder.append("\t\tParents: ");
            stringBuilder.append(f.getName());
            f = this.ja.f(f.eX());
            while (f != null) {
                stringBuilder.append("->");
                stringBuilder.append(f.getName());
                f = this.ja.f(f.eX());
            }
            stringBuilder.append(str);
            stringBuilder.append("\n");
        }
        if (!dI().isEmpty()) {
            stringBuilder.append(str);
            stringBuilder.append("\tMasks: ");
            stringBuilder.append(dI().size());
            stringBuilder.append("\n");
        }
        if (!(eZ() == 0 || eY() == 0)) {
            stringBuilder.append(str);
            stringBuilder.append("\tBackground: ");
            stringBuilder.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(eZ()), Integer.valueOf(eY()), Integer.valueOf(getSolidColor())}));
        }
        if (!this.mm.isEmpty()) {
            stringBuilder.append(str);
            stringBuilder.append("\tShapes:\n");
            for (Object next : this.mm) {
                stringBuilder.append(str);
                stringBuilder.append("\t\t");
                stringBuilder.append(next);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
