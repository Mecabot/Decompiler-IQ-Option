package com.jumio.commons.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.SparseArray;

public class ImageManager {
    private SparseArray<Bitmap> mBitmaps = new SparseArray();

    public boolean storeBitmap(int i, Bitmap bitmap) {
        if (hasBitmap(i)) {
            return false;
        }
        if (i == -1 && bitmap == null) {
            return false;
        }
        this.mBitmaps.put(i, bitmap);
        return true;
    }

    public Bitmap storeBitmap(int i, Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        this.mBitmaps.put(i, createBitmap);
        return createBitmap;
    }

    public Bitmap getBitmap(int i) {
        return (Bitmap) this.mBitmaps.get(i);
    }

    public boolean hasBitmap(int i) {
        return getBitmap(i) != null;
    }

    public void deleteBitmap(int i) {
        if (getBitmap(i) != null) {
            getBitmap(i).recycle();
            this.mBitmaps.remove(i);
            System.gc();
        }
    }

    public void recycleBitmaps() {
        for (int i = 0; i < this.mBitmaps.size(); i++) {
            if (this.mBitmaps.valueAt(i) != null) {
                ((Bitmap) this.mBitmaps.valueAt(i)).recycle();
                this.mBitmaps.setValueAt(i, null);
            }
        }
        this.mBitmaps.clear();
        System.gc();
    }
}
