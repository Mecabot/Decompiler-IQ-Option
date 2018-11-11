package com.iqoption.view.stickyheadersrecyclerview.a;

import android.support.v4.util.LongSparseArray;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.iqoption.view.stickyheadersrecyclerview.c;

/* compiled from: HeaderViewCache */
public class b implements a {
    private final c dIX;
    private final com.iqoption.view.stickyheadersrecyclerview.d.b dIY;
    private final LongSparseArray<View> dJf = new LongSparseArray();

    public b(c cVar, com.iqoption.view.stickyheadersrecyclerview.d.b bVar) {
        this.dIX = cVar;
        this.dIY = bVar;
    }

    public View d(RecyclerView recyclerView, int i) {
        long cA = this.dIX.cA(i);
        View view = (View) this.dJf.get(cA);
        if (view == null) {
            int makeMeasureSpec;
            ViewHolder c = this.dIX.c(recyclerView);
            this.dIX.a(c, i);
            view = c.itemView;
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            if (this.dIY.h(recyclerView) == 1) {
                i = MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824);
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0);
            } else {
                i = MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 0);
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824);
            }
            view.measure(ViewGroup.getChildMeasureSpec(i, recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(makeMeasureSpec, recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), view.getLayoutParams().height));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            this.dJf.put(cA, view);
        }
        return view;
    }
}
