package kotlin.collections;

import java.util.Iterator;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "T", "invoke"})
/* compiled from: _Arrays.kt */
final class ArraysKt___ArraysKt$withIndex$1 extends Lambda implements a<Iterator<? extends T>> {
    final /* synthetic */ Object[] receiver$0;

    ArraysKt___ArraysKt$withIndex$1(Object[] objArr) {
        this.receiver$0 = objArr;
        super(0);
    }

    /* renamed from: aXK */
    public final Iterator<T> invoke() {
        return b.K(this.receiver$0);
    }
}
