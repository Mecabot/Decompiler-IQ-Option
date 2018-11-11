package com.iqoption.deposit.dark.menu.currency;

import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.deposit.a.ak;
import com.iqoption.deposit.menu.currency.a;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class CurrencyDarkViewHolder$$special$$inlined$bindable$1 extends Lambda implements b<a, l> {
    final /* synthetic */ ak $binding$inlined;
    final /* synthetic */ Object $context;

    public CurrencyDarkViewHolder$$special$$inlined$bindable$1(Object obj, ak akVar) {
        this.$context = obj;
        this.$binding$inlined = akVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(a aVar) {
        aVar = aVar;
        ak akVar = (ak) this.$context;
        c adD = aVar.adD();
        TextView textView = this.$binding$inlined.bZG;
        h.d(textView, "binding.currencySymbol");
        textView.setText(adD.getSymbol());
        textView = this.$binding$inlined.bJk;
        h.d(textView, "binding.currencyName");
        textView.setText(adD.getName());
        ImageView imageView;
        if (aVar.isSelected()) {
            imageView = this.$binding$inlined.bZE;
            h.d(imageView, "binding.currencyChecked");
            com.iqoption.core.ext.a.L(imageView);
            return;
        }
        imageView = this.$binding$inlined.bZE;
        h.d(imageView, "binding.currencyChecked");
        com.iqoption.core.ext.a.M(imageView);
    }
}
