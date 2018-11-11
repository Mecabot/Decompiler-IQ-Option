package com.iqoption.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

final /* synthetic */ class o implements OnClickListener {
    private final a cnA;
    private final LinearLayout cnB;

    o(a aVar, LinearLayout linearLayout) {
        this.cnA = aVar;
        this.cnB = linearLayout;
    }

    public void onClick(View view) {
        this.cnA.a(this.cnB, view);
    }
}
