package com.jumio.clientlib.impl.templatematcher;

public final class PixelFormatType {
    public static final PixelFormatType PIXEL_FORMAT_BGRA_8 = new PixelFormatType("PIXEL_FORMAT_BGRA_8");
    public static final PixelFormatType PIXEL_FORMAT_BGR_8 = new PixelFormatType("PIXEL_FORMAT_BGR_8");
    public static final PixelFormatType PIXEL_FORMAT_GRAY = new PixelFormatType("PIXEL_FORMAT_GRAY");
    public static final PixelFormatType PIXEL_FORMAT_RGBA_8 = new PixelFormatType("PIXEL_FORMAT_RGBA_8");
    public static final PixelFormatType PIXEL_FORMAT_RGB_8 = new PixelFormatType("PIXEL_FORMAT_RGB_8");
    public static final PixelFormatType PIXEL_FORMAT_YUV420_NV21 = new PixelFormatType("PIXEL_FORMAT_YUV420_NV21");
    private static PixelFormatType[] a = new PixelFormatType[]{PIXEL_FORMAT_RGB_8, PIXEL_FORMAT_RGBA_8, PIXEL_FORMAT_BGR_8, PIXEL_FORMAT_BGRA_8, PIXEL_FORMAT_YUV420_NV21, PIXEL_FORMAT_GRAY};
    private static int b;
    private final int c;
    private final String d;

    public final int swigValue() {
        return this.c;
    }

    public String toString() {
        return this.d;
    }

    public static PixelFormatType swigToEnum(int i) {
        if (i < a.length && i >= 0 && a[i].c == i) {
            return a[i];
        }
        for (int i2 = 0; i2 < a.length; i2++) {
            if (a[i2].c == i) {
                return a[i2];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No enum ");
        stringBuilder.append(PixelFormatType.class);
        stringBuilder.append(" with value ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private PixelFormatType(String str) {
        this.d = str;
        int i = b;
        b = i + 1;
        this.c = i;
    }
}
