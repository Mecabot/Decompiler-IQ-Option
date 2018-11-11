package com.iqoption.charttools.tools.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import com.iqoption.d.vp;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/IndicatorInfoViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/databinding/IndicatorInfoItemBinding;", "Lcom/iqoption/charttools/tools/data/InfoIndicatorItem;", "callback", "Lcom/iqoption/charttools/tools/viewholder/IndicatorInfoViewHolder$Callback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/tools/viewholder/IndicatorInfoViewHolder$Callback;Landroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "IqOption-5.5.1_optionXRelease"})
/* compiled from: IndicatorInfoViewHolder.kt */
public final class b extends c<vp, com.iqoption.charttools.tools.data.i> {
    private final b aCw;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/charttools/tools/viewholder/IndicatorInfoViewHolder$Callback;", "", "onItemVideoLinkClick", "", "item", "Lcom/iqoption/charttools/tools/data/InfoIndicatorItem;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: IndicatorInfoViewHolder.kt */
    public interface b {
        void a(com.iqoption.charttools.tools.data.i iVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ b aCx;

        public a(b bVar) {
            this.aCx = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            com.iqoption.charttools.tools.data.i iVar = (com.iqoption.charttools.tools.data.i) this.aCx.ZU();
            if (iVar != null) {
                this.aCx.aCw.a(iVar);
            }
        }
    }

    public b(b bVar, ViewGroup viewGroup) {
        h.e(bVar, "callback");
        h.e(viewGroup, "parent");
        super(R.layout.indicator_info_item, viewGroup);
        this.aCw = bVar;
        TextView textView = ((vp) getBinding()).bIn;
        h.d(textView, "binding.videoLink");
        textView.setOnClickListener(new a(this));
    }

    public void a(vp vpVar, com.iqoption.charttools.tools.data.i iVar) {
        h.e(vpVar, "$receiver");
        h.e(iVar, "item");
        TextView textView = vpVar.aip;
        h.d(textView, "text");
        textView.setText(iVar.getInfo());
        TextView textView2;
        if (iVar.Mk() != null) {
            textView2 = vpVar.bIn;
            h.d(textView2, "videoLink");
            com.iqoption.core.ext.a.L(textView2);
            return;
        }
        textView2 = vpVar.bIn;
        h.d(textView2, "videoLink");
        com.iqoption.core.ext.a.M(textView2);
    }
}
