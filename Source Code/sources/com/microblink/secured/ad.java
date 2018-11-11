package com.microblink.secured;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.UiThread;
import com.microblink.hardware.a.a;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.b;
import com.microblink.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"NewApi"})
/* compiled from: line */
public abstract class ad implements t {
    protected a dWB;
    private int dWK;
    protected y dWq;
    protected b dWr;
    protected v dWs;
    ak dWt;
    protected aa dWw;
    protected Camera dXY;
    ab dXZ;
    CameraType dXw;
    private j dYa;
    protected boolean dYb;
    protected o dYc;
    private Size dYd;
    private AtomicBoolean dYe;
    private t.a dYf;
    private boolean dYg;

    protected abstract PreviewCallback aPU();

    protected void finalize() {
        dispose();
        super.finalize();
    }

    @UiThread
    public void dispose() {
        if (this.dYe.compareAndSet(false, true)) {
            if (this.dYc != null) {
                o oVar = this.dYc;
                oVar.dWR.dispose();
                oVar.dWR = null;
            }
            this.dYc = null;
            if (this.dXZ != null) {
                this.dXZ.dispose();
            }
            this.dXZ = null;
            this.dWq = null;
            this.dWs = null;
            this.dWr = null;
            this.dYa = null;
            this.dWB = null;
            this.dYd = null;
            this.dXw = null;
            this.dWw = null;
            this.dYf = null;
        }
    }

    @UiThread
    public void aOG() {
        Log.e(this, "shaking started, this = {}, focus manager: {}, camera queue: {}", this, this.dXZ, this.dWt);
        this.dYb = true;
        if (this.dXZ != null) {
            this.dWt.o(new Runnable() {
                public final void run() {
                    ab a = ad.this.dXZ;
                    if (a != null) {
                        a.aPS();
                    }
                }
            });
        }
        if (this.dWB != null) {
            this.dWB.aOG();
        }
    }

    @UiThread
    public void aOH() {
        Log.e(this, "shaking stopped, this = {}, focus manager: {}, camera queue: {}", this, this.dXZ, this.dWt);
        if (this.dXZ != null) {
            this.dWt.o(new Runnable() {
                public final void run() {
                    ab a = ad.this.dXZ;
                    if (a != null) {
                        a.aPR();
                        if (!a.aPT() || ad.this.dWs.dXz) {
                            a.aPQ();
                        }
                        a.fO(false);
                    }
                }
            });
        }
        this.dYb = false;
        if (this.dWB != null) {
            this.dWB.aOH();
        }
    }

    protected final void n(Runnable runnable) {
        if (this.dWt != null) {
            if (Looper.myLooper() == this.dWt.getHandler().getLooper()) {
                runnable.run();
                return;
            }
            this.dWt.o(runnable);
        }
    }

    public void a(final q qVar) {
        n(new Runnable() {
            public final void run() {
                if (ad.this.dXY == null || ad.this.dYg) {
                    Log.c(ad.this, "Camera is released, cannot request another frame", new Object[0]);
                    return;
                }
                if (!ad.this.aPV()) {
                    ad.this.dXY.setOneShotPreviewCallback(ad.this.aPU());
                } else if (qVar.aPD() != null) {
                    ad.this.dXY.addCallbackBuffer(qVar.aPD());
                }
                ab a = ad.this.dXZ;
                if (a != null) {
                    a.aPP();
                }
            }
        });
    }

    @SuppressLint({"ObsoleteSdkInt"})
    protected boolean aPV() {
        return VERSION.SDK_INT >= 8;
    }

    private void a(float f, Parameters parameters) {
        f = this.dWw.T(f);
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        parameters.setZoom(Math.round(f * ((float) parameters.getMaxZoom())));
    }

    @UiThread
    public final void setZoomLevel(final float f) {
        this.dWt.o(new Runnable() {
            public final void run() {
                if (ad.this.dXY != null) {
                    try {
                        Parameters parameters = ad.this.dXY.getParameters();
                        ad.this.a(f, parameters);
                        ad.this.dXY.setParameters(parameters);
                    } catch (RuntimeException unused) {
                        Log.b(ad.this, "Failed to set zoom level to {}", Float.valueOf(f));
                    }
                }
            }
        });
    }

    public final CameraType getOpenedCameraType() {
        return this.dXw;
    }

    public final boolean aPC() {
        return this.dWK == 270;
    }
}
