package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.aa;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.a.h;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: AbstractReceiverParameterDescriptor */
public abstract class c extends j implements ag {
    private static final f eCb = f.mF("<this>");

    public ag bcO() {
        return null;
    }

    public ag bcP() {
        return null;
    }

    public boolean bcT() {
        return false;
    }

    /* renamed from: ben */
    public aa bcZ() {
        return this;
    }

    public c() {
        super(g.eBF.bel(), eCb);
    }

    /* renamed from: e */
    public ag f(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        w c;
        if (bbv() instanceof d) {
            c = typeSubstitutor.c(bai(), Variance.OUT_VARIANCE);
        } else {
            c = typeSubstitutor.c(bai(), Variance.INVARIANT);
        }
        if (c == null) {
            return null;
        }
        if (c == bai()) {
            return this;
        }
        return new ab(bbv(), new h(c));
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        return mVar.a((ag) this, (Object) d);
    }

    public List<an> getTypeParameters() {
        return Collections.emptyList();
    }

    public w bcQ() {
        return bai();
    }

    public w bai() {
        return bdM().bai();
    }

    public List<aq> bcS() {
        return Collections.emptyList();
    }

    public Collection<? extends a> bcU() {
        return Collections.emptySet();
    }

    public av bbJ() {
        return au.eBh;
    }

    public ai bbR() {
        return ai.eAX;
    }
}
