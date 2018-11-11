package com.microblink.secured;

import android.graphics.RectF;
import com.microblink.hardware.orientation.Orientation;

/* compiled from: line */
public abstract class q implements m {
    protected long IlIllIlIIl;
    protected boolean dUD;
    protected boolean dUE;
    protected RectF dUF;
    protected Orientation dUG;
    protected long dUH;
    protected byte[] dWU;
    protected int dWV;
    protected int dWW;
    protected ad dWX;

    public final byte[] aPD() {
        return this.dWU;
    }

    public void dispose() {
        this.dWU = null;
        this.dWX = null;
        this.dUF = null;
        this.dUG = null;
    }

    public void aOJ() {
        if (this.dWX != null) {
            this.dWX.a(this);
        }
        this.dUF = null;
        this.dUG = null;
    }

    public long aOL() {
        return this.IlIllIlIIl;
    }

    public final long aOM() {
        return this.dUH;
    }
}
