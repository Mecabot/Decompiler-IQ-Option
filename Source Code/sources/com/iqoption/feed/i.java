package com.iqoption.feed;

import android.arch.lifecycle.Observer;
import com.iqoption.util.ba;

final /* synthetic */ class i implements Observer {
    private final b clS;

    i(b bVar) {
        this.clS = bVar;
    }

    public void onChanged(Object obj) {
        this.clS.a((ba) obj);
    }
}
