package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.a.h;

/* compiled from: ProtoContainer.kt */
public abstract class r {
    private final ai eBw;
    private final c evp;
    private final h evq;

    /* compiled from: ProtoContainer.kt */
    public static final class a extends r {
        private final kotlin.reflect.jvm.internal.impl.name.a classId;
        private final boolean eAT;
        private final Class eSB;
        private final Kind eTi;
        private final a eTj;

        public final a bxP() {
            return this.eTj;
        }

        public a(Class classR, c cVar, h hVar, ai aiVar, a aVar) {
            kotlin.jvm.internal.h.e(classR, "classProto");
            kotlin.jvm.internal.h.e(cVar, "nameResolver");
            kotlin.jvm.internal.h.e(hVar, "typeTable");
            super(cVar, hVar, aiVar, null);
            this.eSB = classR;
            this.eTj = aVar;
            this.classId = q.a(cVar, this.eSB.bkk());
            Kind kind = (Kind) kotlin.reflect.jvm.internal.impl.metadata.a.b.eLk.get(this.eSB.getFlags());
            if (kind == null) {
                kind = Kind.CLASS;
            }
            this.eTi = kind;
            Boolean lc = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLl.get(this.eSB.getFlags());
            kotlin.jvm.internal.h.d(lc, "Flags.IS_INNER.get(classProto.flags)");
            this.eAT = lc.booleanValue();
        }

        public final kotlin.reflect.jvm.internal.impl.name.a getClassId() {
            return this.classId;
        }

        public final Kind bxO() {
            return this.eTi;
        }

        public final boolean bbL() {
            return this.eAT;
        }

        public kotlin.reflect.jvm.internal.impl.name.b bxN() {
            kotlin.reflect.jvm.internal.impl.name.b btK = this.classId.btK();
            kotlin.jvm.internal.h.d(btK, "classId.asSingleFqName()");
            return btK;
        }
    }

    /* compiled from: ProtoContainer.kt */
    public static final class b extends r {
        private final kotlin.reflect.jvm.internal.impl.name.b eBM;

        public b(kotlin.reflect.jvm.internal.impl.name.b bVar, c cVar, h hVar, ai aiVar) {
            kotlin.jvm.internal.h.e(bVar, "fqName");
            kotlin.jvm.internal.h.e(cVar, "nameResolver");
            kotlin.jvm.internal.h.e(hVar, "typeTable");
            super(cVar, hVar, aiVar, null);
            this.eBM = bVar;
        }

        public kotlin.reflect.jvm.internal.impl.name.b bxN() {
            return this.eBM;
        }
    }

    public abstract kotlin.reflect.jvm.internal.impl.name.b bxN();

    private r(c cVar, h hVar, ai aiVar) {
        this.evp = cVar;
        this.evq = hVar;
        this.eBw = aiVar;
    }

    public /* synthetic */ r(c cVar, h hVar, ai aiVar, f fVar) {
        this(cVar, hVar, aiVar);
    }

    public final c aYI() {
        return this.evp;
    }

    public final h aYJ() {
        return this.evq;
    }

    public final ai bbR() {
        return this.eBw;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(bxN());
        return stringBuilder.toString();
    }
}
