package com.iqoption.charttools.tools.data;

import com.google.android.gms.plus.PlusShare;
import com.iqoption.charttools.model.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/tools/data/CategoryItem;", "Lcom/iqoption/charttools/tools/data/CategoryAdapterItem;", "category", "Lcom/iqoption/charttools/model/IndicatorCategory;", "title", "", "(Lcom/iqoption/charttools/model/IndicatorCategory;Ljava/lang/String;)V", "getCategory", "()Lcom/iqoption/charttools/model/IndicatorCategory;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CategoryItem.kt */
public final class d extends c {
    private final a aBO;

    public d(a aVar, String str) {
        h.e(aVar, "category");
        h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        super(aVar.getId(), str, null);
        this.aBO = aVar;
    }

    public final a Oe() {
        return this.aBO;
    }
}
