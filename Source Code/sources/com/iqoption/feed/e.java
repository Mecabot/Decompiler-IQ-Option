package com.iqoption.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.core.microservices.feed.response.a;

final /* synthetic */ class e implements OnClickListener {
    private final int cgO;
    private final b clS;
    private final a clT;
    private final com.iqoption.feed.feedlist.e clU;

    e(b bVar, a aVar, com.iqoption.feed.feedlist.e eVar, int i) {
        this.clS = bVar;
        this.clT = aVar;
        this.clU = eVar;
        this.cgO = i;
    }

    public void onClick(View view) {
        this.clS.a(this.clT, this.clU, this.cgO, view);
    }
}
