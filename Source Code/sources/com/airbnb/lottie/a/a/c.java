package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.model.e;
import com.airbnb.lottie.model.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup */
public class c implements d, l, a, f {
    private final h iS;
    private final List<b> kF;
    @Nullable
    private List<l> kG;
    @Nullable
    private o kH;
    private final Path kr;
    private final RectF kt;
    private final Matrix matrix;
    private final String name;

    private static List<b> a(h hVar, com.airbnb.lottie.model.layer.a aVar, List<b> list) {
        List<b> arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            b a = ((b) list.get(i)).a(hVar, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    @Nullable
    static l o(List<b> list) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            if (bVar instanceof l) {
                return (l) bVar;
            }
        }
        return null;
    }

    public c(h hVar, com.airbnb.lottie.model.layer.a aVar, j jVar) {
        this(hVar, aVar, jVar.getName(), a(hVar, aVar, jVar.getItems()), o(jVar.getItems()));
    }

    c(h hVar, com.airbnb.lottie.model.layer.a aVar, String str, List<b> list, @Nullable l lVar) {
        int size;
        this.matrix = new Matrix();
        this.kr = new Path();
        this.kt = new RectF();
        this.name = str;
        this.iS = hVar;
        this.kF = list;
        if (lVar != null) {
            this.kH = lVar.ef();
            this.kH.a(aVar);
            this.kH.a((a) this);
        }
        List arrayList = new ArrayList();
        for (size = list.size() - 1; size >= 0; size--) {
            b bVar = (b) list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (size = arrayList.size() - 1; size >= 0; size--) {
            ((i) arrayList.get(size)).a(list.listIterator(list.size()));
        }
    }

    public void dp() {
        this.iS.invalidateSelf();
    }

    public String getName() {
        return this.name;
    }

    public void a(List<b> list, List<b> list2) {
        List arrayList = new ArrayList(list.size() + this.kF.size());
        arrayList.addAll(list);
        for (int size = this.kF.size() - 1; size >= 0; size--) {
            b bVar = (b) this.kF.get(size);
            bVar.a(arrayList, this.kF.subList(0, size));
            arrayList.add(bVar);
        }
    }

    List<l> dq() {
        if (this.kG == null) {
            this.kG = new ArrayList();
            for (int i = 0; i < this.kF.size(); i++) {
                b bVar = (b) this.kF.get(i);
                if (bVar instanceof l) {
                    this.kG.add((l) bVar);
                }
            }
        }
        return this.kG;
    }

    Matrix dr() {
        if (this.kH != null) {
            return this.kH.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    public Path getPath() {
        this.matrix.reset();
        if (this.kH != null) {
            this.matrix.set(this.kH.getMatrix());
        }
        this.kr.reset();
        for (int size = this.kF.size() - 1; size >= 0; size--) {
            b bVar = (b) this.kF.get(size);
            if (bVar instanceof l) {
                this.kr.addPath(((l) bVar).getPath(), this.matrix);
            }
        }
        return this.kr;
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        this.matrix.set(matrix);
        if (this.kH != null) {
            this.matrix.preConcat(this.kH.getMatrix());
            i = (int) ((((((float) ((Integer) this.kH.dM().getValue()).intValue()) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
        }
        for (int size = this.kF.size() - 1; size >= 0; size--) {
            Object obj = this.kF.get(size);
            if (obj instanceof d) {
                ((d) obj).a(canvas, this.matrix, i);
            }
        }
    }

    public void a(RectF rectF, Matrix matrix) {
        this.matrix.set(matrix);
        if (this.kH != null) {
            this.matrix.preConcat(this.kH.getMatrix());
        }
        this.kt.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.kF.size() - 1; size >= 0; size--) {
            b bVar = (b) this.kF.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.kt, this.matrix);
                if (rectF.isEmpty()) {
                    rectF.set(this.kt);
                } else {
                    rectF.set(Math.min(rectF.left, this.kt.left), Math.min(rectF.top, this.kt.top), Math.max(rectF.right, this.kt.right), Math.max(rectF.bottom, this.kt.bottom));
                }
            }
        }
    }

    public void a(e eVar, int i, List<e> list, e eVar2) {
        if (eVar.f(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.af(getName());
                if (eVar.h(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.i(getName(), i)) {
                i += eVar.g(getName(), i);
                for (int i2 = 0; i2 < this.kF.size(); i2++) {
                    b bVar = (b) this.kF.get(i2);
                    if (bVar instanceof f) {
                        ((f) bVar).a(eVar, i, list, eVar2);
                    }
                }
            }
        }
    }

    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (this.kH != null) {
            this.kH.b(t, cVar);
        }
    }
}
