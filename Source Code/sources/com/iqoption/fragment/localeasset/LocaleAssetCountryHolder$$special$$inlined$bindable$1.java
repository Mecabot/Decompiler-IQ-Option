package com.iqoption.fragment.localeasset;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.TextView;
import com.iqoption.core.util.f;
import com.iqoption.d.wd;
import com.squareup.picasso.Picasso;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class LocaleAssetCountryHolder$$special$$inlined$bindable$1 extends Lambda implements b<b, l> {
    final /* synthetic */ wd $binding$inlined;
    final /* synthetic */ Object $context;
    final /* synthetic */ d this$0;

    public LocaleAssetCountryHolder$$special$$inlined$bindable$1(Object obj, d dVar, wd wdVar) {
        this.$context = obj;
        this.this$0 = dVar;
        this.$binding$inlined = wdVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(b bVar) {
        bVar = bVar;
        wd wdVar = (wd) this.$context;
        TextView textView = this.$binding$inlined.bjy;
        h.d(textView, "binding.countryName");
        textView.setText(bVar.amw().getName());
        textView = this.$binding$inlined.bJl;
        h.d(textView, "binding.countAsset");
        textView.setText(String.valueOf(bVar.amv()));
        textView = this.$binding$inlined.bJo;
        h.d(textView, "binding.yourArea");
        textView.setVisibility(bVar.amu() ? 0 : 8);
        ConstraintLayout constraintLayout = this.$binding$inlined.bJm;
        h.d(constraintLayout, "binding.countryContainer");
        constraintLayout.setSelected(bVar.amt());
        String aA = f.bgP.aA(bVar.amw().VE());
        if (aA != null) {
            View view = this.this$0.itemView;
            h.d(view, "itemView");
            Picasso.with(view.getContext()).load(aA).into(this.$binding$inlined.bJn);
        }
    }
}
