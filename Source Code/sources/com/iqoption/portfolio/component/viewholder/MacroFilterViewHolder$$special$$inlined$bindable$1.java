package com.iqoption.portfolio.component.viewholder;

import android.databinding.ViewDataBinding;
import android.view.View;
import com.iqoption.core.ext.a;
import com.iqoption.d.afb;
import com.iqoption.portfolio.component.b.d;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class MacroFilterViewHolder$$special$$inlined$bindable$1 extends Lambda implements b<d, l> {
    final /* synthetic */ Object $context;
    final /* synthetic */ l this$0;

    public MacroFilterViewHolder$$special$$inlined$bindable$1(Object obj, l lVar) {
        this.$context = obj;
        this.this$0 = lVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(d dVar) {
        dVar = dVar;
        afb afb = (afb) this.$context;
        this.this$0.eh(true);
        afb.bmu.setImageDrawable(dVar.getIcon() != 0 ? a.e((ViewDataBinding) afb, dVar.getIcon()) : null);
        afb.agA.setText(dVar.getText());
        afb.agA.setTextColor(a.a((ViewDataBinding) afb, dVar.getColor()));
        View root = afb.getRoot();
        h.d(root, "root");
        View view = this.this$0.itemView;
        h.d(view, "itemView");
        root.setTag(view.getResources().getString(dVar.awM()));
    }
}
