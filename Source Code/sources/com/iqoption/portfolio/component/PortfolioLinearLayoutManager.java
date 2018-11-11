package com.iqoption.portfolio.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

public final class PortfolioLinearLayoutManager extends LinearLayoutManager {
    private static final String TAG = "com.iqoption.portfolio.component.PortfolioLinearLayoutManager";
    private a cZp;

    public interface a {
        void awI();
    }

    public void a(a aVar) {
        this.cZp = aVar;
    }

    public PortfolioLinearLayoutManager(Context context) {
        super(context);
    }

    public PortfolioLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public PortfolioLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* JADX WARNING: Failed to extract finally block: empty outs */
    public void onLayoutChildren(android.support.v7.widget.RecyclerView.Recycler r2, android.support.v7.widget.RecyclerView.State r3) {
        /*
        r1 = this;
        super.onLayoutChildren(r2, r3);	 Catch:{ Exception -> 0x000f }
        r2 = r1.cZp;
        if (r2 == 0) goto L_0x001e;
    L_0x0007:
        r2 = r1.cZp;
        r2.awI();
        goto L_0x001e;
    L_0x000d:
        r2 = move-exception;
        goto L_0x001f;
    L_0x000f:
        r2 = move-exception;
        r3 = TAG;	 Catch:{ all -> 0x000d }
        r0 = r2.getMessage();	 Catch:{ all -> 0x000d }
        com.iqoption.core.i.w(r3, r0, r2);	 Catch:{ all -> 0x000d }
        r2 = r1.cZp;
        if (r2 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0007;
    L_0x001e:
        return;
    L_0x001f:
        r3 = r1.cZp;
        if (r3 == 0) goto L_0x0028;
    L_0x0023:
        r3 = r1.cZp;
        r3.awI();
    L_0x0028:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.portfolio.component.PortfolioLinearLayoutManager.onLayoutChildren(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State):void");
    }
}
