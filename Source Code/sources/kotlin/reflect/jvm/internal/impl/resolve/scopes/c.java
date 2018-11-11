package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* compiled from: MemberScope.kt */
public abstract class c {

    /* compiled from: MemberScope.kt */
    public static final class a extends c {
        private static final int eRB = (d.eSd.bxe() & ((d.eSd.bxc() | d.eSd.bxd()) ^ -1));
        public static final a eRC = new a();

        private a() {
        }

        public int bwM() {
            return eRB;
        }
    }

    /* compiled from: MemberScope.kt */
    public static final class b extends c {
        public static final b eRD = new b();

        public int bwM() {
            return 0;
        }

        private b() {
        }
    }

    public abstract int bwM();

    public String toString() {
        return getClass().getSimpleName();
    }
}
