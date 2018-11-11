package com.airbnb.lottie.c;

import android.support.annotation.Nullable;
import android.util.JsonReader;
import com.airbnb.lottie.d.f;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.a.a;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.h;
import com.airbnb.lottie.model.a.j;
import java.util.List;

/* compiled from: AnimatableValueParser */
public class d {
    public static b f(JsonReader jsonReader, g gVar) {
        return a(jsonReader, gVar, true);
    }

    public static b a(JsonReader jsonReader, g gVar, boolean z) {
        return new b(a(jsonReader, z ? f.fo() : 1.0f, gVar, j.ou));
    }

    static com.airbnb.lottie.model.a.d g(JsonReader jsonReader, g gVar) {
        return new com.airbnb.lottie.model.a.d(a(jsonReader, gVar, p.ow));
    }

    static com.airbnb.lottie.model.a.f h(JsonReader jsonReader, g gVar) {
        return new com.airbnb.lottie.model.a.f(a(jsonReader, f.fo(), gVar, z.oA));
    }

    static com.airbnb.lottie.model.a.g i(JsonReader jsonReader, g gVar) {
        return new com.airbnb.lottie.model.a.g(a(jsonReader, gVar, ad.oB));
    }

    static h j(JsonReader jsonReader, g gVar) {
        return new h(a(jsonReader, f.fo(), gVar, ae.oC));
    }

    static j k(JsonReader jsonReader, g gVar) {
        return new j(a(jsonReader, gVar, i.ot));
    }

    static a l(JsonReader jsonReader, g gVar) {
        return new a(a(jsonReader, gVar, g.os));
    }

    static c a(JsonReader jsonReader, g gVar, int i) {
        return new c(a(jsonReader, gVar, new m(i)));
    }

    @Nullable
    private static <T> List<com.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, g gVar, ak<T> akVar) {
        return s.a(jsonReader, gVar, 1.0f, akVar);
    }

    @Nullable
    private static <T> List<com.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, float f, g gVar, ak<T> akVar) {
        return s.a(jsonReader, gVar, f, akVar);
    }
}
