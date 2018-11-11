package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.a.i;
import kotlin.reflect.jvm.internal.impl.metadata.a.i.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.protobuf.n;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.o;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: MemberDeserializer.kt */
public final class p {
    private final b eJs = new b(this.eTh.biq().bxu(), this.eTh.biq().bxB());
    private final j eTh;

    private final int lU(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    public p(j jVar) {
        h.e(jVar, "c");
        this.eTh = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0295  */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ad h(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property r37) {
        /*
        r36 = this;
        r6 = r36;
        r5 = r37;
        r0 = "proto";
        kotlin.jvm.internal.h.e(r5, r0);
        r0 = r37.bjR();
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r0 = r37.getFlags();
    L_0x0013:
        r4 = r0;
        goto L_0x001e;
    L_0x0015:
        r0 = r37.bmE();
        r0 = r6.lU(r0);
        goto L_0x0013;
    L_0x001e:
        r3 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j;
        r0 = r6.eTh;
        r8 = r0.bbv();
        r9 = 0;
        r2 = r5;
        r2 = (kotlin.reflect.jvm.internal.impl.protobuf.n) r2;
        r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY;
        r10 = r6.a(r2, r4, r0);
        r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.s.eTk;
        r1 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLj;
        r1 = r1.get(r4);
        r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality) r1;
        r11 = r0.a(r1);
        r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.s.eTk;
        r1 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLi;
        r1 = r1.get(r4);
        r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility) r1;
        r12 = r0.a(r1);
        r0 = "ProtoEnumFlags.visibilit…gs.VISIBILITY.get(flags))";
        kotlin.jvm.internal.h.d(r12, r0);
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLz;
        r0 = r0.get(r4);
        r1 = "Flags.IS_VAR.get(flags)";
        kotlin.jvm.internal.h.d(r0, r1);
        r13 = r0.booleanValue();
        r0 = r6.eTh;
        r0 = r0.aYI();
        r1 = r37.blW();
        r14 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.q.b(r0, r1);
        r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.s.eTk;
        r1 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLr;
        r1 = r1.get(r4);
        r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind) r1;
        r15 = r0.a(r1);
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLD;
        r0 = r0.get(r4);
        r1 = "Flags.IS_LATEINIT.get(flags)";
        kotlin.jvm.internal.h.d(r0, r1);
        r16 = r0.booleanValue();
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLC;
        r0 = r0.get(r4);
        r1 = "Flags.IS_CONST.get(flags)";
        kotlin.jvm.internal.h.d(r0, r1);
        r17 = r0.booleanValue();
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLF;
        r0 = r0.get(r4);
        r1 = "Flags.IS_EXTERNAL_PROPERTY.get(flags)";
        kotlin.jvm.internal.h.d(r0, r1);
        r18 = r0.booleanValue();
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLG;
        r0 = r0.get(r4);
        r1 = "Flags.IS_DELEGATED.get(flags)";
        kotlin.jvm.internal.h.d(r0, r1);
        r19 = r0.booleanValue();
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLH;
        r0 = r0.get(r4);
        r1 = "Flags.IS_EXPECT_PROPERTY.get(flags)";
        kotlin.jvm.internal.h.d(r0, r1);
        r20 = r0.booleanValue();
        r0 = r6.eTh;
        r22 = r0.aYI();
        r0 = r6.eTh;
        r23 = r0.aYJ();
        r0 = r6.eTh;
        r24 = r0.bxK();
        r0 = r6.eTh;
        r25 = r0.bxL();
        r7 = r3;
        r21 = r5;
        r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        r0 = r6.eTh;
        r27 = r3;
        r27 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r27;
        r1 = r37.bkn();
        r7 = "proto.typeParameterList";
        kotlin.jvm.internal.h.d(r1, r7);
        r29 = 0;
        r30 = 0;
        r31 = 0;
        r32 = 0;
        r33 = 60;
        r34 = 0;
        r26 = r0;
        r28 = r1;
        r15 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.j.a(r26, r27, r28, r29, r30, r31, r32, r33, r34);
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLA;
        r7 = r0.get(r4);
        r0 = "hasGetter";
        kotlin.jvm.internal.h.d(r7, r0);
        r0 = r7.booleanValue();
        if (r0 == 0) goto L_0x0133;
    L_0x0119:
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.g.f(r37);
        if (r0 == 0) goto L_0x0133;
    L_0x011f:
        r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER;
        r9 = 0;
        r10 = 4;
        r11 = 0;
        r0 = r6;
        r1 = r2;
        r14 = r2;
        r2 = r8;
        r13 = r3;
        r3 = r9;
        r12 = r4;
        r4 = r10;
        r10 = r5;
        r5 = r11;
        r0 = a(r0, r1, r2, r3, r4, r5);
        goto L_0x013d;
    L_0x0133:
        r14 = r2;
        r13 = r3;
        r12 = r4;
        r10 = r5;
        r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF;
        r0 = r0.bel();
    L_0x013d:
        r1 = r15.bxI();
        r2 = r6.eTh;
        r2 = r2.aYJ();
        r2 = kotlin.reflect.jvm.internal.impl.metadata.a.g.a(r10, r2);
        r3 = 2;
        r4 = 0;
        r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.v.a(r1, r2, r4, r3, r4);
        r2 = r15.bxI();
        r2 = r2.bxQ();
        r3 = r36.bcP();
        r5 = r6.eTh;
        r5 = r5.aYJ();
        r5 = kotlin.reflect.jvm.internal.impl.metadata.a.g.b(r10, r5);
        if (r5 == 0) goto L_0x0172;
    L_0x0169:
        r8 = r15.bxI();
        r0 = r8.a(r5, r0);
        goto L_0x0173;
    L_0x0172:
        r0 = r4;
    L_0x0173:
        r13.a(r1, r2, r3, r0);
        r0 = r7.booleanValue();
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0225;
    L_0x017e:
        r0 = r37.bnm();
        r3 = r37.bnl();
        if (r3 == 0) goto L_0x019b;
    L_0x0188:
        r3 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLL;
        r3 = r3.get(r0);
        r5 = "Flags.IS_NOT_DEFAULT.get(getterFlags)";
        kotlin.jvm.internal.h.d(r3, r5);
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x019b;
    L_0x0199:
        r3 = 1;
        goto L_0x019c;
    L_0x019b:
        r3 = 0;
    L_0x019c:
        r5 = r37.bnl();
        if (r5 == 0) goto L_0x01b6;
    L_0x01a2:
        r5 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLM;
        r5 = r5.get(r0);
        r7 = "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)";
        kotlin.jvm.internal.h.d(r5, r7);
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x01b6;
    L_0x01b3:
        r22 = 1;
        goto L_0x01b8;
    L_0x01b6:
        r22 = 0;
    L_0x01b8:
        r5 = r37.bnl();
        if (r5 == 0) goto L_0x01d2;
    L_0x01be:
        r5 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLN;
        r5 = r5.get(r0);
        r7 = "Flags.IS_INLINE_ACCESSOR.get(getterFlags)";
        kotlin.jvm.internal.h.d(r5, r7);
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x01d2;
    L_0x01cf:
        r23 = 1;
        goto L_0x01d4;
    L_0x01d2:
        r23 = 0;
    L_0x01d4:
        r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER;
        r5 = r6.a(r14, r0, r5);
        if (r3 == 0) goto L_0x0211;
    L_0x01dc:
        r7 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.z;
        r17 = r13;
        r17 = (kotlin.reflect.jvm.internal.impl.descriptors.ad) r17;
        r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.s.eTk;
        r9 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLj;
        r9 = r9.get(r0);
        r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality) r9;
        r19 = r8.a(r9);
        r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.s.eTk;
        r9 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLi;
        r0 = r9.get(r0);
        r0 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility) r0;
        r20 = r8.a(r0);
        r21 = r3 ^ 1;
        r24 = r13.bcW();
        r25 = 0;
        r26 = kotlin.reflect.jvm.internal.impl.descriptors.ai.eAX;
        r16 = r7;
        r18 = r5;
        r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        r0 = r7;
        goto L_0x021d;
    L_0x0211:
        r3 = r13;
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ad) r3;
        r0 = kotlin.reflect.jvm.internal.impl.resolve.b.b(r3, r5);
        r3 = "DescriptorFactory.create…er(property, annotations)";
        kotlin.jvm.internal.h.d(r0, r3);
    L_0x021d:
        r3 = r13.bcQ();
        r0.T(r3);
        goto L_0x0226;
    L_0x0225:
        r0 = r4;
    L_0x0226:
        r3 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLB;
        r3 = r3.get(r12);
        r5 = "Flags.HAS_SETTER.get(flags)";
        kotlin.jvm.internal.h.d(r3, r5);
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x031a;
    L_0x0237:
        r3 = r37.bno();
        r4 = r37.bnn();
        if (r4 == 0) goto L_0x0254;
    L_0x0241:
        r4 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLL;
        r4 = r4.get(r3);
        r5 = "Flags.IS_NOT_DEFAULT.get(setterFlags)";
        kotlin.jvm.internal.h.d(r4, r5);
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x0254;
    L_0x0252:
        r4 = 1;
        goto L_0x0255;
    L_0x0254:
        r4 = 0;
    L_0x0255:
        r5 = r37.bnn();
        if (r5 == 0) goto L_0x026f;
    L_0x025b:
        r5 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLM;
        r5 = r5.get(r3);
        r7 = "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)";
        kotlin.jvm.internal.h.d(r5, r7);
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x026f;
    L_0x026c:
        r22 = 1;
        goto L_0x0271;
    L_0x026f:
        r22 = 0;
    L_0x0271:
        r5 = r37.bnl();
        if (r5 == 0) goto L_0x028b;
    L_0x0277:
        r5 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLN;
        r5 = r5.get(r3);
        r7 = "Flags.IS_INLINE_ACCESSOR.get(setterFlags)";
        kotlin.jvm.internal.h.d(r5, r7);
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x028b;
    L_0x0288:
        r23 = 1;
        goto L_0x028d;
    L_0x028b:
        r23 = 0;
    L_0x028d:
        r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER;
        r1 = r6.a(r14, r3, r1);
        if (r4 == 0) goto L_0x0305;
    L_0x0295:
        r5 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.aa;
        r17 = r13;
        r17 = (kotlin.reflect.jvm.internal.impl.descriptors.ad) r17;
        r7 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.s.eTk;
        r8 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLj;
        r8 = r8.get(r3);
        r8 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality) r8;
        r19 = r7.a(r8);
        r7 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.s.eTk;
        r8 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLi;
        r3 = r8.get(r3);
        r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility) r3;
        r20 = r7.a(r3);
        r21 = r4 ^ 1;
        r24 = r13.bcW();
        r25 = 0;
        r26 = kotlin.reflect.jvm.internal.impl.descriptors.ai.eAX;
        r16 = r5;
        r18 = r1;
        r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        r8 = r5;
        r8 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r8;
        r9 = kotlin.collections.m.emptyList();
        r1 = 0;
        r11 = 0;
        r2 = 0;
        r3 = 0;
        r4 = 60;
        r16 = 0;
        r7 = r15;
        r10 = r1;
        r1 = r12;
        r12 = r2;
        r2 = r13;
        r13 = r3;
        r3 = r14;
        r14 = r4;
        r4 = r15;
        r15 = r16;
        r7 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.j.a(r7, r8, r9, r10, r11, r12, r13, r14, r15);
        r7 = r7.bxJ();
        r8 = r37.bnk();
        r8 = kotlin.collections.l.cr(r8);
        r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER;
        r3 = r7.a(r8, r3, r9);
        r3 = kotlin.collections.u.bY(r3);
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.aq) r3;
        r5.c(r3);
        r3 = r1;
        r1 = r4;
        r4 = r5;
        goto L_0x031d;
    L_0x0305:
        r3 = r12;
        r2 = r13;
        r4 = r15;
        r5 = r2;
        r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ad) r5;
        r1 = kotlin.reflect.jvm.internal.impl.resolve.b.a(r5, r1);
        r5 = "DescriptorFactory.create…er(property, annotations)";
        kotlin.jvm.internal.h.d(r1, r5);
        r35 = r4;
        r4 = r1;
        r1 = r35;
        goto L_0x031d;
    L_0x031a:
        r3 = r12;
        r2 = r13;
        r1 = r15;
    L_0x031d:
        r5 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLE;
        r3 = r5.get(r3);
        r5 = "Flags.HAS_CONSTANT.get(flags)";
        kotlin.jvm.internal.h.d(r3, r5);
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x0344;
    L_0x032e:
        r3 = r6.eTh;
        r3 = r3.baI();
        r5 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$loadProperty$2;
        r7 = r37;
        r5.<init>(r6, r7, r2);
        r5 = (kotlin.jvm.a.a) r5;
        r3 = r3.j(r5);
        r2.a(r3);
    L_0x0344:
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.af) r4;
        r3 = r2;
        r3 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) r3;
        r1 = r1.bxI();
        r1 = r6.a(r3, r1);
        r2.a(r0, r4, r1);
        r3 = r2;
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ad) r3;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.p.h(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property):kotlin.reflect.jvm.internal.impl.descriptors.ad");
    }

    private final boolean a(g gVar, v vVar) {
        for (an aYq : vVar.bxQ()) {
            aYq.aYq();
        }
        return vVar.bxR() && c(gVar);
    }

    private final boolean c(g gVar) {
        if (!this.eTh.biq().bxv().bxH()) {
            return false;
        }
        Object obj;
        Iterable<i> bxW = gVar.bxW();
        if (!((bxW instanceof Collection) && ((Collection) bxW).isEmpty())) {
            for (i iVar : bxW) {
                Object obj2;
                if (h.E(iVar.brf(), new b(1, 3, 0, 4, null)) && iVar.brg() == VersionKind.LANGUAGE_VERSION) {
                    obj2 = 1;
                    continue;
                } else {
                    obj2 = null;
                    continue;
                }
                if (obj2 != null) {
                    obj = null;
                    break;
                }
            }
        }
        obj = 1;
        if (obj != null) {
            return true;
        }
        return false;
    }

    public final ah h(Function function) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g a;
        Function function2 = function;
        h.e(function2, "proto");
        int flags = function.bjR() ? function.getFlags() : lU(function.bmE());
        n nVar = function2;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g a2 = a(nVar, flags, AnnotatedCallableKind.FUNCTION);
        if (kotlin.reflect.jvm.internal.impl.metadata.a.g.g(function)) {
            a = a(this, nVar, AnnotatedCallableKind.FUNCTION, null, 4, null);
        } else {
            a = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel();
        }
        n nVar2 = nVar;
        int i = flags;
        Function function3 = function2;
        k kVar = new k(this.eTh.bbv(), null, a2, q.b(this.eTh.aYI(), function.blW()), s.eTk.a((MemberKind) kotlin.reflect.jvm.internal.impl.metadata.a.b.eLr.get(flags)), function2, this.eTh.aYI(), this.eTh.aYJ(), this.eTh.bxK(), this.eTh.bxL(), null, 1024, null);
        j jVar = this.eTh;
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar2 = kVar;
        List bkn = function.bkn();
        h.d(bkn, "proto.typeParameterList");
        jVar = j.a(jVar, kVar2, bkn, null, null, null, null, 60, null);
        Type b = kotlin.reflect.jvm.internal.impl.metadata.a.g.b(function3, this.eTh.aYJ());
        w a3 = b != null ? jVar.bxI().a(b, a) : null;
        ag bcP = bcP();
        List bxQ = jVar.bxI().bxQ();
        p bxJ = jVar.bxJ();
        bkn = function.blf();
        h.d(bkn, "proto.valueParameterList");
        List a4 = bxJ.a(bkn, nVar2, AnnotatedCallableKind.FUNCTION);
        w a5 = v.a(jVar.bxI(), kotlin.reflect.jvm.internal.impl.metadata.a.g.a(function3, this.eTh.aYJ()), null, 2, null);
        Modality a6 = s.eTk.a((ProtoBuf.Modality) kotlin.reflect.jvm.internal.impl.metadata.a.b.eLj.get(i));
        av a7 = s.eTk.a((Visibility) kotlin.reflect.jvm.internal.impl.metadata.a.b.eLi.get(i));
        h.d(a7, "ProtoEnumFlags.visibilit…gs.VISIBILITY.get(flags))");
        Map emptyMap = ad.emptyMap();
        Boolean lc = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLx.get(i);
        h.d(lc, "Flags.IS_SUSPEND.get(flags)");
        boolean z = (lc.booleanValue() && c(kVar)) || a((g) kVar, jVar.bxI());
        kVar.a(a3, bcP, bxQ, a4, a5, a6, a7, emptyMap, z);
        Boolean lc2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLs.get(i);
        h.d(lc2, "Flags.IS_OPERATOR.get(flags)");
        kVar.gv(lc2.booleanValue());
        lc2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLt.get(i);
        h.d(lc2, "Flags.IS_INFIX.get(flags)");
        kVar.gw(lc2.booleanValue());
        lc2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLw.get(i);
        h.d(lc2, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
        kVar.gx(lc2.booleanValue());
        lc2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLu.get(i);
        h.d(lc2, "Flags.IS_INLINE.get(flags)");
        kVar.gy(lc2.booleanValue());
        lc2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLv.get(i);
        h.d(lc2, "Flags.IS_TAILREC.get(flags)");
        kVar.gz(lc2.booleanValue());
        lc2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLx.get(i);
        h.d(lc2, "Flags.IS_SUSPEND.get(flags)");
        kVar.gE(lc2.booleanValue());
        lc2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLy.get(i);
        h.d(lc2, "Flags.IS_EXPECT_FUNCTION.get(flags)");
        kVar.gA(lc2.booleanValue());
        Pair a8 = this.eTh.biq().bxC().a(function3, kVar, this.eTh.aYJ(), this.eTh.bxI());
        if (a8 != null) {
            kVar.a((r.b) a8.getFirst(), a8.aXF());
        }
        return kVar;
    }

    public final am g(TypeAlias typeAlias) {
        TypeAlias typeAlias2 = typeAlias;
        h.e(typeAlias2, "proto");
        List bpq = typeAlias.bpq();
        h.d(bpq, "proto.annotationList");
        Iterable<Annotation> iterable = bpq;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (Annotation annotation : iterable) {
            b bVar = this.eJs;
            h.d(annotation, "it");
            arrayList.add(bVar.c(annotation, this.eTh.aYI()));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.h hVar = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.h((List) arrayList);
        av a = s.eTk.a((Visibility) kotlin.reflect.jvm.internal.impl.metadata.a.b.eLi.get(typeAlias.getFlags()));
        kotlin.reflect.jvm.internal.impl.storage.h baI = this.eTh.baI();
        kotlin.reflect.jvm.internal.impl.descriptors.k bbv = this.eTh.bbv();
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar = hVar;
        f b = q.b(this.eTh.aYI(), typeAlias.blW());
        h.d(a, "visibility");
        l lVar = new l(baI, bbv, gVar, b, a, typeAlias2, this.eTh.aYI(), this.eTh.aYJ(), this.eTh.bxK(), this.eTh.bxL());
        j jVar = this.eTh;
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = lVar;
        bpq = typeAlias.bkn();
        h.d(bpq, "proto.typeParameterList");
        j a2 = j.a(jVar, kVar, bpq, null, null, null, null, 60, null);
        lVar.a(a2.bxI().bxQ(), v.b(a2.bxI(), kotlin.reflect.jvm.internal.impl.metadata.a.g.a(typeAlias2, this.eTh.aYJ()), null, 2, null), v.b(a2.bxI(), kotlin.reflect.jvm.internal.impl.metadata.a.g.b(typeAlias2, this.eTh.aYJ()), null, 2, null), a((g) lVar, a2.bxI()));
        return lVar;
    }

    private final ag bcP() {
        kotlin.reflect.jvm.internal.impl.descriptors.k bbv = this.eTh.bbv();
        if (!(bbv instanceof d)) {
            bbv = null;
        }
        d dVar = (d) bbv;
        return dVar != null ? dVar.bdh() : null;
    }

    /* JADX WARNING: Missing block: B:22:0x010a, code:
            if (c(r2) != false) goto L_0x010e;
     */
    public final kotlin.reflect.jvm.internal.impl.descriptors.c a(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor r32, boolean r33) {
        /*
        r31 = this;
        r0 = r31;
        r15 = r32;
        r1 = "proto";
        kotlin.jvm.internal.h.e(r15, r1);
        r1 = r0.eTh;
        r1 = r1.bbv();
        if (r1 != 0) goto L_0x0019;
    L_0x0011:
        r1 = new kotlin.TypeCastException;
        r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor";
        r1.<init>(r2);
        throw r1;
    L_0x0019:
        r14 = r1;
        r14 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r14;
        r13 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d;
        r3 = 0;
        r12 = r15;
        r12 = (kotlin.reflect.jvm.internal.impl.protobuf.n) r12;
        r1 = r32.getFlags();
        r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.FUNCTION;
        r4 = r0.a(r12, r1, r2);
        r6 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION;
        r1 = r0.eTh;
        r8 = r1.aYI();
        r1 = r0.eTh;
        r9 = r1.aYJ();
        r1 = r0.eTh;
        r10 = r1.bxK();
        r1 = r0.eTh;
        r11 = r1.bxL();
        r16 = 0;
        r17 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r18 = 0;
        r1 = r13;
        r2 = r14;
        r5 = r33;
        r7 = r15;
        r19 = r12;
        r12 = r16;
        r20 = r13;
        r13 = r17;
        r21 = r14;
        r14 = r18;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        r1 = r0.eTh;
        r2 = r20;
        r23 = r2;
        r23 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r23;
        r24 = kotlin.collections.m.emptyList();
        r25 = 0;
        r26 = 0;
        r27 = 0;
        r28 = 0;
        r29 = 60;
        r30 = 0;
        r22 = r1;
        r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.j.a(r22, r23, r24, r25, r26, r27, r28, r29, r30);
        r3 = r1.bxJ();
        r4 = r32.blf();
        r5 = "proto.valueParameterList";
        kotlin.jvm.internal.h.d(r4, r5);
        r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.FUNCTION;
        r6 = r19;
        r3 = r3.a(r4, r6, r5);
        r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.s.eTk;
        r5 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLi;
        r6 = r32.getFlags();
        r5 = r5.get(r6);
        r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility) r5;
        r4 = r4.a(r5);
        r2.a(r3, r4);
        r3 = r21;
        r3 = r3.bdb();
        r3 = (kotlin.reflect.jvm.internal.impl.types.w) r3;
        r2.Q(r3);
        r3 = r2.getTypeParameters();
        r4 = "descriptor.typeParameters";
        kotlin.jvm.internal.h.d(r3, r4);
        r3 = (java.lang.Iterable) r3;
        r3 = r3.iterator();
    L_0x00c2:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x00d7;
    L_0x00c8:
        r4 = r3.next();
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.an) r4;
        r5 = "it";
        kotlin.jvm.internal.h.d(r4, r5);
        r4.aYq();
        goto L_0x00c2;
    L_0x00d7:
        r1 = r1.bxI();
        r1 = r1.bxR();
        r3 = 1;
        if (r1 != 0) goto L_0x010e;
    L_0x00e2:
        r1 = r0.eTh;
        r1 = r1.bbv();
        r4 = r1 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e;
        if (r4 != 0) goto L_0x00ed;
    L_0x00ec:
        r1 = 0;
    L_0x00ed:
        r1 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e) r1;
        if (r1 == 0) goto L_0x010d;
    L_0x00f1:
        r1 = r1.bxX();
        if (r1 == 0) goto L_0x010d;
    L_0x00f7:
        r1 = r1.bxI();
        if (r1 == 0) goto L_0x010d;
    L_0x00fd:
        r1 = r1.bxR();
        if (r1 != r3) goto L_0x010d;
    L_0x0103:
        r13 = r2;
        r13 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) r13;
        r1 = r0.c(r13);
        if (r1 == 0) goto L_0x010d;
    L_0x010c:
        goto L_0x010e;
    L_0x010d:
        r3 = 0;
    L_0x010e:
        r2.hc(r3);
        r13 = r2;
        r13 = (kotlin.reflect.jvm.internal.impl.descriptors.c) r13;
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.p.a(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor, boolean):kotlin.reflect.jvm.internal.impl.descriptors.c");
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g a(n nVar, int i, AnnotatedCallableKind annotatedCallableKind) {
        if (kotlin.reflect.jvm.internal.impl.metadata.a.b.eLh.get(i).booleanValue()) {
            return new o(this.eTh.baI(), new MemberDeserializer$getAnnotations$1(this, nVar, annotatedCallableKind));
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel();
    }

    static /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.g a(p pVar, n nVar, AnnotatedCallableKind annotatedCallableKind, AnnotatedCallableKind annotatedCallableKind2, int i, Object obj) {
        if ((i & 4) != 0) {
            annotatedCallableKind2 = annotatedCallableKind;
        }
        return pVar.a(nVar, annotatedCallableKind, annotatedCallableKind2);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g a(n nVar, AnnotatedCallableKind annotatedCallableKind, AnnotatedCallableKind annotatedCallableKind2) {
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b(this.eTh.baI(), new MemberDeserializer$getReceiverParameterAnnotations$1(this, nVar, annotatedCallableKind2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f8  */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.aq> a(java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> r26, kotlin.reflect.jvm.internal.impl.protobuf.n r27, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r28) {
        /*
        r25 = this;
        r8 = r25;
        r0 = r8.eTh;
        r0 = r0.bbv();
        if (r0 != 0) goto L_0x0012;
    L_0x000a:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor";
        r0.<init>(r1);
        throw r0;
    L_0x0012:
        r15 = r0;
        r15 = (kotlin.reflect.jvm.internal.impl.descriptors.a) r15;
        r0 = r15.bbv();
        r1 = "callableDescriptor.containingDeclaration";
        kotlin.jvm.internal.h.d(r0, r1);
        r21 = r8.V(r0);
        r0 = r26;
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r2 = 10;
        r2 = kotlin.collections.n.e(r0, r2);
        r1.<init>(r2);
        r14 = r1;
        r14 = (java.util.Collection) r14;
        r13 = r0.iterator();
        r22 = 0;
        r12 = 0;
    L_0x003b:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x0127;
    L_0x0041:
        r0 = r13.next();
        r23 = r12 + 1;
        r9 = r0;
        r9 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r9;
        r0 = r9.bjR();
        if (r0 == 0) goto L_0x0056;
    L_0x0050:
        r0 = r9.getFlags();
        r10 = r0;
        goto L_0x0057;
    L_0x0056:
        r10 = 0;
    L_0x0057:
        if (r21 == 0) goto L_0x0091;
    L_0x0059:
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLh;
        r0 = r0.get(r10);
        r1 = "Flags.HAS_ANNOTATIONS.get(flags)";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0091;
    L_0x006a:
        r11 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n;
        r0 = r8.eTh;
        r7 = r0.baI();
        r16 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1;
        r0 = r16;
        r1 = r12;
        r2 = r9;
        r3 = r8;
        r4 = r21;
        r5 = r27;
        r6 = r28;
        r24 = r13;
        r13 = r7;
        r7 = r15;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = r16;
        r0 = (kotlin.jvm.a.a) r0;
        r11.<init>(r13, r0);
        r11 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) r11;
        r13 = r11;
        goto L_0x009a;
    L_0x0091:
        r24 = r13;
        r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF;
        r0 = r0.bel();
        r13 = r0;
    L_0x009a:
        r11 = 0;
        r0 = r8.eTh;
        r0 = r0.aYI();
        r1 = r9.blW();
        r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.q.b(r0, r1);
        r1 = r8.eTh;
        r1 = r1.bxI();
        r2 = r8.eTh;
        r2 = r2.aYJ();
        r2 = kotlin.reflect.jvm.internal.impl.metadata.a.g.a(r9, r2);
        r3 = 2;
        r4 = 0;
        r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.v.a(r1, r2, r4, r3, r4);
        r2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLI;
        r2 = r2.get(r10);
        r5 = "Flags.DECLARES_DEFAULT_VALUE.get(flags)";
        kotlin.jvm.internal.h.d(r2, r5);
        r16 = r2.booleanValue();
        r2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLJ;
        r2 = r2.get(r10);
        r5 = "Flags.IS_CROSSINLINE.get(flags)";
        kotlin.jvm.internal.h.d(r2, r5);
        r17 = r2.booleanValue();
        r2 = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLK;
        r2 = r2.get(r10);
        r5 = "Flags.IS_NOINLINE.get(flags)";
        kotlin.jvm.internal.h.d(r2, r5);
        r18 = r2.booleanValue();
        r2 = r8.eTh;
        r2 = r2.aYJ();
        r2 = kotlin.reflect.jvm.internal.impl.metadata.a.g.b(r9, r2);
        if (r2 == 0) goto L_0x0105;
    L_0x00f8:
        r5 = r8.eTh;
        r5 = r5.bxI();
        r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.v.a(r5, r2, r4, r3, r4);
        r19 = r2;
        goto L_0x0107;
    L_0x0105:
        r19 = r4;
    L_0x0107:
        r2 = kotlin.reflect.jvm.internal.impl.descriptors.ai.eAX;
        r3 = "SourceElement.NO_SOURCE";
        kotlin.jvm.internal.h.d(r2, r3);
        r3 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ah;
        r9 = r3;
        r10 = r15;
        r4 = r24;
        r5 = r14;
        r14 = r0;
        r0 = r15;
        r15 = r1;
        r20 = r2;
        r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        r5.add(r3);
        r15 = r0;
        r13 = r4;
        r14 = r5;
        r12 = r23;
        goto L_0x003b;
    L_0x0127:
        r5 = r14;
        r14 = r5;
        r14 = (java.util.List) r14;
        r14 = (java.lang.Iterable) r14;
        r0 = kotlin.collections.u.W(r14);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.p.a(java.util.List, kotlin.reflect.jvm.internal.impl.protobuf.n, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind):java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.aq>");
    }

    private final r V(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar instanceof x) {
            return new r.b(((x) kVar).bdD(), this.eTh.aYI(), this.eTh.aYJ(), this.eTh.bxL());
        }
        return kVar instanceof e ? ((e) kVar).bxY() : null;
    }
}
