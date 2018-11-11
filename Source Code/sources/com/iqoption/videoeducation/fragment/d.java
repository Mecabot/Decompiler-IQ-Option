package com.iqoption.videoeducation.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.videoeducation.a.f;
import java.util.List;

final /* synthetic */ class d implements Observer {
    private final f dzW;

    d(f fVar) {
        this.dzW = fVar;
    }

    public void onChanged(Object obj) {
        a.a(this.dzW, (List) obj);
    }
}
