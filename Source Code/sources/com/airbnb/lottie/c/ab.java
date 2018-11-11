package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.content.f;

/* compiled from: RectangleShapeParser */
class ab {
    static f u(JsonReader jsonReader, g gVar) {
        String str = null;
        m mVar = null;
        com.airbnb.lottie.model.a.f fVar = mVar;
        b bVar = fVar;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3519) {
                    switch (hashCode) {
                        case 114:
                            if (nextName.equals("r")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 115:
                            if (nextName.equals("s")) {
                                obj = 2;
                                break;
                            }
                            break;
                    }
                } else if (nextName.equals("nm")) {
                    obj = null;
                }
            } else if (nextName.equals("p")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    mVar = a.b(jsonReader, gVar);
                    break;
                case 2:
                    fVar = d.h(jsonReader, gVar);
                    break;
                case 3:
                    bVar = d.f(jsonReader, gVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new f(str, mVar, fVar, bVar);
    }
}
