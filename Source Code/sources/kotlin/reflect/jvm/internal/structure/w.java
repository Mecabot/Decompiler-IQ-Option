package kotlin.reflect.jvm.internal.structure;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.v;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaType;", "()V", "reflectType", "Ljava/lang/reflect/Type;", "getReflectType", "()Ljava/lang/reflect/Type;", "equals", "", "other", "", "hashCode", "", "toString", "", "Factory", "descriptors.runtime"})
/* compiled from: ReflectJavaType.kt */
public abstract class w implements v {
    public static final a eYF = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaType$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "type", "Ljava/lang/reflect/Type;", "descriptors.runtime"})
    /* compiled from: ReflectJavaType.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final w q(Type type) {
            h.e(type, Param.TYPE);
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new v(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
                return new i(type);
            }
            if (type instanceof WildcardType) {
                return new z((WildcardType) type);
            }
            return new l(type);
        }
    }

    protected abstract Type bzR();

    public boolean equals(Object obj) {
        return (obj instanceof w) && h.E(bzR(), ((w) obj).bzR());
    }

    public int hashCode() {
        return bzR().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(bzR());
        return stringBuilder.toString();
    }
}
