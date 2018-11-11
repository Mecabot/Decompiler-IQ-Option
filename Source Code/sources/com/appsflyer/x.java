package com.appsflyer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class x implements SensorEventListener {
    @NonNull
    private final String pJ;
    @NonNull
    private final String pr;
    private final float[][] qD = new float[2][];
    private final long[] qE = new long[2];
    private final int qF;
    private double qG;
    private long qH;
    private final int qx;

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    private x(int i, @Nullable String str, @Nullable String str2) {
        this.qx = i;
        if (str == null) {
            str = "";
        }
        this.pr = str;
        if (str2 == null) {
            str2 = "";
        }
        this.pJ = str2;
        this.qF = ((((i + 31) * 31) + this.pr.hashCode()) * 31) + this.pJ.hashCode();
    }

    static x a(Sensor sensor) {
        return new x(sensor.getType(), sensor.getName(), sensor.getVendor());
    }

    private static double a(@NonNull float[] fArr, @NonNull float[] fArr2) {
        double d = 0.0d;
        for (int i = 0; i < Math.min(fArr.length, fArr2.length); i++) {
            d += StrictMath.pow((double) (fArr[i] - fArr2[i]), 2.0d);
        }
        return Math.sqrt(d);
    }

    @NonNull
    private static List<Float> b(@NonNull float[] fArr) {
        List<Float> arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(Float.valueOf(valueOf));
        }
        return arrayList;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (!(sensorEvent == null || sensorEvent.values == null)) {
            Sensor sensor = sensorEvent.sensor;
            Object obj = (sensor == null || sensor.getName() == null || sensor.getVendor() == null) ? null : 1;
            if (obj != null) {
                int type = sensorEvent.sensor.getType();
                String name = sensorEvent.sensor.getName();
                String vendor = sensorEvent.sensor.getVendor();
                long j = sensorEvent.timestamp;
                float[] fArr = sensorEvent.values;
                if (b(type, name, vendor)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    float[] fArr2 = this.qD[0];
                    if (fArr2 == null) {
                        this.qD[0] = Arrays.copyOf(fArr, fArr.length);
                        this.qE[0] = currentTimeMillis;
                        return;
                    }
                    float[] fArr3 = this.qD[1];
                    if (fArr3 == null) {
                        fArr = Arrays.copyOf(fArr, fArr.length);
                        this.qD[1] = fArr;
                        this.qE[1] = currentTimeMillis;
                        this.qG = a(fArr2, fArr);
                    } else if (50000000 <= j - this.qH) {
                        this.qH = j;
                        if (Arrays.equals(fArr3, fArr)) {
                            this.qE[1] = currentTimeMillis;
                            return;
                        }
                        double a = a(fArr2, fArr);
                        if (a > this.qG) {
                            this.qD[1] = Arrays.copyOf(fArr, fArr.length);
                            this.qE[1] = currentTimeMillis;
                            this.qG = a;
                        }
                    }
                }
            }
        }
    }

    final void i(@NonNull Map<x, Map<String, Object>> map) {
        a((Map) map, true);
    }

    public final void g(Map<x, Map<String, Object>> map) {
        a((Map) map, false);
    }

    private boolean b(int i, @NonNull String str, @NonNull String str2) {
        return this.qx == i && this.pr.equals(str) && this.pJ.equals(str2);
    }

    @NonNull
    private Map<String, Object> fU() {
        Map<String, Object> hashMap = new HashMap(7);
        hashMap.put("sT", Integer.valueOf(this.qx));
        hashMap.put("sN", this.pr);
        hashMap.put("sV", this.pJ);
        float[] fArr = this.qD[0];
        if (fArr != null) {
            hashMap.put("sVS", b(fArr));
        }
        fArr = this.qD[1];
        if (fArr != null) {
            hashMap.put("sVE", b(fArr));
        }
        return hashMap;
    }

    private void fs() {
        for (int i = 0; i < 2; i++) {
            this.qD[i] = null;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            this.qE[i2] = 0;
        }
        this.qG = 0.0d;
        this.qH = 0;
    }

    public final int hashCode() {
        return this.qF;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return b(xVar.qx, xVar.pr, xVar.pJ);
    }

    private void a(@NonNull Map<x, Map<String, Object>> map, boolean z) {
        int i = 0;
        if (this.qD[0] != null) {
            i = 1;
        }
        if (i != 0) {
            map.put(this, fU());
            if (z) {
                fs();
            }
        } else if (!map.containsKey(this)) {
            map.put(this, fU());
        }
    }
}
