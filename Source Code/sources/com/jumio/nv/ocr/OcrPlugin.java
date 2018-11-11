package com.jumio.nv.ocr;

import android.content.Context;
import android.os.Bundle;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;
import com.jumio.sdk.extraction.ExtractionClient;
import jumio.nv.ocr.b;
import jumio.nv.ocr.g;

public class OcrPlugin implements Plugin {
    public <T> void populateData(Context context, T t) {
    }

    public ExtractionClient getExtractionClient(Context context) {
        return new b(context);
    }

    public Overlay getOverlay(Context context, Bundle bundle) {
        return new g(context);
    }
}
