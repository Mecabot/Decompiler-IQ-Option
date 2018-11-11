package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: CapturedTypeConstructor.kt */
final class CapturedTypeConstructorKt$createCapturedIfNeeded$1 extends Lambda implements a<w> {
    final /* synthetic */ ap receiver$0;

    CapturedTypeConstructorKt$createCapturedIfNeeded$1(ap apVar) {
        this.receiver$0 = apVar;
        super(0);
    }

    /* renamed from: bhg */
    public final w invoke() {
        w bai = this.receiver$0.bai();
        h.d(bai, "this@createCapturedIfNeeded.type");
        return bai;
    }
}
