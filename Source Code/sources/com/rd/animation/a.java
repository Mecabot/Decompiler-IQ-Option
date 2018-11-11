package com.rd.animation;

import android.support.annotation.NonNull;

/* compiled from: AnimationManager */
public class a {
    private com.rd.animation.a.a ehm;

    public a(@NonNull com.rd.draw.data.a aVar, @NonNull com.rd.animation.a.b.a aVar2) {
        this.ehm = new com.rd.animation.a.a(aVar, aVar2);
    }

    public void aSw() {
        if (this.ehm != null) {
            this.ehm.end();
            this.ehm.aSw();
        }
    }

    public void V(float f) {
        if (this.ehm != null) {
            this.ehm.V(f);
        }
    }

    public void end() {
        if (this.ehm != null) {
            this.ehm.end();
        }
    }
}
