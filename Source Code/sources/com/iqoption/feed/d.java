package com.iqoption.feed;

import android.arch.lifecycle.Observer;
import java.util.Map;

final /* synthetic */ class d implements Observer {
    private final b clS;

    d(b bVar) {
        this.clS = bVar;
    }

    public void onChanged(Object obj) {
        this.clS.y((Map) obj);
    }
}
