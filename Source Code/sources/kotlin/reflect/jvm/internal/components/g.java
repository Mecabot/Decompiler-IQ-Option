package kotlin.reflect.jvm.internal.components;

import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, aXE = {"toRuntimeFqName", "", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "descriptors.runtime"})
/* compiled from: ReflectKotlinClassFinder.kt */
public final class g {
    private static final String c(a aVar) {
        String asString = aVar.btG().asString();
        h.d(asString, "relativeClassName.asString()");
        String a = u.a(asString, '.', '$', false, 4, null);
        b packageFqName = aVar.getPackageFqName();
        h.d(packageFqName, "packageFqName");
        if (packageFqName.isRoot()) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aVar.getPackageFqName());
        stringBuilder.append('.');
        stringBuilder.append(a);
        return stringBuilder.toString();
    }
}
