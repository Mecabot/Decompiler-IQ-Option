package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.j;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.renderer.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: MemberComparator */
public class e implements Comparator<k> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final e eQL = new e();
    private static final b eQM = b.ePh.n(new kotlin.jvm.a.b<f, l>() {
        /* renamed from: d */
        public l invoke(f fVar) {
            fVar.gY(false);
            fVar.setVerbose(true);
            fVar.a(AnnotationArgumentsRenderingPolicy.UNLESS_EMPTY);
            fVar.l(DescriptorRendererModifier.ALL);
            return l.etX;
        }
    });

    /* compiled from: MemberComparator */
    public static class a implements Comparator<k> {
        public static final a eQN = new a();

        private a() {
        }

        private static int O(k kVar) {
            if (c.G(kVar)) {
                return 8;
            }
            if (kVar instanceof j) {
                return 7;
            }
            if (kVar instanceof ad) {
                return ((ad) kVar).bcO() == null ? 6 : 5;
            } else {
                if (kVar instanceof r) {
                    return ((r) kVar).bcO() == null ? 4 : 3;
                } else {
                    if (kVar instanceof d) {
                        return 2;
                    }
                    return kVar instanceof am ? 1 : 0;
                }
            }
        }

        /* renamed from: g */
        public int compare(k kVar, k kVar2) {
            Integer h = h(kVar, kVar2);
            return h != null ? h.intValue() : 0;
        }

        private static Integer h(k kVar, k kVar2) {
            int O = O(kVar2) - O(kVar);
            if (O != 0) {
                return Integer.valueOf(O);
            }
            if (c.G(kVar) && c.G(kVar2)) {
                return Integer.valueOf(0);
            }
            int H = kVar.bdc().compareTo(kVar2.bdc());
            return H != 0 ? Integer.valueOf(H) : null;
        }
    }

    private e() {
    }

    /* renamed from: g */
    public int compare(k kVar, k kVar2) {
        Integer i = a.h(kVar, kVar2);
        if (i != null) {
            return i.intValue();
        }
        int compareTo;
        if ((kVar instanceof am) && (kVar2 instanceof am)) {
            compareTo = eQM.b(((am) kVar).bdN()).compareTo(eQM.b(((am) kVar2).bdN()));
            if (compareTo != 0) {
                return compareTo;
            }
        } else if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            int compareTo2;
            int i2;
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar;
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar2;
            ag bcO = aVar.bcO();
            ag bcO2 = aVar2.bcO();
            if (bcO != null) {
                compareTo2 = eQM.b(bcO.bai()).compareTo(eQM.b(bcO2.bai()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
            }
            List bcS = aVar.bcS();
            List bcS2 = aVar2.bcS();
            for (i2 = 0; i2 < Math.min(bcS.size(), bcS2.size()); i2++) {
                int compareTo3 = eQM.b(((aq) bcS.get(i2)).bai()).compareTo(eQM.b(((aq) bcS2.get(i2)).bai()));
                if (compareTo3 != 0) {
                    return compareTo3;
                }
            }
            compareTo2 = bcS.size() - bcS2.size();
            if (compareTo2 != 0) {
                return compareTo2;
            }
            bcS = aVar.getTypeParameters();
            bcS2 = aVar2.getTypeParameters();
            for (i2 = 0; i2 < Math.min(bcS.size(), bcS2.size()); i2++) {
                List aYq = ((an) bcS.get(i2)).aYq();
                List aYq2 = ((an) bcS2.get(i2)).aYq();
                int size = aYq.size() - aYq2.size();
                if (size != 0) {
                    return size;
                }
                for (size = 0; size < aYq.size(); size++) {
                    int compareTo4 = eQM.b((w) aYq.get(size)).compareTo(eQM.b((w) aYq2.get(size)));
                    if (compareTo4 != 0) {
                        return compareTo4;
                    }
                }
            }
            int size2 = bcS.size() - bcS2.size();
            if (size2 != 0) {
                return size2;
            }
            if ((aVar instanceof CallableMemberDescriptor) && (aVar2 instanceof CallableMemberDescriptor)) {
                compareTo = ((CallableMemberDescriptor) aVar).bcW().ordinal() - ((CallableMemberDescriptor) aVar2).bcW().ordinal();
                if (compareTo != 0) {
                    return compareTo;
                }
            }
        } else {
            int i3 = 1;
            if ((kVar instanceof d) && (kVar2 instanceof d)) {
                d dVar = (d) kVar;
                d dVar2 = (d) kVar2;
                if (dVar.bbF().ordinal() != dVar2.bbF().ordinal()) {
                    return dVar.bbF().ordinal() - dVar2.bbF().ordinal();
                }
                if (dVar.bbK() != dVar2.bbK()) {
                    if (!dVar.bbK()) {
                        i3 = -1;
                    }
                    return i3;
                }
            }
            throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", new Object[]{kVar, kVar.getClass(), kVar2, kVar2.getClass()}));
        }
        compareTo = eQM.s(kVar).compareTo(eQM.s(kVar2));
        if (compareTo != 0) {
            return compareTo;
        }
        return c.B(kVar).bdc().compareTo(c.B(kVar2).bdc());
    }
}
