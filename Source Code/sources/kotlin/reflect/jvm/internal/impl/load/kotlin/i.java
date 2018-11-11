package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.aj;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.n;

/* compiled from: JvmPackagePartSource.kt */
public final class i implements f {
    private final b eJM;
    private final b eJN;
    private final n<g> eJO;
    private final boolean eJP;
    private final n eJQ;
    private final String euv;

    /* JADX WARNING: Missing block: B:3:0x0037, code:
            if (r2 != null) goto L_0x003c;
     */
    public i(kotlin.reflect.jvm.internal.impl.resolve.jvm.b r2, kotlin.reflect.jvm.internal.impl.resolve.jvm.b r3, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r4, kotlin.reflect.jvm.internal.impl.metadata.a.c r5, kotlin.reflect.jvm.internal.impl.serialization.deserialization.n<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g> r6, boolean r7, kotlin.reflect.jvm.internal.impl.load.kotlin.n r8) {
        /*
        r1 = this;
        r0 = "className";
        kotlin.jvm.internal.h.e(r2, r0);
        r0 = "packageProto";
        kotlin.jvm.internal.h.e(r4, r0);
        r0 = "nameResolver";
        kotlin.jvm.internal.h.e(r5, r0);
        r1.<init>();
        r1.eJM = r2;
        r1.eJN = r3;
        r1.eJO = r6;
        r1.eJP = r7;
        r1.eJQ = r8;
        r4 = (kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage) r4;
        r2 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.eMt;
        r3 = "JvmProtoBuf.packageModuleName";
        kotlin.jvm.internal.h.d(r2, r3);
        r2 = kotlin.reflect.jvm.internal.impl.metadata.a.f.a(r4, r2);
        r2 = (java.lang.Integer) r2;
        if (r2 == 0) goto L_0x003a;
    L_0x002d:
        r2 = (java.lang.Number) r2;
        r2 = r2.intValue();
        r2 = r5.getString(r2);
        if (r2 == 0) goto L_0x003a;
    L_0x0039:
        goto L_0x003c;
    L_0x003a:
        r2 = "main";
    L_0x003c:
        r1.euv = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.i.<init>(kotlin.reflect.jvm.internal.impl.resolve.jvm.b, kotlin.reflect.jvm.internal.impl.resolve.jvm.b, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.a.c, kotlin.reflect.jvm.internal.impl.serialization.deserialization.n, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.n):void");
    }

    public final b biv() {
        return this.eJM;
    }

    public final b biw() {
        return this.eJN;
    }

    public final n bix() {
        return this.eJQ;
    }

    public i(n nVar, Package packageR, c cVar, n<g> nVar2, boolean z) {
        h.e(nVar, "kotlinClass");
        h.e(packageR, "packageProto");
        h.e(cVar, "nameResolver");
        b j = b.j(nVar.getClassId());
        h.d(j, "JvmClassName.byClassId(kotlinClass.classId)");
        String biJ = nVar.bap().biJ();
        b bVar = null;
        if (biJ != null) {
            if ((((CharSequence) biJ).length() > 0 ? 1 : null) != null) {
                bVar = b.mR(biJ);
            }
        }
        b bVar2 = bVar;
        this(j, bVar2, packageR, cVar, nVar2, z, nVar);
    }

    public final kotlin.reflect.jvm.internal.impl.name.f biu() {
        String internalName = this.eJM.getInternalName();
        h.d(internalName, "className.internalName");
        kotlin.reflect.jvm.internal.impl.name.f mD = kotlin.reflect.jvm.internal.impl.name.f.mD(v.c(internalName, '/', null, 2, null));
        h.d(mD, "Name.identifier(classNam….substringAfterLast('/'))");
        return mD;
    }

    public final a getClassId() {
        return new a(this.eJM.getPackageFqName(), biu());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.eJM);
        return stringBuilder.toString();
    }

    public aj ban() {
        aj ajVar = aj.eAY;
        h.d(ajVar, "SourceFile.NO_SOURCE_FILE");
        return ajVar;
    }
}
