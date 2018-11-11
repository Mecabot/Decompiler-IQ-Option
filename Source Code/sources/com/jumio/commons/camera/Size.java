package com.jumio.commons.camera;

import java.io.Serializable;

public class Size implements Serializable {
    public int height;
    public int width;

    public Size(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public Size copy() {
        return new Size(this.width, this.height);
    }
}
