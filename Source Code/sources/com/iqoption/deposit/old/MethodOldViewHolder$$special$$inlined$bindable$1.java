package com.iqoption.deposit.old;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iqoption.core.ext.a;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.d.wh;
import com.iqoption.deposit.menu.method.c;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "C", "it", "invoke", "(Ljava/lang/Object;)V", "com/iqoption/core/kotlin/DelegatesKt$bindable$1"})
/* compiled from: Delegates.kt */
public final class MethodOldViewHolder$$special$$inlined$bindable$1 extends Lambda implements b<e, l> {
    final /* synthetic */ Object $context;
    final /* synthetic */ a this$0;

    public MethodOldViewHolder$$special$$inlined$bindable$1(Object obj, a aVar) {
        this.$context = obj;
        this.this$0 = aVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(e eVar) {
        eVar = eVar;
        wh whVar = (wh) this.$context;
        View root = this.this$0.cbR.getRoot();
        h.d(root, "binding.root");
        Context context = root.getContext();
        Picasso with = Picasso.with(context);
        ImageView imageView = this.this$0.cbR.bJt;
        PayMethod aaT = eVar.aaT();
        if (aaT instanceof com.iqoption.core.microservices.billing.response.deposit.h) {
            with.cancelRequest(imageView);
            a aVar = this.this$0;
            h.d(imageView, "iconImageView");
            com.iqoption.core.microservices.billing.response.deposit.h hVar = (com.iqoption.core.microservices.billing.response.deposit.h) aaT;
            aVar.a(imageView, hVar);
            this.this$0.a(imageView, hVar);
        } else {
            a aVar2 = this.this$0;
            h.d(imageView, "iconImageView");
            h.d(with, "picasso");
            aVar2.a(imageView, aaT, with);
        }
        if (this.this$0.cbS) {
            LinearLayout linearLayout;
            if (eVar.getSelected()) {
                linearLayout = this.this$0.cbR.bJs;
                h.d(context, "context");
                linearLayout.setBackgroundColor(a.i(context, R.color.deposit_selected_grey_30));
            } else {
                linearLayout = this.this$0.cbR.bJs;
                h.d(linearLayout, "binding.methodContainer");
                h.d(context, "context");
                linearLayout.setBackground(a.l(context, R.drawable.bg_white_grey_selector));
            }
        }
        TextView textView = this.this$0.cbR.bJu;
        h.d(textView, "binding.methodName");
        h.d(context, "context");
        textView.setText(c.a(aaT, context, true, false));
    }
}
