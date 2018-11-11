package com.rd.draw.a;

import android.support.annotation.NonNull;
import android.util.Pair;
import android.view.View.MeasureSpec;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.a;

/* compiled from: MeasureController */
public class c {
    public Pair<Integer, Integer> a(@NonNull a aVar, int i, int i2) {
        a aVar2 = aVar;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int count = aVar.getCount();
        int radius = aVar.getRadius();
        int aSS = aVar.aSS();
        int padding = aVar.getPadding();
        int paddingLeft = aVar.getPaddingLeft();
        int paddingTop = aVar.getPaddingTop();
        int paddingRight = aVar.getPaddingRight();
        int paddingBottom = aVar.getPaddingBottom();
        radius *= 2;
        Orientation aTh = aVar.aTh();
        int i3 = 0;
        if (count != 0) {
            count = ((radius * count) + ((aSS * 2) * count)) + (padding * (count - 1));
            radius += aSS;
            if (aTh == Orientation.HORIZONTAL) {
                int i4 = radius;
                radius = count;
                count = i4;
            }
        } else {
            count = 0;
            radius = 0;
        }
        if (aVar.aTi() == AnimationType.DROP) {
            if (aTh == Orientation.HORIZONTAL) {
                count *= 2;
            } else {
                radius *= 2;
            }
        }
        paddingLeft += paddingRight;
        paddingTop += paddingBottom;
        if (aTh == Orientation.HORIZONTAL) {
            radius += paddingLeft;
            count += paddingTop;
        } else {
            radius += paddingLeft;
            count += paddingTop;
        }
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(radius, size) : radius;
        }
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(count, size2);
            } else {
                size2 = count;
            }
        }
        if (size < 0) {
            size = 0;
        }
        if (size2 >= 0) {
            i3 = size2;
        }
        aVar2.setWidth(size);
        aVar2.setHeight(i3);
        return new Pair(Integer.valueOf(size), Integer.valueOf(i3));
    }
}
