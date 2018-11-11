package com.iqoption.charttools.constructor.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.iqoption.charttools.constructor.u;
import com.iqoption.charttools.o.g;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/constructor/viewholder/InputStepFieldViewHolder;", "Lcom/iqoption/charttools/constructor/viewholder/AbsInputFieldViewHolder;", "Lcom/iqoption/charttools/constructor/viewholder/InputStepFieldBinding;", "Lcom/iqoption/charttools/constructor/InputStepField;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "techtools_release"})
/* compiled from: InputStepFieldViewHolder.kt */
public final class o extends a<n, u> {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: InputStepFieldViewHolder.kt */
    static final class a implements OnClickListener {
        final /* synthetic */ o avx;

        a(o oVar) {
            this.avx = oVar;
        }

        public final void onClick(View view) {
            u uVar = (u) this.avx.ZU();
            if (uVar != null) {
                h.d(view, "it");
                int id = view.getId();
                if (id == g.btnMinus) {
                    uVar.Lp();
                } else if (id == g.btnPlus) {
                    uVar.Lo();
                } else {
                    throw new RuntimeException("Unreachable");
                }
                ((n) this.avx.ZT()).Lv().setTextKeepState(uVar.Lf());
                if (!((n) this.avx.ZT()).Lv().isFocused()) {
                    this.avx.b((f) this.avx.ZT(), uVar);
                }
            }
        }
    }

    public o(ViewGroup viewGroup) {
        h.e(viewGroup, "parent");
        super(new n(viewGroup));
        OnClickListener aVar = new a(this);
        ((n) ZT()).Ly().setOnClickListener(aVar);
        ((n) ZT()).Lz().setOnClickListener(aVar);
    }
}
