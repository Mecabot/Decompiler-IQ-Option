package com.iqoption.fragment.rightpanel;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.fragment.rightpanel.ab.c;

final /* synthetic */ class ac implements OnClickListener {
    private final c cGO;

    private ac(c cVar) {
        this.cGO = cVar;
    }

    static OnClickListener b(c cVar) {
        return new ac(cVar);
    }

    public void onClick(View view) {
        this.cGO.bh(view);
    }
}
