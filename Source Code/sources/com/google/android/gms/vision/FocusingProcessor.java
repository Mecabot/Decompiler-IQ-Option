package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;

public abstract class FocusingProcessor<T> implements Processor<T> {
    private Detector<T> zzlfj;
    private Tracker<T> zzlfy;
    private int zzlfz = 3;
    private boolean zzlga = false;
    private int zzlgb;
    private int zzlgc = 0;

    public FocusingProcessor(Detector<T> detector, Tracker<T> tracker) {
        this.zzlfj = detector;
        this.zzlfy = tracker;
    }

    @Hide
    public void receiveDetections(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzlgc == this.zzlfz) {
                this.zzlfy.onDone();
                this.zzlga = false;
            } else {
                this.zzlfy.onMissing(detections);
            }
            this.zzlgc++;
            return;
        }
        this.zzlgc = 0;
        if (this.zzlga) {
            Object obj = detectedItems.get(this.zzlgb);
            if (obj != null) {
                this.zzlfy.onUpdate(detections, obj);
                return;
            } else {
                this.zzlfy.onDone();
                this.zzlga = false;
            }
        }
        int selectFocus = selectFocus(detections);
        Object obj2 = detectedItems.get(selectFocus);
        if (obj2 == null) {
            StringBuilder stringBuilder = new StringBuilder(35);
            stringBuilder.append("Invalid focus selected: ");
            stringBuilder.append(selectFocus);
            Log.w("FocusingProcessor", stringBuilder.toString());
            return;
        }
        this.zzlga = true;
        this.zzlgb = selectFocus;
        this.zzlfj.setFocus(this.zzlgb);
        this.zzlfy.onNewItem(this.zzlgb, obj2);
        this.zzlfy.onUpdate(detections, obj2);
    }

    public void release() {
        this.zzlfy.onDone();
    }

    public abstract int selectFocus(Detections<T> detections);

    @Hide
    protected final void zzfl(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(28);
            stringBuilder.append("Invalid max gap: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.zzlfz = i;
    }
}
