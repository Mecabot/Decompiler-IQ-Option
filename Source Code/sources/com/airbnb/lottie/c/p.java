package com.airbnb.lottie.c;

import android.util.JsonReader;

/* compiled from: IntegerParser */
public class p implements ak<Integer> {
    public static final p ow = new p();

    private p() {
    }

    /* renamed from: a */
    public Integer b(JsonReader jsonReader, float f) {
        return Integer.valueOf(Math.round(q.d(jsonReader) * f));
    }
}
