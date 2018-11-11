package com.iqoption.menu;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class e implements OnClickListener {
    private final SupportView cPh;

    e(SupportView supportView) {
        this.cPh = supportView;
    }

    public void onClick(View view) {
        this.cPh.bt(view);
    }
}
