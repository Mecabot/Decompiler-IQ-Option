package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser */
class s {
    static <T> List<a<T>> a(JsonReader jsonReader, g gVar, float f, ak<T> akVar) {
        List<a<T>> arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            gVar.Y("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            if (nextName.hashCode() == 107 && nextName.equals("k")) {
                obj = null;
            }
            if (obj != null) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(r.a(jsonReader, gVar, f, akVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(r.a(jsonReader, gVar, f, akVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(r.a(jsonReader, gVar, f, akVar, false));
            }
        }
        jsonReader.endObject();
        p(arrayList);
        return arrayList;
    }

    public static void p(List<? extends a<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            a aVar = (a) list.get(i2);
            i2++;
            aVar.oS = Float.valueOf(((a) list.get(i2)).jr);
        }
        a aVar2 = (a) list.get(i);
        if (aVar2.oP == null) {
            list.remove(aVar2);
        }
    }
}
