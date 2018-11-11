package com.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;

/* compiled from: PointFParser */
public class z implements ak<PointF> {
    public static final z oA = new z();

    private z() {
    }

    /* renamed from: k */
    public PointF b(JsonReader jsonReader, float f) {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_ARRAY) {
            return q.g(jsonReader, f);
        }
        if (peek == JsonToken.BEGIN_OBJECT) {
            return q.g(jsonReader, f);
        }
        if (peek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot convert json to point. Next token is ");
        stringBuilder.append(peek);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
