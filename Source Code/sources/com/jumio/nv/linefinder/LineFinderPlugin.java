package com.jumio.nv.linefinder;

import android.content.Context;
import android.os.Bundle;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;
import com.jumio.sdk.extraction.ExtractionClient;
import jumio.nv.core.s;
import jumio.nv.core.v;

public class LineFinderPlugin implements Plugin {
    public <T> void populateData(Context context, T t) {
    }

    public ExtractionClient getExtractionClient(Context context) {
        return new s(context);
    }

    public Overlay getOverlay(Context context, Bundle bundle) {
        return new v(context);
    }
}
