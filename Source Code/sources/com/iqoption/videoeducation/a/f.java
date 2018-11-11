package com.iqoption.videoeducation.a;

import android.view.ViewGroup;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import com.iqoption.videoeducation.e;
import com.iqoption.videoeducation.g;
import com.iqoption.x.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/videoeducation/component/VideoCatalogsAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "Lcom/iqoption/videoeducation/VideoCatalogAdapterItem;", "callbacks", "Lcom/iqoption/videoeducation/component/VideoCatalogsAdapter$Callbacks;", "(Lcom/iqoption/videoeducation/component/VideoCatalogsAdapter$Callbacks;)V", "imageSize", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideoCatalogsAdapter.kt */
public final class f extends com.iqoption.core.ui.widget.recyclerview.adapter.a<com.iqoption.core.ui.widget.recyclerview.a.b<?>, e> {
    public static final b dzK = new b();
    private final a dzJ;
    private final int imageSize = com.iqoption.core.ext.a.k(com.iqoption.core.f.RR(), R.dimen.dp26);

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/videoeducation/component/VideoCatalogsAdapter$Companion;", "", "()V", "VIEW_TYPE_ERROR", "", "VIEW_TYPE_ITEM", "VIEW_TYPE_LOADING", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideoCatalogsAdapter.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, aXE = {"Lcom/iqoption/videoeducation/component/VideoCatalogsAdapter$Callbacks;", "Lcom/iqoption/videoeducation/component/VideoCatalogViewHolder$Callback;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VideoCatalogsAdapter.kt */
    public interface a extends com.iqoption.videoeducation.a.e.b {
    }

    public f(a aVar) {
        h.e(aVar, "callbacks");
        this.dzJ = aVar;
    }

    /* renamed from: e */
    public com.iqoption.core.ui.widget.recyclerview.a.b<?> onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        if (i == 1) {
            return new e(this.dzJ, this.imageSize, this.imageSize, viewGroup);
        }
        switch (i) {
            case -2:
                return new c(viewGroup);
            case -1:
                return new d(viewGroup);
            default:
                com.iqoption.core.ui.widget.recyclerview.adapter.a.bgj.unsupportedViewType(i);
                throw null;
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(com.iqoption.core.ui.widget.recyclerview.a.b<?> bVar, int i) {
        h.e(bVar, "holder");
        if (bVar.getItemViewType() == 1) {
            e eVar = (e) bVar;
            d dW = getItem(i);
            if (dW == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.videoeducation.VideoCatalogItem");
            }
            eVar.bo((g) dW);
        }
    }

    public int getItemViewType(int i) {
        e eVar = (e) getItem(i);
        if (eVar instanceof com.iqoption.videoeducation.h) {
            return -1;
        }
        if (eVar instanceof com.iqoption.videoeducation.f) {
            return -2;
        }
        if (eVar instanceof g) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
