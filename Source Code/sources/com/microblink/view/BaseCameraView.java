package com.microblink.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.VideoResolutionPreset;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.secured.k;
import com.microblink.secured.t;
import com.microblink.secured.v;
import com.microblink.util.Log;
import com.microblink.view.a.a;

/* compiled from: line */
public abstract class BaseCameraView extends ViewGroup {
    private RectF dUF;
    private Orientation dUG;
    protected a dYU;
    protected CameraViewState dYV;
    protected a dYW;
    protected int dYX;
    protected b dYY;
    protected int dYZ;
    protected CameraAspectMode dZa;
    protected Orientation dZb;
    public com.microblink.hardware.orientation.a dZc;
    private t dZd;
    private c dZe;
    private com.microblink.hardware.a.a dZf;
    private v dZg;
    private int dZh;
    private int dZi;
    private float dZj;
    private boolean dZk;
    private boolean dZl;
    private d dZm;

    /* compiled from: line */
    public enum CameraViewState {
        DESTROYED,
        CREATED,
        STARTED,
        RESUMED
    }

    private static float U(float f) {
        return f > 1.0f ? 1.0f : f < 0.0f ? 0.0f : f;
    }

    protected Activity getHostActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    protected v getCameraFactorySettings() {
        return this.dZg;
    }

