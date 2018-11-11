package com.iqoption.verify.status;

import android.content.Context;
import android.widget.TextView;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.mobbtech.connect.response.r;
import com.iqoption.x.R;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, aXE = {"setDescription", "", "textView", "Landroid/widget/TextView;", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "status", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyStatusFragment.kt */
public final class n {
    private static final void a(TextView textView, q qVar, CardStatus cardStatus) {
        Context context = textView.getContext();
        String string = r.auZ().contains(cardStatus) ? context.getString(R.string.please_wait_until_your_card_is_verified) : cardStatus == CardStatus.DECLINED ? context.getString(c.k(qVar)) : null;
        if (string != null) {
            textView.setText(string);
        }
    }
}
