package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.k;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.resolve.constants.i;
import kotlin.reflect.jvm.internal.impl.storage.c;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import kotlin.reflect.jvm.internal.impl.utils.e;

/* compiled from: AnnotationTypeQualifierResolver.kt */
public final class AnnotationTypeQualifierResolver {
    private final boolean disabled = this.eEw.getDisabled();
    private final c<d, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> eEv;
    private final e eEw;

    /* compiled from: AnnotationTypeQualifierResolver.kt */
    public enum QualifierApplicabilityType {
        METHOD_RETURN_TYPE,
        VALUE_PARAMETER,
        FIELD,
        TYPE_USE
    }

    /* compiled from: AnnotationTypeQualifierResolver.kt */
    public static final class a {
        private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c eEx;
        private final int eEy;

        public a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, int i) {
            h.e(cVar, "typeQualifier");
            this.eEx = cVar;
            this.eEy = i;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c beh() {
            return this.eEx;
        }

        public final List<QualifierApplicabilityType> bdz() {
            QualifierApplicabilityType[] values = QualifierApplicabilityType.values();
            Collection arrayList = new ArrayList();
            for (QualifierApplicabilityType qualifierApplicabilityType : values) {
                if (a(qualifierApplicabilityType)) {
                    arrayList.add(qualifierApplicabilityType);
                }
            }
            return (List) arrayList;
        }

        private final boolean a(QualifierApplicabilityType qualifierApplicabilityType) {
            return b(QualifierApplicabilityType.TYPE_USE) || b(qualifierApplicabilityType);
        }

        private final boolean b(QualifierApplicabilityType qualifierApplicabilityType) {
            return ((1 << qualifierApplicabilityType.ordinal()) & this.eEy) != 0;
        }
    }

