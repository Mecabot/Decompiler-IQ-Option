package kotlin.reflect.jvm.internal;

import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.k;
import kotlin.reflect.b;
import kotlin.reflect.d;
import kotlin.reflect.e;
import kotlin.reflect.h;
import kotlin.reflect.l;

/* compiled from: ReflectionFactoryImpl */
public class z extends k {
    public d e(Class cls, String str) {
        return new n(cls, str);
    }

    public b F(Class cls) {
        return h.H(cls);
    }

    public String a(Lambda lambda) {
        return a((FunctionBase) lambda);
    }

    public String a(FunctionBase functionBase) {
        e a = kotlin.reflect.jvm.d.a(functionBase);
        if (a != null) {
            KFunctionImpl cH = ae.cH(a);
            if (cH != null) {
                return aa.ewB.c(cH.aYM());
            }
        }
        return super.a(functionBase);
    }

    public e a(FunctionReference functionReference) {
        return new KFunctionImpl(a((CallableReference) functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.aXQ());
    }

    public kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return new p(a((CallableReference) propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.aXQ());
    }

    public l a(PropertyReference1 propertyReference1) {
        return new q(a((CallableReference) propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.aXQ());
    }

    public h a(MutablePropertyReference1 mutablePropertyReference1) {
        return new l(a((CallableReference) mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.aXQ());
    }

    private static KDeclarationContainerImpl a(CallableReference callableReference) {
        d Py = callableReference.Py();
        return Py instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) Py : b.euZ;
    }
}