    private int getCameraRotation() {
        switch (this.dYZ) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 8:
                return 180;
            case 9:
                return 270;
            default:
                return 0;
        }
    }

    @UiThread
    protected void onMeasure(int i, int i2) {
        i = resolveSize(getSuggestedMinimumWidth(), i);
        i2 = resolveSize(getSuggestedMinimumHeight(), i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                childAt.measure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(i2, 1073741824));
            }
        }
        Log.a(this, "Measured dimension: {}x{}", Integer.valueOf(i), Integer.valueOf(i2));
        setMeasuredDimension(i, i2);
    }

    @UiThread
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return (this.dYW == null || this.dYW.getView() == null || !this.dYW.getView().dispatchTouchEvent(motionEvent)) ? false : true;
    }

    @UiThread
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Log.a(this, "Camera preview ({} childs) layouting to: top: {} bottom: {}, left: {}, right: {} (changed: {}) ", Integer.valueOf(getChildCount()), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z));
        if (getChildCount() == 0) {
            Log.d(this, "Camera view has no children?!?", new Object[0]);
            return;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 == 0 || i6 == 0) {
            Log.d(this, "Layout size is 0x0?!?", new Object[0]);
        } else if (this.dYW == null) {
            Log.b(this, "Create not called. Cannot layout view!", new Object[0]);
        } else {
            int i7;
            int i8;
            int i9;
            int i10;
            int size = MeasureSpec.getSize(this.dYW.getView().getMeasuredWidth());
            int size2 = MeasureSpec.getSize(this.dYW.getView().getMeasuredHeight());
            Log.a(this, "Camera surface view size is {}x{}", Integer.valueOf(size), Integer.valueOf(size2));
            Log.a(this, "Base camera view size: {}x{}", Integer.valueOf(i5), Integer.valueOf(i6));
            int i11 = (i5 - size) / 2;
            int i12 = (i5 + size) / 2;
            int i13 = (i6 - size2) / 2;
            int i14 = (i6 + size2) / 2;
            int i15;
            if (this.dZa == CameraAspectMode.ASPECT_FIT) {
                Log.a(this, "Layouting in ASPECT_FIT mode", new Object[0]);
                this.dUF = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
                i7 = i14;
                i8 = i13;
                i9 = i11;
                i10 = i12;
                i15 = 0;
            } else {
                float f;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                Log.a(this, "Layouting in ASPECT_FILL mode", new Object[0]);
                if (size <= 0 || size2 <= 0) {
                    f = 1.0f;
                    f2 = 0.0f;
                    f3 = 0.0f;
                    f4 = 1.0f;
                } else {
                    f5 = (float) size;
                    f = ((float) i5) / f5;
                    f2 = (float) size2;
                    f6 = ((float) i6) / f2;
                    f2 = ((float) (-i13)) / f2;
                    f3 = ((float) (-i11)) / f5;
                    f4 = f6;
                }
                if (k.cj(getContext())) {
                    f6 = f;
                    f = f3;
                    f5 = f4;
                } else {
                    f5 = f;
                    f = f2;
                    f2 = f3;
                    f6 = f4;
                }
                f2 = U(f2);
                f = U(f);
                this.dUF = new RectF(f2, f, U(f5) + f2, U(f6) + f);
                StringBuilder stringBuilder = new StringBuilder("Visible ROI: ");
                stringBuilder.append(this.dUF.toString());
                i15 = 0;
                Log.a(this, stringBuilder.toString(), new Object[0]);
                i9 = i;
                i8 = i2;
                i10 = i3;
                i7 = i4;
            }
            this.dZh = i10 - i9;
            this.dZi = i7 - i8;
            Log.f(this, "Layouting camera surface view: Left: {}, Top: {}, Right: {}, Bottom: {}", Integer.valueOf(i11), Integer.valueOf(i13), Integer.valueOf(i12), Integer.valueOf(i14));
            this.dYW.getView().layout(i11, i13, i12, i14);
            if (this.dZe != null) {
                if (this.dUG.isHorizontal()) {
                    this.dZe.ak(this.dZi, this.dZh);
                } else {
                    this.dZe.ak(this.dZh, this.dZi);
                }
            }
            for (i5 = 1; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                Log.f(this, "Layouting child {}: Left: {}, Top: {}, Right: {}, Bottom: {}", Integer.valueOf(i5), Integer.valueOf(i9), Integer.valueOf(i8), Integer.valueOf(i10), Integer.valueOf(i7));
                childAt.layout(i9, i8, i10, i7);
            }
        }
    }

    @UiThread
    public final CameraType getOpenedCameraType() {
        return this.dZd != null ? this.dZd.getOpenedCameraType() : null;
    }

    protected final boolean aQc() {
        return this.dZd != null ? this.dZd.aPC() : false;
    }

    @UiThread
    public final float getZoomLevel() {
        return this.dZj;
    }

    @UiThread
    public final void setZoomLevel(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.dZj = f;
        if (this.dZd != null) {
            this.dZd.setZoomLevel(this.dZj);
        }
    }

    @UiThread
    public final CameraViewState getCameraViewState() {
        return this.dYV;
    }

    public final void setTapToFocusAllowed(boolean z) {
        this.dZk = z;
    }

    public final void setPinchToZoomAllowed(boolean z) {
        this.dZl = z;
    }

    public final int getCameraPreviewWidth() {
        return this.dZh;
    }

    public final int getCameraPreviewHeight() {
        return this.dZi;
    }

    protected final int getConfigurationOrientation() {
        return this.dYX;
    }

    @UiThread
    public void setCameraType(CameraType cameraType) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setCameraType must be called before calling create()");
        } else if (cameraType != null) {
            this.dZg.dXw = cameraType;
        }
    }

    @UiThread
    public void setShakeListener(com.microblink.hardware.a.a aVar) {
        this.dZf = aVar;
    }

    public CameraAspectMode getAspectMode() {
        return this.dZa;
    }

    @UiThread
    public void setAspectMode(CameraAspectMode cameraAspectMode) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setAspectMode must be called before calling create()");
        }
        this.dZa = cameraAspectMode;
        if (this.dZa == null) {
            this.dZa = CameraAspectMode.ASPECT_FILL;
        }
    }

    @UiThread
    public final void setOnSizeChangedListener(c cVar) {
        this.dZe = cVar;
    }

    @UiThread
    public final void setOnActivityFlipListener(b bVar) {
        this.dYY = bVar;
    }

    @UiThread
    public final void setVideoResolutionPreset(VideoResolutionPreset videoResolutionPreset) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        v vVar = this.dZg;
        if (videoResolutionPreset != null) {
            vVar.dXt = videoResolutionPreset;
        } else {
            vVar.dXt = VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT;
        }
    }

    @UiThread
    public final void setForceUseLegacyCamera(boolean z) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.dZg.dXx = z;
    }

    @UiThread
    public final void setRequestAutofocusOnShakingStopInContinousAutofocusMode(boolean z) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.dZg.dXz = z;
    }

    @UiThread
    public final void setPhotoMode(boolean z) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.dZg.dXu = z;
    }

    @UiThread
    public final void setOptimizeCameraForNearScan(boolean z) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.dZg.dXv = z;
    }

    @UiThread
    public final void setRequestedSurfaceViewForCameraDisplay(@NonNull CameraSurface cameraSurface) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("This method can only be called before calling create().");
        }
        this.dZg.dXy = cameraSurface;
    }

    public a getCameraEventsListener() {
        return this.dYU;
    }

    @UiThread
    public void setCameraEventsListener(a aVar) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setCameraEventsListener must be called before calling create()");
        }
        this.dYU = aVar;
    }

    public int getHostScreenOrientation() {
        return this.dYZ;
    }

    public RectF getVisiblePart() {
        return this.dUF;
    }

    public Orientation getCurrentOrientation() {
        return this.dUG;
    }

    public final Orientation getInitialOrientation() {
        return this.dZb;
    }

    @UiThread
    @CallSuper
    public void setInitialOrientation(Orientation orientation) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setInitialOrientation must be called before calling create()");
        }
        this.dZb = orientation;
        if (getInitialOrientation() == null) {
            this.dZb = Orientation.fromActivityInfoCode(this.dYZ);
        }
    }

    @UiThread
    public void setOrientationAllowedListener(d dVar) {
        if (this.dYV != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setOrientationAllowedListener must be called before calling create()");
        }
        this.dZm = dVar;
    }

    public com.microblink.hardware.orientation.a getOrientationChangeListener() {
        return this.dZc;
    }

    public void setOrientationChangeListener(com.microblink.hardware.orientation.a aVar) {
        if (this.dYV == CameraViewState.DESTROYED || this.dYV == CameraViewState.CREATED) {
            this.dZc = aVar;
            return;
        }
        throw new IllegalStateException("Method setOrientationChangeListener must be called before calling start()");
    }
}
