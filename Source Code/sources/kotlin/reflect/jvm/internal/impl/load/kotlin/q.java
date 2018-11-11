package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.b;

/* compiled from: MemberSignature.kt */
public final class q {
    public static final a eJW = new a();
    private final String signature;

    /* compiled from: MemberSignature.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final q a(c cVar, JvmMethodSignature jvmMethodSignature) {
            h.e(cVar, "nameResolver");
            h.e(jvmMethodSignature, "signature");
            return bc(cVar.getString(jvmMethodSignature.blW()), cVar.getString(jvmMethodSignature.bsf()));
        }

        public final q bc(String str, String str2) {
            h.e(str, "name");
            h.e(str2, "desc");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            return new q(stringBuilder.toString(), null);
        }

        public final q bd(String str, String str2) {
            h.e(str, "name");
            h.e(str2, "desc");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("#");
            stringBuilder.append(str2);
            return new q(stringBuilder.toString(), null);
        }

        public final q a(f fVar) {
            h.e(fVar, "signature");
            if (fVar instanceof b) {
                return bc(fVar.getName(), fVar.getDesc());
            }
            if (fVar instanceof kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.a) {
                return bd(fVar.getName(), fVar.getDesc());
            }
            throw new NoWhenBranchMatchedException();
        }

        public final q a(q qVar, int i) {
            h.e(qVar, "signature");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(qVar.biD());
            stringBuilder.append("@");
            stringBuilder.append(i);
            return new q(stringBuilder.toString(), null);
        }
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.signature, ((kotlin.reflect.jvm.internal.impl.load.kotlin.q) r2).signature) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.q;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (kotlin.reflect.jvm.internal.impl.load.kotlin.q) r2;
        r0 = r1.signature;
        r2 = r2.signature;
        r2 = kotlin.jvm.internal.h.E(r0, r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0015;
    L_0x0013:
        r2 = 0;
        return r2;
    L_0x0015:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.q.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.signature;
        return str != null ? str.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MemberSignature(signature=");
        stringBuilder.append(this.signature);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private q(String str) {
        this.signature = str;
    }

    public /* synthetic */ q(String str, f fVar) {
        this(str);
    }

    public final String biD() {
        return this.signature;
    }
}
