package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.c;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.u;
import kotlin.reflect.n;
import kotlin.reflect.o;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, aXE = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflect-api"})
/* compiled from: KTypesJvm.kt */
public final class b {
    public static final kotlin.reflect.b<?> d(n nVar) {
        h.e(nVar, "$receiver");
        c aYo = nVar.aYo();
        if (aYo != null) {
            kotlin.reflect.b<?> a = a(aYo);
            if (a != null) {
                return a;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot calculate JVM erasure for type: ");
        stringBuilder.append(nVar);
        throw new KotlinReflectionInternalError(stringBuilder.toString());
    }

    public static final kotlin.reflect.b<?> a(c cVar) {
        h.e(cVar, "$receiver");
        if (cVar instanceof kotlin.reflect.b) {
            return (kotlin.reflect.b) cVar;
        }
        if (cVar instanceof o) {
            Object obj;
            List aYq = ((o) cVar).aYq();
            Iterator it = aYq.iterator();
            Object obj2;
            do {
                f fVar = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                n nVar = (n) obj;
                if (nVar == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                }
                f bbW = ((u) nVar).bai().bwA().bbW();
                if (bbW instanceof d) {
                    fVar = bbW;
                }
                d dVar = (d) fVar;
                if (dVar == null || dVar.bbF() == ClassKind.INTERFACE || dVar.bbF() == ClassKind.ANNOTATION_CLASS) {
                    obj2 = null;
                    continue;
                } else {
                    obj2 = 1;
                    continue;
                }
            } while (obj2 == null);
            n nVar2 = (n) obj;
            if (nVar2 == null) {
                nVar2 = (n) u.bV(aYq);
            }
            if (nVar2 != null) {
                kotlin.reflect.b<?> d = d(nVar2);
                if (d != null) {
                    return d;
                }
            }
            return j.F(Object.class);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot calculate JVM erasure for type: ");
        stringBuilder.append(cVar);
        throw new KotlinReflectionInternalError(stringBuilder.toString());
    }
}
