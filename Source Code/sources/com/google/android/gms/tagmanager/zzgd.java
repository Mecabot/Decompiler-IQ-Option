package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class zzgd implements ComponentCallbacks2 {
    private /* synthetic */ TagManager zzkud;

    zzgd(TagManager tagManager) {
        this.zzkud = tagManager;
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.zzkud.dispatch();
        }
    }
}
