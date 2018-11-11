package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import android.util.Log;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.k;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;

public class MergePaths implements b {
    private final MergePathsMode mU;
    private final String name;

    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            switch (i) {
                case 1:
                    return Merge;
                case 2:
                    return Add;
                case 3:
                    return Subtract;
                case 4:
                    return Intersect;
                case 5:
                    return ExcludeIntersections;
                default:
                    return Merge;
            }
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.name = str;
        this.mU = mergePathsMode;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode et() {
        return this.mU;
    }

    @Nullable
    public b a(h hVar, a aVar) {
        if (hVar.dh()) {
            return new k(this);
        }
        Log.w("LOTTIE", "Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MergePaths{mode=");
        stringBuilder.append(this.mU);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
