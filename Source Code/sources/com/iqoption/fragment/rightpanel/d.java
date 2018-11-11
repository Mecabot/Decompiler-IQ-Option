package com.iqoption.fragment.rightpanel;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.fragment.rightpanel.b.c;

final /* synthetic */ class d implements OnClickListener {
    private final c cEO;

    private d(c cVar) {
        this.cEO = cVar;
    }

    static OnClickListener b(c cVar) {
        return new d(cVar);
    }

    public void onClick(View view) {
        this.cEO.bi(view);
    }
}
