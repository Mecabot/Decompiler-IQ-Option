package com.airbnb.lottie.c;

import android.graphics.Color;
import android.support.annotation.IntRange;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.d.e;
import com.airbnb.lottie.model.content.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientColorParser */
public class m implements ak<c> {
    private int ov;

    public m(int i) {
        this.ov = i;
    }

    /* renamed from: e */
    public c b(JsonReader jsonReader, float f) {
        List arrayList = new ArrayList();
        Object obj = jsonReader.peek() == JsonToken.BEGIN_ARRAY ? 1 : null;
        if (obj != null) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (obj != null) {
            jsonReader.endArray();
        }
        if (this.ov == -1) {
            this.ov = arrayList.size() / 4;
        }
        float[] fArr = new float[this.ov];
        int[] iArr = new int[this.ov];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.ov * 4; i3++) {
            int i4 = i3 / 4;
            double floatValue = (double) ((Float) arrayList.get(i3)).floatValue();
            switch (i3 % 4) {
                case 0:
                    fArr[i4] = (float) floatValue;
                    break;
                case 1:
                    i = (int) (floatValue * 255.0d);
                    break;
                case 2:
                    i2 = (int) (floatValue * 255.0d);
                    break;
                case 3:
                    iArr[i4] = Color.argb(255, i, i2, (int) (floatValue * 255.0d));
                    break;
                default:
                    break;
            }
        }
        c cVar = new c(fArr, iArr);
        a(cVar, arrayList);
        return cVar;
    }

    private void a(c cVar, List<Float> list) {
        int i = this.ov * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = (double) ((Float) list.get(i)).floatValue();
                } else {
                    dArr2[i2] = (double) ((Float) list.get(i)).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < cVar.getSize(); i3++) {
                int i4 = cVar.getColors()[i3];
                cVar.getColors()[i3] = Color.argb(a((double) cVar.getPositions()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
    }

    @IntRange(from = 0, to = 255)
    private int a(double d, double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        for (int i = 1; i < dArr3.length; i++) {
            int i2 = i - 1;
            double d2 = dArr3[i2];
            double d3 = dArr3[i];
            if (dArr3[i] >= d) {
                return (int) (e.a(dArr4[i2], dArr4[i], (d - d2) / (d3 - d2)) * 255.0d);
            }
        }
        return (int) (dArr4[dArr4.length - 1] * 255.0d);
    }
}
