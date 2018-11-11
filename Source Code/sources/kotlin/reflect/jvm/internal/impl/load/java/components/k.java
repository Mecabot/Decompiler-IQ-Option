package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: SignaturePropagator */
public interface k {
    public static final k eGm = new k() {
        public a a(q qVar, d dVar, w wVar, w wVar2, List<aq> list, List<an> list2) {
            return new a(wVar, wVar2, list, list2, Collections.emptyList(), false);
        }

        public void a(CallableMemberDescriptor callableMemberDescriptor, List<String> list) {
            throw new UnsupportedOperationException("Should not be called");
        }
    };

    /* compiled from: SignaturePropagator */
    public static class a {
        private final List<an> eAR;
        private final boolean eCT;
        private final w eDY;
        private final w eGn;
        private final List<aq> eGo;
        private final List<String> eGp;

        public a(w wVar, w wVar2, List<aq> list, List<an> list2, List<String> list3, boolean z) {
            this.eDY = wVar;
            this.eGn = wVar2;
            this.eGo = list;
            this.eAR = list2;
            this.eGp = list3;
            this.eCT = z;
        }

        public w bcQ() {
            return this.eDY;
        }

        public w bfS() {
            return this.eGn;
        }

        public List<aq> bcS() {
            return this.eGo;
        }

        public List<an> getTypeParameters() {
            return this.eAR;
        }

        public boolean beF() {
            return this.eCT;
        }

        public List<String> getErrors() {
            return this.eGp;
        }
    }

    a a(q qVar, d dVar, w wVar, w wVar2, List<aq> list, List<an> list2);

    void a(CallableMemberDescriptor callableMemberDescriptor, List<String> list);
}
