package com.iqoption.feed.feedlist.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.feed.feedlist.e;

final /* synthetic */ class k implements OnClickListener {
    private final e clX;
    private final j cne;

    k(j jVar, e eVar) {
        this.cne = jVar;
        this.clX = eVar;
    }

    public void onClick(View view) {
        this.cne.d(this.clX, view);
    }
}
