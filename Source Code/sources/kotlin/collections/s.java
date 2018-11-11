package kotlin.collections;

import java.util.List;
import kotlin.f.f;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, aXE = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"})
/* compiled from: ReversedViews.kt */
class s extends r {
    private static final int d(List<?> list, int i) {
        int bQ = m.bQ(list);
        if (i >= 0 && bQ >= i) {
            return m.bQ(list) - i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Element index ");
        stringBuilder.append(i);
        stringBuilder.append(" must be in range [");
        stringBuilder.append(new f(0, m.bQ(list)));
        stringBuilder.append("].");
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    private static final int e(List<?> list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position index ");
        stringBuilder.append(i);
        stringBuilder.append(" must be in range [");
        stringBuilder.append(new f(0, list.size()));
        stringBuilder.append("].");
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public static final <T> List<T> bS(List<? extends T> list) {
        h.e(list, "$receiver");
        return new ag(list);
    }

    public static final <T> List<T> bT(List<T> list) {
        h.e(list, "$receiver");
        return new af(list);
    }
}
