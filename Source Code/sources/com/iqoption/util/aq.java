package com.iqoption.util;

import android.view.View.OnSystemUiVisibilityChangeListener;
import com.iqoption.util.am.b;

final /* synthetic */ class aq implements OnSystemUiVisibilityChangeListener {
    private final b dwc;

    aq(b bVar) {
        this.dwc = bVar;
    }

    public void onSystemUiVisibilityChange(int i) {
        this.dwc.gH(i);
    }
}
