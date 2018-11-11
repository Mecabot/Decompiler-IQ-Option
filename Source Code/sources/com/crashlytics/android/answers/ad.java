package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.Map;
import java.util.UUID;

/* compiled from: SessionMetadataCollector */
class ad {
    private final Context context;
    private final IdManager tl;
    private final String tm;
    private final String versionName;

    public ad(Context context, IdManager idManager, String str, String str2) {
        this.context = context;
        this.tl = idManager;
        this.tm = str;
        this.versionName = str2;
    }

    public ab gM() {
        Map gN = this.tl.gN();
        return new ab(this.tl.aUH(), UUID.randomUUID().toString(), this.tl.aUG(), this.tl.aUM(), (String) gN.get(DeviceIdentifierType.FONT_TOKEN), CommonUtils.cQ(this.context), this.tl.aUI(), this.tl.aUL(), this.tm, this.versionName);
    }
}
