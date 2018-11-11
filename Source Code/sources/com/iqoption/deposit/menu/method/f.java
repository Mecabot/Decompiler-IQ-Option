package com.iqoption.deposit.menu.method;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.deposit.a.ao;
import com.iqoption.deposit.r.e;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import io.card.payment.CardType;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001b"}, aXE = {"Lcom/iqoption/deposit/menu/method/MethodViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/deposit/databinding/ItemPaymentMethodBinding;", "clickListener", "Lcom/iqoption/deposit/menu/method/OnMethodClickListener;", "(Lcom/iqoption/deposit/databinding/ItemPaymentMethodBinding;Lcom/iqoption/deposit/menu/method/OnMethodClickListener;)V", "<set-?>", "Lcom/iqoption/deposit/menu/method/MethodAdapterItem;", "bound", "getBound", "()Lcom/iqoption/deposit/menu/method/MethodAdapterItem;", "setBound", "(Lcom/iqoption/deposit/menu/method/MethodAdapterItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "loadCardIcon", "", "view", "Landroid/widget/ImageView;", "userCard", "Lcom/iqoption/core/microservices/billing/response/deposit/UserCard;", "loadPayMethodIcon", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "picasso", "Lcom/squareup/picasso/Picasso;", "deposit_release"})
/* compiled from: MethodViewHolder.kt */
public final class f extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(f.class), "bound", "getBound()Lcom/iqoption/deposit/menu/method/MethodAdapterItem;"))};
    private final d bXV;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ i cbB;
        final /* synthetic */ f this$0;

        public a(f fVar, i iVar) {
            this.this$0 = fVar;
            this.cbB = iVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.cbB.j(this.this$0.adl().aaT());
        }
    }

    public final void a(b bVar) {
        h.e(bVar, "<set-?>");
        this.bXV.a(this, apP[0], bVar);
    }

    public final b adl() {
        return (b) this.bXV.b(this, apP[0]);
    }

    public f(ao aoVar, i iVar) {
        h.e(aoVar, "binding");
        h.e(iVar, "clickListener");
        super(aoVar.getRoot());
        View view = this.itemView;
        h.d(view, "itemView");
        view.setOnClickListener(new a(this, iVar));
        this.bXV = c.h(new MethodViewHolder$$special$$inlined$bindable$1(aoVar, this, aoVar));
    }

    private final void a(ImageView imageView, com.iqoption.core.microservices.billing.response.deposit.h hVar) {
        CardType gV = com.iqoption.core.util.a.gV(hVar.Vg());
        Context context = imageView.getContext();
        h.d(context, "view.context");
        Integer a = com.iqoption.deposit.c.a.a(gV);
        imageView.setImageDrawable(com.iqoption.core.ext.a.l(context, a != null ? a.intValue() : e.ic_payment_method_placeholder));
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
        stringBuilder.append("square-");
        stringBuilder.append(str);
        RequestCreator a = com.iqoption.core.util.h.a(picasso, stringBuilder.toString());
        Context context = imageView.getContext();
        h.d(context, "view.context");
        a = a.placeholder(com.iqoption.core.ext.a.l(context, e.ic_payment_method_placeholder));
        context = imageView.getContext();
        h.d(context, "view.context");
        a.error(com.iqoption.core.ext.a.l(context, e.ic_payment_method_placeholder)).into(imageView);
    }
}
