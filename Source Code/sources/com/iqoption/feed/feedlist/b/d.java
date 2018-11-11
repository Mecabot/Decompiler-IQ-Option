package com.iqoption.feed.feedlist.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.core.microservices.feed.response.a;

final /* synthetic */ class d implements OnClickListener {
    private final a clT;
    private final a cnh;

    d(a aVar, a aVar2) {
        this.cnh = aVar;
        this.clT = aVar2;
    }

    public void onClick(View view) {
        this.cnh.e(this.clT, view);
    }
}
