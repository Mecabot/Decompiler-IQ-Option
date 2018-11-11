package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.i;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.f;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.d;
import kotlin.reflect.jvm.internal.impl.load.java.n;
import kotlin.reflect.jvm.internal.impl.load.java.r;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import kotlin.reflect.jvm.internal.impl.utils.e;

/* compiled from: signatureEnhancement.kt */
public final class j {
    private final e eEw;
    private final AnnotationTypeQualifierResolver eGK;

    /* compiled from: signatureEnhancement.kt */
    private static class a {
        private final boolean eIO;
        private final w ewu;

        public a(w wVar, boolean z) {
            h.e(wVar, Param.TYPE);
            this.ewu = wVar;
            this.eIO = z;
        }

        public final w bai() {
            return this.ewu;
        }

        public final boolean bih() {
            return this.eIO;
        }
    }

    /* compiled from: signatureEnhancement.kt */
    private final class b {
        private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.a eIP;
        private final w eIQ;
        private final Collection<w> eIR;
        private final boolean eIS;
        private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h eIT;
        private final QualifierApplicabilityType eIU;
        final /* synthetic */ j eIV;

        public b(j jVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, w wVar, Collection<? extends w> collection, boolean z, kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, QualifierApplicabilityType qualifierApplicabilityType) {
            h.e(wVar, "fromOverride");
            h.e(collection, "fromOverridden");
            h.e(hVar, "containerContext");
            h.e(qualifierApplicabilityType, "containerApplicabilityType");
            this.eIV = jVar;
            this.eIP = aVar;
            this.eIQ = wVar;
            this.eIR = collection;
            this.eIS = z;
            this.eIT = hVar;
            this.eIU = qualifierApplicabilityType;
        }

        private final boolean bii() {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar = this.eIP;
            w wVar = null;
            if (!(aVar instanceof aq)) {
                aVar = null;
            }
            aq aqVar = (aq) aVar;
            if (aqVar != null) {
                wVar = aqVar.bdS();
            }
            return wVar != null;
        }

