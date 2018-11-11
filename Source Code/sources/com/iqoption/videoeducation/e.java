package com.iqoption.videoeducation;

import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u0007\b\t¨\u0006\n"}, aXE = {"Lcom/iqoption/videoeducation/VideoCatalogAdapterItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "id", "(J)V", "getId", "()Ljava/lang/Long;", "Lcom/iqoption/videoeducation/VideoCatalogLoadingItem;", "Lcom/iqoption/videoeducation/VideoCatalogErrorItem;", "Lcom/iqoption/videoeducation/VideoCatalogItem;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideoCatalogAdapterItems.kt */
public abstract class e implements d<Long> {
    private final long id;

    private e(long j) {
        this.id = j;
    }

    public /* synthetic */ e(long j, f fVar) {
        this(j);
    }

    /* renamed from: getId */
    public Long Jf() {
        return Long.valueOf(this.id);
    }
}
