package kotlin.sequences;

import java.util.Iterator;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"})
/* compiled from: Sequences.kt */
final class SequencesKt__SequencesKt$flatten$1 extends Lambda implements b<h<? extends T>, Iterator<? extends T>> {
    public static final SequencesKt__SequencesKt$flatten$1 eZc = new SequencesKt__SequencesKt$flatten$1();

    SequencesKt__SequencesKt$flatten$1() {
        super(1);
    }

    /* renamed from: c */
    public final Iterator<T> invoke(h<? extends T> hVar) {
        h.e(hVar, "it");
        return hVar.iterator();
    }
}
