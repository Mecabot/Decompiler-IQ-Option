package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProgressNoopOutputStream */
class q extends OutputStream implements s {
    private final Map<i, t> yH = new HashMap();
    private i yI;
    private t yJ;
    private int yK;
    private final Handler yv;

    q(Handler handler) {
        this.yv = handler;
    }

    public void d(i iVar) {
        this.yI = iVar;
        this.yJ = iVar != null ? (t) this.yH.get(iVar) : null;
    }

    int jR() {
        return this.yK;
    }

    Map<i, t> jS() {
        return this.yH;
    }

    void s(long j) {
        if (this.yJ == null) {
            this.yJ = new t(this.yv, this.yI);
            this.yH.put(this.yI, this.yJ);
        }
        this.yJ.t(j);
        this.yK = (int) (((long) this.yK) + j);
    }

    public void write(byte[] bArr) {
        s((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        s((long) i2);
    }

    public void write(int i) {
        s(1);
    }
}
