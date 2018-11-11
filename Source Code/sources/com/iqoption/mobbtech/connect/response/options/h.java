package com.iqoption.mobbtech.connect.response.options;

import android.support.v4.util.Pair;
import com.google.common.base.d;

final /* synthetic */ class h implements d {
    static final d $instance = new h();

    private h() {
    }

    public Object apply(Object obj) {
        return Pair.create(((e) obj).id, ((e) obj).getCreated());
    }
}
