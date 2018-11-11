package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.g;

/* compiled from: PathKeyframe */
public class h extends a<PointF> {
    @Nullable
    private Path kr;

    public h(g gVar, a<PointF> aVar) {
        super(gVar, aVar.oP, aVar.oQ, aVar.oR, aVar.jr, aVar.oS);
        Object obj = (this.oQ == null || this.oP == null || !((PointF) this.oP).equals(((PointF) this.oQ).x, ((PointF) this.oQ).y)) ? null : 1;
        if (this.oQ != null && obj == null) {
            this.kr = f.b((PointF) this.oP, (PointF) this.oQ, aVar.oV, aVar.oW);
        }
    }

    @Nullable
    Path getPath() {
        return this.kr;
    }
}
