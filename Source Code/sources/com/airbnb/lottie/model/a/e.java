package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.i;
import com.airbnb.lottie.a.b.j;
import com.airbnb.lottie.e.a;
import java.util.Collections;
import java.util.List;

/* compiled from: AnimatablePathValue */
public class e implements m<PointF, PointF> {
    private final List<a<PointF>> lt;

    public e() {
        this.lt = Collections.singletonList(new a(new PointF(0.0f, 0.0f)));
    }

    public e(List<a<PointF>> list) {
        this.lt = list;
    }

    public com.airbnb.lottie.a.b.a<PointF, PointF> dW() {
        if (((a) this.lt.get(0)).isStatic()) {
            return new j(this.lt);
        }
        return new i(this.lt);
    }
}
