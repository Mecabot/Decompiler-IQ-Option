package com.microblink.secured;

import android.support.annotation.UiThread;
import com.microblink.hardware.camera.CameraType;

/* compiled from: line */
public interface t extends com.microblink.hardware.a.a {

    /* compiled from: line */
    public interface a {
    }

    boolean aPC();

    CameraType getOpenedCameraType();

    @UiThread
    void setZoomLevel(float f);
}
