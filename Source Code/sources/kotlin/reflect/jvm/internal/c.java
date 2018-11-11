package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001f\b \u0018\u0000 /*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u001b#$%&'()*+,-./0123456789:;<=B1\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\nH&¢\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u001f2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\nH\u0014¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0004R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006>"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller;", "M", "Ljava/lang/reflect/Member;", "", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "arity", "", "getArity", "()I", "getInstanceClass$kotlin_reflect_api", "()Ljava/lang/Class;", "getMember$kotlin_reflect_api", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType$kotlin_reflect_api", "()Ljava/lang/reflect/Type;", "call", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "checkObjectInstance", "obj", "BoundClassCompanionFieldGetter", "BoundClassCompanionFieldSetter", "BoundConstructor", "BoundInstanceFieldGetter", "BoundInstanceFieldSetter", "BoundInstanceMethod", "BoundJvmStaticInObject", "BoundJvmStaticInObjectFieldGetter", "BoundJvmStaticInObjectFieldSetter", "BoundStaticMethod", "ClassCompanionFieldGetter", "ClassCompanionFieldSetter", "Companion", "Constructor", "FieldGetter", "FieldSetter", "InstanceFieldGetter", "InstanceFieldSetter", "InstanceMethod", "JvmStaticInObject", "JvmStaticInObjectFieldGetter", "JvmStaticInObjectFieldSetter", "Method", "StaticFieldGetter", "StaticFieldSetter", "StaticMethod", "ThrowingCaller", "kotlin-reflect-api"})
/* compiled from: FunctionCaller.kt */
public abstract class c<M extends Member> {
    public static final m evc = new m();
    private final List<Type> Uj;
    private final Type eva;
    private final Class<?> evb;
    private final M member;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0004\"\u0006\b\u0001\u0010\t\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\t0\u0004H\b¢\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004*\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\n¨\u0006\f"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$Companion;", "", "()V", "argsWithReceiver", "", "receiver", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirst", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirstArg", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class m {
        private m() {
        }

        public /* synthetic */ m(f fVar) {
            this();
        }

        public final Object[] c(Object obj, Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            Object obj2 = new Object[(objArr.length + 1)];
            obj2[0] = obj;
            System.arraycopy(objArr, 0, obj2, 1, objArr.length);
            return obj2;
        }

