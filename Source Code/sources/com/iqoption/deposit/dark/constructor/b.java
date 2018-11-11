package com.iqoption.deposit.dark.constructor;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty;
import com.iqoption.deposit.a.e;
import com.iqoption.deposit.constructor.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, aXE = {"Lcom/iqoption/deposit/dark/constructor/EditDarkFieldHolder;", "Lcom/iqoption/deposit/constructor/BaseEditFieldHolder;", "binding", "Lcom/iqoption/deposit/databinding/ConstructorTextEditFieldBinding;", "property", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "name", "", "isRequired", "", "(Lcom/iqoption/deposit/databinding/ConstructorTextEditFieldBinding;Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;Ljava/lang/String;Z)V", "getBinding", "()Lcom/iqoption/deposit/databinding/ConstructorTextEditFieldBinding;", "editText", "Landroid/support/design/widget/TextInputEditText;", "setHint", "", "hint", "showError", "message", "view", "Landroid/view/View;", "deposit_release"})
/* compiled from: FieldHoldersDark.kt */
public final class b extends c {
    private final e bXS;

    public b(e eVar, ExtraParamProperty extraParamProperty, String str, boolean z) {
        h.e(eVar, "binding");
        h.e(extraParamProperty, "property");
        h.e(str, "name");
        super(extraParamProperty, str, z);
        this.bXS = eVar;
    }

    public View abZ() {
        return this.bXS.getRoot();
    }

    public ExtraParamProperty abT() {
        return abU();
    }

    /* renamed from: acP */
    public TextInputEditText aca() {
        return this.bXS.bYw;
    }

    public void hg(String str) {
        TextInputLayout textInputLayout = this.bXS.bYx;
        h.d(textInputLayout, "binding.constructorPaymentInput");
        textInputLayout.setHint(str);
    }

    public void hh(String str) {
        TextInputLayout textInputLayout = this.bXS.bYx;
        h.d(textInputLayout, "binding.constructorPaymentInput");
        textInputLayout.setError(str);
        textInputLayout = this.bXS.bYx;
        h.d(textInputLayout, "binding.constructorPaymentInput");
        textInputLayout.setErrorEnabled(str != null);
    }
}
