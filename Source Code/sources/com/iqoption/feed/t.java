package com.iqoption.feed;

import android.arch.lifecycle.Observer;
import com.iqoption.feed.b.AnonymousClass3;
import com.iqoption.feed.feedlist.e;
import com.iqoption.util.ba;

final /* synthetic */ class t implements Observer {
    private final e clX;
    private final AnonymousClass3 cmc;

    t(AnonymousClass3 anonymousClass3, e eVar) {
        this.cmc = anonymousClass3;
        this.clX = eVar;
    }

    public void onChanged(Object obj) {
        this.cmc.a(this.clX, (ba) obj);
    }
}
