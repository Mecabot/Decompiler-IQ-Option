package com.jumio.commons.camera;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;

public class CameraUtils {
    public static final int FULL_SIZE = -1;
    private static IYuvConversion yuvConversion;

    public interface IYuvConversion {
        int yuvCutRotateScale2rgb(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2, int i7, int i8, int i9);
    }

    public static void setYuvConversion(IYuvConversion iYuvConversion) {
        yuvConversion = iYuvConversion;
    }

    public static int getImageRotation(PreviewProperties previewProperties) {
        int i = previewProperties.orientation / 90;
        if (previewProperties.frontFacing) {
            return (i == 1 || i == 3) ? (i + 2) % 4 : i;
        } else {
            return i;
        }
    }

    public static RectF surfaceToPreview(PreviewProperties previewProperties, Rect rect) {
        Matrix matrix = new Matrix();
        matrix.setScale(((float) previewProperties.preview.width) / ((float) previewProperties.scaledPreview.width), ((float) previewProperties.preview.height) / ((float) previewProperties.scaledPreview.height));
        float f = ((float) (previewProperties.scaledPreview.width - previewProperties.surface.width)) / 2.0f;
        float f2 = ((float) (previewProperties.scaledPreview.height - previewProperties.surface.height)) / 2.0f;
        RectF rectF = new RectF(rect);
        rectF.offset(f, f2);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        return rectF2;
    }

