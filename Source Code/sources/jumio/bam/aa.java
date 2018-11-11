package jumio.bam;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.internal.view.SupportMenu;
import com.jumio.commons.json.JumioJSONObject;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.utils.ImageUtil;
import com.jumio.ocr.impl.smartEngines.swig.OcrPoint;
import com.jumio.ocr.impl.smartEngines.swig.OcrQuadrangle;
import com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: BamLogUtils */
public class aa extends LogUtils {
    private static StringBuilder a = new StringBuilder();
    private static HashMap<String, ArrayList<a>> b;

    /* compiled from: BamLogUtils */
    public static class a {
        public int a;
        public int b;
        public int c;
        public int d;
    }

    public static void a() {
        LogUtils.init();
        d();
        b();
    }

    public static void b() {
        a.delete(0, a.length());
    }

    public static void c() {
        Log.i(a.toString(), LogUtils.getLogFolder(), "OCRImageData.txt");
    }

    public static void a(String str, OcrQuadrangle ocrQuadrangle) {
        if (b != null) {
            if (!b.containsKey(str)) {
                b.put(str, new ArrayList());
            }
            a aVar = new a();
            aVar.a = ocrQuadrangle.getTopLeft().getX();
            aVar.b = ocrQuadrangle.getTopLeft().getY();
            aVar.c = ocrQuadrangle.getBottomRight().getX();
            aVar.d = ocrQuadrangle.getBottomRight().getY();
            ((ArrayList) b.get(str)).add(aVar);
        }
    }

