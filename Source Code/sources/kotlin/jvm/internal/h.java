package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Intrinsics */
public class h {
    public static int compare(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    private h() {
    }

    public static String p(String str, Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(obj);
        return stringBuilder.toString();
    }

    public static void cv(Object obj) {
        if (obj == null) {
            aXZ();
        }
    }

    public static void aXZ() {
        throw ((KotlinNullPointerException) ad(new KotlinNullPointerException()));
    }

    public static void lR(String str) {
        throw ((UninitializedPropertyAccessException) ad(new UninitializedPropertyAccessException(str)));
    }

    public static void lS(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lateinit property ");
        stringBuilder.append(str);
        stringBuilder.append(" has not been initialized");
        lR(stringBuilder.toString());
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" must not be null");
            throw ((IllegalStateException) ad(new IllegalStateException(stringBuilder.toString())));
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            lT(str);
        }
    }

    private static void lT(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameter specified as non-null is null: method ");
        stringBuilder.append(className);
        stringBuilder.append(".");
        stringBuilder.append(methodName);
        stringBuilder.append(", parameter ");
        stringBuilder.append(str);
        throw ((IllegalArgumentException) ad(new IllegalArgumentException(stringBuilder.toString())));
    }

    public static boolean E(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    public static boolean j(Double d, Double d2) {
        if (d == null) {
            if (d2 != null) {
                return false;
            }
        } else if (d2 == null || d.doubleValue() != d2.doubleValue()) {
            return false;
        }
        return true;
    }

    public static boolean a(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    private static <T extends Throwable> T ad(T t) {
        return b(t, h.class.getName());
    }

    static <T extends Throwable> T b(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}
