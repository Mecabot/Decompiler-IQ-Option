package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.g;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: JavaAnnotationMapper.kt */
public class b implements c {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), Param.TYPE, "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    private final kotlin.reflect.jvm.internal.impl.name.b eBM;
    private final ai eBw;
    private final e eFQ;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.b eFR;

    /* renamed from: bfN */
    public ad bai() {
        return (ad) g.a(this.eFQ, (Object) this, apP[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0041  */
    public b(kotlin.reflect.jvm.internal.impl.load.java.lazy.h r2, kotlin.reflect.jvm.internal.impl.load.java.structure.a r3, kotlin.reflect.jvm.internal.impl.name.b r4) {
        /*
        r1 = this;
        r0 = "c";
        kotlin.jvm.internal.h.e(r2, r0);
        r0 = "fqName";
        kotlin.jvm.internal.h.e(r4, r0);
        r1.<init>();
        r1.eBM = r4;
        if (r3 == 0) goto L_0x0025;
    L_0x0011:
        r4 = r2.bgq();
        r4 = r4.bgc();
        r0 = r3;
        r0 = (kotlin.reflect.jvm.internal.impl.load.java.structure.l) r0;
        r4 = r4.a(r0);
        if (r4 == 0) goto L_0x0025;
    L_0x0022:
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ai) r4;
        goto L_0x002c;
    L_0x0025:
        r4 = kotlin.reflect.jvm.internal.impl.descriptors.ai.eAX;
        r0 = "SourceElement.NO_SOURCE";
        kotlin.jvm.internal.h.d(r4, r0);
    L_0x002c:
        r1.eBw = r4;
        r4 = r2.baI();
        r0 = new kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$type$2;
        r0.<init>(r1, r2);
        r0 = (kotlin.jvm.a.a) r0;
        r2 = r4.i(r0);
        r1.eFQ = r2;
        if (r3 == 0) goto L_0x0050;
    L_0x0041:
        r2 = r3.bhj();
        if (r2 == 0) goto L_0x0050;
    L_0x0047:
        r2 = (java.lang.Iterable) r2;
        r2 = kotlin.collections.u.N(r2);
        r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.b) r2;
        goto L_0x0051;
    L_0x0050:
        r2 = 0;
    L_0x0051:
        r1.eFR = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.components.b.<init>(kotlin.reflect.jvm.internal.impl.load.java.lazy.h, kotlin.reflect.jvm.internal.impl.load.java.structure.a, kotlin.reflect.jvm.internal.impl.name.b):void");
    }

    public kotlin.reflect.jvm.internal.impl.name.b bdD() {
        return this.eBM;
    }

    public ai bbR() {
        return this.eBw;
    }

    protected final kotlin.reflect.jvm.internal.impl.load.java.structure.b bfO() {
        return this.eFR;
    }

    public Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> bee() {
        return ad.emptyMap();
    }
}
