package com.airbnb.lottie.c;

import android.util.JsonReader;

/* compiled from: FloatParser */
public class j implements ak<Float> {
    public static final j ou = new j();

    private j() {
    }

    /* renamed from: d */
    public Float b(JsonReader jsonReader, float f) {
        return Float.valueOf(q.d(jsonReader) * f);
    }
}
