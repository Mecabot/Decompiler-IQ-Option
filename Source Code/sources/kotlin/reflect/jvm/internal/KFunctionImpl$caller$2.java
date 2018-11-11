package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.AnnotationConstructorCaller.CallMode;
import kotlin.reflect.jvm.internal.AnnotationConstructorCaller.Origin;
import kotlin.reflect.jvm.internal.c.w;
import kotlin.reflect.jvm.internal.e.b;
import kotlin.reflect.jvm.internal.e.c;
import kotlin.reflect.jvm.internal.e.d;
import kotlin.reflect.jvm.internal.e.e;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Member;", "invoke"})
/* compiled from: KFunctionImpl.kt */
final class KFunctionImpl$caller$2 extends Lambda implements a<c<? extends Member>> {
    final /* synthetic */ KFunctionImpl this$0;

    KFunctionImpl$caller$2(KFunctionImpl kFunctionImpl) {
        this.this$0 = kFunctionImpl;
        super(0);
    }

    /* renamed from: aZr */
    public final c<Member> invoke() {
        Object w;
        c<Member> a;
        e d = ac.ewF.d(this.this$0.aYM());
        Class aXV;
        Collection arrayList;
        if (d instanceof d) {
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
                return new AnnotationConstructorCaller(aXV, (List) arrayList, CallMode.POSITIONAL_CALL, Origin.KOTLIN, null, 16, null);
            }
            w = this.this$0.aYP().w(((d) d).aYA(), ae.b(this.this$0.aYM()));
        } else if (d instanceof e) {
            e eVar = (e) d;
            w = this.this$0.aYP().l(eVar.getMethodName(), eVar.aYB(), ae.b(this.this$0.aYM()));
        } else if (d instanceof c) {
            w = ((c) d).getMethod();
        } else if (d instanceof b) {
            w = ((b) d).aYz();
        } else if (d instanceof e.a) {
            List atC = ((e.a) d).atC();
            aXV = this.this$0.aYP().aXV();
            Iterable<Method> iterable = atC;
            arrayList = new ArrayList(n.e(iterable, 10));
            for (Method method : iterable) {
                h.d(method, "it");
                arrayList.add(method.getName());
            }
            return new AnnotationConstructorCaller(aXV, (List) arrayList, CallMode.POSITIONAL_CALL, Origin.JAVA, atC);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (w instanceof Constructor) {
            a = this.this$0.a((Constructor) w);
        } else if (w instanceof Method) {
            w a2;
            Method method2 = (Method) w;
            if (!Modifier.isStatic(method2.getModifiers())) {
                a2 = this.this$0.e(method2);
            } else if (this.this$0.aYM().bbQ().j(ae.bam()) != null) {
                a2 = this.this$0.d(method2);
            } else {
                a2 = this.this$0.c(method2);
            }
            a = a2;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not compute caller for function: ");
            stringBuilder.append(this.this$0.aYM());
            stringBuilder.append(" (member = ");
            stringBuilder.append(w);
            stringBuilder.append(')');
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        }
        return a;
    }
}
