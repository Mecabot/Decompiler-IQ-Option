package com.iqoption.deposit.light.methods;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.util.q;
import com.iqoption.deposit.a.aq;
import com.iqoption.deposit.menu.method.b;
import com.iqoption.deposit.r;
import com.iqoption.deposit.r.e;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import io.card.payment.CardType;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/deposit/light/methods/MethodLightViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/deposit/databinding/ItemPaymentMethodLightBinding;", "callback", "Lcom/iqoption/deposit/light/methods/OnMethodCallbackLight;", "(Lcom/iqoption/deposit/databinding/ItemPaymentMethodLightBinding;Lcom/iqoption/deposit/light/methods/OnMethodCallbackLight;)V", "<set-?>", "Lcom/iqoption/deposit/menu/method/MethodAdapterItem;", "bound", "getBound", "()Lcom/iqoption/deposit/menu/method/MethodAdapterItem;", "setBound", "(Lcom/iqoption/deposit/menu/method/MethodAdapterItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "loadCardIcon", "", "view", "Landroid/widget/ImageView;", "userCard", "Lcom/iqoption/core/microservices/billing/response/deposit/UserCard;", "loadPayMethodIcon", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "picasso", "Lcom/squareup/picasso/Picasso;", "markSelectedIfNeeded", "selected", "", "deposit_release"})
/* compiled from: MethodLightViewHolder.kt */
public final class a extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "bound", "getBound()Lcom/iqoption/deposit/menu/method/MethodAdapterItem;"))};
    private final d bXV = c.h(new MethodLightViewHolder$$special$$inlined$bindable$1(this.caT, this));
    private final aq caT;
    private final g caU;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ a this$0;

        public a(a aVar) {
            this.this$0 = aVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.this$0.caU.j(this.this$0.adl().aaT());
        }
    }

    public final void a(b bVar) {
        h.e(bVar, "<set-?>");
        this.bXV.a(this, apP[0], bVar);
    }

    public final b adl() {
        return (b) this.bXV.b(this, apP[0]);
    }

    public a(aq aqVar, g gVar) {
        h.e(aqVar, "binding");
        h.e(gVar, "callback");
        super(aqVar.getRoot());
        this.caT = aqVar;
        this.caU = gVar;
        View view = this.itemView;
        h.d(view, "itemView");
        view.setOnClickListener(new a(this));
    }

    public final void cv(boolean z) {
        View root = this.caT.getRoot();
        h.d(root, "binding.root");
        Context context = root.getContext();
        if (q.bj(context)) {
            int i;
            View view;
            if (z) {
                view = this.caT.bZJ;
                h.d(view, "binding.methodChecked");
                com.iqoption.core.ext.a.L(view);
                i = r.c.green_30;
            } else {
                view = this.caT.bZJ;
                h.d(view, "binding.methodChecked");
                com.iqoption.core.ext.a.M(view);
                i = r.c.white;
            }
            LinearLayout linearLayout = this.caT.bJs;
            h.d(context, "context");
            linearLayout.setBackgroundColor(com.iqoption.core.ext.a.i(context, i));
        }
    }

    private final void a(ImageView imageView, com.iqoption.core.microservices.billing.response.deposit.h hVar) {
        int intValue;
        CardType gV = com.iqoption.core.util.a.gV(hVar.Vg());
        Context context = imageView.getContext();
        h.d(context, "view.context");
        Integer a = com.iqoption.deposit.c.a.a(gV);
        if (a != null) {
            intValue = a.intValue();
        } else {
            intValue = e.ic_payment_method_placeholder_grey;
        }
        imageView.setImageDrawable(com.iqoption.core.ext.a.l(context, intValue));
    }

    private final void a(ImageView imageView, PayMethod payMethod, Picasso picasso) {
        String str = null;
        if (!(payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.g)) {
            payMethod = null;
        }
        com.iqoption.core.microservices.billing.response.deposit.g gVar = (com.iqoption.core.microservices.billing.response.deposit.g) payMethod;
        if (gVar != null) {
            str = gVar.UY();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("squarelight-");
        stringBuilder.append(str);
        RequestCreator a = com.iqoption.core.util.h.a(picasso, stringBuilder.toString());
        Context context = imageView.getContext();
        h.d(context, "view.context");
        a = a.placeholder(com.iqoption.core.ext.a.l(context, e.ic_payment_method_placeholder_grey));
        context = imageView.getContext();
        h.d(context, "view.context");
        a.error(com.iqoption.core.ext.a.l(context, e.ic_payment_method_placeholder_grey)).into(imageView);
    }
}
