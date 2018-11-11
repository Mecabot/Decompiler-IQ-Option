package com.iqoption.tutorial.a;

import android.content.Context;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, aXE = {"Lcom/iqoption/tutorial/strategy/CallPutAnotherInstrumentStrategy;", "Lcom/iqoption/tutorial/strategy/CallPutStrategy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "message", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CallPutAnotherInstrumentStrategy.kt */
public final class b extends c {
    public b(Context context) {
        h.e(context, "context");
        super(context);
    }

    public String message() {
        String string = getContext().getString(R.string.make_a_trade_based_on_new_trend);
        if (string == null) {
            h.aXZ();
        }
        return string;
    }
}
