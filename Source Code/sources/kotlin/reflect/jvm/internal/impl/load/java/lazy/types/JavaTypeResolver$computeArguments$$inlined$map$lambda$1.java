package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolver$computeArguments$$inlined$map$lambda$1 extends Lambda implements a<w> {
    final /* synthetic */ a $attr$inlined;
    final /* synthetic */ an $constructor$inlined;
    final /* synthetic */ boolean $isRaw$inlined;
    final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.an $parameter;
    final /* synthetic */ b this$0;

    /* compiled from: JavaTypeResolver.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$$inlined$map$lambda$1$1 */
    static final class AnonymousClass1 extends Lambda implements a<w> {
        final /* synthetic */ JavaTypeResolver$computeArguments$$inlined$map$lambda$1 this$0;

        AnonymousClass1(JavaTypeResolver$computeArguments$$inlined$map$lambda$1 javaTypeResolver$computeArguments$$inlined$map$lambda$1) {
            this.this$0 = javaTypeResolver$computeArguments$$inlined$map$lambda$1;
            super(0);
        }

        /* renamed from: bhg */
        public final w invoke() {
            f bbW = this.this$0.$constructor$inlined.bbW();
            if (bbW == null) {
                h.aXZ();
            }
            h.d(bbW, "constructor.declarationDescriptor!!");
            ad bdb = bbW.bdb();
            h.d(bdb, "constructor.declarationDescriptor!!.defaultType");
            return kotlin.reflect.jvm.internal.impl.types.b.a.bl(bdb);
        }
    }

    JavaTypeResolver$computeArguments$$inlined$map$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.an anVar, b bVar, a aVar, an anVar2, boolean z) {
        this.$parameter = anVar;
        this.this$0 = bVar;
        this.$attr$inlined = aVar;
        this.$constructor$inlined = anVar2;
        this.$isRaw$inlined = z;
        super(0);
    }

    /* renamed from: bhg */
    public final w invoke() {
        kotlin.reflect.jvm.internal.impl.descriptors.an anVar = this.$parameter;
        h.d(anVar, "parameter");
        return c.a(anVar, this.$attr$inlined.bhf(), (a) new AnonymousClass1(this));
    }
}
