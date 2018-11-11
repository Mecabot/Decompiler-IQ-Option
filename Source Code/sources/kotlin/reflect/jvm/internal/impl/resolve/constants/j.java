package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.p;

/* compiled from: constantValues.kt */
public abstract class j extends f<l> {
    public static final a eRq = new a();

    /* compiled from: constantValues.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final j mQ(String str) {
            h.e(str, "message");
            return new b(str);
        }
    }

    /* compiled from: constantValues.kt */
    public static final class b extends j {
        private final String message;

        public b(String str) {
            h.e(str, "message");
            this.message = str;
        }

        /* renamed from: i */
        public ad h(u uVar) {
            h.e(uVar, "module");
            return p.mU(this.message);
        }

        public String toString() {
            return this.message;
        }
    }

    public j() {
        super(l.etX);
    }

    /* renamed from: bwG */
    public l getValue() {
        throw new UnsupportedOperationException();
    }
}
