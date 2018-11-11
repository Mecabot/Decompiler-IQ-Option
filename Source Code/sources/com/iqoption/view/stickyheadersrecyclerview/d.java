package com.iqoption.view.stickyheadersrecyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;
import com.iqoption.view.stickyheadersrecyclerview.a.a;
import com.iqoption.view.stickyheadersrecyclerview.d.b;

/* compiled from: StickyRecyclerHeadersDecoration */
public class d extends ItemDecoration {
    private final c dIX;
    private final b dIY;
    private final a dIZ;
    private final com.iqoption.view.stickyheadersrecyclerview.b.a dJa;
    private final b dJb;
    private final SparseArray<Rect> dJc;
    private final a dJd;
    private final com.iqoption.view.stickyheadersrecyclerview.c.a dJe;
    private final Rect mTempRect;

    public d(c cVar) {
        this(cVar, new com.iqoption.view.stickyheadersrecyclerview.d.a(), new com.iqoption.view.stickyheadersrecyclerview.b.a(), null);
    }

    private d(c cVar, b bVar, com.iqoption.view.stickyheadersrecyclerview.b.a aVar, b bVar2) {
        this(cVar, bVar, aVar, new com.iqoption.view.stickyheadersrecyclerview.c.a(bVar), new com.iqoption.view.stickyheadersrecyclerview.a.b(cVar, bVar), bVar2);
    }

    private d(c cVar, b bVar, com.iqoption.view.stickyheadersrecyclerview.b.a aVar, com.iqoption.view.stickyheadersrecyclerview.c.a aVar2, a aVar3, b bVar2) {
        this(cVar, aVar2, bVar, aVar, aVar3, new a(cVar, aVar3, bVar, aVar), bVar2);
    }

    private d(c cVar, com.iqoption.view.stickyheadersrecyclerview.c.a aVar, b bVar, com.iqoption.view.stickyheadersrecyclerview.b.a aVar2, a aVar3, a aVar4, b bVar2) {
        this.dJc = new SparseArray();
        this.mTempRect = new Rect();
        this.dIX = cVar;
        this.dIZ = aVar3;
        this.dIY = bVar;
        this.dJe = aVar;
        this.dJa = aVar2;
        this.dJd = aVar4;
        this.dJb = bVar2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1 && this.dJd.u(childAdapterPosition, this.dIY.p(recyclerView))) {
            a(rect, c(recyclerView, childAdapterPosition), this.dIY.h(recyclerView));
        }
    }

    private void a(Rect rect, View view, int i) {
        this.dJa.a(this.mTempRect, view);
        if (i == 1) {
            rect.top = (view.getHeight() + this.mTempRect.top) + this.mTempRect.bottom;
        } else {
            rect.left = (view.getWidth() + this.mTempRect.left) + this.mTempRect.right;
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        super.onDrawOver(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        if (childCount > 0 && this.dIX.getItemCount() > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1) {
                    boolean d = this.dJd.d(childAt, this.dIY.h(recyclerView), childAdapterPosition);
                    if (d || this.dJd.u(childAdapterPosition, this.dIY.p(recyclerView))) {
                        View d2 = this.dIZ.d(recyclerView, childAdapterPosition);
                        Rect rect = (Rect) this.dJc.get(childAdapterPosition);
                        if (rect == null) {
                            rect = new Rect();
                            this.dJc.put(childAdapterPosition, rect);
                        }
                        Rect rect2 = rect;
                        this.dJd.a(rect2, recyclerView, d2, childAt, d);
                        this.dJe.a(recyclerView, canvas, d2, rect2);
                    }
                }
            }
        }
    }

    public View c(RecyclerView recyclerView, int i) {
        return this.dIZ.d(recyclerView, i);
    }
}
