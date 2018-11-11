package com.microblink.secured;

/* compiled from: line */
public class x {
    protected final int dXA;
    private w[] dXB;
    private int dXC;

    public final synchronized void a(w wVar) {
        if (wVar != null) {
            wVar.aOJ();
            if (this.dXC < this.dXA) {
                this.dXC++;
                this.dXB[this.dXC] = wVar;
            }
        }
    }
}