        public final Object[] N(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "$receiver");
            m mVar = this;
            if (objArr.length <= 1) {
                return new Object[0];
            }
            objArr = Arrays.copyOfRange(objArr, 1, objArr.length);
            kotlin.jvm.internal.h.d(objArr, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            if (objArr != null) {
                return objArr;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$ThrowingCaller;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "", "()V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class aa extends c {
        public static final aa eve = new aa();

        private aa() {
            Class cls = Void.TYPE;
            kotlin.jvm.internal.h.d(cls, "Void.TYPE");
            super(null, cls, null, new Type[0]);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundClassCompanionFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class b extends c<Field> {
        public b(Field field, Class<?> cls) {
            kotlin.jvm.internal.h.e(field, "field");
            kotlin.jvm.internal.h.e(cls, "klass");
            Member member = field;
            Class cls2 = Void.TYPE;
            kotlin.jvm.internal.h.d(cls2, "Void.TYPE");
            Type type = cls2;
            Type[] typeArr = new Type[1];
            Type genericType = field.getGenericType();
            kotlin.jvm.internal.h.d(genericType, "field.genericType");
            typeArr[0] = genericType;
            super(member, type, cls, typeArr);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            ((Field) aYw()).set(null, i.x(objArr));
            return kotlin.l.etX;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundConstructor;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class c extends c<Constructor<?>> {
        private final Object boundReceiver;

        public c(Constructor<?> constructor, Object obj) {
            kotlin.jvm.internal.h.e(constructor, "constructor");
            Member member = constructor;
            Class declaringClass = constructor.getDeclaringClass();
            kotlin.jvm.internal.h.d(declaringClass, "constructor.declaringClass");
            Type type = declaringClass;
            Object genericParameterTypes = constructor.getGenericParameterTypes();
            kotlin.jvm.internal.h.d(genericParameterTypes, "constructor.genericParameterTypes");
            super(member, type, null, genericParameterTypes);
            this.boundReceiver = obj;
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            Constructor constructor = (Constructor) aYw();
            objArr = c.evc.c(this.boundReceiver, objArr);
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$ClassCompanionFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class k extends c<Field> {
        public k(Field field, Class<?> cls) {
            kotlin.jvm.internal.h.e(field, "field");
            kotlin.jvm.internal.h.e(cls, "klass");
            Member member = field;
            Type genericType = field.getGenericType();
            kotlin.jvm.internal.h.d(genericType, "field.genericType");
            super(member, genericType, cls, new Type[0]);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return ((Field) aYw()).get(i.v(objArr));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$ClassCompanionFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "klass", "Ljava/lang/Class;", "(Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class l extends c<Field> {
        public l(Field field, Class<?> cls) {
            kotlin.jvm.internal.h.e(field, "field");
            kotlin.jvm.internal.h.e(cls, "klass");
            Member member = field;
            Class cls2 = Void.TYPE;
            kotlin.jvm.internal.h.d(cls2, "Void.TYPE");
            Type type = cls2;
            Type[] typeArr = new Type[1];
            Type genericType = field.getGenericType();
            kotlin.jvm.internal.h.d(genericType, "field.genericType");
            typeArr[0] = genericType;
            super(member, type, cls, typeArr);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            ((Field) aYw()).set(null, i.x(objArr));
            return kotlin.l.etX;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$Constructor;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class n extends c<Constructor<?>> {
        public n(Constructor<?> constructor) {
            kotlin.jvm.internal.h.e(constructor, "constructor");
            Member member = constructor;
            Class declaringClass = constructor.getDeclaringClass();
            kotlin.jvm.internal.h.d(declaringClass, "constructor.declaringClass");
            Type type = declaringClass;
            Class declaringClass2 = constructor.getDeclaringClass();
            kotlin.jvm.internal.h.d(declaringClass2, "klass");
            Class declaringClass3 = declaringClass2.getDeclaringClass();
            if (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) {
                declaringClass3 = null;
            }
            Object genericParameterTypes = constructor.getGenericParameterTypes();
            kotlin.jvm.internal.h.d(genericParameterTypes, "constructor.genericParameterTypes");
            super(member, type, declaringClass3, genericParameterTypes);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return ((Constructor) aYw()).newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static abstract class o extends c<Field> {
        public /* synthetic */ o(Field field, boolean z, int i, f fVar) {
            if ((i & 2) != 0) {
                z = Modifier.isStatic(field.getModifiers()) ^ 1;
            }
            this(field, z);
        }

        public o(Field field, boolean z) {
            Class declaringClass;
            kotlin.jvm.internal.h.e(field, "field");
            Member member = field;
            Type genericType = field.getGenericType();
            kotlin.jvm.internal.h.d(genericType, "field.genericType");
            if (z) {
                declaringClass = field.getDeclaringClass();
            } else {
                declaringClass = null;
            }
            super(member, genericType, declaringClass, new Type[0]);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return ((Field) aYw()).get(aYy() != null ? i.v(objArr) : null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0014¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static abstract class p extends c<Field> {
        private final boolean dq;

        public /* synthetic */ p(Field field, boolean z, boolean z2, int i, f fVar) {
            if ((i & 4) != 0) {
                z2 = Modifier.isStatic(field.getModifiers()) ^ 1;
            }
            this(field, z, z2);
        }

        public p(Field field, boolean z, boolean z2) {
            kotlin.jvm.internal.h.e(field, "field");
            Member member = field;
            Class cls = Void.TYPE;
            kotlin.jvm.internal.h.d(cls, "Void.TYPE");
            Type type = cls;
            Class declaringClass = z2 ? field.getDeclaringClass() : null;
            Type[] typeArr = new Type[1];
            Type genericType = field.getGenericType();
            kotlin.jvm.internal.h.d(genericType, "field.genericType");
            typeArr[0] = genericType;
            super(member, type, declaringClass, typeArr);
            this.dq = z;
        }

        protected void M(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            super.M(objArr);
            if (this.dq && i.x(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            ((Field) aYw()).set(aYy() != null ? i.v(objArr) : null, i.x(objArr));
            return kotlin.l.etX;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ%\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004¢\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static abstract class w extends c<Method> {
        private final boolean evd;

        public /* synthetic */ w(Method method, boolean z, Type[] typeArr, int i, f fVar) {
            if ((i & 2) != 0) {
                z = Modifier.isStatic(method.getModifiers()) ^ 1;
            }
            if ((i & 4) != 0) {
                typeArr = method.getGenericParameterTypes();
                kotlin.jvm.internal.h.d(typeArr, "method.genericParameterTypes");
            }
            this(method, z, typeArr);
        }

        public w(Method method, boolean z, Type[] typeArr) {
            kotlin.jvm.internal.h.e(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
            kotlin.jvm.internal.h.e(typeArr, "parameterTypes");
            Member member = method;
            Type genericReturnType = method.getGenericReturnType();
            kotlin.jvm.internal.h.d(genericReturnType, "method.genericReturnType");
            super(member, genericReturnType, z ? method.getDeclaringClass() : null, typeArr);
            this.evd = kotlin.jvm.internal.h.E(aYx(), Void.TYPE);
        }

        protected final Object d(Object obj, Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            return this.evd ? kotlin.l.etX : ((Method) aYw()).invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundClassCompanionFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class a extends o {
        private final Object boundReceiver;

        public a(Field field, Object obj) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, false);
            this.boundReceiver = obj;
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return ((Field) aYw()).get(this.boundReceiver);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class d extends o {
        private final Object boundReceiver;

        public d(Field field, Object obj) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, false);
            this.boundReceiver = obj;
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return ((Field) aYw()).get(this.boundReceiver);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class e extends p {
        private final Object boundReceiver;

        public e(Field field, boolean z, Object obj) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, z, false);
            this.boundReceiver = obj;
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            ((Field) aYw()).set(this.boundReceiver, i.v(objArr));
            return kotlin.l.etX;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundInstanceMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class f extends w {
        private final Object boundReceiver;

        public f(Method method, Object obj) {
            kotlin.jvm.internal.h.e(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
            super(method, false, null, 4, null);
            this.boundReceiver = obj;
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return d(this.boundReceiver, objArr);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class g extends w {
        public g(Method method) {
            kotlin.jvm.internal.h.e(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
            super(method, false, null, 4, null);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return d(null, objArr);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObjectFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class h extends o {
        public h(Field field) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, false);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundJvmStaticInObjectFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class i extends p {
        public i(Field field, boolean z) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, z, false);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            ((Field) aYw()).set(null, i.x(objArr));
            return kotlin.l.etX;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$BoundStaticMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class j extends w {
        private final Object boundReceiver;

        public j(Method method, Object obj) {
            Type[] typeArr;
            kotlin.jvm.internal.h.e(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
            m mVar = c.evc;
            Object genericParameterTypes = method.getGenericParameterTypes();
            kotlin.jvm.internal.h.d(genericParameterTypes, "method.genericParameterTypes");
            if (genericParameterTypes.length <= 1) {
                typeArr = new Type[0];
            } else {
                typeArr = Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                kotlin.jvm.internal.h.d(typeArr, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
                if (typeArr == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            super(method, false, typeArr);
            this.boundReceiver = obj;
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return d(null, c.evc.c(this.boundReceiver, objArr));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class q extends o {
        public q(Field field) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, false, 2, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class r extends p {
        public r(Field field, boolean z) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, z, false, 4, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$InstanceMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class s extends w {
        public s(Method method) {
            kotlin.jvm.internal.h.e(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
            super(method, false, null, 6, null);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return d(objArr[0], c.evc.N(objArr));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class t extends w {
        public t(Method method) {
            kotlin.jvm.internal.h.e(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
            super(method, true, null, 4, null);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            cE(i.w(objArr));
            return d(null, c.evc.N(objArr));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0014¢\u0006\u0002\u0010\t¨\u0006\n"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObjectFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class u extends o {
        public u(Field field) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, true);
        }

        protected void M(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            super.M(objArr);
            cE(i.w(objArr));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0014¢\u0006\u0002\u0010\u000b¨\u0006\f"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$JvmStaticInObjectFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class v extends p {
        public v(Field field, boolean z) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, z, true);
        }

        protected void M(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            super.M(objArr);
            cE(i.w(objArr));
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticFieldGetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class x extends o {
        public x(Field field) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, false, 2, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticFieldSetter;", "Lkotlin/reflect/jvm/internal/FunctionCaller$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class y extends p {
        public y(Field field, boolean z) {
            kotlin.jvm.internal.h.e(field, "field");
            super(field, z, false, 4, null);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, aXE = {"Lkotlin/reflect/jvm/internal/FunctionCaller$StaticMethod;", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: FunctionCaller.kt */
    public static final class z extends w {
        public z(Method method) {
            kotlin.jvm.internal.h.e(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
            super(method, false, null, 6, null);
        }

        public Object L(Object[] objArr) {
            kotlin.jvm.internal.h.e(objArr, "args");
            M(objArr);
            return d(null, objArr);
        }
    }

    public abstract Object L(Object[] objArr);

    /* JADX WARNING: Missing block: B:3:0x0035, code:
            if (r2 != null) goto L_0x003c;
     */
    public c(M r2, java.lang.reflect.Type r3, java.lang.Class<?> r4, java.lang.reflect.Type[] r5) {
        /*
        r1 = this;
        r0 = "returnType";
        kotlin.jvm.internal.h.e(r3, r0);
        r0 = "valueParameterTypes";
        kotlin.jvm.internal.h.e(r5, r0);
        r1.<init>();
        r1.member = r2;
        r1.eva = r3;
        r1.evb = r4;
        r2 = r1.evb;
        if (r2 == 0) goto L_0x0038;
    L_0x0017:
        r3 = new kotlin.jvm.internal.l;
        r4 = 2;
        r3.<init>(r4);
        r2 = (java.lang.reflect.Type) r2;
        r3.add(r2);
        r3.cw(r5);
        r2 = r3.size();
        r2 = new java.lang.reflect.Type[r2];
        r2 = r3.toArray(r2);
        r2 = (java.lang.reflect.Type[]) r2;
        r2 = kotlin.collections.m.listOf(r2);
        if (r2 == 0) goto L_0x0038;
    L_0x0037:
        goto L_0x003c;
    L_0x0038:
        r2 = kotlin.collections.i.A(r5);
    L_0x003c:
        r1.Uj = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.c.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }

    public final M aYw() {
        return this.member;
    }

    public final Type aYx() {
        return this.eva;
    }

    public final Class<?> aYy() {
        return this.evb;
    }

    public final int aYv() {
        return this.Uj.size();
    }

    protected void M(Object[] objArr) {
        kotlin.jvm.internal.h.e(objArr, "args");
        if (aYv() != objArr.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Callable expects ");
            stringBuilder.append(aYv());
            stringBuilder.append(" arguments, but ");
            stringBuilder.append(objArr.length);
            stringBuilder.append(" were provided.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    protected final void cE(Object obj) {
        if (obj != null) {
            Member member = this.member;
            if (member == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            if (member.getDeclaringClass().isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
    }
}
