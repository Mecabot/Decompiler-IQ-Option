package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.h;

/* compiled from: InvalidModuleException.kt */
public final class InvalidModuleException extends IllegalStateException {
    public InvalidModuleException(String str) {
        h.e(str, "message");
        super(str);
    }
}
