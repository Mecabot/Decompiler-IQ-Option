package com.iqoption.launcher;

import com.google.common.base.d;
import com.iqoption.core.i;

final /* synthetic */ class j implements d {
    static final d $instance = new j();

    private j() {
    }

    public Object apply(Object obj) {
        return i.i(LauncherActivity.TAG, "Options loading error", (Exception) obj);
    }
}
