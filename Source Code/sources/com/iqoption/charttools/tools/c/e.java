package com.iqoption.charttools.tools.c;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.charttools.tools.data.l;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import com.iqoption.d.akg;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/TemplateViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/databinding/TemplateItemBinding;", "Lcom/iqoption/charttools/tools/data/TemplateItem;", "callback", "Lcom/iqoption/charttools/tools/viewholder/TemplateViewHolder$Callback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/tools/viewholder/TemplateViewHolder$Callback;Landroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TemplateViewHolder.kt */
public final class e extends c<akg, l> {
    private final a aCC;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/TemplateViewHolder$Callback;", "", "onItemClick", "", "item", "Lcom/iqoption/charttools/tools/data/TemplateItem;", "onItemRemoveClick", "onItemSettingsClick", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TemplateViewHolder.kt */
    public interface a {
        void d(l lVar);

        void e(l lVar);

        void f(l lVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/tools/viewholder/TemplateViewHolder$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TemplateViewHolder.kt */
    public static final class b extends g {
        final /* synthetic */ e aCD;

        b(e eVar) {
            this.aCD = eVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            l lVar = (l) this.aCD.ZU();
            if (lVar != null) {
                int id = view.getId();
                if (id == R.id.btnEdit) {
                    this.aCD.aCC.e(lVar);
                } else if (id == R.id.btnRemove) {
                    this.aCD.aCC.f(lVar);
                } else if (id == R.id.content) {
                    this.aCD.aCC.d(lVar);
                }
            }
        }
    }

    public e(a aVar, ViewGroup viewGroup) {
        h.e(aVar, "callback");
        h.e(viewGroup, "parent");
        super(R.layout.template_item, viewGroup);
        this.aCC = aVar;
        OnClickListener bVar = new b(this);
        ((akg) getBinding()).axL.setOnClickListener(bVar);
        ((akg) getBinding()).bLv.setOnClickListener(bVar);
        ((akg) getBinding()).bTD.setOnClickListener(bVar);
    }

    public void a(akg akg, l lVar) {
        h.e(akg, "$receiver");
        h.e(lVar, "item");
        TextView textView = akg.aig;
        h.d(textView, "name");
        textView.setText(lVar.Oh().getName());
        textView = akg.bTF;
        h.d(textView, "indicators");
        textView.setText(lVar.Oi());
        ConstraintLayout constraintLayout = akg.axL;
        h.d(constraintLayout, com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT);
        constraintLayout.setEnabled(lVar.Oj() ^ 1);
    }
}
