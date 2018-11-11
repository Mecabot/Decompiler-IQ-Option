package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzdlf;
import com.google.android.gms.internal.zzdll;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzdll[] zzlhz;
    private List<Line> zzlia;
    private String zzlib;
    private Rect zzlic;

    @Hide
    TextBlock(SparseArray<zzdll> sparseArray) {
        this.zzlhz = new zzdll[sparseArray.size()];
        for (int i = 0; i < this.zzlhz.length; i++) {
            this.zzlhz[i] = (zzdll) sparseArray.valueAt(i);
        }
    }

    private static Point[] zza(int i, int i2, int i3, int i4, zzdlf zzdlf) {
        int i5 = zzdlf.left;
        int i6 = zzdlf.top;
        double sin = Math.sin(Math.toRadians((double) zzdlf.zzlif));
        double cos = Math.cos(Math.toRadians((double) zzdlf.zzlif));
        r6 = new Point[4];
        int i7 = 0;
        r6[0] = new Point(i, i2);
        r6[1] = new Point(i3, i2);
        r6[2] = new Point(i3, i4);
        r6[3] = new Point(i, i4);
        while (i7 < 4) {
            i2 = (int) ((((double) r6[i7].x) * sin) + (((double) r6[i7].y) * cos));
            r6[i7].x = (int) ((((double) r6[i7].x) * cos) - (((double) r6[i7].y) * sin));
            r6[i7].y = i2;
            r6[i7].offset(i5, i6);
            i7++;
        }
        return r6;
    }

    public Rect getBoundingBox() {
        if (this.zzlic == null) {
            this.zzlic = zzc.zza((Text) this);
        }
        return this.zzlic;
    }

    public List<? extends Text> getComponents() {
        int i = 0;
        if (this.zzlhz.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzlia == null) {
            this.zzlia = new ArrayList(this.zzlhz.length);
            zzdll[] zzdllArr = this.zzlhz;
            int length = zzdllArr.length;
            while (i < length) {
                this.zzlia.add(new Line(zzdllArr[i]));
                i++;
            }
        }
        return this.zzlia;
    }

    public Point[] getCornerPoints() {
        if (this.cornerPoints == null) {
            Point[] pointArr;
            int i = 0;
            if (this.zzlhz.length == 0) {
                pointArr = new Point[0];
            } else {
                int i2;
                int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                int i4 = 0;
                int i5 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                int i6 = Integer.MIN_VALUE;
                int i7 = Integer.MIN_VALUE;
                while (i4 < this.zzlhz.length) {
                    zzdlf zzdlf = this.zzlhz[i4].zzlih;
                    zzdlf zzdlf2 = this.zzlhz[i].zzlih;
                    int i8 = -zzdlf2.left;
                    int i9 = -zzdlf2.top;
                    double sin = Math.sin(Math.toRadians((double) zzdlf2.zzlif));
                    double cos = Math.cos(Math.toRadians((double) zzdlf2.zzlif));
                    Point[] pointArr2 = new Point[4];
                    i2 = i3;
                    pointArr2[0] = new Point(zzdlf.left, zzdlf.top);
                    pointArr2[0].offset(i8, i9);
                    i = (int) ((((double) pointArr2[0].x) * cos) + (((double) pointArr2[0].y) * sin));
                    int i10 = (int) ((((double) (-pointArr2[0].x)) * sin) + (((double) pointArr2[0].y) * cos));
                    pointArr2[0].x = i;
                    pointArr2[0].y = i10;
                    pointArr2[1] = new Point(zzdlf.width + i, i10);
                    pointArr2[2] = new Point(zzdlf.width + i, zzdlf.height + i10);
                    pointArr2[3] = new Point(i, i10 + zzdlf.height);
                    i3 = i2;
                    for (i = 0; i < 4; i++) {
                        Point point = pointArr2[i];
                        i3 = Math.min(i3, point.x);
                        i6 = Math.max(i6, point.x);
                        i5 = Math.min(i5, point.y);
                        i7 = Math.max(i7, point.y);
                    }
                    i4++;
                    i = 0;
                }
                i2 = i3;
                pointArr = zza(i3, i5, i6, i7, this.zzlhz[0].zzlih);
            }
            this.cornerPoints = pointArr;
        }
        return this.cornerPoints;
    }

    public String getLanguage() {
        if (this.zzlib != null) {
            return this.zzlib;
        }
        HashMap hashMap = new HashMap();
        for (zzdll zzdll : this.zzlhz) {
            hashMap.put(zzdll.zzlib, Integer.valueOf((hashMap.containsKey(zzdll.zzlib) ? ((Integer) hashMap.get(zzdll.zzlib)).intValue() : 0) + 1));
        }
        this.zzlib = (String) ((Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        if (this.zzlib == null || this.zzlib.isEmpty()) {
            this.zzlib = "und";
        }
        return this.zzlib;
    }

    public String getValue() {
        if (this.zzlhz.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(this.zzlhz[0].zzlik);
        for (int i = 1; i < this.zzlhz.length; i++) {
            stringBuilder.append("\n");
            stringBuilder.append(this.zzlhz[i].zzlik);
        }
        return stringBuilder.toString();
    }
}
