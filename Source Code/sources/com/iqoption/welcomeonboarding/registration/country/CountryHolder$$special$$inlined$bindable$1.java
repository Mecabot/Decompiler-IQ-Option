package com.iqoption.welcomeonboarding.registration.country;

import android.widget.TextView;
import com.iqoption.d.vx;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class CountryHolder$$special$$inlined$bindable$1 extends Lambda implements b<c, l> {
    final /* synthetic */ vx $binding$inlined;
    final /* synthetic */ Object $context;

    public CountryHolder$$special$$inlined$bindable$1(Object obj, vx vxVar) {
        this.$context = obj;
        this.$binding$inlined = vxVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(c cVar) {
        cVar = cVar;
        vx vxVar = (vx) this.$context;
        TextView textView = this.$binding$inlined.bjy;
        h.d(textView, "binding.countryName");
        textView.setText(cVar.amw().getName());
    }
}
