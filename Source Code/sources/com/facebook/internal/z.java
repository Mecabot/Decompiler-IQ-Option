package com.facebook.internal;

import com.facebook.h;
import java.util.concurrent.Executor;

/* compiled from: WorkQueue */
public class z {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Object Fi;
    private b Fj;
    private final int Fk;
    private b Fl;
    private int Fm;
    private final Executor executor;

    /* compiled from: WorkQueue */
    public interface a {
    }

    /* compiled from: WorkQueue */
    private class b implements a {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Runnable Fp;
        private b Fq;
        private b Fr;
        private boolean Fs;

        static {
            Class cls = z.class;
        }

        b(Runnable runnable) {
            this.Fp = runnable;
        }

        Runnable getCallback() {
            return this.Fp;
        }

        void M(boolean z) {
            this.Fs = z;
        }

        b a(b this_, boolean z) {
            if (this_ == null) {
                this.Fr = this;
                this.Fq = this;
                this_ = this;
            } else {
                this.Fq = this_;
                this.Fr = this_.Fr;
                b bVar = this.Fq;
                this.Fr.Fq = this;
                bVar.Fr = this;
            }
            return z ? this : this_;
        }

        b c(b bVar) {
            if (bVar == this) {
                if (this.Fq == this) {
                    bVar = null;
                } else {
                    bVar = this.Fq;
                }
            }
            this.Fq.Fr = this.Fr;
            this.Fr.Fq = this.Fq;
            this.Fr = null;
            this.Fq = null;
            return bVar;
        }
    }

    public z() {
        this(8);
    }

    public z(int i) {
        this(i, h.getExecutor());
    }

    public z(int i, Executor executor) {
        this.Fi = new Object();
        this.Fl = null;
        this.Fm = 0;
        this.Fk = i;
        this.executor = executor;
    }

    public a h(Runnable runnable) {
        return a(runnable, true);
    }

    public a a(Runnable runnable, boolean z) {
        a bVar = new b(runnable);
        synchronized (this.Fi) {
            this.Fj = bVar.a(this.Fj, z);
        }
        mL();
        return bVar;
    }

    private void mL() {
        a(null);
    }

    private void a(b bVar) {
        synchronized (this.Fi) {
            if (bVar != null) {
                this.Fl = bVar.c(this.Fl);
                this.Fm--;
            }
            if (this.Fm < this.Fk) {
                bVar = this.Fj;
                if (bVar != null) {
                    this.Fj = bVar.c(this.Fj);
                    this.Fl = bVar.a(this.Fl, false);
                    this.Fm++;
                    bVar.M(true);
                }
            } else {
                bVar = null;
            }
        }
        if (bVar != null) {
            b(bVar);
        }
    }

    private void b(final b bVar) {
        this.executor.execute(new Runnable() {
            public void run() {
                try {
                    bVar.getCallback().run();
                } finally {
                    z.this.a(bVar);
                }
            }
        });
    }
}
