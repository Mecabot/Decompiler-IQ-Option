package com.iqoption.deposit.constructor;

import com.iqoption.core.microservices.billing.response.extraparams.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, aXE = {"Lcom/iqoption/deposit/constructor/BaseSelectIntegerFieldHolder;", "Lcom/iqoption/deposit/constructor/FieldHolder;", "property", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty;", "name", "", "isRequired", "", "(Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty;Ljava/lang/String;Z)V", "getProperty", "()Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamEnumProperty;", "value", "deposit_release"})
/* compiled from: FieldHolders.kt */
public abstract class d extends f {
    private final a bXc;

    protected final a abW() {
        return this.bXc;
    }

    public d(a aVar, String str, boolean z) {
        h.e(aVar, "property");
        h.e(str, "name");
        super(str, z);
        this.bXc = aVar;
    }

    /* renamed from: abV */
    public a abT() {
        return this.bXc;
    }

    public String value() {
        return aca().getText().toString();
    }
}
