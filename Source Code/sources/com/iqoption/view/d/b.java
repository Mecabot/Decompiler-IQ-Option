package com.iqoption.view.d;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: OnClickDelayView */
public abstract class b implements OnClickListener {
    private long doZ = 300;
    private long dpa;

    public abstract void q(View view);

    public b(long j) {
        this.doZ = j;
    }

    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - this.dpa >= this.doZ) {
            this.dpa = SystemClock.elapsedRealtime();
            q(view);
        }
    }
}
