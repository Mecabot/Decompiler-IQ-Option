package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.k.a.a;
import kotlin.reflect.jvm.internal.impl.load.kotlin.u;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: predefinedEnhancementInfo.kt */
final class PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$22 extends Lambda implements b<a, l> {
    final /* synthetic */ String $JFBiConsumer$inlined;
    final /* synthetic */ String $JFBiFunction$inlined;
    final /* synthetic */ String $JFConsumer$inlined;
    final /* synthetic */ String $JFFunction$inlined;
    final /* synthetic */ String $JFPredicate$inlined;
    final /* synthetic */ String $JFUnaryOperator$inlined;
    final /* synthetic */ String $JLObject$inlined;
    final /* synthetic */ String $JUOptional$inlined;
    final /* synthetic */ String $JUStream$inlined;
    final /* synthetic */ u receiver$0$inlined;

    PredefinedEnhancementInfoKt$$special$$inlined$enhancement$lambda$22(u uVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.receiver$0$inlined = uVar;
        this.$JFConsumer$inlined = str;
        this.$JFPredicate$inlined = str2;
        this.$JUStream$inlined = str3;
        this.$JFUnaryOperator$inlined = str4;
        this.$JFBiConsumer$inlined = str5;
        this.$JLObject$inlined = str6;
        this.$JFBiFunction$inlined = str7;
        this.$JFFunction$inlined = str8;
        this.$JUOptional$inlined = str9;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return l.etX;
    }

    public final void a(a aVar) {
        h.e(aVar, "$receiver");
        aVar.a(this.$JLObject$inlined, g.eII);
        aVar.a(JvmPrimitiveType.BOOLEAN);
    }
}
