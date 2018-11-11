package com.iqoption.core.graphics.a;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.DimenRes;
import com.iqoption.core.ext.a;
import com.iqoption.core.f;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a\u001a\u0010\b\u001a\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a\"\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, aXE = {"oval", "Landroid/graphics/drawable/ShapeDrawable;", "width", "", "height", "w", "", "h", "rect", "roundedRect", "radii", "", "core_release"})
/* compiled from: Factories.kt */
public final class c {
    public static /* synthetic */ ShapeDrawable b(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        return af(i, i2);
    }

    public static final ShapeDrawable af(@DimenRes int i, @DimenRes int i2) {
        return h(a.j(f.RR(), i), a.j(f.RR(), i2));
    }

    public static final ShapeDrawable h(float f, float f2) {
        OvalShape ovalShape = new OvalShape();
        ovalShape.resize(f, f2);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.setIntrinsicWidth((int) f);
        shapeDrawable.setIntrinsicHeight((int) f2);
        return shapeDrawable;
    }
}
