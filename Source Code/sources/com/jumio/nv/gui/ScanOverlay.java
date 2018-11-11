package com.jumio.nv.gui;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class ScanOverlay {
    public Rect bounds;
    public Bitmap image;

    public ScanOverlay(Bitmap bitmap) {
        this.image = bitmap;
    }
}
