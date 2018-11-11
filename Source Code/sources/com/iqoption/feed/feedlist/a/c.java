package com.iqoption.feed.feedlist.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.core.microservices.feed.response.a;

final /* synthetic */ class c implements OnClickListener {
    private final a clT;
    private final a cmX;

    c(a aVar, a aVar2) {
        this.cmX = aVar;
        this.clT = aVar2;
    }

    public void onClick(View view) {
        this.cmX.a(this.clT, view);
    }
}
