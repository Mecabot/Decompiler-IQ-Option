package com.rd;

import android.support.annotation.Nullable;

/* compiled from: IndicatorManager */
public class a implements com.rd.animation.a.b.a {
    private com.rd.draw.a ehe = new com.rd.draw.a();
    private com.rd.animation.a ehf = new com.rd.animation.a(this.ehe.aSn(), this);
    private a ehg;

    /* compiled from: IndicatorManager */
    interface a {
        void aSp();
    }

    a(@Nullable a aVar) {
        this.ehg = aVar;
    }

    public com.rd.animation.a aSm() {
        return this.ehf;
    }

    public com.rd.draw.data.a aSn() {
        return this.ehe.aSn();
    }

    public com.rd.draw.a aSo() {
        return this.ehe;
    }

    public void a(@Nullable com.rd.animation.b.a aVar) {
        this.ehe.b(aVar);
        if (this.ehg != null) {
            this.ehg.aSp();
        }
    }
}
