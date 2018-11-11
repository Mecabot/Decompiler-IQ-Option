package kotlin.f;

import kotlin.jvm.internal.h;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u0002H\b2\u0006\u0010\n\u001a\u0002H\bH\u0002¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\r2\u0006\u0010\n\u001a\u00020\rH\u0002¨\u0006\u000e"}, aXE = {"checkStepIsPositive", "", "isPositive", "", "step", "", "rangeTo", "Lkotlin/ranges/ClosedRange;", "T", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "kotlin-stdlib"})
/* compiled from: Ranges.kt */
class i extends h {
    public static final void a(boolean z, Number number) {
        h.e(number, "step");
        if (!z) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Step must be positive, was: ");
            stringBuilder.append(number);
            stringBuilder.append('.');
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
