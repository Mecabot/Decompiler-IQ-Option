package com.jumio.commons.utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public class RingBuffer<T extends Serializable> implements Serializable, Iterable<T> {
    private Object[] mArray;
    private int mElements = 0;
    private int mIndex = 0;
    private int mReadIndex = 0;

    private class RingBufferIterator implements Iterator<T> {
        private int mLocalIndex = 0;

        public boolean hasNext() {
            return true;
        }

        public T next() {
            Serializable serializable = (Serializable) RingBuffer.this.mArray[this.mLocalIndex];
            this.mLocalIndex++;
            if (RingBuffer.this.mIndex >= RingBuffer.this.mArray.length) {
                this.mLocalIndex = 0;
            }
            return serializable;
        }

        public void remove() {
            if (RingBuffer.this.isEmpty()) {
                throw new IllegalStateException("cannot call remove on an empty ringbuffer!");
            } else if (!RingBuffer.this.isEmpty()) {
                RingBuffer.this.mArray[this.mLocalIndex] = null;
                int i = this.mLocalIndex;
                while (i < RingBuffer.this.mArray.length - 1) {
                    int i2 = i + 1;
                    RingBuffer.this.mArray[i] = RingBuffer.this.mArray[i2];
                    i = i2;
                }
                RingBuffer.this.mElements = RingBuffer.this.mElements - 1;
            }
        }
    }

    private class StatefulRingBufferIterator implements Iterator<T> {
        public boolean hasNext() {
            return true;
        }

        private StatefulRingBufferIterator() {
        }

        public T next() {
            Serializable serializable = (Serializable) RingBuffer.this.mArray[RingBuffer.this.mReadIndex];
            RingBuffer.this.mReadIndex = RingBuffer.this.mReadIndex + 1;
            if (RingBuffer.this.mReadIndex >= RingBuffer.this.mArray.length) {
                RingBuffer.this.mReadIndex = 0;
            }
            return serializable;
        }

        public void remove() {
            throw new IllegalStateException("Removing not supported!");
        }
    }

    public RingBuffer(int i) {
        this.mArray = new Object[i];
        clear();
    }

    @SafeVarargs
    public static <T extends Serializable> RingBuffer<T> wrap(T... tArr) {
        RingBuffer<T> ringBuffer = new RingBuffer(tArr.length);
        for (Serializable add : tArr) {
            ringBuffer.add(add);
        }
        return ringBuffer;
    }

    public void add(T t) {
        this.mArray[this.mIndex] = t;
        this.mIndex++;
        if (this.mIndex >= this.mArray.length) {
            this.mIndex = 0;
        }
        if (this.mElements < this.mArray.length) {
            this.mElements++;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T current() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot call current() upon an empty RingBuffer!");
        } else if (this.mIndex == 0) {
            return (Serializable) this.mArray[this.mArray.length - 1];
        } else {
            return (Serializable) this.mArray[this.mIndex - 1];
        }
    }

    public Iterator<T> iterator() {
        return new RingBufferIterator();
    }

    public Iterator<T> statefulIterator() {
        return new StatefulRingBufferIterator();
    }

    public int size() {
        return this.mElements;
    }

    public void clear() {
        Arrays.fill(this.mArray, null);
        this.mElements = 0;
        this.mIndex = 0;
        this.mReadIndex = 0;
    }

    public void resetStatefulIterator() {
        this.mReadIndex = 0;
    }
}
