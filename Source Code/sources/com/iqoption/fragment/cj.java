package com.iqoption.fragment;

import com.iqoption.dto.PushSetting;
import com.iqoption.view.SettingItemView;
import com.iqoption.view.SettingItemView.a;

final /* synthetic */ class cj implements a {
    private final cc cqU;
    private final PushSetting cqV;
    private final SettingItemView cqW;

    cj(cc ccVar, PushSetting pushSetting, SettingItemView settingItemView) {
        this.cqU = ccVar;
        this.cqV = pushSetting;
        this.cqW = settingItemView;
    }

    public void b(SettingItemView settingItemView, boolean z) {
        this.cqU.a(this.cqV, this.cqW, settingItemView, z);
    }
}
