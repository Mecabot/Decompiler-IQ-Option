package com.iqoption.app.a;

import android.content.Context;
import android.widget.Toast;

final /* synthetic */ class c implements Runnable {
    private final Context aeF;
    private final String afd;
    private final int jd;

    c(Context context, String str, int i) {
        this.aeF = context;
        this.afd = str;
        this.jd = i;
    }

    public void run() {
        Toast.makeText(this.aeF, this.afd, this.jd).show();
    }
}
