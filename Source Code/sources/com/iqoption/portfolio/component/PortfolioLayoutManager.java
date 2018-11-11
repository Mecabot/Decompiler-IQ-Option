package com.iqoption.portfolio.component;

import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;
import com.iqoption.util.g;

public final class PortfolioLayoutManager extends LayoutManager implements ScrollVectorProvider {
    public static final String TAG = "com.iqoption.portfolio.component.PortfolioLayoutManager";
    private final SparseArray<View> cZg = new SparseArray();
    private final b cZh;
    private int cZi = -1;
    private int cZj = -1;
    private View cZk;
    private View cZl;
    private final a cZm = new a();
    private int cZn = -1;
    private int cZo = -1;

    private static final class a implements Parcelable {
        public static final Creator<a> CREATOR = new Creator<a>() {
            /* renamed from: X */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* renamed from: fY */
            public a[] newArray(int i) {
                return new a[i];
            }
        };
        int bottom;
        int position;
        int top;

        public int describeContents() {
            return 0;
        }

        a() {
        }

        void a(a aVar) {
            this.top = aVar.top;
            this.bottom = aVar.bottom;
            this.position = aVar.position;
        }

        void reset() {
            this.top = 0;
            this.bottom = 0;
            this.position = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.top);
            parcel.writeInt(this.bottom);
            parcel.writeInt(this.position);
        }

        protected a(Parcel parcel) {
            this.top = parcel.readInt();
            this.bottom = parcel.readInt();
            this.position = parcel.readInt();
        }

