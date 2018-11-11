package com.iqoption.core.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/analytics/AnalyticsScrollEventHelper;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "iqAnalytics", "Lcom/iqoption/core/analytics/IQAnalytics;", "eventName", "", "frequencyInItems", "", "(Lcom/iqoption/core/analytics/IQAnalytics;Ljava/lang/String;I)V", "currentScrollAdapterPosition", "trackingScrollOffset", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "dy", "trackScroll", "scrollOffset", "core_release"})
/* compiled from: AnalyticsScrollEventHelper.kt */
public final class c extends OnScrollListener {
    private int aMA = -1;
    private final e aMB;
    private final int aMC;
    private int aMz;
    private final String sD;

    public c(e eVar, String str, int i) {
        h.e(eVar, "iqAnalytics");
        h.e(str, "eventName");
        this.aMB = eVar;
        this.sD = str;
        this.aMC = i;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView == null) {
            h.aXZ();
        }
        if (recyclerView.getChildCount() != 0 && recyclerView.getAdapter() != null) {
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.aMA = linearLayoutManager != null ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() : 0;
            if (this.aMA % this.aMC == 0) {
                dE(this.aMA);
            }
        }
    }

    private final void dE(int i) {
        if (this.aMz < i) {
            this.aMz = i;
            this.aMB.dW(this.sD);
        }
    }
}
