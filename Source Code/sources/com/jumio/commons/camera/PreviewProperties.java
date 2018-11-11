package com.jumio.commons.camera;

import android.graphics.PixelFormat;
import com.jumio.commons.PersistWith;
import java.io.Serializable;

@PersistWith("PreviewProperties")
public class PreviewProperties implements Serializable {
    private static final long serialVersionUID = 2336255597278613463L;
    public Size camera;
    public boolean frontFacing;
    public boolean isPortrait;
    public int orientation;
    public Size preview;
    public int previewFormat = 17;
    public Size scaledPreview;
    public int sensorRotation;
    public Size surface;

    public PreviewProperties copy() {
        PreviewProperties previewProperties = new PreviewProperties();
        previewProperties.scaledPreview = this.scaledPreview.copy();
        previewProperties.surface = this.surface.copy();
        previewProperties.preview = this.preview.copy();
        previewProperties.camera = this.camera.copy();
        previewProperties.frontFacing = this.frontFacing;
        previewProperties.orientation = this.orientation;
        previewProperties.sensorRotation = this.sensorRotation;
        return previewProperties;
    }

    public float getScaleFactor() {
        return ((float) this.scaledPreview.width) / ((float) this.preview.width);
    }

    public float getBytesPerPixel() {
        PixelFormat pixelFormat = new PixelFormat();
        PixelFormat.getPixelFormatInfo(this.previewFormat, pixelFormat);
        return ((float) pixelFormat.bitsPerPixel) / 8.0f;
    }
}
