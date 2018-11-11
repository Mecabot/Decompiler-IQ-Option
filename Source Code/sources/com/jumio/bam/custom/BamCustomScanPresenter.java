package com.jumio.bam.custom;

import com.jumio.sdk.presentation.BaseScanPresenter.BaseScanControl;
import jumio.bam.g;
import jumio.bam.z;

public class BamCustomScanPresenter {
    private g inlineScanViewController;
    private z scanPresenter;

    public BamCustomScanPresenter(g gVar, z zVar) {
        this.inlineScanViewController = gVar;
        this.scanPresenter = zVar;
    }

    public void onActivityPause() {
        if (this.scanPresenter != null) {
            this.scanPresenter.a(true, true);
        }
    }

    public void retryScan() {
        this.inlineScanViewController.a();
        this.scanPresenter.activate();
        this.scanPresenter.c();
    }

    public void stopScan() {
        if (this.scanPresenter != null) {
            this.scanPresenter.deactivate();
        }
    }

    public void clearSDK() {
        this.inlineScanViewController.b();
        if (this.scanPresenter != null) {
            this.scanPresenter.deactivate();
            this.scanPresenter.detachView();
            this.scanPresenter = null;
        }
    }

    public boolean hasFlash() {
        return this.scanPresenter.control(BaseScanControl.hasFlash);
    }

    public boolean isFlashOn() {
        return this.scanPresenter.control(BaseScanControl.isFlashOn);
    }

    public void toggleFlash() {
        this.scanPresenter.control(BaseScanControl.toggleFlash);
    }

    public boolean hasMultipleCameras() {
        return this.scanPresenter.control(BaseScanControl.hasMultipleCameras);
    }

    public boolean isCameraFrontFacing() {
        return this.scanPresenter.control(BaseScanControl.isCameraFrontfacing);
    }

    public void switchCamera() {
        this.scanPresenter.control(BaseScanControl.toggleCamera);
    }
}
