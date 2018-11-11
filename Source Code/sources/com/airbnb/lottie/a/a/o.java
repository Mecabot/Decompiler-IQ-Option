package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.e.c;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.g;
import com.airbnb.lottie.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent */
public class o implements d, i, j, l, a {
    private final h iS;
    private final Path kr = new Path();
    private final com.airbnb.lottie.model.layer.a ku;
    private final com.airbnb.lottie.a.b.a<Float, Float> li;
    private final com.airbnb.lottie.a.b.a<Float, Float> lj;
    private final com.airbnb.lottie.a.b.o lk;
    private c ll;
    private final Matrix matrix = new Matrix();
    private final String name;

    public o(h hVar, com.airbnb.lottie.model.layer.a aVar, g gVar) {
        this.iS = hVar;
        this.ku = aVar;
        this.name = gVar.getName();
        this.li = gVar.eB().dW();
        aVar.a(this.li);
        this.li.b(this);
        this.lj = gVar.eC().dW();
        aVar.a(this.lj);
        this.lj.b(this);
        this.lk = gVar.eD().ef();
        this.lk.a(aVar);
        this.lk.a((a) this);
    }

    public void a(ListIterator<b> listIterator) {
        if (this.ll == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            List arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.ll = new c(this.iS, this.ku, "Repeater", arrayList, null);
        }
    }

    public String getName() {
        return this.name;
    }

    public void a(List<b> list, List<b> list2) {
        this.ll.a((List) list, (List) list2);
    }

    public Path getPath() {
        Path path = this.ll.getPath();
        this.kr.reset();
        float floatValue = ((Float) this.li.getValue()).floatValue();
        float floatValue2 = ((Float) this.lj.getValue()).floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.lk.e(((float) i) + floatValue2));
            this.kr.addPath(path, this.matrix);
        }
        return this.kr;
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = ((Float) this.li.getValue()).floatValue();
        float floatValue2 = ((Float) this.lj.getValue()).floatValue();
        float floatValue3 = ((Float) this.lk.dN().getValue()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.lk.dO().getValue()).floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            float f = (float) i2;
            this.matrix.preConcat(this.lk.e(f + floatValue2));
            this.ll.a(canvas, this.matrix, (int) (((float) i) * e.lerp(floatValue3, floatValue4, f / floatValue)));
        }
    }

    public void a(RectF rectF, Matrix matrix) {
        this.ll.a(rectF, matrix);
    }

    public void dp() {
        this.iS.invalidateSelf();
    }

    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        e.a(eVar, i, list, eVar2, this);
    }

    public <T> void a(T t, @Nullable c<T> cVar) {
        if (!this.lk.b(t, cVar)) {
            if (t == q.jZ) {
                this.li.a(cVar);
            } else if (t == q.ka) {
                this.lj.a(cVar);
            }
        }
    }
}
