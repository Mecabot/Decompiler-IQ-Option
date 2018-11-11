package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: ViewIndexingTrigger */
public class d implements SensorEventListener {
    private a Aa;

    /* compiled from: ViewIndexingTrigger */
    public interface a {
        void kB();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void a(a aVar) {
        this.Aa = aVar;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.Aa != null) {
            float f = sensorEvent.values[0];
            double d = (double) (f / 9.80665f);
            double d2 = (double) (sensorEvent.values[1] / 9.80665f);
            double d3 = (double) (sensorEvent.values[2] / 9.80665f);
            if (Math.sqrt(((d * d) + (d2 * d2)) + (d3 * d3)) > 2.299999952316284d) {
                this.Aa.kB();
            }
        }
    }
}
