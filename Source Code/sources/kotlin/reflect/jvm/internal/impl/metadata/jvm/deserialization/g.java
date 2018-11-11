package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.internal.h;

/* compiled from: JvmMetadataVersion.kt */
public final class g extends kotlin.reflect.jvm.internal.impl.metadata.a.a {
    public static final g eMH = new g(1, 1, 11);
    public static final g eMI = new g(new int[0]);
    public static final a eMJ = new a();

    /* compiled from: JvmMetadataVersion.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public g(int... iArr) {
        h.e(iArr, "numbers");
        super(Arrays.copyOf(iArr, iArr.length));
    }

    public boolean btC() {
        return getMajor() == 1 && getMinor() == 1;
    }
}
