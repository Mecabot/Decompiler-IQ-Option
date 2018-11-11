package com.iqoption.deposit.dark.a;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import com.iqoption.core.util.r;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/dark/card/ValidateTextWatcher;", "Lcom/iqoption/core/util/TextWatcherAdapter;", "textInputLayout", "Landroid/support/design/widget/TextInputLayout;", "(Landroid/support/design/widget/TextInputLayout;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "deposit_release"})
/* compiled from: CardPaymentDarkFragment.kt */
public final class b extends r {
    private final TextInputLayout bXO;

    public b(TextInputLayout textInputLayout) {
        h.e(textInputLayout, "textInputLayout");
        this.bXO = textInputLayout;
    }

    public void afterTextChanged(Editable editable) {
        h.e(editable, "s");
        super.afterTextChanged(editable);
        this.bXO.setError((CharSequence) null);
    }
}
