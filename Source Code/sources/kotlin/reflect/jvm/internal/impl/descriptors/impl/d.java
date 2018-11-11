package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: AbstractTypeAliasDescriptor.kt */
public abstract class d extends k implements am {
    private List<? extends an> eCc;
    private final a eCd = new a(this);
    private final av eCe;

    /* compiled from: AbstractTypeAliasDescriptor.kt */
    public static final class a implements kotlin.reflect.jvm.internal.impl.types.an {
        final /* synthetic */ d this$0;

        public boolean bbY() {
            return true;
        }

        a(d dVar) {
            this.this$0 = dVar;
        }

        /* renamed from: bet */
        public am bbW() {
            return this.this$0;
        }

        public List<an> getParameters() {
            return this.this$0.ber();
        }

        public Collection<w> beu() {
            Collection<w> beu = bbW().bdN().bwA().beu();
            h.d(beu, "declarationDescriptor.un…pe.constructor.supertypes");
            return beu;
        }

        public g bdy() {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(bbW());
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[typealias ");
            stringBuilder.append(bbW().bdc().asString());
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }

    protected abstract kotlin.reflect.jvm.internal.impl.storage.h baI();

    public boolean bbO() {
        return false;
    }

    public boolean bbP() {
        return false;
    }

    protected abstract List<an> ber();

    public boolean isExternal() {
        return false;
    }

    public d(k kVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, f fVar, ai aiVar, av avVar) {
        h.e(kVar, "containingDeclaration");
        h.e(gVar, "annotations");
        h.e(fVar, "name");
        h.e(aiVar, "sourceElement");
        h.e(avVar, "visibilityImpl");
        super(kVar, gVar, fVar, aiVar);
        this.eCe = avVar;
    }

    public final void cc(List<? extends an> list) {
        h.e(list, "declaredTypeParameters");
        this.eCc = list;
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        h.e(mVar, "visitor");
        return mVar.a((am) this, (Object) d);
    }

    public boolean bbL() {
        return au.b((w) bdN(), (b) new AbstractTypeAliasDescriptor$isInner$1(this));
    }

    public final Collection<ae> beo() {
        kotlin.reflect.jvm.internal.impl.descriptors.d bdP = bdP();
        if (bdP == null) {
            return m.emptyList();
        }
        Collection<c> bbE = bdP.bbE();
        h.d(bbE, "classDescriptor.constructors");
        Collection arrayList = new ArrayList();
        for (c cVar : bbE) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.af.a aVar = af.eEg;
            kotlin.reflect.jvm.internal.impl.storage.h baI = baI();
            am amVar = this;
            h.d(cVar, "it");
            ae a = aVar.a(baI, amVar, cVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return (List) arrayList;
    }

    public List<an> bbS() {
        List<an> list = this.eCc;
        if (list == null) {
            h.lS("declaredTypeParametersImpl");
        }
        return list;
    }

    public Modality bbG() {
        return Modality.FINAL;
    }

    public av bbJ() {
        return this.eCe;
    }

    public kotlin.reflect.jvm.internal.impl.types.an bby() {
        return this.eCd;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("typealias ");
        stringBuilder.append(bdc().asString());
        return stringBuilder.toString();
    }

    /* renamed from: bep */
    public am beq() {
        n beq = super.bcZ();
        if (beq != null) {
            return (am) beq;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }

    /* JADX WARNING: Missing block: B:3:0x000d, code:
            if (r1 != null) goto L_0x0014;
     */
    protected final kotlin.reflect.jvm.internal.impl.types.ad bes() {
        /*
        r2 = this;
        r0 = r2;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.f) r0;
        r1 = r2.bdP();
        if (r1 == 0) goto L_0x0010;
    L_0x0009:
        r1 = r1.bbA();
        if (r1 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0014;
    L_0x0010:
        r1 = kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c.eSm;
        r1 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.h) r1;
    L_0x0014:
        r0 = kotlin.reflect.jvm.internal.impl.types.au.a(r0, r1);
        r1 = "TypeUtils.makeUnsubstitu…ope ?: MemberScope.Empty)";
        kotlin.jvm.internal.h.d(r0, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.d.bes():kotlin.reflect.jvm.internal.impl.types.ad");
    }
}
