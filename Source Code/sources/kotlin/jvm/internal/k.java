package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.d;
import kotlin.reflect.e;
import kotlin.reflect.h;
import kotlin.reflect.l;

/* compiled from: ReflectionFactory */
public class k {
    public e a(FunctionReference functionReference) {
        return functionReference;
    }

    public h a(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public l a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public d e(Class cls, String str) {
        return new i(cls, str);
    }

    public b F(Class cls) {
        return new d(cls);
    }

    public String a(Lambda lambda) {
        return a((FunctionBase) lambda);
    }

    public String a(FunctionBase functionBase) {
        String obj = functionBase.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring("kotlin.jvm.functions.".length()) : obj;
    }
}
