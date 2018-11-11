package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.m;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape.Type;

/* compiled from: PolystarShapeParser */
class aa {
    static PolystarShape t(JsonReader jsonReader, g gVar) {
        String str = null;
        Type type = str;
        b bVar = type;
        m mVar = bVar;
        b bVar2 = mVar;
        b bVar3 = bVar2;
        b bVar4 = bVar3;
        b bVar5 = bVar4;
        b bVar6 = bVar5;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            switch (nextName.hashCode()) {
                case 112:
                    if (nextName.equals("p")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 3369:
                    if (nextName.equals("ir")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 3370:
                    if (nextName.equals("is")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        obj = null;
                        break;
                    }
                    break;
                case 3555:
                    if (nextName.equals("or")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 3686:
                    if (nextName.equals("sy")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    type = Type.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    bVar = d.a(jsonReader, gVar, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, gVar);
                    break;
                case 4:
                    bVar2 = d.a(jsonReader, gVar, false);
                    break;
                case 5:
                    bVar4 = d.f(jsonReader, gVar);
                    break;
                case 6:
                    bVar6 = d.a(jsonReader, gVar, false);
                    break;
                case 7:
                    bVar3 = d.f(jsonReader, gVar);
                    break;
                case 8:
                    bVar5 = d.a(jsonReader, gVar, false);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }
}
