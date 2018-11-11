package com.iqoption.portfolio.component.b;

import com.iqoption.mobbtech.connect.response.options.e;

/* compiled from: OpenExpItem */
public class h extends j<e> {
    public int getViewType() {
        return 6;
    }

    public h(i iVar, e eVar) {
        super(iVar, eVar);
    }

    public long awU() {
        return this.daq.getExpireTime();
    }
}
