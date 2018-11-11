package kotlin.reflect.jvm.internal.components;

import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.g;
import kotlin.reflect.jvm.internal.impl.load.java.structure.t;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.structure.j;
import kotlin.reflect.jvm.internal.structure.u;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lkotlin/reflect/jvm/internal/components/ReflectJavaClassFinder;", "Lkotlin/reflect/jvm/internal/impl/load/java/JavaClassFinder;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "findClass", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "findPackage", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPackage;", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "knownClassNamesInPackage", "", "", "packageFqName", "descriptors.runtime"})
/* compiled from: ReflectJavaClassFinder.kt */
public final class c implements g {
    private final ClassLoader classLoader;

    public Set<String> b(b bVar) {
        h.e(bVar, "packageFqName");
        return null;
    }

    public c(ClassLoader classLoader) {
        h.e(classLoader, "classLoader");
        this.classLoader = classLoader;
    }

    public kotlin.reflect.jvm.internal.impl.load.java.structure.g a(a aVar) {
        h.e(aVar, "classId");
        b packageFqName = aVar.getPackageFqName();
        String asString = aVar.btG().asString();
        h.d(asString, "classId.relativeClassName.asString()");
        String a = u.a(asString, '.', '$', false, 4, null);
        h.d(packageFqName, "packageFqName");
        if (!packageFqName.isRoot()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(packageFqName.asString());
            stringBuilder.append(".");
            stringBuilder.append(a);
            a = stringBuilder.toString();
        }
        Class a2 = d.a(this.classLoader, a);
        return a2 != null ? new j(a2) : null;
    }

    public t a(b bVar) {
        h.e(bVar, "fqName");
        return new u(bVar);
    }
}
