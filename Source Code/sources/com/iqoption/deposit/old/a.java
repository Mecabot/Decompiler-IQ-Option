package com.iqoption.deposit.old;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.iqoption.core.e.c;
import com.iqoption.core.ext.g;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.d.wh;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import io.card.payment.CardType;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, aXE = {"Lcom/iqoption/deposit/old/MethodOldViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/ItemPaymentMethodOldBinding;", "clickListener", "Lcom/iqoption/deposit/old/OnMethodClickListenerOld;", "clickable", "", "(Lcom/iqoption/databinding/ItemPaymentMethodOldBinding;Lcom/iqoption/deposit/old/OnMethodClickListenerOld;Z)V", "<set-?>", "Lcom/iqoption/deposit/old/PayMethodItem;", "bound", "getBound", "()Lcom/iqoption/deposit/old/PayMethodItem;", "setBound", "(Lcom/iqoption/deposit/old/PayMethodItem;)V", "bound$delegate", "Lkotlin/properties/ReadWriteProperty;", "getView", "Landroid/view/View;", "loadCardIcon", "", "view", "Landroid/widget/ImageView;", "userCard", "Lcom/iqoption/core/microservices/billing/response/deposit/UserCard;", "loadPayMethodIcon", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "picasso", "Lcom/squareup/picasso/Picasso;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MethodOldViewHolder.kt */
public final class a extends ViewHolder {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "bound", "getBound()Lcom/iqoption/deposit/old/PayMethodItem;"))};
    private final d bXV;
    private final wh cbR;
    private final boolean cbS;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class a extends g {
        final /* synthetic */ c cbT;
        final /* synthetic */ a this$0;

        public a(a aVar, c cVar) {
            this.this$0 = aVar;
            this.cbT = cVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.cbT.b(this.this$0.adT());
        }
    }

    public final void a(e eVar) {
        h.e(eVar, "<set-?>");
        this.bXV.a(this, apP[0], eVar);
    }

    public final e adT() {
        return (e) this.bXV.b(this, apP[0]);
    }

    public a(wh whVar, c cVar, boolean z) {
        h.e(whVar, "binding");
        h.e(cVar, "clickListener");
        super(whVar.getRoot());
        this.cbR = whVar;
        this.cbS = z;
        if (this.cbS) {
            View view = this.itemView;
            h.d(view, "itemView");
            view.setOnClickListener(new a(this, cVar));
        }
        this.bXV = c.h(new MethodOldViewHolder$$special$$inlined$bindable$1(this.cbR, this));
    }

    private final void a(ImageView imageView, com.iqoption.core.microservices.billing.response.deposit.h hVar) {
        CardType gV = com.iqoption.core.util.a.gV(hVar.Vg());
        Context context = imageView.getContext();
        h.d(context, "view.context");
        Integer a = com.iqoption.deposit.c.a.a(gV);
        imageView.setImageDrawable(com.iqoption.core.ext.a.l(context, a != null ? a.intValue() : R.drawable.ic_payment_method_placeholder_grey));
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
        a = a.placeholder(com.iqoption.core.ext.a.l(context, R.drawable.ic_payment_method_placeholder_grey));
        context = imageView.getContext();
        h.d(context, "view.context");
        a.error(com.iqoption.core.ext.a.l(context, R.drawable.ic_payment_method_placeholder_grey)).into(imageView);
    }

    public final View getView() {
        return this.cbR.getRoot();
    }
}
