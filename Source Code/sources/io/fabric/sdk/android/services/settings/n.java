package io.fabric.sdk.android.services.settings;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.services.common.CommonUtils;

/* compiled from: IconRequest */
public class n {
    public final String eoW;
    public final int epu;
    public final int height;
    public final int width;

    public n(String str, int i, int i2, int i3) {
        this.eoW = str;
        this.epu = i;
        this.width = i2;
        this.height = i3;
    }

    public static n K(Context context, String str) {
        if (str != null) {
            try {
                int cP = CommonUtils.cP(context);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("App icon resource ID is ");
                stringBuilder.append(cP);
                c.aUg().d("Fabric", stringBuilder.toString());
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), cP, options);
                return new n(str, cP, options.outWidth, options.outHeight);
            } catch (Throwable e) {
                c.aUg().e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
