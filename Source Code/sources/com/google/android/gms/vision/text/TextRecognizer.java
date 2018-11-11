package com.google.android.gms.vision.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.gms.internal.zzdld;
import com.google.android.gms.internal.zzdll;
import com.google.android.gms.internal.zzdln;
import com.google.android.gms.internal.zzdlr;
import com.google.android.gms.internal.zzdls;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame.Metadata;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class TextRecognizer extends Detector<TextBlock> {
    private final zzdlr zzlid;

    public static class Builder {
        private Context mContext;
        private zzdls zzlie = new zzdls();

        public Builder(Context context) {
            this.mContext = context;
        }

        public TextRecognizer build() {
            return new TextRecognizer(new zzdlr(this.mContext, this.zzlie));
        }
    }

    private TextRecognizer() {
        throw new IllegalStateException("Default constructor called");
    }

    private TextRecognizer(zzdlr zzdlr) {
        this.zzlid = zzdlr;
    }

    private static SparseArray<TextBlock> zza(zzdll[] zzdllArr) {
        SparseArray sparseArray = new SparseArray();
        for (zzdll zzdll : zzdllArr) {
            SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzdll.zzlio);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sparseArray.append(zzdll.zzlio, sparseArray2);
            }
            sparseArray2.append(zzdll.zzlip, zzdll);
        }
        SparseArray<TextBlock> sparseArray3 = new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray3.append(sparseArray.keyAt(i), new TextBlock((SparseArray) sparseArray.valueAt(i)));
        }
        return sparseArray3;
    }

    public final SparseArray<TextBlock> detect(Frame frame) {
        zzdln zzdln = new zzdln(new Rect());
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        Bitmap bitmap;
        int i;
        int i2;
        int i3;
        zzdld zzc = zzdld.zzc(frame);
        if (frame.getBitmap() != null) {
            bitmap = frame.getBitmap();
        } else {
            byte[] array;
            Metadata metadata = frame.getMetadata();
            ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
            int format = metadata.getFormat();
            i = zzc.width;
            i2 = zzc.height;
            if (grayscaleImageData.hasArray() && grayscaleImageData.arrayOffset() == 0) {
                array = grayscaleImageData.array();
            } else {
                byte[] bArr = new byte[grayscaleImageData.capacity()];
                grayscaleImageData.get(bArr);
                array = bArr;
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new YuvImage(array, format, i, i2, null).compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            bitmap = BitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
        }
        Bitmap bitmap2 = bitmap;
        i = bitmap2.getWidth();
        i2 = bitmap2.getHeight();
        if (zzc.rotation != 0) {
            Matrix matrix = new Matrix();
            switch (zzc.rotation) {
                case 0:
                    i3 = 0;
                    break;
                case 1:
                    i3 = 90;
                    break;
                case 2:
                    i3 = 180;
                    break;
                case 3:
                    i3 = 270;
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported rotation degree.");
            }
            matrix.postRotate((float) i3);
            bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, i, i2, matrix, false);
        }
        if (zzc.rotation == 1 || zzc.rotation == 3) {
            zzc.width = i2;
            zzc.height = i;
        }
        if (!zzdln.zzliq.isEmpty()) {
            Rect rect;
            Rect rect2 = zzdln.zzliq;
            i3 = frame.getMetadata().getWidth();
            int height = frame.getMetadata().getHeight();
            switch (zzc.rotation) {
                case 1:
                    rect = new Rect(height - rect2.bottom, rect2.left, height - rect2.top, rect2.right);
                    break;
                case 2:
                    rect = new Rect(i3 - rect2.right, height - rect2.bottom, i3 - rect2.left, height - rect2.top);
                    break;
                case 3:
                    rect = new Rect(rect2.top, i3 - rect2.right, rect2.bottom, i3 - rect2.left);
                    break;
                default:
                    rect = rect2;
                    break;
            }
            zzdln.zzliq.set(rect);
        }
        zzc.rotation = 0;
        return zza(this.zzlid.zza(bitmap2, zzc, zzdln));
    }

    public final boolean isOperational() {
        return this.zzlid.isOperational();
    }

    public final void release() {
        super.release();
        this.zzlid.zzbln();
    }
}
