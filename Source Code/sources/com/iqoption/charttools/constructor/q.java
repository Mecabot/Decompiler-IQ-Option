package com.iqoption.charttools.constructor;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.iqoption.core.util.j;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/constructor/InputItemsScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "()V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "techtools_release"})
/* compiled from: InputItemsScrollListener.kt */
public final class q extends OnScrollListener {
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 1) {
            View focusedChild = recyclerView != null ? recyclerView.getFocusedChild() : null;
            if (focusedChild != null) {
                focusedChild.clearFocus();
                j.R(focusedChild);
            }
        }
    }
}
