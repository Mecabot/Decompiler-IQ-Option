package com.microblink.image;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.microblink.geometry.c;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.secured.i;
import java.nio.ByteBuffer;

/* compiled from: line */
public class ImageBuilder {
    private static native long buildNativeImageFromCamera1Buffer(int i, int i2, byte[] bArr, int i3, float f, float f2, float f3, float f4);

    @TargetApi(21)
    private static native long buildNativeImageFromCamera2Image(int i, int i2, int i3, float f, float f2, float f3, float f4, ByteBuffer byteBuffer, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7, ByteBuffer byteBuffer3, int i8, int i9);

    static {
        i.aPx();
    }

    @Keep
    public static Image buildImageFromNativeContext(long j) {
        return new Image(j);
    }

    public static Image a(@NonNull byte[] bArr, int i, int i2, @NonNull Orientation orientation, @Nullable c cVar) {
        int bitsPerPixel = ((i * i2) * ImageFormat.getBitsPerPixel(17)) / 8;
        if (bArr.length != bitsPerPixel) {
            StringBuilder stringBuilder = new StringBuilder("Wrong size of imageBuffer! For image size ");
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            stringBuilder.append(", the expected buffer size is ");
            stringBuilder.append(Integer.toString(bitsPerPixel));
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (orientation == null || orientation == Orientation.ORIENTATION_UNKNOWN) {
            throw new IllegalArgumentException("Image orientation cannot be null nor unknown");
        } else {
            if (cVar == null) {
                cVar = c.aOF();
            }
            if (cVar.isRelative()) {
                long buildNativeImageFromCamera1Buffer = buildNativeImageFromCamera1Buffer(i, i2, bArr, orientation.intValue(), cVar.getX(), cVar.getY(), cVar.getWidth(), cVar.getHeight());
                if (buildNativeImageFromCamera1Buffer != 0) {
                    Image buildImageFromNativeContext = buildImageFromNativeContext(buildNativeImageFromCamera1Buffer);
                    buildImageFromNativeContext.dUM = bArr;
                    return buildImageFromNativeContext;
                }
                throw new RuntimeException("Failed to create native image. Please check log for details.");
            }
            throw new IllegalArgumentException("Scanning region must be given in relative coordinates, i.e. following must hold true: x + width <= 1.f && y + height <= 1.f");
        }
    }
}
