package com.iqoption.tutorial.utils;

import android.graphics.Point;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, aXE = {"Lcom/iqoption/tutorial/utils/TrainingPosition;", "", "pointerStart", "Landroid/graphics/Point;", "pointerEnd", "dialog", "(Landroid/graphics/Point;Landroid/graphics/Point;Landroid/graphics/Point;)V", "getDialog", "()Landroid/graphics/Point;", "getPointerEnd", "getPointerStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TutorialOptions.kt */
public final class b {
    private final Point duG;
    private final Point duH;
    private final Point duI;

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.duI, r3.duI) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.tutorial.utils.b;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.tutorial.utils.b) r3;
        r0 = r2.duG;
        r1 = r3.duG;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.duH;
        r1 = r3.duH;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.duI;
        r3 = r3.duI;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r3 = 0;
        return r3;
    L_0x0029:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.tutorial.utils.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Point point = this.duG;
        int i = 0;
        int hashCode = (point != null ? point.hashCode() : 0) * 31;
        Point point2 = this.duH;
        hashCode = (hashCode + (point2 != null ? point2.hashCode() : 0)) * 31;
        point2 = this.duI;
        if (point2 != null) {
            i = point2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrainingPosition(pointerStart=");
        stringBuilder.append(this.duG);
        stringBuilder.append(", pointerEnd=");
        stringBuilder.append(this.duH);
        stringBuilder.append(", dialog=");
        stringBuilder.append(this.duI);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(Point point, Point point2, Point point3) {
        h.e(point, "pointerStart");
        h.e(point2, "pointerEnd");
        h.e(point3, "dialog");
        this.duG = point;
        this.duH = point2;
        this.duI = point3;
    }

    public final Point aFT() {
        return this.duG;
    }

    public final Point aFU() {
        return this.duH;
    }

    public final Point aFV() {
        return this.duI;
    }
}
