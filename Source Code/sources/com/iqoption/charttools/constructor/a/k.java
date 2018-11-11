package com.iqoption.charttools.constructor.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.charttools.b.u;
import com.iqoption.charttools.constructor.m;
import com.iqoption.charttools.o;
import com.iqoption.core.ext.g;
import com.iqoption.core.ui.widget.recyclerview.a.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputHostViewHolder;", "Lcom/iqoption/core/ui/widget/recyclerview/viewholder/VDBindingHolder;", "Lcom/iqoption/charttools/databinding/IndicatorConstructorInputSelectBinding;", "Lcom/iqoption/charttools/constructor/InputHost;", "callback", "Lcom/iqoption/charttools/constructor/viewholder/InputHostViewHolder$Callback;", "parent", "Landroid/view/ViewGroup;", "(Lcom/iqoption/charttools/constructor/viewholder/InputHostViewHolder$Callback;Landroid/view/ViewGroup;)V", "bind", "", "item", "Callback", "techtools_release"})
/* compiled from: InputHostViewHolder.kt */
public final class k extends c<u, m> {
    private final a avq;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputHostViewHolder$Callback;", "", "onItemHostRequest", "", "item", "Lcom/iqoption/charttools/constructor/InputHost;", "techtools_release"})
    /* compiled from: InputHostViewHolder.kt */
    public interface a {
        void a(m mVar);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/charttools/constructor/viewholder/InputHostViewHolder$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "techtools_release"})
    /* compiled from: InputHostViewHolder.kt */
    /* renamed from: com.iqoption.charttools.constructor.a.k$1 */
    public static final class AnonymousClass1 extends g {
        final /* synthetic */ k avr;

        AnonymousClass1(k kVar) {
            this.avr = kVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            m mVar = (m) this.avr.ZU();
            if (mVar != null) {
                this.avr.avq.a(mVar);
            }
        }
    }

    public k(a aVar, ViewGroup viewGroup) {
        h.e(aVar, "callback");
        h.e(viewGroup, "parent");
        super(o.h.indicator_constructor_input_select, viewGroup);
        this.avq = aVar;
        ((u) getBinding()).avm.setOnClickListener(new AnonymousClass1(this));
    }

    public void a(u uVar, m mVar) {
        h.e(uVar, "$receiver");
        h.e(mVar, "item");
        TextView textView = uVar.avo;
        h.d(textView, PlusShare.KEY_CALL_TO_ACTION_LABEL);
        textView.setText(mVar.getLabel());
        textView = uVar.axE;
        h.d(textView, "input");
        textView.setText(mVar.Li()[mVar.Ld()].getTitle());
        LinearLayout linearLayout = uVar.avm;
        h.d(linearLayout, b.CONTENT);
        boolean z = false;
        if (mVar.isEnabled()) {
            if (((mVar.Li().length == 0 ? 1 : 0) ^ 1) != 0) {
                z = true;
            }
        }
        linearLayout.setEnabled(z);
    }
}
