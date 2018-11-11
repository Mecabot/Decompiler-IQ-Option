package com.iqoption.charttools.tools.a;

import android.view.ViewGroup;
import com.iqoption.charttools.tools.c.e;
import com.iqoption.charttools.tools.c.f;
import com.iqoption.charttools.tools.data.k;
import com.iqoption.charttools.tools.data.l;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import com.iqoption.x.R;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/charttools/tools/adapters/TemplatesAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/IQAdapter;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/tools/data/TemplateAdapterItem;", "callbacks", "Lcom/iqoption/charttools/tools/adapters/TemplatesAdapter$Callbacks;", "(Lcom/iqoption/charttools/tools/adapters/TemplatesAdapter$Callbacks;)V", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TemplatesAdapter.kt */
public final class d extends com.iqoption.core.ui.widget.recyclerview.adapter.a<c<?, ?>, k> {
    public static final b aBK = new b();
    private final a aBJ;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/charttools/tools/adapters/TemplatesAdapter$Companion;", "", "()V", "VIEW_TYPE_EMPTY", "", "VIEW_TYPE_ITEM", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TemplatesAdapter.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, aXE = {"Lcom/iqoption/charttools/tools/adapters/TemplatesAdapter$Callbacks;", "Lcom/iqoption/charttools/tools/viewholder/TemplateViewHolder$Callback;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TemplatesAdapter.kt */
    public interface a extends com.iqoption.charttools.tools.c.e.a {
    }

    public d(a aVar) {
        h.e(aVar, "callbacks");
        this.aBJ = aVar;
    }

    /* renamed from: i */
    public c<?, ?> onCreateViewHolder(ViewGroup viewGroup, int i) {
        h.e(viewGroup, "parent");
        switch (i) {
            case 1:
                return new e(this.aBJ, viewGroup);
            case 2:
                return new f((int) R.string.you_have_no_templates, viewGroup);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(c<?, ?> cVar, int i) {
        h.e(cVar, "holder");
        if (cVar.getItemViewType() == 1) {
            e eVar = (e) cVar;
            com.iqoption.core.ui.widget.recyclerview.adapter.a.d dW = getItem(i);
            if (dW == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.tools.data.TemplateItem");
            }
            eVar.bo((l) dW);
        }
    }

    public int getItemViewType(int i) {
        return ((k) getItem(i)) instanceof l ? 1 : 2;
    }
}
