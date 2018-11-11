package com.iqoption.view.stickyheadersrecyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.iqoption.view.stickyheadersrecyclerview.d.b;

/* compiled from: HeaderPositionCalculator */
public class a {
    private final c dIX;
    private final b dIY;
    private final com.iqoption.view.stickyheadersrecyclerview.a.a dIZ;
    private final com.iqoption.view.stickyheadersrecyclerview.b.a dJa;
    private final Rect mTempRect1 = new Rect();
    private final Rect mTempRect2 = new Rect();

    public a(c cVar, com.iqoption.view.stickyheadersrecyclerview.a.a aVar, b bVar, com.iqoption.view.stickyheadersrecyclerview.b.a aVar2) {
        this.dIX = cVar;
        this.dIZ = aVar;
        this.dIY = bVar;
        this.dJa = aVar2;
    }

    public boolean d(View view, int i, int i2) {
        int top;
        this.dJa.a(this.mTempRect1, view);
        if (i == 1) {
            top = view.getTop();
            i = this.mTempRect1.top;
        } else {
            top = view.getLeft();
            i = this.mTempRect1.left;
        }
        if (top > i || this.dIX.cA(i2) < 0) {
            return false;
        }
        return true;
    }

    public boolean u(int i, boolean z) {
        if (hp(i)) {
            return false;
        }
        long cA = this.dIX.cA(i);
        if (cA < 0) {
            return false;
        }
        long j = -1;
        boolean z2 = true;
        int i2 = (z ? 1 : -1) + i;
        if (!hp(i2)) {
            j = this.dIX.cA(i2);
        }
        if (i != (z ? this.dIX.getItemCount() - 1 : 0) && cA == j) {
            z2 = false;
        }
        return z2;
    }

    private boolean hp(int i) {
        return i < 0 || i >= this.dIX.getItemCount();
    }

    public void a(Rect rect, RecyclerView recyclerView, View view, View view2, boolean z) {
        a(rect, recyclerView, view, view2, this.dIY.h(recyclerView));
        if (z && d(recyclerView, view)) {
            View e = e(recyclerView, view);
            RecyclerView recyclerView2 = recyclerView;
            a(recyclerView2, this.dIY.h(recyclerView), rect, view, e, this.dIZ.d(recyclerView, recyclerView.getChildAdapterPosition(e)));
        }
    }

    private void a(Rect rect, RecyclerView recyclerView, View view, View view2, int i) {
        int i2;
        int i3;
        this.dJa.a(this.mTempRect1, view);
        LayoutParams layoutParams = view2.getLayoutParams();
        int i4 = 0;
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            i4 = marginLayoutParams.leftMargin;
            i2 = marginLayoutParams.topMargin;
        } else {
            i2 = 0;
        }
        if (i == 1) {
            int left = (view2.getLeft() - i4) + this.mTempRect1.left;
            i = Math.max(((view2.getTop() - i2) - view.getHeight()) - this.mTempRect1.bottom, n(recyclerView) + this.mTempRect1.top);
            i3 = left;
        } else {
            i = (view2.getTop() - i2) + this.mTempRect1.top;
            i3 = Math.max(((view2.getLeft() - i4) - view.getWidth()) - this.mTempRect1.right, o(recyclerView) + this.mTempRect1.left);
        }
        rect.set(i3, i, view.getWidth() + i3, view.getHeight() + i);
    }

    private boolean d(RecyclerView recyclerView, View view) {
        View e = e(recyclerView, view);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(e);
        if (childAdapterPosition == -1) {
            return false;
        }
        boolean p = this.dIY.p(recyclerView);
        if (childAdapterPosition > 0 && u(childAdapterPosition, p)) {
            View d = this.dIZ.d(recyclerView, childAdapterPosition);
            this.dJa.a(this.mTempRect1, d);
            this.dJa.a(this.mTempRect2, view);
            if (this.dIY.h(recyclerView) == 1) {
                if (((e.getTop() - this.mTempRect1.bottom) - d.getHeight()) - this.mTempRect1.top < ((recyclerView.getPaddingTop() + view.getBottom()) + this.mTempRect2.top) + this.mTempRect2.bottom) {
                    return true;
                }
            } else if (((e.getLeft() - this.mTempRect1.right) - d.getWidth()) - this.mTempRect1.left < ((recyclerView.getPaddingLeft() + view.getRight()) + this.mTempRect2.left) + this.mTempRect2.right) {
                return true;
            }
        }
        return false;
    }

    private void a(RecyclerView recyclerView, int i, Rect rect, View view, View view2, View view3) {
        this.dJa.a(this.mTempRect1, view3);
        this.dJa.a(this.mTempRect2, view);
        int n;
        if (i == 1) {
            n = (n(recyclerView) + this.mTempRect2.top) + this.mTempRect2.bottom;
            i = ((((view2.getTop() - view3.getHeight()) - this.mTempRect1.bottom) - this.mTempRect1.top) - view.getHeight()) - n;
            if (i < n) {
                rect.top += i;
                return;
            }
            return;
        }
        n = (o(recyclerView) + this.mTempRect2.left) + this.mTempRect2.right;
        i = ((((view2.getLeft() - view3.getWidth()) - this.mTempRect1.right) - this.mTempRect1.left) - view.getWidth()) - n;
        if (i < n) {
            rect.left += i;
        }
    }

    private View e(RecyclerView recyclerView, View view) {
        boolean p = this.dIY.p(recyclerView);
        int i = p ? -1 : 1;
        int childCount = p ? recyclerView.getChildCount() - 1 : 0;
        while (childCount >= 0 && childCount <= recyclerView.getChildCount() - 1) {
            View childAt = recyclerView.getChildAt(childCount);
            if (!a(recyclerView, childAt, view, this.dIY.h(recyclerView))) {
                return childAt;
            }
            childCount += i;
        }
        return null;
    }

    private boolean a(RecyclerView recyclerView, View view, View view2, int i) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        this.dJa.a(this.mTempRect1, view2);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1 || this.dIZ.d(recyclerView, childAdapterPosition) != view2) {
            return false;
        }
        if (i == 1) {
            if (view.getTop() - layoutParams.topMargin >= ((n(recyclerView) + view2.getBottom()) + this.mTempRect1.bottom) + this.mTempRect1.top) {
                return false;
            }
        } else if (view.getLeft() - layoutParams.leftMargin >= ((o(recyclerView) + view2.getRight()) + this.mTempRect1.right) + this.mTempRect1.left) {
            return false;
        }
        return true;
    }

    private int n(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            return recyclerView.getPaddingTop();
        }
        return this.dIX.aK(recyclerView.getContext());
    }

    private int o(RecyclerView recyclerView) {
        return recyclerView.getLayoutManager().getClipToPadding() ? recyclerView.getPaddingLeft() : 0;
    }
}
