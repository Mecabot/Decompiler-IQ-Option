package com.iqoption.trading.history.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.trading.history.fragment.viewmodel.InstrumentTypeViewModel.b;

final /* synthetic */ class q implements Observer {
    private final TradingHistorySearchSettingFragment dtG;

    q(TradingHistorySearchSettingFragment tradingHistorySearchSettingFragment) {
        this.dtG = tradingHistorySearchSettingFragment;
    }

    public void onChanged(Object obj) {
        this.dtG.a((b) obj);
    }
}
