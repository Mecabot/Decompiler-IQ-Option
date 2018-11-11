package com.iqoption.feed.feedlist.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.core.microservices.feed.response.a;

final /* synthetic */ class q implements OnClickListener {
    private final a clT;
    private final m cno;

    q(m mVar, a aVar) {
        this.cno = mVar;
        this.clT = aVar;
    }

    public void onClick(View view) {
        this.cno.g(this.clT, view);
    }
}
