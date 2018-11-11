package com.iqoption.core.ui.widget.gl;

import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.iqoption.core.ui.widget.b.m;

/* compiled from: GLGraphView */
public final class b extends com.iqoption.core.ui.widget.b {
    private a beG;

    /* compiled from: GLGraphView */
    public interface a extends m {
        void ZE();

        void ZF();

        boolean onTouchEvent(@NonNull MotionEvent motionEvent);
    }

    public void setController(@NonNull a aVar) {
        this.beG = aVar;
        setRenderer(aVar);
        setRenderMode(1);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.beG == null) {
            return false;
        }
        if (this.beG.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent)) {
            z = true;
        }
        return z;
    }

    public void onResume() {
        super.onResume();
        if (this.beG != null) {
            this.beG.ZE();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.beG != null) {
            this.beG.ZF();
        }
    }
}
