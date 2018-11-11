package com.iqoption.deposit.light.constructor;

import android.view.View;
import android.widget.EditText;
import com.iqoption.core.microservices.billing.response.extraparams.a;
import com.iqoption.deposit.constructor.d;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, aXE = {"Lcom/iqoption/deposit/light/constructor/SelectIntegerLightFieldHolder;", "Lcom/iqoption/deposit/constructor/BaseSelectIntegerFieldHolder;", "binding", "Lcom/iqoption/deposit/databinding/ConstructorSpinnerFieldLightBinding;", "property", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty;", "name", "", "isRequired", "", "(Lcom/iqoption/deposit/databinding/ConstructorSpinnerFieldLightBinding;Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty;Ljava/lang/String;Z)V", "getBinding", "()Lcom/iqoption/deposit/databinding/ConstructorSpinnerFieldLightBinding;", "editText", "Landroid/widget/EditText;", "setHint", "", "hint", "showError", "message", "value", "view", "Landroid/view/View;", "deposit_release"})
/* compiled from: FieldHoldersLight.kt */
public final class c extends d {
    private final com.iqoption.deposit.a.c caJ;

    public c(com.iqoption.deposit.a.c cVar, a aVar, String str, boolean z) {
        h.e(cVar, "binding");
        h.e(aVar, "property");
        h.e(str, "name");
        super(aVar, str, z);
        this.caJ = cVar;
    }

    /* renamed from: abV */
    public a abT() {
        return abW();
    }

    public View abZ() {
        return this.caJ.getRoot();
    }

    public String value() {
        EditText editText = this.caJ.bYv;
        h.d(editText, "binding.constructorSpinnerEdit");
        return editText.getText().toString();
    }

    public EditText aca() {
        return this.caJ.bYv;
    }

    public void hg(String str) {
        EditText editText = this.caJ.bYv;
        h.d(editText, "binding.constructorSpinnerEdit");
        editText.setHint(str);
    }

    public void hh(String str) {
        EditText editText = this.caJ.bYv;
        h.d(editText, "binding.constructorSpinnerEdit");
        com.iqoption.deposit.light.a.b(editText, str);
    }
}
