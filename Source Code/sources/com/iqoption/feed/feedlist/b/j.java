package com.iqoption.feed.feedlist.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.feed.feedlist.e;

final /* synthetic */ class j implements OnClickListener {
    private final e clX;
    private final i cnl;

    j(i iVar, e eVar) {
        this.cnl = iVar;
        this.clX = eVar;
    }

    public void onClick(View view) {
        this.cnl.f(this.clX, view);
    }
}
