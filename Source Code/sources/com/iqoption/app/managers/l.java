package com.iqoption.app.managers;

import android.util.Pair;
import com.google.common.base.d;
import com.iqoption.dto.entity.result.BuybackResult;
import com.iqoption.mobbtech.connect.response.options.i;

final /* synthetic */ class l implements d {
    static final d $instance = new l();

    private l() {
    }

    public Object apply(Object obj) {
        return Pair.create((BuybackResult) obj, new i(((BuybackResult) obj).expired, ((BuybackResult) obj).activeId, ((BuybackResult) obj).typeName.toInstrumentType()));
    }
}
