package com.appsflyer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class z {
    private static final BitSet qJ = new BitSet(6);
    private static final Handler qK = new Handler(Looper.getMainLooper());
    private static volatile z qL;
    final Handler qM;
    private final Map<x, x> qN = new HashMap(qJ.size());
    private final Map<x, Map<String, Object>> qO = new HashMap(qJ.size());
    private final SensorManager qP;
    boolean qQ;
    private boolean qR;
    final Runnable qS = new Runnable() {
        private static String pZ;
        private static String pr;

        AnonymousClass1() {
        }

        public final void run() {
            synchronized (z.this.qr) {
                z.this.fO();
                z.this.qM.postDelayed(z.this.qT, 1800000);
            }
        }

        static void aj(String str) {
            pr = str;
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                if (i == 0 || i == str.length() - 1) {
                    stringBuilder.append(str.charAt(i));
                } else {
                    stringBuilder.append("*");
                }
                i++;
            }
            pZ = stringBuilder.toString();
        }

        static void ah(String str) {
            if (pr == null) {
                AnonymousClass1.aj(i.fF().getString("AppsFlyerKey"));
            }
            if (pr != null && str.contains(pr)) {
                AFLogger.an(str.replace(pr, pZ));
            }
        }
    };
    final Runnable qT = new Runnable() {
        public final void run() {
            synchronized (z.this.qr) {
                z.this.ft();
                z.this.qM.postDelayed(z.this.qS, 500);
                z.this.qQ = true;
            }
        }
    };
    final Runnable qU = new Runnable() {
        public final void run() {
            synchronized (z.this.qr) {
                if (z.this.qQ) {
                    z.this.qM.removeCallbacks(z.this.qT);
                    z.this.qM.removeCallbacks(z.this.qS);
                    z.this.fO();
                    z.this.qQ = false;
                }
            }
        }
    };
    final Object qr = new Object();

    static {
        qJ.set(1);
        qJ.set(2);
        qJ.set(4);
    }

    private z(@NonNull SensorManager sensorManager, Handler handler) {
        this.qP = sensorManager;
        this.qM = handler;
    }

    static z G(Context context) {
        return a((SensorManager) context.getApplicationContext().getSystemService("sensor"), qK);
    }

    private static z a(SensorManager sensorManager, Handler handler) {
        if (qL == null) {
            synchronized (z.class) {
                if (qL == null) {
                    qL = new z(sensorManager, handler);
                }
            }
        }
        return qL;
    }

    final void ft() {
        try {
            for (Sensor sensor : this.qP.getSensorList(-1)) {
                int type = sensor.getType();
                Object obj = (type < 0 || !qJ.get(type)) ? null : 1;
                if (obj != null) {
                    x a = x.a(sensor);
                    if (!this.qN.containsKey(a)) {
                        this.qN.put(a, a);
                    }
                    this.qP.registerListener((SensorEventListener) this.qN.get(a), sensor, 0);
                }
            }
        } catch (Throwable unused) {
            this.qR = true;
        }
    }

    final void fO() {
        try {
            if (!this.qN.isEmpty()) {
                for (x xVar : this.qN.values()) {
                    this.qP.unregisterListener(xVar);
                    xVar.i(this.qO);
                }
            }
        } catch (Throwable unused) {
            this.qR = false;
        }
    }

    @NonNull
    final List<Map<String, Object>> fV() {
        synchronized (this.qr) {
            if (!this.qN.isEmpty() && this.qR) {
                for (x g : this.qN.values()) {
                    g.g(this.qO);
                }
            }
            if (this.qO.isEmpty()) {
                List<Map<String, Object>> emptyList = Collections.emptyList();
                return emptyList;
            }
            List arrayList = new ArrayList(this.qO.values());
            return arrayList;
        }
    }
}
