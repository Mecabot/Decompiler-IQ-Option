package com.iqoption.core.graphics.animation;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.Property;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\b¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/graphics/animation/Drawables;", "", "()V", "ALPHA", "Landroid/util/Property;", "Landroid/graphics/drawable/Drawable;", "", "getALPHA", "()Landroid/util/Property;", "BOUNDS", "Landroid/graphics/Rect;", "getBOUNDS", "COLOR", "Landroid/graphics/drawable/ColorDrawable;", "getCOLOR", "GRADIENT_COLOR", "Landroid/graphics/drawable/GradientDrawable;", "getGRADIENT_COLOR", "SCALE_X", "Lcom/iqoption/core/graphics/drawable/PropertyDrawable;", "", "getSCALE_X", "SCALE_Y", "getSCALE_Y", "SHAPE_COLOR", "Landroid/graphics/drawable/ShapeDrawable;", "getSHAPE_COLOR", "TRANSLATION_X", "getTRANSLATION_X", "TRANSLATION_Y", "getTRANSLATION_Y", "core_release"})
/* compiled from: DrawableProperties.kt */
public final class b {
    private static final Property<Drawable, Integer> ALPHA = new a(Integer.TYPE, "alpha");
    private static final Property<com.iqoption.core.graphics.a.e, Float> SCALE_X = new e(Float.TYPE, "scaleX");
    private static final Property<com.iqoption.core.graphics.a.e, Float> SCALE_Y = new f(Float.TYPE, "scaleY");
    private static final Property<com.iqoption.core.graphics.a.e, Integer> TRANSLATION_X = new h(Integer.TYPE, "translationX");
    private static final Property<com.iqoption.core.graphics.a.e, Integer> TRANSLATION_Y = new i(Integer.TYPE, "translationY");
    private static final Property<Drawable, Rect> aQI = new b(Rect.class, "bounds");
    private static final Property<ColorDrawable, Integer> aQJ = new c(Integer.TYPE, "color");
    private static final Property<ShapeDrawable, Integer> aQK = new g(Integer.TYPE, "shapeColor");
    private static final Property<GradientDrawable, Integer> aQL = new d(Integer.TYPE, "gradientColor");
    public static final b aQM = new b();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/graphics/animation/Drawables$ALPHA$1", "Landroid/util/Property;", "Landroid/graphics/drawable/Drawable;", "", "get", "object", "(Landroid/graphics/drawable/Drawable;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: DrawableProperties.kt */
    public static final class a extends Property<Drawable, Integer> {
        a(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            b((Drawable) obj, ((Number) obj2).intValue());
        }

        /* renamed from: a */
        public Integer get(Drawable drawable) {
            kotlin.jvm.internal.h.e(drawable, "object");
            return Integer.valueOf(drawable.getAlpha());
        }

        public void b(Drawable drawable, int i) {
            kotlin.jvm.internal.h.e(drawable, "object");
            drawable.setAlpha(i);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0002¨\u0006\t"}, aXE = {"com/iqoption/core/graphics/animation/Drawables$BOUNDS$1", "Landroid/util/Property;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Rect;", "get", "object", "set", "", "bounds", "core_release"})
    /* compiled from: DrawableProperties.kt */
    public static final class b extends Property<Drawable, Rect> {
        /* renamed from: b */
        public Rect get(Drawable drawable) {
            kotlin.jvm.internal.h.e(drawable, "object");
            return null;
        }

        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public void set(Drawable drawable, Rect rect) {
            kotlin.jvm.internal.h.e(drawable, "object");
            kotlin.jvm.internal.h.e(rect, "bounds");
            drawable.setBounds(rect);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/graphics/animation/Drawables$COLOR$1", "Landroid/util/Property;", "Landroid/graphics/drawable/ColorDrawable;", "", "get", "object", "(Landroid/graphics/drawable/ColorDrawable;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: DrawableProperties.kt */
    public static final class c extends Property<ColorDrawable, Integer> {
        c(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            a((ColorDrawable) obj, ((Number) obj2).intValue());
        }

        /* renamed from: a */
        public Integer get(ColorDrawable colorDrawable) {
            kotlin.jvm.internal.h.e(colorDrawable, "object");
            return Integer.valueOf(colorDrawable.getColor());
        }

        public void a(ColorDrawable colorDrawable, int i) {
            kotlin.jvm.internal.h.e(colorDrawable, "object");
            colorDrawable.setColor(i);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/graphics/animation/Drawables$GRADIENT_COLOR$1", "Landroid/util/Property;", "Landroid/graphics/drawable/GradientDrawable;", "", "get", "object", "(Landroid/graphics/drawable/GradientDrawable;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: DrawableProperties.kt */
    public static final class d extends Property<GradientDrawable, Integer> {
        d(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            a((GradientDrawable) obj, ((Number) obj2).intValue());
        }

        /* renamed from: a */
        public Integer get(GradientDrawable gradientDrawable) {
            kotlin.jvm.internal.h.e(gradientDrawable, "object");
            return Integer.valueOf(0);
        }

        public void a(GradientDrawable gradientDrawable, int i) {
            kotlin.jvm.internal.h.e(gradientDrawable, "object");
            gradientDrawable.setColor(i);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/graphics/animation/Drawables$SCALE_X$1", "Landroid/util/Property;", "Lcom/iqoption/core/graphics/drawable/PropertyDrawable;", "", "get", "object", "(Lcom/iqoption/core/graphics/drawable/PropertyDrawable;)Ljava/lang/Float;", "set", "", "value", "core_release"})
    /* compiled from: DrawableProperties.kt */
    public static final class e extends Property<com.iqoption.core.graphics.a.e, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            a((com.iqoption.core.graphics.a.e) obj, ((Number) obj2).floatValue());
        }

        /* renamed from: a */
        public Float get(com.iqoption.core.graphics.a.e eVar) {
            kotlin.jvm.internal.h.e(eVar, "object");
            return Float.valueOf(eVar.getScaleX());
        }

        public void a(com.iqoption.core.graphics.a.e eVar, float f) {
            kotlin.jvm.internal.h.e(eVar, "object");
            eVar.setScaleX(f);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/graphics/animation/Drawables$SCALE_Y$1", "Landroid/util/Property;", "Lcom/iqoption/core/graphics/drawable/PropertyDrawable;", "", "get", "object", "(Lcom/iqoption/core/graphics/drawable/PropertyDrawable;)Ljava/lang/Float;", "set", "", "value", "core_release"})
    /* compiled from: DrawableProperties.kt */
    public static final class f extends Property<com.iqoption.core.graphics.a.e, Float> {
        f(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            a((com.iqoption.core.graphics.a.e) obj, ((Number) obj2).floatValue());
        }

        /* renamed from: a */
        public Float get(com.iqoption.core.graphics.a.e eVar) {
            kotlin.jvm.internal.h.e(eVar, "object");
            return Float.valueOf(eVar.getScaleY());
        }

        public void a(com.iqoption.core.graphics.a.e eVar, float f) {
            kotlin.jvm.internal.h.e(eVar, "object");
            eVar.setScaleY(f);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/graphics/animation/Drawables$SHAPE_COLOR$1", "Landroid/util/Property;", "Landroid/graphics/drawable/ShapeDrawable;", "", "get", "object", "(Landroid/graphics/drawable/ShapeDrawable;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: DrawableProperties.kt */
    public static final class g extends Property<ShapeDrawable, Integer> {
        g(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            a((ShapeDrawable) obj, ((Number) obj2).intValue());
        }

        /* renamed from: a */
        public Integer get(ShapeDrawable shapeDrawable) {
            kotlin.jvm.internal.h.e(shapeDrawable, "object");
            Paint paint = shapeDrawable.getPaint();
            kotlin.jvm.internal.h.d(paint, "`object`.paint");
            return Integer.valueOf(paint.getColor());
        }

        public void a(ShapeDrawable shapeDrawable, int i) {
            kotlin.jvm.internal.h.e(shapeDrawable, "object");
            Paint paint = shapeDrawable.getPaint();
            kotlin.jvm.internal.h.d(paint, "`object`.paint");
            paint.setColor(i);
            shapeDrawable.invalidateSelf();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/graphics/animation/Drawables$TRANSLATION_X$1", "Landroid/util/Property;", "Lcom/iqoption/core/graphics/drawable/PropertyDrawable;", "", "get", "object", "(Lcom/iqoption/core/graphics/drawable/PropertyDrawable;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: DrawableProperties.kt */
    public static final class h extends Property<com.iqoption.core.graphics.a.e, Integer> {
        h(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            a((com.iqoption.core.graphics.a.e) obj, ((Number) obj2).intValue());
        }

        /* renamed from: b */
        public Integer get(com.iqoption.core.graphics.a.e eVar) {
            kotlin.jvm.internal.h.e(eVar, "object");
            return Integer.valueOf(eVar.Ud());
        }

        public void a(com.iqoption.core.graphics.a.e eVar, int i) {
            kotlin.jvm.internal.h.e(eVar, "object");
            eVar.dL(i);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/graphics/animation/Drawables$TRANSLATION_Y$1", "Landroid/util/Property;", "Lcom/iqoption/core/graphics/drawable/PropertyDrawable;", "", "get", "object", "(Lcom/iqoption/core/graphics/drawable/PropertyDrawable;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: DrawableProperties.kt */
    public static final class i extends Property<com.iqoption.core.graphics.a.e, Integer> {
        i(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            a((com.iqoption.core.graphics.a.e) obj, ((Number) obj2).intValue());
        }

        /* renamed from: b */
        public Integer get(com.iqoption.core.graphics.a.e eVar) {
            kotlin.jvm.internal.h.e(eVar, "object");
            return Integer.valueOf(eVar.Ue());
        }

        public void a(com.iqoption.core.graphics.a.e eVar, int i) {
            kotlin.jvm.internal.h.e(eVar, "object");
            eVar.dM(i);
        }
    }

    private b() {
    }

    public final Property<GradientDrawable, Integer> TC() {
        return aQL;
    }

    public final Property<Drawable, Integer> TD() {
        return ALPHA;
    }
}
