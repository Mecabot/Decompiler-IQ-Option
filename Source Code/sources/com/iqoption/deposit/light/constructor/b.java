package com.iqoption.deposit.light.constructor;

import android.view.View;
import android.widget.EditText;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty;
import com.iqoption.deposit.a.g;
import com.iqoption.deposit.constructor.c;
import com.iqoption.deposit.light.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, aXE = {"Lcom/iqoption/deposit/light/constructor/EditLightFieldHolder;", "Lcom/iqoption/deposit/constructor/BaseEditFieldHolder;", "binding", "Lcom/iqoption/deposit/databinding/ConstructorTextEditFieldLightBinding;", "property", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "name", "", "isRequired", "", "(Lcom/iqoption/deposit/databinding/ConstructorTextEditFieldLightBinding;Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;Ljava/lang/String;Z)V", "getBinding", "()Lcom/iqoption/deposit/databinding/ConstructorTextEditFieldLightBinding;", "editText", "Landroid/widget/EditText;", "setHint", "", "hint", "showError", "message", "view", "Landroid/view/View;", "deposit_release"})
/* compiled from: FieldHoldersLight.kt */
public final class b extends c {
    private final g caI;

    public b(g gVar, ExtraParamProperty extraParamProperty, String str, boolean z) {
        h.e(gVar, "binding");
        h.e(extraParamProperty, "property");
        h.e(str, "name");
        super(extraParamProperty, str, z);
        this.caI = gVar;
    }

    public View abZ() {
        return this.caI.getRoot();
    }

    public ExtraParamProperty abT() {
        return abU();
    }

    public EditText aca() {
        return this.caI.bYy;
    }

    public void hg(String str) {
        EditText editText = this.caI.bYy;
        h.d(editText, "binding.constructorPaymentEdit");
        editText.setHint(str);
    }

    public void hh(String str) {
        EditText editText = this.caI.bYy;
        h.d(editText, "binding.constructorPaymentEdit");
        a.b(editText, str);
    }
}
