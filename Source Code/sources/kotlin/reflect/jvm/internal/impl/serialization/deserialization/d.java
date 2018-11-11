package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.a.a;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;

/* compiled from: ClassData.kt */
public final class d {
    private final Class eSB;
    private final a eSC;
    private final ai eSD;
    private final c evp;

    public final c bxn() {
        return this.evp;
    }

    public final Class bxo() {
        return this.eSB;
    }

    public final a bxp() {
        return this.eSC;
    }

    public final ai bxq() {
        return this.eSD;
    }

    /* JADX WARNING: Missing block: B:10:0x002e, code:
            if (kotlin.jvm.internal.h.E(r2.eSD, r3.eSD) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033;
    L_0x0002:
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.d;
        if (r0 == 0) goto L_0x0031;
    L_0x0006:
        r3 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.d) r3;
        r0 = r2.evp;
        r1 = r3.evp;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0012:
        r0 = r2.eSB;
        r1 = r3.eSB;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x001c:
        r0 = r2.eSC;
        r1 = r3.eSC;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0026:
        r0 = r2.eSD;
        r3 = r3.eSD;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0033;
    L_0x0031:
        r3 = 0;
        return r3;
    L_0x0033:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        c cVar = this.evp;
        int i = 0;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        Class classR = this.eSB;
        hashCode = (hashCode + (classR != null ? classR.hashCode() : 0)) * 31;
        a aVar = this.eSC;
        hashCode = (hashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        ai aiVar = this.eSD;
        if (aiVar != null) {
            i = aiVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassData(nameResolver=");
        stringBuilder.append(this.evp);
        stringBuilder.append(", classProto=");
        stringBuilder.append(this.eSB);
        stringBuilder.append(", metadataVersion=");
        stringBuilder.append(this.eSC);
        stringBuilder.append(", sourceElement=");
        stringBuilder.append(this.eSD);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(c cVar, Class classR, a aVar, ai aiVar) {
        h.e(cVar, "nameResolver");
        h.e(classR, "classProto");
        h.e(aVar, "metadataVersion");
        h.e(aiVar, "sourceElement");
        this.evp = cVar;
        this.eSB = classR;
        this.eSC = aVar;
        this.eSD = aiVar;
    }
}