    public AnnotationTypeQualifierResolver(kotlin.reflect.jvm.internal.impl.storage.h hVar, e eVar) {
        h.e(hVar, "storageManager");
        h.e(eVar, "jsr305State");
        this.eEw = eVar;
        this.eEv = hVar.p(new AnnotationTypeQualifierResolver$resolvedNicknames$1(this));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c t(d dVar) {
        if (!dVar.bbQ().k(a.eEz)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c c;
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c c2 : dVar.bbQ()) {
            c2 = c(c2);
            if (c2 != null) {
                break;
            }
        }
        c2 = null;
        return c2;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c u(d dVar) {
        if (dVar.bbF() != ClassKind.ANNOTATION_CLASS) {
            return null;
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) this.eEv.invoke(dVar);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c c(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        h.e(cVar, "annotationDescriptor");
        if (this.eEw.getDisabled()) {
            return null;
        }
        d l = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(cVar);
        if (l == null) {
            return null;
        }
        if (a.x(l)) {
            return cVar;
        }
        return u(l);
    }

    public final k d(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        h.e(cVar, "annotationDescriptor");
        if (this.eEw.getDisabled()) {
            return null;
        }
        k kVar = (k) a.eED.get(cVar.bdD());
        if (kVar == null) {
            return (k) null;
        }
        f bgt = kVar.bgt();
        Collection bgu = kVar.bgu();
        ReportLevel f = f(cVar);
        if ((f != ReportLevel.IGNORE ? 1 : null) == null) {
            f = null;
        }
        if (f != null) {
            return new k(f.a(bgt, null, f.isWarning(), 1, null), bgu);
        }
        return null;
    }

    public final a e(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        h.e(cVar, "annotationDescriptor");
        if (this.eEw.getDisabled()) {
            return null;
        }
        d l = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(cVar);
        if (l != null) {
            if (!l.bbQ().k(a.eEB)) {
                l = null;
            }
            if (l != null) {
                d l2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(cVar);
                if (l2 == null) {
                    h.aXZ();
                }
                cVar = l2.bbQ().j(a.eEB);
                if (cVar == null) {
                    h.aXZ();
                }
                Collection arrayList = new ArrayList();
                for (Entry entry : cVar.bee().entrySet()) {
                    List a;
                    kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) entry.getKey();
                    kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2 = (kotlin.reflect.jvm.internal.impl.resolve.constants.f) entry.getValue();
                    if (h.E(fVar, m.eFm)) {
                        a = a(fVar2);
                    } else {
                        a = m.emptyList();
                    }
                    r.a(arrayList, (Iterable) a);
                }
                int i = 0;
                for (QualifierApplicabilityType ordinal : (List) arrayList) {
                    i |= 1 << ordinal.ordinal();
                }
                for (Object next : l.bbQ()) {
                    Object obj;
                    if (c((kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) next) != null) {
                        obj = 1;
                        continue;
                    } else {
                        obj = null;
                        continue;
                    }
                    if (obj != null) {
                        break;
                    }
                }
                Object next2 = null;
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) next2;
                if (cVar2 != null) {
                    return new a(cVar2, i);
                }
                return null;
            }
        }
        return null;
    }

    public final ReportLevel f(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        h.e(cVar, "annotationDescriptor");
        ReportLevel g = g(cVar);
        if (g != null) {
            return g;
        }
        return this.eEw.bzB();
    }

    public final ReportLevel g(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        h.e(cVar, "annotationDescriptor");
        Map bzD = this.eEw.bzD();
        b bdD = cVar.bdD();
        ReportLevel reportLevel = null;
        ReportLevel reportLevel2 = (ReportLevel) bzD.get(bdD != null ? bdD.asString() : null);
        if (reportLevel2 != null) {
            return reportLevel2;
        }
        d l = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(cVar);
        if (l != null) {
            reportLevel = v(l);
        }
        return reportLevel;
    }

    private final ReportLevel v(d dVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c j = dVar.bbQ().j(a.eEC);
        ReportLevel reportLevel = null;
        kotlin.reflect.jvm.internal.impl.resolve.constants.f m = j != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.m(j) : null;
        if (!(m instanceof i)) {
            m = null;
        }
        i iVar = (i) m;
        if (iVar == null) {
            return null;
        }
        ReportLevel bzC = this.eEw.bzC();
        if (bzC != null) {
            return bzC;
        }
        String asString = iVar.bwF().asString();
        int hashCode = asString.hashCode();
        if (hashCode != -2137067054) {
            if (hashCode != -1838656823) {
                if (hashCode == 2656902 && asString.equals("WARN")) {
                    reportLevel = ReportLevel.WARN;
                }
            } else if (asString.equals("STRICT")) {
                reportLevel = ReportLevel.STRICT;
            }
        } else if (asString.equals("IGNORE")) {
            reportLevel = ReportLevel.IGNORE;
        }
        return reportLevel;
    }

    private final List<QualifierApplicabilityType> a(kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> fVar) {
        if (fVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) {
            Collection arrayList = new ArrayList();
            for (kotlin.reflect.jvm.internal.impl.resolve.constants.f a : (Iterable) ((kotlin.reflect.jvm.internal.impl.resolve.constants.b) fVar).getValue()) {
                r.a(arrayList, (Iterable) a(a));
            }
            return (List) arrayList;
        } else if (!(fVar instanceof i)) {
            return m.emptyList();
        } else {
            Object obj;
            String identifier = ((i) fVar).bwF().getIdentifier();
            int hashCode = identifier.hashCode();
            if (hashCode != -2024225567) {
                if (hashCode != 66889946) {
                    if (hashCode != 107598562) {
                        if (hashCode == 446088073 && identifier.equals("PARAMETER")) {
                            obj = QualifierApplicabilityType.VALUE_PARAMETER;
                            return m.cs(obj);
                        }
                    } else if (identifier.equals("TYPE_USE")) {
                        obj = QualifierApplicabilityType.TYPE_USE;
                        return m.cs(obj);
                    }
                } else if (identifier.equals("FIELD")) {
                    obj = QualifierApplicabilityType.FIELD;
                    return m.cs(obj);
                }
            } else if (identifier.equals("METHOD")) {
                obj = QualifierApplicabilityType.METHOD_RETURN_TYPE;
                return m.cs(obj);
            }
            obj = null;
            return m.cs(obj);
        }
    }

    public final boolean getDisabled() {
        return this.disabled;
    }
}
