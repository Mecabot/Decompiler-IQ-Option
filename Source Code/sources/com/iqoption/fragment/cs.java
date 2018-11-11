package com.iqoption.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.traderoom.TradeRoomViewModel;
import com.iqoption.traderoom.a;

final /* synthetic */ class cs implements Observer {
    private final a crX;

    private cs(a aVar) {
        this.crX = aVar;
    }

    static Observer a(a aVar) {
        return new cs(aVar);
    }

    public void onChanged(Object obj) {
        this.crX.a((TradeRoomViewModel.a) obj);
    }
}
