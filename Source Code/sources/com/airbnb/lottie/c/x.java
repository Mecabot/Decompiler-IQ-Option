package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.a.b.h;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.g;

/* compiled from: PathKeyframeParser */
class x {
    static h s(JsonReader jsonReader, g gVar) {
        return new h(gVar, r.a(jsonReader, gVar, f.fo(), y.oz, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
