package com.google.common.collect;

import com.google.common.base.i;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> extends aj<T> {
    private T LP;
    private State Pq = State.NOT_READY;

    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T pr();

    protected AbstractIterator() {
    }

    protected final T ps() {
        this.Pq = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        i.checkState(this.Pq != State.FAILED);
        switch (this.Pq) {
            case DONE:
                return false;
            case READY:
                return true;
            default:
                return pt();
        }
    }

    private boolean pt() {
        this.Pq = State.FAILED;
        this.LP = pr();
        if (this.Pq == State.DONE) {
            return false;
        }
        this.Pq = State.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.Pq = State.NOT_READY;
            T t = this.LP;
            this.LP = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
