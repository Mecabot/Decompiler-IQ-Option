package kotlin.collections;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, aXE = {"<anonymous>", "", "E", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"})
/* compiled from: AbstractCollection.kt */
final class AbstractCollection$toString$1 extends Lambda implements b<E, CharSequence> {
    final /* synthetic */ a this$0;

    AbstractCollection$toString$1(a aVar) {
        this.this$0 = aVar;
        super(1);
    }

    /* renamed from: cq */
    public final CharSequence invoke(E e) {
        return e == this.this$0 ? "(this Collection)" : String.valueOf(e);
    }
}
