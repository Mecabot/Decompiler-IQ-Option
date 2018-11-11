package com.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.airbnb.lottie.e.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation */
public abstract class a<K, A> {
    private float jg = 0.0f;
    final List<a> ln = new ArrayList();
    private boolean ls = false;
    private final List<? extends com.airbnb.lottie.e.a<K>> lt;
    @Nullable
    protected c<A> lu;
    @Nullable
    private com.airbnb.lottie.e.a<K> lv;

    /* compiled from: BaseKeyframeAnimation */
    public interface a {
        void dp();
    }

    abstract A a(com.airbnb.lottie.e.a<K> aVar, float f);

    a(List<? extends com.airbnb.lottie.e.a<K>> list) {
        this.lt = list;
    }

    public void dC() {
        this.ls = true;
    }

    public void b(a aVar) {
        this.ln.add(aVar);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < dG()) {
            f = dG();
        } else if (f > dH()) {
            f = dH();
        }
        if (f != this.jg) {
            this.jg = f;
            notifyListeners();
        }
    }

    public void notifyListeners() {
        for (int i = 0; i < this.ln.size(); i++) {
            ((a) this.ln.get(i)).dp();
        }
    }

    private com.airbnb.lottie.e.a<K> dD() {
        if (this.lv != null && this.lv.j(this.jg)) {
            return this.lv;
        }
        com.airbnb.lottie.e.a<K> aVar = (com.airbnb.lottie.e.a) this.lt.get(this.lt.size() - 1);
        if (this.jg < aVar.eQ()) {
            for (int size = this.lt.size() - 1; size >= 0; size--) {
                aVar = (com.airbnb.lottie.e.a) this.lt.get(size);
                if (aVar.j(this.jg)) {
                    break;
                }
            }
        }
        this.lv = aVar;
        return aVar;
    }

    float dE() {
        if (this.ls) {
            return 0.0f;
        }
        com.airbnb.lottie.e.a dD = dD();
        if (dD.isStatic()) {
            return 0.0f;
        }
        return (this.jg - dD.eQ()) / (dD.dH() - dD.eQ());
    }

    private float dF() {
        com.airbnb.lottie.e.a dD = dD();
        if (dD.isStatic()) {
            return 0.0f;
        }
        return dD.oR.getInterpolation(dE());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float dG() {
        return this.lt.isEmpty() ? 0.0f : ((com.airbnb.lottie.e.a) this.lt.get(0)).eQ();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    float dH() {
        return this.lt.isEmpty() ? 1.0f : ((com.airbnb.lottie.e.a) this.lt.get(this.lt.size() - 1)).dH();
    }

    public A getValue() {
        return a(dD(), dF());
    }

    public float getProgress() {
        return this.jg;
    }

    public void a(@Nullable c<A> cVar) {
        if (this.lu != null) {
            this.lu.b(null);
        }
        this.lu = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
