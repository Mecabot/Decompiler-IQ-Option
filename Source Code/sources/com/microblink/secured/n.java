package com.microblink.secured;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.params.MeteringRectangle;
import android.media.Image;
import android.media.ImageReader;
import android.support.annotation.UiThread;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.b;
import com.microblink.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(21)
/* compiled from: line */
public class n implements t {
    private ImageReader dWA;
    private com.microblink.hardware.a.a dWB;
    private com.microblink.hardware.a.a dWC;
    private Rect dWD;
    private float dWE;
    private Rect dWF;
    private Rect[] dWG;
    private int dWH;
    private int dWI;
    private int dWJ;
    private int dWK;
    private AtomicInteger dWL;
    private CaptureCallback dWM;
    private CameraCaptureSession dWm;
    private boolean dWn;
    private Builder dWo;
    private CaptureRequest dWp;
    protected y dWq;
    protected b dWr;
    protected v dWs;
    private ak dWt;
    private ak dWu;
    private boolean dWv;
    private aa dWw;
    private CameraType dWx;
    private boolean dWy;
    private a dWz;

    /* compiled from: line */
    class a {
        AtomicBoolean dWO;
        AtomicBoolean dWP;
        public AtomicBoolean dWQ;
    }

    protected void finalize() {
        dispose();
        super.finalize();
    }

    @UiThread
    public final void dispose() {
        if (!this.dWv) {
            this.dWt = null;
            this.dWq = null;
            this.dWs = null;
            this.dWu = null;
            this.dWx = null;
            this.dWw = null;
            this.dWv = true;
            if (this.dWA != null) {
                Log.f(this, "Late closing ImageReader", new Object[0]);
                this.dWA.close();
                this.dWA = null;
            }
        }
    }

    @UiThread
    public void aOG() {
        Log.e(this, "Shaking started", new Object[0]);
        if (this.dWC != null) {
            this.dWC.aOG();
        }
        if (this.dWB != null) {
            this.dWB.aOG();
        }
    }

    @UiThread
    public void aOH() {
        Log.e(this, "Shaking stopped", new Object[0]);
        if (this.dWC != null) {
            this.dWC.aOH();
        }
        if (this.dWB != null) {
            this.dWB.aOH();
        }
        if (this.dWs.dXz) {
            aPB();
        }
    }

    @UiThread
    public final void setZoomLevel(float f) {
        if (this.dWo != null && this.dWm != null) {
            this.dWF = R(f);
            this.dWo.set(CaptureRequest.SCALER_CROP_REGION, this.dWF);
            a(this.dWG);
        }
    }

    private Rect R(float f) {
        f = this.dWw.T(f);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        f = ((f * (this.dWE - 1.0f)) + 1.0f) * 2.0f;
        int round = Math.round(((float) this.dWD.width()) / f);
        int round2 = Math.round(((float) this.dWD.height()) / f);
        int width = this.dWD.width() / 2;
        int height = this.dWD.height() / 2;
        return new Rect(width - round, height - round2, width + round, height + round2);
    }

    private void aPz() {
        ImageReader imageReader = this.dWA;
        if (imageReader != null) {
            this.dWo.addTarget(imageReader.getSurface());
            this.dWp = this.dWo.build();
            this.dWo.removeTarget(imageReader.getSurface());
        }
    }

    private void aPA() {
        try {
            if (this.dWm != null) {
                Log.e(this, "Capturing another frame for recognition. Currently alive images: {}", Integer.valueOf(this.dWL.get()));
                this.dWm.capture(this.dWp, null, this.dWt.getHandler());
                return;
            }
            Log.e(this, "Session is already closed. Cannot capture another frame for recognition.", new Object[0]);
        } catch (Throwable e) {
            Log.a(this, e, "Failed to capture frame for recognition", new Object[0]);
        }
    }

