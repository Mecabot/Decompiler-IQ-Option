package com.iqoption.verify.status;

import android.support.annotation.StringRes;
import com.iqoption.mobbtech.connect.response.DeclineReason;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, aXE = {"getDeclinedDescription", "", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: BaseVerifyStatusFragment.kt */
public final class c {
    @StringRes
    public static final int k(q qVar) {
        h.e(qVar, "card");
        DeclineReason auY = qVar.auY();
        if (auY != null) {
            switch (d.aoS[auY.ordinal()]) {
                case 1:
                    return R.string.your_card_is_not_signed;
                case 2:
                    return R.string.you_did_not_provide_us_with_the_back;
                case 3:
                    return R.string.you_did_not_provide_us_with_the_front;
                case 4:
                    return R.string.you_have_provided_us_with_black_and_white;
                case 5:
                    return R.string.you_have_provided_us_with_wrong_card;
                case 6:
                    return R.string.the_copy_of_your_card_is_blurry;
                case 7:
                    return R.string.we_were_not_able_to_see;
            }
        }
        return R.string.we_were_not_able_to_verify;
    }
}
