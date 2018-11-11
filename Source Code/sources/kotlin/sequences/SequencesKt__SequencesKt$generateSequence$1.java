package kotlin.sequences;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
/* compiled from: Sequences.kt */
final class SequencesKt__SequencesKt$generateSequence$1 extends Lambda implements b<T, T> {
    final /* synthetic */ a $nextFunction;

    SequencesKt__SequencesKt$generateSequence$1(a aVar) {
        this.$nextFunction = aVar;
        super(1);
    }

    public final T invoke(T t) {
        h.e(t, "it");
        return this.$nextFunction.invoke();
    }
}
