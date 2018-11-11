package com.airbnb.lottie.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.c;
import com.airbnb.lottie.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ImageAssetManager */
public class b {
    private static final Object lV = new Object();
    private final Context context;
    private String lW;
    @Nullable
    private c lX;
    private final Map<String, p> lY;
    private final Map<String, Bitmap> lZ = new HashMap();

    public b(Callback callback, String str, c cVar, Map<String, p> map) {
        this.lW = str;
        if (!(TextUtils.isEmpty(str) || this.lW.charAt(this.lW.length() - 1) == '/')) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.lW);
            stringBuilder.append('/');
            this.lW = stringBuilder.toString();
        }
        if (callback instanceof View) {
            this.context = ((View) callback).getContext();
            this.lY = map;
            a(cVar);
            return;
        }
        Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
        this.lY = new HashMap();
        this.context = null;
    }

    public void a(@Nullable c cVar) {
        this.lX = cVar;
    }

    @Nullable
    public Bitmap ae(String str) {
        Bitmap bitmap = (Bitmap) this.lZ.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        p pVar = (p) this.lY.get(str);
        if (pVar == null) {
            return null;
        }
        if (this.lX != null) {
            bitmap = this.lX.a(pVar);
            if (bitmap != null) {
                a(str, bitmap);
            }
            return bitmap;
        }
        String fileName = pVar.getFileName();
        Options options = new Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!fileName.startsWith("data:") || fileName.indexOf("base64,") <= 0) {
            try {
                if (TextUtils.isEmpty(this.lW)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                AssetManager assets = this.context.getAssets();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.lW);
                stringBuilder.append(fileName);
                return a(str, BitmapFactory.decodeStream(assets.open(stringBuilder.toString()), null, options));
            } catch (Throwable e) {
                Log.w("LOTTIE", "Unable to open asset.", e);
                return null;
            }
        }
        try {
            byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
            return a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
        } catch (Throwable e2) {
            Log.w("LOTTIE", "data URL did not have correct base64 format.", e2);
            return null;
        }
    }

    public void recycleBitmaps() {
        synchronized (lV) {
            Iterator it = this.lZ.entrySet().iterator();
            while (it.hasNext()) {
                ((Bitmap) ((Entry) it.next()).getValue()).recycle();
                it.remove();
            }
        }
    }

    public boolean l(Context context) {
        return (context == null && this.context == null) || (context != null && this.context.equals(context));
    }

    private Bitmap a(String str, @Nullable Bitmap bitmap) {
        Bitmap bitmap2;
        synchronized (lV) {
            bitmap2 = (Bitmap) this.lZ.put(str, bitmap);
        }
        return bitmap2;
    }
}
