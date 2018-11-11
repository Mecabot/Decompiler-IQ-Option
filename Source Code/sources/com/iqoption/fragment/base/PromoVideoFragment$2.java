package com.iqoption.fragment.base;

import com.iqoption.core.ui.navigation.LifecycleBackListener;
import com.iqoption.core.ui.navigation.a;

class PromoVideoFragment$2 extends LifecycleBackListener {
    final /* synthetic */ j cwj;

    PromoVideoFragment$2(j jVar, a aVar) {
        this.cwj = jVar;
        super(aVar);
    }

    public boolean onBackPressed() {
        return this.cwj.a();
    }
}
