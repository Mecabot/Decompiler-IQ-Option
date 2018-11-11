package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.w;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1 extends Lambda implements a<Type> {
    final /* synthetic */ w $kotlinType;
    final /* synthetic */ KClassImpl$Data$supertypes$2 this$0;

    KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(w wVar, KClassImpl$Data$supertypes$2 kClassImpl$Data$supertypes$2) {
        this.$kotlinType = wVar;
        this.this$0 = kClassImpl$Data$supertypes$2;
        super(0);
    }

    /* renamed from: aYV */
    public final Type invoke() {
        f bbW = this.$kotlinType.bwA().bbW();
        StringBuilder stringBuilder;
        if (bbW instanceof d) {
            Class a = ae.a((d) bbW);
            Type genericSuperclass;
            if (a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported superclass of ");
                stringBuilder.append(this.this$0.this$0);
                stringBuilder.append(": ");
                stringBuilder.append(bbW);
                throw new KotlinReflectionInternalError(stringBuilder.toString());
            } else if (h.E(i.this.aXV().getSuperclass(), a)) {
                genericSuperclass = i.this.aXV().getGenericSuperclass();
                h.d(genericSuperclass, "jClass.genericSuperclass");
                return genericSuperclass;
            } else {
                Object interfaces = i.this.aXV().getInterfaces();
                h.d(interfaces, "jClass.interfaces");
                int indexOf = i.indexOf(interfaces, a);
                if (indexOf < 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("No superclass of ");
                    stringBuilder.append(this.this$0.this$0);
                    stringBuilder.append(" in Java reflection for ");
                    stringBuilder.append(bbW);
                    throw new KotlinReflectionInternalError(stringBuilder.toString());
                }
                genericSuperclass = i.this.aXV().getGenericInterfaces()[indexOf];
                h.d(genericSuperclass, "jClass.genericInterfaces[index]");
                return genericSuperclass;
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Supertype not a class: ");
        stringBuilder.append(bbW);
        throw new KotlinReflectionInternalError(stringBuilder.toString());
    }
}
