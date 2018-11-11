package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.a.k;
import com.iqoption.fragment.cashbox.deppage.a;

/* compiled from: AnimatableTextPropertiesParser */
public class b {
    public static k c(JsonReader jsonReader, g gVar) {
        jsonReader.beginObject();
        k kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            if (nextName.hashCode() == 97 && nextName.equals(a.TAG)) {
                obj = null;
            }
            if (obj != null) {
                jsonReader.skipValue();
            } else {
                kVar = d(jsonReader, gVar);
            }
        }
        jsonReader.endObject();
        return kVar == null ? new k(null, null, null, null) : kVar;
    }

    private static k d(JsonReader jsonReader, g gVar) {
        jsonReader.beginObject();
        com.airbnb.lottie.model.a.a aVar = null;
        com.airbnb.lottie.model.a.a aVar2 = null;
        com.airbnb.lottie.model.a.b bVar = aVar2;
        com.airbnb.lottie.model.a.b bVar2 = bVar;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 116) {
                if (hashCode != 3261) {
                    if (hashCode != 3664) {
                        if (hashCode == 3684 && nextName.equals("sw")) {
                            obj = 2;
                        }
                    } else if (nextName.equals("sc")) {
                        obj = 1;
                    }
                } else if (nextName.equals("fc")) {
                    obj = null;
                }
            } else if (nextName.equals("t")) {
                obj = 3;
            }
            switch (obj) {
                case null:
                    aVar = d.l(jsonReader, gVar);
                    break;
                case 1:
                    aVar2 = d.l(jsonReader, gVar);
                    break;
                case 2:
                    bVar = d.f(jsonReader, gVar);
                    break;
                case 3:
                    bVar2 = d.f(jsonReader, gVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new k(aVar, aVar2, bVar, bVar2);
    }
}
