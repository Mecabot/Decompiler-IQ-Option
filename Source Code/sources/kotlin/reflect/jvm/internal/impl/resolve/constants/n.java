package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: IntegerValueTypeConstructor.kt */
public final class n implements an {
    private final ArrayList<w> eRr;
    private final u ezG;
    private final long value;

    public boolean bbY() {
        return false;
    }

    public Void bwC() {
        return null;
    }

    public /* synthetic */ f bbW() {
        return (f) bwC();
    }

    public Collection<w> beu() {
        return this.eRr;
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.an> getParameters() {
        return m.emptyList();
    }

    public g bdy() {
        return this.ezG.bdy();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IntegerValueType(");
        stringBuilder.append(this.value);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
