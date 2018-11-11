package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: JvmAnnotationNames.kt */
public final class n {
    private static final b eFA = new b("javax.annotation.Nonnull");
    private static final b eFB = new b("javax.annotation.CheckForNull");
    private static final List<b> eFC = m.listOf(m.eFn, new b("edu.umd.cs.findbugs.annotations.NonNull"), new b("androidx.annotation.NonNull"), new b("android.support.annotation.NonNull"), new b("com.android.annotations.NonNull"), new b("org.eclipse.jdt.annotation.NonNull"), new b("org.checkerframework.checker.nullness.qual.NonNull"), new b("lombok.NonNull"), new b("io.reactivex.annotations.NonNull"));
    private static final b eFD = new b("org.checkerframework.checker.nullness.compatqual.NullableDecl");
    private static final b eFE = new b("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
    private static final b eFF = new b("androidx.annotation.RecentlyNullable");
    private static final b eFG = new b("androidx.annotation.RecentlyNonNull");
    private static final Set<b> eFH = ak.e(ak.e(ak.e(ak.e(ak.a(ak.e(ak.a(new LinkedHashSet(), eFz), eFA), eFC), eFD), eFE), eFF), eFG);
    private static final List<b> eFI = m.listOf(m.eFq, m.eFr);
    private static final List<b> eFJ = m.listOf(m.eFp, m.eFs);
    private static final List<b> eFz = m.listOf(m.eFo, new b("androidx.annotation.Nullable"), new b("android.support.annotation.Nullable"), new b("com.android.annotations.Nullable"), new b("org.eclipse.jdt.annotation.Nullable"), new b("org.checkerframework.checker.nullness.qual.Nullable"), new b("javax.annotation.Nullable"), new b("javax.annotation.CheckForNull"), new b("edu.umd.cs.findbugs.annotations.CheckForNull"), new b("edu.umd.cs.findbugs.annotations.Nullable"), new b("edu.umd.cs.findbugs.annotations.PossiblyNull"), new b("io.reactivex.annotations.Nullable"));

    public static final List<b> bfD() {
        return eFz;
    }

    public static final b bfE() {
        return eFA;
    }

    public static final b bfF() {
        return eFB;
    }

    public static final List<b> bfG() {
        return eFC;
    }

    public static final b bfH() {
        return eFD;
    }

    public static final b bfI() {
        return eFE;
    }

    public static final b bfJ() {
        return eFF;
    }

    public static final b bfK() {
        return eFG;
    }

    public static final List<b> bfL() {
        return eFI;
    }

    public static final List<b> bfM() {
        return eFJ;
    }
}
