package com.jumio.nv.extraction;

import android.app.Activity;
import android.content.Intent;
import com.jumio.nv.models.ServerSettingsModel;
import java.io.Serializable;

public interface NfcController extends Serializable {
    boolean consumeIntent(int i, Intent intent);

    void downloadCertificates(ServerSettingsModel serverSettingsModel);

    boolean hasNfcFeature();

    boolean hasRootCertificate(String str);

    boolean isNfcEnabled();

    void pause(Activity activity);

    void setEnabled(boolean z);

    void setTagAccess(Object obj);

    void start(Activity activity);

    void stop();
}
