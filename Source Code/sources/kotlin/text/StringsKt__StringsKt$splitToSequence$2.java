package kotlin.text;

import kotlin.f.f;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"})
/* compiled from: Strings.kt */
final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements b<f, String> {
    final /* synthetic */ CharSequence receiver$0;

    StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        this.receiver$0 = charSequence;
        super(1);
    }

    /* renamed from: a */
    public final String invoke(f fVar) {
        h.e(fVar, "it");
        return v.a(this.receiver$0, fVar);
    }
}
