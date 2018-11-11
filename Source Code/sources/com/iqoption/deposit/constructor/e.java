package com.iqoption.deposit.constructor;

import com.iqoption.core.microservices.billing.response.extraparams.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, aXE = {"Lcom/iqoption/deposit/constructor/BaseSelectStringFieldHolder;", "Lcom/iqoption/deposit/constructor/FieldHolder;", "property", "Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamSelectProperty;", "name", "", "isRequired", "", "(Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamSelectProperty;Ljava/lang/String;Z)V", "getProperty", "()Lcom/iqoption/core/microservices/billing/response/extraparams/ExtraParamSelectProperty;", "value", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "deposit_release"})
/* compiled from: FieldHolders.kt */
public abstract class e extends f {
    private final c bXd;
    private String value;

    public final c abY() {
        return this.bXd;
    }

    public e(c cVar, String str, boolean z) {
        h.e(cVar, "property");
        h.e(str, "name");
        super(str, z);
        this.bXd = cVar;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    /* renamed from: abX */
    public c abT() {
        return this.bXd;
    }

    public String value() {
        String str = this.value;
        return str != null ? str : "";
    }
}
