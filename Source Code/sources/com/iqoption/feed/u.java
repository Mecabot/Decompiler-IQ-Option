package com.iqoption.feed;

import android.view.ViewGroup;
import com.iqoption.feed.b.c;
import java.util.Map.Entry;

final /* synthetic */ class u implements Runnable {
    private final Entry cmo;
    private final ViewGroup cmp;
    private final ViewGroup cmq;

    u(Entry entry, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.cmo = entry;
        this.cmp = viewGroup;
        this.cmq = viewGroup2;
    }

    public void run() {
        c.a(this.cmo, this.cmp, this.cmq);
    }
}
