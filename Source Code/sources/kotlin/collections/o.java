package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0002¨\u0006\u0004"}, aXE = {"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"})
/* compiled from: IteratorsJVM.kt */
class o extends n {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, aXE = {"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    /* compiled from: IteratorsJVM.kt */
    public static final class a implements Iterator<T>, kotlin.jvm.internal.a.a {
        final /* synthetic */ Enumeration eug;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(Enumeration<T> enumeration) {
            this.eug = enumeration;
        }

        public boolean hasNext() {
            return this.eug.hasMoreElements();
        }

        public T next() {
            return this.eug.nextElement();
        }
    }

    public static final <T> Iterator<T> a(Enumeration<T> enumeration) {
        h.e(enumeration, "$receiver");
        return new a(enumeration);
    }
}
