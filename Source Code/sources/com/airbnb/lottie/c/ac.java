package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.content.g;

/* compiled from: RepeaterParser */
class ac {
    static g v(JsonReader jsonReader, com.airbnb.lottie.g gVar) {
        String str = null;
        b bVar = null;
        b bVar2 = bVar;
        l lVar = bVar2;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710 && nextName.equals("tr")) {
                            obj = 3;
                        }
                    } else if (nextName.equals("nm")) {
                        obj = null;
                    }
                } else if (nextName.equals("o")) {
                    obj = 2;
                }
            } else if (nextName.equals("c")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    bVar = d.a(jsonReader, gVar, false);
                    break;
                case 2:
                    bVar2 = d.a(jsonReader, gVar, false);
                    break;
                case 3:
                    lVar = c.e(jsonReader, gVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new g(str, bVar, bVar2, lVar);
    }
}
