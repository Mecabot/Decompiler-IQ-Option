package com.iqoption.core.graphics.a.a;

import android.graphics.drawable.Drawable;
import android.util.StateSet;
import com.iqoption.core.graphics.a.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0015B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0005\"\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u0018\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0016"}, aXE = {"Lcom/iqoption/core/graphics/drawable/stateanimator/StateControlDrawable;", "Lcom/iqoption/core/graphics/drawable/DrawableWrapper;", "wrapped", "Landroid/graphics/drawable/Drawable;", "stateSpecs", "", "", "controllers", "Lcom/iqoption/core/graphics/drawable/stateanimator/StateControlDrawable$Controller;", "(Landroid/graphics/drawable/Drawable;[[I[Lcom/iqoption/core/graphics/drawable/stateanimator/StateControlDrawable$Controller;)V", "[Lcom/iqoption/core/graphics/drawable/stateanimator/StateControlDrawable$Controller;", "curSpecIndex", "", "[[I", "findSpecIndex", "state", "isStateful", "", "onStateChange", "setState", "stateSet", "Controller", "core_release"})
/* compiled from: StateControlDrawable.kt */
public class d extends b {
    private int aRX = -1;
    private final int[][] aRY;
    private final a[] aRZ;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, aXE = {"Lcom/iqoption/core/graphics/drawable/stateanimator/StateControlDrawable$Controller;", "", "animate", "", "fromSpecIndex", "", "toSpecIndex", "init", "specIndex", "core_release"})
    /* compiled from: StateControlDrawable.kt */
    public interface a {
        void ag(int i, int i2);

        void init(int i);
    }

    public boolean isStateful() {
        return true;
    }

    public d(Drawable drawable, int[][] iArr, a... aVarArr) {
        h.e(drawable, "wrapped");
        h.e(iArr, "stateSpecs");
        h.e(aVarArr, "controllers");
        super(drawable);
        this.aRY = iArr;
        this.aRZ = aVarArr;
    }

    public boolean setState(int[] iArr) {
        h.e(iArr, "stateSet");
        return i(iArr) || super.setState(iArr);
    }

    protected boolean onStateChange(int[] iArr) {
        h.e(iArr, "state");
        int j = j(iArr);
        int i = 0;
        if (this.aRX == j) {
            return false;
        }
        int i2 = this.aRX;
        if (i2 == -1) {
            a[] aVarArr = this.aRZ;
            int length = aVarArr.length;
            while (i < length) {
                aVarArr[i].init(j);
                i++;
            }
        } else {
            a[] aVarArr2 = this.aRZ;
            int length2 = aVarArr2.length;
            while (i < length2) {
                aVarArr2[i].ag(i2, j);
                i++;
            }
        }
        this.aRX = j;
        return true;
    }

    private final int j(int[] iArr) {
        Object[] objArr = (Object[]) this.aRY;
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            if (StateSet.stateSetMatches((int[]) objArr[i], iArr)) {
                return i2;
            }
            i++;
            i2 = i3;
        }
        return ((Object[]) this.aRY).length - 1;
    }
}
