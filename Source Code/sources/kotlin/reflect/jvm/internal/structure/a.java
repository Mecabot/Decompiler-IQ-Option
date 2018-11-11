package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader;", "", "()V", "cache", "Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "getCache", "()Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "setCache", "(Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;)V", "buildCache", "member", "Ljava/lang/reflect/Member;", "loadParameterNames", "", "", "Cache", "descriptors.runtime"})
/* compiled from: ReflectJavaMember.kt */
final class a {
    private static a eYf;
    public static final a eYg = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "", "getParameters", "Ljava/lang/reflect/Method;", "getName", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetName", "()Ljava/lang/reflect/Method;", "getGetParameters", "descriptors.runtime"})
    /* compiled from: ReflectJavaMember.kt */
    public static final class a {
        private final Method eYh;
        private final Method eYi;

        public a(Method method, Method method2) {
            this.eYh = method;
            this.eYi = method2;
        }

        public final Method bzM() {
            return this.eYh;
        }

        public final Method bzN() {
            return this.eYi;
        }
    }

    private a() {
    }

    public final a a(Member member) {
        h.e(member, "member");
        Class cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", new Class[0]), b.O(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List<String> b(Member member) {
        h.e(member, "member");
        a aVar = eYf;
        if (aVar == null) {
            aVar = a(member);
            eYf = aVar;
        }
        Method bzM = aVar.bzM();
        if (bzM == null) {
            return null;
        }
        Method bzN = aVar.bzN();
        if (bzN == null) {
            return null;
        }
        Object invoke = bzM.invoke(member, new Object[0]);
        if (invoke == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
        }
        Object[] objArr = (Object[]) invoke;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object invoke2 : objArr) {
            Object invoke22 = bzN.invoke(invoke22, new Object[0]);
            if (invoke22 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            arrayList.add((String) invoke22);
        }
        return (List) arrayList;
    }
}
