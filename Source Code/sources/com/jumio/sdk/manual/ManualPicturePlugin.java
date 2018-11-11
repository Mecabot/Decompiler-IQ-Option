package com.jumio.sdk.manual;

import android.content.Context;
import android.os.Bundle;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;
import com.jumio.sdk.extraction.ExtractionClient;

public class ManualPicturePlugin implements Plugin {
    public <T> void populateData(Context context, T t) {
    }

    public ExtractionClient getExtractionClient(Context context) {
        return new ManualPictureClient(context);
    }

    public Overlay getOverlay(Context context, Bundle bundle) {
        return new ManualOverlay(context);
    }
}
