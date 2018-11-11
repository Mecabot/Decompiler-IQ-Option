package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzdlf;

@Hide
final class zzc {
    static Rect zza(Text text) {
        int i = Integer.MIN_VALUE;
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i4 = Integer.MIN_VALUE;
        for (Point point : text.getCornerPoints()) {
            i2 = Math.min(i2, point.x);
            i = Math.max(i, point.x);
            i3 = Math.min(i3, point.y);
            i4 = Math.max(i4, point.y);
        }
        return new Rect(i2, i3, i, i4);
    }

    static Point[] zza(zzdlf zzdlf) {
        r0 = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzdlf.zzlif));
        double cos = Math.cos(Math.toRadians((double) zzdlf.zzlif));
        r0[0] = new Point(zzdlf.left, zzdlf.top);
        r0[1] = new Point((int) (((double) zzdlf.left) + (((double) zzdlf.width) * cos)), (int) (((double) zzdlf.top) + (((double) zzdlf.width) * sin)));
        r0[2] = new Point((int) (((double) r0[1].x) - (((double) zzdlf.height) * sin)), (int) (((double) r0[1].y) + (((double) zzdlf.height) * cos)));
        r0[3] = new Point(r0[0].x + (r0[2].x - r0[1].x), r0[0].y + (r0[2].y - r0[1].y));
        return r0;
    }
}
