package com.iqoption.charttools.tools.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.charttools.model.indicator.h;
import com.iqoption.charttools.model.indicator.k;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import com.iqoption.d.z;
import com.iqoption.x.R;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/ActiveIndicatorViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/databinding/ActiveToolsItemBinding;", "Lcom/iqoption/charttools/tools/data/ActiveIndicatorItem;", "callback", "Lcom/iqoption/charttools/tools/viewholder/ActiveIndicatorViewHolder$Callback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/tools/viewholder/ActiveIndicatorViewHolder$Callback;Landroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ActiveIndicatorViewHolder.kt */
public final class a extends c<z, com.iqoption.charttools.tools.data.a> {
    private final a aCu;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/ActiveIndicatorViewHolder$Callback;", "", "onItemClick", "", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "onItemRemoveClick", "onItemSettingsClick", "onItemToggleVisibilityClick", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveIndicatorViewHolder.kt */
    public interface a {
        void q(h hVar);

        void r(h hVar);

        void s(h hVar);

        void t(h hVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/tools/viewholder/ActiveIndicatorViewHolder$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ActiveIndicatorViewHolder.kt */
    public static final class b extends g {
        final /* synthetic */ a aCv;

        b(a aVar) {
            this.aCv = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            com.iqoption.charttools.tools.data.a aVar = (com.iqoption.charttools.tools.data.a) this.aCv.ZU();
            if (aVar != null) {
                h JS = aVar.JS();
                if (JS != null) {
                    int id = view.getId();
                    if (id == R.id.content) {
                        this.aCv.aCu.q(JS);
                    } else if (id == R.id.editIndicator) {
                        this.aCv.aCu.s(JS);
                    } else if (id == R.id.removeIndicator) {
                        this.aCv.aCu.t(JS);
                    } else if (id == R.id.visibleIndicator) {
                        this.aCv.aCu.r(JS);
                    }
                }
            }
        }
    }

    public a(a aVar, ViewGroup viewGroup) {
        kotlin.jvm.internal.h.e(aVar, "callback");
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        super(R.layout.active_tools_item, viewGroup);
        this.aCu = aVar;
        OnClickListener bVar = new b(this);
        this.itemView.setOnClickListener(bVar);
        ((z) getBinding()).biE.setOnClickListener(bVar);
        ((z) getBinding()).biB.setOnClickListener(bVar);
        ((z) getBinding()).biC.setOnClickListener(bVar);
    }

    public void a(z zVar, com.iqoption.charttools.tools.data.a aVar) {
        kotlin.jvm.internal.h.e(zVar, "$receiver");
        kotlin.jvm.internal.h.e(aVar, "item");
        TextView textView = zVar.aig;
        kotlin.jvm.internal.h.d(textView, "name");
        textView.setText(aVar.getTitle());
        textView = zVar.biD;
        kotlin.jvm.internal.h.d(textView, "snippet");
        textView.setText(aVar.Oc());
        zVar.biD.setTextColor(aVar.Od());
        ImageView imageView = zVar.biE;
        kotlin.jvm.internal.h.d(imageView, "visibleIndicator");
        imageView.setSelected(aVar.JS().isHidden());
        View view = this.itemView;
        kotlin.jvm.internal.h.d(view, "itemView");
        view.setClickable(aVar.JS().KJ() instanceof k);
    }
}
