package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: DescriptorRendererImpl.kt */
final class DescriptorRendererImpl$appendTypeProjections$1 extends Lambda implements b<ap, CharSequence> {
    final /* synthetic */ d this$0;

    DescriptorRendererImpl$appendTypeProjections$1(d dVar) {
        this.this$0 = dVar;
        super(1);
    }

    /* renamed from: b */
    public final CharSequence invoke(ap apVar) {
        h.e(apVar, "it");
        if (apVar.bze()) {
            return "*";
        }
        d dVar = this.this$0;
        w bai = apVar.bai();
        h.d(bai, "it.type");
        String b = dVar.b(bai);
        if (apVar.bzf() != Variance.INVARIANT) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(apVar.bzf());
            stringBuilder.append(' ');
            stringBuilder.append(b);
            b = stringBuilder.toString();
        }
        return b;
    }
}
