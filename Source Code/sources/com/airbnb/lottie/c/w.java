package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.model.content.MergePaths.MergePathsMode;

/* compiled from: MergePathsParser */
class w {
    static MergePaths f(JsonReader jsonReader) {
        String str = null;
        MergePathsMode mergePathsMode = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 3488) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    obj = null;
                }
            } else if (nextName.equals("mm")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    mergePathsMode = MergePathsMode.forId(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new MergePaths(str, mergePathsMode);
    }
}
