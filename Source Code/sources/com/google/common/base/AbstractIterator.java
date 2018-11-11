package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class AbstractIterator<T> implements Iterator<T> {
    private State LO = State.NOT_READY;
    private T LP;

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
        this.LO = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        i.checkState(this.LO != State.FAILED);
        switch (this.LO) {
            case READY:
                return true;
            case DONE:
                return false;
            default:
                return pt();
        }
    }

    private boolean pt() {
        this.LO = State.FAILED;
        this.LP = pr();
        if (this.LO == State.DONE) {
            return false;
        }
        this.LO = State.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.LO = State.NOT_READY;
            T t = this.LP;
            this.LP = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
