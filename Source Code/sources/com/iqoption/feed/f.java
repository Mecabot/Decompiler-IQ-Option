package com.iqoption.feed;

import android.support.v7.widget.RecyclerView;

final /* synthetic */ class f implements Runnable {
    private final RecyclerView clV;
    private final int jH;

    f(RecyclerView recyclerView, int i) {
        this.clV = recyclerView;
        this.jH = i;
    }

    public void run() {
        this.clV.b(this.jH);
    }
}
