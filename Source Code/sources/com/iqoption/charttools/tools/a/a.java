package com.iqoption.charttools.tools.a;

import android.view.ViewGroup;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/charttools/tools/adapters/ActiveIndicatorsAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/charttools/tools/viewholder/ActiveIndicatorViewHolder;", "Lcom/iqoption/charttools/tools/data/ActiveIndicatorItem;", "callbacks", "Lcom/iqoption/charttools/tools/adapters/ActiveIndicatorsAdapter$Callbacks;", "(Lcom/iqoption/charttools/tools/adapters/ActiveIndicatorsAdapter$Callbacks;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveIndicatorsAdapter.kt */
public final class a extends com.iqoption.core.ui.widget.recyclerview.adapter.a<com.iqoption.charttools.tools.c.a, com.iqoption.charttools.tools.data.a> {
    private final a aBF;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, aXE = {"Lcom/iqoption/charttools/tools/adapters/ActiveIndicatorsAdapter$Callbacks;", "Lcom/iqoption/charttools/tools/viewholder/ActiveIndicatorViewHolder$Callback;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveIndicatorsAdapter.kt */
    public interface a extends com.iqoption.charttools.tools.c.a.a {
    }

    public a(a aVar) {
        h.e(aVar, "callbacks");
        this.aBF = aVar;
    }

    /* renamed from: h */
    public com.iqoption.charttools.tools.c.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        return new com.iqoption.charttools.tools.c.a(this.aBF, viewGroup);
    }

    /* renamed from: a */
    public void onBindViewHolder(com.iqoption.charttools.tools.c.a aVar, int i) {
        h.e(aVar, "holder");
        aVar.bo(getItem(i));
    }
}
