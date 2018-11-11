package com.iqoption.videoeducation.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.videoeducation.VideoEducationViewModel;
import com.iqoption.videoeducation.a.f;

final /* synthetic */ class c implements Observer {
    private final a dzT;
    private final VideoEducationViewModel dzU;
    private final f dzV;

    c(a aVar, VideoEducationViewModel videoEducationViewModel, f fVar) {
        this.dzT = aVar;
        this.dzU = videoEducationViewModel;
        this.dzV = fVar;
    }

    public void onChanged(Object obj) {
        this.dzT.a(this.dzU, this.dzV, (Boolean) obj);
    }
}
