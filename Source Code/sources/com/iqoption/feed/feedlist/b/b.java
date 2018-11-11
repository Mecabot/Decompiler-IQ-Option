package com.iqoption.feed.feedlist.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.feed.feedlist.e;

final /* synthetic */ class b implements OnClickListener {
    private final e clX;
    private final a cnh;

    b(a aVar, e eVar) {
        this.cnh = aVar;
        this.clX = eVar;
    }

    public void onClick(View view) {
        this.cnh.e(this.clX, view);
    }
}
