package com.iqoption.signals;

import android.widget.TextView;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iqoption.d.aje;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class SignalItemViewHolder$$special$$inlined$bindable$1 extends Lambda implements b<c, l> {
    final /* synthetic */ Object $context;
    final /* synthetic */ d this$0;

    public SignalItemViewHolder$$special$$inlined$bindable$1(Object obj, d dVar) {
        this.$context = obj;
        this.this$0 = dVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(c cVar) {
        cVar = cVar;
        aje aje = (aje) this.$context;
        aje.bmu.setImageResource(cVar.aDZ() ? R.drawable.ic_signals_bull : R.drawable.ic_signals_bear);
        TextView textView = aje.bnB;
        h.d(textView, Param.TYPE);
        textView.setText(cVar.getType());
        textView = aje.aiq;
        h.d(textView, "time");
        textView.setText(cVar.getTime());
        textView = aje.axH;
        h.d(textView, "active");
        textView.setText(cVar.getActiveName());
        textView = aje.bns;
        h.d(textView, FirebaseAnalytics.b.VALUE);
        textView.setText(cVar.getValue());
        this.this$0.drg.gy(cVar.getLevel());
        if (cVar.aDZ()) {
            aje.bns.setTextColor(this.this$0.dre);
            this.this$0.drg.setColor(this.this$0.dre);
            return;
        }
        aje.bns.setTextColor(this.this$0.drf);
        this.this$0.drg.setColor(this.this$0.drf);
    }
}
