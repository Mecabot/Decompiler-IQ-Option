package com.iqoption.charttools.templates.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.charttools.b.aa;
import com.iqoption.charttools.o;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/charttools/templates/viewholder/IndicatorViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/databinding/TemplatesIndicatorItemBinding;", "Lcom/iqoption/charttools/templates/IndicatorItem;", "callback", "Lcom/iqoption/charttools/templates/viewholder/ViewHolderCallback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/templates/viewholder/ViewHolderCallback;Landroid/view/ViewGroup;)V", "bind", "", "item", "techtools_release"})
/* compiled from: IndicatorViewHolder.kt */
public final class b extends c<aa, com.iqoption.charttools.templates.c> {
    private final d azk;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/templates/viewholder/IndicatorViewHolder$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "techtools_release"})
    /* compiled from: IndicatorViewHolder.kt */
    public static final class a extends g {
        final /* synthetic */ b aAx;

        a(b bVar) {
            this.aAx = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            com.iqoption.charttools.templates.c cVar = (com.iqoption.charttools.templates.c) this.aAx.ZU();
            if (cVar != null) {
                int id = view.getId();
                if (id == o.g.btnVisibility) {
                    this.aAx.azk.a(cVar);
                } else if (id == o.g.btnSettings) {
                    this.aAx.azk.b(cVar);
                } else if (id == o.g.btnDelete) {
                    this.aAx.azk.c(cVar);
                }
            }
        }
    }

    public b(d dVar, ViewGroup viewGroup) {
        h.e(dVar, "callback");
        h.e(viewGroup, "parent");
        super(o.h.templates_indicator_item, viewGroup);
        this.azk = dVar;
        aa aaVar = (aa) getBinding();
        OnClickListener aVar = new a(this);
        aaVar.axK.setOnClickListener(aVar);
        aaVar.axJ.setOnClickListener(aVar);
        aaVar.axI.setOnClickListener(aVar);
    }

    public void a(aa aaVar, com.iqoption.charttools.templates.c cVar) {
        h.e(aaVar, "$receiver");
        h.e(cVar, "item");
        TextView textView = aaVar.aig;
        h.d(textView, "name");
        textView.setText(cVar.getName());
        ImageView imageView = aaVar.axK;
        h.d(imageView, "btnVisibility");
        imageView.setSelected(cVar.JS().isHidden());
    }
}
