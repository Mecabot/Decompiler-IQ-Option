package com.iqoption.charttools.tools.a;

import android.view.ViewGroup;
import com.iqoption.charttools.tools.c.f;
import com.iqoption.charttools.tools.data.h;
import com.iqoption.charttools.tools.data.m;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import com.iqoption.x.R;
import kotlin.TypeCastException;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/charttools/tools/adapters/IndicatorsAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/tools/data/IndicatorAdapterItem;", "Lcom/iqoption/charttools/tools/decorations/IndicatorsItemDecoration$ViewTypeProvider;", "callbacks", "Lcom/iqoption/charttools/tools/adapters/IndicatorsAdapter$Callbacks;", "(Lcom/iqoption/charttools/tools/adapters/IndicatorsAdapter$Callbacks;)V", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: IndicatorsAdapter.kt */
public final class b extends com.iqoption.core.ui.widget.recyclerview.adapter.a<c<?, ?>, h> {
    public static final b aBH = new b();
    private final a aBG;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/tools/adapters/IndicatorsAdapter$Companion;", "", "()V", "VIEW_TYPE_EMPTY", "", "VIEW_TYPE_INFO", "VIEW_TYPE_TITLE", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: IndicatorsAdapter.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/charttools/tools/adapters/IndicatorsAdapter$Callbacks;", "Lcom/iqoption/charttools/tools/viewholder/IndicatorTitleViewHolder$Callback;", "Lcom/iqoption/charttools/tools/viewholder/IndicatorInfoViewHolder$Callback;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: IndicatorsAdapter.kt */
    public interface a extends com.iqoption.charttools.tools.c.b.b, com.iqoption.charttools.tools.c.c.a {
    }

    public b(a aVar) {
        kotlin.jvm.internal.h.e(aVar, "callbacks");
        this.aBG = aVar;
    }

    /* renamed from: i */
    public c<?, ?> onCreateViewHolder(ViewGroup viewGroup, int i) {
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        switch (i) {
            case 1:
                return new com.iqoption.charttools.tools.c.c(this.aBG, viewGroup);
            case 2:
                return new com.iqoption.charttools.tools.c.b(this.aBG, viewGroup);
            case 3:
                return new f((int) R.string.no_indicators, viewGroup);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(c<?, ?> cVar, int i) {
        kotlin.jvm.internal.h.e(cVar, "holder");
        d dW;
        switch (cVar.getItemViewType()) {
            case 1:
                com.iqoption.charttools.tools.c.c cVar2 = (com.iqoption.charttools.tools.c.c) cVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.tools.data.TitleIndicatorItem");
                }
                cVar2.bo((m) dW);
                return;
            case 2:
                com.iqoption.charttools.tools.c.b bVar = (com.iqoption.charttools.tools.c.b) cVar;
                dW = getItem(i);
                if (dW == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.tools.data.InfoIndicatorItem");
                }
                bVar.bo((com.iqoption.charttools.tools.data.i) dW);
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        h hVar = (h) getItem(i);
        if (hVar instanceof m) {
            return 1;
        }
        return hVar instanceof com.iqoption.charttools.tools.data.i ? 2 : 3;
    }
}
