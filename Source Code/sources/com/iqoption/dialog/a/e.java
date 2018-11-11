package com.iqoption.dialog.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import com.google.common.collect.ImmutableList;

final /* synthetic */ class e implements a {
    private final Context aeF;
    private final boolean bVC;
    private final c cgi;
    private final ImmutableList cgj;

    e(Context context, boolean z, c cVar, ImmutableList immutableList) {
        this.aeF = context;
        this.bVC = z;
        this.cgi = cVar;
        this.cgj = immutableList;
    }

    public Adapter aeE() {
        return b.a(this.aeF, this.bVC, this.cgi, this.cgj);
    }
}
