package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.c.u;
import com.airbnb.lottie.model.c;
import com.airbnb.lottie.model.d;
import com.airbnb.lottie.model.layer.Layer;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: LottieComposition */
public class g {
    private Rect bounds;
    private float frameRate;
    private final s jj = new s();
    private final HashSet<String> jk = new HashSet();
    private Map<String, List<Layer>> jl;
    private Map<String, p> jm;
    private Map<String, c> jn;
    private SparseArrayCompat<d> jo;
    private LongSparseArray<Layer> jp;
    private List<Layer> jq;
    private float jr;
    private float js;

    /* compiled from: LottieComposition */
    public static class a {
        public static a a(Context context, String str, r rVar) {
            try {
                return a(context.getAssets().open(str), rVar);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to find file ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString(), e);
            }
        }

        public static a a(Context context, @RawRes int i, r rVar) {
            return a(context.getResources().openRawResource(i), rVar);
        }

        public static a a(InputStream inputStream, r rVar) {
            return a(new JsonReader(new InputStreamReader(inputStream)), rVar);
        }

        public static a a(JsonReader jsonReader, r rVar) {
            a eVar = new e(rVar);
            eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JsonReader[]{jsonReader});
            return eVar;
        }

        public static g a(JsonReader jsonReader) {
            return u.e(jsonReader);
        }
    }

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, p> map2, SparseArrayCompat<d> sparseArrayCompat, Map<String, c> map3) {
        this.bounds = rect;
        this.jr = f;
        this.js = f2;
        this.frameRate = f3;
        this.jq = list;
        this.jp = longSparseArray;
        this.jl = map;
        this.jm = map2;
        this.jo = sparseArrayCompat;
        this.jn = map3;
    }

    @RestrictTo({Scope.LIBRARY})
    public void Y(String str) {
        Log.w("LOTTIE", str);
        this.jk.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.jj.setEnabled(z);
    }

    public s getPerformanceTracker() {
        return this.jj;
    }

    @RestrictTo({Scope.LIBRARY})
    public Layer f(long j) {
        return (Layer) this.jp.get(j);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public float cZ() {
        return (float) ((long) ((dg() / this.frameRate) * 1000.0f));
    }

    @RestrictTo({Scope.LIBRARY})
    public float da() {
        return this.jr;
    }

    @RestrictTo({Scope.LIBRARY})
    public float db() {
        return this.js;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public List<Layer> dc() {
        return this.jq;
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY})
    public List<Layer> Z(String str) {
        return (List) this.jl.get(str);
    }

    public SparseArrayCompat<d> dd() {
        return this.jo;
    }

    public Map<String, c> de() {
        return this.jn;
    }

    public Map<String, p> df() {
        return this.jm;
    }

    public float dg() {
        return this.js - this.jr;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.jq) {
            stringBuilder.append(layer.toString("\t"));
        }
        return stringBuilder.toString();
    }
}
