package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.reflect.jvm.internal.impl.builtins.h;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.incremental.components.c;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.f;
import kotlin.reflect.jvm.internal.impl.load.java.components.g;
import kotlin.reflect.jvm.internal.impl.load.java.components.j;
import kotlin.reflect.jvm.internal.impl.load.java.components.k;
import kotlin.reflect.jvm.internal.impl.load.kotlin.e;
import kotlin.reflect.jvm.internal.impl.load.kotlin.m;
import kotlin.reflect.jvm.internal.impl.load.kotlin.t;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;

/* compiled from: context.kt */
public final class b {
    private final al eCn;
    private final k eGA;
    private final l eGB;
    private final g eGC;
    private final f eGD;
    private final j eGE;
    private final kotlin.reflect.jvm.internal.impl.load.java.a.b eGF;
    private final j eGG;
    private final t eGH;
    private final c eGI;
    private final h eGJ;
    private final AnnotationTypeQualifierResolver eGK;
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j eGL;
    private final kotlin.reflect.jvm.internal.impl.load.java.h eGM;
    private final c eGN;
    private final kotlin.reflect.jvm.internal.impl.load.java.g eGx;
    private final m eGy;
    private final e eGz;
    private final kotlin.reflect.jvm.internal.impl.storage.h exB;
    private final u ezG;

    public b(kotlin.reflect.jvm.internal.impl.storage.h hVar, kotlin.reflect.jvm.internal.impl.load.java.g gVar, m mVar, e eVar, k kVar, l lVar, g gVar2, f fVar, j jVar, kotlin.reflect.jvm.internal.impl.load.java.a.b bVar, j jVar2, t tVar, al alVar, c cVar, u uVar, h hVar2, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j jVar3, kotlin.reflect.jvm.internal.impl.load.java.h hVar3, c cVar2) {
        kotlin.reflect.jvm.internal.impl.storage.h hVar4 = hVar;
        kotlin.reflect.jvm.internal.impl.load.java.g gVar3 = gVar;
        m mVar2 = mVar;
        e eVar2 = eVar;
        k kVar2 = kVar;
        l lVar2 = lVar;
        g gVar4 = gVar2;
        f fVar2 = fVar;
        j jVar4 = jVar;
        kotlin.reflect.jvm.internal.impl.load.java.a.b bVar2 = bVar;
        j jVar5 = jVar2;
        t tVar2 = tVar;
        al alVar2 = alVar;
        c cVar3 = cVar;
        u uVar2 = uVar;
        h hVar5 = hVar2;
        kotlin.jvm.internal.h.e(hVar4, "storageManager");
        kotlin.jvm.internal.h.e(gVar3, "finder");
        kotlin.jvm.internal.h.e(mVar2, "kotlinClassFinder");
        kotlin.jvm.internal.h.e(eVar2, "deserializedDescriptorResolver");
        kotlin.jvm.internal.h.e(kVar2, "signaturePropagator");
        kotlin.jvm.internal.h.e(lVar2, "errorReporter");
        kotlin.jvm.internal.h.e(gVar4, "javaResolverCache");
        kotlin.jvm.internal.h.e(fVar2, "javaPropertyInitializerEvaluator");
        kotlin.jvm.internal.h.e(jVar4, "samConversionResolver");
        kotlin.jvm.internal.h.e(bVar2, "sourceElementFactory");
        kotlin.jvm.internal.h.e(jVar5, "moduleClassResolver");
        kotlin.jvm.internal.h.e(tVar2, "packagePartProvider");
        kotlin.jvm.internal.h.e(alVar2, "supertypeLoopChecker");
        kotlin.jvm.internal.h.e(cVar3, "lookupTracker");
        kotlin.jvm.internal.h.e(uVar2, "module");
        kotlin.jvm.internal.h.e(hVar2, "reflectionTypes");
        kotlin.jvm.internal.h.e(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        kotlin.jvm.internal.h.e(jVar3, "signatureEnhancement");
        kotlin.jvm.internal.h.e(hVar3, "javaClassesTracker");
        kotlin.jvm.internal.h.e(cVar2, "settings");
        h hVar6 = hVar2;
        this.exB = hVar4;
        this.eGx = gVar3;
        this.eGy = mVar2;
        this.eGz = eVar2;
        this.eGA = kVar2;
        this.eGB = lVar2;
        this.eGC = gVar4;
        this.eGD = fVar2;
        this.eGE = jVar4;
        this.eGF = bVar2;
        this.eGG = jVar5;
        this.eGH = tVar2;
        this.eCn = alVar2;
        this.eGI = cVar3;
        this.ezG = uVar;
        this.eGJ = hVar6;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j jVar6 = jVar3;
        this.eGK = annotationTypeQualifierResolver;
        this.eGL = jVar6;
        c cVar4 = cVar2;
        this.eGM = hVar3;
        this.eGN = cVar4;
    }

    public final kotlin.reflect.jvm.internal.impl.storage.h baI() {
        return this.exB;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.g bfV() {
        return this.eGx;
    }

    public final m bfW() {
        return this.eGy;
    }

    public final e bfX() {
        return this.eGz;
    }

    public final k bfY() {
        return this.eGA;
    }

    public final l bfZ() {
        return this.eGB;
    }

    public final g bga() {
        return this.eGC;
    }

    public final f bgb() {
        return this.eGD;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.a.b bgc() {
        return this.eGF;
    }

    public final j bgd() {
        return this.eGG;
    }

    public final t bge() {
        return this.eGH;
    }

    public final al bbZ() {
        return this.eCn;
    }

    public final c bgf() {
        return this.eGI;
    }

    public final u bar() {
        return this.ezG;
    }

    public final h bgg() {
        return this.eGJ;
    }

    public final AnnotationTypeQualifierResolver bgh() {
        return this.eGK;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j bgi() {
        return this.eGL;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.h bgj() {
        return this.eGM;
    }

    public final c bgk() {
        return this.eGN;
    }

    public final b a(g gVar) {
        g gVar2 = gVar;
        kotlin.jvm.internal.h.e(gVar2, "javaResolverCache");
        kotlin.reflect.jvm.internal.impl.storage.h hVar = this.exB;
        kotlin.reflect.jvm.internal.impl.load.java.g gVar3 = this.eGx;
        m mVar = this.eGy;
        e eVar = this.eGz;
        k kVar = this.eGA;
        l lVar = this.eGB;
        f fVar = this.eGD;
        j jVar = this.eGE;
        kotlin.reflect.jvm.internal.impl.load.java.a.b bVar = this.eGF;
        j jVar2 = this.eGG;
        t tVar = this.eGH;
        al alVar = this.eCn;
        al alVar2 = alVar;
        return new b(hVar, gVar3, mVar, eVar, kVar, lVar, gVar2, fVar, jVar, bVar, jVar2, tVar, alVar2, this.eGI, this.ezG, this.eGJ, this.eGK, this.eGL, this.eGM, this.eGN);
    }
}
