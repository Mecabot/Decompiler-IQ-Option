package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* compiled from: SmartList */
public class h<E> extends AbstractList<E> implements RandomAccess {
    private int eXK;
    private Object eXL;

    /* compiled from: SmartList */
    private static class a<T> implements Iterator<T> {
        private static final a eXM = new a();

        public boolean hasNext() {
            return false;
        }

        private a() {
        }

        public static <T> a<T> bzF() {
            return eXM;
        }

        public T next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* compiled from: SmartList */
    private static abstract class c<T> implements Iterator<T> {
        private boolean eXP;

        protected abstract void bzG();

        protected abstract T getElement();

        private c() {
        }

        public final boolean hasNext() {
            return this.eXP ^ 1;
        }

        public final T next() {
            if (this.eXP) {
                throw new NoSuchElementException();
            }
            this.eXP = true;
            bzG();
            return getElement();
        }
    }

    /* compiled from: SmartList */
    private class b extends c<E> {
        private final int eXN;

        public b() {
            super();
            this.eXN = h.this.modCount;
        }

        protected E getElement() {
            return h.this.eXL;
        }

        protected void bzG() {
            if (h.this.modCount != this.eXN) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ModCount: ");
                stringBuilder.append(h.this.modCount);
                stringBuilder.append("; expected: ");
                stringBuilder.append(this.eXN);
                throw new ConcurrentModificationException(stringBuilder.toString());
            }
        }

        public void remove() {
            bzG();
            h.this.clear();
        }
    }

    public E get(int i) {
        if (i < 0 || i >= this.eXK) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index: ");
            stringBuilder.append(i);
            stringBuilder.append(", Size: ");
            stringBuilder.append(this.eXK);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (this.eXK == 1) {
            return this.eXL;
        } else {
            return ((Object[]) this.eXL)[i];
        }
    }

    public boolean add(E e) {
        if (this.eXK == 0) {
            this.eXL = e;
        } else if (this.eXK == 1) {
            this.eXL = new Object[]{this.eXL, e};
        } else {
            Object obj = (Object[]) this.eXL;
            int length = obj.length;
            if (this.eXK >= length) {
                int i = ((length * 3) / 2) + 1;
                int i2 = this.eXK + 1;
                if (i >= i2) {
                    i2 = i;
                }
                Object obj2 = new Object[i2];
                this.eXL = obj2;
                System.arraycopy(obj, 0, obj2, 0, length);
                obj = obj2;
            }
            obj[this.eXK] = e;
        }
        this.eXK++;
        this.modCount++;
        return true;
    }

    public void add(int i, E e) {
        if (i < 0 || i > this.eXK) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index: ");
            stringBuilder.append(i);
            stringBuilder.append(", Size: ");
            stringBuilder.append(this.eXK);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        if (this.eXK == 0) {
            this.eXL = e;
        } else if (this.eXK == 1 && i == 0) {
            this.eXL = new Object[]{e, this.eXL};
        } else {
            Object obj = new Object[(this.eXK + 1)];
            if (this.eXK == 1) {
                obj[0] = this.eXL;
            } else {
                Object[] objArr = (Object[]) this.eXL;
                System.arraycopy(objArr, 0, obj, 0, i);
                System.arraycopy(objArr, i, obj, i + 1, this.eXK - i);
            }
            obj[i] = e;
            this.eXL = obj;
        }
        this.eXK++;
        this.modCount++;
    }

    public int size() {
        return this.eXK;
    }

    public void clear() {
        this.eXL = null;
        this.eXK = 0;
        this.modCount++;
    }

    public E set(int i, E e) {
        if (i < 0 || i >= this.eXK) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index: ");
            stringBuilder.append(i);
            stringBuilder.append(", Size: ");
            stringBuilder.append(this.eXK);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (this.eXK == 1) {
            E e2 = this.eXL;
            this.eXL = e;
            return e2;
        } else {
            Object[] objArr = (Object[]) this.eXL;
            E e3 = objArr[i];
            objArr[i] = e;
            return e3;
        }
    }

    public E remove(int i) {
        if (i < 0 || i >= this.eXK) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index: ");
            stringBuilder.append(i);
            stringBuilder.append(", Size: ");
            stringBuilder.append(this.eXK);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        E e;
        if (this.eXK == 1) {
            e = this.eXL;
            this.eXL = null;
        } else {
            Object[] objArr = (Object[]) this.eXL;
            E e2 = objArr[i];
            if (this.eXK == 2) {
                this.eXL = objArr[1 - i];
            } else {
                int i2 = (this.eXK - i) - 1;
                if (i2 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i2);
                }
                objArr[this.eXK - 1] = null;
            }
            e = e2;
        }
        this.eXK--;
        this.modCount++;
        return e;
    }

    public Iterator<E> iterator() {
        if (this.eXK == 0) {
            return a.bzF();
        }
        if (this.eXK == 1) {
            return new b();
        }
        return super.iterator();
    }

    public <T> T[] toArray(T[] tArr) {
        int length = tArr.length;
        if (this.eXK == 1) {
            if (length != 0) {
                tArr[0] = this.eXL;
            } else {
                Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
                objArr[0] = this.eXL;
                return objArr;
            }
        } else if (length < this.eXK) {
            return Arrays.copyOf((Object[]) this.eXL, this.eXK, tArr.getClass());
        } else {
            if (this.eXK != 0) {
                System.arraycopy(this.eXL, 0, tArr, 0, this.eXK);
            }
        }
        if (length > this.eXK) {
            tArr[this.eXK] = null;
        }
        return tArr;
    }
}
