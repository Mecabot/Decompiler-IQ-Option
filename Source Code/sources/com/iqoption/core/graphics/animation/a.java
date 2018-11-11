package com.iqoption.core.graphics.animation;

import android.animation.TypeEvaluator;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, aXE = {"Lcom/iqoption/core/graphics/animation/ArgbEvaluator;", "Landroid/animation/TypeEvaluator;", "", "()V", "evaluate", "fraction", "", "startValue", "endValue", "Companion", "core_release"})
/* compiled from: Evaluators.kt */
public final class a implements TypeEvaluator<Object> {
    private static final a aQG = new a();
    public static final a aQH = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/core/graphics/animation/ArgbEvaluator$Companion;", "", "()V", "instance", "Lcom/iqoption/core/graphics/animation/ArgbEvaluator;", "instance$annotations", "getInstance", "()Lcom/iqoption/core/graphics/animation/ArgbEvaluator;", "core_release"})
    /* compiled from: Evaluators.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a TB() {
            return a.aQG;
        }
    }

    public static final a TB() {
        a aVar = aQH;
        return aQG;
    }

    public Object evaluate(float f, Object obj, Object obj2) {
        h.e(obj, "startValue");
        h.e(obj2, "endValue");
        int intValue = ((Integer) obj).intValue();
        float f2 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        float f3 = ((float) ((intValue >> 16) & 255)) / 255.0f;
        float f4 = ((float) ((intValue >> 8) & 255)) / 255.0f;
        float f5 = ((float) (intValue & 255)) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float f6 = ((float) ((intValue2 >> 24) & 255)) / 255.0f;
        float f7 = ((float) ((intValue2 >> 16) & 255)) / 255.0f;
        float f8 = ((float) ((intValue2 >> 8) & 255)) / 255.0f;
        f3 = (float) Math.pow((double) f3, 2.2d);
        f4 = (float) Math.pow((double) f4, 2.2d);
        f5 = (float) Math.pow((double) f5, 2.2d);
        f4 += (((float) Math.pow((double) f8, 2.2d)) - f4) * f;
        f5 += f * (((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d)) - f5);
        f2 = (f2 + ((f6 - f2) * f)) * 255.0f;
        return Integer.valueOf((((Math.round(((float) Math.pow((double) (f3 + ((((float) Math.pow((double) f7, 2.2d)) - f3) * f)), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f2) << 24)) | (Math.round(((float) Math.pow((double) f4, 0.45454545454545453d)) * 255.0f) << 8)) | Math.round(((float) Math.pow((double) f5, 0.45454545454545453d)) * 255.0f));
    }
}
