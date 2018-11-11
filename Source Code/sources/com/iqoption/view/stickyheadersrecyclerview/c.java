package com.iqoption.view.stickyheadersrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

/* compiled from: StickyRecyclerHeadersAdapter */
public interface c<VH extends ViewHolder> {
    void a(VH vh, int i);

    int aK(Context context);

    VH c(ViewGroup viewGroup);

    long cA(int i);

    int getItemCount();
}
