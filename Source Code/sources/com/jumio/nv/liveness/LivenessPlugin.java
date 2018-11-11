package com.jumio.nv.liveness;

import android.content.Context;
import android.os.Bundle;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;
import com.jumio.nv.liveness.extraction.LivenessClient;
import com.jumio.nv.liveness.overlay.LivenessOverlay;
import com.jumio.sdk.extraction.ExtractionClient;

public class LivenessPlugin implements Plugin {
    public <T> void populateData(Context context, T t) {
    }

    public ExtractionClient getExtractionClient(Context context) {
        return new LivenessClient(context);
    }

    public Overlay getOverlay(Context context, Bundle bundle) {
        return new LivenessOverlay(context);
    }
}
