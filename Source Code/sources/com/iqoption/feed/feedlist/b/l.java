package com.iqoption.feed.feedlist.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.core.microservices.feed.response.a;

final /* synthetic */ class l implements OnClickListener {
    private final a clT;
    private final i cnl;

    l(i iVar, a aVar) {
        this.cnl = iVar;
        this.clT = aVar;
    }

    public void onClick(View view) {
        this.cnl.f(this.clT, view);
    }
}
