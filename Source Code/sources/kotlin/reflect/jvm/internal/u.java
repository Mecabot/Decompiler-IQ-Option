package kotlin.reflect.jvm.internal;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.lang.reflect.Type;
import kotlin.NotImplementedError;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.c;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.structure.b;
import kotlin.reflect.jvm.internal.y.a;
import kotlin.reflect.n;

@i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00068@X\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006%²\u0006\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0002¢\u0006\u0000"}, aXE = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflect_api", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflect-api", "parameterizedTypeArguments"})
/* compiled from: KTypeImpl.kt */
public final class u implements n {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(u.class), "javaType", "getJavaType$kotlin_reflect_api()Ljava/lang/reflect/Type;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(u.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(u.class), "arguments", "getArguments()Ljava/util/List;")), kotlin.jvm.internal.j.a(new PropertyReference0Impl(kotlin.jvm.internal.j.F(u.class), "parameterizedTypeArguments", "<v#0>"))};
    private final a ewr;
    private final a ews = y.h(new KTypeImpl$classifier$2(this));
    private final a ewt = y.h(new KTypeImpl$arguments$2(this));
    private final w ewu;

    public c aYo() {
        return (c) this.ews.G(this, apP[1]);
    }

    public final Type bah() {
        return (Type) this.ewr.G(this, apP[0]);
    }

    public u(w wVar, kotlin.jvm.a.a<? extends Type> aVar) {
        h.e(wVar, Param.TYPE);
        h.e(aVar, "computeJavaType");
        this.ewu = wVar;
        this.ewr = y.h(aVar);
    }

    public final w bai() {
        return this.ewu;
    }

    private final c a(w wVar) {
        f bbW = wVar.bwA().bbW();
        if (bbW instanceof d) {
            Class a = ae.a((d) bbW);
            if (a == null) {
                return null;
            }
            if (a.isArray()) {
                ap apVar = (ap) u.bZ(wVar.bdF());
                if (apVar != null) {
                    wVar = apVar.bai();
                    if (wVar != null) {
                        h.d(wVar, "argument");
                        c a2 = a(wVar);
                        if (a2 != null) {
                            return new i(b.U(kotlin.jvm.a.a(kotlin.reflect.jvm.b.a(a2))));
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Cannot determine classifier for array element type: ");
                        stringBuilder.append(this);
                        throw new KotlinReflectionInternalError(stringBuilder.toString());
                    }
                }
                return new i(a);
            } else if (au.aW(wVar)) {
                return new i(a);
            } else {
                Class Q = b.Q(a);
                if (Q != null) {
                    a = Q;
                }
                return new i(a);
            }
        } else if (bbW instanceof an) {
            return new w((an) bbW);
        } else {
            if (!(bbW instanceof am)) {
                return null;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("An operation is not implemented: ");
            stringBuilder2.append("Type alias classifiers are not yet supported");
            throw new NotImplementedError(stringBuilder2.toString());
        }
    }

    public boolean aYp() {
        return this.ewu.aYp();
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && h.E(this.ewu, ((u) obj).ewu);
    }

    public int hashCode() {
        return this.ewu.hashCode();
    }

    public String toString() {
        return aa.ewB.b(this.ewu);
    }
}
