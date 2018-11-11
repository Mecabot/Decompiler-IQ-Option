package com.iqoption.core.ext;

import android.util.Property;
import android.view.View;
import android.widget.TextView;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\tR(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\tR(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\tR(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\t¨\u0006\u0018"}, aXE = {"Lcom/iqoption/core/ext/ViewProperties;", "", "()V", "RIGHT", "Landroid/util/Property;", "Landroid/view/View;", "", "RIGHT$annotations", "getRIGHT", "()Landroid/util/Property;", "TEXT_COLOR", "Landroid/widget/TextView;", "TEXT_COLOR$annotations", "getTEXT_COLOR", "TEXT_SIZE", "", "TEXT_SIZE$annotations", "getTEXT_SIZE", "VERTICAL_POSITION", "VERTICAL_POSITION$annotations", "getVERTICAL_POSITION", "WIDTH_RIGHT", "WIDTH_RIGHT$annotations", "getWIDTH_RIGHT", "core_release"})
/* compiled from: AndroidExtensions.kt */
public final class h {
    private static final Property<View, Integer> aPA = new a(Integer.TYPE, "right");
    public static final h aPB = new h();
    private static final Property<TextView, Integer> aPw = new b(Integer.TYPE, "textColor");
    private static final Property<TextView, Float> aPx = new c(Float.TYPE, "textSize");
    private static final Property<View, Integer> aPy = new d(Integer.TYPE, "verticalPosition");
    private static final Property<View, Integer> aPz = new e(Integer.TYPE, "widthRight");

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/ext/ViewProperties$RIGHT$1", "Landroid/util/Property;", "Landroid/view/View;", "", "get", "object", "(Landroid/view/View;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends Property<View, Integer> {
        a(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            i((View) obj, ((Number) obj2).intValue());
        }

        /* renamed from: O */
        public Integer get(View view) {
            kotlin.jvm.internal.h.e(view, "object");
            return Integer.valueOf(view.getRight());
        }

        public void i(View view, int i) {
            kotlin.jvm.internal.h.e(view, "object");
            view.setRight(i);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/ext/ViewProperties$TEXT_COLOR$1", "Landroid/util/Property;", "Landroid/widget/TextView;", "", "get", "object", "(Landroid/widget/TextView;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class b extends Property<TextView, Integer> {
        b(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            b((TextView) obj, ((Number) obj2).intValue());
        }

        /* renamed from: i */
        public Integer get(TextView textView) {
            kotlin.jvm.internal.h.e(textView, "object");
            return Integer.valueOf(textView.getCurrentTextColor());
        }

        public void b(TextView textView, int i) {
            kotlin.jvm.internal.h.e(textView, "object");
            textView.setTextColor(i);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/ext/ViewProperties$TEXT_SIZE$1", "Landroid/util/Property;", "Landroid/widget/TextView;", "", "get", "object", "(Landroid/widget/TextView;)Ljava/lang/Float;", "set", "", "value", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class c extends Property<TextView, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            a((TextView) obj, ((Number) obj2).floatValue());
        }

        /* renamed from: j */
        public Float get(TextView textView) {
            kotlin.jvm.internal.h.e(textView, "object");
            return Float.valueOf(textView.getTextSize());
        }

        public void a(TextView textView, float f) {
            kotlin.jvm.internal.h.e(textView, "object");
            textView.setTextSize(0, f);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/ext/ViewProperties$VERTICAL_POSITION$1", "Landroid/util/Property;", "Landroid/view/View;", "", "get", "object", "(Landroid/view/View;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class d extends Property<View, Integer> {
        d(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            i((View) obj, ((Number) obj2).intValue());
        }

        /* renamed from: O */
        public Integer get(View view) {
            kotlin.jvm.internal.h.e(view, "object");
            return Integer.valueOf(view.getTop());
        }

        public void i(View view, int i) {
            kotlin.jvm.internal.h.e(view, "object");
            int height = view.getHeight();
            view.setTop(i);
            view.setBottom(i + height);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, aXE = {"com/iqoption/core/ext/ViewProperties$WIDTH_RIGHT$1", "Landroid/util/Property;", "Landroid/view/View;", "", "get", "object", "(Landroid/view/View;)Ljava/lang/Integer;", "set", "", "value", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class e extends Property<View, Integer> {
        e(Class cls, String str) {
            super(cls, str);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            i((View) obj, ((Number) obj2).intValue());
        }

        /* renamed from: O */
        public Integer get(View view) {
            kotlin.jvm.internal.h.e(view, "object");
            return Integer.valueOf(view.getWidth());
        }

        public void i(View view, int i) {
            kotlin.jvm.internal.h.e(view, "object");
            view.setRight(view.getLeft() + i);
        }
    }

    private h() {
    }

    public static final Property<TextView, Integer> SY() {
        return aPw;
    }
}
