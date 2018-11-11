package kotlin.reflect.jvm.internal.structure;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Annotation;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.b;
import kotlin.reflect.jvm.internal.impl.name.f;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "(Lorg/jetbrains/kotlin/name/Name;)V", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "Factory", "descriptors.runtime"})
/* compiled from: ReflectJavaAnnotationArguments.kt */
public abstract class d implements b {
    public static final a eYp = new a();
    private final f eBW;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "value", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "descriptors.runtime"})
    /* compiled from: ReflectJavaAnnotationArguments.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final d a(Object obj, f fVar) {
            h.e(obj, FirebaseAnalytics.b.VALUE);
            if (b.P(obj.getClass())) {
                return new o(fVar, (Enum) obj);
            }
            if (obj instanceof Annotation) {
                return new e(fVar, (Annotation) obj);
            }
            if (obj instanceof Object[]) {
                return new h(fVar, (Object[]) obj);
            }
            if (obj instanceof Class) {
                return new k(fVar, (Class) obj);
            }
            return new q(fVar, obj);
        }
    }

    public d(f fVar) {
        this.eBW = fVar;
    }

    public f bdc() {
        return this.eBW;
    }
}
