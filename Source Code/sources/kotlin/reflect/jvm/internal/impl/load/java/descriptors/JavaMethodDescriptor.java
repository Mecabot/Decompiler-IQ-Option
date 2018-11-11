package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.r.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.util.i;

public class JavaMethodDescriptor extends ac implements b {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final b<aq> eGs = new b<aq>() {
    };
    private ParameterNamesStatus eGt = null;

    private enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean isStable;
        public final boolean isSynthesized;

        private ParameterNamesStatus(boolean z, boolean z2) {
            this.isStable = z;
            this.isSynthesized = z2;
        }

        public static ParameterNamesStatus get(boolean z, boolean z2) {
            return z ? z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
        }
    }

    protected JavaMethodDescriptor(k kVar, ah ahVar, g gVar, f fVar, Kind kind, ai aiVar) {
        super(kVar, ahVar, gVar, fVar, kind, aiVar);
    }

    public static JavaMethodDescriptor a(k kVar, g gVar, f fVar, ai aiVar) {
        return new JavaMethodDescriptor(kVar, null, gVar, fVar, Kind.DECLARATION, aiVar);
    }

    public ac a(w wVar, ag agVar, List<? extends an> list, List<aq> list2, w wVar2, Modality modality, av avVar, Map<? extends b<?>, ?> map) {
        Object a = super.a(wVar, agVar, list, list2, wVar2, modality, avVar, map);
        gv(i.eWm.m(a).isSuccess());
        return a;
    }

    public boolean beF() {
        return this.eGt.isStable;
    }

    public boolean bcT() {
        return this.eGt.isSynthesized;
    }

    public void o(boolean z, boolean z2) {
        this.eGt = ParameterNamesStatus.get(z, z2);
    }

    /* renamed from: e */
    protected JavaMethodDescriptor a(k kVar, r rVar, Kind kind, f fVar, g gVar, ai aiVar) {
        ah ahVar = (ah) rVar;
        if (fVar == null) {
            fVar = bdc();
        }
        JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(kVar, ahVar, gVar, fVar, kind, aiVar);
        javaMethodDescriptor.o(beF(), bcT());
        return javaMethodDescriptor;
    }

    /* renamed from: c */
    public JavaMethodDescriptor a(w wVar, List<i> list, w wVar2) {
        return (JavaMethodDescriptor) bdr().cb(h.a(list, bcS(), this)).M(wVar2).N(wVar).bdu().bdt().bdx();
    }
}
