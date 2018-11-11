package com.iqoption.view.stickyheadersrecyclerview.c;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.iqoption.view.stickyheadersrecyclerview.d.b;

/* compiled from: HeaderRenderer */
public class a {
    private final b dIY;
    private final com.iqoption.view.stickyheadersrecyclerview.b.a dJa;
    private final Rect mTempRect;

    public a(b bVar) {
        this(bVar, new com.iqoption.view.stickyheadersrecyclerview.b.a());
    }

    private a(b bVar, com.iqoption.view.stickyheadersrecyclerview.b.a aVar) {
        this.mTempRect = new Rect();
        this.dIY = bVar;
        this.dJa = aVar;
    }

    public void a(RecyclerView recyclerView, Canvas canvas, View view, Rect rect) {
        canvas.save();
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            a(this.mTempRect, recyclerView, view);
            canvas.clipRect(this.mTempRect);
        }
        canvas.translate((float) rect.left, (float) rect.top);
        view.draw(canvas);
        canvas.restore();
    }

    private void a(Rect rect, RecyclerView recyclerView, View view) {
        this.dJa.a(rect, view);
        if (this.dIY.h(recyclerView) == 1) {
            rect.set(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), (recyclerView.getWidth() - recyclerView.getPaddingRight()) - rect.right, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            rect.set(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getWidth() - recyclerView.getPaddingRight(), (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - rect.bottom);
        }
    }
}
