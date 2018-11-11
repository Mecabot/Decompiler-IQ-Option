package com.jumio.nv.mrz;

import android.content.Context;
import android.os.Bundle;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;
import com.jumio.sdk.extraction.ExtractionClient;
import jumio.nv.mrz.a;
import jumio.nv.mrz.d;

public class MrzPlugin implements Plugin {
    public <T> void populateData(Context context, T t) {
    }

    public ExtractionClient getExtractionClient(Context context) {
        return new a(context);
    }

    public Overlay getOverlay(Context context, Bundle bundle) {
        return new d(context);
    }
}
