package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.structure.i;
import kotlin.reflect.jvm.internal.impl.load.java.structure.j;
import kotlin.reflect.jvm.internal.impl.load.java.structure.p;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;
import kotlin.reflect.jvm.internal.impl.load.java.structure.v;
import kotlin.reflect.jvm.internal.impl.load.java.structure.y;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;

/* compiled from: DescriptorResolverUtils */
public final class a {
    public static <D extends CallableMemberDescriptor> Collection<D> a(f fVar, Collection<D> collection, Collection<D> collection2, d dVar, l lVar) {
        return a(fVar, collection, collection2, dVar, lVar, false);
    }

    public static <D extends CallableMemberDescriptor> Collection<D> b(f fVar, Collection<D> collection, Collection<D> collection2, d dVar, l lVar) {
        return a(fVar, collection, collection2, dVar, lVar, true);
    }

    private static <D extends CallableMemberDescriptor> Collection<D> a(f fVar, Collection<D> collection, Collection<D> collection2, d dVar, final l lVar, final boolean z) {
        final Collection linkedHashSet = new LinkedHashSet();
        OverridingUtil.a(fVar, collection, collection2, dVar, new g() {
            public void a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
            }

            public void h(CallableMemberDescriptor callableMemberDescriptor) {
                OverridingUtil.a(callableMemberDescriptor, new b<CallableMemberDescriptor, kotlin.l>() {
                    /* renamed from: x */
                    public kotlin.l invoke(CallableMemberDescriptor callableMemberDescriptor) {
                        lVar.c(callableMemberDescriptor);
                        return kotlin.l.etX;
                    }
                });
                linkedHashSet.add(callableMemberDescriptor);
            }

            public void a(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection) {
                if (!z || callableMemberDescriptor.bcW() == Kind.FAKE_OVERRIDE) {
                    super.a(callableMemberDescriptor, collection);
                }
            }
        });
        return linkedHashSet;
    }

    public static aq b(f fVar, d dVar) {
        Collection bbE = dVar.bbE();
        if (bbE.size() != 1) {
            return null;
        }
        for (aq aqVar : ((c) bbE.iterator().next()).bcS()) {
            if (aqVar.bdc().equals(fVar)) {
                return aqVar;
            }
        }
        return null;
    }

    public static boolean a(p pVar) {
        return pVar.bhF().isInterface() && (pVar instanceof q) && a((q) pVar);
    }

    public static boolean a(q qVar) {
        String asString = qVar.bdc().asString();
        if (asString.equals("toString") || asString.equals("hashCode")) {
            return qVar.bcS().isEmpty();
        }
        return asString.equals("equals") ? a(qVar, "java.lang.Object") : false;
    }

    private static boolean a(q qVar, String str) {
        List bcS = qVar.bcS();
        boolean z = true;
        if (bcS.size() == 1) {
            v bhD = ((y) bcS.get(0)).bhD();
            if (bhD instanceof j) {
                i bhw = ((j) bhD).bhw();
                if (bhw instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.g) {
                    kotlin.reflect.jvm.internal.impl.name.b bdD = ((kotlin.reflect.jvm.internal.impl.load.java.structure.g) bhw).bdD();
                    if (bdD == null || !bdD.asString().equals(str)) {
                        z = false;
                    }
                    return z;
                }
            }
        }
        return false;
    }
}
