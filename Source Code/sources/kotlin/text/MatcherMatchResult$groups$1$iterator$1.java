package kotlin.text;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"})
/* compiled from: Regex.kt */
final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements b<Integer, f> {
    final /* synthetic */ j.b this$0;

    MatcherMatchResult$groups$1$iterator$1(j.b bVar) {
        this.this$0 = bVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return ml(((Number) obj).intValue());
    }

    public final f ml(int i) {
        return this.this$0.mk(i);
    }
}
