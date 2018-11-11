package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;

/* compiled from: StarProjectionImpl.kt */
public final class ai {

    /* compiled from: StarProjectionImpl.kt */
    public static final class a extends ao {
        final /* synthetic */ List eVb;

        a(List list) {
            this.eVb = list;
        }

        public ap d(an anVar) {
            h.e(anVar, "key");
            if (!this.eVb.contains(anVar)) {
                return null;
            }
            f bbW = anVar.bbW();
            if (bbW != null) {
                return au.e((an) bbW);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    public static final w d(an anVar) {
        h.e(anVar, "$receiver");
        k bbv = anVar.bbv();
        if (bbv == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
        }
        an bby = ((g) bbv).bby();
        h.d(bby, "classDescriptor.typeConstructor");
        List parameters = bby.getParameters();
        h.d(parameters, "classDescriptor.typeConstructor.parameters");
        Iterable<an> iterable = parameters;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (an anVar2 : iterable) {
            h.d(anVar2, "it");
            arrayList.add(anVar2.bby());
        }
        TypeSubstitutor e = TypeSubstitutor.e((as) new a((List) arrayList));
        List aYq = anVar.aYq();
        h.d(aYq, "this.upperBounds");
        w c = e.c((w) u.bU(aYq), Variance.OUT_VARIANCE);
        if (c != null) {
            return c;
        }
        ad baW = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(anVar).baW();
        h.d(baW, "builtIns.defaultBound");
        return baW;
    }
}
