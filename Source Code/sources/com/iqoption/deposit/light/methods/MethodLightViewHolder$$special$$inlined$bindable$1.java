package com.iqoption.deposit.light.methods;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.core.ext.a;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.deposit.a.aq;
import com.iqoption.deposit.menu.method.c;
import com.iqoption.deposit.r;
import com.squareup.picasso.Picasso;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class MethodLightViewHolder$$special$$inlined$bindable$1 extends Lambda implements b<com.iqoption.deposit.menu.method.b, l> {
    final /* synthetic */ Object $context;
    final /* synthetic */ a this$0;

    public MethodLightViewHolder$$special$$inlined$bindable$1(Object obj, a aVar) {
        this.$context = obj;
        this.this$0 = aVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(com.iqoption.deposit.menu.method.b bVar) {
        bVar = bVar;
        aq aqVar = (aq) this.$context;
        View root = this.this$0.caT.getRoot();
        h.d(root, "binding.root");
        Context context = root.getContext();
        Picasso with = Picasso.with(context);
        ImageView imageView = this.this$0.caT.bJt;
        PayMethod aaT = bVar.aaT();
        if (aaT instanceof com.iqoption.core.microservices.billing.response.deposit.h) {
            with.cancelRequest(imageView);
            a aVar = this.this$0;
            h.d(imageView, "iconImageView");
            aVar.a(imageView, (com.iqoption.core.microservices.billing.response.deposit.h) aaT);
        } else {
            a aVar2 = this.this$0;
            h.d(imageView, "iconImageView");
            h.d(with, "picasso");
            aVar2.a(imageView, aaT, with);
        }
        TextView textView = this.this$0.caT.bJu;
        h.d(textView, "binding.methodName");
        h.d(context, "context");
        textView.setText(c.a(aaT, context, true, false));
        TextView textView2;
        if (bVar.abQ() && bVar.aaT().UU()) {
            textView2 = this.this$0.caT.bZK;
            h.d(textView2, "binding.methodDescription");
            a.L(textView2);
            this.this$0.caT.bZK.setText(r.h.for_verified_accounts);
        } else if (bVar.adF() != null) {
            TextView textView3 = this.this$0.caT.bZK;
            h.d(textView3, "binding.methodDescription");
            a.L(textView3);
            textView3 = this.this$0.caT.bZK;
            h.d(textView3, "binding.methodDescription");
            textView3.setText(bVar.adF());
        } else {
            textView2 = this.this$0.caT.bZK;
            h.d(textView2, "binding.methodDescription");
            a.M(textView2);
        }
        this.this$0.cv(this.this$0.caU.k(aaT));
    }
}