        public boolean a(PortfolioLayoutManager portfolioLayoutManager) {
            return this.position >= portfolioLayoutManager.getItemCount();
        }
    }

    public interface b {
        int fZ(int i);
    }

    private boolean fU(int i) {
        return i == 1 || i == 4;
    }

    private boolean fV(int i) {
        return i == 2 || i == 5;
    }

    private boolean fW(int i) {
        return i == -3 || i == 3 || i == 6;
    }

    public boolean canScrollVertically() {
        return true;
    }

    public PortfolioLayoutManager(b bVar) {
        this.cZh = bVar;
    }

    public Parcelable onSaveInstanceState() {
        return new g().a("key.anchor", this.cZm).toBundle();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            this.cZm.a((a) ((Bundle) parcelable).getParcelable("key.anchor"));
        }
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        Recycler recycler2;
        detachAndScrapAttachedViews(recycler);
        this.cZg.clear();
        if (this.cZm.a(this)) {
            this.cZm.reset();
        }
        this.cZk = null;
        this.cZi = -1;
        this.cZl = null;
        this.cZj = -1;
        b(recycler, state);
        c(recycler, state);
        int childCount = getChildCount();
        if (childCount <= state.getItemCount()) {
            int paddingBottom = (getPaddingBottom() + getHeight()) - getDecoratedBottom(getChildAt(childCount - 1));
            if (paddingBottom > 0) {
                View childAt = getChildAt(0);
                int position = getPosition(childAt) - 1;
                int top = childAt.getTop();
                int i = position;
                Object obj = 1;
                int i2 = 0;
                while (obj != null && i >= 0) {
                    View viewForPosition = recycler.getViewForPosition(i);
                    addView(viewForPosition, 0);
                    measureChildWithMargins(viewForPosition, 0, 0);
                    int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                    layoutDecoratedWithMargins(viewForPosition, 0, top - decoratedMeasuredHeight, getDecoratedMeasuredWidth(viewForPosition), top);
                    top = getDecoratedTop(viewForPosition);
                    i2 += decoratedMeasuredHeight;
                    obj = paddingBottom > i2 ? 1 : null;
                    i--;
                }
                recycler2 = recycler;
                offsetChildrenVertical(Math.min(paddingBottom, i2));
                awH();
                a(recycler, state);
                if (this.cZn != -1 && this.cZo != -1) {
                    this.cZn = -1;
                    this.cZo = -1;
                    return;
                }
            }
        }
        recycler2 = recycler;
        awH();
        a(recycler, state);
        if (this.cZn != -1) {
        }
    }

    private void a(Recycler recycler, State state) {
        if (getChildCount() > 1) {
            int i = 0;
            View childAt = getChildAt(0);
            int position = getPosition(childAt);
            int itemViewType = getItemViewType(childAt);
            View childAt2 = getChildAt(1);
            int position2 = getPosition(childAt2);
            int itemViewType2 = getItemViewType(childAt2);
            View view;
            int decoratedMeasuredHeight;
            if (this.cZk != null) {
                int decoratedTop;
                int i2;
                if (fU(itemViewType) && fW(itemViewType2)) {
                    if (position >= this.cZi || position2 <= this.cZi) {
                        this.cZk = childAt;
                        this.cZi = position;
                        detachView(this.cZk);
                        attachView(this.cZk);
                        layoutDecoratedWithMargins(this.cZk, 0, 0, getDecoratedMeasuredWidth(this.cZk), getDecoratedMeasuredHeight(this.cZk));
                    } else {
                        attachView(this.cZk, 1);
                        this.cZg.remove(this.cZi);
                        decoratedTop = getDecoratedTop(childAt2);
                        position2 = getDecoratedBottom(childAt);
                        layoutDecoratedWithMargins(this.cZk, 0, position2, getDecoratedMeasuredWidth(this.cZk), decoratedTop);
                        this.cZk = null;
                        this.cZi = -1;
                    }
                    awH();
                } else if (fW(itemViewType)) {
                    int fZ = this.cZh.fZ(position);
                    if (fZ != this.cZi) {
                        itemViewType = getChildCount() - getHeadersCount();
                        i2 = 0;
                        while (i2 < itemViewType) {
                            position2 = i2 + 1;
                            childAt2 = getChildAt(i2);
                            if (this.cZi - getPosition(childAt2) == 1) {
                                attachView(this.cZk, position2);
                                this.cZg.remove(this.cZi);
                                position2 = getDecoratedBottom(childAt2);
                                decoratedTop = position2 + getDecoratedMeasuredHeight(this.cZk);
                                layoutDecoratedWithMargins(this.cZk, 0, position2, getDecoratedMeasuredWidth(this.cZk), decoratedTop);
                                awH();
                                break;
                            }
                            i2 = position2 + 1;
                        }
                        this.cZi = fZ;
                    }
                    view = (View) this.cZg.get(this.cZi);
                    if (view == null) {
                        this.cZk = recycler.getViewForPosition(this.cZh.fZ(position));
                        addView(this.cZk);
                        measureChildWithMargins(this.cZk, 0, 0);
                    } else {
                        this.cZk = view;
                        attachView(this.cZk);
                        this.cZg.remove(this.cZi);
                    }
                    decoratedMeasuredHeight = getDecoratedMeasuredHeight(this.cZk);
                    layoutDecoratedWithMargins(this.cZk, 0, 0, getDecoratedMeasuredWidth(this.cZk), decoratedMeasuredHeight);
                    a(childAt, this.cZk, decoratedMeasuredHeight);
                } else {
                    if (position - this.cZi != 1 || getDecoratedTop(childAt) <= 0) {
                        itemViewType = getChildCount() - getHeadersCount();
                        i2 = getPosition(getChildAt(itemViewType - 1));
                        if (this.cZi > position && this.cZi < i2) {
                            while (i < itemViewType) {
                                i2 = i + 1;
                                View childAt3 = getChildAt(i);
                                if (this.cZi - getPosition(childAt3) == 1) {
                                    attachView(this.cZk, i2);
                                    this.cZg.remove(this.cZi);
                                    position2 = getDecoratedBottom(childAt3);
                                    decoratedTop = position2 + getDecoratedMeasuredHeight(this.cZk);
                                    layoutDecoratedWithMargins(this.cZk, 0, position2, getDecoratedMeasuredWidth(this.cZk), decoratedTop);
                                    awH();
                                    break;
                                }
                                i = i2 + 1;
                            }
                        }
                    } else {
                        attachView(this.cZk, 0);
                        this.cZg.remove(this.cZi);
                    }
                    this.cZk = null;
                    this.cZi = -1;
                }
            } else if (fU(itemViewType) && fW(itemViewType2) && getDecoratedTop(childAt) < 0) {
                this.cZk = childAt;
                this.cZi = position;
                detachView(this.cZk);
                attachView(this.cZk);
                layoutDecoratedWithMargins(this.cZk, 0, 0, getDecoratedMeasuredWidth(this.cZk), getDecoratedMeasuredHeight(this.cZk));
                awH();
            } else if (fW(itemViewType)) {
                this.cZi = this.cZh.fZ(position);
                view = (View) this.cZg.get(this.cZi);
                if (view == null) {
                    this.cZk = recycler.getViewForPosition(this.cZh.fZ(position));
                    addView(this.cZk);
                    measureChildWithMargins(this.cZk, 0, 0);
                } else {
                    this.cZk = view;
                    attachView(this.cZk);
                    this.cZg.remove(this.cZi);
                }
                decoratedMeasuredHeight = getDecoratedMeasuredHeight(this.cZk);
                layoutDecoratedWithMargins(this.cZk, 0, 0, getDecoratedMeasuredWidth(this.cZk), decoratedMeasuredHeight);
                a(childAt, this.cZk, decoratedMeasuredHeight);
            } else {
                this.cZk = null;
                this.cZi = -1;
            }
        }
    }

    private void a(View view, View view2, int i) {
        int decoratedBottom = getDecoratedBottom(view);
        int i2 = 1;
        while (decoratedBottom < i) {
            int i3 = i2 + 1;
            View childAt = getChildAt(i2);
            decoratedBottom += getDecoratedBottom(childAt);
            int itemViewType = getItemViewType(childAt);
            if (fU(itemViewType) || fV(itemViewType)) {
                i -= getDecoratedTop(childAt);
                break;
            }
            i2 = i3;
        }
        i = 0;
        if (i != 0) {
            ViewCompat.offsetTopAndBottom(view2, -i);
        }
    }

    private boolean fX(int i) {
        return i == this.cZi || i == this.cZj;
    }

    private int getHeadersCount() {
        if (this.cZk == null) {
            return 0;
        }
        if (this.cZl != null) {
            return 2;
        }
        return 1;
    }

    private void b(Recycler recycler, State state) {
        int i = this.cZm.position - 1;
        int i2 = this.cZm.top;
        int i3 = i;
        Object obj = 1;
        while (obj != null && i3 >= 0) {
            if (fX(i3)) {
                i2 -= getDecoratedMeasuredHeight(this.cZk);
            } else {
                View view = (View) this.cZg.get(i3);
                if (view == null) {
                    view = recycler.getViewForPosition(i3);
                    addView(view, 0);
                    measureChildWithMargins(view, 0, 0);
                    layoutDecoratedWithMargins(view, 0, i2 - getDecoratedMeasuredHeight(view), getDecoratedMeasuredWidth(view), i2);
                } else {
                    attachView(view, 0);
                    this.cZg.remove(i3);
                }
                i2 = getDecoratedTop(view);
            }
            obj = i2 > 0 ? 1 : null;
            i3--;
        }
    }

    private void c(Recycler recycler, State state) {
        int height = getHeight();
        int itemCount = state.getItemCount();
        int i = this.cZm.position;
        int i2 = this.cZm.top;
        int i3 = i;
        Object obj = 1;
        while (obj != null && i3 < itemCount) {
            View view = (View) this.cZg.get(i3);
            if (view == null) {
                view = recycler.getViewForPosition(i3);
                addView(view);
                measureChildWithMargins(view, 0, 0);
                layoutDecoratedWithMargins(view, 0, i2, getDecoratedMeasuredWidth(view), i2 + getDecoratedMeasuredHeight(view));
            } else {
                attachView(view);
                this.cZg.remove(i3);
            }
            i2 = getDecoratedBottom(view);
            obj = i2 <= height ? 1 : null;
            i3++;
        }
    }

    private void awH() {
        this.cZm.reset();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (getDecoratedTop(childAt) >= 0) {
                this.cZm.position = getPosition(childAt);
                this.cZm.top = getDecoratedTop(childAt);
                this.cZm.bottom = getDecoratedBottom(childAt);
                return;
            }
        }
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        int i2;
        i = a(i, state);
        offsetChildrenVertical(-i);
        awH();
        this.cZg.clear();
        int childCount = getChildCount();
        while (true) {
            i2 = 0;
            if (childCount == 0) {
                break;
            }
            View childAt = getChildAt(0);
            this.cZg.put(getPosition(childAt), childAt);
            detachView(childAt);
            childCount--;
        }
        b(recycler, state);
        c(recycler, state);
        a(recycler, state);
        int size = this.cZg.size();
        while (i2 < size) {
            recycler.recycleView((View) this.cZg.valueAt(i2));
            i2++;
        }
        return i;
    }

    private int a(int i, State state) {
        int childCount = getChildCount();
        int itemCount = state.getItemCount();
        if (childCount == 0) {
            return 0;
        }
        if (i < 0) {
            View childAt = getChildAt(0);
            childCount = getPosition(childAt);
            if (this.cZk == null || childCount - this.cZi != 1) {
                if (childCount <= 0) {
                    i = Math.max(getDecoratedTop(childAt), i);
                }
            } else if (this.cZi <= 0) {
                i = Math.max(getDecoratedTop(childAt) - getDecoratedBottom(this.cZk), i);
            }
        } else if (i > 0) {
            View childAt2 = getChildAt((childCount - 1) - getHeadersCount());
            if (getPosition(childAt2) >= itemCount - 1) {
                i = Math.min(getDecoratedBottom(childAt2) - getHeight(), i);
            }
        } else {
            i = 0;
        }
        return i;
    }

    public void scrollToPosition(int i) {
        this.cZm.reset();
        if (i != -1) {
            this.cZm.position = i;
        }
        requestLayout();
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        SmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        return new PointF(0.0f, (float) (i < getPosition(getChildAt(0)) ? -1 : 1));
    }
}
