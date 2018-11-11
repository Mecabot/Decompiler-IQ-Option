package com.google.zxing.a.a;

import com.google.zxing.common.a;

/* compiled from: Token */
abstract class g {
    static final g abr = new e(null, 0, 0);
    private final g abs;

    abstract void a(a aVar, byte[] bArr);

    g(g gVar) {
        this.abs = gVar;
    }

    final g yy() {
        return this.abs;
    }

    final g I(int i, int i2) {
        return new e(this, i, i2);
    }

    final g J(int i, int i2) {
        return new b(this, i, i2);
    }
}
