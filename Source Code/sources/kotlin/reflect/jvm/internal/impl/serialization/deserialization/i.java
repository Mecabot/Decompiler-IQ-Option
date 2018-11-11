package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* compiled from: DeserializationConfiguration.kt */
public interface i {

    /* compiled from: DeserializationConfiguration.kt */
    public static final class b {
        public static boolean a(i iVar) {
            return false;
        }

        public static boolean b(i iVar) {
            return false;
        }

        public static boolean c(i iVar) {
            return true;
        }

        public static boolean d(i iVar) {
            return true;
        }

        public static boolean e(i iVar) {
            return false;
        }
    }

    /* compiled from: DeserializationConfiguration.kt */
    public static final class a implements i {
        public static final a eSX = new a();

        private a() {
        }

        public boolean bir() {
            return b.a(this);
        }

        public boolean bxE() {
            return b.b(this);
        }

        public boolean bxF() {
            return b.c(this);
        }

        public boolean bxG() {
            return b.d(this);
        }

        public boolean bxH() {
            return b.e(this);
        }
    }

    boolean bir();

    boolean bxE();

    boolean bxF();

    boolean bxG();

    boolean bxH();
}
