package com.iqoption.feed.feedlist.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.core.microservices.feed.response.a;

final /* synthetic */ class p implements OnClickListener {
    private final a clT;
    private final m cno;

    p(m mVar, a aVar) {
        this.cno = mVar;
        this.clT = aVar;
    }

    public void onClick(View view) {
        this.cno.h(this.clT, view);
    }
}
