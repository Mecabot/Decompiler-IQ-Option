package com.iqoption.deposit.c;

import android.support.annotation.DrawableRes;
import com.iqoption.deposit.r.e;
import io.card.payment.CardType;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, aXE = {"cardIconResId", "", "type", "Lio/card/payment/CardType;", "(Lio/card/payment/CardType;)Ljava/lang/Integer;", "deposit_release"})
/* compiled from: CardTypes.kt */
public final class a {
    @DrawableRes
    public static final Integer a(CardType cardType) {
        if (cardType != null) {
            switch (b.aoS[cardType.ordinal()]) {
                case 1:
                    return Integer.valueOf(e.ic_visa);
                case 2:
                    return Integer.valueOf(e.ic_master_card);
                case 3:
                    return Integer.valueOf(e.cio_ic_amex);
                case 4:
                    return Integer.valueOf(e.cio_ic_discover);
                case 5:
                    return Integer.valueOf(e.cio_ic_jcb);
            }
        }
        return null;
    }
}