    public static void a(String str, String str2, long j, boolean z) {
        StringBuilder stringBuilder = a;
        stringBuilder.append(str);
        stringBuilder.append("\r\n");
        stringBuilder = a;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("value: ");
        stringBuilder2.append(str2);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\r\n");
        StringBuilder stringBuilder3 = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append("time: ");
        stringBuilder.append(Long.toString(j));
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3 = a;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("accepted: ");
        stringBuilder4.append(Boolean.toString(z));
        stringBuilder3.append(stringBuilder4.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3 = a;
        stringBuilder3.append("coordinates: ");
        stringBuilder3.append("\r\n");
        ArrayList arrayList = (ArrayList) b.get(str);
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                a aVar = (a) arrayList.get(i);
                StringBuilder stringBuilder5 = a;
                stringBuilder5.append(aVar.a);
                stringBuilder5.append(",");
                stringBuilder5.append(aVar.b);
                stringBuilder5.append(",");
                stringBuilder5.append(aVar.c);
                stringBuilder5.append(",");
                stringBuilder5.append(aVar.d);
                stringBuilder5.append("\r\n");
            }
            a.append("\r\n");
        }
    }

    public static void a(OcrQuadrangle ocrQuadrangle, OcrQuadrangle ocrQuadrangle2, JumioJSONObject jumioJSONObject) {
        StringBuilder stringBuilder = a;
        stringBuilder.append("MASKING RECT:");
        stringBuilder.append("\r\n");
        stringBuilder = a;
        stringBuilder.append("Detection:");
        stringBuilder.append("\r\n");
        stringBuilder = a;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("TL: ");
        stringBuilder2.append(a(ocrQuadrangle.getTopLeft()));
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\r\n");
        stringBuilder = a;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("BL: ");
        stringBuilder2.append(a(ocrQuadrangle.getBottomLeft()));
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\r\n");
        StringBuilder stringBuilder3 = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append("TR: ");
        stringBuilder.append(a(ocrQuadrangle2.getTopRight()));
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3 = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append("BR: ");
        stringBuilder.append(a(ocrQuadrangle2.getBottomRight()));
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3 = a;
        stringBuilder3.append("Upload:");
        stringBuilder3.append("\r\n");
        try {
            stringBuilder3 = a;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("TL: ");
            stringBuilder4.append(a(jumioJSONObject.getJSONObject("topLeft")));
            stringBuilder3.append(stringBuilder4.toString());
            stringBuilder3.append("\r\n");
            stringBuilder3 = a;
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("TR: ");
            stringBuilder4.append(a(jumioJSONObject.getJSONObject("topRight")));
            stringBuilder3.append(stringBuilder4.toString());
            stringBuilder3.append("\r\n");
            stringBuilder3 = a;
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("BL: ");
            stringBuilder4.append(a(jumioJSONObject.getJSONObject("bottomLeft")));
            stringBuilder3.append(stringBuilder4.toString());
            stringBuilder3.append("\r\n");
            stringBuilder3 = a;
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("BR: ");
            stringBuilder4.append(a(jumioJSONObject.getJSONObject("bottomRight")));
            stringBuilder3.append(stringBuilder4.toString());
            stringBuilder3.append("\r\n");
        } catch (Exception unused) {
            a.append("\r\n");
        }
    }

    public static void a(int i, int i2, int i3, int i4) {
        StringBuilder stringBuilder = a;
        stringBuilder.append("IMAGE INFORMATION:");
        stringBuilder.append("\r\n");
        stringBuilder = a;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("detection width: ");
        stringBuilder2.append(i);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\r\n");
        StringBuilder stringBuilder3 = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append("detection height: ");
        stringBuilder.append(i2);
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3 = a;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("upload width: ");
        stringBuilder4.append(i3);
        stringBuilder3.append(stringBuilder4.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3 = a;
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append("upload height: ");
        stringBuilder4.append(i4);
        stringBuilder3.append(stringBuilder4.toString());
        stringBuilder3.append("\r\n");
        a.append("\r\n");
    }

    public static void a(byte[] bArr, int i, int i2) {
        Log.image(ImageUtil.rgbToBitmap(bArr, i, i2), LogUtils.getLogFolder(), "scaled.webp", CompressFormat.WEBP, 80);
    }

    public static void b(byte[] bArr, int i, int i2) {
        Bitmap rgbToBitmap = ImageUtil.rgbToBitmap(bArr, i, i2);
        Canvas canvas = new Canvas(rgbToBitmap);
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(0.0f);
        Iterator it = b.entrySet().iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Entry entry = (Entry) it.next();
            if (entry.getKey() == FieldName.NUMBER.toString()) {
                paint.setColor(-16724941);
            } else if (entry.getKey() == FieldName.EXPIRY.toString()) {
                paint.setColor(-205);
            } else if (entry.getKey() == FieldName.NAME.toString()) {
                paint.setColor(-39373);
            } else if (entry.getKey() == FieldName.AMEX_CVV.toString()) {
                paint.setColor(-6724045);
            } else if (entry.getKey() == FieldName.UK_ACCOUNTNUM.toString()) {
                paint.setColor(-16724737);
            } else if (entry.getKey() == FieldName.UK_SORTCODE.toString()) {
                paint.setColor(-6736948);
            }
            while (i3 < ((ArrayList) entry.getValue()).size()) {
                a aVar = (a) ((ArrayList) entry.getValue()).get(i3);
                canvas.drawRect((float) aVar.a, (float) aVar.b, (float) aVar.c, (float) aVar.d, paint);
                i3++;
            }
        }
        ArrayList arrayList = (ArrayList) b.get(FieldName.NUMBER);
        if (arrayList != null) {
            paint.setColor(SupportMenu.CATEGORY_MASK);
            paint.setStrokeWidth(2.0f);
            if (arrayList.size() > 6) {
                a aVar2 = (a) arrayList.get(6);
                a aVar3 = (a) arrayList.get((arrayList.size() - 1) - 4);
                Paint paint2 = paint;
                canvas.drawLine((float) aVar2.a, (float) aVar2.b, (float) aVar3.c, (float) aVar3.b, paint2);
                canvas.drawLine((float) aVar3.c, (float) aVar3.b, (float) aVar3.c, (float) aVar3.d, paint2);
                canvas.drawLine((float) aVar2.a, (float) aVar2.b, (float) aVar2.a, (float) aVar2.d, paint2);
                canvas.drawLine((float) aVar2.a, (float) aVar2.d, (float) aVar3.c, (float) aVar3.d, paint2);
            }
        }
        Log.image(rgbToBitmap, LogUtils.getLogFolder(), "scaled_with_coords.png", CompressFormat.PNG, 0);
    }

    public static void d() {
        if (b == null) {
            b = new HashMap();
        } else {
            b.clear();
        }
    }

    private static String a(OcrPoint ocrPoint) {
        return String.format("%d, %d", new Object[]{Integer.valueOf(ocrPoint.getX()), Integer.valueOf(ocrPoint.getY())});
    }

    private static String a(JSONObject jSONObject) {
        return String.format("%d, %d", new Object[]{Integer.valueOf(jSONObject.getInt("x")), Integer.valueOf(jSONObject.getInt("y"))});
    }
}
