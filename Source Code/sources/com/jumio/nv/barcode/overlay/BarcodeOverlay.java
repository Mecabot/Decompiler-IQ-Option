package com.jumio.nv.barcode.overlay;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.nv.NVOverlay;
import com.jumio.nv.NVOverlay.NVOverlayConfig;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;

public class BarcodeOverlay extends NVOverlay {
    private Rect overlayBounds;
    private NVOverlayConfig overlayConfig = new NVOverlayConfig();

    public void update(ExtractionUpdate extractionUpdate) {
    }

    public BarcodeOverlay(Context context) {
        super(context);
    }

    public void calculate(@NonNull DocumentScanMode documentScanMode, @NonNull DocumentFormat documentFormat, Rect rect) {
        super.calculate(documentScanMode, documentFormat, rect);
        int i = (int) ((((float) this.w) - (((float) this.w) * 0.9f)) / 2.0f);
        int i2 = (int) ((((float) this.h) - (((float) this.h) * 0.95f)) / 2.0f);
        this.overlayBounds = new Rect(i, i2, this.w - i, this.h - (i2 * 3));
    }

    public Rect getOverlayBounds() {
        return this.overlayBounds;
    }

    public NVOverlayConfig getNetverifyOverlayConfiguration(Context context) {
        this.overlayConfig.drawBrackets = false;
        this.overlayConfig.dimBackground = false;
        return this.overlayConfig;
    }
}
