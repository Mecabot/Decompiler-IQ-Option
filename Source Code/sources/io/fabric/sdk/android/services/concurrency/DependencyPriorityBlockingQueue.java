package io.fabric.sdk.android.services.concurrency;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DependencyPriorityBlockingQueue<E extends a & i & f> extends PriorityBlockingQueue<E> {
    final Queue<E> blockedQueue = new LinkedList();
    private final ReentrantLock lock = new ReentrantLock();

    /* renamed from: aUX */
    public E take() {
        return b(0, null, null);
    }

    /* renamed from: aUY */
    public E peek() {
        try {
            return b(1, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    /* renamed from: d */
    public E poll(long j, TimeUnit timeUnit) {
        return b(3, Long.valueOf(j), timeUnit);
    }

    /* renamed from: aUZ */
    public E poll() {
        try {
            return b(2, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public int size() {
        try {
            this.lock.lock();
            int size = this.blockedQueue.size() + super.size();
            return size;
        } finally {
            this.lock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.lock.lock();
            tArr = a(super.toArray(tArr), this.blockedQueue.toArray(tArr));
            return tArr;
        } finally {
            this.lock.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.lock.lock();
            Object[] a = a(super.toArray(), this.blockedQueue.toArray());
            return a;
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        int drainTo;
        try {
            this.lock.lock();
            drainTo = super.drainTo(collection) + this.blockedQueue.size();
            while (!this.blockedQueue.isEmpty()) {
                collection.add(this.blockedQueue.poll());
            }
            return drainTo;
        } finally {
            drainTo = this.lock;
            drainTo.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.lock.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.blockedQueue.isEmpty() && drainTo <= i) {
                collection.add(this.blockedQueue.poll());
                drainTo++;
            }
            this.lock.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.lock.lock();
            boolean z = super.contains(obj) || this.blockedQueue.contains(obj);
            this.lock.unlock();
            return z;
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    public void clear() {
        try {
            this.lock.lock();
            this.blockedQueue.clear();
            super.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.lock.lock();
            boolean z = super.remove(obj) || this.blockedQueue.remove(obj);
            this.lock.unlock();
            return z;
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.lock.lock();
            boolean removeAll = this.blockedQueue.removeAll(collection) | super.removeAll(collection);
            return removeAll;
        } finally {
            this.lock.unlock();
        }
    }

    E a(int i, Long l, TimeUnit timeUnit) {
        E e;
        switch (i) {
            case 0:
                e = (a) super.take();
                break;
            case 1:
                e = (a) super.peek();
                break;
            case 2:
                e = (a) super.poll();
                break;
            case 3:
                e = (a) super.poll(l.longValue(), timeUnit);
                break;
            default:
                return null;
        }
        return e;
    }

    boolean a(int i, E e) {
        try {
            this.lock.lock();
            if (i == 1) {
                super.remove(e);
            }
            boolean offer = this.blockedQueue.offer(e);
            return offer;
        } finally {
            this.lock.unlock();
        }
    }

    E b(int i, Long l, TimeUnit timeUnit) {
        a a;
        while (true) {
            a = a(i, l, timeUnit);
            if (a == null || a(a)) {
                return a;
            }
            a(i, a);
        }
        return a;
    }

    boolean a(E e) {
        return e.aUW();
    }

    public void aVa() {
        try {
            this.lock.lock();
            Iterator it = this.blockedQueue.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (a(aVar)) {
                    super.offer(aVar);
                    it.remove();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    <T> T[] a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, objArr, 0, length);
        System.arraycopy(tArr2, 0, objArr, length, length2);
        return objArr;
    }
}
