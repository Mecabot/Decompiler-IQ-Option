package com.iqoption.withdrawal.common.methods;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.b;
import com.iqoption.microservice.withdraw.response.WithdrawMethodType;
import com.iqoption.microservice.withdraw.response.a;
import com.iqoption.util.l;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import io.card.payment.CardType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¨\u0006\u0010"}, aXE = {"cardResourceName", "", "type", "Lio/card/payment/CardType;", "getIconResourceName", "method", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "setMethodIcon", "", "imageView", "Landroid/widget/ImageView;", "setMethodName", "textView", "Landroid/widget/TextView;", "setUpLimit", "mask", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MethodHolders.kt */
public final class c {
    private static final void a(TextView textView, a aVar, String str) {
        com.iqoption.withdrawal.common.a aty = aVar.aty();
        Context context = textView.getContext();
        if (aty != null) {
            textView.setText(context.getString(R.string.up_to_n1, new Object[]{l.e(str, Double.valueOf(aty.getValue()))}));
            return;
        }
        textView.setText(context.getString(R.string.no_limits));
    }

    private static final void a(ImageView imageView, a aVar) {
        Picasso with = Picasso.with(imageView.getContext());
        h.d(with, "Picasso.with(imageView.context)");
        com.iqoption.core.util.h.a(with, e(aVar)).error((int) R.drawable.ic_payout_method_placeholder).into((ImageView) imageView.findViewById(b.a.withdrawMethodIcon));
    }

    private static final String e(a aVar) {
        String b;
        if (aVar instanceof com.iqoption.microservice.withdraw.response.c) {
            b = b(((com.iqoption.microservice.withdraw.response.c) aVar).getCardType());
        } else if (aVar instanceof com.iqoption.microservice.withdraw.response.h) {
            b = ((com.iqoption.microservice.withdraw.response.h) aVar).atI();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected case: ");
            stringBuilder.append(aVar);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("withdrawal-");
        stringBuilder2.append(b);
        return stringBuilder2.toString();
    }

    private static final String b(CardType cardType) {
        if (cardType != null) {
            switch (d.aoS[cardType.ordinal()]) {
                case 1:
                    return "visa";
                case 2:
                    return "mastercard";
            }
        }
        return null;
    }

    private static final void a(TextView textView, ImageView imageView, a aVar) {
        Context context = textView.getContext();
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (aVar.att() == WithdrawMethodType.CARD) {
            textView.setText(aVar.getName());
            textView.setVisibility(0);
            h.d(context, "context");
            layoutParams.height = context.getResources().getDimensionPixelSize(R.dimen.dp32);
        } else {
            textView.setVisibility(8);
            layoutParams.height = -2;
        }
        imageView.setLayoutParams(layoutParams);
    }
}
