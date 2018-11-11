package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.e;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: FunctionClassScope.kt */
public final class c extends e {
    public c(h hVar, FunctionClassDescriptor functionClassDescriptor) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(functionClassDescriptor, "containingClass");
        super(hVar, functionClassDescriptor);
    }

    protected List<r> bca() {
        d bxh = bxh();
        if (bxh == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        }
        switch (((FunctionClassDescriptor) bxh).bbT()) {
            case Function:
                return l.cr(e.ezN.a((FunctionClassDescriptor) bxh(), false));
            case SuspendFunction:
                return l.cr(e.ezN.a((FunctionClassDescriptor) bxh(), true));
            default:
                return m.emptyList();
        }
    }
}
