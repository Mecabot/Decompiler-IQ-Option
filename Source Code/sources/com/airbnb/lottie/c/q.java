package com.airbnb.lottie.c;

import android.graphics.Color;
import android.graphics.PointF;
import android.support.annotation.ColorInt;
import android.util.JsonReader;
import android.util.JsonToken;
import com.iqoption.dto.ChartTimeInterval;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils */
class q {

    /* compiled from: JsonUtils */
    /* renamed from: com.airbnb.lottie.c.q$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ox = new int[JsonToken.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:6:?, code:
            ox[android.util.JsonToken.BEGIN_OBJECT.ordinal()] = 3;
     */
        static {
            /*
            r0 = android.util.JsonToken.values();
            r0 = r0.length;
            r0 = new int[r0];
            ox = r0;
            r0 = ox;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.util.JsonToken.NUMBER;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = ox;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.util.JsonToken.BEGIN_ARRAY;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = ox;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.util.JsonToken.BEGIN_OBJECT;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.q.1.<clinit>():void");
        }
    }

    @ColorInt
    static int c(JsonReader jsonReader) {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
    }

    static List<PointF> f(JsonReader jsonReader, float f) {
        List<PointF> arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(g(jsonReader, f));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    static PointF g(JsonReader jsonReader, float f) {
        switch (AnonymousClass1.ox[jsonReader.peek().ordinal()]) {
            case 1:
                return h(jsonReader, f);
            case 2:
                return i(jsonReader, f);
            case 3:
                return j(jsonReader, f);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown point starts with ");
                stringBuilder.append(jsonReader.peek());
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static PointF h(JsonReader jsonReader, float f) {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    private static PointF i(JsonReader jsonReader, float f) {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    private static PointF j(JsonReader jsonReader, float f) {
        jsonReader.beginObject();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            switch (nextName.hashCode()) {
                case ChartTimeInterval.CANDLE_2m /*120*/:
                    if (nextName.equals("x")) {
                        obj = null;
                        break;
                    }
                    break;
                case 121:
                    if (nextName.equals("y")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    f2 = d(jsonReader);
                    break;
                case 1:
                    f3 = d(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new PointF(f2 * f, f3 * f);
    }

    static float d(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        switch (AnonymousClass1.ox[peek.ordinal()]) {
            case 1:
                return (float) jsonReader.nextDouble();
            case 2:
                jsonReader.beginArray();
                float nextDouble = (float) jsonReader.nextDouble();
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                jsonReader.endArray();
                return nextDouble;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown value for token of type ");
                stringBuilder.append(peek);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
