package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.e;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: ClassDescriptorImpl */
public class h extends g {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Modality eCr;
    private final ClassKind eCs;
    private final an eCt;
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.h eCu;
    private Set<c> eCv;
    private c eCw;

    public d bbC() {
        return null;
    }

    public boolean bbK() {
        return false;
    }

    public boolean bbL() {
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

    public h(k kVar, f fVar, Modality modality, ClassKind classKind, Collection<w> collection, ai aiVar, boolean z, kotlin.reflect.jvm.internal.impl.storage.h hVar) {
        super(hVar, kVar, fVar, aiVar, z);
        this.eCr = modality;
        this.eCs = classKind;
        this.eCt = new e(this, Collections.emptyList(), collection, hVar);
    }

    public final void a(kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, Set<c> set, c cVar) {
        this.eCu = hVar;
        this.eCv = set;
        this.eCw = cVar;
    }

    public g bbQ() {
        return g.eBF.bel();
    }

    public an bby() {
        return this.eCt;
    }

    public Collection<c> bbE() {
        return this.eCv;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbA() {
        return this.eCu;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbx() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c.eSm;
    }

    public ClassKind bbF() {
        return this.eCs;
    }

    public c bbI() {
        return this.eCw;
    }

    public Modality bbG() {
        return this.eCr;
    }

    public av bbJ() {
        return au.eBg;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ");
        stringBuilder.append(bdc());
        return stringBuilder.toString();
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.an> bbS() {
        return Collections.emptyList();
    }
}
