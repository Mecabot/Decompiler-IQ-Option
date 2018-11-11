package com.microblink.secured;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.microblink.hardware.a.a;
import com.microblink.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: line */
public final class y implements SensorEventListener {
    private static float dXD = 0.47f;
    private static float dXE = 0.2f;
    private static float dXF = 0.66f;
    private s dXG;
    public a dXH;
    public AtomicBoolean dXI;
    private int dXJ;
    private long dXK;

    private float aPE() {
        float x = this.dXG.getX();
        float y = this.dXG.getY();
        float z = this.dXG.getZ();
        return (float) Math.sqrt((double) (((x * x) + (y * y)) + (z * z)));
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
        Log.f(this, "Accelerometer accuracy has changed", new Object[0]);
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        e(sensorEvent.values);
    }

    private void e(float[] fArr) {
        if (this.dXK >= 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.dXK;
            if (currentTimeMillis > 0) {
                this.dXJ = (int) ((((float) this.dXJ) * dXF) + (((float) (currentTimeMillis * 1000)) * (1.0f - dXF)));
                this.dXG.S((((float) this.dXJ) / 1000.0f) / 1000.0f);
            }
        }
        boolean z = true;
        this.dXG.g(fArr[0], fArr[1], fArr[2]);
        Object obj = (this.dXI.get() || aPE() <= dXD) ? null : 1;
        if (obj != null) {
            this.dXI.set(true);
            this.dXH.aOG();
        } else {
            if (!this.dXI.get() || aPE() >= dXE) {
                z = false;
            }
            if (z) {
                this.dXI.set(false);
                this.dXH.aOH();
            }
        }
        this.dXK = System.currentTimeMillis();
    }
}
