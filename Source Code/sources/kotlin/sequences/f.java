package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"})
/* compiled from: Sequences.kt */
public final class f<T, R, E> implements h<E> {
    private final h<T> eYN;
    private final b<T, R> eYV;
    private final b<R, Iterator<E>> eYW;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004¨\u0006\u000e"}, aXE = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<E>, kotlin.jvm.internal.a.a {
        private final Iterator<T> RC;
        private Iterator<? extends E> eYX;
        final /* synthetic */ f eYY;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(f fVar) {
            this.eYY = fVar;
            this.RC = fVar.eYN.iterator();
        }

        public E next() {
            if (bAg()) {
                Iterator it = this.eYX;
                if (it == null) {
                    h.aXZ();
                }
                return it.next();
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return bAg();
        }

        private final boolean bAg() {
            Iterator it = this.eYX;
            if (!(it == null || it.hasNext())) {
                this.eYX = (Iterator) null;
            }
            while (this.eYX == null) {
                if (!this.RC.hasNext()) {
                    return false;
                }
                it = (Iterator) this.eYY.eYW.invoke(this.eYY.eYV.invoke(this.RC.next()));
                if (it.hasNext()) {
                    this.eYX = it;
                    return true;
                }
            }
            return true;
        }
    }

    public f(h<? extends T> hVar, b<? super T, ? extends R> bVar, b<? super R, ? extends Iterator<? extends E>> bVar2) {
        h.e(hVar, "sequence");
        h.e(bVar, "transformer");
        h.e(bVar2, "iterator");
        this.eYN = hVar;
        this.eYV = bVar;
        this.eYW = bVar2;
    }

    public Iterator<E> iterator() {
        return new a(this);
    }
}
