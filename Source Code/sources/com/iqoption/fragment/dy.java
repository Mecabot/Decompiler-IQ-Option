package com.iqoption.fragment;

import com.google.common.base.j;
import com.iqoption.dto.entity.Feature;

final /* synthetic */ class dy implements j {
    static final j $instance = new dy();

    private dy() {
    }

    public boolean apply(Object obj) {
        return "platform-troubles".equalsIgnoreCase(((Feature) obj).name);
    }
}