    @UiThread
    public final void aPB() {
        if (!this.dWy) {
            Log.c(this, "Autofocus not supported, unable to trigger it", new Object[0]);
        } else if (this.dWo == null || this.dWm == null || this.dWt == null) {
            Log.c(this, "Cannot trigger autofocus. Camera session is closed!", new Object[0]);
        } else {
            this.dWt.o(new Runnable() {
                public final void run() {
                    if (n.this.dWo == null || n.this.dWm == null || !n.this.dWn || n.this.dWt == null) {
                        Log.c(n.this, "Cannot trigger autofocus. Camera session is closed!", new Object[0]);
                        return;
                    }
                    Log.a(n.this, "Triggering autofocus", new Object[0]);
                    if (n.this.dWs == null || !n.this.dWs.dXv) {
                        n.this.dWo.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
                    } else {
                        n.this.dWo.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(2));
                    }
                    try {
                        n.this.dWo.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
                        n.this.aPz();
                        n.this.dWm.setRepeatingRequest(n.this.dWo.build(), n.this.dWM, n.this.dWt.getHandler());
                        n.this.dWz.dWQ.set(false);
                        n.this.dWo.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
                        n.this.dWm.capture(n.this.dWo.build(), n.this.dWM, n.this.dWt.getHandler());
                        n.this.dWo.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
                    } catch (Exception unused) {
                        n.this.dWr.aOI();
                    }
                }
            });
        }
    }

    private Rect i(Rect rect) {
        float f = ((float) (rect.left + 1000)) / 2000.0f;
        float f2 = ((float) (rect.right + 1000)) / 2000.0f;
        return new Rect(this.dWF.left + Math.round(f * ((float) this.dWF.width())), this.dWF.top + Math.round((((float) (rect.top + 1000)) / 2000.0f) * ((float) this.dWF.height())), this.dWF.left + Math.round(f2 * ((float) this.dWF.width())), this.dWF.top + Math.round((((float) (rect.bottom + 1000)) / 2000.0f) * ((float) this.dWF.height())));
    }

    public final void a(Rect[] rectArr) {
        if (this.dWo != null && this.dWm != null && this.dWF != null && !this.dWw.aPH()) {
            Object obj;
            Object obj2;
            Object obj3 = null;
            if (rectArr != null) {
                if (this.dWH > 0) {
                    obj = new MeteringRectangle[(rectArr.length < this.dWH ? rectArr.length : this.dWH)];
                } else {
                    obj = null;
                }
                if (this.dWI > 0) {
                    obj2 = new MeteringRectangle[(rectArr.length < this.dWI ? rectArr.length : this.dWI)];
                } else {
                    obj2 = null;
                }
                if (this.dWJ > 0) {
                    obj3 = new MeteringRectangle[(rectArr.length < this.dWJ ? rectArr.length : this.dWJ)];
                }
                for (int i = 0; i < rectArr.length; i++) {
                    if (i < this.dWH) {
                        obj[i] = new MeteringRectangle(i(rectArr[i]), 1000);
                    }
                    if (i < this.dWI) {
                        obj2[i] = new MeteringRectangle(i(rectArr[i]), 1000);
                    }
                    if (i < this.dWJ) {
                        obj3[i] = new MeteringRectangle(i(rectArr[i]), 1000);
                    }
                }
                Object obj4 = obj;
                obj = obj3;
                obj3 = obj4;
            } else {
                obj = null;
                obj2 = obj;
            }
            if (obj3 != null) {
                this.dWo.set(CaptureRequest.CONTROL_AF_REGIONS, obj3);
            } else if (this.dWH > 0) {
                this.dWo.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(this.dWF, 0)});
            }
            if (obj2 != null) {
                this.dWo.set(CaptureRequest.CONTROL_AE_REGIONS, obj2);
            } else if (this.dWI > 0) {
                this.dWo.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(this.dWF, 0)});
            }
            if (obj != null) {
                this.dWo.set(CaptureRequest.CONTROL_AWB_REGIONS, obj);
            } else if (this.dWJ > 0) {
                this.dWo.set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{new MeteringRectangle(this.dWF, 0)});
            }
            this.dWG = rectArr;
            this.dWt.o(new Runnable() {
                public final void run() {
                    if (!(n.this.dWm == null || n.this.dWo == null)) {
                        try {
                            n.this.aPz();
                            n.this.dWm.setRepeatingRequest(n.this.dWo.build(), n.this.dWM, n.this.dWt.getHandler());
                        } catch (Throwable e) {
                            Log.b((Object) this, e, "Failed to set capture request with new parameters", new Object[0]);
                        } catch (Throwable e2) {
                            Log.b((Object) this, e2, "Failed to set capture request with new parameters - capture session is already closed", new Object[0]);
                        }
                    }
                }
            });
        }
    }

    public final CameraType getOpenedCameraType() {
        return this.dWx;
    }

    public final boolean aPC() {
        return this.dWK == 270;
    }

    public final void a(Image image) {
        image.close();
        Log.e(this, "[close] Active images: {}", Integer.valueOf(this.dWL.decrementAndGet()));
        if (this.dWL.decrementAndGet() == 0 && this.dWz.dWP.get()) {
            Log.f(this, "Closing image reader", new Object[0]);
            ImageReader imageReader = this.dWA;
            if (imageReader != null) {
                imageReader.close();
                this.dWA = null;
            }
            return;
        }
        if (!this.dWz.dWO.get()) {
            aPA();
        }
    }
}