    public static RectF previewToSurface(PreviewProperties previewProperties, RectF rectF) {
        Matrix matrix = new Matrix();
        float f = ((float) previewProperties.scaledPreview.width) / ((float) previewProperties.preview.width);
        float f2 = ((float) previewProperties.scaledPreview.height) / ((float) previewProperties.preview.height);
        if (previewProperties.frontFacing) {
            matrix.setScale(f * -1.0f, f2);
            matrix.postTranslate((float) previewProperties.scaledPreview.width, 0.0f);
        } else {
            matrix.setScale(f, f2);
        }
        f = ((float) (previewProperties.scaledPreview.width - previewProperties.surface.width)) / 2.0f;
        float f3 = ((float) (previewProperties.scaledPreview.height - previewProperties.surface.height)) / 2.0f;
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-f, -f3);
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return rectF3;
    }

    public static Bitmap yuv2bitmap(byte[] bArr, boolean z, PreviewProperties previewProperties, Rect rect, int i) {
        Size size = new Size(-1, -1);
        bArr = yuv2rgb(bArr, z, previewProperties, rect, size, i);
        return bArr != null ? rgb2bitmap(bArr, size.width, size.height) : null;
    }

    public static Bitmap yuv2bitmap(byte[] bArr, boolean z, PreviewProperties previewProperties, Rect rect, float f) {
        Size size = new Size(-1, -1);
        bArr = yuv2rgb(bArr, z, previewProperties, rect, f, size);
        return bArr != null ? rgb2bitmap(bArr, size.width, size.height) : null;
    }

    public static Bitmap yuv2bitmap(byte[] bArr, boolean z, PreviewProperties previewProperties, int i, int i2, int i3, int i4, int i5, int i6) {
        bArr = yuv2rgb(bArr, z, previewProperties, i, i2, i3, i4, i5, i6);
        return bArr != null ? rgb2bitmap(bArr, i5, i6) : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A:{SKIP} */
    public static byte[] yuv2rgb(byte[] r12, boolean r13, com.jumio.commons.camera.PreviewProperties r14, android.graphics.Rect r15, float r16, com.jumio.commons.camera.Size r17) {
        /*
        r2 = r14;
        r4 = r17;
        if (r15 != 0) goto L_0x0007;
    L_0x0005:
        r0 = 0;
        return r0;
    L_0x0007:
        r5 = surfaceToPreview(r2, r15);
        r6 = r15.height();
        r6 = (float) r6;
        r3 = r15.width();
        r3 = (float) r3;
        r6 = r6 / r3;
        r3 = 2;
        if (r13 == 0) goto L_0x003f;
    L_0x0019:
        r7 = r5.left;
        r7 = (int) r7;
        r8 = r5.top;
        r8 = (int) r8;
        r9 = r5.width();
        r9 = (int) r9;
        r5 = r5.height();
        r5 = (int) r5;
        r6 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));
        if (r6 < 0) goto L_0x0036;
    L_0x002d:
        r6 = (float) r9;
        r6 = r6 * r16;
        r0 = (int) r6;
        r5 = r5 - r0;
        r5 = r5 / r3;
        r8 = r8 + r5;
    L_0x0034:
        r5 = r0;
        goto L_0x0065;
    L_0x0036:
        r6 = (float) r5;
        r6 = r6 / r16;
        r0 = (int) r6;
        r9 = r9 - r0;
        r9 = r9 / r3;
        r7 = r7 + r9;
    L_0x003d:
        r9 = r0;
        goto L_0x0065;
    L_0x003f:
        r7 = r5.left;
        r8 = (int) r7;
        r7 = r5.top;
        r7 = (int) r7;
        r9 = r5.width();
        r9 = (int) r9;
        r5 = r5.height();
        r5 = (int) r5;
        r6 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));
        if (r6 > 0) goto L_0x005c;
    L_0x0053:
        r6 = (float) r5;
        r6 = r6 / r16;
        r0 = (int) r6;
        r9 = r9 - r0;
        r9 = r9 / r3;
        r8 = r8 + r9;
        r9 = r5;
        goto L_0x0034;
    L_0x005c:
        r6 = (float) r9;
        r6 = r6 * r16;
        r0 = (int) r6;
        r5 = r5 - r0;
        r5 = r5 / r3;
        r7 = r7 + r5;
        r5 = r9;
        goto L_0x003d;
    L_0x0065:
        r0 = r4.width;
        r6 = -1;
        if (r0 != r6) goto L_0x0071;
    L_0x006a:
        if (r13 == 0) goto L_0x006e;
    L_0x006c:
        r0 = r9;
        goto L_0x006f;
    L_0x006e:
        r0 = r5;
    L_0x006f:
        r4.width = r0;
    L_0x0071:
        r0 = r4.height;
        if (r0 != r6) goto L_0x007c;
    L_0x0075:
        if (r13 == 0) goto L_0x0079;
    L_0x0077:
        r0 = r5;
        goto L_0x007a;
    L_0x0079:
        r0 = r9;
    L_0x007a:
        r4.height = r0;
    L_0x007c:
        r0 = r2.camera;
        r0 = r0.width;
        r6 = r2.camera;
        r6 = r6.height;
        r10 = r2.orientation;
        r10 = r10 / 90;
        r11 = r2.frontFacing;
        if (r11 != 0) goto L_0x0094;
    L_0x008c:
        if (r10 == r3) goto L_0x009d;
    L_0x008e:
        r11 = 4;
        if (r10 == r11) goto L_0x009d;
    L_0x0091:
        r11 = 3;
        if (r10 == r11) goto L_0x009d;
    L_0x0094:
        r11 = r2.frontFacing;
        if (r11 == 0) goto L_0x00a3;
    L_0x0098:
        r11 = 1;
        if (r10 == r11) goto L_0x009d;
    L_0x009b:
        if (r10 != r3) goto L_0x00a3;
    L_0x009d:
        r0 = r0 - r5;
        r0 = r0 - r8;
        r6 = r6 - r9;
        r6 = r6 - r7;
        r8 = r0;
        goto L_0x00a4;
    L_0x00a3:
        r6 = r7;
    L_0x00a4:
        r7 = r4.width;
        r10 = r4.height;
        r0 = r12;
        r1 = r13;
        r3 = r5;
        r4 = r9;
        r5 = r8;
        r8 = r10;
        r0 = yuv2rgb(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.CameraUtils.yuv2rgb(byte[], boolean, com.jumio.commons.camera.PreviewProperties, android.graphics.Rect, float, com.jumio.commons.camera.Size):byte[]");
    }

    public static byte[] yuv2rgb(byte[] bArr, boolean z, PreviewProperties previewProperties, Rect rect, Size size, int i) {
        int width;
        int height;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Size size2 = size;
        int i7 = i;
        RectF surfaceToPreview = surfaceToPreview(previewProperties, rect);
        int i8;
        int i9;
        if (z) {
            i8 = (int) surfaceToPreview.left;
            i9 = (int) surfaceToPreview.top;
            width = (int) surfaceToPreview.width();
            height = (int) surfaceToPreview.height();
            i2 = height;
            i3 = i8;
            i4 = i9;
            i5 = width;
        } else {
            i8 = (int) surfaceToPreview.left;
            i9 = (int) surfaceToPreview.top;
            width = (int) surfaceToPreview.width();
            height = (int) surfaceToPreview.height();
            i5 = height;
            i4 = i8;
            i3 = i9;
            i2 = width;
        }
        if (i7 == -1 || (width <= i7 && height <= i7)) {
            i7 = width;
        } else if (width > height) {
            height = (int) (((float) i7) * (((float) height) / ((float) width)));
        } else {
            height = i7;
            i7 = (int) (((float) i7) * (((float) width) / ((float) height)));
        }
        if (size2 != null) {
            if (size2.width == -1) {
                size2.width = i7;
            } else {
                i7 = size2.width;
            }
            if (size2.height == -1) {
                size2.height = height;
            } else {
                i6 = size2.height;
                return yuv2rgb(bArr, z, previewProperties, i2, i5, i4, i3, i7, i6);
            }
        }
        i6 = height;
        return yuv2rgb(bArr, z, previewProperties, i2, i5, i4, i3, i7, i6);
    }

    public static byte[] yuv2rgb(byte[] bArr, boolean z, PreviewProperties previewProperties, int i, int i2, int i3, int i4, int i5, int i6) {
        PreviewProperties previewProperties2 = previewProperties;
        int i7 = previewProperties2.camera.width;
        int i8 = previewProperties2.camera.height;
        int i9 = previewProperties2.orientation / 90;
        if (previewProperties2.frontFacing && (i9 == 1 || i9 == 3)) {
            i9 = (i9 + 2) % 4;
        }
        int i10 = i9;
        byte[] bArr2 = new byte[((i5 * i6) * 3)];
        int i11 = -1;
        if (yuvConversion != null) {
            i11 = yuvConversion.yuvCutRotateScale2rgb(bArr, i7, i8, i3, i4, i, i2, bArr2, i5, i6, i10);
        }
        return i11 != 0 ? null : bArr2;
    }

    public static Bitmap rgb2bitmap(byte[] bArr, int i, int i2) {
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

    public static Bitmap rgb2bitmap(byte[] bArr, int i, int i2, int i3) {
        Bitmap rgb2bitmap = rgb2bitmap(bArr, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(rgb2bitmap.getWidth(), rgb2bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, rgb2bitmap.getWidth(), rgb2bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = (float) i3;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(rgb2bitmap, rect, rect, paint);
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001d A:{SYNTHETIC, Splitter: B:14:0x001d} */
    public static void saveBitmap(android.graphics.Bitmap r2, java.io.File r3, android.graphics.Bitmap.CompressFormat r4, int r5) {
        /*
        r0 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ all -> 0x001a }
        r1.<init>(r3);	 Catch:{ all -> 0x001a }
        r2.compress(r4, r5, r1);	 Catch:{ all -> 0x0017 }
        r1.flush();	 Catch:{ all -> 0x0017 }
        if (r1 == 0) goto L_0x0016;
    L_0x000e:
        r1.close();	 Catch:{ IOException -> 0x0012 }
        goto L_0x0016;
    L_0x0012:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x0016:
        return;
    L_0x0017:
        r2 = move-exception;
        r0 = r1;
        goto L_0x001b;
    L_0x001a:
        r2 = move-exception;
    L_0x001b:
        if (r0 == 0) goto L_0x0025;
    L_0x001d:
        r0.close();	 Catch:{ IOException -> 0x0021 }
        goto L_0x0025;
    L_0x0021:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x0025:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.CameraUtils.saveBitmap(android.graphics.Bitmap, java.io.File, android.graphics.Bitmap$CompressFormat, int):void");
    }
}
