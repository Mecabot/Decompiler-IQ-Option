package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k;

/* compiled from: ModuleVisibilityHelper.kt */
public interface g {

    /* compiled from: ModuleVisibilityHelper.kt */
    public static final class a implements g {
        public static final a eWj = new a();

        public boolean j(k kVar, k kVar2) {
            h.e(kVar, "what");
            h.e(kVar2, "from");
            return true;
        }

        private a() {
        }
    }

    boolean j(k kVar, k kVar2);
}
