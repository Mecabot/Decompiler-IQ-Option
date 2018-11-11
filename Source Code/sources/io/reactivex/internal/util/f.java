package io.reactivex.internal.util;

/* compiled from: Pow2 */
public final class f {
    public static int jk(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
