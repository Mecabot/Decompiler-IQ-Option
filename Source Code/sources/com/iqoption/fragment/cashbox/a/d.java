package com.iqoption.fragment.cashbox.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.method.DigitsKeyListener;
import android.widget.EditText;
import com.iqoption.core.microservices.billing.response.extraparams.b;

@SuppressLint({"ViewConstructor"})
/* compiled from: ExtraParamIntegerView */
public class d extends f {
    public d(Context context, String str, b bVar, boolean z, String str2) {
        super(context, str, bVar.getTitle(), z, str2);
    }

    protected EditText bp(Context context) {
        EditText bp = super.bp(context);
        bp.setInputType(8194);
        bp.setKeyListener(DigitsKeyListener.getInstance(false, true));
        return bp;
    }
}
