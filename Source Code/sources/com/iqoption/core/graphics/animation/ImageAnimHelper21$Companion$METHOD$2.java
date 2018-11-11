package com.iqoption.core.graphics.animation;

import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Ljava/lang/reflect/Method;", "invoke"})
/* compiled from: ImageAnimHelperApi.kt */
final class ImageAnimHelper21$Companion$METHOD$2 extends Lambda implements a<Method> {
    public static final ImageAnimHelper21$Companion$METHOD$2 aQS = new ImageAnimHelper21$Companion$METHOD$2();

    ImageAnimHelper21$Companion$METHOD$2() {
        super(0);
    }

    /* renamed from: TG */
    public final Method invoke() {
        try {
            Method declaredMethod = ImageView.class.getDeclaredMethod("animateTransform", new Class[]{Matrix.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e) {
            Log.w(f.TAG, e.getMessage(), e);
            return null;
        }
    }
}
