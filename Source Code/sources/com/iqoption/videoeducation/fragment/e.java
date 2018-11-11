package com.iqoption.videoeducation.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.videoeducation.b.a;

final /* synthetic */ class e implements Observer {
    private final a dzT;

    e(a aVar) {
        this.dzT = aVar;
    }

    public void onChanged(Object obj) {
        this.dzT.c((a) obj);
    }
}
