package com.iqoption.withdrawal.common.fields;

import android.text.Editable;
import android.widget.EditText;
import java.util.regex.Pattern;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"TEXT_MAX_LENGTH", "", "USD_MASK", "", "getValue", "edit", "Landroid/widget/EditText;", "isAmountField", "", "field", "Lcom/iqoption/microservice/withdraw/response/PayoutField;", "isFieldRequired", "isValidByRegexp", "value", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawFieldsFragment.kt */
public final class f {
    private static final boolean a(com.iqoption.microservice.withdraw.response.f fVar) {
        return h.E(fVar.getName(), "amount");
    }

    private static final boolean a(com.iqoption.microservice.withdraw.response.f fVar, String str) {
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        obj = (obj == null || b(fVar)) ? null : 1;
        if (obj != null || Pattern.matches(fVar.atH(), charSequence)) {
            return true;
        }
        return false;
    }

    private static final boolean b(com.iqoption.microservice.withdraw.response.f fVar) {
        return fVar.getRequired() || a(fVar);
    }

    private static final String f(EditText editText) {
        Editable text = editText.getText();
        h.d(text, "edit.text");
        return v.trim(text).toString();
    }
}
