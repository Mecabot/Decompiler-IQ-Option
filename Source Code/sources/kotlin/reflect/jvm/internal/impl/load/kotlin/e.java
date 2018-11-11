package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Set;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.j;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.n;

/* compiled from: DeserializedDescriptorResolver.kt */
public final class e {
    private static final Set<Kind> eJD = ai.cu(Kind.CLASS);
    private static final Set<Kind> eJE = aj.I(Kind.FILE_FACADE, Kind.MULTIFILE_CLASS_PART);
    private static final g eJF = new g(1, 1, 2);
    public static final a eJG = new a();
    public h eJC;

    /* compiled from: DeserializedDescriptorResolver.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final h biq() {
        h hVar = this.eJC;
        if (hVar == null) {
            kotlin.jvm.internal.h.lS("components");
        }
        return hVar;
    }

    public final void a(d dVar) {
        kotlin.jvm.internal.h.e(dVar, "components");
        this.eJC = dVar.biq();
    }

    private final boolean bir() {
        h hVar = this.eJC;
        if (hVar == null) {
            kotlin.jvm.internal.h.lS("components");
        }
        return hVar.bxv().bir();
    }

    public final d e(n nVar) {
        kotlin.jvm.internal.h.e(nVar, "kotlinClass");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.d f = f(nVar);
        if (f == null) {
            return null;
        }
        h hVar = this.eJC;
        if (hVar == null) {
            kotlin.jvm.internal.h.lS("components");
        }
        return hVar.bxt().a(nVar.getClassId(), f);
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.d f(n nVar) {
        kotlin.jvm.internal.h.e(nVar, "kotlinClass");
        String[] a = a(nVar, eJD);
        if (a == null) {
            return null;
        }
        String[] biQ = nVar.bap().biQ();
        if (biQ == null) {
            return null;
        }
        Pair a2;
        try {
            a2 = j.a(a, biQ);
        } catch (InvalidProtocolBufferException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not read data from ");
            stringBuilder.append(nVar.getLocation());
            throw new IllegalStateException(stringBuilder.toString(), e);
        } catch (Throwable th) {
            if (!bir() && !nVar.bap().biN().btC()) {
                a2 = null;
            }
        }
        if (a2 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h hVar = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h) a2.aXG();
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.d(hVar, (Class) a2.aXH(), nVar.bap().biN(), new p(nVar, g(nVar), h(nVar)));
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h a(x xVar, n nVar) {
        kotlin.jvm.internal.h.e(xVar, "descriptor");
        kotlin.jvm.internal.h.e(nVar, "kotlinClass");
        String[] a = a(nVar, eJE);
        if (a == null) {
            return null;
        }
        String[] biQ = nVar.bap().biQ();
        if (biQ == null) {
            return null;
        }
        Pair b;
        try {
            b = j.b(a, biQ);
        } catch (InvalidProtocolBufferException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not read data from ");
            stringBuilder.append(nVar.getLocation());
            throw new IllegalStateException(stringBuilder.toString(), e);
        } catch (Throwable th) {
            if (!bir() && !nVar.bap().biN().btC()) {
                b = null;
            }
        }
        if (b == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h hVar = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h) b.aXG();
        Package packageR = (Package) b.aXH();
        c cVar = hVar;
        kotlin.reflect.jvm.internal.impl.metadata.a.a biN = nVar.bap().biN();
        f iVar = new i(nVar, packageR, cVar, g(nVar), h(nVar));
        h hVar2 = this.eJC;
        if (hVar2 == null) {
            kotlin.jvm.internal.h.lS("components");
        }
        return new i(xVar, packageR, cVar, biN, iVar, hVar2, DeserializedDescriptorResolver$createKotlinPackagePartScope$2.eJH);
    }

    private final n<g> g(n nVar) {
        return (bir() || nVar.bap().biN().btC()) ? null : new n(nVar.bap().biN(), g.eMH, nVar.getLocation(), nVar.getClassId());
    }

    private final boolean h(n nVar) {
        h hVar = this.eJC;
        if (hVar == null) {
            kotlin.jvm.internal.h.lS("components");
        }
        return hVar.bxv().bxE() && (nVar.bap().biL() || kotlin.jvm.internal.h.E(nVar.bap().biN(), eJF));
    }

    public final String[] a(n nVar, Set<? extends Kind> set) {
        kotlin.jvm.internal.h.e(nVar, "kotlinClass");
        kotlin.jvm.internal.h.e(set, "expectedKinds");
        KotlinClassHeader bap = nVar.bap();
        String[] biO = bap.biO();
        if (biO == null) {
            biO = bap.biP();
        }
        return (biO == null || !set.contains(bap.biM())) ? null : biO;
    }
}
