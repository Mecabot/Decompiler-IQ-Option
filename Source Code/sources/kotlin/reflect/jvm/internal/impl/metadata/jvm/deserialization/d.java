package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.internal.h;

/* compiled from: JvmBytecodeBinaryVersion.kt */
public final class d extends kotlin.reflect.jvm.internal.impl.metadata.a.a {
    public static final d eMC = new d(1, 0, 2);
    public static final d eMD = new d(new int[0]);
    public static final a eME = new a();

    /* compiled from: JvmBytecodeBinaryVersion.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public d(int... iArr) {
        h.e(iArr, "numbers");
        super(Arrays.copyOf(iArr, iArr.length));
    }
}
