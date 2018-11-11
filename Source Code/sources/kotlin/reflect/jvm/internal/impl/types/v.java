package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.m;

/* compiled from: IntersectionTypeConstructor */
public class v implements an {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Set<w> eUW;
    private final int hashCode = this.eUW.hashCode();

    public f bbW() {
        return null;
    }

    public boolean bbY() {
        return false;
    }

    public v(Collection<w> collection) {
        this.eUW = new LinkedHashSet(collection);
    }

    public List<an> getParameters() {
        return Collections.emptyList();
    }

    public Collection<w> beu() {
        return this.eUW;
    }

    public h bzb() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("member scope for intersection type ");
        stringBuilder.append(this);
        return m.a(stringBuilder.toString(), this.eUW);
    }

    public g bdy() {
        return ((w) this.eUW.iterator().next()).bwA().bdy();
    }

    public String toString() {
        return ag(this.eUW);
    }

    private static String ag(Iterable<w> iterable) {
        StringBuilder stringBuilder = new StringBuilder("{");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            stringBuilder.append(((w) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(" & ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return this.eUW == null ? vVar.eUW == null : this.eUW.equals(vVar.eUW);
    }

    public int hashCode() {
        return this.hashCode;
    }
}
