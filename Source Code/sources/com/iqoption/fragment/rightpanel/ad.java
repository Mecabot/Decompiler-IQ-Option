package com.iqoption.fragment.rightpanel;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.fragment.rightpanel.ab.c;

final /* synthetic */ class ad implements OnClickListener {
    private final c cGO;

    private ad(c cVar) {
        this.cGO = cVar;
    }

    static OnClickListener b(c cVar) {
        return new ad(cVar);
    }

    public void onClick(View view) {
        this.cGO.bi(view);
    }
}
