package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* compiled from: ModuleMapping.kt */
public final class l {
    private static final String bf(String str, String str2) {
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(u.a(str, '.', '/', false, 4, null));
        stringBuilder.append("/");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
