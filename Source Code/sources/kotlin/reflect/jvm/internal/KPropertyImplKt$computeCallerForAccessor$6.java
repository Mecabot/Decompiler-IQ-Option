package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.c.e;
import kotlin.reflect.jvm.internal.c.l;
import kotlin.reflect.jvm.internal.c.o;
import kotlin.reflect.jvm.internal.c.p;
import kotlin.reflect.jvm.internal.c.q;
import kotlin.reflect.jvm.internal.c.r;
import kotlin.reflect.jvm.internal.c.u;
import kotlin.reflect.jvm.internal.c.v;
import kotlin.reflect.jvm.internal.c.x;
import kotlin.reflect.jvm.internal.c.y;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.s.a;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"computeFieldCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "invoke"})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImplKt$computeCallerForAccessor$6 extends Lambda implements b<Field, c<? extends Field>> {
    final /* synthetic */ boolean $isGetter;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$1 $isInsideClassCompanionObject$1;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$3 $isInsideInterfaceCompanionObjectWithJvmField$3;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$4 $isJvmStaticProperty$4;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$5 $isNotNullProperty$5;
    final /* synthetic */ a receiver$0;

    KPropertyImplKt$computeCallerForAccessor$6(a aVar, KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1, KPropertyImplKt$computeCallerForAccessor$3 kPropertyImplKt$computeCallerForAccessor$3, boolean z, KPropertyImplKt$computeCallerForAccessor$5 kPropertyImplKt$computeCallerForAccessor$5, KPropertyImplKt$computeCallerForAccessor$4 kPropertyImplKt$computeCallerForAccessor$4) {
        this.receiver$0 = aVar;
        this.$isInsideClassCompanionObject$1 = kPropertyImplKt$computeCallerForAccessor$1;
        this.$isInsideInterfaceCompanionObjectWithJvmField$3 = kPropertyImplKt$computeCallerForAccessor$3;
        this.$isGetter = z;
        this.$isNotNullProperty$5 = kPropertyImplKt$computeCallerForAccessor$5;
        this.$isJvmStaticProperty$4 = kPropertyImplKt$computeCallerForAccessor$4;
        super(1);
    }

    /* renamed from: b */
    public final c<Field> invoke(Field field) {
        h.e(field, "field");
        o hVar;
        p iVar;
        if (this.$isInsideClassCompanionObject$1.invoke() || this.$isInsideInterfaceCompanionObjectWithJvmField$3.invoke()) {
            k bbv = this.receiver$0.bab().bbv();
            if (bbv == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            Class a = ae.a((d) bbv);
            if (a == null) {
                h.aXZ();
            }
            if (!this.$isGetter) {
                c<Field> bVar;
                if (this.receiver$0.isBound()) {
                    bVar = new c.b(field, a);
                } else {
                    bVar = new l(field, a);
                }
                return bVar;
            } else if (this.receiver$0.isBound()) {
                return new c.a(field, a);
            } else {
                return new c.k(field, a);
            }
        } else if (Modifier.isStatic(field.getModifiers())) {
            if (this.$isJvmStaticProperty$4.invoke()) {
                if (this.$isGetter) {
                    if (this.receiver$0.isBound()) {
                        hVar = new c.h(field);
                    } else {
                        hVar = new u(field);
                    }
                    return hVar;
                }
                if (this.receiver$0.isBound()) {
                    iVar = new c.i(field, this.$isNotNullProperty$5.invoke());
                } else {
                    iVar = new v(field, this.$isNotNullProperty$5.invoke());
                }
                return iVar;
            } else if (this.$isGetter) {
                return new x(field);
            } else {
                return new y(field, this.$isNotNullProperty$5.invoke());
            }
        } else if (this.$isGetter) {
            if (this.receiver$0.isBound()) {
                hVar = new c.d(field, this.receiver$0.aZv().aXQ());
            } else {
                hVar = new q(field);
            }
            return hVar;
        } else {
            if (this.receiver$0.isBound()) {
                iVar = new e(field, this.$isNotNullProperty$5.invoke(), this.receiver$0.aZv().aXQ());
            } else {
                iVar = new r(field, this.$isNotNullProperty$5.invoke());
            }
            return iVar;
        }
    }
}
