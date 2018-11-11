package com.iqoption.deposit.light.constructor.selector.string;

import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ext.a;
import com.iqoption.deposit.a.ai;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class SelectorStringLightViewHolder$$special$$inlined$bindable$1 extends Lambda implements b<com.iqoption.deposit.constructor.selector.string.b, l> {
    final /* synthetic */ ai $binding$inlined;
    final /* synthetic */ Object $context;

    public SelectorStringLightViewHolder$$special$$inlined$bindable$1(Object obj, ai aiVar) {
        this.$context = obj;
        this.$binding$inlined = aiVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(com.iqoption.deposit.constructor.selector.string.b bVar) {
        bVar = bVar;
        ai aiVar = (ai) this.$context;
        TextView textView = this.$binding$inlined.bZD;
        h.d(textView, "binding.constructorSpinnerName");
        textView.setText(bVar.acf().getDescription());
        ImageView imageView;
        if (bVar.isSelected()) {
            imageView = this.$binding$inlined.bZB;
            h.d(imageView, "binding.constructorSpinnerChecked");
            a.L(imageView);
            return;
        }
        imageView = this.$binding$inlined.bZB;
        h.d(imageView, "binding.constructorSpinnerChecked");
        a.M(imageView);
    }
}
