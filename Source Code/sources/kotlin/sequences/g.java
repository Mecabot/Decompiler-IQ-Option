package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
/* compiled from: Sequences.kt */
final class g<T> implements h<T> {
    private final kotlin.jvm.a.a<T> eYZ;
    private final b<T, T> eZa;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, aXE = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, kotlin.jvm.internal.a.a {
        private int eYS = -2;
        private T eYT;
        final /* synthetic */ g eZb;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(g gVar) {
            this.eZb = gVar;
        }

        private final void bAf() {
            Object invoke;
            if (this.eYS == -2) {
                invoke = this.eZb.eYZ.invoke();
            } else {
                b b = this.eZb.eZa;
                Object obj = this.eYT;
                if (obj == null) {
                    h.aXZ();
                }
                invoke = b.invoke(obj);
            }
            this.eYT = invoke;
            this.eYS = this.eYT == null ? 0 : 1;
        }

        public T next() {
            if (this.eYS < 0) {
                bAf();
            }
            if (this.eYS == 0) {
                throw new NoSuchElementException();
            }
            T t = this.eYT;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.eYS = -1;
            return t;
        }

        public boolean hasNext() {
            if (this.eYS < 0) {
                bAf();
            }
            return this.eYS == 1;
        }
    }

    public g(kotlin.jvm.a.a<? extends T> aVar, b<? super T, ? extends T> bVar) {
        h.e(aVar, "getInitialValue");
        h.e(bVar, "getNextValue");
        this.eYZ = aVar;
        this.eZa = bVar;
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
