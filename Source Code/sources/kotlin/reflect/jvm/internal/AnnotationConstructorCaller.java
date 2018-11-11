package kotlin.reflect.jvm.internal;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0016\u0017B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016¢\u0006\u0002\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflect-api"})
/* compiled from: AnnotationConstructorCaller.kt */
public final class AnnotationConstructorCaller extends c {
    private final List<Class<?>> euP;
    private final List<Object> euQ;
    private final List<String> euR;
    private final CallMode euS;
    private final Class<?> eus;
    private final List<Method> methods;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, aXE = {"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflect-api"})
    /* compiled from: AnnotationConstructorCaller.kt */
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, aXE = {"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflect-api"})
    /* compiled from: AnnotationConstructorCaller.kt */
    public enum Origin {
        JAVA,
        KOTLIN
    }

    public /* synthetic */ AnnotationConstructorCaller(Class cls, List list, CallMode callMode, Origin origin, List list2, int i, f fVar) {
        if ((i & 16) != 0) {
            Iterable<String> iterable = list;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (String declaredMethod : iterable) {
                arrayList.add(cls.getDeclaredMethod(declaredMethod, new Class[0]));
            }
            list2 = (List) arrayList;
        }
        this(cls, list, callMode, origin, list2);
    }

    public AnnotationConstructorCaller(Class<?> cls, List<String> list, CallMode callMode, Origin origin, List<Method> list2) {
        h.e(cls, "jClass");
        h.e(list, "parameterNames");
        h.e(callMode, "callMode");
        h.e(origin, b.ORIGIN);
        h.e(list2, "methods");
        Type type = cls;
        Iterable<Method> iterable = list2;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (Method genericReturnType : iterable) {
            arrayList.add(genericReturnType.getGenericReturnType());
        }
        Object[] toArray = ((List) arrayList).toArray(new Type[0]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        super(null, type, null, (Type[]) toArray);
        this.eus = cls;
        this.euR = list;
        this.euS = callMode;
        this.methods = list2;
        Iterable<Method> iterable2 = this.methods;
        Collection arrayList2 = new ArrayList(n.e(iterable2, 10));
        for (Method returnType : iterable2) {
            Object returnType2 = returnType.getReturnType();
            h.d(returnType2, "it");
            Class R = kotlin.reflect.jvm.internal.structure.b.R(returnType2);
            if (R != null) {
                returnType2 = R;
            }
            arrayList2.add(returnType2);
        }
        this.euP = (List) arrayList2;
        iterable2 = this.methods;
        arrayList2 = new ArrayList(n.e(iterable2, 10));
        for (Method returnType3 : iterable2) {
            arrayList2.add(returnType3.getDefaultValue());
        }
        this.euQ = (List) arrayList2;
        if (this.euS == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && (u.d((Iterable) this.euR, (Object) b.VALUE).isEmpty() ^ 1) != 0) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    public Object L(Object[] objArr) {
        h.e(objArr, "args");
        M(objArr);
        Collection arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            int i3 = i2 + 1;
            if (obj == null && this.euS == CallMode.CALL_BY_NAME) {
                obj = this.euQ.get(i2);
            } else {
                obj = a.a(obj, (Class) this.euP.get(i2));
            }
            if (obj != null) {
                arrayList.add(obj);
                i++;
                i2 = i3;
            } else {
                a.a(i2, (String) this.euR.get(i2), (Class) this.euP.get(i2));
                throw null;
            }
        }
        return a.a(this.eus, this.methods, ad.ae(u.f((Iterable) this.euR, (Iterable) (List) arrayList)));
    }
}
