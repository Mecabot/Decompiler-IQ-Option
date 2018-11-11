package com.jumio.nv.nfc;

import android.content.Context;
import android.os.Bundle;
import com.jumio.commons.log.Log;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.Plugin;
import com.jumio.sdk.extraction.ExtractionClient;
import jumio.nv.nfc.w;

public class NfcPlugin implements Plugin {
    public <T> void populateData(Context context, T t) {
    }

    public ExtractionClient getExtractionClient(Context context) {
        Log.w("NfcPlugin", "Caution! NFC reading is not done via the extraction client mechanism!");
        return null;
    }

    public Overlay getOverlay(Context context, Bundle bundle) {
        return w.a(bundle);
    }
}
