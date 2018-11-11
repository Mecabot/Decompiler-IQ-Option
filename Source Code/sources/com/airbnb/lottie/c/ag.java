package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.model.content.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeGroupParser */
class ag {
    static j x(JsonReader jsonReader, g gVar) {
        List arrayList = new ArrayList();
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 3371) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    obj = null;
                }
            } else if (nextName.equals("it")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        b m = h.m(jsonReader, gVar);
                        if (m != null) {
                            arrayList.add(m);
                        }
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new j(str, arrayList);
    }
}
