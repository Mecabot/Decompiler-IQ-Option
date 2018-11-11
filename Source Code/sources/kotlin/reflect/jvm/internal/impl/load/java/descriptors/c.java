package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: JavaClassConstructorDescriptor */
public class c extends f implements b {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Boolean eGq = null;
    private Boolean eGr = null;

    protected c(d dVar, c cVar, g gVar, boolean z, Kind kind, ai aiVar) {
        super(dVar, cVar, gVar, z, kind, aiVar);
    }

    public static c b(d dVar, g gVar, boolean z, ai aiVar) {
        return new c(dVar, null, gVar, z, Kind.DECLARATION, aiVar);
    }

    public boolean beF() {
        return this.eGq.booleanValue();
    }

    public void gF(boolean z) {
        this.eGq = Boolean.valueOf(z);
    }

    public boolean bcT() {
        return this.eGr.booleanValue();
    }

    public void gG(boolean z) {
        this.eGr = Boolean.valueOf(z);
    }

    /* renamed from: d */
    protected c b(k kVar, r rVar, Kind kind, kotlin.reflect.jvm.internal.impl.name.f fVar, g gVar, ai aiVar) {
        if (kind == Kind.DECLARATION || kind == Kind.SYNTHESIZED) {
            c a = a((d) kVar, (c) rVar, kind, aiVar, gVar);
            a.gF(beF());
            a.gG(bcT());
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attempt at creating a constructor that is not a declaration: \ncopy from: ");
        stringBuilder.append(this);
        stringBuilder.append("\n");
        stringBuilder.append("newOwner: ");
        stringBuilder.append(kVar);
        stringBuilder.append("\n");
        stringBuilder.append("kind: ");
        stringBuilder.append(kind);
        throw new IllegalStateException(stringBuilder.toString());
    }

    protected c a(d dVar, c cVar, Kind kind, ai aiVar, g gVar) {
        return new c(dVar, cVar, gVar, this.eCo, kind, aiVar);
    }

    /* renamed from: b */
    public c a(w wVar, List<i> list, w wVar2) {
        c d = b(bdj(), null, bcW(), null, bbQ(), bbR());
        c cVar = d;
        w wVar3 = wVar;
        w wVar4 = wVar2;
        cVar.a(wVar3, bcP(), getTypeParameters(), h.a(list, bcS(), d), wVar4, bbG(), bbJ());
        return d;
    }
}
