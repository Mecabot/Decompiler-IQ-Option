package com.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.b;
import com.airbnb.lottie.model.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager */
public class a {
    private final AssetManager assetManager;
    private final g<String> lQ = new g();
    private final Map<g<String>, Typeface> lR = new HashMap();
    private final Map<String, Typeface> lS = new HashMap();
    @Nullable
    private b lT;
    private String lU = ".ttf";

    public a(Callback callback, @Nullable b bVar) {
        this.lT = bVar;
        if (callback instanceof View) {
            this.assetManager = ((View) callback).getContext().getAssets();
            return;
        }
        Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
        this.assetManager = null;
    }

    public void a(@Nullable b bVar) {
        this.lT = bVar;
    }

    public Typeface g(String str, String str2) {
        this.lQ.set(str, str2);
        Typeface typeface = (Typeface) this.lR.get(this.lQ);
        if (typeface != null) {
            return typeface;
        }
        Typeface a = a(ad(str), str2);
        this.lR.put(this.lQ, a);
        return a;
    }

    private Typeface ad(String str) {
        Typeface typeface = (Typeface) this.lS.get(str);
        if (typeface != null) {
            return typeface;
        }
        typeface = null;
        if (this.lT != null) {
            typeface = this.lT.V(str);
        }
        if (this.lT != null && r0 == null) {
            String W = this.lT.W(str);
            if (W != null) {
                typeface = Typeface.createFromAsset(this.assetManager, W);
            }
        }
        if (typeface == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fonts/");
            stringBuilder.append(str);
            stringBuilder.append(this.lU);
            typeface = Typeface.createFromAsset(this.assetManager, stringBuilder.toString());
        }
        this.lS.put(str, typeface);
        return typeface;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }
}
