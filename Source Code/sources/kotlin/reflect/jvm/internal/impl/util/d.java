package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.util.c.c;
import kotlin.text.Regex;

/* compiled from: modifierChecks.kt */
public final class d {
    private final f eBW;
    private final Regex eVZ;
    private final Collection<f> eWa;
    private final b<r, String> eWb;
    private final b[] eWc;

    private d(f fVar, Regex regex, Collection<f> collection, b<? super r, String> bVar, b... bVarArr) {
        this.eBW = fVar;
        this.eVZ = regex;
        this.eWa = collection;
        this.eWb = bVar;
        this.eWc = bVarArr;
    }

    public final boolean o(r rVar) {
        h.e(rVar, "functionDescriptor");
        if (this.eBW != null && (h.E(rVar.bdc(), this.eBW) ^ 1) != 0) {
            return false;
        }
        if (this.eVZ != null) {
            String asString = rVar.bdc().asString();
            h.d(asString, "functionDescriptor.name.asString()");
            if (!this.eVZ.matches(asString)) {
                return false;
            }
        }
        return this.eWa == null || this.eWa.contains(rVar.bdc());
    }

    public final c p(r rVar) {
        h.e(rVar, "functionDescriptor");
        for (b a : this.eWc) {
            String a2 = a.a(rVar);
            if (a2 != null) {
                return new c.b(a2);
            }
        }
        String str = (String) this.eWb.invoke(rVar);
        if (str != null) {
            return new c.b(str);
        }
        return c.eVY;
    }

    public d(f fVar, b[] bVarArr, b<? super r, String> bVar) {
        h.e(fVar, "name");
        h.e(bVarArr, "checks");
        h.e(bVar, "additionalChecks");
        this(fVar, null, null, (b) bVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }

    public d(Regex regex, b[] bVarArr, b<? super r, String> bVar) {
        h.e(regex, "regex");
        h.e(bVarArr, "checks");
        h.e(bVar, "additionalChecks");
        this(null, regex, null, (b) bVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }

    public d(Collection<f> collection, b[] bVarArr, b<? super r, String> bVar) {
        h.e(collection, "nameList");
        h.e(bVarArr, "checks");
        h.e(bVar, "additionalChecks");
        this(null, null, (Collection) collection, (b) bVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }
}
