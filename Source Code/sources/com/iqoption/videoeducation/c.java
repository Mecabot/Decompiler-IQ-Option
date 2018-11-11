package com.iqoption.videoeducation;

import com.iqoption.util.p;

/* compiled from: SearchDebouncer */
public class c extends p {
    private final a dyD;
    private CharSequence dyE;
    private final p dyF = new p(new Runnable() {
        public void run() {
            c.this.dyD.p(c.this.dyE);
        }
    });

    /* compiled from: SearchDebouncer */
    public interface a {
        void p(CharSequence charSequence);
    }

    public c(a aVar) {
        super(null);
        this.dyD = aVar;
    }

    public void cg(long j) {
        this.dyF.cg(j);
    }

    public void a(CharSequence charSequence, long j) {
        this.dyE = charSequence;
        cg(j);
    }
}
