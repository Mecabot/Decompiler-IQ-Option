package com.iqoption.fragment.dialog;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class l implements OnClickListener {
    private final h cAC;
    private final int jH;

    l(h hVar, int i) {
        this.cAC = hVar;
        this.jH = i;
    }

    public void onClick(View view) {
        this.cAC.b(this.jH, view);
    }
}
