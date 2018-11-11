package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.descriptors.al.a;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: ClassTypeConstructorImpl */
public class e extends b implements an {
    private final Collection<w> eDM;
    private final d eSA;
    private final List<an> parameters;

    public boolean bbY() {
        return true;
    }

    public e(d dVar, List<? extends an> list, Collection<w> collection, h hVar) {
        super(hVar);
        this.eSA = dVar;
        this.parameters = Collections.unmodifiableList(new ArrayList(list));
        this.eDM = Collections.unmodifiableCollection(collection);
    }

    public List<an> getParameters() {
        return this.parameters;
    }

    public String toString() {
        return c.w(this.eSA).asString();
    }

    /* renamed from: bbX */
    public d bbW() {
        return this.eSA;
    }

    protected Collection<w> bbU() {
        return this.eDM;
    }

    protected al bbZ() {
        return a.eAZ;
    }
}
