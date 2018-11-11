package com.iqoption.fragment.rightpanel;

import android.graphics.Rect;
import com.iqoption.fragment.rightpanel.j.AnonymousClass2;

final /* synthetic */ class o implements Runnable {
    private final AnonymousClass2 cFQ;
    private final Rect cFR;

    o(AnonymousClass2 anonymousClass2, Rect rect) {
        this.cFQ = anonymousClass2;
        this.cFR = rect;
    }

    public void run() {
        this.cFQ.e(this.cFR);
    }
}
