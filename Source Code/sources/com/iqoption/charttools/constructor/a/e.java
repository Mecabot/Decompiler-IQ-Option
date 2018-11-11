package com.iqoption.charttools.constructor.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.charttools.b.k;
import com.iqoption.charttools.constructor.l;
import com.iqoption.charttools.o;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/GroupTitleViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorGroupTitleItemBinding;", "Lcom/iqoption/charttools/constructor/InputGroupTitle;", "callback", "Lcom/iqoption/charttools/constructor/viewholder/GroupTitleViewHolder$Callback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/constructor/viewholder/GroupTitleViewHolder$Callback;Landroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "techtools_release"})
/* compiled from: GroupTitleViewHolder.kt */
public final class e extends c<k, l> {
    private final a avj;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/GroupTitleViewHolder$Callback;", "", "onItemToggled", "", "item", "Lcom/iqoption/charttools/constructor/InputGroupTitle;", "techtools_release"})
    /* compiled from: GroupTitleViewHolder.kt */
    public interface a {
        void a(l lVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/constructor/viewholder/GroupTitleViewHolder$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "techtools_release"})
    /* compiled from: GroupTitleViewHolder.kt */
    /* renamed from: com.iqoption.charttools.constructor.a.e$1 */
    public static final class AnonymousClass1 extends g {
        final /* synthetic */ e avk;

        AnonymousClass1(e eVar) {
            this.avk = eVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            l lVar = (l) this.avk.ZU();
            if (lVar != null && lVar.Lg()) {
                ImageView imageView = ((k) this.avk.getBinding()).axz;
                imageView.setSelected(imageView.isSelected() ^ 1);
                this.avk.avj.a(lVar);
            }
        }
    }

    public e(a aVar, ViewGroup viewGroup) {
        h.e(aVar, "callback");
        h.e(viewGroup, "parent");
        super(o.h.indicator_constructor_group_title_item, viewGroup);
        this.avj = aVar;
        ((k) getBinding()).axz.setOnClickListener(new AnonymousClass1(this));
    }

    public void a(k kVar, l lVar) {
        h.e(kVar, "$receiver");
        h.e(lVar, "item");
        TextView textView = kVar.agA;
        h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        textView.setText(lVar.getText());
        ImageView imageView;
        if (lVar.Lg()) {
            ImageView imageView2 = kVar.axz;
            h.d(imageView2, "btnExpand");
            com.iqoption.core.ext.a.L(imageView2);
            imageView = kVar.axz;
            h.d(imageView, "btnExpand");
            imageView.setSelected(lVar.isExpanded());
            return;
        }
        imageView = kVar.axz;
        h.d(imageView, "btnExpand");
        com.iqoption.core.ext.a.M(imageView);
    }
}
