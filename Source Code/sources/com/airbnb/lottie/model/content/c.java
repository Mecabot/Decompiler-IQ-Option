package com.airbnb.lottie.model.content;

import com.airbnb.lottie.d.b;
import com.airbnb.lottie.d.e;

/* compiled from: GradientColor */
public class c {
    private final float[] mE;
    private final int[] mF;

    public c(float[] fArr, int[] iArr) {
        this.mE = fArr;
        this.mF = iArr;
    }

    public float[] getPositions() {
        return this.mE;
    }

    public int[] getColors() {
        return this.mF;
    }

    public int getSize() {
        return this.mF.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.mF.length != cVar2.mF.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot interpolate between gradients. Lengths vary (");
            stringBuilder.append(cVar.mF.length);
            stringBuilder.append(" vs ");
            stringBuilder.append(cVar2.mF.length);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        for (int i = 0; i < cVar.mF.length; i++) {
            this.mE[i] = e.lerp(cVar.mE[i], cVar2.mE[i], f);
            this.mF[i] = b.a(f, cVar.mF[i], cVar2.mF[i]);
        }
    }
}
