package com.iqoption.feed.feedlist.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.core.microservices.feed.response.a;

final /* synthetic */ class m implements OnClickListener {
    private final a clT;
    private final j cne;

    m(j jVar, a aVar) {
        this.cne = jVar;
        this.clT = aVar;
    }

    public void onClick(View view) {
        this.cne.c(this.clT, view);
    }
}
