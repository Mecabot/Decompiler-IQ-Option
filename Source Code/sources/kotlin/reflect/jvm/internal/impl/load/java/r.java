package kotlin.reflect.jvm.internal.impl.load.java;

/* compiled from: utils.kt */
public final class r {
    /* JADX WARNING: Missing block: B:37:0x00bf, code:
            if (kotlin.reflect.jvm.internal.impl.builtins.g.H(r4) != false) goto L_0x00c3;
     */
    public static final kotlin.reflect.jvm.internal.impl.load.java.i a(kotlin.reflect.jvm.internal.impl.types.w r4, java.lang.String r5) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r4, r0);
        r0 = "value";
        kotlin.jvm.internal.h.e(r5, r0);
        r0 = r4.bwA();
        r0 = r0.bbW();
        r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d;
        r2 = 0;
        if (r1 == 0) goto L_0x004d;
    L_0x0017:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r0;
        r1 = r0.bbF();
        r3 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS;
        if (r1 != r3) goto L_0x004d;
    L_0x0021:
        r4 = r0.bdg();
        r5 = kotlin.reflect.jvm.internal.impl.name.f.mD(r5);
        r0 = "Name.identifier(value)";
        kotlin.jvm.internal.h.d(r5, r0);
        r0 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BACKEND;
        r0 = (kotlin.reflect.jvm.internal.impl.incremental.components.b) r0;
        r4 = r4.c(r5, r0);
        r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d;
        if (r5 == 0) goto L_0x004c;
    L_0x003a:
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r4;
        r5 = r4.bbF();
        r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY;
        if (r5 != r0) goto L_0x004c;
    L_0x0044:
        r5 = new kotlin.reflect.jvm.internal.impl.load.java.e;
        r5.<init>(r4);
        r2 = r5;
        r2 = (kotlin.reflect.jvm.internal.impl.load.java.i) r2;
    L_0x004c:
        return r2;
    L_0x004d:
        r4 = kotlin.reflect.jvm.internal.impl.types.b.a.aU(r4);
        r0 = kotlin.reflect.jvm.internal.impl.utils.g.nc(r5);
        r1 = r0.component1();
        r0 = r0.bbt();
        r3 = kotlin.reflect.jvm.internal.impl.builtins.g.r(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r3 == 0) goto L_0x006c;
    L_0x0063:
        r4 = java.lang.Boolean.parseBoolean(r5);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        r5 = java.lang.Boolean.valueOf(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        goto L_0x00c3;
    L_0x006c:
        r3 = kotlin.reflect.jvm.internal.impl.builtins.g.s(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r3 == 0) goto L_0x0079;
    L_0x0072:
        r5 = (java.lang.CharSequence) r5;	 Catch:{ IllegalArgumentException -> 0x00c2 }
        r5 = kotlin.text.x.S(r5);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        goto L_0x00c3;
    L_0x0079:
        r3 = kotlin.reflect.jvm.internal.impl.builtins.g.u(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r3 == 0) goto L_0x0084;
    L_0x007f:
        r5 = kotlin.text.t.X(r1, r0);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        goto L_0x00c3;
    L_0x0084:
        r3 = kotlin.reflect.jvm.internal.impl.builtins.g.w(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r3 == 0) goto L_0x008f;
    L_0x008a:
        r5 = kotlin.text.t.Y(r1, r0);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        goto L_0x00c3;
    L_0x008f:
        r3 = kotlin.reflect.jvm.internal.impl.builtins.g.t(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r3 == 0) goto L_0x009a;
    L_0x0095:
        r5 = kotlin.text.t.Z(r1, r0);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        goto L_0x00c3;
    L_0x009a:
        r3 = kotlin.reflect.jvm.internal.impl.builtins.g.v(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r3 == 0) goto L_0x00a5;
    L_0x00a0:
        r5 = kotlin.text.t.aa(r1, r0);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        goto L_0x00c3;
    L_0x00a5:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.g.x(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00ab:
        r5 = kotlin.text.s.nd(r5);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        goto L_0x00c3;
    L_0x00b0:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.g.z(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r0 == 0) goto L_0x00bb;
    L_0x00b6:
        r5 = kotlin.text.s.ne(r5);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        goto L_0x00c3;
    L_0x00bb:
        r4 = kotlin.reflect.jvm.internal.impl.builtins.g.H(r4);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r4 == 0) goto L_0x00c2;
    L_0x00c1:
        goto L_0x00c3;
    L_0x00c2:
        r5 = r2;
    L_0x00c3:
        if (r5 == 0) goto L_0x00cd;
    L_0x00c5:
        r4 = new kotlin.reflect.jvm.internal.impl.load.java.d;
        r4.<init>(r5);
        r2 = r4;
        r2 = (kotlin.reflect.jvm.internal.impl.load.java.i) r2;
    L_0x00cd:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.r.a(kotlin.reflect.jvm.internal.impl.types.w, java.lang.String):kotlin.reflect.jvm.internal.impl.load.java.i");
    }
}
