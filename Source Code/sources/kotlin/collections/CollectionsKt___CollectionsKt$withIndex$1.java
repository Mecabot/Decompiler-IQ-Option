package kotlin.collections;

import java.util.Iterator;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "T", "invoke"})
/* compiled from: _Collections.kt */
final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements a<Iterator<? extends T>> {
    final /* synthetic */ Iterable receiver$0;

    CollectionsKt___CollectionsKt$withIndex$1(Iterable iterable) {
        this.receiver$0 = iterable;
        super(0);
    }

    /* renamed from: aXK */
    public final Iterator<T> invoke() {
        return this.receiver$0.iterator();
    }
}
