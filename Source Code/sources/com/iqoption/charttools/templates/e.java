package com.iqoption.charttools.templates;

import android.view.ViewGroup;
import com.iqoption.charttools.templates.a.c;
import com.iqoption.charttools.templates.a.d;
import com.iqoption.core.ui.widget.recyclerview.a.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0012B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/charttools/templates/InstrumentItemsAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/IQViewHolder;", "Lcom/iqoption/charttools/templates/InstrumentAdapterItem;", "Lcom/iqoption/charttools/templates/InstrumentItemsDecoration$ViewTypeProvider;", "callback", "Lcom/iqoption/charttools/templates/viewholder/ViewHolderCallback;", "(Lcom/iqoption/charttools/templates/viewholder/ViewHolderCallback;)V", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "techtools_release"})
/* compiled from: InstrumentItemsAdapter.kt */
public final class e extends com.iqoption.core.ui.widget.recyclerview.adapter.a<b<?>, d> implements com.iqoption.charttools.templates.f.a {
    public static final a azl = new a();
    private final d azk;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/templates/InstrumentItemsAdapter$Companion;", "", "()V", "VIEW_TYPE_FIGURE", "", "VIEW_TYPE_INDICATOR", "VIEW_TYPE_TITLE", "techtools_release"})
    /* compiled from: InstrumentItemsAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public e(d dVar) {
        h.e(dVar, "callback");
        this.azk = dVar;
    }

    /* renamed from: e */
    public b<?> onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        switch (i) {
            case 1:
                return new c(viewGroup);
            case 2:
                return new com.iqoption.charttools.templates.a.b(this.azk, viewGroup);
            case 3:
                return new com.iqoption.charttools.templates.a.a(this.azk, viewGroup);
            default:
                com.iqoption.core.ui.widget.recyclerview.adapter.a.bgj.unsupportedViewType(i);
                throw null;
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(b<?> bVar, int i) {
        h.e(bVar, "holder");
        com.iqoption.core.ui.widget.recyclerview.adapter.a.d dW;
        switch (bVar.getItemViewType()) {
            case 1:
                c cVar = (c) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.templates.TitleItem");
                }
                cVar.bo((o) dW);
                return;
            case 2:
                com.iqoption.charttools.templates.a.b bVar2 = (com.iqoption.charttools.templates.a.b) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.templates.IndicatorItem");
                }
                bVar2.bo((c) dW);
                return;
            case 3:
                com.iqoption.charttools.templates.a.a aVar = (com.iqoption.charttools.templates.a.a) bVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.templates.FigureItem");
                }
                aVar.bo((b) dW);
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        d dVar = (d) getItem(i);
        if (dVar instanceof o) {
            return 1;
        }
        if (dVar instanceof c) {
            return 2;
        }
        if (dVar instanceof b) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }
}
