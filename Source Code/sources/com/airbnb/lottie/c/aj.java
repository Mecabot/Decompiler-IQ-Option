package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;

/* compiled from: ShapeTrimPathParser */
class aj {
    static ShapeTrimPath A(JsonReader jsonReader, g gVar) {
        String str = null;
        Type type = str;
        b bVar = type;
        b bVar2 = bVar;
        b bVar3 = bVar2;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 109) {
                    if (hashCode != 111) {
                        if (hashCode != 115) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                obj = 3;
                            }
                        } else if (nextName.equals("s")) {
                            obj = null;
                        }
                    } else if (nextName.equals("o")) {
                        obj = 2;
                    }
                } else if (nextName.equals("m")) {
                    obj = 4;
                }
            } else if (nextName.equals("e")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    bVar = d.a(jsonReader, gVar, false);
                    break;
                case 1:
                    bVar2 = d.a(jsonReader, gVar, false);
                    break;
                case 2:
                    bVar3 = d.a(jsonReader, gVar, false);
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                case 4:
                    type = Type.forId(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3);
    }
}
