package kotlin.reflect.jvm.internal;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.types.w;

@i(aXC = {1, 1, 11}, aXD = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u0019*\u00060\u001aj\u0002`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u0019*\u00060\u001aj\u0002`\u001b2\u0006\u0010\u001f\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, aXE = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "renderTypeParameter", "typeParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflect-api"})
/* compiled from: ReflectionObjectRenderer.kt */
public final class aa {
    private static final b ewA = b.ePd;
    public static final aa ewB = new aa();

    private aa() {
    }

    private final void a(StringBuilder stringBuilder, ag agVar) {
        if (agVar != null) {
            w bai = agVar.bai();
            h.d(bai, "receiver.type");
            stringBuilder.append(b(bai));
            stringBuilder.append(".");
        }
    }

    private final void a(StringBuilder stringBuilder, a aVar) {
        ag bcP = aVar.bcP();
        ag bcO = aVar.bcO();
        a(stringBuilder, bcP);
        Object obj = (bcP == null || bcO == null) ? null : 1;
        if (obj != null) {
            stringBuilder.append("(");
        }
        a(stringBuilder, bcO);
        if (obj != null) {
            stringBuilder.append(")");
        }
    }

    private final String a(a aVar) {
        if (aVar instanceof ad) {
            return c((ad) aVar);
        }
        if (aVar instanceof r) {
            return b((r) aVar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal callable: ");
        stringBuilder.append(aVar);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    public final String c(ad adVar) {
        h.e(adVar, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(adVar.bdW() ? "var " : "val ");
        ewB.a(stringBuilder, (a) adVar);
        b bVar = ewA;
        f bdc = adVar.bdc();
        h.d(bdc, "descriptor.name");
        stringBuilder.append(bVar.b(bdc, true));
        stringBuilder.append(": ");
        aa aaVar = ewB;
        w bai = adVar.bai();
        h.d(bai, "descriptor.type");
        stringBuilder.append(aaVar.b(bai));
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    public final String b(r rVar) {
        h.e(rVar, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fun ");
        ewB.a(stringBuilder, (a) rVar);
        b bVar = ewA;
        f bdc = rVar.bdc();
        h.d(bdc, "descriptor.name");
        stringBuilder.append(bVar.b(bdc, true));
        List bcS = rVar.bcS();
        h.d(bcS, "descriptor.valueParameters");
        u.a(bcS, stringBuilder, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderFunction$1$1.ewC, 48, null);
        stringBuilder.append(": ");
        aa aaVar = ewB;
        w bcQ = rVar.bcQ();
        if (bcQ == null) {
            h.aXZ();
        }
        h.d(bcQ, "descriptor.returnType!!");
        stringBuilder.append(aaVar.b(bcQ));
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    public final String c(r rVar) {
        h.e(rVar, "invoke");
        StringBuilder stringBuilder = new StringBuilder();
        ewB.a(stringBuilder, (a) rVar);
        List bcS = rVar.bcS();
        h.d(bcS, "invoke.valueParameters");
        u.a(bcS, stringBuilder, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderLambda$1$1.ewD, 48, null);
        stringBuilder.append(" -> ");
        aa aaVar = ewB;
        w bcQ = rVar.bcQ();
        if (bcQ == null) {
            h.aXZ();
        }
        h.d(bcQ, "invoke.returnType!!");
        stringBuilder.append(aaVar.b(bcQ));
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    public final String b(o oVar) {
        h.e(oVar, "parameter");
        StringBuilder stringBuilder = new StringBuilder();
        switch (ab.aoS[oVar.aZN().ordinal()]) {
            case 1:
                stringBuilder.append("extension receiver");
                break;
            case 2:
                stringBuilder.append("instance");
                break;
            case 3:
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("parameter #");
                stringBuilder2.append(oVar.getIndex());
                stringBuilder2.append(' ');
                stringBuilder2.append(oVar.getName());
                stringBuilder.append(stringBuilder2.toString());
                break;
        }
        stringBuilder.append(" of ");
        stringBuilder.append(ewB.a((a) oVar.aZM().aYM()));
        String stringBuilder3 = stringBuilder.toString();
        h.d(stringBuilder3, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder3;
    }

    public final String a(an anVar) {
        h.e(anVar, "typeParameter");
        StringBuilder stringBuilder = new StringBuilder();
        switch (ab.auk[anVar.bdd().ordinal()]) {
            case 2:
                stringBuilder.append("in ");
                break;
            case 3:
                stringBuilder.append("out ");
                break;
        }
        stringBuilder.append(anVar.bdc());
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    public final String b(w wVar) {
        h.e(wVar, Param.TYPE);
        return ewA.b(wVar);
    }
}
