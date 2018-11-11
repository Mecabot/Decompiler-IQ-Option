package com.iqoption.view;

import com.iqoption.mobbtech.connect.a.c;
import com.iqoption.view.LocalToast.AnonymousClass1;

final /* synthetic */ class i implements Runnable {
    private final AnonymousClass1 dCj;
    private final c dCk;

    i(AnonymousClass1 anonymousClass1, c cVar) {
        this.dCj = anonymousClass1;
        this.dCk = cVar;
    }

    public void run() {
        this.dCj.a(this.dCk);
    }
}
