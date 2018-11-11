package kotlin.reflect.jvm.internal.impl.resolve.scopes.a;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: ImplicitClassReceiver.kt */
public class c implements d, g {
    private final d eSA;
    private final c eSy;
    private final d eSz;

    public c(d dVar, c cVar) {
        h.e(dVar, "classDescriptor");
        this.eSA = dVar;
        if (cVar == null) {
            cVar = this;
        }
        this.eSy = cVar;
        this.eSz = this.eSA;
    }

    public final d bdP() {
        return this.eSA;
    }

    /* renamed from: bfN */
    public ad bai() {
        return this.eSA.bdb();
    }

    public boolean equals(Object obj) {
        d dVar = this.eSA;
        Object obj2 = null;
        if (!(obj instanceof c)) {
            obj = null;
        }
        c cVar = (c) obj;
        if (cVar != null) {
            obj2 = cVar.eSA;
        }
        return h.E(dVar, obj2);
    }

    public int hashCode() {
        return this.eSA.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class{");
        stringBuilder.append(bai());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
