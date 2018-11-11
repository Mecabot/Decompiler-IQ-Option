package com.iqoption.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.d.yo;
import com.iqoption.feed.feedlist.e;

final /* synthetic */ class n implements OnClickListener {
    private final b clS;
    private final e clX;
    private final yo clY;

    n(b bVar, e eVar, yo yoVar) {
        this.clS = bVar;
        this.clX = eVar;
        this.clY = yoVar;
    }

    public void onClick(View view) {
        this.clS.b(this.clX, this.clY, view);
    }
}
