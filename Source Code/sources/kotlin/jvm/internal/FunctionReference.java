package kotlin.jvm.internal;

import kotlin.reflect.a;
import kotlin.reflect.e;

public class FunctionReference extends CallableReference implements FunctionBase, e {
    private final int arity;

    public FunctionReference(int i) {
        this.arity = i;
    }

    public FunctionReference(int i, Object obj) {
        super(obj);
        this.arity = i;
    }

    /* renamed from: aXY */
    protected e aXS() {
        return (e) super.aXS();
    }

    protected a aXP() {
        return j.a(this);
    }

    /* JADX WARNING: Missing block: B:16:0x004e, code:
            if (kotlin.jvm.internal.h.E(aXQ(), r5.aXQ()) != false) goto L_0x0052;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r5 != r4) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof kotlin.jvm.internal.FunctionReference;
        r2 = 0;
        if (r1 == 0) goto L_0x0053;
    L_0x0009:
        r5 = (kotlin.jvm.internal.FunctionReference) r5;
        r1 = r4.Py();
        if (r1 != 0) goto L_0x0018;
    L_0x0011:
        r1 = r5.Py();
        if (r1 != 0) goto L_0x0051;
    L_0x0017:
        goto L_0x0026;
    L_0x0018:
        r1 = r4.Py();
        r3 = r5.Py();
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0051;
    L_0x0026:
        r1 = r4.getName();
        r3 = r5.getName();
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0051;
    L_0x0034:
        r1 = r4.getSignature();
        r3 = r5.getSignature();
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0051;
    L_0x0042:
        r1 = r4.aXQ();
        r5 = r5.aXQ();
        r5 = kotlin.jvm.internal.h.E(r1, r5);
        if (r5 == 0) goto L_0x0051;
    L_0x0050:
        goto L_0x0052;
    L_0x0051:
        r0 = 0;
    L_0x0052:
        return r0;
    L_0x0053:
        r0 = r5 instanceof kotlin.reflect.e;
        if (r0 == 0) goto L_0x0060;
    L_0x0057:
        r0 = r4.aXR();
        r5 = r5.equals(r0);
        return r5;
    L_0x0060:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.FunctionReference.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return (((Py() == null ? 0 : Py().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        FunctionReference aXR = aXR();
        if (aXR != this) {
            return aXR.toString();
        }
        String str;
        if ("<init>".equals(getName())) {
            str = "constructor (Kotlin reflection is not available)";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("function ");
            stringBuilder.append(getName());
            stringBuilder.append(" (Kotlin reflection is not available)");
            str = stringBuilder.toString();
        }
        return str;
    }
}
