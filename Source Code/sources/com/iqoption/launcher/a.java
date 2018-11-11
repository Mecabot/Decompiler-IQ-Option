package com.iqoption.launcher;

import android.arch.lifecycle.Observer;

final /* synthetic */ class a implements Observer {
    private final LauncherActivity cNI;

    a(LauncherActivity launcherActivity) {
        this.cNI = launcherActivity;
    }

    public void onChanged(Object obj) {
        this.cNI.p((Boolean) obj);
    }
}
