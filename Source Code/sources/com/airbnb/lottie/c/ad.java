package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.e.d;

/* compiled from: ScaleXYParser */
public class ad implements ak<d> {
    public static final ad oB = new ad();

    private ad() {
    }

    /* renamed from: l */
    public d b(JsonReader jsonReader, float f) {
        Object obj = jsonReader.peek() == JsonToken.BEGIN_ARRAY ? 1 : null;
        if (obj != null) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (obj != null) {
            jsonReader.endArray();
        }
        return new d((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
