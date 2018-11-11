package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.components.e;
import kotlin.reflect.jvm.internal.components.j;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.name.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PackageViewDescriptor;", "invoke"})
/* compiled from: KPackageImpl.kt */
final class KPackageImpl$Data$descriptor$2 extends Lambda implements a<z> {
    final /* synthetic */ a this$0;

    KPackageImpl$Data$descriptor$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aZH */
    public final z invoke() {
        j aZo = this.this$0.aZo();
        e a = this.this$0.aZE();
        if (a != null) {
            String a2 = ae.a(a);
            if (a2 != null) {
                aZo.bat().lY(a2);
            }
        }
        u bar = aZo.bar();
        b packageFqName = kotlin.reflect.jvm.internal.structure.b.S(n.this.aXV()).getPackageFqName();
        h.d(packageFqName, "jClass.classId.packageFqName");
        return bar.g(packageFqName);
    }
}
