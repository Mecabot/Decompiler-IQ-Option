package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.layer.a;

/* compiled from: Repeater */
public class g implements b {
    private final String name;
    private final b nd;
    private final b ne;
    private final l nf;

    public g(String str, b bVar, b bVar2, l lVar) {
        this.name = str;
        this.nd = bVar;
        this.ne = bVar2;
        this.nf = lVar;
    }

    public String getName() {
        return this.name;
    }

    public b eB() {
        return this.nd;
    }

    public b eC() {
        return this.ne;
    }

    public l eD() {
        return this.nf;
    }

    @Nullable
    public com.airbnb.lottie.a.a.b a(h hVar, a aVar) {
        return new o(hVar, aVar, this);
    }
}
