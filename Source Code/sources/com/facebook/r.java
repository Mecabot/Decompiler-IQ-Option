package com.facebook;

import android.os.Handler;
import com.facebook.k.a;
import com.facebook.k.b;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Map;

/* compiled from: ProgressOutputStream */
class r extends FilterOutputStream implements s {
    private final long threshold = h.jb();
    private final Map<i, t> yH;
    private t yJ;
    private long yL;
    private long yM;
    private long yN;
    private final k yt;

    r(OutputStream outputStream, k kVar, Map<i, t> map, long j) {
        super(outputStream);
        this.yt = kVar;
        this.yH = map;
        this.yN = j;
    }

    private void s(long j) {
        if (this.yJ != null) {
            this.yJ.s(j);
        }
        this.yL += j;
        if (this.yL >= this.yM + this.threshold || this.yL >= this.yN) {
            jT();
        }
    }

    private void jT() {
        if (this.yL > this.yM) {
            for (a aVar : this.yt.getCallbacks()) {
                if (aVar instanceof b) {
                    Handler jD = this.yt.jD();
                    final b bVar = (b) aVar;
                    if (jD == null) {
                        bVar.a(this.yt, this.yL, this.yN);
                    } else {
                        jD.post(new Runnable() {
                            public void run() {
                                bVar.a(r.this.yt, r.this.yL, r.this.yN);
                            }
                        });
                    }
                }
            }
            this.yM = this.yL;
        }
    }

    public void d(i iVar) {
        this.yJ = iVar != null ? (t) this.yH.get(iVar) : null;
    }

    public void write(byte[] bArr) {
        this.out.write(bArr);
        s((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        s((long) i2);
    }

    public void write(int i) {
        this.out.write(i);
        s(1);
    }

    public void close() {
        super.close();
        for (t jU : this.yH.values()) {
            jU.jU();
        }
        jT();
    }
}
