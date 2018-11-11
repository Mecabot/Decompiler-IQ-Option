package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.h;
import kotlin.reflect.jvm.internal.impl.types.e;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: MutableClassDescriptor */
public class v extends g {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private List<an> eAR;
    private final boolean eAT;
    private av eCK;
    private Modality eCr;
    private final ClassKind eCs;
    private kotlin.reflect.jvm.internal.impl.types.an eCt;
    private final Collection<w> eDM = new ArrayList();
    private final h exB;

    public d bbC() {
        return null;
    }

    public c bbI() {
        return null;
    }

    public boolean bbK() {
        return false;
    }

    public boolean bbM() {
        return false;
    }

    public boolean bbN() {
        return false;
    }

    public boolean bbO() {
        return false;
    }

    public boolean bbP() {
        return false;
    }

    public v(k kVar, ClassKind classKind, boolean z, boolean z2, f fVar, ai aiVar, h hVar) {
        super(hVar, kVar, fVar, aiVar, z2);
        this.exB = hVar;
        this.eCs = classKind;
        this.eAT = z;
    }

    public g bbQ() {
        return g.eBF.bel();
    }

    public void c(Modality modality) {
        this.eCr = modality;
    }

    public Modality bbG() {
        return this.eCr;
    }

    public ClassKind bbF() {
        return this.eCs;
    }

    public void d(av avVar) {
        this.eCK = avVar;
    }

    public av bbJ() {
        return this.eCK;
    }

    public boolean bbL() {
        return this.eAT;
    }

    public kotlin.reflect.jvm.internal.impl.types.an bby() {
        return this.eCt;
    }

    /* renamed from: beX */
    public Set<c> bbE() {
        return Collections.emptySet();
    }

    public void cf(List<an> list) {
        if (this.eAR != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Type parameters are already set for ");
            stringBuilder.append(bdc());
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.eAR = new ArrayList(list);
    }

    public List<an> bbS() {
        return this.eAR;
    }

    public void beY() {
        this.eCt = new e(this, this.eAR, this.eDM, this.exB);
        for (c cVar : bbE()) {
            ((f) cVar).Q(bdb());
        }
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbA() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c.eSm;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbx() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c.eSm;
    }

    public String toString() {
        return j.m(this);
    }
}
