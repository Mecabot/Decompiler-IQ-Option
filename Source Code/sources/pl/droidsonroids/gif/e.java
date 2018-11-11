package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.RawRes;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* compiled from: GifViewUtils */
final class e {
    static final List<String> fkP = Arrays.asList(new String[]{"raw", "drawable", "mipmap"});

    /* compiled from: GifViewUtils */
    static class b {
        boolean fkR;
        int fkS;

        b(View view, AttributeSet attributeSet, int i, int i2) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, pl.droidsonroids.gif.h.a.GifView, i, i2);
            this.fkR = obtainStyledAttributes.getBoolean(pl.droidsonroids.gif.h.a.GifView_freezesAnimation, false);
            this.fkS = obtainStyledAttributes.getInt(pl.droidsonroids.gif.h.a.GifView_loopCount, -1);
            obtainStyledAttributes.recycle();
        }

        b() {
            this.fkR = false;
            this.fkS = -1;
        }
    }

    /* compiled from: GifViewUtils */
    static class a extends b {
        final int fkQ;
        final int mBackgroundResId;

        a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.fkQ = a(imageView, attributeSet, true);
            this.mBackgroundResId = a(imageView, attributeSet, false);
        }

        a() {
            this.fkQ = 0;
            this.mBackgroundResId = 0;
        }

        private static int a(ImageView imageView, AttributeSet attributeSet, boolean z) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (!e.fkP.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) || e.a(imageView, z, attributeResourceValue)) {
                    return 0;
                }
                return attributeResourceValue;
            }
            return 0;
        }
    }

    static a a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new a();
        }
        a aVar = new a(imageView, attributeSet, i, i2);
        int i3 = aVar.fkS;
        if (i3 >= 0) {
            a(i3, imageView.getDrawable());
            a(i3, imageView.getBackground());
        }
        return aVar;
    }

    static void a(int i, Drawable drawable) {
        if (drawable instanceof b) {
            ((b) drawable).setLoopCount(i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020 A:{Splitter: B:2:0x0006, ExcHandler: java.io.IOException (unused java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020 A:{Splitter: B:2:0x0006, ExcHandler: java.io.IOException (unused java.io.IOException)} */
    static boolean a(android.widget.ImageView r2, boolean r3, int r4) {
        /*
        r0 = r2.getResources();
        if (r0 == 0) goto L_0x0020;
    L_0x0006:
        r1 = new pl.droidsonroids.gif.b;	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        r1.<init>(r0, r4);	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        if (r3 == 0) goto L_0x0011;
    L_0x000d:
        r2.setImageDrawable(r1);	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        goto L_0x001e;
    L_0x0011:
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        r4 = 16;
        if (r3 < r4) goto L_0x001b;
    L_0x0017:
        r2.setBackground(r1);	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        goto L_0x001e;
    L_0x001b:
        r2.setBackgroundDrawable(r1);	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
    L_0x001e:
        r2 = 1;
        return r2;
    L_0x0020:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.e.a(android.widget.ImageView, boolean, int):boolean");
    }

    static boolean a(ImageView imageView, Uri uri) {
        if (uri != null) {
            try {
                imageView.setImageDrawable(new b(imageView.getContext().getContentResolver(), uri));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    static float a(@NonNull Resources resources, @RawRes @DrawableRes int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        i = typedValue.density;
        if (i == 0) {
            i = 160;
        } else if (i == SupportMenu.USER_MASK) {
            i = 0;
        }
        int i2 = resources.getDisplayMetrics().densityDpi;
        return (i <= 0 || i2 <= 0) ? 1.0f : ((float) i2) / ((float) i);
    }
}
