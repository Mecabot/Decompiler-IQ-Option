package kotlin.text;

import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lkotlin/Pair;", "", "", "startIndex", "invoke"})
/* compiled from: Strings.kt */
final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements m<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List $delimitersList;
    final /* synthetic */ boolean $ignoreCase;

    StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z) {
        this.$delimitersList = list;
        this.$ignoreCase = z;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        return m((CharSequence) obj, ((Number) obj2).intValue());
    }

    public final Pair<Integer, Integer> m(CharSequence charSequence, int i) {
        h.e(charSequence, "$receiver");
        Pair b = v.a(charSequence, (Collection) this.$delimitersList, i, this.$ignoreCase, false);
        return b != null ? j.D(b.getFirst(), Integer.valueOf(((String) b.aXF()).length())) : null;
    }
}
