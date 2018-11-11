package jumio.nv.ocr;

import com.jumio.clientlib.impl.templatematcher.ImgWarp;
import com.jumio.clientlib.impl.templatematcher.PixelFormatType;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;

/* compiled from: TemplateMatcherImageProcessor */
public class f {
    public static float[] a(a aVar, float f) {
        float[] e = aVar.e();
        float f2 = (((e[0] + e[2]) + e[6]) + e[4]) / 4.0f;
        float f3 = (((e[1] + e[3]) + e[7]) + e[5]) / 4.0f;
        float f4 = e[0] - f2;
        float f5 = e[1] - f3;
        float f6 = e[2] - f2;
        float f7 = e[3] - f3;
        float f8 = e[6] - f2;
        float f9 = e[7] - f3;
        float f10 = e[4] - f2;
        float f11 = e[5] - f3;
        double sqrt = Math.sqrt((double) ((f4 * f4) + (f5 * f5)));
        float f12 = f3;
        double sqrt2 = Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
        float f13 = f2;
        double sqrt3 = Math.sqrt((double) ((f8 * f8) + (f9 * f9)));
        float f14 = f9;
        double sqrt4 = Math.sqrt((double) ((f10 * f10) + (f11 * f11)));
        f9 = (float) (((double) f6) / sqrt2);
        float f15 = (float) (((double) f14) / sqrt3);
        float f16 = (float) (((double) f10) / sqrt4);
        double d = (double) f;
        sqrt *= d;
        float f17 = (float) (((double) ((float) (((double) f4) / sqrt))) * sqrt);
        float f18 = (float) (((double) ((float) (((double) f5) / sqrt))) * sqrt);
        sqrt2 *= d;
        float f19 = (float) (((double) f9) * sqrt2);
        float f20 = (float) (((double) ((float) (((double) f7) / sqrt2))) * sqrt2);
        sqrt3 *= d;
        f3 = (float) (((double) ((float) (((double) f8) / sqrt3))) * sqrt3);
        float f21 = (float) (((double) f15) * sqrt3);
        d *= sqrt4;
        f2 = (float) (((double) f16) * d);
        f10 = (float) (((double) ((float) (((double) f11) / sqrt4))) * d);
        e[0] = f13 + f17;
        e[1] = f12 + f18;
        e[2] = f13 + f19;
        e[3] = f12 + f20;
        e[6] = f13 + f3;
        e[7] = f12 + f21;
        e[4] = f13 + f2;
        e[5] = f12 + f10;
        return e;
    }

    public static byte[] a(byte[] bArr, boolean z, a aVar) {
        float[] e = aVar.e();
        int o = (int) (z ? aVar.o() : aVar.n());
        int n = (int) (z ? aVar.n() : aVar.o());
        float w = ((float) aVar.w()) / ((float) aVar.x());
        int width = aVar.p().width();
        return a(bArr, o, n, e, width, (int) (((float) width) / w), aVar);
    }

    public static byte[] a(byte[] bArr, float f, Size size, boolean z, a aVar) {
        float[] a = a(aVar, f);
        int o = (int) (z ? aVar.o() : aVar.n());
        int n = (int) (z ? aVar.n() : aVar.o());
        float w = ((float) aVar.w()) / ((float) aVar.x());
        size.width = (int) (((float) aVar.p().width()) * f);
        size.height = (int) (((float) size.width) / w);
        return a(bArr, o, n, a, size.width, size.height, aVar);
    }

    public static byte[] a(byte[] bArr, int i, int i2, float[] fArr, int i3, int i4, a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[((i4 * i3) * 3)];
        int i5 = i;
        byte[] bArr3 = bArr;
        int i6 = i2;
        ImgWarp.warp(bArr3, (long) i5, i5, i6, PixelFormatType.PIXEL_FORMAT_YUV420_NV21, fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7], bArr2, i3, i4);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Image warping took ");
        stringBuilder.append(currentTimeMillis2);
        stringBuilder.append(" ms");
        Log.d("TemplateMatcher", stringBuilder.toString());
        return bArr2;
    }
}
