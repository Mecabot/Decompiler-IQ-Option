package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: JvmAnnotationNames */
public final class m {
    public static final b eFk = new b("kotlin.Metadata");
    public static final String eFl;
    public static final f eFm = f.mD(FirebaseAnalytics.b.VALUE);
    public static final b eFn = new b("org.jetbrains.annotations.NotNull");
    public static final b eFo = new b("org.jetbrains.annotations.Nullable");
    public static final b eFp = new b("org.jetbrains.annotations.Mutable");
    public static final b eFq = new b("org.jetbrains.annotations.ReadOnly");
    public static final b eFr = new b("kotlin.annotations.jvm.ReadOnly");
    public static final b eFs = new b("kotlin.annotations.jvm.Mutable");
    public static final b eFt = new b("kotlin.jvm.PurelyImplements");
    public static final b eFu = new b("kotlin.jvm.internal.EnhancedNullability");
    public static final b eFv = new b("kotlin.jvm.internal.EnhancedMutability");
    public static final b eFw = new b("kotlin.annotations.jvm.internal.ParameterName");
    public static final b eFx = new b("kotlin.annotations.jvm.internal.DefaultValue");
    public static final b eFy = new b("kotlin.annotations.jvm.internal.DefaultNull");

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("L");
        stringBuilder.append(kotlin.reflect.jvm.internal.impl.resolve.jvm.b.u(eFk).getInternalName());
        stringBuilder.append(";");
        eFl = stringBuilder.toString();
    }
}
