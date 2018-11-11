package com.iqoption.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.feed.feedlist.e;
import com.iqoption.widget.a.a;

final /* synthetic */ class s implements OnClickListener {
    private final b clS;
    private final e clX;
    private final a cma;

    s(b bVar, e eVar, a aVar) {
        this.clS = bVar;
        this.clX = eVar;
        this.cma = aVar;
    }

    public void onClick(View view) {
        this.clS.a(this.clX, this.cma, view);
    }
}
