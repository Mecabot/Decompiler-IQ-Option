package com.iqoption.fragment;

import android.support.v4.app.FragmentManager;
import com.iqoption.core.data.model.InstrumentType;
import java.util.ArrayList;

final /* synthetic */ class ar implements Runnable {
    private final FragmentManager cfl;
    private final InstrumentType coO;
    private final ArrayList coP;
    private final int jH;

    ar(FragmentManager fragmentManager, int i, InstrumentType instrumentType, ArrayList arrayList) {
        this.cfl = fragmentManager;
        this.jH = i;
        this.coO = instrumentType;
        this.coP = arrayList;
    }

    public void run() {
        aq.a(this.cfl, this.jH, this.coO, this.coP);
    }
}
