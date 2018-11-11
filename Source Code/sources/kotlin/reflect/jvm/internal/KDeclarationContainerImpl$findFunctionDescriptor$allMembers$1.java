package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.r;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
/* compiled from: KDeclarationContainerImpl.kt */
final class KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1 extends Lambda implements b<r, String> {
    public static final KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1 evS = new KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1();

    KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(r rVar) {
        h.e(rVar, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(kotlin.reflect.jvm.internal.impl.renderer.b.ePf.s(rVar));
        stringBuilder.append(" | ");
        stringBuilder.append(ac.ewF.d(rVar));
        return stringBuilder.toString();
    }
}
