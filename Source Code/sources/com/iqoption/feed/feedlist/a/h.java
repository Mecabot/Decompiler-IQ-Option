package com.iqoption.feed.feedlist.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.feed.feedlist.e;

final /* synthetic */ class h implements OnClickListener {
    private final e clX;
    private final g cnb;

    h(g gVar, e eVar) {
        this.cnb = gVar;
        this.clX = eVar;
    }

    public void onClick(View view) {
        this.cnb.c(this.clX, view);
    }
}
