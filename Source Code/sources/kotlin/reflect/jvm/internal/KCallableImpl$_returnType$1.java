package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.w;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"})
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$_returnType$1 extends Lambda implements a<u> {
    final /* synthetic */ g this$0;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Ljava/lang/reflect/Type;", "R", "invoke"})
    /* compiled from: KCallableImpl.kt */
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1$1 */
    static final class AnonymousClass1 extends Lambda implements a<Type> {
        final /* synthetic */ KCallableImpl$_returnType$1 this$0;

        AnonymousClass1(KCallableImpl$_returnType$1 kCallableImpl$_returnType$1) {
            this.this$0 = kCallableImpl$_returnType$1;
            super(0);
        }

        /* renamed from: aYV */
        public final Type invoke() {
            return this.this$0.this$0.aYN().aYx();
        }
    }

    KCallableImpl$_returnType$1(g gVar) {
        this.this$0 = gVar;
        super(0);
    }

    /* renamed from: aYU */
    public final u invoke() {
        w bcQ = this.this$0.aYM().bcQ();
        if (bcQ == null) {
            h.aXZ();
        }
        h.d(bcQ, "descriptor.returnType!!");
        return new u(bcQ, new AnonymousClass1(this));
    }
}
