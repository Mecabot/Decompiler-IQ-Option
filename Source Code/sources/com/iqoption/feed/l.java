package com.iqoption.feed;

import android.arch.lifecycle.Observer;
import com.iqoption.feed.feedlist.e;

final /* synthetic */ class l implements Observer {
    private final b clS;

    l(b bVar) {
        this.clS = bVar;
    }

    public void onChanged(Object obj) {
        this.clS.g((e) obj);
    }
}
