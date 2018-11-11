package com.iqoption.signals;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.analytics.EventManager;
import com.iqoption.d.ago;
import com.iqoption.dto.Event;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/widget/window/OptionsWindow;", "invoke"})
/* compiled from: SignalsFragment.kt */
final class SignalsFragment$filtersWindow$2 extends Lambda implements kotlin.jvm.a.a<com.iqoption.widget.a.a> {
    final /* synthetic */ i this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/signals/SignalsFragment$filtersWindow$2$1$listener$1"})
    /* compiled from: SignalsFragment.kt */
    static final class a implements OnClickListener {
        final /* synthetic */ com.iqoption.widget.a.a drs;
        final /* synthetic */ SignalsFragment$filtersWindow$2 drt;

        a(com.iqoption.widget.a.a aVar, SignalsFragment$filtersWindow$2 signalsFragment$filtersWindow$2) {
            this.drs = aVar;
            this.drt = signalsFragment$filtersWindow$2;
        }

        public final void onClick(View view) {
            SignalFilter signalFilter;
            double d;
            h.d(view, "v");
            int id = view.getId();
            if (id == R.id.gap) {
                signalFilter = SignalFilter.GAP;
                d = 1.0d;
            } else if (id != R.id.sharpJump) {
                signalFilter = SignalFilter.ALL;
                d = 0.0d;
            } else {
                signalFilter = SignalFilter.SHARP_JUMP;
                d = 2.0d;
            }
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "signals_set-filter").setValue(Double.valueOf(d)).build());
            i.b(this.drt.this$0).a(signalFilter);
            this.drs.dismiss();
        }
    }

    SignalsFragment$filtersWindow$2(i iVar) {
        this.this$0 = iVar;
        super(0);
    }

    /* renamed from: aEe */
    public final com.iqoption.widget.a.a invoke() {
        com.iqoption.widget.a.a aVar = new com.iqoption.widget.a.a();
        ago ago = (ago) com.iqoption.core.ext.a.a(this.this$0, (int) R.layout.price_movements_filter_options, null, false, 4, null);
        View root = ago.getRoot();
        h.d(root, "root");
        com.iqoption.core.ext.a.N(root);
        aVar.g(root, root.getMeasuredWidth(), root.getMeasuredHeight());
        OnClickListener aVar2 = new a(aVar, this);
        ago.bPY.setOnClickListener(aVar2);
        ago.bPZ.setOnClickListener(aVar2);
        ago.bQa.setOnClickListener(aVar2);
        return aVar;
    }
}
