package com.jumio.sdk.extraction;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.core.environment.Environment;
import com.jumio.core.mvp.model.DynamicModel;
import com.jumio.core.mvp.model.StaticModel;

public abstract class ExtractionClient<U, R> extends DynamicModel<byte[], U, R> {
    private final float FOCUS_THRESHOLD = 0.12f;
    private final int INTENSITY_THRESHOLD = 70;
    private boolean dataExtractionActive = false;
    protected Rect extractionArea;
    protected Context mContext;
    protected boolean mIsInverted;
    protected boolean mIsPortrait;
    protected boolean mIsTablet;
    private PreviewProperties mPreviewProperties;

    public static class ExtractionUpdate<T> {
        private final T mData;
        private final int mState;

        public ExtractionUpdate(int i, T t) {
            this.mState = i;
            this.mData = t;
        }

        public T getData() {
            return this.mData;
        }

        public int getState() {
            return this.mState;
        }
    }

    @Deprecated
    public static class ImageCheckResult {
        private boolean mFlashNeeded;
        private boolean mRefocusNeeded;

        public ImageCheckResult(boolean z, boolean z2) {
            this.mFlashNeeded = z;
            this.mRefocusNeeded = z2;
        }

        public boolean isFlashNeeded() {
            return this.mFlashNeeded;
        }

        public boolean isRefocusNeeded() {
            return this.mRefocusNeeded;
        }
    }

    public abstract void configure(StaticModel staticModel);

    public abstract void destroy();

    public Size getPrefferedPreviewSize() {
        return null;
    }

    protected abstract void init();

    public void takePicture() {
    }

    public boolean takePictureManually() {
        return false;
    }

    public ExtractionClient(Context context) {
        this.mContext = context;
        Environment.loadJniInterfaceLib();
        Environment.loadJniImageQualityLib();
        CameraUtils.setYuvConversion(new YuvConversionWrapper());
    }

    public void reinit() {
        if (!isDataExtractionActive()) {
            init();
            setDataExtractionActive(true);
        }
    }

    public synchronized void process(byte[] bArr) {
        if (isDataExtractionActive()) {
            feed(bArr);
        }
    }

    public void cancel() {
        setDataExtractionActive(false);
        System.gc();
    }

    public boolean isDataExtractionActive() {
        return this.dataExtractionActive;
    }

    public void setDataExtractionActive(boolean z) {
        this.dataExtractionActive = z;
    }

    public void setPreviewProperties(PreviewProperties previewProperties) {
        if (previewProperties != null) {
            this.mPreviewProperties = previewProperties.copy();
        }
    }

    public void setFlags(boolean z, boolean z2, boolean z3) {
        this.mIsPortrait = z;
        this.mIsTablet = z2;
        this.mIsInverted = z3;
    }

    public void setExtractionArea(Rect rect) {
        this.extractionArea = new Rect(rect);
    }

    public boolean isPortrait() {
        return this.mIsPortrait;
    }

    public PreviewProperties getPreviewProperties() {
        if (this.mPreviewProperties == null) {
            return new PreviewProperties();
        }
        return this.mPreviewProperties;
    }
}
