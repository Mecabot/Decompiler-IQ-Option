package com.iqoption.feed.feedlist.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.feed.feedlist.e;

final /* synthetic */ class b implements OnClickListener {
    private final e clX;
    private final a cmX;

    b(a aVar, e eVar) {
        this.cmX = aVar;
        this.clX = eVar;
    }

    public void onClick(View view) {
        this.cmX.b(this.clX, view);
    }
}
