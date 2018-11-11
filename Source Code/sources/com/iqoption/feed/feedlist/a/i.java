package com.iqoption.feed.feedlist.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.core.microservices.feed.response.a;

final /* synthetic */ class i implements OnClickListener {
    private final a clT;
    private final g cnb;

    i(g gVar, a aVar) {
        this.cnb = gVar;
        this.clT = aVar;
    }

    public void onClick(View view) {
        this.cnb.b(this.clT, view);
    }
}
