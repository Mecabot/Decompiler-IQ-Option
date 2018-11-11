package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent */
public class r implements b, a {
    private final List<a> ln = new ArrayList();
    private final Type lo;
    private final com.airbnb.lottie.a.b.a<?, Float> lp;
    private final com.airbnb.lottie.a.b.a<?, Float> lq;
    private final com.airbnb.lottie.a.b.a<?, Float> lr;
    private final String name;

    public void a(List<b> list, List<b> list2) {
    }

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.lo = shapeTrimPath.dy();
        this.lp = shapeTrimPath.eJ().dW();
        this.lq = shapeTrimPath.eI().dW();
        this.lr = shapeTrimPath.eC().dW();
        aVar.a(this.lp);
        aVar.a(this.lq);
        aVar.a(this.lr);
        this.lp.b(this);
        this.lq.b(this);
        this.lr.b(this);
    }

    public void dp() {
        for (int i = 0; i < this.ln.size(); i++) {
            ((a) this.ln.get(i)).dp();
        }
    }

    public String getName() {
        return this.name;
    }

    void a(a aVar) {
        this.ln.add(aVar);
    }

    Type dy() {
        return this.lo;
    }

    public com.airbnb.lottie.a.b.a<?, Float> dz() {
        return this.lp;
    }

    public com.airbnb.lottie.a.b.a<?, Float> dA() {
        return this.lq;
    }

    public com.airbnb.lottie.a.b.a<?, Float> dB() {
        return this.lr;
    }
}
