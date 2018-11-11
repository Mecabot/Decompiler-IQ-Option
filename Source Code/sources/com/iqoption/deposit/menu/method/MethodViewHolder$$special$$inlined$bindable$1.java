package com.iqoption.deposit.menu.method;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ext.a;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.e;
import com.iqoption.deposit.a.ao;
import com.iqoption.deposit.r;
import com.iqoption.deposit.r.c;
import com.squareup.picasso.Picasso;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class MethodViewHolder$$special$$inlined$bindable$1 extends Lambda implements b<b, l> {
    final /* synthetic */ ao $binding$inlined;
    final /* synthetic */ Object $context;
    final /* synthetic */ f this$0;

    public MethodViewHolder$$special$$inlined$bindable$1(Object obj, f fVar, ao aoVar) {
        this.$context = obj;
        this.this$0 = fVar;
        this.$binding$inlined = aoVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(b bVar) {
        int i;
        bVar = bVar;
        ao aoVar = (ao) this.$context;
        View root = this.$binding$inlined.getRoot();
        h.d(root, "binding.root");
        Context context = root.getContext();
        Picasso with = Picasso.with(context);
        ImageView imageView = this.$binding$inlined.bJt;
        PayMethod aaT = bVar.aaT();
        if (e.a(aaT)) {
            with.cancelRequest(imageView);
            h.d(context, "context");
            imageView.setImageDrawable(a.l(context, r.e.ic_add_card));
        } else if (aaT instanceof com.iqoption.core.microservices.billing.response.deposit.h) {
            with.cancelRequest(imageView);
            f fVar = this.this$0;
            h.d(imageView, "iconImageView");
            fVar.a(imageView, (com.iqoption.core.microservices.billing.response.deposit.h) aaT);
        } else {
            f fVar2 = this.this$0;
            h.d(imageView, "iconImageView");
            h.d(with, "picasso");
            fVar2.a(imageView, aaT, with);
        }
        TextView textView = this.$binding$inlined.bJu;
        h.d(textView, "binding.methodName");
        h.d(context, "context");
        textView.setText(c.a(aaT, context, false, false, 4, null));
        ImageView imageView2;
        if (bVar.abQ() && bVar.aaT().UU()) {
            imageView2 = this.$binding$inlined.bZI;
            h.d(imageView2, "binding.methodChecked");
            a.M(imageView2);
            imageView2 = this.$binding$inlined.bZH;
            h.d(imageView2, "binding.methodBlocked");
            a.L(imageView2);
            imageView2 = this.$binding$inlined.bJt;
            h.d(imageView2, "binding.methodIcon");
            imageView2.setAlpha(0.5f);
            i = c.grey_blue_70;
        } else if (bVar.isSelected()) {
            imageView2 = this.$binding$inlined.bZI;
            h.d(imageView2, "binding.methodChecked");
            a.L(imageView2);
            imageView2 = this.$binding$inlined.bZH;
            h.d(imageView2, "binding.methodBlocked");
            a.M(imageView2);
            imageView2 = this.$binding$inlined.bJt;
            h.d(imageView2, "binding.methodIcon");
            imageView2.setAlpha(1.0f);
            i = c.white;
        } else {
            imageView2 = this.$binding$inlined.bZI;
            h.d(imageView2, "binding.methodChecked");
            a.M(imageView2);
            imageView2 = this.$binding$inlined.bZH;
            h.d(imageView2, "binding.methodBlocked");
            a.M(imageView2);
            imageView2 = this.$binding$inlined.bJt;
            h.d(imageView2, "binding.methodIcon");
            imageView2.setAlpha(1.0f);
            i = c.white;
        }
        this.$binding$inlined.bJu.setTextColor(a.i(context, i));
    }
}
