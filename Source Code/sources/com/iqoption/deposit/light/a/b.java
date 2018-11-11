package com.iqoption.deposit.light.a;

import android.text.Editable;
import android.widget.EditText;
import com.iqoption.core.util.r;
import com.iqoption.deposit.light.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/light/card/ValidateTextWatcher;", "Lcom/iqoption/core/util/TextWatcherAdapter;", "editText", "Landroid/widget/EditText;", "(Landroid/widget/EditText;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "deposit_release"})
/* compiled from: CardPaymentLightFragment.kt */
public final class b extends r {
    private final EditText aMM;

    public b(EditText editText) {
        h.e(editText, "editText");
        this.aMM = editText;
    }

    public void afterTextChanged(Editable editable) {
        h.e(editable, "s");
        super.afterTextChanged(editable);
        a.b(this.aMM, null);
    }
}
