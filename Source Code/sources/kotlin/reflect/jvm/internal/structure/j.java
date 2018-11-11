package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.java.structure.g;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.structure.t.a;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0011\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0013\u00108\u001a\u00020\u001b2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\u00002\u0006\u0010*\u001a\u00020\u0018H\u0016J\b\u0010<\u001a\u00020'H\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\fR\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u0004\u0018\u00010\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\b\u0012\u0004\u0012\u000202018VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002060\t8VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\f¨\u0006B"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "klass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "constructors", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "getConstructors", "()Ljava/util/List;", "element", "getElement", "()Ljava/lang/Class;", "fields", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaField;", "getFields", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getFqName", "()Lorg/jetbrains/kotlin/name/FqName;", "innerClassNames", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getInnerClassNames", "isAnnotationType", "", "()Z", "isEnum", "isInterface", "lightClassOriginKind", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/LightClassOriginKind;", "getLightClassOriginKind", "()Lorg/jetbrains/kotlin/load/java/structure/LightClassOriginKind;", "methods", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "getMethods", "modifiers", "", "getModifiers", "()I", "name", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "outerClass", "getOuterClass", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "supertypes", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifierType;", "getSupertypes", "()Ljava/util/Collection;", "typeParameters", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "equals", "other", "", "findInnerClass", "hashCode", "isEnumValuesOrValueOf", "method", "Ljava/lang/reflect/Method;", "toString", "", "descriptors.runtime"})
/* compiled from: ReflectJavaClass.kt */
public final class j extends n implements g, f, t {
    private final Class<?> ewM;

    public LightClassOriginKind bhs() {
        return null;
    }

    public av bbJ() {
        return a.d(this);
    }

    public boolean bhm() {
        return f.a.b(this);
    }

    /* renamed from: bxS */
    public List<c> getAnnotations() {
        return f.a.a(this);
    }

    public boolean isAbstract() {
        return a.a(this);
    }

    public boolean isFinal() {
        return a.c(this);
    }

    public boolean isStatic() {
        return a.b(this);
    }

    /* renamed from: w */
    public c r(b bVar) {
        h.e(bVar, "fqName");
        return f.a.a(this, bVar);
    }

    public j(Class<?> cls) {
        h.e(cls, "klass");
        this.ewM = cls;
    }

    /* renamed from: bzS */
    public Class<?> bzP() {
        return this.ewM;
    }

    public int getModifiers() {
        return this.ewM.getModifiers();
    }

    /* renamed from: bzT */
    public List<f> bhp() {
        Object declaredClasses = this.ewM.getDeclaredClasses();
        h.d(declaredClasses, "klass.declaredClasses");
        return m.f(m.g(m.c(i.E(declaredClasses), ReflectJavaClass$innerClassNames$1.eYw), ReflectJavaClass$innerClassNames$2.eYx));
    }

    public b bdD() {
        b btK = b.S(this.ewM).btK();
        h.d(btK, "klass.classId.asSingleFqName()");
        return btK;
    }

    /* renamed from: bzU */
    public j bhq() {
        Class declaringClass = this.ewM.getDeclaringClass();
        return declaringClass != null ? new j(declaringClass) : null;
    }

    public Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.j> beu() {
        if (h.E(this.ewM, Object.class)) {
            return m.emptyList();
        }
        l lVar = new l(2);
        Object genericSuperclass = this.ewM.getGenericSuperclass();
        if (genericSuperclass == null) {
            genericSuperclass = Object.class;
        }
        lVar.add(genericSuperclass);
        genericSuperclass = this.ewM.getGenericInterfaces();
        h.d(genericSuperclass, "klass.genericInterfaces");
        lVar.cw(genericSuperclass);
        Iterable<Type> listOf = m.listOf((Type[]) lVar.toArray(new Type[lVar.size()]));
        Collection arrayList = new ArrayList(n.e(listOf, 10));
        for (Type lVar2 : listOf) {
            arrayList.add(new l(lVar2));
        }
        return (List) arrayList;
    }

    /* renamed from: atC */
    public List<s> bht() {
        Object declaredMethods = this.ewM.getDeclaredMethods();
        h.d(declaredMethods, "klass.declaredMethods");
        return m.f(m.f(m.b(i.E(declaredMethods), new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.eYy));
    }

    private final boolean h(Method method) {
        String name = method.getName();
        if (name == null) {
            return false;
        }
        int hashCode = name.hashCode();
        if (hashCode != -823812830) {
            if (hashCode != 231605032 || !name.equals("valueOf")) {
                return false;
            }
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        } else if (!name.equals("values")) {
            return false;
        } else {
            Object parameterTypes = method.getParameterTypes();
            h.d(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: atw */
    public List<p> bhu() {
        Object declaredFields = this.ewM.getDeclaredFields();
        h.d(declaredFields, "klass.declaredFields");
        return m.f(m.f(m.b(i.E(declaredFields), ReflectJavaClass$fields$1.eYu), ReflectJavaClass$fields$2.eYv));
    }

    /* renamed from: bbD */
    public List<m> bbE() {
        Object declaredConstructors = this.ewM.getDeclaredConstructors();
        h.d(declaredConstructors, "klass.declaredConstructors");
        return m.f(m.f(m.b(i.E(declaredConstructors), ReflectJavaClass$constructors$1.eYs), ReflectJavaClass$constructors$2.eYt));
    }

    public f bdc() {
        f mD = f.mD(this.ewM.getSimpleName());
        h.d(mD, "Name.identifier(klass.simpleName)");
        return mD;
    }

    public List<x> getTypeParameters() {
        Object typeParameters = this.ewM.getTypeParameters();
        h.d(typeParameters, "klass.typeParameters");
        Collection arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable xVar : typeParameters) {
            arrayList.add(new x(xVar));
        }
        return (List) arrayList;
    }

    public boolean isInterface() {
        return this.ewM.isInterface();
    }

    public boolean bhr() {
        return this.ewM.isAnnotation();
    }

    public boolean isEnum() {
        return this.ewM.isEnum();
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && h.E(this.ewM, ((j) obj).ewM);
    }

    public int hashCode() {
        return this.ewM.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.ewM);
        return stringBuilder.toString();
    }
}
