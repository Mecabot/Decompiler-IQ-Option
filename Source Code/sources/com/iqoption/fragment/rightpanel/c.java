package com.iqoption.fragment.rightpanel;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class c implements OnClickListener {
    private final com.iqoption.fragment.rightpanel.b.c cEO;

    private c(com.iqoption.fragment.rightpanel.b.c cVar) {
        this.cEO = cVar;
    }

    static OnClickListener b(com.iqoption.fragment.rightpanel.b.c cVar) {
        return new c(cVar);
    }

    public void onClick(View view) {
        this.cEO.bh(view);
    }
}
