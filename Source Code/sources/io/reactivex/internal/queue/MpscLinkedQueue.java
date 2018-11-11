package io.reactivex.internal.queue;

import io.reactivex.internal.b.h;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T> implements h<T> {
    private final AtomicReference<LinkedQueueNode<T>> erH = new AtomicReference();
    private final AtomicReference<LinkedQueueNode<T>> erI = new AtomicReference();

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E e) {
            ci(e);
        }

        public E aWT() {
            E aWU = aWU();
            ci(null);
            return aWU;
        }

        public E aWU() {
            return this.value;
        }

        public void ci(E e) {
            this.value = e;
        }

        public void c(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public LinkedQueueNode<E> aWV() {
            return (LinkedQueueNode) get();
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        b(linkedQueueNode);
        a(linkedQueueNode);
    }

    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t);
        a(linkedQueueNode).c(linkedQueueNode);
        return true;
    }

    public T poll() {
        LinkedQueueNode aWS = aWS();
        LinkedQueueNode aWV = aWS.aWV();
        T aWT;
        if (aWV != null) {
            aWT = aWV.aWT();
            b(aWV);
            return aWT;
        } else if (aWS == aWQ()) {
            return null;
        } else {
            while (true) {
                aWV = aWS.aWV();
                if (aWV != null) {
                    aWT = aWV.aWT();
                    b(aWV);
                    return aWT;
                }
            }
        }
    }

    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    LinkedQueueNode<T> aWQ() {
        return (LinkedQueueNode) this.erH.get();
    }

    LinkedQueueNode<T> a(LinkedQueueNode<T> linkedQueueNode) {
        return (LinkedQueueNode) this.erH.getAndSet(linkedQueueNode);
    }

    LinkedQueueNode<T> aWR() {
        return (LinkedQueueNode) this.erI.get();
    }

    LinkedQueueNode<T> aWS() {
        return (LinkedQueueNode) this.erI.get();
    }

    void b(LinkedQueueNode<T> linkedQueueNode) {
        this.erI.lazySet(linkedQueueNode);
    }

    public boolean isEmpty() {
        return aWR() == aWQ();
    }
}
