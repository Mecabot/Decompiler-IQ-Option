package com.jumio.nv.liveness.eyetracking;

import android.content.Context;
import android.os.Bundle;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;
import com.jumio.nv.liveness.eyetracking.a.a;
import com.jumio.sdk.extraction.ExtractionClient;

public class EyeTrackingPlugin implements Plugin {
    public <T> void populateData(Context context, T t) {
    }

    public ExtractionClient getExtractionClient(Context context) {
        return new a(context);
    }

    public Overlay getOverlay(Context context, Bundle bundle) {
        return new com.jumio.nv.liveness.eyetracking.overlay.a(context);
    }
}
