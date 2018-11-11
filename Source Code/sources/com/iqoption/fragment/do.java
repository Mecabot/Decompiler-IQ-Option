package com.iqoption.fragment;

import android.view.View;
import com.iqoption.fragment.cr.AnonymousClass5;
import io.reactivex.c.a;

final /* synthetic */ class do implements a {
    private final View aeQ;
    private final AnonymousClass5 csf;

    do(AnonymousClass5 anonymousClass5, View view) {
        this.csf = anonymousClass5;
        this.aeQ = view;
    }

    public void run() {
        this.csf.aS(this.aeQ);
    }
}
