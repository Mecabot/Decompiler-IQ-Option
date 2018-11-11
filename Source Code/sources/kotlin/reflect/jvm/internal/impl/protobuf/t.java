package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: UnmodifiableLazyStringList */
public class t extends AbstractList<String> implements RandomAccess, l {
    private final l eOS;

    public l bvi() {
        return this;
    }

    public t(l lVar) {
        this.eOS = lVar;
    }

    public String get(int i) {
        return (String) this.eOS.get(i);
    }

    public int size() {
        return this.eOS.size();
    }

    public d lJ(int i) {
        return this.eOS.lJ(i);
    }

    public void f(d dVar) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<String> listIterator(final int i) {
        return new ListIterator<String>() {
            ListIterator<String> eOT = t.this.eOS.listIterator(i);

            public boolean hasNext() {
                return this.eOT.hasNext();
            }

            public String next() {
                return (String) this.eOT.next();
            }

            public boolean hasPrevious() {
                return this.eOT.hasPrevious();
            }

            /* renamed from: bvx */
            public String previous() {
                return (String) this.eOT.previous();
            }

            public int nextIndex() {
                return this.eOT.nextIndex();
            }

            public int previousIndex() {
                return this.eOT.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void set(String str) {
                throw new UnsupportedOperationException();
            }

            public void add(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Iterator<String> iter = t.this.eOS.iterator();

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public String next() {
                return (String) this.iter.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public List<?> bvh() {
        return this.eOS.bvh();
    }
}
