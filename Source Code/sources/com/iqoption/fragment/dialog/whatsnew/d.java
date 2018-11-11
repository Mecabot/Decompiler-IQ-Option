package com.iqoption.fragment.dialog.whatsnew;

import android.arch.lifecycle.Observer;
import com.iqoption.core.ui.c;

final /* synthetic */ class d implements Observer {
    private final a cBS;

    d(a aVar) {
        this.cBS = aVar;
    }

    public void onChanged(Object obj) {
        this.cBS.c((c) obj);
    }
}
