package com.facebook;

import android.os.Handler;
import com.facebook.i.b;
import com.facebook.i.e;

/* compiled from: RequestProgress */
class t {
    private final long threshold = h.jb();
    private long yM;
    private long yN;
    private long yQ;
    private final i yo;
    private final Handler yv;

    t(Handler handler, i iVar) {
        this.yo = iVar;
        this.yv = handler;
    }

    void s(long j) {
        this.yQ += j;
        if (this.yQ >= this.yM + this.threshold || this.yQ >= this.yN) {
            jU();
        }
    }

    void t(long j) {
        this.yN += j;
    }

    void jU() {
        if (this.yQ > this.yM) {
            b jp = this.yo.jp();
            if (this.yN > 0 && (jp instanceof e)) {
                final long j = this.yQ;
                final long j2 = this.yN;
                final e eVar = (e) jp;
                if (this.yv == null) {
                    eVar.c(j, j2);
                } else {
                    this.yv.post(new Runnable() {
                        public void run() {
                            eVar.c(j, j2);
                        }
                    });
                }
                this.yM = this.yQ;
            }
        }
    }
}
