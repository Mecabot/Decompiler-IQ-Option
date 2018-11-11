package com.jumio.commons.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.support.v4.view.ViewCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageUtil {
    public static Bitmap rgbToBitmap(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        int[] iArr = new int[i];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = ((i3 * i) * 3) + (i4 * 3);
                iArr[i4] = ((((bArr[i5] & 255) << 16) + ViewCompat.MEASURED_STATE_MASK) + ((bArr[i5 + 1] & 255) << 8)) + (bArr[i5 + 2] & 255);
            }
            createBitmap.setPixels(iArr, 0, i, 0, i3, i, 1);
        }
        return createBitmap;
    }

    public static byte[] rgbToFormat(byte[] bArr, int i, int i2, CompressFormat compressFormat, int i3) {
        Bitmap rgbToBitmap = rgbToBitmap(bArr, i, i2);
        byte[] bitmapToFormat = bitmapToFormat(rgbToBitmap, compressFormat, i3);
        MutableBitmap.delete(rgbToBitmap);
        return bitmapToFormat;
    }

    public static byte[] bitmapToFormat(Bitmap bitmap, CompressFormat compressFormat, int i) {
        byte[] toByteArray;
        IOException e;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(compressFormat, i, byteArrayOutputStream);
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            toByteArray = null;
            e.printStackTrace();
            return toByteArray;
        }
        return toByteArray;
    }

    public static byte[] bitmap2rgb(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        i = 0;
        int i2 = 0;
        while (i < height) {
            int i3 = i2;
            for (i2 = 0; i2 < width; i2++) {
                int i4 = (i * width) + i2;
                bArr[i3] = (byte) ((iArr[i4] >> 16) & 255);
                bArr[i3 + 1] = (byte) ((iArr[i4] >> 8) & 255);
                bArr[i3 + 2] = (byte) (iArr[i4] & 255);
                i3 += 3;
            }
            i++;
            i2 = i3;
        }
        return bArr;
    }

    public static int calculateInSampleSize(Options options, int i, int i2) {
        int i3 = 1;
        if (options == null) {
            return 1;
        }
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i2 || i5 > i) {
            i4 /= 2;
            i5 /= 2;
            while (i4 / i3 > i2 && i5 / i3 > i) {
                i3 *= 2;
            }
        }
        return i3;
    }

    public static Bitmap loadResized(String str, int i, int i2, int i3) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        i2 = (int) Math.ceil((double) (((float) options.outHeight) / ((float) i2)));
        i = (int) Math.ceil((double) (((float) options.outWidth) / ((float) i)));
        if (i2 > 1 || i > 1) {
            if (i2 > i) {
                options.inSampleSize = i2;
            } else {
                options.inSampleSize = i;
            }
        }
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (i3 == 0) {
            return decodeFile;
        }
        Bitmap rotate = rotate(decodeFile, i3);
        if (rotate != decodeFile) {
            decodeFile.recycle();
        }
        return rotate;
    }

    public static Bitmap loadResized(Context context, int i, int i2, int i3) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        i3 = (int) Math.ceil((double) (((float) options.outHeight) / ((float) i3)));
        i2 = (int) Math.ceil((double) (((float) options.outWidth) / ((float) i2)));
        if (i3 > 1 || i2 > 1) {
            if (i3 > i2) {
                options.inSampleSize = i3;
            } else {
                options.inSampleSize = i2;
            }
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(context.getResources(), i, options);
    }

    public static Bitmap rotate(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int i2;
        int i3;
        int width;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        if (i != 0) {
            if (i != 90) {
                if (i != 180) {
                    if (i != 270) {
                        i2 = 0;
                        i3 = 0;
                        return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
                    }
                }
            }
            i = bitmap.getHeight();
            width = bitmap.getWidth();
            i2 = i;
            i3 = width;
            return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
        }
        i = bitmap.getWidth();
        width = bitmap.getHeight();
        i2 = i;
        i3 = width;
        return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
    }
}
