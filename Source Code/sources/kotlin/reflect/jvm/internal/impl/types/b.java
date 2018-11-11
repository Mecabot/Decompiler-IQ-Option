package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: AbstractClassTypeConstructor */
public abstract class b extends c implements an {
    private int hashCode = 0;

    /* renamed from: bbX */
    public abstract d bbW();

    public b(h hVar) {
        super(hVar);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        k bbX = bbW();
        if (c(bbX)) {
            i = c.w(bbX).hashCode();
        } else {
            i = System.identityHashCode(this);
        }
        this.hashCode = i;
        return i;
    }

    public g bdy() {
        return a.Q(bbW());
    }

    /* JADX WARNING: Missing block: B:22:0x004f, code:
            return false;
     */
    public final boolean equals(java.lang.Object r4) {
        /*
        r3 = this;
        if (r3 != r4) goto L_0x0004;
    L_0x0002:
        r4 = 1;
        return r4;
    L_0x0004:
        r0 = r4 instanceof kotlin.reflect.jvm.internal.impl.types.an;
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = r4.hashCode();
        r2 = r3.hashCode();
        if (r0 == r2) goto L_0x0015;
    L_0x0014:
        return r1;
    L_0x0015:
        r4 = (kotlin.reflect.jvm.internal.impl.types.an) r4;
        r0 = r4.getParameters();
        r0 = r0.size();
        r2 = r3.getParameters();
        r2 = r2.size();
        if (r0 == r2) goto L_0x002a;
    L_0x0029:
        return r1;
    L_0x002a:
        r0 = r3.bbW();
        r4 = r4.bbW();
        r2 = c(r0);
        if (r2 == 0) goto L_0x004f;
    L_0x0038:
        if (r4 == 0) goto L_0x0041;
    L_0x003a:
        r2 = c(r4);
        if (r2 != 0) goto L_0x0041;
    L_0x0040:
        goto L_0x004f;
    L_0x0041:
        r2 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d;
        if (r2 == 0) goto L_0x004e;
    L_0x0045:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r0;
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r4;
        r4 = e(r0, r4);
        return r4;
    L_0x004e:
        return r1;
    L_0x004f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.b.equals(java.lang.Object):boolean");
    }

    private static boolean e(d dVar, d dVar2) {
        if (!dVar.bdc().equals(dVar2.bdc())) {
            return false;
        }
        k bbv = dVar.bbv();
        k bbv2 = dVar2.bbv();
        while (true) {
            boolean z = true;
            if (bbv == null || bbv2 == null) {
                return true;
            }
            if (bbv instanceof u) {
                return bbv2 instanceof u;
            }
            if (bbv2 instanceof u) {
                return false;
            }
            if (bbv instanceof x) {
                if (!((bbv2 instanceof x) && ((x) bbv).bdD().equals(((x) bbv2).bdD()))) {
                    z = false;
                }
                return z;
            } else if ((bbv2 instanceof x) || !bbv.bdc().equals(bbv2.bdc())) {
                return false;
            } else {
                bbv = bbv.bbv();
                bbv2 = bbv2.bbv();
            }
        }
        return true;
    }

    private static boolean c(f fVar) {
        return (p.W(fVar) || c.u(fVar)) ? false : true;
    }

    protected Collection<w> hg(boolean z) {
        k bbv = bbW().bbv();
        if (!(bbv instanceof d)) {
            return Collections.emptyList();
        }
        Collection<w> hVar = new kotlin.reflect.jvm.internal.impl.utils.h();
        d dVar = (d) bbv;
        hVar.add(dVar.bdb());
        dVar = dVar.bbC();
        if (z && dVar != null) {
            hVar.add(dVar.bdb());
        }
        return hVar;
    }

    protected w bex() {
        if (g.e(bbW())) {
            return null;
        }
        return bdy().baU();
    }
}
