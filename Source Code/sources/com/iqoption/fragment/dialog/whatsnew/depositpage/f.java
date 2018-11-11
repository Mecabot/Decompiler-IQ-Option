package com.iqoption.fragment.dialog.whatsnew.depositpage;

import android.arch.lifecycle.Observer;
import java.util.List;

final /* synthetic */ class f implements Observer {
    private final a cCd;

    f(a aVar) {
        this.cCd = aVar;
    }

    public void onChanged(Object obj) {
        c.a(this.cCd, (List) obj);
    }
}
