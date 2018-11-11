package com.jumio.bam;

import android.content.Context;
import android.os.Bundle;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;
import com.jumio.sdk.extraction.ExtractionClient;
import jumio.bam.k;
import jumio.bam.s;

public class BamPlugin implements Plugin {
    public <T> void populateData(Context context, T t) {
    }

    public ExtractionClient getExtractionClient(Context context) {
        return new k(context);
    }

    public Overlay getOverlay(Context context, Bundle bundle) {
        return new s(context);
    }
}
