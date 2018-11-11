package com.iqoption.deposit.menu.method;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.iqoption.core.ext.a;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.e;
import com.iqoption.core.microservices.billing.response.deposit.g;
import com.iqoption.deposit.r;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a$\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¨\u0006\u000b"}, aXE = {"creditCardDescription", "", "context", "Landroid/content/Context;", "userCard", "Lcom/iqoption/core/microservices/billing/response/deposit/UserCard;", "getDescription", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "short", "", "withSpan", "deposit_release"})
/* compiled from: MethodAdapterItem.kt */
public final class c {
    public static /* bridge */ /* synthetic */ CharSequence a(PayMethod payMethod, Context context, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        return a(payMethod, context, z, z2);
    }

    public static final CharSequence a(PayMethod payMethod, Context context, boolean z, boolean z2) {
        h.e(payMethod, "$receiver");
        h.e(context, "context");
        if (e.a(payMethod)) {
            String name = payMethod.getName();
            if (z) {
                return name;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getString(r.h.new_credit_card_n1, new Object[]{name}));
            if (z2) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(a.i(context, com.iqoption.deposit.r.c.grey_blue_70)), spannableStringBuilder.length() - name.length(), spannableStringBuilder.length(), 33);
            }
            return spannableStringBuilder;
        } else if (payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.h) {
            return a(context, (com.iqoption.core.microservices.billing.response.deposit.h) payMethod);
        } else {
            if (payMethod instanceof g) {
                return payMethod.getName();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected case: ");
            stringBuilder.append(payMethod);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private static final CharSequence a(Context context, com.iqoption.core.microservices.billing.response.deposit.h hVar) {
        String Vg = hVar.Vg();
        int i = r.h.credit_card_n1;
        Object[] objArr = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("**");
        int length = Vg.length() - 4;
        int length2 = Vg.length();
        if (Vg == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        Vg = Vg.substring(length, length2);
        h.d(Vg, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        stringBuilder.append(Vg);
        objArr[0] = stringBuilder.toString();
        String string = context.getString(i, objArr);
        h.d(string, "context.getString(R.stri… - 4, cardNumber.length))");
        return string;
    }
}
