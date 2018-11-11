package com.iqoption.charttools.constructor.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.charttools.b.u;
import com.iqoption.charttools.constructor.s;
import com.iqoption.charttools.o;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputSelectViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorInputSelectBinding;", "Lcom/iqoption/charttools/constructor/InputSelect;", "callback", "Lcom/iqoption/charttools/constructor/viewholder/InputSelectViewHolder$Callback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/constructor/viewholder/InputSelectViewHolder$Callback;Landroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "techtools_release"})
/* compiled from: InputSelectViewHolder.kt */
public final class m extends c<u, s> {
    private final a avt;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputSelectViewHolder$Callback;", "", "onItemSelectRequest", "", "item", "Lcom/iqoption/charttools/constructor/InputSelect;", "techtools_release"})
    /* compiled from: InputSelectViewHolder.kt */
    public interface a {
        void a(s sVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/constructor/viewholder/InputSelectViewHolder$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "techtools_release"})
    /* compiled from: InputSelectViewHolder.kt */
    /* renamed from: com.iqoption.charttools.constructor.a.m$1 */
    public static final class AnonymousClass1 extends g {
        final /* synthetic */ m avu;

        AnonymousClass1(m mVar) {
            this.avu = mVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            s sVar = (s) this.avu.ZU();
            if (sVar != null) {
                this.avu.avt.a(sVar);
            }
        }
    }

    public m(a aVar, ViewGroup viewGroup) {
        h.e(aVar, "callback");
        h.e(viewGroup, "parent");
        super(o.h.indicator_constructor_input_select, viewGroup);
        this.avt = aVar;
        ((u) getBinding()).avm.setOnClickListener(new AnonymousClass1(this));
    }

    public void a(u uVar, s sVar) {
        h.e(uVar, "$receiver");
        h.e(sVar, "item");
        TextView textView = uVar.avo;
        h.d(textView, PlusShare.KEY_CALL_TO_ACTION_LABEL);
        textView.setText(sVar.getLabel());
        TextView textView2 = uVar.axE;
        h.d(textView2, "input");
        textView2.setText(sVar.getOptions()[sVar.Ld()]);
    }
}
