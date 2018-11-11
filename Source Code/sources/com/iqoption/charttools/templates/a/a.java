package com.iqoption.charttools.templates.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.charttools.b.y;
import com.iqoption.charttools.o;
import com.iqoption.charttools.templates.b;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/charttools/templates/viewholder/FigureViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/databinding/TemplatesFigureItemBinding;", "Lcom/iqoption/charttools/templates/FigureItem;", "callback", "Lcom/iqoption/charttools/templates/viewholder/ViewHolderCallback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/templates/viewholder/ViewHolderCallback;Landroid/view/ViewGroup;)V", "bind", "", "item", "techtools_release"})
/* compiled from: FigureViewHolder.kt */
public final class a extends c<y, b> {
    private final d azk;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/templates/viewholder/FigureViewHolder$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "techtools_release"})
    /* compiled from: FigureViewHolder.kt */
    public static final class a extends g {
        final /* synthetic */ a aAw;

        a(a aVar) {
            this.aAw = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            b bVar = (b) this.aAw.ZU();
            if (bVar != null) {
                int id = view.getId();
                if (id == o.g.btnVisibility) {
                    this.aAw.azk.a(bVar);
                } else if (id == o.g.btnSettings) {
                    this.aAw.azk.b(bVar);
                } else if (id == o.g.btnDelete) {
                    this.aAw.azk.c(bVar);
                }
            }
        }
    }

    public a(d dVar, ViewGroup viewGroup) {
        h.e(dVar, "callback");
        h.e(viewGroup, "parent");
        super(o.h.templates_figure_item, viewGroup);
        this.azk = dVar;
        y yVar = (y) getBinding();
        OnClickListener aVar = new a(this);
        yVar.axK.setOnClickListener(aVar);
        yVar.axJ.setOnClickListener(aVar);
        yVar.axI.setOnClickListener(aVar);
    }

    public void a(y yVar, b bVar) {
        h.e(yVar, "$receiver");
        h.e(bVar, "item");
        TextView textView = yVar.aig;
        h.d(textView, "name");
        textView.setText(bVar.getName());
        textView = yVar.axH;
        h.d(textView, "active");
        textView.setText(bVar.ML());
        ImageView imageView = yVar.axK;
        h.d(imageView, "btnVisibility");
        imageView.setSelected(bVar.MM().isHidden());
    }
}