        public final a a(o oVar) {
            kotlin.jvm.a.b bij = bij();
            kotlin.jvm.a.b signatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1 = oVar != null ? new SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1(oVar, bij) : null;
            w wVar = this.eIQ;
            if (signatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1 == null) {
                signatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1 = bij;
            }
            w a = p.a(wVar, signatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1);
            if (a != null) {
                return new a(a, true);
            }
            return new a(this.eIQ, false);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d ad(kotlin.reflect.jvm.internal.impl.types.w r12) {
            /*
            r11 = this;
            r0 = kotlin.reflect.jvm.internal.impl.types.t.aB(r12);
            if (r0 == 0) goto L_0x0018;
        L_0x0006:
            r0 = kotlin.reflect.jvm.internal.impl.types.t.aC(r12);
            r1 = new kotlin.Pair;
            r2 = r0.byT();
            r0 = r0.byU();
            r1.<init>(r2, r0);
            goto L_0x001d;
        L_0x0018:
            r1 = new kotlin.Pair;
            r1.<init>(r12, r12);
        L_0x001d:
            r0 = r1.aXG();
            r0 = (kotlin.reflect.jvm.internal.impl.types.w) r0;
            r1 = r1.aXH();
            r1 = (kotlin.reflect.jvm.internal.impl.types.w) r1;
            r2 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.eAc;
            r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d;
            r3 = r0.aYp();
            r4 = 0;
            if (r3 == 0) goto L_0x0038;
        L_0x0034:
            r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
        L_0x0036:
            r5 = r3;
            goto L_0x0042;
        L_0x0038:
            r3 = r1.aYp();
            if (r3 != 0) goto L_0x0041;
        L_0x003e:
            r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL;
            goto L_0x0036;
        L_0x0041:
            r5 = r4;
        L_0x0042:
            r0 = r2.K(r0);
            if (r0 == 0) goto L_0x004b;
        L_0x0048:
            r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY;
            goto L_0x0055;
        L_0x004b:
            r0 = r2.J(r1);
            if (r0 == 0) goto L_0x0054;
        L_0x0051:
            r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE;
            goto L_0x0055;
        L_0x0054:
            r0 = r4;
        L_0x0055:
            r12 = r12.bzc();
            r6 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.e;
            r7 = 0;
            r8 = 8;
            r9 = 0;
            r3 = r10;
            r4 = r5;
            r5 = r0;
            r3.<init>(r4, r5, r6, r7, r8, r9);
            return r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.b.ad(kotlin.reflect.jvm.internal.impl.types.w):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d");
        }

        private final d a(w wVar, boolean z, d dVar) {
            g bbQ;
            if (!z || this.eIP == null) {
                bbQ = wVar.bbQ();
            } else {
                bbQ = i.a(this.eIP.bbQ(), wVar.bbQ());
            }
            SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1 signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1 = new SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1(bbQ);
            SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2 signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2 = SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2.eIW;
            NullabilityQualifier nullabilityQualifier = null;
            if (z) {
                d bgo = this.eIT.bgo();
                dVar = bgo != null ? bgo.c(this.eIU) : null;
            }
            f i = i(bbQ);
            if (i == null) {
                i = (dVar == null || dVar.bhQ() == null) ? null : new f(dVar.bhQ(), dVar.bhT());
            }
            NullabilityQualifier bhX = i != null ? i.bhX() : null;
            MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2.B(signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1.B(n.bfL(), MutabilityQualifier.READ_ONLY), signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1.B(n.bfM(), MutabilityQualifier.MUTABLE));
            if (i != null) {
                nullabilityQualifier = i.bhX();
            }
            boolean z2 = false;
            boolean z3 = nullabilityQualifier == NullabilityQualifier.NOT_NULL && kotlin.reflect.jvm.internal.impl.types.b.a.ba(wVar);
            if (i != null && i.bhY()) {
                z2 = true;
            }
            return new d(bhX, mutabilityQualifier, z3, z2);
        }

        private final f i(g gVar) {
            Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterable = gVar;
            j jVar = this.eIV;
            for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c i : iterable) {
                f i2 = jVar.i(i);
                if (i2 != null) {
                    return i2;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0079  */
        private final kotlin.jvm.a.b<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d> bij() {
            /*
            r14 = this;
            r0 = r14.eIR;
            r0 = (java.lang.Iterable) r0;
            r1 = new java.util.ArrayList;
            r2 = 10;
            r2 = kotlin.collections.n.e(r0, r2);
            r1.<init>(r2);
            r1 = (java.util.Collection) r1;
            r0 = r0.iterator();
        L_0x0015:
            r2 = r0.hasNext();
            if (r2 == 0) goto L_0x0029;
        L_0x001b:
            r2 = r0.next();
            r2 = (kotlin.reflect.jvm.internal.impl.types.w) r2;
            r2 = r14.ae(r2);
            r1.add(r2);
            goto L_0x0015;
        L_0x0029:
            r1 = (java.util.List) r1;
            r0 = r14.eIQ;
            r0 = r14.ae(r0);
            r2 = r14.eIS;
            r3 = 0;
            r4 = 1;
            if (r2 == 0) goto L_0x006a;
        L_0x0037:
            r2 = r14.eIR;
            r2 = (java.lang.Iterable) r2;
            r5 = r2 instanceof java.util.Collection;
            if (r5 == 0) goto L_0x004a;
        L_0x003f:
            r5 = r2;
            r5 = (java.util.Collection) r5;
            r5 = r5.isEmpty();
            if (r5 == 0) goto L_0x004a;
        L_0x0048:
            r2 = 0;
            goto L_0x0066;
        L_0x004a:
            r2 = r2.iterator();
        L_0x004e:
            r5 = r2.hasNext();
            if (r5 == 0) goto L_0x0048;
        L_0x0054:
            r5 = r2.next();
            r5 = (kotlin.reflect.jvm.internal.impl.types.w) r5;
            r6 = kotlin.reflect.jvm.internal.impl.types.checker.b.eVr;
            r7 = r14.eIQ;
            r5 = r6.d(r5, r7);
            r5 = r5 ^ r4;
            if (r5 == 0) goto L_0x004e;
        L_0x0065:
            r2 = 1;
        L_0x0066:
            if (r2 == 0) goto L_0x006a;
        L_0x0068:
            r2 = 1;
            goto L_0x006b;
        L_0x006a:
            r2 = 0;
        L_0x006b:
            if (r2 == 0) goto L_0x006f;
        L_0x006d:
            r5 = 1;
            goto L_0x0073;
        L_0x006f:
            r5 = r0.size();
        L_0x0073:
            r5 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d[r5];
            r6 = r5.length;
            r7 = 0;
        L_0x0077:
            if (r7 >= r6) goto L_0x00df;
        L_0x0079:
            if (r7 != 0) goto L_0x007d;
        L_0x007b:
            r8 = 1;
            goto L_0x007e;
        L_0x007d:
            r8 = 0;
        L_0x007e:
            if (r8 != 0) goto L_0x0085;
        L_0x0080:
            if (r2 != 0) goto L_0x0083;
        L_0x0082:
            goto L_0x0085;
        L_0x0083:
            r9 = 0;
            goto L_0x0086;
        L_0x0085:
            r9 = 1;
        L_0x0086:
            r10 = kotlin.m.etY;
            if (r10 == 0) goto L_0x0096;
        L_0x008a:
            if (r9 != 0) goto L_0x0096;
        L_0x008c:
            r0 = "Only head type constructors should be computed";
            r1 = new java.lang.AssertionError;
            r1.<init>(r0);
            r1 = (java.lang.Throwable) r1;
            throw r1;
        L_0x0096:
            r9 = r0.get(r7);
            r9 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.n) r9;
            r10 = r9.bil();
            r9 = r9.bim();
            r11 = r1;
            r11 = (java.lang.Iterable) r11;
            r12 = new java.util.ArrayList;
            r12.<init>();
            r12 = (java.util.Collection) r12;
            r11 = r11.iterator();
        L_0x00b2:
            r13 = r11.hasNext();
            if (r13 == 0) goto L_0x00d2;
        L_0x00b8:
            r13 = r11.next();
            r13 = (java.util.List) r13;
            r13 = kotlin.collections.u.h(r13, r7);
            r13 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.n) r13;
            if (r13 == 0) goto L_0x00cb;
        L_0x00c6:
            r13 = r13.bai();
            goto L_0x00cc;
        L_0x00cb:
            r13 = 0;
        L_0x00cc:
            if (r13 == 0) goto L_0x00b2;
        L_0x00ce:
            r12.add(r13);
            goto L_0x00b2;
        L_0x00d2:
            r12 = (java.util.List) r12;
            r12 = (java.util.Collection) r12;
            r8 = r14.a(r10, r12, r9, r8);
            r5[r7] = r8;
            r7 = r7 + 1;
            goto L_0x0077;
        L_0x00df:
            r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1;
            r0.<init>(r5);
            r0 = (kotlin.jvm.a.b) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.b.bij():kotlin.jvm.a.b<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d>");
        }

        private final List<n> ae(w wVar) {
            ArrayList arrayList = new ArrayList(1);
            new SignatureEnhancement$SignatureParts$toIndexed$1(arrayList).a(wVar, this.eIT);
            return arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:72:0x0149  */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d a(kotlin.reflect.jvm.internal.impl.types.w r11, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.w> r12, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d r13, boolean r14) {
            /*
            r10 = this;
            r12 = (java.lang.Iterable) r12;
            r0 = new java.util.ArrayList;
            r1 = 10;
            r1 = kotlin.collections.n.e(r12, r1);
            r0.<init>(r1);
            r0 = (java.util.Collection) r0;
            r1 = r12.iterator();
        L_0x0013:
            r2 = r1.hasNext();
            if (r2 == 0) goto L_0x0027;
        L_0x0019:
            r2 = r1.next();
            r2 = (kotlin.reflect.jvm.internal.impl.types.w) r2;
            r2 = r10.ad(r2);
            r0.add(r2);
            goto L_0x0013;
        L_0x0027:
            r0 = (java.util.List) r0;
            r0 = (java.lang.Iterable) r0;
            r1 = new java.util.ArrayList;
            r1.<init>();
            r1 = (java.util.Collection) r1;
            r2 = r0.iterator();
        L_0x0036:
            r3 = r2.hasNext();
            if (r3 == 0) goto L_0x004c;
        L_0x003c:
            r3 = r2.next();
            r3 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d) r3;
            r3 = r3.bhR();
            if (r3 == 0) goto L_0x0036;
        L_0x0048:
            r1.add(r3);
            goto L_0x0036;
        L_0x004c:
            r1 = (java.util.List) r1;
            r1 = (java.lang.Iterable) r1;
            r1 = kotlin.collections.u.Y(r1);
            r2 = new java.util.ArrayList;
            r2.<init>();
            r2 = (java.util.Collection) r2;
            r3 = r0.iterator();
        L_0x005f:
            r4 = r3.hasNext();
            if (r4 == 0) goto L_0x0075;
        L_0x0065:
            r4 = r3.next();
            r4 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d) r4;
            r4 = r4.bhQ();
            if (r4 == 0) goto L_0x005f;
        L_0x0071:
            r2.add(r4);
            goto L_0x005f;
        L_0x0075:
            r2 = (java.util.List) r2;
            r2 = (java.lang.Iterable) r2;
            r2 = kotlin.collections.u.Y(r2);
            r3 = new java.util.ArrayList;
            r3.<init>();
            r3 = (java.util.Collection) r3;
            r12 = r12.iterator();
        L_0x0088:
            r4 = r12.hasNext();
            if (r4 == 0) goto L_0x00a6;
        L_0x008e:
            r4 = r12.next();
            r4 = (kotlin.reflect.jvm.internal.impl.types.w) r4;
            r4 = kotlin.reflect.jvm.internal.impl.types.aw.bd(r4);
            r4 = r10.ad(r4);
            r4 = r4.bhQ();
            if (r4 == 0) goto L_0x0088;
        L_0x00a2:
            r3.add(r4);
            goto L_0x0088;
        L_0x00a6:
            r3 = (java.util.List) r3;
            r3 = (java.lang.Iterable) r3;
            r12 = kotlin.collections.u.Y(r3);
            r11 = r10.a(r11, r14, r13);
            r13 = r11.bhT();
            r3 = 1;
            r13 = r13 ^ r3;
            r4 = 0;
            if (r13 == 0) goto L_0x00bd;
        L_0x00bb:
            r13 = r11;
            goto L_0x00be;
        L_0x00bd:
            r13 = r4;
        L_0x00be:
            if (r13 == 0) goto L_0x00c5;
        L_0x00c0:
            r13 = r13.bhQ();
            goto L_0x00c6;
        L_0x00c5:
            r13 = r4;
        L_0x00c6:
            r5 = r11.bhQ();
            r6 = r10.eIS;
            r7 = 0;
            if (r6 == 0) goto L_0x00d3;
        L_0x00cf:
            if (r14 == 0) goto L_0x00d3;
        L_0x00d1:
            r6 = 1;
            goto L_0x00d4;
        L_0x00d3:
            r6 = 0;
        L_0x00d4:
            r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l.a(r2, r13, r6);
            if (r8 == 0) goto L_0x00ec;
        L_0x00da:
            r9 = r10.bii();
            if (r9 == 0) goto L_0x00e8;
        L_0x00e0:
            if (r14 == 0) goto L_0x00e8;
        L_0x00e2:
            r14 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
            if (r8 != r14) goto L_0x00e8;
        L_0x00e6:
            r14 = 1;
            goto L_0x00e9;
        L_0x00e8:
            r14 = 0;
        L_0x00e9:
            if (r14 != 0) goto L_0x00ec;
        L_0x00eb:
            r4 = r8;
        L_0x00ec:
            r14 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE;
            r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY;
            r9 = r11.bhR();
            r14 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l.a(r1, r14, r8, r9, r6);
            r14 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) r14;
            if (r5 != r13) goto L_0x0106;
        L_0x00fc:
            r13 = kotlin.jvm.internal.h.E(r12, r2);
            r13 = r13 ^ r3;
            if (r13 == 0) goto L_0x0104;
        L_0x0103:
            goto L_0x0106;
        L_0x0104:
            r13 = 0;
            goto L_0x0107;
        L_0x0106:
            r13 = 1;
        L_0x0107:
            r11 = r11.bhS();
            if (r11 != 0) goto L_0x0138;
        L_0x010d:
            r11 = r0 instanceof java.util.Collection;
            if (r11 == 0) goto L_0x011c;
        L_0x0111:
            r11 = r0;
            r11 = (java.util.Collection) r11;
            r11 = r11.isEmpty();
            if (r11 == 0) goto L_0x011c;
        L_0x011a:
            r11 = 0;
            goto L_0x0133;
        L_0x011c:
            r11 = r0.iterator();
        L_0x0120:
            r0 = r11.hasNext();
            if (r0 == 0) goto L_0x011a;
        L_0x0126:
            r0 = r11.next();
            r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d) r0;
            r0 = r0.bhS();
            if (r0 == 0) goto L_0x0120;
        L_0x0132:
            r11 = 1;
        L_0x0133:
            if (r11 == 0) goto L_0x0136;
        L_0x0135:
            goto L_0x0138;
        L_0x0136:
            r11 = 0;
            goto L_0x0139;
        L_0x0138:
            r11 = 1;
        L_0x0139:
            if (r4 != 0) goto L_0x0146;
        L_0x013b:
            if (r13 == 0) goto L_0x0146;
        L_0x013d:
            r12 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l.a(r12, r5, r6);
            r11 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l.a(r12, r14, r3, r11);
            return r11;
        L_0x0146:
            if (r4 != 0) goto L_0x0149;
        L_0x0148:
            goto L_0x014a;
        L_0x0149:
            r3 = 0;
        L_0x014a:
            r11 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l.a(r4, r14, r3, r11);
            return r11;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.b.a(kotlin.reflect.jvm.internal.impl.types.w, java.util.Collection, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d");
        }
    }

    /* compiled from: signatureEnhancement.kt */
    private static final class c extends a {
        private final boolean eGw;

        public final boolean bfT() {
            return this.eGw;
        }

        public c(w wVar, boolean z, boolean z2) {
            h.e(wVar, Param.TYPE);
            super(wVar, z2);
            this.eGw = z;
        }
    }

    public j(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, e eVar) {
        h.e(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        h.e(eVar, "jsr305State");
        this.eGK = annotationTypeQualifierResolver;
        this.eEw = eVar;
    }

    /* JADX WARNING: Missing block: B:20:0x0057, code:
            if (r6.equals("NEVER") != false) goto L_0x0062;
     */
    /* JADX WARNING: Missing block: B:22:0x0060, code:
            if (r6.equals("MAYBE") != false) goto L_0x0062;
     */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f h(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c r6) {
        /*
        r5 = this;
        r6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.m(r6);
        r0 = r6 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.i;
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        r6 = r1;
    L_0x000a:
        r6 = (kotlin.reflect.jvm.internal.impl.resolve.constants.i) r6;
        r0 = 2;
        r2 = 0;
        if (r6 == 0) goto L_0x006c;
    L_0x0010:
        r6 = r6.bwF();
        r6 = r6.asString();
        r3 = r6.hashCode();
        r4 = 73135176; // 0x45bf448 float:2.5855495E-36 double:3.6133578E-316;
        if (r3 == r4) goto L_0x005a;
    L_0x0021:
        r4 = 74175084; // 0x46bd26c float:2.7720738E-36 double:3.6647361E-316;
        if (r3 == r4) goto L_0x0051;
    L_0x0026:
        r4 = 433141802; // 0x19d1382a float:2.1632778E-23 double:2.14000484E-315;
        if (r3 == r4) goto L_0x0041;
    L_0x002b:
        r4 = 1933739535; // 0x7342860f float:1.5411753E31 double:9.553942722E-315;
        if (r3 == r4) goto L_0x0031;
    L_0x0030:
        goto L_0x006a;
    L_0x0031:
        r3 = "ALWAYS";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x006a;
    L_0x0039:
        r6 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f;
        r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL;
        r6.<init>(r3, r2, r0, r1);
        goto L_0x006b;
    L_0x0041:
        r3 = "UNKNOWN";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x006a;
    L_0x0049:
        r6 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f;
        r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY;
        r6.<init>(r3, r2, r0, r1);
        goto L_0x006b;
    L_0x0051:
        r3 = "NEVER";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x006a;
    L_0x0059:
        goto L_0x0062;
    L_0x005a:
        r3 = "MAYBE";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x006a;
    L_0x0062:
        r6 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f;
        r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE;
        r6.<init>(r3, r2, r0, r1);
        goto L_0x006b;
    L_0x006a:
        r6 = r1;
    L_0x006b:
        return r6;
    L_0x006c:
        r6 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f;
        r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL;
        r6.<init>(r3, r2, r0, r1);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.h(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f");
    }

    public final f i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        h.e(cVar, "annotationDescriptor");
        f j = j(cVar);
        if (j != null) {
            return j;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c c = this.eGK.c(cVar);
        f fVar = null;
        if (c == null) {
            return null;
        }
        ReportLevel f = this.eGK.f(cVar);
        if (f.isIgnore()) {
            return null;
        }
        j = j(c);
        if (j != null) {
            fVar = f.a(j, null, f.isWarning(), 1, null);
        }
        return fVar;
    }

    private final f j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.reflect.jvm.internal.impl.name.b bdD = cVar.bdD();
        f fVar = null;
        if (bdD == null) {
            return null;
        }
        f fVar2;
        if (n.bfD().contains(bdD)) {
            fVar2 = new f(NullabilityQualifier.NULLABLE, false, 2, null);
        } else if (n.bfG().contains(bdD)) {
            fVar2 = new f(NullabilityQualifier.NOT_NULL, false, 2, null);
        } else {
            if (h.E(bdD, n.bfE())) {
                fVar = h(cVar);
            } else if (h.E(bdD, n.bfH()) && this.eEw.bzE()) {
                fVar2 = new f(NullabilityQualifier.NULLABLE, false, 2, null);
            } else if (h.E(bdD, n.bfI()) && this.eEw.bzE()) {
                fVar2 = new f(NullabilityQualifier.NOT_NULL, false, 2, null);
            } else if (h.E(bdD, n.bfK())) {
                fVar = new f(NullabilityQualifier.NOT_NULL, true);
            } else if (h.E(bdD, n.bfJ())) {
                fVar = new f(NullabilityQualifier.NULLABLE, true);
            }
            fVar2 = fVar;
        }
        return fVar2;
    }

    public final <D extends CallableMemberDescriptor> Collection<D> a(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, Collection<? extends D> collection) {
        h.e(hVar, "c");
        h.e(collection, "platformSignatures");
        Iterable<CallableMemberDescriptor> iterable = collection;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (CallableMemberDescriptor a : iterable) {
            arrayList.add(a(a, hVar));
        }
        return (List) arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0210 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0230 A:{LOOP_END, LOOP:2: B:111:0x022a->B:113:0x0230} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0210 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0230 A:{LOOP_END, LOOP:2: B:111:0x022a->B:113:0x0230} */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x025b  */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D a(D r18, kotlin.reflect.jvm.internal.impl.load.java.lazy.h r19) {
        /*
        r17 = this;
        r7 = r17;
        r8 = r18;
        r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.b;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r8;
    L_0x0009:
        r9 = r8;
        r9 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.b) r9;
        r0 = r9.bcW();
        r1 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
        r10 = 1;
        if (r0 != r1) goto L_0x0029;
    L_0x0015:
        r0 = r9.bcV();
        r1 = "original";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = r0.bcU();
        r0 = r0.size();
        if (r0 != r10) goto L_0x0029;
    L_0x0028:
        return r8;
    L_0x0029:
        r0 = r18.bbQ();
        r1 = r19;
        r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.b(r1, r0);
        r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.e;
        if (r0 == 0) goto L_0x0057;
    L_0x0037:
        r0 = r8;
        r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.e) r0;
        r1 = r0.bfa();
        if (r1 == 0) goto L_0x0057;
    L_0x0040:
        r1 = r1.isDefault();
        if (r1 != 0) goto L_0x0057;
    L_0x0046:
        r0 = r0.bfa();
        if (r0 != 0) goto L_0x004f;
    L_0x004c:
        kotlin.jvm.internal.h.aXZ();
    L_0x004f:
        r1 = "getter!!";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0;
        goto L_0x0058;
    L_0x0057:
        r0 = r8;
    L_0x0058:
        r1 = r9.bcO();
        r11 = 0;
        if (r1 == 0) goto L_0x0082;
    L_0x005f:
        r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.r;
        if (r1 != 0) goto L_0x0065;
    L_0x0063:
        r1 = r11;
        goto L_0x0066;
    L_0x0065:
        r1 = r0;
    L_0x0066:
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r1;
        if (r1 == 0) goto L_0x0073;
    L_0x006a:
        r2 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.eGs;
        r1 = r1.a(r2);
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.aq) r1;
        goto L_0x0074;
    L_0x0073:
        r1 = r11;
    L_0x0074:
        r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1.eIX;
        r2 = (kotlin.jvm.a.b) r2;
        r1 = r7.a(r8, r1, r4, r2);
        r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.b.a(r1, r11, r10, r11);
        r12 = r1;
        goto L_0x0083;
    L_0x0082:
        r12 = r11;
    L_0x0083:
        r1 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
        if (r1 != 0) goto L_0x0089;
    L_0x0087:
        r1 = r11;
        goto L_0x008a;
    L_0x0089:
        r1 = r8;
    L_0x008a:
        r1 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) r1;
        r13 = 0;
        if (r1 == 0) goto L_0x00ba;
    L_0x008f:
        r2 = kotlin.reflect.jvm.internal.impl.load.kotlin.u.eJX;
        r3 = r1.bbv();
        if (r3 != 0) goto L_0x009f;
    L_0x0097:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor";
        r0.<init>(r1);
        throw r0;
    L_0x009f:
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r3;
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r1;
        r5 = 3;
        r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(r1, r13, r13, r5, r11);
        r1 = r2.a(r3, r1);
        if (r1 == 0) goto L_0x00ba;
    L_0x00ae:
        r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.g.bhZ();
        r1 = r2.get(r1);
        r1 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.h) r1;
        r14 = r1;
        goto L_0x00bb;
    L_0x00ba:
        r14 = r11;
    L_0x00bb:
        if (r14 == 0) goto L_0x0116;
    L_0x00bd:
        r1 = r14.bie();
        r1 = r1.size();
        r2 = r9.bcS();
        r2 = r2.size();
        if (r1 != r2) goto L_0x00d1;
    L_0x00cf:
        r1 = 1;
        goto L_0x00d2;
    L_0x00d1:
        r1 = 0;
    L_0x00d2:
        r2 = kotlin.m.etY;
        if (r2 == 0) goto L_0x0116;
    L_0x00d6:
        if (r1 != 0) goto L_0x0116;
    L_0x00d8:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Predefined enhancement info for ";
        r0.append(r1);
        r0.append(r8);
        r1 = " has ";
        r0.append(r1);
        r1 = r14.bie();
        r1 = r1.size();
        r0.append(r1);
        r1 = ", but ";
        r0.append(r1);
        r1 = r9.bcS();
        r1 = r1.size();
        r0.append(r1);
        r1 = " expected";
        r0.append(r1);
        r0 = r0.toString();
        r1 = new java.lang.AssertionError;
        r1.<init>(r0);
        r1 = (java.lang.Throwable) r1;
        throw r1;
    L_0x0116:
        r1 = r0.bcS();
        r2 = "annotationOwnerForMember.valueParameters";
        kotlin.jvm.internal.h.d(r1, r2);
        r1 = (java.lang.Iterable) r1;
        r2 = new java.util.ArrayList;
        r15 = 10;
        r3 = kotlin.collections.n.e(r1, r15);
        r2.<init>(r3);
        r2 = (java.util.Collection) r2;
        r1 = r1.iterator();
    L_0x0132:
        r3 = r1.hasNext();
        if (r3 == 0) goto L_0x01a2;
    L_0x0138:
        r3 = r1.next();
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.aq) r3;
        r5 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1;
        r5.<init>(r3);
        r5 = (kotlin.jvm.a.b) r5;
        r5 = r7.a(r8, r3, r4, r5);
        if (r14 == 0) goto L_0x015d;
    L_0x014b:
        r6 = r14.bie();
        if (r6 == 0) goto L_0x015d;
    L_0x0151:
        r11 = r3.getIndex();
        r6 = kotlin.collections.u.h(r6, r11);
        r11 = r6;
        r11 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.o) r11;
        goto L_0x015e;
    L_0x015d:
        r11 = 0;
    L_0x015e:
        r5 = r5.a(r11);
        r6 = r5.bih();
        if (r6 == 0) goto L_0x016d;
    L_0x0168:
        r6 = r5.bai();
        goto L_0x017b;
    L_0x016d:
        r6 = "p";
        kotlin.jvm.internal.h.d(r3, r6);
        r6 = r3.bai();
        r11 = "p.type";
        kotlin.jvm.internal.h.d(r6, r11);
    L_0x017b:
        r11 = "p";
        kotlin.jvm.internal.h.d(r3, r11);
        r6 = r7.a(r3, r6);
        r11 = r5.bih();
        if (r11 != 0) goto L_0x0193;
    L_0x018a:
        r3 = r3.bdR();
        if (r6 == r3) goto L_0x0191;
    L_0x0190:
        goto L_0x0193;
    L_0x0191:
        r3 = 0;
        goto L_0x0194;
    L_0x0193:
        r3 = 1;
    L_0x0194:
        r11 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j$c;
        r5 = r5.bai();
        r11.<init>(r5, r6, r3);
        r2.add(r11);
        r11 = 0;
        goto L_0x0132;
    L_0x01a2:
        r11 = r2;
        r11 = (java.util.List) r11;
        r2 = r0;
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) r2;
        r3 = 1;
        r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ad;
        if (r0 != 0) goto L_0x01af;
    L_0x01ad:
        r0 = 0;
        goto L_0x01b0;
    L_0x01af:
        r0 = r8;
    L_0x01b0:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ad) r0;
        if (r0 == 0) goto L_0x01bd;
    L_0x01b4:
        r0 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.f(r0);
        if (r0 != r10) goto L_0x01bd;
    L_0x01ba:
        r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType.FIELD;
        goto L_0x01bf;
    L_0x01bd:
        r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType.METHOD_RETURN_TYPE;
    L_0x01bf:
        r5 = r0;
        r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.eIY;
        r6 = r0;
        r6 = (kotlin.jvm.a.b) r6;
        r0 = r7;
        r1 = r8;
        r0 = r0.a(r1, r2, r3, r4, r5, r6);
        if (r14 == 0) goto L_0x01d2;
    L_0x01cd:
        r1 = r14.bid();
        goto L_0x01d3;
    L_0x01d2:
        r1 = 0;
    L_0x01d3:
        r0 = r0.a(r1);
        if (r12 == 0) goto L_0x01df;
    L_0x01d9:
        r1 = r12.bih();
        if (r1 == r10) goto L_0x0211;
    L_0x01df:
        r1 = r0.bih();
        if (r1 != 0) goto L_0x0211;
    L_0x01e5:
        r1 = r11;
        r1 = (java.lang.Iterable) r1;
        r2 = r1 instanceof java.util.Collection;
        if (r2 == 0) goto L_0x01f6;
    L_0x01ec:
        r2 = r1;
        r2 = (java.util.Collection) r2;
        r2 = r2.isEmpty();
        if (r2 == 0) goto L_0x01f6;
    L_0x01f5:
        goto L_0x020d;
    L_0x01f6:
        r1 = r1.iterator();
    L_0x01fa:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x020d;
    L_0x0200:
        r2 = r1.next();
        r2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.c) r2;
        r2 = r2.bih();
        if (r2 == 0) goto L_0x01fa;
    L_0x020c:
        r13 = 1;
    L_0x020d:
        if (r13 == 0) goto L_0x0210;
    L_0x020f:
        goto L_0x0211;
    L_0x0210:
        return r8;
    L_0x0211:
        if (r12 == 0) goto L_0x0218;
    L_0x0213:
        r1 = r12.bai();
        goto L_0x0219;
    L_0x0218:
        r1 = 0;
    L_0x0219:
        r11 = (java.lang.Iterable) r11;
        r2 = new java.util.ArrayList;
        r3 = kotlin.collections.n.e(r11, r15);
        r2.<init>(r3);
        r2 = (java.util.Collection) r2;
        r3 = r11.iterator();
    L_0x022a:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0247;
    L_0x0230:
        r4 = r3.next();
        r4 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.c) r4;
        r5 = new kotlin.reflect.jvm.internal.impl.load.java.descriptors.i;
        r6 = r4.bai();
        r4 = r4.bfT();
        r5.<init>(r6, r4);
        r2.add(r5);
        goto L_0x022a;
    L_0x0247:
        r2 = (java.util.List) r2;
        r0 = r0.bai();
        r0 = r9.a(r1, r2, r0);
        if (r0 != 0) goto L_0x025b;
    L_0x0253:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type D";
        r0.<init>(r1);
        throw r0;
    L_0x025b:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j.a(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.h):D");
    }

    private final boolean a(aq aqVar, w wVar) {
        boolean z;
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.a d = kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.d(aqVar);
        if (d instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.g) {
            z = r.a(wVar, ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.g) d).getValue()) != null;
        } else if (h.E(d, f.eGv)) {
            z = au.aX(wVar);
        } else if (d == null) {
            z = aqVar.bdR();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (z && aqVar.bcU().isEmpty()) {
            return true;
        }
        return false;
    }

    private final b a(CallableMemberDescriptor callableMemberDescriptor, aq aqVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, kotlin.jvm.a.b<? super CallableMemberDescriptor, ? extends w> bVar) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar2;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar = aqVar;
        if (aqVar != null) {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.h b = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.b(hVar, aqVar.bbQ());
            if (b != null) {
                hVar2 = b;
                return a(callableMemberDescriptor, aVar, false, hVar2, QualifierApplicabilityType.VALUE_PARAMETER, bVar);
            }
        }
        hVar2 = hVar;
        return a(callableMemberDescriptor, aVar, false, hVar2, QualifierApplicabilityType.VALUE_PARAMETER, bVar);
    }

    private final b a(CallableMemberDescriptor callableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z, kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, QualifierApplicabilityType qualifierApplicabilityType, kotlin.jvm.a.b<? super CallableMemberDescriptor, ? extends w> bVar) {
        w wVar = (w) bVar.invoke(callableMemberDescriptor);
        Collection bcU = callableMemberDescriptor.bcU();
        h.d(bcU, "this.overriddenDescriptors");
        Iterable<CallableMemberDescriptor> iterable = bcU;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (CallableMemberDescriptor callableMemberDescriptor2 : iterable) {
            h.d(callableMemberDescriptor2, "it");
            arrayList.add((w) bVar.invoke(callableMemberDescriptor2));
        }
        return new b(this, aVar, wVar, (List) arrayList, z, kotlin.reflect.jvm.internal.impl.load.java.lazy.a.b(hVar, ((w) bVar.invoke(callableMemberDescriptor)).bbQ()), qualifierApplicabilityType);
    }
}
