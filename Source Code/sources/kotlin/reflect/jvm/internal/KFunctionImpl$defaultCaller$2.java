package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.AnnotationConstructorCaller.CallMode;
import kotlin.reflect.jvm.internal.AnnotationConstructorCaller.Origin;
import kotlin.reflect.jvm.internal.c.w;
import kotlin.reflect.jvm.internal.e.d;
import kotlin.reflect.jvm.internal.e.e;
import kotlin.reflect.jvm.internal.impl.descriptors.k;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Member;", "invoke"})
/* compiled from: KFunctionImpl.kt */
final class KFunctionImpl$defaultCaller$2 extends Lambda implements a<c<? extends Member>> {
    final /* synthetic */ KFunctionImpl this$0;

    KFunctionImpl$defaultCaller$2(KFunctionImpl kFunctionImpl) {
        this.this$0 = kFunctionImpl;
        super(0);
    }

    /* renamed from: aZr */
    public final c<Member> invoke() {
        Member a;
        e d = ac.ewF.d(this.this$0.aYM());
        c<Member> cVar = null;
        Class aXV;
        Collection arrayList;
        if (d instanceof e) {
            KDeclarationContainerImpl aYP = this.this$0.aYP();
            e eVar = (e) d;
            String methodName = eVar.getMethodName();
            String aYB = eVar.aYB();
            Member aYw = this.this$0.aYN().aYw();
            if (aYw == null) {
                h.aXZ();
            }
            a = aYP.a(methodName, aYB, Modifier.isStatic(aYw.getModifiers()) ^ 1, ae.b(this.this$0.aYM()));
        } else if (d instanceof d) {
            if (this.this$0.aYQ()) {
                aXV = this.this$0.aYP().aXV();
                Iterable<KParameter> parameters = this.this$0.getParameters();
                arrayList = new ArrayList(n.e(parameters, 10));
                for (KParameter name : parameters) {
                    String name2 = name.getName();
                    if (name2 == null) {
                        h.aXZ();
                    }
                    arrayList.add(name2);
                }
                return new AnnotationConstructorCaller(aXV, (List) arrayList, CallMode.CALL_BY_NAME, Origin.KOTLIN, null, 16, null);
            }
            a = this.this$0.aYP().x(((d) d).aYA(), ae.b(this.this$0.aYM()));
        } else if (d instanceof e.a) {
            List atC = ((e.a) d).atC();
            aXV = this.this$0.aYP().aXV();
            Iterable<Method> iterable = atC;
            arrayList = new ArrayList(n.e(iterable, 10));
            for (Method method : iterable) {
                h.d(method, "it");
                arrayList.add(method.getName());
            }
            return new AnnotationConstructorCaller(aXV, (List) arrayList, CallMode.CALL_BY_NAME, Origin.JAVA, atC);
        } else {
            a = null;
        }
        if (a instanceof Constructor) {
            cVar = this.this$0.a((Constructor) a);
        } else if (a instanceof Method) {
            w b;
            if (this.this$0.aYM().bbQ().j(ae.bam()) != null) {
                k bbv = this.this$0.aYM().bbv();
                if (bbv == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                } else if (!((kotlin.reflect.jvm.internal.impl.descriptors.d) bbv).bbK()) {
                    b = this.this$0.d((Method) a);
                    cVar = b;
                }
            }
            b = this.this$0.c((Method) a);
            cVar = b;
        }
        return cVar;
    }
}
