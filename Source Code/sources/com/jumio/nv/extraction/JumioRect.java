package com.jumio.nv.extraction;

import java.io.Serializable;

public class JumioRect implements Serializable {
    public int bottom;
    public int left;
    public int right;
    public int top;

    public JumioRect(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public final int height() {
        return this.bottom - this.top;
    }

    public final int width() {
        return this.right - this.left;
    }
}
