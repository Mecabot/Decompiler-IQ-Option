package com.jumio.commons.camera;

import android.os.Handler;
import com.jumio.commons.view.ViewFader;

public class CameraFlashThread extends Thread {
    private static final int FLASH_PULSE_ICON_DURATION = 8000;
    private static final int FLASH_PULSE_ICON_START_DELAY = 3000;
    private ViewFader fader;
    private Handler handler;
    private boolean pulsate;

    public CameraFlashThread(ViewFader viewFader) {
        this.pulsate = false;
        this.fader = null;
        this.handler = null;
        this.handler = new Handler();
        this.fader = viewFader;
    }

    public void pulsate(boolean z) {
        this.pulsate = z;
        if (!z && this.fader != null) {
            this.fader.cancel();
        }
    }

    public void run() {
        try {
            Thread.sleep(3000);
            while (!isInterrupted()) {
                if (this.pulsate) {
                    this.handler.post(new Runnable() {
                        public void run() {
                            if (CameraFlashThread.this.fader != null) {
                                CameraFlashThread.this.fader.pulsate();
                            }
                        }
                    });
                }
                Thread.sleep(8000);
            }
        } catch (InterruptedException unused) {
            this.handler.post(new Runnable() {
                public void run() {
                    CameraFlashThread.this.fader.cancel();
                }
            });
        }
    }
}
