package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;

/* compiled from: capitalizeDecapitalize.kt */
final class CapitalizeDecapitalizeKt$decapitalizeSmart$1 extends Lambda implements b<Integer, Boolean> {
    final /* synthetic */ boolean $asciiOnly;
    final /* synthetic */ String receiver$0;

    CapitalizeDecapitalizeKt$decapitalizeSmart$1(String str, boolean z) {
        this.receiver$0 = str;
        this.$asciiOnly = z;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(mb(((Number) obj).intValue()));
    }

    public final boolean mb(int i) {
        char charAt = this.receiver$0.charAt(i);
        if (this.$asciiOnly) {
            return 'A' <= charAt && 'Z' >= charAt;
        } else {
            return Character.isUpperCase(charAt);
        }
    }
}
