package com.jumio.sdk.manual;

import android.content.Context;
import android.graphics.Bitmap;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.sdk.extraction.ExtractionClient;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class ManualPictureClient extends ExtractionClient<ExtractionUpdate, StaticModel> {
    private AtomicBoolean mPictureTaken = new AtomicBoolean(false);
    private final AtomicBoolean mTakePicture = new AtomicBoolean(false);

    private class SavingTask extends Thread {
        private byte[] data;

        public SavingTask(byte[] bArr) {
            this.data = Arrays.copyOf(bArr, bArr.length);
        }

        public void run() {
            ManualPictureClient.this.access$300(new ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(1.0f)));
            Bitmap yuv2bitmap = CameraUtils.yuv2bitmap(this.data, ManualPictureClient.this.isPortrait(), ManualPictureClient.this.getPreviewProperties(), ManualPictureClient.this.extractionArea, -1);
            ManualPictureClient.this.access$300(new ExtractionUpdate(ExtractionUpdateState.saveImage, yuv2bitmap));
            ManualPictureClient.this.access$300(new ExtractionUpdate(ExtractionUpdateState.saveExactImage, yuv2bitmap));
            ManualPictureClient.this.access$400(null);
            this.data = null;
            System.gc();
        }
    }

    public void configure(StaticModel staticModel) {
    }

    public void destroy() {
    }

    public boolean takePictureManually() {
        return true;
    }

    public ManualPictureClient(Context context) {
        super(context);
    }

    protected void init() {
        this.mTakePicture.set(false);
        this.mPictureTaken.set(false);
    }

    public void feed(byte[] bArr) {
        if (this.mTakePicture.get() && !this.mPictureTaken.get()) {
            this.mPictureTaken.set(true);
            new SavingTask(bArr).start();
        }
    }

    public void takePicture() {
        this.mTakePicture.set(true);
    }
}
