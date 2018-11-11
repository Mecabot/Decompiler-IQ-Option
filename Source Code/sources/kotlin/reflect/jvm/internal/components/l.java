package kotlin.reflect.jvm.internal.components;

import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.aj;
import kotlin.reflect.jvm.internal.impl.load.java.a.b;
import kotlin.reflect.jvm.internal.structure.n;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, aXE = {"Lkotlin/reflect/jvm/internal/components/RuntimeSourceElementFactory;", "Lkotlin/reflect/jvm/internal/impl/load/java/sources/JavaSourceElementFactory;", "()V", "source", "Lkotlin/reflect/jvm/internal/impl/load/java/sources/JavaSourceElement;", "javaElement", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaElement;", "RuntimeSourceElement", "descriptors.runtime"})
/* compiled from: RuntimeSourceElementFactory.kt */
public final class l implements b {
    public static final l ewY = new l();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/components/RuntimeSourceElementFactory$RuntimeSourceElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/sources/JavaSourceElement;", "javaElement", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "(Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;)V", "getJavaElement", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "getContainingFile", "Lkotlin/reflect/jvm/internal/impl/descriptors/SourceFile;", "toString", "", "descriptors.runtime"})
    /* compiled from: RuntimeSourceElementFactory.kt */
    public static final class a implements kotlin.reflect.jvm.internal.impl.load.java.a.a {
        private final n ewZ;

        public a(n nVar) {
            h.e(nVar, "javaElement");
            this.ewZ = nVar;
        }

        /* renamed from: bav */
        public n baw() {
            return this.ewZ;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getName());
            stringBuilder.append(": ");
            stringBuilder.append(baw().toString());
            return stringBuilder.toString();
        }

        public aj ban() {
            aj ajVar = aj.eAY;
            h.d(ajVar, "SourceFile.NO_SOURCE_FILE");
            return ajVar;
        }
    }

    private l() {
    }

    public kotlin.reflect.jvm.internal.impl.load.java.a.a a(kotlin.reflect.jvm.internal.impl.load.java.structure.l lVar) {
        h.e(lVar, "javaElement");
        return new a((n) lVar);
    }
}
