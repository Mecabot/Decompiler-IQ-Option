package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: BuiltInAnnotationDescriptor.kt */
public final class j implements c {
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(j.class), Param.TYPE, "getType()Lorg/jetbrains/kotlin/types/KotlinType;"))};
    private final d den = g.a(LazyThreadSafetyMode.PUBLICATION, new BuiltInAnnotationDescriptor$type$2(this));
    private final g eBL;
    private final b eBM;
    private final Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> eBN;

    public w bai() {
        d dVar = this.den;
        kotlin.reflect.j jVar = apP[0];
        return (w) dVar.getValue();
    }

    public j(g gVar, b bVar, Map<f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> map) {
        h.e(gVar, "builtIns");
        h.e(bVar, "fqName");
        h.e(map, "allValueArguments");
        this.eBL = gVar;
        this.eBM = bVar;
        this.eBN = map;
    }

    public b bdD() {
        return this.eBM;
    }

    public Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> bee() {
        return this.eBN;
    }

    public ai bbR() {
        ai aiVar = ai.eAX;
        h.d(aiVar, "SourceElement.NO_SOURCE");
        return aiVar;
    }
}
