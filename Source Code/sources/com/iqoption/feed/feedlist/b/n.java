package com.iqoption.feed.feedlist.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.feed.feedlist.e;

final /* synthetic */ class n implements OnClickListener {
    private final e clX;
    private final m cno;

    n(m mVar, e eVar) {
        this.cno = mVar;
        this.clX = eVar;
    }

    public void onClick(View view) {
        this.cno.g(this.clX, view);
    }
}
