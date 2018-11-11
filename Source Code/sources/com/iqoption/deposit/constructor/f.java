package com.iqoption.deposit.constructor;

import android.view.View;
import android.widget.EditText;
import com.iqoption.core.microservices.billing.response.extraparams.ExtraParamProperty;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0015H&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, aXE = {"Lcom/iqoption/deposit/constructor/FieldHolder;", "", "name", "", "isRequired", "", "(Ljava/lang/String;Z)V", "()Z", "getName", "()Ljava/lang/String;", "editText", "Landroid/widget/EditText;", "property", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamProperty;", "setHint", "", "hint", "showError", "message", "value", "view", "Landroid/view/View;", "deposit_release"})
/* compiled from: FieldHolders.kt */
public abstract class f {
    private final boolean bXe;
    private final String name;

    public abstract ExtraParamProperty abT();

    public abstract View abZ();

    public abstract EditText aca();

    public abstract void hg(String str);

    public abstract void hh(String str);

    public abstract String value();

    public f(String str, boolean z) {
        h.e(str, "name");
        this.name = str;
        this.bXe = z;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isRequired() {
        return this.bXe;
    }
}
