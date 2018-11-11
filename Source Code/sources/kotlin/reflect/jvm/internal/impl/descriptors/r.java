package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.as;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: FunctionDescriptor */
public interface r extends CallableMemberDescriptor {

    /* compiled from: FunctionDescriptor */
    public interface a<D extends r> {
        a<D> M(w wVar);

        a<D> N(w wVar);

        a<D> a(Kind kind);

        a<D> a(Modality modality);

        a<D> a(ag agVar);

        a<D> a(g gVar);

        a<D> a(av avVar);

        a<D> b(as asVar);

        a<D> bds();

        a<D> bdt();

        a<D> bdu();

        a<D> bdv();

        a<D> bdw();

        D bdx();

        a<D> cb(List<aq> list);

        a<D> e(f fVar);

        a<D> gu(boolean z);

        a<D> h(k kVar);
    }

    /* compiled from: FunctionDescriptor */
    public interface b<V> {
    }

    <V> V a(b<V> bVar);

    boolean bbN();

    k bbv();

    Collection<? extends r> bcU();

    boolean bcb();

    r bdk();

    r bdl();

    boolean bdm();

    boolean bdn();

    boolean bdo();

    boolean bdp();

    boolean bdq();

    a<? extends r> bdr();

    r c(TypeSubstitutor typeSubstitutor);
}
